package blog;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String> featureList = new ArrayList<>();
    public static List<Action> actionsList = new ArrayList<>();
    private static void initFeatureList() {
        featureList.add("用户注册");
        featureList.add("用户登录");
        featureList.add("查看文章列表-按照发表时间倒序给出");
        featureList.add("发表文章-要求先登录");
        featureList.add("查看指定文章内容");
        featureList.add("评论指定文章-要求先登录");
        featureList.add("点赞指定文章-要求先登录");
    }
    private static void initActionsList() {
        actionsList.add(new UserRegisterAction());
        actionsList.add(new userLoginAction());
        actionsList.add(new ArticleListAction());
        actionsList.add(new ArticlePublishAction());
        actionsList.add(new ArticleDetailAction());
        actionsList.add(new ArticleCommentAction());
        actionsList.add(new ArticleLike_relationAction());
    }
    public static void main(String[] args) throws SQLException {
        DBUtil.initDataSource();
        Scanner scan = new Scanner(System.in);
         initFeatureList();
         initActionsList();
         while(true) {
             showMenu();
             System.out.print("请输入功能的序号> ");
             int select = scan.nextInt();
             if(select == 0) {
                 System.out.println("欢迎下次再来");
                 System.exit(0);
             }
             if(select - 1 < actionsList.size()) {
                 actionsList.get(select-1).run();
             } else {
                 System.out.println("还没有该项功能");
             }
         }

    }

    private static void showMenu() {
        for (int i = 0; i < featureList.size() ; i++) {
            System.out.println(i + 1+"  "+featureList.get(i));
        }
        System.out.println(0+"  "+"退出");
    }

}
