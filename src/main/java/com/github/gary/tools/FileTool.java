package com.github.gary.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class FileTool {
    private static final int BUFFER_SIZE = 1024 * 10;
    //    private static String downloadPath = File.separator + "Users" + File.separator + "garygao" + File.separator + "workspace" + File.separator + "MusicCloud163" + File.separator + "music" + File.separator;
    private static String downloadPath = "/Users/garygao/Music/网易云音乐/";

    /**
     * 下载文件
     *
     * @param fileName 文件名，带上后缀
     * @param httpUrl  从网络上下载的地址
     */
    public static void download(String fileName, String httpUrl) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpConn = null;
        URL url = null;
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int size = 0;
            url = new URL(httpUrl);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.connect();
            bis = new BufferedInputStream(httpConn.getInputStream());
            String wholePath = downloadPath + fileName;
            File file = new File(wholePath);
            if (file.exists()) {
                System.out.println("存在文件:" + wholePath);
                return;
            }
            fos = new FileOutputStream(wholePath);

            System.out.println("正在获取链接[" + httpUrl + "]的内容\n将其保存为文件[" + fileName + "]");

            while ((size = bis.read(buf)) != -1)
                fos.write(buf, 0, size);
            fos.close();
            bis.close();
            httpConn.disconnect();
            System.out.println(wholePath + "||已下载完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (httpConn != null) {
                    httpConn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}