import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class RequestTaskPool implements Runnable {
    private final Socket socket;
    public RequestTaskPool(Socket socket) {
         this.socket = socket;
     }

    @Override
    public void run() {
        try{
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            Scanner isScanner = new Scanner(is,"UTF-8");
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(os,"UTF-8"));
            //阻塞2
            while(isScanner.hasNextLine()) {
                String request = isScanner.nextLine();
                String response = service(request);
                printWriter.printf("%s\r\n",response);
                printWriter.flush();
            }
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
    private static String service (String request) {
        return request;
    }
}
