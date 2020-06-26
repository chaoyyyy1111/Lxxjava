import jdk.internal.util.xml.impl.Input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStreamDemo {
    public static void main(String[] args) {
        inputDemo();
    }

    private static void inputDemo() {
        /*try (InputStream is = new FileInputStream("测试目录\\linlin.txt")) {
            int count = 0;
            while(true) {
                int n = is.read();
                if(n == -1) {
                    break;
                }
                count++;
                System.out.printf("%d%n",n);
                System.out.printf("%02x%n",n);
                System.out.printf("%c%n",n);
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
         */
        try (InputStream is = new FileInputStream("测试目录\\linlin.txt")) {
            byte[] buffer = new byte[8];
            int count = 0;
            while(true) {
                int n = is.read(buffer);
                System.out.println("读到了"+n+"个数");
                count++;
                if(n == -1) {
                    break;
                }
                for (int i = 0; i < n ; i++) {
                    System.out.printf("%d%n",buffer[i]);
                    System.out.printf("%02x%n",buffer[i]);
                    System.out.printf("%c%n",buffer[i]);
                }
            }
            System.out.println(count);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}

