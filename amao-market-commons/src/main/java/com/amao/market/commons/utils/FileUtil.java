package com.amao.market.commons.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @author LinYuchang
 */
public class FileUtil {

    public static byte[] readAsBytes(File file) throws IOException {
        try (FileInputStream is = new FileInputStream(file)) {
            return FileUtil.readAsBytes(is);
        }
    }

    public static byte[] readAsBytes(InputStream is) throws IOException {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            IOUtils.copy(is, os);
            return os.toByteArray();
        }
    }

    public static void write(File file, byte[] data) throws IOException {
        try (FileOutputStream os = new FileOutputStream(file)) {
            FileUtil.write(os, data);
        }
    }

    public static void write(OutputStream os, byte[] data) throws IOException {
        try (ByteArrayInputStream is = new ByteArrayInputStream(data)) {
            IOUtils.copy(is, os);
        }
    }

    /**
     * 获取文件的md5
     *
     * @param file 文件对象
     * @return md5
     * @throws IOException 文件读取失败时抛出
     */
    public static String getMD5(File file) throws IOException {
        try (FileInputStream stream = new FileInputStream(file)) {
            return DigestUtils.md5Hex(stream);
        }
    }

    /**
     * 计算文件流的md5
     *
     * @param stream 文件流
     * @return md5
     * @throws IOException 流读取失败时抛出
     */
    public static String getMD5(InputStream stream) throws IOException {
        return DigestUtils.md5Hex(stream);
    }

    /**
     * 获取文件后缀名
     *
     * @param path    文件路径
     * @param withDot 是否包含小数点分隔符
     * @return String
     */
    public static String getExtension(String path, boolean withDot) {
        int index = path.lastIndexOf(".");
        return index < 0 ? "" : path.substring(withDot ? index : index + 1);
    }
}
