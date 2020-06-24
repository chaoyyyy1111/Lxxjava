import java.io.File;

public class scanDir {
    public static void main(String[] args) {
        File root = new File("测试目录");

        scanDir(root);
    }

    /**
     * 保证 node 代表的一定是 目录
     * @param node
     */
    private static void scanDir(File node) {
        // 1. 先打印结点的绝对路径
        System.out.println(node.getAbsolutePath() + "\\");
        // 2. 获取结点的孩子结点
        File[] children = node.listFiles();
        if (children == null) {
            // 防御式编程：理论上不应该出现该情况的
            return;
        }

        // 3. 孩子中的普通文件，直接打印
        //    孩子中的目录，递归，进行深度遍历
        // 隐含的递归停止条件：children 的长度 == 0 的时候，下面的循环没有任何效果
        for (File child : children) {
            if (child.isDirectory()) {
                scanDir(child);
            } else if (child.isFile()) {
                System.out.println(child.getAbsolutePath());
            }
        }
    }
}

