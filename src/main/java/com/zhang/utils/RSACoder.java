package com.zhang.utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public abstract class RSACoder {

    private static Log logger = LogFactory.getLog(RSACoder.class);
    public static final String KEY_ALGORITHM = "RSA";
   /* private static final int KEY_SIZE = 1024;
    RSA最大加密明文大小
    private static final int MAX_ENCRYPT_BLOCK = 117;*/

    private static PublicKey publicKey;
    private static PrivateKey privateKey;

    private static KeyFactory keyFactory;
    private static String priKeyPath="E:\\usr\\local\\keys\\xianpingan\\testpri.key";
    private static String pubKeyPath = "E:\\usr\\local\\keys\\xianpingan\\testpub.key";





    static {
        try {
            keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            logger.error("秘钥工厂加载失败！", e);
        }
        FileInputStream fis = null;
        ObjectInputStream ofs = null;
        try {
            //加载公钥
            fis = new FileInputStream(pubKeyPath);
            ofs = new ObjectInputStream(fis);
            RSAPublicKey pubKey = (RSAPublicKey) ofs.readObject();
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pubKey.getEncoded());
            publicKey = keyFactory.generatePublic(x509KeySpec);
        } catch (Exception e) {
            logger.error("公钥加载异常！", e);
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
                if (null != ofs) {
                    ofs.close();
                }
            } catch (Exception e) {
                logger.error("公钥加载资源释放异常", e);
            }
        }

        try {
            //加载私钥
            fis = new FileInputStream(priKeyPath);
            ofs = new ObjectInputStream(fis);
            RSAPrivateKey priKey = (RSAPrivateKey) ofs.readObject();
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(priKey.getEncoded());
            privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        } catch (Exception e) {
            logger.error("私钥加载异常！", e);
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
                if (null != ofs) {
                    ofs.close();
                }
            } catch (Exception e) {
                logger.error("私钥加载资源释放异常", e);
            }
        }
    }

    /**
     * 公钥加密（平台给的公钥）
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPubKey(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥加密（自己的私钥）
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPriKey(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用平台公钥验签
     *//*
    public static boolean verify(String respXml, String signStr) throws Exception {
        String respXmlMd5 = MD5.getHashString(respXml.getBytes("UTF-8"));
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decryptData = decryptByPublicKey(decoder.decodeBuffer(signStr));
        String md5Str = new String(decryptData, "UTF-8");
        if (respXmlMd5.equals(md5Str)) {
            return true;
        }
        return false;
    }*/
}
