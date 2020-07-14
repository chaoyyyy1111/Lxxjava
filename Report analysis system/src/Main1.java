
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stock = Integer.parseInt(req.getParameter("astock"));
        int year =  Integer.parseInt(req.getParameter("ayear"));
        String item =  req.getParameter("item");
        String s = item+"_"+stock+"_"+year;
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet");

        //HSSFRow row = hssfSheet.createRow(0);
        //HSSFCell cell = row.createCell(0);
        //cell.setCellValue("test");

        try(Connection connection = DUtil.getConnection()) {
            String sql = "select * from "+s;
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                try(ResultSet r = ps.executeQuery()) {
                    HSSFRow row = hssfSheet.createRow(0);
                    for (int i = 0; i < 6 ; i++) {
                        HSSFCell cell = row.createCell(i);
                        cell.setCellValue(r.getMetaData().getColumnName(i+1));
                    }
                    int i = 1;
                    while(r.next()) {
                        HSSFRow row1 = hssfSheet.createRow(i);
                        HSSFCell cell = row1.createCell(0);
                        cell.setCellValue(r.getString(1));
                        HSSFCell cell1 = row1.createCell(1);
                        cell1.setCellValue(r.getDouble(2));
                        HSSFCell cell2 = row1.createCell(2);
                        cell2.setCellValue(r.getDouble(3));
                        HSSFCell cell3 = row1.createCell(3);
                        cell3.setCellValue(r.getDouble(4));
                        HSSFCell cell4 = row1.createCell(4);
                        cell4.setCellValue(r.getDouble(5));
                        HSSFCell cell5 = row1.createCell(5);
                        cell5.setCellValue(r.getDouble(6));
                        i++;
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setContentType("application/octet-stream; charset=iso-8859-1");
        StringBuffer contentDisposition = new StringBuffer("attachment; filename=\"");
        String name = s+".xls";
        String fileName = new String(name.getBytes("UTF-8"), "iso-8859-1");
        contentDisposition.append(fileName).append("\"");
        resp.setHeader("Content-disposition", contentDisposition.toString());
        ServletOutputStream out = resp.getOutputStream();
        try {
            hssfWorkbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}

