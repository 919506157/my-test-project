package com.zhang.im;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;

public class SignUpTest {

    public static void main(String[] args) {
        String httpUrl = "https://console.tim.qq.com/";
        String ver = "v4";
        String servicename = "im_open_login_svc";
        String command = "account_import";
        String sdkappid = "1400367050";
        String identifier = "admin";
        String usersig = GenerateTestUserSig.genTestUserSig("admin");


        String random = "4294967000";
        String contenttype = "json";

        System.out.println(usersig);
//https://console.tim.qq.com/$ver/$servicename/$command?sdkappid=$SDKAppID&identifier=$identifier&usersig=$usersig&random=99999999&contenttype=json
        StringBuffer sb = new StringBuffer();
        sb.append(httpUrl)
                .append(ver).append("/")
                .append(servicename).append("/")
                .append(command).append("?")
                .append("sdkappid").append("=").append(sdkappid).append("&")
                .append("identifier").append("=").append(identifier).append("&")
                .append("usersig").append("=").append(usersig).append("&")
                .append("random").append("=").append(random).append("&")
                .append("contenttype").append("=").append(contenttype)
        ;

        System.out.println(sb.toString());
        //HttpClientUtils.poolHttpsPost();

    }


}
