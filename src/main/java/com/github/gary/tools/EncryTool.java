package com.github.gary.tools;

import com.github.gary.core.Params;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

/**
 * params 参数计算 两次AES/CBC/Padding IV(0102030405060708) 两次加密结果均再次进行Base64编码
 * encSecKey 参数计算 RSA加密NoPadding
 * <p>
 * RSA的算法涉及三个参数，n、e1、e2。其中，n是两个大质数p、q的积，n的二进制表示时所占用的位数，就是所谓的密钥长度。
 * <p>
 * e1和e2是一对相关的值，e1可以任意取，
 * <p>
 * 要求e1与(p-1）*(q-1）互质；
 * <p>
 * 再选择e2，要求（e2*e1）mod((p-1）*(q-1））=1。
 * <p>
 * （n，e1）,(n，e2）就是密钥对。其中(n，e1）为公钥，(n，e2）为私钥。
 * <p>
 * RSA加解密的算法完全相同，设A为明文，B为密文，则：
 * <p>
 * A=B^e2 mod n；
 * <p>
 * B=A^e1 mod n；
 *
 * @author garygao
 */
public class EncryTool {
    private final static String IV = "0102030405060708";
    private static String randomStr = null;

    private static final String USER_NAME = "*******************@163.com";
    private static final String PASSWORD = "******************************";

    /**
     * @param args 参数
     */
    public static void main(String[] args) {
        String param1 = "{\"username\":\"" + USER_NAME + "\",\"password\":\"" + EncryTool.getMD5(PASSWORD)
                + "\",\"rememberLogin\":\"true\",\"clientToken\":\"1_KJrAO+ifmy7J31aKKyZDkp5wFiX3nzhS_PvXciyu9xmqdCzCWQA1PrraNbpYGz3rv\",\"csrf_token\":\"\"}", // ,\"clientToken\":\"1_KJrAO+ifmy7J31aKKyZDkp5wFiX3nzhS_Kzu3EV21dVDkNsDWYkdFTLzNCxNtwlNx\"
                param2 = Params.pubKey,
                param3 = Params.modulus,
                param4 = Params.nonce;

        System.out.printf("params=%1$s&encSecKey=%2$s%n", getParams(param1, param4), getEncSecKey(param2, param3));
    }

    public static byte[] getMD5(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(pass.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * OK!
     * <p>
     * 010001
     * 00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7
     *
     * @param param2 参数2
     * @param param3 参数3
     * @return
     */
    public static String getEncSecKey(String param2, String param3) {
        // TODO Auto-generated method stub
        try {
            final int maxEncryptBlock = 1024;
            BigInteger pubkey = new BigInteger(param2, 16);
            BigInteger modulus = new BigInteger(param3, 16);
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, pubkey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            // PKCS1Padding
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            randomStr = new StringBuilder(randomStr).reverse().toString();
            byte[] data = randomStr.getBytes("utf-8");
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;

            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > maxEncryptBlock) {
                    cache = cipher.doFinal(data, offSet, maxEncryptBlock);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * maxEncryptBlock;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            String result = byte2HexString(encryptedData);
            if (result.length() >= 256) {
                return result.substring(result.length() - 256, result.length());
            } else {
                while (result.length() < 256) {
                    result = 0 + result;
                }
                return result;
            }
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | IOException
                | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String byte2HexString(byte[] encryptedData) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder(encryptedData.length);
        for (int i = 0; i < encryptedData.length; i++) {
            String temp = Integer.toHexString(encryptedData[i] & 0xff);
            if (temp.length() < 2) {
                sb.append("0");
            }
            sb.append(temp.toLowerCase());
        }
        return sb.toString();
    }

    /**
     * @param param1
     * @param param4
     * @return
     */
    public static String getParams(String param1, String param4) {
        // TODO Auto-generated method stub
        try {
            SecretKey key = getKey(param4.getBytes("utf-8"));
            // PKCS5Padding
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("utf-8")));
            byte[] res = cipher.doFinal(param1.getBytes("utf-8"));
            res = Base64.getEncoder().encode(res);

            randomStr = getRandom(16);
            key = getKey(randomStr.getBytes("utf-8"));
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("utf-8")));
            byte[] result = cipher.doFinal(res);
            return new String(Base64.getEncoder().encode(result), "utf-8");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | UnsupportedEncodingException | IllegalBlockSizeException
                | BadPaddingException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    // 随机16字符即可
    private static String getRandom(int size) {
        StringBuilder sb = new StringBuilder(size);
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int j = 0; j < size; j++) {
            int m = (int) (Math.random() * alphabet.length());
            sb.append(alphabet.charAt(m));
        }
        return sb.toString();
    }

    private static SecretKey getKey(byte[] bytes) {
        // TODO Auto-generated method stub
        byte[] keyTemp = new byte[16];
        for (int i = 0; i < keyTemp.length; i++) {
            keyTemp[i] = bytes[i];
        }
        return new SecretKeySpec(bytes, "AES");
    }

}
