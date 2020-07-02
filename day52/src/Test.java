import java.io.*;

public class Test {
    public static void main(String[] args) {
        String path = "测试目录/gaga.txt";
        try(InputStream is = new FileInputStream(path)) {
            char[] buffer = new char[1024];
            int n;
            try(Reader reader = new InputStreamReader(is,"UTF-8")) {
                while((n = reader.read(buffer)) != -1) {
                    for (int i = 0; i < n ; i++) {
                        System.out.println(buffer[i]);
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
