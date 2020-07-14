import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana6 extends AnalysisServlet {
    public static String func() {
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>盈利能力分析</h1>");
        sb.append("<p>本年资产净利率"+func1(nProfit_2019,tAssets_2018,tAssets_2019)+" "+
                func2(tmp(nProfit_2019,tAssets_2018,tAssets_2019),tmp(nProfit_2018,tAssets_2017,tAssets_2018))+"</p>");
        sb.append("<p>去年资产净利率"+func1(nProfit_2018,tAssets_2017,tAssets_2018)+"</p>");
        sb.append("<p>本年权益净利率"+func1(nProfit_2019,sHE_2018,sHE_2019)+" "+
                func2(tmp(nProfit_2019,sHE_2018,sHE_2019),tmp(nProfit_2018,sHE_2017,sHE_2018))+"</p>");
        sb.append("<p>去年权益净利率"+func1(nProfit_2018,sHE_2017,sHE_2018)+"</p>");
        sb.append("<p>本年营业净利率"+func3(nProfit_2019,oIncome_2019)+" "+
                func2(nProfit_2019/oIncome_2019,nProfit_2018/oIncome_2018)+"</p>");
        sb.append("<p>去年营业净利率"+func3(nProfit_2018,oIncome_2018)+"</p>");
        if(tmp(nProfit_2019,tAssets_2018,tAssets_2019) > tmp(nProfit_2018,tAssets_2017,tAssets_2018)) {
            sb.append("注：<span style = color:red>该公司的资产净利率有所提高，</span>");
        } else if(tmp(nProfit_2019,tAssets_2018,tAssets_2019) < tmp(nProfit_2018,tAssets_2017,tAssets_2018)) {
            sb.append("注：<span style = color:green>该公司的资产净利率有所下降，</span>");
        } else {
            sb.append("注：<span style = color:green>该公司的资产净利率没有明显变化，</span>");
        }
        if(tmp(nProfit_2019,sHE_2018,sHE_2019) > tmp(nProfit_2018,sHE_2017,sHE_2018)) {
            sb.append("<span style = color:red>权益净利率有所提高，</span>");
        } else if(tmp(nProfit_2019,sHE_2018,sHE_2019) < tmp(nProfit_2018,sHE_2017,sHE_2018)) {
            sb.append("<span style = color:green>权益净利率有所下降，</span>");
        } else {
            sb.append("<span style = color:green>权益净利率没有明显变化，</span>");
        }
        if(nProfit_2019/oIncome_2019 > nProfit_2018/oIncome_2018) {
            sb.append("<span style = color:red>营业净利率有所提高。</span>");
        } else if(nProfit_2019/oIncome_2019 < nProfit_2018/oIncome_2018) {
            sb.append("<span style = color:green>营业净利率有所下降。</span>");
        } else {
            sb.append("<span style = color:green>营业净利率没有明显变化。</span>");
        }
        return sb.toString();
    }
    private static String func1(double a,double b,double c) {
        DecimalFormat df = new DecimalFormat("#.00");
        double tmp = (b + c)/2;
        double n = (a/tmp)*100;
        String s = df.format(n)+"%";
        return s;
    }
    private static String func3 (double a,double b) {
        DecimalFormat df = new DecimalFormat("#.00");
        double n = (a/b)*100;
        String s = df.format(n)+"%";
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
    private static double tmp(double a,double b,double c) {
        double tmp = (b + c)/2;
        return (a/tmp)*100;
    }
}
