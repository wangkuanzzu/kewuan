package com.wink.learn.utils.ECCUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class BCSignECC {

//    引用BouncyCastleProvider实现ECC
    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }
    public static final String BC = "BC";
    public static final String EC = "EC";
    public static final String NONEwithECDSA = "NONEwithECDSA";
    public static final String RIPEMD160withECDSA = "RIPEMD160withECDSA";
    public static final String SHA1withECDSA = "SHA1withECDSA";
    public static final String SHA224withECDSA = "SHA224withECDSA";
    public static final String SHA256withECDSA = "SHA256withECDSA";
    public static final String SHA384withECDSA = "SHA384withECDSA";
    public static final String SHA512withECDSA = "SHA512withECDSA";

    public static KeyPair initKey(int keySize, byte[] seed) throws Exception {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance(BCSignECC.EC,BCSignECC.BC);
        // 初始化随机产生器
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(seed);
        keygen.initialize(keySize, secureRandom);
        KeyPair keys = keygen.genKeyPair();
        return keys;
    }

    public static KeyPair initKey(int keySize) throws Exception {
        return initKey(keySize, new SecureRandom().generateSeed(8));
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
        KeyFactory keyFactory = KeyFactory.getInstance(BCSignECC.EC,BCSignECC.BC);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    //将Base64编码后的私钥转换成PrivateKey对象
    public static PrivateKey string2PrivateKey(String priStr) throws Exception{
        byte[] keyBytes = Base64.getDecoder().decode(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(BCSignECC.EC,BCSignECC.BC);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static byte[] sign(String signAlgorithm, PrivateKey privateKey, byte[] data) throws Exception {
        // 2.执行签名[私钥签名]
        Signature signature = Signature.getInstance(signAlgorithm);
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    public static byte[] sign(String signAlgorithm, String pathname, byte[] data) throws Exception {
        String priv_key = null;
        InputStreamReader file= new InputStreamReader(new FileInputStream(pathname));
        BufferedReader br = new BufferedReader(file);
        String lineTxt = null;
        while ((lineTxt = br.readLine()) != null) {
            JSONObject jsonObject = JSON.parseObject(lineTxt);
            priv_key = jsonObject.getString("priv_key");
        }

        PrivateKey privateKey = string2PrivateKey(priv_key);
        return sign(signAlgorithm, privateKey, data);
    }

    public static byte[] sign(String signAlgorithm, byte[] privateKeyByte, byte[] data) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(BCSignECC.EC,BCSignECC.BC);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyByte);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        return sign(signAlgorithm, privateKey, data);
    }

    public static boolean verify(String signAlgorithm, byte[] publKeyBytes, byte[] data, byte[] sign) throws Exception {
        // 3.验证签名[公钥验签]
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(BCSignECC.EC,BCSignECC.BC);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        return verify(signAlgorithm,publicKey,data,sign);
    }

    public static boolean verify(String signAlgorithm, PublicKey publicKey, byte[] data, byte[] sign) throws Exception {
        // 3.验证签名[公钥验签]
        Signature signature = Signature.getInstance(signAlgorithm);
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(sign);
    }
}
