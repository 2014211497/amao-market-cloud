package com.amao.market.commons.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 加密工具类
 *
 * @author LinYuchang
 * @since 1.0.0
 */
public class EncryptUtil {

    /**
     * 对明文进行加密（不可逆）
     * <p>
     * 原理是进行 Base64 后再进行 MD5 得到字符串
     *
     * @param plainText 明文
     * @return 密文
     */
    public static String encryptWithBase64AndMD5(String plainText) {
        return DigestUtils.md5Hex(Base64.getEncoder().encodeToString(plainText.getBytes(UTF_8)));
    }

    /**
     * 对明文进行加密（不可逆）
     * <p>
     * 原理时进行 MD5 后再进行 Base64 得到字符串
     *
     * @param plainText 明文
     * @return 密文
     */
    public static String encryptWithMD5AndBase64(String plainText) {
        return Base64.getEncoder().encodeToString(DigestUtils.md5(plainText));
    }

    /**
     * base64 加密，使用 UTF8 编码
     *
     * @param data 待加密的字符串
     * @return 加密后的base64字符串
     */
    public static String base64Encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes(UTF_8));
    }

    /**
     * base64 解密，使用 UTF8 编码
     *
     * @param data 待解密的字符串
     * @return 解密后的字符串
     */
    public static String base64Decode(String data) {
        return new String(Base64.getDecoder().decode(data), UTF_8);
    }
}
