import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TestDemo {
    public static final String HOST = "www.baidu.com";
    public static final int PORT = 80;
    public static void main(String[] args) {
        try(Socket socket = new Socket(HOST,PORT)) {
            String request = "GET /s?wd=java HTTP/1.1\r\nHost:www.baidu.com\r\n\r\n";
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            printWriter.print(request);
            printWriter.flush();
            Scanner scan = new Scanner(socket.getInputStream(),"UTF-8");
            while(scan.hasNext()) {
                String s = scan.nextLine();
                System.out.println(s);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
