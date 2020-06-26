import java.io.File;

public class scanDirDepth {
    public static void func(File file,int count) {
        for(int i = 0;i < count;i++) {
            System.out.print("    ");
        }
        count++;
        System.out.println(file.getAbsolutePath()+"\\\\");
        File[] files = file.listFiles();
        if(files == null) {
            return;
        }
        for (File f:files) {
            if(f.isDirectory()) {
                func(f,count);
            } else {
                for(int i = 0;i < count;i++) {
                    System.out.print("    ");
                }
                System.out.println(f.getAbsolutePath());
            }
        }
    }
    public static void main(String[] args) {
        String path = "测试目录";
        File file = new File(path);
        func(file,0);
    }
}

