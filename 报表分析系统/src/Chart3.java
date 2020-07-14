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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;

import javax.imageio.ImageIO;
import javax.swing.*;

//这是柱形图的另一种效果，其实跟第一种相比都只有数据集发生了变化，再无其他变化
public class Chart3 {
    ChartPanel frame1;
    public Chart3(String title,String data1,String data2,String year,int miu) throws SQLException {
        XYDataset xydataset = createDataset(title,data1,data2,year,miu);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title, "年度", "周转率",xydataset, true, true, true);
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
    public Chart3(String title,String data1,String data2,String data3,String year,int miu) throws SQLException {
        XYDataset xydataset = createDataset(title,data1,data2,data3,year,miu);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title, "年度", "周转率",xydataset, true, true, true);
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
    private static TimeSeries getTimeSeries(String title,String data1,String data2,String year,int miu) throws SQLException {
        TimeSeries timeseries = new TimeSeries(title,
                org.jfree.data.time.Year.class);
        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2015 from " +year+" where item in(?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    while(r.next()) {
                        if(r.getString("item").equals(data1)) {
                            a = r.getDouble("a2015");
                            System.out.println(a);
                        } else if(r.getString("item").equals(data2)) {
                            b = r.getDouble("a2015");
                            System.out.println(b);
                        }
                    }
                    timeseries.add(new Year(miu-4),a/b);
                }
            }
        }

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2016 from " +year+ " where item in(?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    while(r.next()) {
                        if(r.getString("item").equals(data1)) {
                            a = r.getDouble("a2016");
                            System.out.println(a);
                        } else if(r.getString("item").equals(data2)) {
                            b = r.getDouble("a2016");
                            System.out.println(b);
                        }
                    }
                    timeseries.add(new Year(miu-3),a/b);
                }
            }
        }

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2017 from "+year+" where item in(?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    while(r.next()) {
                        if(r.getString("item").equals(data1)) {
                            a = r.getDouble("a2017");
                            System.out.println(a);
                        } else if(r.getString("item").equals(data2)) {
                            b = r.getDouble("a2017");
                            System.out.println(b);
                        }
                    }
                    timeseries.add(new Year(miu-2),a/b);
                }
            }
        }

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2018 from "+year+" where item in(?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    while(r.next()) {
                        if(r.getString("item").equals(data1)) {
                            a = r.getDouble("a2018");
                            System.out.println(a);
                        } else if(r.getString("item").equals(data2)) {
                            b = r.getDouble("a2018");
                            System.out.println(b);
                        }
                    }
                    timeseries.add(new Year(miu-1),a/b);
                }
            }
        }

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2019 from "+year+" where item in(?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    while(r.next()) {
                        if(r.getString("item").equals(data1)) {
                            a = r.getDouble("a2019");
                            System.out.println(a);
                        } else if(r.getString("item").equals(data2)) {
                            b = r.getDouble("a2019");
                            System.out.println(b);
                        }
                    }
                    timeseries.add(new Year(miu),a/b);
                }
            }
        }
        return timeseries;
    }
    private static TimeSeries getTimeSeries(String title,String data1,String data2,String data3,String year,int miu) throws SQLException {
        TimeSeries timeseries = new TimeSeries(title,
                org.jfree.data.time.Year.class);
        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2015 from "+year+" where item in(?,?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                ps.setString(3,data3);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    double c = 0.0;
                    while(r.next()) {
                        if(r.getString(1).equals(data3)) {
                            c = r.getDouble(2);
                        } else if(r.getString(1).equals(data2)) {
                            b = r.getDouble(2);
                        } else {
                            a = r.getDouble(2);

                        }

                    }
                    timeseries.add(new Year(miu-4),(a+b)/c);
                }
            }
        }

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2016 from "+year+" where item in(?,?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                ps.setString(3,data3);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    double c = 0.0;
                    while(r.next()) {
                        if(r.getString(1).equals(data3)) {
                            c = r.getDouble(2);
                        } else if(r.getString(1).equals(data2)) {
                            b = r.getDouble(2);
                        } else {
                            a = r.getDouble(2);

                        }

                    }
                    timeseries.add(new Year(miu-3),(a+b)/c);
                }
            }
        }
        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2017 from "+year+" where item in(?,?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                ps.setString(3,data3);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    double c = 0.0;
                    while(r.next()) {
                        if(r.getString(1).equals(data3)) {
                            c = r.getDouble(2);
                        } else if(r.getString(1).equals(data2)) {
                            b = r.getDouble(2);
                        } else {
                            a = r.getDouble(2);

                        }

                    }
                    timeseries.add(new Year(miu-2),(a+b)/c);
                }
            }
        }

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2018 from "+year+" where item in(?,?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                ps.setString(3,data3);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    double c = 0.0;
                    while(r.next()) {
                        if(r.getString(1).equals(data3)) {
                            c = r.getDouble(2);
                        } else if(r.getString(1).equals(data2)) {
                            b = r.getDouble(2);
                        } else {
                            a = r.getDouble(2);

                        }

                    }
                    timeseries.add(new Year(miu-1),(a+b)/c);
                }
            }
        }

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2019 from "+year+" where item in(?,?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,data1);
                ps.setString(2,data2);
                ps.setString(3,data3);
                try(ResultSet r = ps.executeQuery()) {
                    double a = 0.0;
                    double b = 0.0;
                    double c = 0.0;
                    while(r.next()) {
                        if(r.getString(1).equals(data3)) {
                            c = r.getDouble(2);
                        } else if(r.getString(1).equals(data2)) {
                            b = r.getDouble(2);
                        } else {
                            a = r.getDouble(2);

                        }

                    }
                    timeseries.add(new Year(miu),(a+b)/c);
                }
            }
        }



        return timeseries;
    }

    private static XYDataset createDataset(String title,String data1,String data2,String data3,String year,int miu) throws SQLException {  //这个数据集有点多，但都不难理解
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(getTimeSeries(title,data1,data2,data3,year,miu));
        return timeseriescollection;
    }
    private static XYDataset createDataset(String title,String data1,String data2,String year,int miu) throws SQLException {  //这个数据集有点多，但都不难理解
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(getTimeSeries(title,data1,data2,year,miu));
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
        File f=new File("测试目录/营运能力分析2.jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放图形对象
        g2d.dispose();
    }
    public static JFrame transfer(String year,int miu) throws SQLException {
        JFrame frame=new JFrame("营运能力分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart3("应收账款周转率","营业收入","平应收",year,miu).getChartPanel());
        frame.add(new Chart3("存货周转率","营业成本","平存货",year,miu).getChartPanel());
        frame.add(new Chart3("流动资产周转率","营业收入","平流动资产",year,miu).getChartPanel());
        frame.add(new Chart3("总资产周转率","营业收入","平资产",year,miu).getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        //savePic(frame);
        return frame;
    }
   /* public static void main(String[] args) throws SQLException {
        JFrame frame=new JFrame("营运能力分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart3("应收账款周转率","营业收入","平应收").getChartPanel());
        frame.add(new Chart3("存货周转率","营业成本","平存货").getChartPanel());
        frame.add(new Chart3("流动资产周转率","营业收入","平流动资产").getChartPanel());
        frame.add(new Chart3("总资产周转率","营业收入","平资产").getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        //frame.setVisible(true);
        //savePic(frame);

    }

    */
}
