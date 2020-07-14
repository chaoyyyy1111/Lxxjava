import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana2 extends AnalysisServlet {
    public static String func() {
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>比较利润表分析</h1>");
        sb.append("<p>本年营业收入变化率"+func1(oIncome_2018,oIncome_2019)+" "+
                func2(tmp(oIncome_2018,oIncome_2019),tmp(oIncome_2017,oIncome_2018))+"</p>");
        sb.append("<p>去年营业收入变化率"+func1(oIncome_2017,oIncome_2018)+"</p>");
        sb.append("<p>本年营业成本变化率"+func1(oCost_2018,oCost_2019)+" "+
                func2(tmp(oCost_2018,oCost_2019),tmp(oCost_2017,oCost_2018))+"</p>");
        sb.append("<p>去年营业成本变化率"+func1(oCost_2017,oCost_2018)+"</p>");
        sb.append("<p>本年营业税金及附加变化率"+func1(bTS_2018,bTS_2019)+" "+
                func2(tmp(bTS_2018,bTS_2019),tmp(bTS_2017,bTS_2018))+"</p>");
        sb.append("<p>去年营业税金及附加变化率"+func1(bTS_2017,bTS_2018)+"</p>");
        sb.append("<p>本年销售费用变化率"+func1(cSales_2018,cSales_2019)+" "+
                func2(tmp(cSales_2018,cSales_2019),tmp(cSales_2017,cSales_2018))+"</p>");
        sb.append("<p>去年销售费用变化率"+func1(cSales_2017,cSales_2018)+"</p>");
        sb.append("<p>本年管理费用变化率"+func1(mFees_2018,mFees_2019)+" "+
                func2(tmp(mFees_2018,mFees_2019),tmp(mFees_2017,mFees_2018))+"</p>");
        sb.append("<p>去年管理费用变化率"+func1(mFees_2017,mFees_2018)+"</p>");
        sb.append("<p>本年财务费用变化率"+func1(fCharges_2018,fCharges_2019)+" "+
                func2(tmp(fCharges_2018,fCharges_2019),tmp(fCharges_2017,fCharges_2018))+"</p>");
        sb.append("<p>去年财务费用变化率"+func1(fCharges_2017,fCharges_2018)+"</p>");
        sb.append("<p>本年营业利润变化率"+func1(oProfit_2018,oProfit_2019)+" "+
                func2(tmp(oProfit_2018,oProfit_2019),tmp(oProfit_2017,oProfit_2018))+"</p>");
        sb.append("<p>去年营业利润变化率"+func1(oProfit_2017,oProfit_2018)+"</p>");
        sb.append("<p>本年利润总额变化率"+func1(pTotal_2018,pTotal_2019)+" "+
                func2(tmp(pTotal_2018,pTotal_2019),tmp(pTotal_2017,pTotal_2018))+"</p>");
        sb.append("<p>去年利润总额变化率"+func1(pTotal_2017,pTotal_2018)+"</p>");
        sb.append("<p>本年净利润变化率"+func1(nProfit_2018,nProfit_2019)+" "+
                func2(tmp(nProfit_2018,nProfit_2019),tmp(nProfit_2017,nProfit_2018))+"</p>");
        sb.append("<p>去年净利润变化率"+func1(nProfit_2017,nProfit_2018)+"</p>");
        boolean flag = false;
        if(tmp(oIncome_2018,oIncome_2019) > tmp(nProfit_2018,nProfit_2019)) {
            sb.append("注：<span style = color:green>该公司净利润的增速小于营业收入，</span>");
           if(tmp(oCost_2018,oCost_2019) > tmp(oCost_2017,oCost_2018)) {
               sb.append("<span style = color:green>是由于营业成本的增速过快，</span>");
               flag = true;
           }
           if(tmp(bTS_2018,bTS_2019) > tmp(bTS_2017,bTS_2018)) {
               sb.append("<span style = color:green>是由于营业税金及附加增速过快，</span>");
               flag = true;
            }
           if(tmp(cSales_2018,cSales_2019)>tmp(cSales_2017,cSales_2018)) {
               sb.append("<span style = color:green>是由于销售费用增速过快，</span>");
               flag = true;
           }
           if(tmp(mFees_2018,mFees_2019)>tmp(mFees_2017,mFees_2018)) {
               sb.append("<span style = color:green>是由于管理费用增速过快，</span>");
               flag = true;
           }
           if(tmp(fCharges_2018,fCharges_2019)>tmp(fCharges_2017,fCharges_2018)) {
               sb.append("<span style = color:green>是由于财务费用增速过快，</span>");
               flag = true;
           }
           if(!flag) {
               sb.append("<span style = color:green>是由于所得税费用增速过快，</span>");
           }
        } else if(tmp(oIncome_2018,oIncome_2019) < tmp(nProfit_2018,nProfit_2019)) {
            sb.append("注：<span style = color:red>该公司净利润的增速大于营业收入。</span>");
        } else {
            sb.append("注：<span style = color:red>该公司净利润的增速等于营业收入。</span>");
        }
        return sb.toString();
    }
    private static String func1(double tAssets_2018,double tAssets_2019) {
        DecimalFormat df = new DecimalFormat("#.00");
        double n = ((tAssets_2019-tAssets_2018)*1.0/tAssets_2018)*100;
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
    private static double tmp(double tAssets_2018,double tAssets_2019) {
        return ((tAssets_2019-tAssets_2018)*1.0/tAssets_2018)*100;
    }
}
