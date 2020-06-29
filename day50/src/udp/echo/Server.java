package udp.echo;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    public static final int PORT = 8602;
    public static void main(String[] args) {
        try(DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            while(true) {
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,0,receiveBuffer.length);
                serverSocket.receive(receivePacket);
                String host = receivePacket.getAddress().getHostName();
                int port = receivePacket.getPort();
                int length = receivePacket.getLength();
                String request = new String(receiveBuffer,0,length,"UTF-8");
                String response = Service(host,port,request);
                byte[] sendBuffer = response.getBytes("UTF-8");
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer,0,sendBuffer.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
    private static Map<String,Translation> map = new HashMap<>();
    private static class Translation {
        String 中文含义;
        List<String> 例句 = new ArrayList<>();
    }
    static {

            Translation translation = new Translation();
            translation.中文含义 = "苹果";
            translation.例句.add("他又咬了一口苹果。\r\n He took another bite of apple." );
            translation.例句.add("她削去苹果皮，把它切成四瓣。\r\n She peeled and quartered an apple. ");
            map.put("apple",translation);

    }

    private static String Service(String host,int port, String request) {
        //String sql = "select en,zh,sentances from dictionary where en = ?";
        String response = "";
        if(map.get(request) == null) {
            response = "该单词不存在";
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append(request);
            sb.append("\r\n含义：");
            sb.append(map.get(request).中文含义);
            sb.append("\r\n例句：\r\n");
            for(String s:map.get(request).例句) {
                sb.append(s);
                sb.append("\r\n");
            }
            response = sb.toString();
        }
        /*try(Connection connection = DUtil.getConnection()) {
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,request);
                try(ResultSet resultSet = ps.executeQuery()) {
                        if(resultSet.next()) {
                            String en = resultSet.getString(1);
                            String zh = resultSet.getString(2);
                            String sentances = resultSet.getString(3);
                            StringBuffer sb = new StringBuffer();
                            sb.append(en);
                            sb.append("\r\n含义：");
                            sb.append(zh);
                            sb.append("\r\n例句：\r\n");
                            sb.append(sentances);
                            response = sb.toString();
                        } else {
                            response = "不认识这个单词";
                        }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         */

        return response;
    }
}
