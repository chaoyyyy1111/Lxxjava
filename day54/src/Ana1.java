import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Ana1 extends AnalysisServlet  {
public static String func() {
    StringBuffer sb = new StringBuffer();
    sb.append("<h1>比较资产负债表分析</h1>");
    sb.append("<p>本年总资产变化率"+func1(tAssets_2018,tAssets_2019)+" "+
            func2(tmp(tAssets_2018,tAssets_2019),tmp(tAssets_2017,tAssets_2018))+"</p>");
    sb.append("<p>去年总资产变化率"+func1(tAssets_2017,tAssets_2018)+"</p>");
    sb.append("<p>本年流动资产变化率"+func1(cAssets_2018,cAssets_2019)+" "+
            func2(tmp(cAssets_2018,cAssets_2019),tmp(cAssets_2017,cAssets_2018))+"</p>");
    sb.append("<p>去年流动资产变化率"+func1(cAssets_2017,cAssets_2018)+"</p>");
    sb.append("<p>本年固定资产变化率"+func1(fAssets_2018,fAssets_2019)+" "+
            func2(tmp(fAssets_2018,fAssets_2019),tmp(fAssets_2017,fAssets_2018))+"</p>");
    sb.append("<p>去年固定资产变化率"+func1(fAssets_2017,fAssets_2018)+"</p>");
    sb.append("<p>本年负债总额变化率"+func1(tLiabilities_2018,tLiabilities_2019)+" "+
            func2(tmp(tLiabilities_2018,tLiabilities_2019),tmp(tLiabilities_2017,tLiabilities_2018))+"</p>");
    sb.append("<p>去年负债总额变化率"+func1(tLiabilities_2017,tLiabilities_2018)+"</p>");
    sb.append("<p>本年流动负债变化率"+func1(cLiabilities_2018,cLiabilities_2019)+" "+
            func2(tmp(cLiabilities_2018,cLiabilities_2019),tmp(cLiabilities_2017,cLiabilities_2018))+"</p>");
    sb.append("<p>去年流动负债变化率"+func1(cLiabilities_2017,cLiabilities_2018)+"</p>");
    sb.append("<p>本年股东权益变化率"+func1(sHE_2018,sHE_2019)+" "+
            func2(tmp(sHE_2018,sHE_2019),tmp(sHE_2017,sHE_2018))+"</p>");
    sb.append("<p>去年股东权益变化率"+func1(sHE_2017,sHE_2018)+"</p>");
    if((fAssets_2019-fAssets_2018)*1.0/fAssets_2018 < 0) {
        sb.append("注：<span style = color:green>固定资产增长速度小于0，该企业有收缩趋势；</span>");
    }
    if((fAssets_2019-fAssets_2018)*1.0/fAssets_2018 > (cAssets_2019-cAssets_2018)*1.0/cAssets_2018 &&
            (fAssets_2019-fAssets_2018)*1.0/fAssets_2018 >= 0 ) {
        sb.append("注：<span style = color:red>固定资产增长速度大于流动资产，该企业有扩张趋势；</span>");
    } else if((fAssets_2019-fAssets_2018)*1.0/fAssets_2018 < (cAssets_2019-cAssets_2018)*1.0/cAssets_2018 &&
            (fAssets_2019-fAssets_2018)*1.0/fAssets_2018 >= 0){
        sb.append("注：<span style = color:green>固定资产增长速度小于流动资产，该企业不具有扩张趋势；</span>");
    } else if((fAssets_2019-fAssets_2018)*1.0/fAssets_2018 == (cAssets_2019-cAssets_2018)*1.0/cAssets_2018 &&
            (fAssets_2019-fAssets_2018)*1.0/fAssets_2018 >= 0) {
        sb.append("注：<span style = color:green>固定资产增长速度等于流动资产，该企业不具有扩张趋势；</span>");
    }
    if((tLiabilities_2019-tLiabilities_2018)*1.0/tLiabilities_2018 > (tAssets_2019-tAssets_2018)*1.0/tAssets_2018 ) {
        sb.append("<span style = color:green>总负债的变化率大于总资产，具有财务风险；</span>");
    } else if((tLiabilities_2019-tLiabilities_2018)*1.0/tLiabilities_2018 < (tAssets_2019-tAssets_2018)*1.0/tAssets_2018) {
        sb.append("<span style = color:red>总负债的变化率小于总资产，不具有财务风险；</span>");
    } else {
        sb.append("<span style = color:red>总负债的变化率等于总资产，不具有财务风险；</span>");
    }
    if((sHE_2019-sHE_2018)*1.0/sHE_2018 > (tAssets_2019-tAssets_2018)*1.0/tAssets_2018
    && (sHE_2018-sHE_2017)*1.0/sHE_2017 > (tAssets_2018-tAssets_2017)*1.0/tAssets_2017) {
        sb.append("<span style = color:red>去年和今年连续两年股东权益的增长速度均超过各年资产的增长速度，说明财务状况比较稳定。</span>");
    } else if((sHE_2019-sHE_2018)*1.0/sHE_2018 < (tAssets_2019-tAssets_2018)*1.0/tAssets_2018
            && (sHE_2018-sHE_2017)*1.0/sHE_2017 < (tAssets_2018-tAssets_2017)*1.0/tAssets_2017) {
        sb.append("<span style = color:green>去年和今年连续两年股东权益的增长速度均低于各年资产的增长速度，说明财务状况不稳定。</span>");
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
