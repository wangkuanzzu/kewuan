package ECCUtils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class JDK8EncryptECC {

    //生成秘钥对
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    //获取公钥(Base64编码)
    public static String getPublicKey(KeyPair keyPair){
        PublicKey publicKey = keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return new String(Base64.getEncoder().encode(bytes));
    }

    //获取私钥(Base64编码)
    public static String getPrivateKey(KeyPair keyPair){
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return new String(Base64.getEncoder().encode(bytes));
    }

    //将Base64编码后的公钥转换成PublicKey对象
    public static PublicKey string2PublicKey(String pubStr) throws Exception{
        byte[] keyBytes = Base64.getDecoder().decode(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    //将Base64编码后的私钥转换成PrivateKey对象
    public static PrivateKey string2PrivateKey(String priStr) throws Exception{
        byte[] keyBytes = Base64.getDecoder().decode(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    //公钥加密
    public static byte[] publicEncrypt(byte[] content, PublicKey publicKey) throws Exception{
        Cipher cipher = Cipher.getInstance("ECIES");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    //私钥解密
    public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("ECIES");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }
}
