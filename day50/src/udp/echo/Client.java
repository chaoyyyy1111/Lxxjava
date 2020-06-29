package udp.echo;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Scanner;
public class Client {
    public static final String HOST = "127.0.0.1";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try(DatagramSocket clientSocket = new DatagramSocket()) {
            System.out.print("echo> ");
            while(scan.hasNext()) {
                String request = scan.nextLine();
                if(request.equalsIgnoreCase("quit")) {
                    break;
                }
                byte[] sendBuffer = request.getBytes("UTf-8");
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer,0,
                        sendBuffer.length,InetAddress.getByName(HOST),Server.PORT);
                clientSocket.send(sendPacket);
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,0,receiveBuffer.length);
                clientSocket.receive(receivePacket);
                String response = new String(receiveBuffer,0,
                        receivePacket.getLength(),"UTF-8");
                System.out.println("应答:"+response);
                System.out.print("echo> ");
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
