import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Chart7 {
    public static JFrame transfer(String year, int miu) throws SQLException {
        JFrame frame=new JFrame("短期偿债能力分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart2("流动比率","流动资产合计","流动负债合计",year,miu).getChartPanel());
        frame.add(new Chart2("速动比率","负存货","流动负债合计",year,miu).getChartPanel());
        frame.add(new Chart2("现金流量比率","经营活动现金流量","流动负债合计",year,miu).getChartPanel());
        frame.add(new Chart2("现金比率","货币资金","交易性金融资产","流动负债合计",year,miu).getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        //savePic(frame);
        return frame;
    }
}
