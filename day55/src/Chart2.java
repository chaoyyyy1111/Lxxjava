import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import javax.swing.*;

//这是柱形图的另一种效果，其实跟第一种相比都只有数据集发生了变化，再无其他变化
public class Chart2 {
    ChartPanel frame1;
    public Chart2(String title,String data1,String data2,String year,int miu) throws SQLException {
        CategoryDataset dataset = getDataSet(data1,data2,year,miu);
        JFreeChart chart = ChartFactory.createBarChart3D(
                title, // 图表标题
                "年度", // 目录轴的显示标签
                "比率", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,           // 是否显示图例(对于简单的柱状图必须是false)
                false,          // 是否生成工具
                false           // 是否生成URL链接
        );

        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

        //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题

        frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame

    }
    public Chart2(String title,String data1,String data2,String data3,String year,int miu) throws SQLException {
        CategoryDataset dataset = getDataSet(data1,data2,data3,year,miu);
        JFreeChart chart = ChartFactory.createBarChart3D(
                title, // 图表标题
                "年度", // 目录轴的显示标签
                "比率", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,           // 是否显示图例(对于简单的柱状图必须是false)
                false,          // 是否生成工具
                false           // 是否生成URL链接
        );

        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

        //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题

        frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame

    }
    private static CategoryDataset getDataSet(String data1,String data2,String year,int miu) throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try(Connection connection = DUtil.getConnection()) {
                String sql = "select item,a2015 from " +year+ " where item in(?,?)";
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
                        dataset.addValue(a/b, (miu-4)+"", (miu-4)+"");
                    }
                }
        }

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select item,a2016 from "+year+" where item in(?,?)";
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
                    dataset.addValue(a/b, (miu-3)+"", (miu-3)+"");
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
                    dataset.addValue(a/b, (miu-2)+"", (miu-2)+"");
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
                    dataset.addValue(a/b, (miu-1)+"", (miu-1)+"");
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
                    dataset.addValue(a/b, miu+"", miu+"");
                }
            }
        }
        return dataset;
    }
    private static CategoryDataset getDataSet(String data1,String data2,String data3,String year,int miu) throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try(Connection connection = DUtil.getConnection()) {
                String sql = "select item,a2015 from " +year+ " where item in(?,?,?)";
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
                        dataset.addValue((a+b)/c, (miu-4)+"", (miu-4)+"");
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
                    dataset.addValue((a+b)/c, (miu-3)+"", (miu-3)+"");
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
                    dataset.addValue((a+b)/c, (miu-2)+"", (miu-2)+"");
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
                    dataset.addValue((a+b)/c, (miu-1)+"", (miu-1)+"");
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
                    dataset.addValue((a+b)/c, miu+"", miu+"");
                }
            }
        }



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
        File f=new File("测试目录/长期偿债能力分析2.jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放图形对象
        g2d.dispose();
    }
    public static JFrame transfer(String year,int miu) throws SQLException {
        JFrame frame=new JFrame("长期偿债能力分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart5("资产负债率","负债合计","资产总计",year,miu).getChartPanel());
        frame.add(new Chart2("权益乘数","资产总计","股东权益合计",year,miu).getChartPanel());
        frame.add(new Chart2("产权比率","负债合计","股东权益合计",year,miu).getChartPanel());
        frame.add(new Chart2("利息保障倍数","利润总额","财务费用","财务费用",year,miu).getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        //savePic(frame);
        return frame;
    }
    /*public static void main(String[] args) throws SQLException {
        JFrame frame=new JFrame("长期偿债能力分析");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new Chart3("资产负债率","负债合计","资产总计").getChartPanel());
        frame.add(new Chart2("权益乘数","资产总计","股东权益合计").getChartPanel());
        frame.add(new Chart2("产权比率","负债合计","股东权益合计").getChartPanel());
        frame.add(new Chart2("利息保障倍数","利润总额","财务费用","财务费用").getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        savePic(frame);

    }

     */
}
