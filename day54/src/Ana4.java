import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana4 {
    public static String func() {
        double tAssets_2018 = 0;
        double tAssets_2019 = 0;
        double tLiabilities_2018 = 0;
        double tLiabilities_2019 = 0;
        try(Connection connection = DUtil.getConnection()) {
            String sql =  "select item,2018_amount,2019_amount from the_balance_sheet where item in( \"资产总计\",\"负债合计\")";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                try(ResultSet r = ps.executeQuery()) {
                    while(r.next()) {
                        String s = r.getString(1);
                        if(s.equals("资产总计")) {
                            tAssets_2018 = r.getDouble(2);
                            tAssets_2019 = r.getDouble(3);
                        } else {
                            tLiabilities_2018 = r.getDouble(2);
                            tLiabilities_2019 = r.getDouble(3);
                        }
                    }
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
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
