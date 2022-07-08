package com.zhang.im;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpClientUtils {

    private static Log log = LogFactory.getLog(HttpClientUtils.class);

    private static final String CHAR_SET = "UTF-8";

    // 最大连接数200
    private static int MAX_CONNECTION_NUM = 200;

    // 单路由最大连接数80
    private static int MAX_PER_ROUTE = 20;

    // 向服务端请求超时时间设置(单位:毫秒)
    private static int SERVER_REQUEST_TIME_OUT = 3000;

    // 服务端响应超时时间设置(单位:毫秒)
    private static int SERVER_RESPONSE_TIME_OUT = 20000;

    // 连接池管理对象
    private static PoolingHttpClientConnectionManager cm = null;

    private HttpClientUtils() {
    }

    public static CloseableHttpClient getHttpsClient(RequestConfig config) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).setConnectionManager(cm).build();
        return httpClient;
    }

    static {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());

            LayeredConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sc, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                    .<ConnectionSocketFactory>create().register("https", sslsf)
                    .register("http", new PlainConnectionSocketFactory()).build();

            cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            cm.setMaxTotal(MAX_CONNECTION_NUM);
            cm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        } catch (Exception e) {
            log.error("初始化连接池失败!", e);
        }
    }

    /**
     * Https post请求
     *
     * @param url   请求地址
     * @param xml   请求参数(如果为null,则表示不请求参数) return 返回结果
     * @param msgTp 报文头参数设置
     * @throws Exception
     */
    public static String poolHttpsPost(String url, String json) throws Exception {
        CloseableHttpResponse response = null;
        HttpPost post = null;
        try {
            log.info("请求接口地址:" + url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(600000).setConnectTimeout(600000).build();

            post = new HttpPost(url);
            post.setHeader("Connection", "keep-alive");
            post.setHeader("Content-Type", "application/xml;charset=utf-8");
            post.setConfig(requestConfig);

            if (null != json) {
                StringEntity se = new StringEntity(json, CHAR_SET);
                post.setEntity(se);
            }

            response = getHttpsClient(requestConfig).execute(post);
            int status = response.getStatusLine().getStatusCode();
            log.info("请求接口响应码:" + status);
            String result = null;
            if (status == 200) {
                result = EntityUtils.toString(response.getEntity(), CHAR_SET);
            }
            return result;
        } catch (Exception e) {
        } finally {
            post.releaseConnection();
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException e) {
                    log.error("response关闭失败", e);
                }
            }
        }
        return null;
    }


    /**
     * Https post请求
     *
     * @param url 请求地址
     * @param xml 请求参数(如果为null,则表示不请求参数) return 返回结果
     * @throws Exception
     */
    public static String jsonHttpPost(String url, String xml) throws Exception {
        log.info("请求URL:" + url);
        CloseableHttpResponse response = null;
        HttpPost post = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SERVER_RESPONSE_TIME_OUT)
                    .setConnectTimeout(SERVER_REQUEST_TIME_OUT).build();
            post = new HttpPost(url);
            post.setConfig(requestConfig);
            if (null != xml) {
                StringEntity se = new StringEntity(xml, CHAR_SET);
                se.setContentType("application/json");
                post.setEntity(se);
            }
            response = getHttpsClient(requestConfig).execute(post);
            int status = response.getStatusLine().getStatusCode();
            String result = null;
            if (status == 200) {
                result = EntityUtils.toString(response.getEntity(), CHAR_SET);
            }
            log.info("响应状态:" + status + "响应结果:" + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求异常!");
            throw e;
        } finally {
            post.releaseConnection();
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

}


	