import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana4 extends AnalysisServlet {
    public static String func() {
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>长期偿债能力分析</h1>");
        sb.append("<p>本年资产负债率"+func1(tLiabilities_2019/tAssets_2019)+" "+
                func2(tLiabilities_2019/tAssets_2019,tLiabilities_2018/tAssets_2018)+"</p>");
        sb.append("<p>去年资产负债率"+func1(tLiabilities_2018/tAssets_2018)+"</p>");
        if(tLiabilities_2019/tAssets_2019 > tLiabilities_2018/tAssets_2018) {
            sb.append("注：<span style = color:green>该公司的长期偿债能力有所下降。</span>");
        } else if(tLiabilities_2019/tAssets_2019 < tLiabilities_2018/tAssets_2018) {
            sb.append("注：<span style = color:red>该公司的长期偿债能力有所提高。</span>");
        } else {
            sb.append("注：<span style = color:green>该公司的长期偿债能力没有明显变化。</span>");
        }
        return sb.toString();
    }
    private static String func1(double a) {
        DecimalFormat df = new DecimalFormat("#.00");
        String s = df.format(a)+"%";
        return s;
    }
    private static String func2(double a,double b) {
        if(a > b) {
            return "+";
        } else if(a < b) {
            return "-";
        } else {
            return "#";
        }
    }
}
