package com.exchange.bbs.web.utils;

import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * java 加解密工具类
 *
 * @author zwh
 */
@SuppressWarnings("restriction")
public class EncryptUtil {

    private static final String UTF8 = "utf-8";
    //定义 加密算法,可用 DES,DESede,Blowfish
    private static final String ALGORITHM_DESEDE = "DESede";

    // MD5数字签名
    @SuppressWarnings("unused")
    private static String md5Digest(String src, int bit) throws Exception {
        // 定义数字签名方法, 可用：MD5, SHA-1
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(src.getBytes(UTF8));
        if (bit == 16) {
            return byte2HexStr(b).substring(8, 24);
        } else {
            return byte2HexStr(b);
        }
    }

    /**
     * BASE64 加密
     *
     * @param src
     * @return
     * @throws Exception
     */
/*    public static String base64Encoder(String src) throws Exception {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(src.getBytes(UTF8));
    }*/

    //BASE64解密
    public static String base64Decoder(String dest) throws Exception {
        BASE64Decoder decoder = new BASE64Decoder();
        return new String(decoder.decodeBuffer(dest), UTF8);
    }

    //3DES加密
    public static String desedeEncoder(String src, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(build3DesKey(key), ALGORITHM_DESEDE);
        Cipher cipher = Cipher.getInstance(ALGORITHM_DESEDE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] b = cipher.doFinal(src.getBytes(UTF8));

        return byte2HexStr(b);
    }

    //3DES解密
    public static String desedeDecoder(String dest, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(build3DesKey(key), ALGORITHM_DESEDE);
        Cipher cipher = Cipher.getInstance(ALGORITHM_DESEDE);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] b = cipher.doFinal(str2ByteArray(dest));

        return new String(b, UTF8);

    }

    // 字节数组转化为大写16进制字符串
    private static String byte2HexStr(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String s = Integer.toHexString(b[i] & 0xFF);
            if (s.length() == 1) {
                sb.append("0");
            }
            sb.append(s.toUpperCase());
        }
        return sb.toString();
    }

    //字符串转字节数组
    private static byte[] str2ByteArray(String s) {
        int byteArrayLength = s.length() / 2;
        byte[] b = new byte[byteArrayLength];
        for (int i = 0; i < byteArrayLength; i++) {
            byte b0 = (byte) Integer.valueOf(s.substring(i * 2, i * 2 + 2), 16).intValue();
            b[i] = b0;
        }
        return b;
    }

    //构造3DES加解密方法key
    private static byte[] build3DesKey(String keyStr) throws Exception {
        byte[] key = new byte[24];
        byte[] temp = keyStr.getBytes(UTF8);
        if (key.length > temp.length) {
            System.arraycopy(temp, 0, key, 0, temp.length);
        } else {
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    }

    /**
     * AES 加密
     *
     * @param content  明文
     * @param password 生成秘钥的关键字
     * @return
     */
    public static byte[] aesEncrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();// 分组秘钥
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 生成秘钥
            Cipher cipher = Cipher.getInstance("AES");
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES 解密
     *
     * @param content  密文
     * @param password 生成秘钥的关键字
     * @return
     */
    public static byte[] aesDecrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();//分组秘钥
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");//生成秘钥
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //将二进制转换成16进制 
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    //md5加密
    public static String md5Encrypt(String inStr) {
        String outStr = "";
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(inStr.getBytes());
            byte b[] = md.digest();
            StringBuffer buf = new StringBuffer();
            for (int i = 1; i < b.length; i++) {
                int c = b[i] >>> 4 & 0xf;
                buf.append(Integer.toHexString(c));
                c = b[i] & 0xf;
                buf.append(Integer.toHexString(c));
            }
            outStr = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return outStr;
    }

    //将16进制转换为二进制   
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) {
        try {

            //    		String str = "ADJIW2321,100";
            //加密
            //    		System.out.println("加密前：" + str);
            //    		byte[] encryptResult = aesEncrypt(str, Config.ENCODE_KEY);
            //    		String encryptResultStr = parseByte2HexStr(encryptResult);
            //    		System.out.println("加密后：" + encryptResultStr);
            //解密
            //    		byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
            ////    	byte[] decryptResult = aesDecrypt(decryptFrom,Config.ENCODE_KEY);
            //    		System.out.println("解密后：" + new String(decryptResult));

    		/*String encodeStr = desedeEncoder(str, Config.ENCODE_KEY);
            String decodeStr = desedeDecoder(encodeStr, Config.ENCODE_KEY);
    		System.out.println("EStr:"+encodeStr);
    		System.out.println("Estr:"+encodeStr.length());
    		System.out.println("DStr:"+decodeStr);*/

    		
    		/*String coder1=EncryptUtil.base64Encoder("张卫花");
    		String coder2=EncryptUtil.base64Decoder(coder1);
    		System.out.println("加密："+coder1);
    		System.out.println("解密："+coder2);
    		String des1=EncryptUtil.desedeEncoder("1", "!@$#");
    		String des2=EncryptUtil.desedeDecoder(des1, "!@$#");
			System.out.println("加密："+des1);
    		System.out.println("解密："+des2);
			
    		String md5=EncryptUtil.md5Digest("1");
    		System.out.println(md5);*/
            //    		String testStr = "1111111111111111|"+DateUtils.getTime(0);
            //    		System.out.println(testStr);
            //testStr = Base64.encode(testStr, "utf-8");
            //System.out.println(testStr+"---"+testStr.length());
            //    		String resultStr = aesEncrypt(testStr, "token");
            //    		System.out.println(resultStr+"----"+resultStr.length());
            //    		resultStr = aesDecrypt(resultStr, "token");
            //    		System.out.println(resultStr+"----"+resultStr.length());
            //resultStr = Base64.decode(resultStr);
            //System.out.println(resultStr+"----"+resultStr.length());
    		/*long src = System.currentTimeMillis();
    		System.out.println(src);
    		long res = src-1200000000000l;
    		System.out.println(res);*/
    		/*String des1=EncryptUtil.desedeEncoder(DateUtils.getTime(0), "!@$#");
    		String des2=EncryptUtil.desedeDecoder(des1, "!@$#");
			System.out.println("加密："+des1);
    		System.out.println("解密："+des2);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
