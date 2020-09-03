package com.tester.cases;


import com.tester.dao.TestResultDao;
import com.tester.utils.DateUtils;
import com.tester.utils.OhMyEmail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.GeneralSecurityException;
import java.util.*;

import static com.tester.utils.DateUtils.PATTERN_DAY;
import static com.tester.utils.OhMyEmail.SMTP_QQ;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Autowired
    private TestResultDao testResultDao;


    @Before
    public void before() throws GeneralSecurityException {


        OhMyEmail.config(SMTP_QQ(false), "yaokai@kanda-data.com", "join7Kc2KkWnpTbH");


    }

    @Test
    public void testSendAttach() throws Exception {
        StringBuffer content = new StringBuffer();


        content.append("<h1 font color =red>你好：</h1>").append("本日数据源抓取量监控：").append("<br/>").append("<br/>");
        String toDay = DateUtils.parseDate(new Date(), PATTERN_DAY);
        content.append("时间:").append(toDay).append("<br/>").append("<br/>");



        //淘宝热销商品
        String tbsale = null;
        Integer tbsaleTwoDayCount = testResultDao.tbsaleTwoDayCount(tbsale);
        String tbsaleMinimumTimeCount = testResultDao.tbsaleMinimumTimeCount(tbsale);
        Integer tbsaleThreeDayCount = testResultDao.tbsaleThreeDayCount(tbsale);
        double tbsaledouble = 1.0 * (tbsaleTwoDayCount - tbsaleThreeDayCount) / tbsaleThreeDayCount * 100;
        Double tbsaleMoMCount = Double.valueOf(String.format("%.2f", tbsaledouble));
        System.out.println(tbsaleMoMCount);



        //抖音热销商品
        String dysale = null;
        Integer dysaleTwoDayCount = testResultDao.dysaleTwoDayCount(dysale);
        String dysaleMinimumTimeCount = testResultDao.dysaleMinimumTimeCount(dysale);
        Integer dysaleThreeDayCount = testResultDao.dysaleThreeDayCount(dysale);
        double dysaledouble = 1.0 * (dysaleTwoDayCount - dysaleThreeDayCount) / dysaleThreeDayCount * 100;
        Double dysaleMoMCount = Double.valueOf(String.format("%.2f", dysaledouble));
        System.out.println(dysaleMoMCount);


        //京东日销
        String jdsale = null;
        Integer jdsaleTwoDayCount = testResultDao.jdsaleTwoDayCount(jdsale);
        String jdsaleMinimumTimeCount = testResultDao.jdsaleMinimumTimeCount(jdsale);
        Integer jdsaleThreeDayCount = testResultDao.tbsaleThreeDayCount(jdsale);
        double jdsaledouble = 1.0 * (jdsaleTwoDayCount - jdsaleThreeDayCount) / jdsaleThreeDayCount * 100;
        Double jdsaleMoMCount = Double.valueOf(String.format("%.2f", jdsaledouble));
        System.out.println(jdsaleMoMCount);



        //苏宁日销
        String suningsale = null;
        Integer suningsaleTwoDayCount = testResultDao.suningsaleTwoDayCount(suningsale);
        String suningsaleMinimumTimeCount = testResultDao.suningsaleMinimumTimeCount(suningsale);
        Integer suningsaleThreeDayCount = testResultDao.suningsaleThreeDayCount(suningsale);
        double suningsaledouble = 1.0 * (suningsaleTwoDayCount - suningsaleThreeDayCount) / suningsaleThreeDayCount * 100;
        Double suningsaleMoMCount = Double.valueOf(String.format("%.2f", suningsaledouble));
        System.out.println(suningsaleMoMCount);

        int thirtythreshold = 30;
        int negativethirtythreshold = -30;
        int fiftythreshold = 50;
        int negativefiftythreshold = -50;



        //淘宝热销商品判断条件
        if (tbsaleMoMCount > negativefiftythreshold && tbsaleMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝热销商品入库数据量昨日环比:"+ tbsaleMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (tbsaleMoMCount > thirtythreshold && tbsaleMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝热销商品入库数据量昨日环比:"+ tbsaleMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (tbsaleMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝热销商品入库数据量昨日环比:"+ tbsaleMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (tbsaleMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝热销商品入库数据量昨日环比:"+ tbsaleMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }




        //抖音热销商品判断条件
        if (dysaleMoMCount > negativefiftythreshold && dysaleMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">抖音热销商品入库数据量昨日环比:"+ dysaleMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (dysaleMoMCount > thirtythreshold && dysaleMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">抖音热销商品入库数据量昨日环比:"+ dysaleMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (dysaleMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">抖音热销商品入库数据量昨日环比:"+ dysaleMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (dysaleMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">抖音热销商品入库数据量昨日环比:"+ dysaleMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }



        //京东日销判断条件
        if (jdsaleMoMCount > negativefiftythreshold && jdsaleMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">京东日销入库数据量昨日环比:"+ jdsaleMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (jdsaleMoMCount > thirtythreshold && jdsaleMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">京东日销入库数据量昨日环比:"+ jdsaleMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (jdsaleMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">京东日销入库数据量昨日环比:"+ jdsaleMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (jdsaleMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">京东日销入库数据量昨日环比:"+ jdsaleMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }




        //苏宁日销判断条件
        if (suningsaleMoMCount > negativefiftythreshold && suningsaleMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">苏宁日销入库数据量昨日环比:"+ suningsaleMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (suningsaleMoMCount > thirtythreshold && suningsaleMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">苏宁日销入库数据量昨日环比:"+ suningsaleMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (suningsaleMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">苏宁日销入库数据量昨日环比:"+ suningsaleMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (suningsaleMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">苏宁日销入库数据量昨日环比:"+ suningsaleMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }

        //淘宝热销商品html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">淘宝热销商品</th></tr>");
        content.append("<tr><th align=\"center\">前两天入库的数据量</th><td align=\"center\">" + tbsaleThreeDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">前天入库的数据量</th><td align=\"center\">" + tbsaleTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + tbsaleMoMCount + '%' + "</td></tr>");
        //content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + tbsaleMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");



        //抖音热销商品html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">抖音热销商品</th></tr>");
        content.append("<tr><th align=\"center\">前两天入库的数据量</th><td align=\"center\">" + dysaleThreeDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">前天入库的数据量</th><td align=\"center\">" + dysaleTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + dysaleMoMCount + '%' + "</td></tr>");
        //content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + dysaleMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //京东日销html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">京东日销</th></tr>");
        content.append("<tr><th align=\"center\">前两天入库的数据量</th><td align=\"center\">" + jdsaleThreeDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">前天入库的数据量</th><td align=\"center\">" + jdsaleTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + jdsaleMoMCount + '%' + "</td></tr>");
        //content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + tbsaleMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");



        //苏宁日销html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">苏宁日销</th></tr>");
        content.append("<tr><th align=\"center\">前两天入库的数据量</th><td align=\"center\">" + suningsaleThreeDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">前天入库的数据量</th><td align=\"center\">" + suningsaleTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + suningsaleMoMCount + '%' + "</td></tr>");
        //content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + dysaleMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //发送邮件

        OhMyEmail.subject("数据源抓取量监控")
                .from("data ba")
                .to("yanglei@kanda-data.com , yaokai@kanda-data.com")
                //.to("yaokai@kanda-data.com")
                .html(content.toString())
                .send();

    }
}


