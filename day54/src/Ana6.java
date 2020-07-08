import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana6 {
    public static String func() {
        double nProfit_2018 = 0;
        double nProfit_2019 = 0;
        double tAssets_2017 = 0;
        double tAssets_2018 = 0;
        double tAssets_2019 = 0;
        double sHE_2017 = 0;
        double sHE_2018 = 0;
        double sHE_2019 = 0;
        double oIncome_2017 = 0;
        double oIncome_2018 = 0;
        double oIncome_2019 = 0;


        try(Connection connection = DUtil.getConnection()) {
            String sql =  "select item,2017_amount,2018_amount,2019_amount from the_balance_sheet where item in(\"净利润\",\n" +
                    "\"资产总计\",\"股东权益合计\",\"营业收入\")";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                try(ResultSet r = ps.executeQuery()) {
                    while(r.next()) {
                        String s = r.getString(1);
                        if(s.equals("净利润")) {
                            nProfit_2018 = r.getDouble(3);
                            nProfit_2019 = r.getDouble(4);
                        } else if(s.equals("资产总计")) {
                            tAssets_2017 = r.getDouble(2);
                            tAssets_2018 = r.getDouble(3);
                            tAssets_2019 = r.getDouble(4);
                        } else if(s.equals("股东权益合计")) {
                            sHE_2017 = r.getDouble(2);
                            sHE_2018 = r.getDouble(3);
                            sHE_2019 = r.getDouble(4);
                        } else  {
                            oIncome_2017 = r.getDouble(2);
                            oIncome_2018 = r.getDouble(3);
                            oIncome_2019 = r.getDouble(4);
                        }
                    }
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
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
