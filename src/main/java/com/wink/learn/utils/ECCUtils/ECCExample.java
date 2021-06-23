package com.wink.learn.utils.ECCUtils;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;


import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;


public class ECCExample {

    public static void main(String[] args) throws Exception {

//        jdkJDK8SignECC2();
//        JDKEncryptECC();



    }

    public static void hutoolEcc(){
        KeyPair keyPair = SecureUtil.generateKeyPair(SignAlgorithm.SHA256withECDSA.getValue(),256);
        System.out.println(keyPair.getPrivate().toString());
        System.out.println(keyPair.getPublic().toString());
        String data = "123";
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withECDSA);
        byte[] signed = sign.sign(data.getBytes());
        System.out.println(Arrays.toString(signed));
        boolean verify = sign.verify(data.getBytes(),signed);
        System.out.println(verify);
    }

    public static void jdkJDK8SignECC2() throws Exception{
        String msg = "helloworld";

        byte[] sign1 = JDK8SignECC.sign(JDK8SignECC.SHA256withECDSA,"/Users/kuan/temp/private_key_ecdsa.txt",msg.getBytes());
        System.out.println("sign1: "+ Base64.getEncoder().encodeToString(sign1));

//        String privateKey = "MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCCGk6jWcuKK/9N0M/CKEEGh84VGRlGV+sXct+i0IY09ng==";
//        byte[] sign2 = JDK8SignECC.sign(JDK8SignECC.SHA256withECDSA,JDK8SignECC.string2PrivateKey(privateKey),msg.getBytes());
//        System.out.println("sign2: "+ Base64.getEncoder().encodeToString(sign2));
//
//        byte[] sign3 = JDK8SignECC.sign(JDK8SignECC.SHA256withECDSA,JDK8SignECC.string2PrivateKey(privateKey),msg.getBytes());
//        System.out.println("sign3: "+ Base64.getEncoder().encodeToString(sign3));

        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE1SmTD9+hRzZB4NXZnfPpRkRayW8RUQ0JeLAJEqap07C8MLe/jC4nP4b7SsNBfEzneZAdmn6gfXY7DwAXInBR6w==";
        Boolean checkFlag1 = JDK8SignECC.verify(JDK8SignECC.SHA256withECDSA,JDK8SignECC.string2PublicKey(publicKey),msg.getBytes(),sign1);
        System.out.println(checkFlag1);

    }


    public static void jdkJDK8SignECC() throws Exception{
        String msg="{\n" +
                "    \"name\":\"张三\",\n" +
                "    \"address\":\"北京市朝阳区中电发展大厦\",\n" +
                "    \"accountType\":1,\n" +
                "    \"accountName\":\"张三\",\n" +
                "    \"bankName\":\"招商银行\",\n" +
                "    \"accountNo\":\"6225888888888888\",\n" +
//                "    \"publicKey\":\"WER45YUIO\",\n" +
//                "    \"sign\":\"DFHGRTHERT\"\n" +
                "}";


        //      给到流量主手中的公私钥文件示例
//      {
//         "pub_key": "iIpKYH7SpC1gEjXyzjSOteeSNCDOcN68O27u6R/sPyY=",
//         "priv_key": "khVE/f+rkQc9upt0tHqTncyhGxTwbtAIeXiVv9LRE4WIikpgftKkLWASNfLONI6155I0IM5w3rw7bu7pH+w/Jg=="
//      }

        //创建公私钥对
        KeyPair keyPairForSign = JDK8SignECC.initKey( 256);
        //base64转string
        String pub = Base64.getEncoder().encodeToString(keyPairForSign.getPublic().getEncoded());
        String pri = Base64.getEncoder().encodeToString(keyPairForSign.getPrivate().getEncoded());
        String fileContent = "{" +
                "\"pub_key\":"+"\""+pub+"\","+
                "\"priv_key\":"+"\""+pri+"\""+
                "}";
//      给到流量主手中的公私钥文件示例
//      {
//         "pub_key": "iIpKYH7SpC1gEjXyzjSOteeSNCDOcN68O27u6R/sPyY=",
//         "priv_key": "khVE/f+rkQc9upt0tHqTncyhGxTwbtAIeXiVv9LRE4WIikpgftKkLWASNfLONI6155I0IM5w3rw7bu7pH+w/Jg=="
//      }
        System.out.println("fileConent:\n"+fileContent);
        //签名算法，采用SHA256withECDSA，以下用于测试所有算法
        List<String> list= new ArrayList<>();
//        list.add(JDK8SignECC.NONEwithECDSA);
//        list.add(JDK8SignECC.RIPEMD160withECDSA);
//        list.add(JDK8SignECC.SHA1withECDSA);
//        list.add(JDK8SignECC.SHA224withECDSA);
        list.add(JDK8SignECC.SHA256withECDSA);
//        list.add(JDK8SignECC.SHA384withECDSA);
//        list.add(JDK8SignECC.SHA512withECDSA);
        for (String algo : list) {
            //私钥字符串生成私钥对象,执行签名
            PrivateKey privateKey = JDK8SignECC.string2PrivateKey(pri);
            byte[] sign = JDK8SignECC.sign(algo,privateKey,msg.getBytes());
            System.out.println("sign:"+ Base64.getEncoder().encodeToString(sign));

            //公钥字符串生成公钥对象,验证签名
            PublicKey publicKey = JDK8SignECC.string2PublicKey(pub);
            boolean checkb= JDK8SignECC.verify(algo,publicKey,msg.getBytes(),sign);
            System.out.println("checkb:"+ checkb);
        }
    }

    public static void BCEncryptECC() throws Exception{
        //加解密操作
        KeyPair keyPair = BCEncryptECC.getKeyPair();
        String publicKeyStr = BCEncryptECC.getPublicKey(keyPair);
        String privateKeyStr = BCEncryptECC.getPrivateKey(keyPair);
        System.out.println("ECC公钥Base64编码:" + publicKeyStr);
        System.out.println("ECC私钥Base64编码:" + privateKeyStr);

        ECPublicKey publicKey = BCEncryptECC.string2PublicKey(publicKeyStr);
        ECPrivateKey privateKey = BCEncryptECC.string2PrivateKey(privateKeyStr);

        byte[] publicEncrypt = BCEncryptECC.publicEncrypt("hello world".getBytes(), publicKey);
        System.out.println(new String(Base64.getEncoder().encode(publicEncrypt)));
        byte[] privateDecrypt = BCEncryptECC.privateDecrypt(publicEncrypt, privateKey);
        System.out.println(new String(privateDecrypt));
    }
    public static void JDKEncryptECC() throws Exception{
        //加解密操作
        KeyPair keyPair = JDK8EncryptECC.getKeyPair();
        String publicKeyStr = JDK8EncryptECC.getPublicKey(keyPair);
        String privateKeyStr = JDK8EncryptECC.getPrivateKey(keyPair);
        System.out.println("ECC公钥Base64编码:" + publicKeyStr);
        System.out.println("ECC私钥Base64编码:" + privateKeyStr);

        PublicKey publicKey = JDK8EncryptECC.string2PublicKey(publicKeyStr);
        PrivateKey privateKey = JDK8EncryptECC.string2PrivateKey(privateKeyStr);

        byte[] publicEncrypt = JDK8EncryptECC.publicEncrypt("hello world".getBytes(), publicKey);
        System.out.println(new String(Base64.getEncoder().encode(publicEncrypt)));
        byte[] privateDecrypt = JDK8EncryptECC.privateDecrypt(publicEncrypt, privateKey);
        System.out.println(new String(privateDecrypt));
    }

}