package com.zhang.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * 将私钥文件，公钥文件转换成公私钥内容工具类
 * 声明：以下代码只是为了方便测试而提供的样例代码，可以根据自己需要，按照技术文档编写。该代码仅供参考，不提供编码性能规范性等方面的保障
 */
public class CertUtil {

    public static PrivateKey getPriKey(KeyStore keyStore, String password) {
        try {
            Enumeration<String> aliasenum = keyStore.aliases();
            if (aliasenum.hasMoreElements()) {
                String keyAlias = aliasenum.nextElement();
                if (keyStore.isKeyEntry(keyAlias)) {
                    PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias, password.toCharArray());
                    return privateKey;
                }
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static KeyStore loadKeyStore(String pfxkeyfile, String password) {
        FileInputStream fis = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            fis = new FileInputStream(pfxkeyfile);
            char[] nPassword = password.toCharArray();
            if (null != keyStore) {
                keyStore.load(fis, nPassword);
            }
            return keyStore;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fis)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    public static PublicKey loadPubkey(String pubkeyfile) {
        CertificateFactory cf = null;
        FileInputStream in = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            in = new FileInputStream(pubkeyfile);
            X509Certificate validateCert = (X509Certificate) cf.generateCertificate(in);
            return validateCert.getPublicKey();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
