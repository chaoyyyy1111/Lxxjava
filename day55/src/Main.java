import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Main extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        int stock = Integer.parseInt(request.getParameter("astock"));
        int year =  Integer.parseInt(request.getParameter("ayear"));
        String item =  request.getParameter("item");
        InputStream is = null;
        OutputStream os = null;
        try(Connection connection = DUtil.getConnection()) {
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

        try {
            response.setContentType("image/jpeg");
            os = response.getOutputStream();
            int num;
            byte buf[] = new byte[1024];

            while ((num = is.read(buf)) != -1) {
                os.write(buf, 0, num);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
