import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Main extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        int stock = Integer.parseInt(request.getParameter("astock"));
        int year =  Integer.parseInt(request.getParameter("ayear"));
        String item =  request.getParameter("item");
        //InputStream is = null;
        OutputStream os = null;
        String byear = "a"+stock;
        int num = year;
        JFrame jf = null;

        try {
            if(item.equals("比较资产负债表分析")) {
                jf = Chart1.transfer(byear,num);
            } else if(item.equals("比较利润表分析")) {
                jf = Chart6.transfer(byear,num);
            } else if(item.equals("短期偿债能力分析")) {
                jf = Chart7.transfer(byear,num);
            } else if(item.equals("长期偿债能力分析")) {
                jf = Chart2.transfer(byear,num);
            } else if(item.equals("营运能力分析")) {
                jf = Chart3.transfer(byear,num);
            } else if(item.equals("盈利能力分析")) {
                jf = Chart5.transfer(byear,num);
            } else {
                jf = Chart4.transfer(byear,num);
            }
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
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                ImageIO.write(img, "jpg", out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //释放图形对象
            byte[] buf = out.toByteArray();
            response.setContentType("image/jpeg");
            os = response.getOutputStream();
            os.write(buf);
            os.flush();
            g2d.dispose();

        } catch (SQLException | IOException e ) {
            e.printStackTrace();
        }
        /*try(Connection connection = DUtil.getConnection()) {
            String sql = "SELECT paper FROM picture WHERE astock = ? and ayear = ? and item = ? ";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,stock);
                ps.setInt(2,year);
                ps.setString(3,item);
                try(ResultSet r = ps.executeQuery()) {
                    if(r.next()) {
                        is = r.getBinaryStream(1);
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

         */

        /*try {
            response.setContentType("image/jpeg");
            os = response.getOutputStream();
            int num;
            byte[] buf = new byte[1024];

            while ((num = is.read(buf)) != -1) {
                os.write(buf, 0, num);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

    }


}
