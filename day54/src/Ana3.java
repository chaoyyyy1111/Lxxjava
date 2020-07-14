import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana3 extends AnalysisServlet {
    public static String func() {
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>短期偿债能力分析</h1>");
        sb.append("<p>本年流动比率"+func1(cAssets_2019/cLiabilities_2019)+" "+
                func2(cAssets_2019/cLiabilities_2019,cAssets_2018/cLiabilities_2018)+"</p>");
        sb.append("<p>去年流动比率"+func1(cAssets_2018/cLiabilities_2018)+"</p>");
        sb.append("<p>本年速动比率"+func1((cAssets_2019-inventory_2019)/cLiabilities_2019)+" "+
                func2((cAssets_2019-inventory_2019)/cLiabilities_2019,(cAssets_2018-inventory_2018)/cLiabilities_2018)+"</p>");
        sb.append("<p>去年速动比率"+func1((cAssets_2018-inventory_2018)/cLiabilities_2018)+"</p>");
        if(cAssets_2019/cLiabilities_2019 > cAssets_2018/cLiabilities_2018
        && (cAssets_2019-inventory_2019)/cLiabilities_2019 > (cAssets_2018-inventory_2018)/cLiabilities_2018) {
            sb.append("注：<span style = color:red> 该公司短期长债能力整体有所提高。</span>");
        } else if(cAssets_2019/cLiabilities_2019 < cAssets_2018/cLiabilities_2018
                && (cAssets_2019-inventory_2019)/cLiabilities_2019 < (cAssets_2018-inventory_2018)/cLiabilities_2018) {
            sb.append("注：<span style = color:green> 该公司短期长债能力整体下降。</span>");
        } else {
            sb.append("注：<span style = color:green> 该公司短期长债能力没有明显提高。</span>");
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
