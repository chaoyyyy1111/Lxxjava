import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.Scanner;

public class FileStreamDemo {
    public static void main1(String[] args) {

        inputDemo();
        //outputDemo();
    }

    private static void outputDemo() {
        try(OutputStream os = new FileOutputStream("测试目录\\gaga.txt")) {
            byte[] buffer = new byte[8];
            buffer[0] = 'H';
            buffer[1] = '\r';
            buffer[2] = '\n';
            buffer[3] = 'W';
            os.write(buffer,0,4);
            os.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
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
        try (InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            byte[] buffer = new byte[1024];
            while(true) {
                int n = is.read(buffer);
                if(n == -1) {
                    break;
                }
                for (int i = 0; i < n ; i++) {
                    System.out.printf("%d%n",buffer[i]);
                    System.out.printf("%02x%n",buffer[i]);
                }
                String s = new String(buffer,0,n,"UTF-8");
                System.out.println(s);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static void main2(String[] args) throws IOException {
        try(InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            try(Reader reader = new InputStreamReader(is,"UTF-8")) {
                char[] buf = new char[1024];
                int n;
                while((n = reader.read(buf)) != -1) {
                    for (int i = 0; i < n ; i++) {
                        System.out.println(buf[i]);
                    }
                }
            }
        }
    }

    public static void main3(String[] args) throws IOException{
        try(Reader reader = new FileReader("测试目录\\中文.txt")) {
            char[] buf = new char[1024];
            int n;
            while((n = reader.read(buf)) != -1) {
                for (int i = 0; i < n ; i++) {
                    System.out.println(buf[i]);
                }
            }
        }
    }

    public static void main4(String[] args) throws IOException {
        try(InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            try(Reader reader = new InputStreamReader(is,"UTF-8")) {
                try(Scanner scan = new Scanner(reader)) {
                    while(scan.hasNextLine()) {
                        String line = scan.nextLine();
                        System.out.println(line);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try(InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            try(Scanner scan = new Scanner(is,"UTF-8")) {
                while(scan.hasNextLine()) {
                    String line = scan.nextLine();
                    System.out.println(line);
                }
            }
        }
    }
}

