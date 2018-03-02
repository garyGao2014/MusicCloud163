package com.github.gary.asyn;

import com.alibaba.fastjson.JSONObject;
import com.github.gary.tools.FileTool;
import sun.tools.jconsole.Worker;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FileDownloadThread {

    private final static int threadCount = 10;
    //key为url value为文件名
    public static BlockingQueue<Map<String, String>> queue = new ArrayBlockingQueue<Map<String, String>>(100, true);
    private static ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);
    private static volatile boolean isRun = true;

    static {
        for (int i = 0; i < threadCount; i++) {
            threadPoolExecutor.execute(new FileDownloadWorker());
        }
    }

    private FileDownloadThread() {
        System.out.println("启动FileDownloadThread");
    }


    static class FileDownloadWorker implements Runnable {
        private FileDownloadWorker() {
            System.out.println("启动FileDownloadWorker");
        }

        @Override
        public void run() {
            try {
                while (isRun) {
                    Map<String, String> take = queue.take();
                    System.out.println("异步程序收到文件下载的消息:" + JSONObject.toJSONString(take));
                    if (take != null && take.size() > 0) {
                        for (String url : take.keySet()) {
                            String name = take.get(url);
                            FileTool.download(name, url);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new FileDownloadThread();
    }
}
