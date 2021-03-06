
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Chart1 {
    ChartPanel frame1;public Chart1(String title, String title1, String title2,String year,int miu) throws SQLException {
        XYDataset xydataset = createDataset(title1,title2,year,miu);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title, "年度", "变化率(%)",xydataset, true, true, true);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
        frame1=new ChartPanel(jfreechart,true);
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

    }
    public Chart1(String title, String title1,String year,int miu) throws SQLException {
        XYDataset xydataset = createDataset(title1,year,miu);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title, "年度", "变化率(%)",xydataset, true, true, true);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
        frame1=new ChartPanel(jfreechart,true);
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
    }
    public Chart1(String title, String title1,String title2,String title3,String year,int miu) throws SQLException {
        XYDataset xydataset = createDataset(title1,title2,title3,year,miu);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title, "年度", "增长率(%)",xydataset, true, true, true);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
        frame1=new ChartPanel(jfreechart,true);
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
    }
    public static double func(double a,double b) {
        return (b-a)/a;
    }
    private static TimeSeries getTimeSeries(String title,String year,int miu) throws SQLException {
        TimeSeries timeseries = new TimeSeries(title+"增长率",
                org.jfree.data.time.Year.class);
        try(Connection connection = DUtil.getConnection()) {
            String sql = "select a2014,a2015,a2016,a2017,a2018,a2019 from "+year+" where item = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,title);
                try(ResultSet r = ps.executeQuery()) {
                    if(r.next()) {
                        double tAssets_2014 = r.getDouble(1);
                        double tAssets_2015 = r.getDouble(2);
                        double tAssets_2016 = r.getDouble(3);
                        double tAssets_2017 = r.getDouble(4);
                        double tAssets_2018 = r.getDouble(5);
                        double tAssets_2019 = r.getDouble(6);
                        timeseries.add(new Year(miu-4),func(tAssets_2014,tAssets_2015)*100D);
                        timeseries.add(new Year(miu-3),func(tAssets_2015,tAssets_2016)*100D);
                        timeseries.add(new Year(miu-2),func(tAssets_2016,tAssets_2017)*100D);
                        timeseries.add(new Year(miu-1),func(tAssets_2017,tAssets_2018)*100D);
                        timeseries.add(new Year(miu),func(tAssets_2018,tAssets_2019)*100D);
                    }
                }
            }
        }
        return timeseries;
    }
    private static XYDataset createDataset(String title1,String title2,String title3,String year,int miu) throws SQLException {  //这个数据集有点多，但都不难理解
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(getTimeSeries(title1,year,miu));
        timeseriescollection.addSeries(getTimeSeries(title2,year,miu));
        timeseriescollection.addSeries(getTimeSeries(title3,year,miu));
        return timeseriescollection;
    }
    private static XYDataset createDataset(String title1,String title2,String year,int miu) throws SQLException {  //这个数据集有点多，但都不难理解
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(getTimeSeries(title1,year,miu));
        timeseriescollection.addSeries(getTimeSeries(title2,year,miu));
        return timeseriescollection;
    }
    private static XYDataset createDataset(String title1,String year,int miu) throws SQLException {  //这个数据集有点多，但都不难理解
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(getTimeSeries(title1,year,miu));
        return timeseriescollection;
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
        File f=new File("测试目录/比较资产负债表分析2.jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放图形对象
        g2d.dispose();
    }

    public static JFrame transfer(String year,int miu) throws SQLException {
        JFrame frame=new JFrame("比较资产负债表分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart1("资产变化率图","资产总计","流动资产合计",year,miu).getChartPanel());
        frame.add(new Chart1("负债变化率图","负债合计","流动负债合计",year,miu).getChartPanel());
        frame.add(new Chart1("固定资产变化率图","固定资产",year,miu).getChartPanel());
        frame.add(new Chart1("股东权益变化率图","股东权益合计",year,miu).getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        return frame;
    }
    /*public static void main(String[] args) throws SQLException {
        JFrame frame=new JFrame("比较资产负债表分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart1("资产变化率图","资产总计","流动资产合计").getChartPanel());
        frame.add(new Chart1("负债变化率图","负债合计","流动负债合计").getChartPanel());
        frame.add(new Chart1("固定资产变化率图","固定资产",).getChartPanel());
        frame.add(new Chart1("股东权益变化率图","股东权益合计").getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        //savePic(frame);

    }

     */
}


