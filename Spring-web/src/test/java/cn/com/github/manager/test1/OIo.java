package cn.com.github.manager.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OIo {

    private static boolean isStop = false;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        System.out.println("11111111111111");
        ServerSocket server = new ServerSocket(8089);
        // 通过线程池的方式来处理
        executorService = Executors.newCachedThreadPool();
        // 监听多个请求
        while (!isStop) {
            Socket clientSocket = server.accept();
            // 每个请求分配对应的线程来处理
            // 由于是阻塞IO，所以如果不分配线程来处理，会导致同一时间只能处理
            // 一个请求
            System.out.println("222222222222");
            executorService.submit(new NetworkHandler(clientSocket));
        }
    }

    static class NetworkHandler implements Runnable {

        private Socket clientSocket;

        public NetworkHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                String requestContent, responseContent;
                // 建立连接之后不停读取数据
                while((requestContent = reader.readLine()) != null) {
                    if("DONE".equals(requestContent)) {
                        break;
                    }
                    responseContent = handleRequest(requestContent);
                    writer.write(responseContent);
                }
                writer.flush();
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String handleRequest(String request) {
            System.out.println("request: " + request);
            return "handed";
        }
    }
}