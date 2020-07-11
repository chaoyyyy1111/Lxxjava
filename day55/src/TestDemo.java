import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDemo {
    public static void main(String[] args) {
        try(Connection connection = DUtil.getConnection()) {
            File f = new File("f:/比较资产负债表分析2.jpg");
            FileInputStream fis = new FileInputStream(f);
            String sql = "insert into picture values(?,?,?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, "比较资产负债表分析");
                ps.setInt(2, 201000);
                ps.setInt(3, 2018);
                ps.setBinaryStream(4,fis,(int)f.length());
                ps.executeUpdate();
            }
        } catch(SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
