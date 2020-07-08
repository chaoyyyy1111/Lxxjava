import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana3 {
    public static String func() {
        double cAssets_2018 = 0;
        double cAssets_2019 = 0;
        double cLiabilities_2018 = 0;
        double cLiabilities_2019 = 0;
        double inventory_2018 = 0;
        double inventory_2019 = 0;
        try(Connection connection = DUtil.getConnection()) {
            String sql =  "select item,2018_amount,2019_amount from the_balance_sheet where item in( \"流动资产合计\",\"流动负债合计\",\"存货\")";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                try(ResultSet r = ps.executeQuery()) {
                    while(r.next()) {
                        String s = r.getString(1);
                        if(s.equals("流动资产合计")) {
                            cAssets_2018 = r.getDouble(2);
                            cAssets_2019 = r.getDouble(3);
                        } else if(s.equals("流动负债合计")) {
                            cLiabilities_2018 = r.getDouble(2);
                            cLiabilities_2019 = r.getDouble(3);
                        } else {
                            inventory_2018 = r.getDouble(2);
                            inventory_2019 = r.getDouble(3);
                        }
                    }
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
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
