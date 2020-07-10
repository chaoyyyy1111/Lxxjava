
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
    ChartPanel frame1;
    public Chart1(String title, String title1, String title2) throws SQLException {
        XYDataset xydataset = createDataset(title1,title2);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title, "年度", "比率(%)",xydataset, true, true, true);
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
    public Chart1(String title, String title1) throws SQLException {
        XYDataset xydataset = createDataset(title1);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title, "年度", "比率(%)",xydataset, true, true, true);
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

    private static TimeSeries getTimeSeries(String title) throws SQLException {
        TimeSeries timeseries = new TimeSeries(title+"变化率",
                org.jfree.data.time.Year.class);
        try(Connection connection = DUtil.getConnection()) {
            String sql = "select 2016_amount,2017_amount,2018_amount,2019_amount from a201000 where item = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,title);
                try(ResultSet r = ps.executeQuery()) {
                    if(r.next()) {
                        double tAssets_2016 = r.getDouble(1);
                        double tAssets_2017 = r.getDouble(2);
                        double tAssets_2018 = r.getDouble(3);
                        double tAssets_2019 = r.getDouble(4);
                        timeseries.add(new Year(2017),(tAssets_2016/tAssets_2017)*100D);
                        timeseries.add(new Year(2018),(tAssets_2017/tAssets_2018)*100D);
                        timeseries.add(new Year(2019),(tAssets_2018/tAssets_2019)*100D);
                    }
                }
            }
        }
        return timeseries;
    }
    private static XYDataset createDataset(String title1,String title2) throws SQLException {  //这个数据集有点多，但都不难理解
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(getTimeSeries(title1));
        timeseriescollection.addSeries(getTimeSeries(title2));
        return timeseriescollection;
    }
    private static XYDataset createDataset(String title1) throws SQLException {  //这个数据集有点多，但都不难理解
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(getTimeSeries(title1));
        return timeseriescollection;
    }
    public ChartPanel getChartPanel(){
        return frame1;

    }

    public static JFrame transfer() throws SQLException {
        JFrame frame=new JFrame("比较资产负债表分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart1("资产变化比率图","资产总计","流动资产合计").getChartPanel());
        frame.add(new Chart1("负债变化比率图","负债合计","流动负债合计").getChartPanel());
        frame.add(new Chart1("固定资产变化比率图","固定资产").getChartPanel());
        frame.add(new Chart1("股东权益变化比率图","股东权益合计").getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        return frame;
    }



    public static void main(String[] args) throws SQLException {
        JFrame frame=new JFrame("比较资产负债表分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart1("资产变化比率图","资产总计","流动资产合计").getChartPanel());
        frame.add(new Chart1("负债变化比率图","负债合计","流动负债合计").getChartPanel());
        frame.add(new Chart1("固定资产变化比率图","固定资产").getChartPanel());
        frame.add(new Chart1("股东权益变化比率图","股东权益合计").getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);


    }
}


