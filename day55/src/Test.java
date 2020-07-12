import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet");

        //HSSFRow row = hssfSheet.createRow(0);
        //HSSFCell cell = row.createCell(0);
        //cell.setCellValue("test");
        String s = "duanqichangzhai_201000_2019";
        try(Connection connection = DUtil.getConnection()) {
            String sql = "select * from "+s;
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                try(ResultSet r = ps.executeQuery()) {
                    HSSFRow row = hssfSheet.createRow(0);
                    for (int i = 0; i < 4 ; i++) {
                        HSSFCell cell = row.createCell(i);
                        cell.setCellValue(r.getMetaData().getColumnName(i+1));
                        System.out.println(r.getMetaData().getColumnName(i+1));
                    }
                    int i = 1;
                    while(r.next()) {
                        HSSFRow row1 = hssfSheet.createRow(i);
                        HSSFCell cell = row1.createCell(0);
                        cell.setCellValue(r.getString(1));
                        System.out.println(r.getString(1));
                        HSSFCell cell1 = row1.createCell(1);
                        cell.setCellValue(r.getDouble(2));
                        HSSFCell cell2 = row1.createCell(2);
                        cell.setCellValue(r.getDouble(3));
                        HSSFCell cell3 = row1.createCell(3);
                        cell.setCellValue(r.getDouble(4));
                        HSSFCell cell4 = row1.createCell(4);
                        cell.setCellValue(r.getDouble(5));
                        HSSFCell cell5 = row1.createCell(5);
                        cell.setCellValue(r.getDouble(6));
                        i++;
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    }

