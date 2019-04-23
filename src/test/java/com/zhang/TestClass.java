package com.zhang;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;


public class TestClass {


    public static int test(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a + b;
    }

    @Test
    public void Test1() {
        Object o = new Object();
        System.out.println(o.hashCode());
        StringBuffer sb = new StringBuffer();
        switch (1) {
            case 1:
                sb.append("Hello a");
            case 2:
                sb.append("b");
            case 3:
                sb.append("c");
            default:
                sb.append("d");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void Test2() {
        int j = 0;
        //for (int i = 0; i < 100; i++)
        j = j++;
        System.out.println(j);
    }

    @Test
    public void Test3() {
        StringBuffer sb = new StringBuffer();
        sb.append("123456789");
        System.out.println(sb.length());
        System.out.println(sb.substring(0, sb.length()));
    }

    @Test
    public void Test4() throws Exception {
        String a = "payerInfo=HLM1H0uPo9g64Ss5JRDRBme7E3Ov8TWC1XJTyyVzlN7abGRvZTQ8wFMtEU7aBZl6eryKg+puqf6f7GNQI2R/4oB0HucwOmkGhAgTL2tCH8eqU6zzWcvKWf6bLVvGFgOH5xG7WPX3rFIzyPuAUQ0o3mCONjgOOpIsceaFCkFkEHM/AdHrn8c1pL3oAaFMl/kFObE6hbzJHBu9v8XYLWiBXGC0xbTKWRSsmKdl6+ne0Byf8HD0IOtHk2LDk2S/MFuvzln7ezqkBQqc2B6+DXb4+fLg5AxRrtn7gvzcOxYvB1rZCaDFDEpjw5DLfVVHeGovOWJa3zZ/qmEfzET+nV9c6g==";
        System.out.println(a.indexOf("="));
        a.substring(0, a.indexOf("="));
        System.out.println(a.substring(0, a.indexOf("=")));
        System.out.println(a.substring(a.indexOf("=") + 1));
    }

    @Test
    public void Test5() throws Exception {
        String a = "{channelType=07, subMerAbbr=曲普贸易, acqInsCode=48762900, txnSubType=01, version=5.1.0, txnAmt=31060, signMethod=01, backUrl=http://double.unspay.com/unionpaywg-internetbank-gateway/response/payResponseNotice, merAbbr=曲普贸易, encoding=UTF-8, merCatCode=5065, subMerId=876290050651914, signature=QGFx+kMATR66PQ7VDsKP4f9pg5Cg19yi4HN5sZShVqRgYQY/e3pli/JwGQxzIiRc7mgAx9hu0sUAoJrksYF/3tI/nUmQwBk4v+YYtQntTxds3/w4FyjpnQunZyKOH+RrKcfoYFWDVUSbZ6qr02w2Q8zXnnCOqsjV5jEt/Zr4sB3Qc5KZCm6h3DJN30zAapgAnftsfKyGFAprCxGIkcvimzuTOwQpcdnu3PHqsYURWZJh2zPbQgpZPp6rxHzInOD5vdpeYp029VuR00XDZv6+wG+rTZs9C8xxPMEffWj2cKc5ArE2I7+ppN7Q9AZsY82hJge8biu/W3WvhEHDwjwrWA==, orderId=201903136570036, txnType=01, frontUrl=http://www.unspay.com/unspay/page/linkbank/unionpayNewRespPage.action, currencyCode=156, merId=876290050651914, subMerName=重庆曲普贸易有限公司, accType=01, merName=重庆曲普贸易有限公司, certId=69929927506, bizType=000201, txnTime=20190313113936, accessType=1}";
        String s = JSON.toJSONString(a);
        System.out.println(s);
    }

    @Test
    public void Test6() {
        int n1 = 3;
        int n2 = 5;
        int n3 = 7;

        int num = 10;

        for (int i = 0; i < num - 3; i++) {
            int n4 = n1 + n3 - 2 * n2;
            n1 = n2;
            n2 = n3;
            n3 = n4;
        }
        System.out.println("n1:" + n1);
        System.out.println("n2:" + n2);
        System.out.println("n3:" + n3);
    }


    @Test
    public void Test7() {
        String amt = new BigDecimal("1256478989876").divide(new BigDecimal("10000000000000000000")).toString();
    }

    @Test
    public void Test8() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", "12");
        map.put("sex", null);
        map.put("amount", "100");
        List<String> list = new ArrayList<>();


        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (null == value || "".equals(value)) {
                list.add(entry.getKey());
            }
        }

        for (String key : list) {
            map.remove(key);
        }

        System.out.println(map);
    }

    public static void main(String[] args) {

    }

    @Test
    public void Test9() {

        String a = "MEQCIHGl8q6PkO2RkHXrwEY/EbkQqJmKf36hHYNYDLysnSgcAiA3DE2X7jlTv6fN\n" +
                "4rO2Qr839yMW0kHcBFB0KfV5qIhkGg==\n";
        a = a.replaceAll("\r", "").replaceAll("\n", "").replaceAll("\t", "");
        System.out.println(a);

    }


    @Test
    public void Test10() {
        String str = "abc";
        String str1 = new String("abc");
        int q = 1, w = 2;
        str.hashCode();
        System.out.println(str + q + w);

    }

    @Test
    public void Test11() {
        ArrayList list = new ArrayList();
        Object o = new Object();
        list.add(o);
        list.remove(o);
        while (true) {
            list.add(new Object());
        }
    }


}
