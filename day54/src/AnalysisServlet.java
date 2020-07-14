import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

public class AnalysisServlet extends HttpServlet {
    public static double tAssets_2017 = 0;
    public static double tAssets_2018 = 0;
    public static double tAssets_2019 = 0;
    public static double cAssets_2017 = 0;
    public static double cAssets_2018 = 0;
    public static double cAssets_2019 = 0;
    public static double fAssets_2017 = 0;
    public static double fAssets_2018 = 0;
    public static double fAssets_2019 = 0;
    public static double tLiabilities_2017 = 0;
    public static double tLiabilities_2018 = 0;
    public static double tLiabilities_2019 = 0;
    public static double cLiabilities_2017 = 0;
    public static double cLiabilities_2018 = 0;
    public static double cLiabilities_2019 = 0;
    public static double sHE_2017 = 0;
    public static double sHE_2018 = 0;
    public static double sHE_2019 = 0;
    public static double oIncome_2017 = 0;
    public static double  oIncome_2018 = 0;
    public static double oIncome_2019 = 0;
    public static double oCost_2017 = 0;
    public static double oCost_2018 = 0;
    public static double oCost_2019 = 0;
    public static double bTS_2017 = 0;
    public static double bTS_2018 = 0;
    public static double bTS_2019 = 0;
    public static double cSales_2017 = 0;
    public static double cSales_2018 = 0;
    public static double cSales_2019 = 0;
    public static double mFees_2017 = 0;
    public static double mFees_2018 = 0;
    public static double mFees_2019 = 0;
    public static double fCharges_2017 = 0;
    public static double fCharges_2018 = 0;
    public static double fCharges_2019 = 0;
    public static double oProfit_2017 = 0;
    public static double oProfit_2018 = 0;
    public static double oProfit_2019 = 0;
    public static double pTotal_2017 = 0;
    public static double pTotal_2018 = 0;
    public static double pTotal_2019 = 0;
    public static double nProfit_2017 = 0;
    public static double nProfit_2018 = 0;
    public static double nProfit_2019 = 0;
    public static double inventory_2017 = 0;
    public static double inventory_2018 = 0;
    public static double inventory_2019 = 0;
    public static double aReceivable_2017 = 0;
    public static double aReceivable_2018 = 0;
    public static double aReceivable_2019 = 0;
    public static final char[] chars = {'1','2','3','4','5','6','7','8','9','0'};
    //产生随机数
    public static Random random = new Random();
    public static String getRandomString(){
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i<5; i++)
        {
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        return buffer.toString();
    }
    /*获取随机的颜色*/
    public static Color getRandomColor()
    {
        return new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255));
    }
    /*返回某颜色的反色*/
    public static Color getReverseColor(Color c)
    {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalysisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
         tAssets_2017 = Double.parseDouble(req.getParameter("tAssets_2017"));
         tAssets_2018 = Double.parseDouble(req.getParameter("tAssets_2018"));
        tAssets_2019 = Double.parseDouble(req.getParameter("tAssets_2019"));
        cAssets_2017 = Double.parseDouble(req.getParameter("cAssets_2017"));
        cAssets_2018 = Double.parseDouble(req.getParameter("cAssets_2018"));
        cAssets_2019 = Double.parseDouble(req.getParameter("cAssets_2019"));
        fAssets_2017 = Double.parseDouble(req.getParameter("fAssets_2017"));
        fAssets_2018 = Double.parseDouble(req.getParameter("fAssets_2018"));
        fAssets_2019 = Double.parseDouble(req.getParameter("fAssets_2019"));
        tLiabilities_2017 = Double.parseDouble(req.getParameter("tLiabilities_2017"));
        tLiabilities_2018 = Double.parseDouble(req.getParameter("tLiabilities_2018"));
        tLiabilities_2019 = Double.parseDouble(req.getParameter("tLiabilities_2019"));
        cLiabilities_2017 = Double.parseDouble(req.getParameter("cLiabilities_2017"));
        cLiabilities_2018 = Double.parseDouble(req.getParameter("cLiabilities_2018"));
        cLiabilities_2019 = Double.parseDouble(req.getParameter("cLiabilities_2019"));
        sHE_2017 = Double.parseDouble(req.getParameter("sHE_2017"));
        sHE_2018 = Double.parseDouble(req.getParameter("sHE_2018"));
        sHE_2019 = Double.parseDouble(req.getParameter("sHE_2019"));
        oIncome_2017 = Double.parseDouble(req.getParameter("oIncome_2017"));
        oIncome_2018 = Double.parseDouble(req.getParameter("oIncome_2018"));
        oIncome_2019 = Double.parseDouble(req.getParameter("oIncome_2019"));
        oCost_2017 = Double.parseDouble(req.getParameter("oCost_2017"));
        oCost_2018 = Double.parseDouble(req.getParameter("oCost_2018"));
        oCost_2019 = Double.parseDouble(req.getParameter("oCost_2019"));
        bTS_2017 = Double.parseDouble(req.getParameter("bTS_2017"));
        bTS_2018 = Double.parseDouble(req.getParameter("bTS_2018"));
        bTS_2019 = Double.parseDouble(req.getParameter("bTS_2019"));
        cSales_2017 = Double.parseDouble(req.getParameter("cSales_2017"));
        cSales_2018 = Double.parseDouble(req.getParameter("cSales_2018"));
        cSales_2019 = Double.parseDouble(req.getParameter("cSales_2019"));
        mFees_2017 = Double.parseDouble(req.getParameter("mFees_2017"));
        mFees_2018 = Double.parseDouble(req.getParameter("mFees_2018"));
        mFees_2019 = Double.parseDouble(req.getParameter("mFees_2019"));
        fCharges_2017 = Double.parseDouble(req.getParameter("fCharges_2017"));
        fCharges_2018 = Double.parseDouble(req.getParameter("fCharges_2018"));
        fCharges_2019 = Double.parseDouble(req.getParameter("fCharges_2019"));
        oProfit_2017 = Double.parseDouble(req.getParameter("oProfit_2017"));
        oProfit_2018 = Double.parseDouble(req.getParameter("oProfit_2018"));
        oProfit_2019 = Double.parseDouble(req.getParameter("oProfit_2019"));
        pTotal_2017 = Double.parseDouble(req.getParameter("pTotal_2017"));
        pTotal_2018 = Double.parseDouble(req.getParameter("pTotal_2018"));
        pTotal_2019 = Double.parseDouble(req.getParameter("pTotal_2019"));
        nProfit_2017 = Double.parseDouble(req.getParameter("nProfit_2017"));
        nProfit_2018 = Double.parseDouble(req.getParameter("nProfit_2018"));
        nProfit_2019 = Double.parseDouble(req.getParameter("nProfit_2019"));
        inventory_2017 = Double.parseDouble(req.getParameter("inventory_2017"));
        inventory_2018 = Double.parseDouble(req.getParameter("inventory_2018"));
        inventory_2019 = Double.parseDouble(req.getParameter("inventory_2019"));
        aReceivable_2017 = Double.parseDouble(req.getParameter("aReceivable_2017"));
        aReceivable_2018 = Double.parseDouble(req.getParameter("aReceivable_2018"));
        aReceivable_2019 = Double.parseDouble(req.getParameter("aReceivable_2019"));

        String s = req.getParameter("choice");
        String ret = "";
        if(s.equals("1")) {
            ret = Ana1.func();
        } else if(s.equals("2")) {
            ret = Ana2.func();
        } else if(s.equals("3")) {
            ret = Ana3.func();
        } else if(s.equals("4")) {
            ret = Ana4.func();
        } else if(s.equals("5")) {
            ret = Ana5.func();
        } else if(s.equals("6")) {
            ret = Ana6.func();
        } else if(s.equals("7")) {
            ret = Ana7.func();
        }
        resp.setContentType("image/jpeg");
        /*随机字符串*/
        String randomString = getRandomString();
        /*将randomString放到session中*/
        req.getSession(true).setAttribute("randomString", randomString);
        /*设置图片的宽高*/
        int width = 100;
        int height = 30;
        /*随机颜色用于背景颜色，反色用于前景颜色*/
        Color color = getRandomColor();
        Color reverse = getReverseColor(color);
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 18, 20);
        for(int i = 0, n = random.nextInt(100); i <n; i++)
        {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }
        ServletOutputStream out = resp.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bi);
        out.close();



    }


}
