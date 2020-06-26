import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class scanDirBoard {
    public static void func(File file) {
        Queue<File> queue = new LinkedList<>();
        queue.add(file);
        while(!queue.isEmpty()) {
            File f = queue.poll();
            if(f.isDirectory()) {
                System.out.println(f.getAbsolutePath()+"\\\\");
            } else {
                System.out.println(f.getAbsolutePath());
            }
            if(f.isDirectory()) {
                File[] files = f.listFiles();
                for (File f1:files) {
                    queue.add(f1);
                }
            }
        }
    }
    public static void main(String[] args) {
        String path = "测试目录";
        File file = new File(path);
        func(file);
    }
}
