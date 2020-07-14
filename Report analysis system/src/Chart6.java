import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Chart6 {
    public static JFrame transfer(String year, int miu) throws SQLException {
        JFrame frame=new JFrame("比较利润表分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart1("营业收入与成本变化率图","营业收入","营业成本",year,miu).getChartPanel());
        frame.add(new Chart1("营业税金及附加与财务费用变化率图","营业税金及附加","财务费用",year,miu).getChartPanel());
        frame.add(new Chart1("销售与管理费用变化率图","销售费用","管理费用",year,miu).getChartPanel());
        frame.add(new Chart1("净利润变化率图","营业利润","利润总额","净利润",year,miu).getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        return frame;
    }
}
