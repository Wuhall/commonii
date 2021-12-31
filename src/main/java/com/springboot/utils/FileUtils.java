package com.springboot.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Wuhall
 */
public class FileUtils {

    /**
     * 文件下载
     */
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

    /**
     * 递归文件夹中的文件
     * 返回文件名
     */
    public static void recursiveFile(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            recursiveFile(dir);
        }
    }

    /**
     * 文件复制
     */
    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);
        byte[] bytes = new byte[20 * 1024];
        int n;
        while ((n = in.read(bytes, 0, bytes.length)) != -1) {
            out.write(bytes, 0, n);
        }
        in.close();
        out.close();
    }

    /**
     * 逐行输出文件内容
     * inputStreamReader 实现字节流解码成字符流
     */
    public static void readFileContent(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
