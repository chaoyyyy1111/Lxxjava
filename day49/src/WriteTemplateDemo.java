import java.io.*;

public class WriteTemplateDemo {
    public static void main1(String[] args) throws IOException {
        try(OutputStream os = new FileOutputStream("测试目录\\gaga.txt")) {
            byte[] buf = new byte[8192];
            for (int i = 0; i < 8 ; i++) {
                os.write(buf,i*1024,1024);
            }
            os.flush();
        }
    }

    public static void main2(String[] args) throws IOException {
        try(OutputStream os = new FileOutputStream("测试目录\\gaga.txt")) {
            try(Writer writer = new OutputStreamWriter(os,"UTF-8")) {
                char[] buf = new char[8];
                buf[0] = '你';
                buf[1] = '好';
                buf[2] = '世';
                buf[3] = '界';
                writer.write(buf,0,3);
                writer.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String s = "渣渣";
        try(OutputStream os = new FileOutputStream("测试目录\\gaga.txt")) {
            try(Writer writer = new OutputStreamWriter(os)) {
                try(PrintWriter printWriter = new PrintWriter(writer)) {
                    //printWriter.println("你是渣渣");
                    printWriter.printf("你是啦啦");
                    printWriter.flush();
                }
            }
        }
    }
}
