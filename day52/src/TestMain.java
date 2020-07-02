import java.sql.SQLOutput;

public class TestMain {
    public static void main(String[] args) {
        String s = "https://hao.360.com/";
        int pos = s.indexOf("://");
        String 协议 = s.substring(0,pos);
        int pos1 = s.indexOf("/",pos+3);
        String tmp = s.substring(pos+3,pos1);
        int pos2 = tmp.indexOf(":");
        int port = 0;
        String host = "";
        if(pos2 == -1) {
            if(协议.equals("http")) {
                port = 80;
                host = tmp;
            } else {
                port = 443;
                host = tmp;
            }
        } else {
            port = Integer.parseInt(tmp.substring(pos2+1));
            host = tmp.substring(0,pos2);
        }
        int pos3 = s.indexOf("?");
        String path = "";
        String query = "";
        if(pos3 == -1) {
            path = s.substring(pos1);
            query = "query不存在";
        } else {
            path = s.substring(pos1,pos3);
            query = s.substring(pos3+1);
        }

        System.out.println(协议);
        System.out.println(host);
        System.out.println(port);
        System.out.println(path);
        System.out.println(query);
    }

}
