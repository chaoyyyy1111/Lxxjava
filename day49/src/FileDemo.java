import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        //String path = "D:\\录屏\\xixi.txt";
        String path = "测试目录";
        String path2 = "cici.txt";
        File dest = new File(path2);
        File file = new File(path);
        /*System.out.println(file.isFile());
        System.out.println(file.isAbsolute());
        System.out.println(file.isDirectory());
        System.out.println(file.isHidden());
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
         */

        /*try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        /*try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean mkdir = dest.mkdir();
        System.out.println(mkdir);
         */
        //boolean b = file.delete();
        File[] files = file.listFiles();
        for (File f:files) {
            System.out.println(f.getAbsolutePath());
        }
        String[] strs = file.list();
        System.out.println(strs);
        System.out.println(strs.length);
        for (String s:strs) {
            System.out.println(s);
        }
    }
}

