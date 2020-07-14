import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Chart4{
    ChartPanel frame1;
    public Chart4(String year) throws SQLException {
        DefaultPieDataset data = getDataSet(year);
        JFreeChart chart = ChartFactory.createPieChart3D("资本结构",data,true,false,false);
        //设置百分比
        PiePlot pieplot = (PiePlot) chart.getPlot();
        DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
        NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
        pieplot.setLabelGenerator(sp1);//设置饼图显示百分比

        //没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据显示");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);

        pieplot.setIgnoreNullValues(true);//设置不显示空值
        pieplot.setIgnoreZeroValues(true);//设置不显示负值
        frame1=new ChartPanel (chart,true);
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
        piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
    }
    private static DefaultPieDataset getDataSet(String year) throws SQLException {
        DefaultPieDataset dataset = new DefaultPieDataset();
        double tAssets = 0.0;
        double cAssets = 0.0;
        double tLiabilities = 0.0;
        double cLiabilities = 0.0;
        double sHE = 0.0;
        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2019 from " +year+ " where item in(\"资产总计\",\"流动资产合计\",\"负债合计\",\"流动负债合计\",\"股东权益合计\")";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                 try(ResultSet r = ps.executeQuery()) {
                     while(r.next()) {
                         if(r.getString(1).equals("资产总计")) {
                             tAssets = r.getDouble(2);
                         } else if(r.getString(1).equals("流动资产合计")) {
                             cAssets = r.getDouble(2);
                         } else if(r.getString(1).equals("负债合计")) {
                             tLiabilities = r.getDouble(2);
                         } else if(r.getString(1).equals("流动负债合计")) {
                             cLiabilities = r.getDouble(2);
                         } else {
                             sHE = r.getDouble(2);
                         }
                     }
                 }
             }
        }
        dataset.setValue("流动资产",cAssets);
        dataset.setValue("非流动资产",tAssets-cAssets);
        dataset.setValue("流动负债",cLiabilities);
        dataset.setValue("非流动负债",tLiabilities-cLiabilities);
        dataset.setValue("所有者权益",sHE);
        return dataset;
    }
    public ChartPanel getChartPanel(){
        return frame1;

    }
    public static void savePic(JFrame jf){
        //得到窗口内容面板
        Container content=jf.getContentPane();
        //创建缓冲图片对象
        BufferedImage img=new BufferedImage(
                jf.getWidth(),jf.getHeight(),BufferedImage.TYPE_INT_RGB);
        //得到图形对象
        Graphics2D g2d = img.createGraphics();
        //将窗口内容面板输出到图形对象中
        content.printAll(g2d);
        //保存为图片
        File f=new File("测试目录/发展能力分析与资本结构2.jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放图形对象
        g2d.dispose();
    }
    public static JFrame transfer(String year,int miu) throws SQLException {
        JFrame frame=new JFrame("发展能力分析与资本结构");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart1("销售与利润增长率","营业收入","利润总额",year,miu).getChartPanel());
        frame.add(new Chart1("资产与股权资本增长率","资产总计","股东权益合计",year,miu).getChartPanel());
        //frame.add(new Chart1("营业税金及附加与财务费用变化率图","营业税金及附加","财务费用").getChartPanel());
        frame.add(new Chart4(year).getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        return frame;
        //savePic(frame);
    }
    /*public static void main(String[] args) throws SQLException {
        JFrame frame=new JFrame("发展能力分析与资本结构");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart1("销售与利润增长率","营业收入","利润总额","a201000",2019).getChartPanel());
        frame.add(new Chart1("资产与股权资本增长率","资产总计","股东权益合计","a201000",2019).getChartPanel());
        //frame.add(new Chart1("营业税金及附加与财务费用变化率图","营业税金及附加","财务费用").getChartPanel());
        frame.add(new Chart4("a201000").getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        savePic(frame);

    }

     */



}
