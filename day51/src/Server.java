
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final int SERVER_PORT = 9260;
    public static ExecutorService threadPool = Executors.newFixedThreadPool(8);
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while(true) {
                //阻塞1
                Socket socket = serverSocket.accept();
                SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
                System.out.println(remoteSocketAddress);
                Runnable task = new RequestTaskPool(socket);
                threadPool.execute(task);
            }
        }
    }

}
