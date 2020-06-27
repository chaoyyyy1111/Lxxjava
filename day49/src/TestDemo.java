import java.io.*;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) throws IOException {
           String path1 = "测试目录\\gaga.txt";
           String path2 = "测试目录\\gungun.txt";
           try(InputStream is = new FileInputStream(path1)) {
               byte[] buf = new byte[8];
               try(OutputStream os = new FileOutputStream(path2)) {
                   int n;
                   while((n = is.read(buf)) != -1) {
                       os.write(buf,0,n);
                   }
                   os.flush();
               }
           }

    }
}