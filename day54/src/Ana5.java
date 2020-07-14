import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana5 extends AnalysisServlet {
    public static String func() {
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>营运能力分析</h1>");
        sb.append("<p>本年应收账款周转率"+func1(oIncome_2019,aReceivable_2018,aReceivable_2019)+" "+
                func2(tmp(oIncome_2019,aReceivable_2018,aReceivable_2019),tmp(oIncome_2018,aReceivable_2017,aReceivable_2018))+"</p>");
        sb.append("<p>去年应收账款周转率"+func1(oIncome_2018,aReceivable_2017,aReceivable_2018)+"</p>");
        sb.append("<p>本年存货周转率"+func1(oCost_2019,inventory_2018,inventory_2019)+" "+
                func2(tmp(oCost_2019,inventory_2018,inventory_2019),tmp(oCost_2018,inventory_2017,inventory_2018))+"</p>");
        sb.append("<p>去年存货周转率"+func1(oCost_2018,inventory_2017,inventory_2018)+"</p>");
        sb.append("<p>本年总资产周转率"+func1(oIncome_2019,tAssets_2018,tAssets_2019)+" "+
                func2(tmp(oIncome_2019,tAssets_2018,tAssets_2019),tmp(oIncome_2018,tAssets_2017,tAssets_2018))+"</p>");
        sb.append("<p>去年总资产周转率"+func1(oIncome_2018,tAssets_2017,tAssets_2018)+"</p>");
        if(tmp(oIncome_2019,aReceivable_2018,aReceivable_2019) > tmp(oIncome_2018,aReceivable_2017,aReceivable_2018)) {
            sb.append("注：<span style = color:red>该公司的应收账款周转速度有所提高，</span>");
        } else if(tmp(oIncome_2019,aReceivable_2018,aReceivable_2019) < tmp(oIncome_2018,aReceivable_2017,aReceivable_2018)) {
            sb.append("注：<span style = color:green>该公司的应收账款周转速度有所下降，</span>");
        } else {
            sb.append("注：<span style = color:green>该公司的应收账款周转速度没有明显变化，</span>");
        }
        if(tmp(oCost_2019,inventory_2018,inventory_2019) > tmp(oCost_2018,inventory_2017,inventory_2018)) {
            sb.append("<span style = color:red>存货周转速度有所提高，说明该公司的销售具有良好的趋势，</span>");
        } else if(tmp(oCost_2019,inventory_2018,inventory_2019) < tmp(oCost_2018,inventory_2017,inventory_2018)) {
            sb.append("<span style = color:green>存货周转速度有所下降，说明该公司近期销售情况不太景气，</span>");
        } else {
            sb.append("<span style = color:green>存货周转速度没有明显变化，</span>");
        }
        if(tmp(oIncome_2019,tAssets_2018,tAssets_2019) > tmp(oIncome_2018,tAssets_2017,tAssets_2018)) {
            sb.append("<span style = color:red>总资产周转速度有所提高。</span>");
        } else if(tmp(oIncome_2019,tAssets_2018,tAssets_2019) < tmp(oIncome_2018,tAssets_2017,tAssets_2018)) {
            sb.append("<span style = color:green>总资产周转速度有所下降。</span>");
        } else {
            sb.append("<span style = color:green>总资产周转速度没有明显变化。</span>");
        }
        return sb.toString();
    }
    private static String func1(double a,double b,double c) {
        DecimalFormat df = new DecimalFormat("#.00");
        double tmp = (b + c)/2;
        double n = a/tmp;
        String s = df.format(n);
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
        return a/tmp;
    }
}
