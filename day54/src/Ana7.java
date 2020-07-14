import java.text.DecimalFormat;

public class Ana7 extends AnalysisServlet {
    public static String func() {
          double nOEquity_2019 = nProfit_2019/((sHE_2018+sHE_2019)/2);
          double nOEquity_2018 = nProfit_2018/((sHE_2017+sHE_2018)/2);
          double oNIR_2019 = nProfit_2019/((oIncome_2018+oIncome_2019)/2);
          double oNIR_2018 = nProfit_2019/((oIncome_2018+oIncome_2019)/2);
          double toAssets_2019 = oIncome_2019/((tAssets_2018+tAssets_2019)/2);
          double toAssets_2018 = oIncome_2019/((tAssets_2018+tAssets_2019)/2);
          double eMul_2019 = ((tAssets_2018+tAssets_2019)/2)/((sHE_2018+sHE_2019)/2);
          double eMul_2018 = ((tAssets_2018+tAssets_2019)/2)/((sHE_2018+sHE_2019)/2);

          double cONIR = oNIR_2019*toAssets_2018*eMul_2018 - nOEquity_2018;
          double cToAssets = oNIR_2019*toAssets_2019*eMul_2018 - oNIR_2019*toAssets_2018*eMul_2018;
          double ceMul = oNIR_2019*toAssets_2019*eMul_2019 - oNIR_2019*toAssets_2019*eMul_2018;

          StringBuffer sb = new StringBuffer();
          sb.append("<h1>杜邦分析</h1>");
          sb.append("<p>营业净利率变动对权益净利率的影响为"+func3(cONIR)+"</p>");
          sb.append("<p>总资产周转次数对权益净利率变动的影响为"+func3(cToAssets)+"</p>");
          sb.append("<p>权益乘数对权益净利率变动的影响为"+func3(ceMul)+"</p>");
          return sb.toString();

    }
    private static String func3 (double a) {
        DecimalFormat df = new DecimalFormat("#.00");
        double n = a*100;
        String s = df.format(n)+"%";
        return s;
    }
}
