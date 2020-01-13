package com.zhang.utils;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;


public class SocketClientUtil {

    private String serverIp;

    private int serverPort;

    public SocketClientUtil(String serverIp, int serverPort) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public String execute(Map<String, String> map) throws Exception {
        String respXml = "";
        // 1.建立客户端socket连接，指定服务器位置及端口
        Socket socket = null;
        // 2.得到socket读写流
        OutputStream os = null;
        PrintWriter pw = null;
        // 输入流
        InputStream is = null;
        BufferedReader br = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(serverIp, serverPort), 10000);// 连接超时设置
            socket.setSoTimeout(10000); // 读写超时设置
            os = socket.getOutputStream();
            pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            // 3.对socket进行读写操作
            String info = jsonObject(map);
            pw.write(info);
            pw.flush();
            socket.shutdownOutput();
            // 接收服务器的响应
            String reply = null;
            while (!((reply = br.readLine()) == null)) {
                respXml += reply;
            }
            socket.shutdownInput();
        } catch (Exception e) {
            System.out.println("异常");
        } finally {
            try {
                // 4.关闭资源
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
                if (pw != null) {
                    pw.close();
                }
                if (os != null) {
                    os.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e2) {
            }
        }
        return respXml;
    }

    private static String jsonObject(Object obj) {

        String json = "";
        try {
            json = JSON.toJSONString(obj);
            return json;
        } catch (Exception e) {
            json = "{\"err\":\"" + "JsonObject is wrong" + "\"}";
            return json;
        }
    }

}
