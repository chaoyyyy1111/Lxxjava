import sun.rmi.runtime.Log;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;
public class Client {
    private static final String SERVER_HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        try(Socket socket = new Socket(SERVER_HOST,Server.SERVER_PORT)) {
            SocketAddress localSocketAddress = socket.getLocalSocketAddress();
            System.out.println(localSocketAddress);
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            System.out.println(remoteSocketAddress);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            Scanner isScanner = new Scanner(is,"UTF-8");
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(os,"UTF-8"));
            System.out.print("请填写请求> ");
            while(scan.hasNextLine()) {
                String request = scan.nextLine();
                printWriter.printf("%s\r\n",request);
                printWriter.flush();
                String response = isScanner.nextLine();
                System.out.println(response);
                System.out.print("请填写请求> ");
            }
        }
    }
}
