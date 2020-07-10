import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.SQLException;


public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        try {

            JFrame jf = Chart1.transfer();
            Container content=jf.getContentPane();
            BufferedImage bi = new BufferedImage(jf.getWidth(),jf.getHeight(),BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bi.createGraphics();
            //将窗口内容面板输出到图形对象中
            content.printAll(g);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
            g.setColor(jf.getBackground());
            g.setColor(jf.getForeground());
            g.setFont(jf.getFont());
            g.fillRect(0, 0, jf.getWidth(), jf.getHeight());
            ServletOutputStream out = resp.getOutputStream();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(bi);
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


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
        File f=new File("D:\\Tomcat\\apache-tomcat-8.5.47\\webapps\\picture\\hello.jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放图形对象
        g2d.dispose();
    }

}
