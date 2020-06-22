import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        String path = "随机.txt";
        File file = new File(path);
        //System.out.println(file.isFile());
       // System.out.println(file.isHidden());
       // System.out.println(file.isDirectory());
        //System.out.println(file.isAbsolute());
        //System.out.println(file.exists());
        //System.out.println(file.canExecute());
        //System.out.println(file.canRead());
        //System.out.println(file.canWrite());
        System.out.println(file.getAbsolutePath());
        //System.out.println(file.getName());
        //System.out.println(file.getParent());
    }

}
