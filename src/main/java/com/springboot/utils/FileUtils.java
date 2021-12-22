package com.springboot.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Wuhall
 */
public class FileUtils {

    public static void downFile(String fileName, HttpServletResponse response) throws FileNotFoundException {
        String path = System.getProperty("user.dir");
        String filePath = path + "/" + fileName;
        // 读到流中
        InputStream inStream = new FileInputStream(filePath);
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
            new File(filePath).delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
