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



        //京东
        String jd = null;
        Integer jdOneDayCount = testResultDao.jdOneDayCount(jd);
        String jdMinimumTimeCount = testResultDao.jdMinimumTimeCount(jd);
        Integer jdTwoDayCount = testResultDao.jdTwoDayCount(jd);
        double jddouble = 1.0 * (jdOneDayCount - jdTwoDayCount) / jdTwoDayCount * 100;
        Double jdMoMCount = Double.valueOf(String.format("%.2f", jddouble));

        //拼多多
        String pdd = null;
        Integer pddOneDayCount = testResultDao.pddOneDayCount(pdd);
        String pddMinimumTimeCount = testResultDao.pddMinimumTimeCount(pdd);
        Integer pddTwoDayCount = testResultDao.pddTwoDayCount(pdd);
        double pdddouble = 1.0 * (pddOneDayCount - pddTwoDayCount) / pddTwoDayCount * 100;
        Double pddMoMCount = Double.valueOf(String.format("%.2f", pdddouble));
        System.out.println(pddMoMCount);

        //苏宁
        String suning = null;
        Integer suningOneDayCount = testResultDao.suningOneDayCount(suning);
        String suningMinimumTimeCount = testResultDao.suningMinimumTimeCount(suning);
        Integer suningTwoDayCount = testResultDao.suningTwoDayCount(suning);
        double suningdouble = 1.0 * (suningOneDayCount - suningTwoDayCount) / suningTwoDayCount * 100;
        Double suningMoMCount = Double.valueOf(String.format("%.2f", suningdouble));
        System.out.println(suningMoMCount);


        //考拉
        String kaola = null;
        Integer kaolaOneDayCount = testResultDao.kaolaOneDayCount(kaola);
        String kaolaMinimumTimeCount = testResultDao.kaolaMinimumTimeCount(kaola);
        Integer kaolaTwoDayCount = testResultDao.kaolaTwoDayCount(kaola);
        double kaoladouble = 1.0 * (kaolaOneDayCount - kaolaTwoDayCount) / kaolaTwoDayCount * 100;
        Double kaolaMoMCount = Double.valueOf(String.format("%.2f", kaoladouble));
        System.out.println(kaolaMoMCount);


        //淘宝
        String tb = null;
        Integer tbOneDayCount = testResultDao.tbOneDayCount(tb);
        String tbMinimumTimeCount = testResultDao.tbMinimumTimeCount(tb);
        Integer tbTwoDayCount = testResultDao.tbTwoDayCount(tb);
        double tbdouble = 1.0 * (tbOneDayCount - tbTwoDayCount) / tbTwoDayCount * 100;
        Double tbMoMCount = Double.valueOf(String.format("%.2f", tbdouble));
        System.out.println(tbMoMCount);


        //得物
        String du = null;
        Integer duTwoDayCount = testResultDao.duTwoDayCount(du);
        String duMinimumTimeCount = testResultDao.duMinimumTimeCount(du);
        Integer duThreeDayCount = testResultDao.duThreeDayCount(du);
        double dudouble = 1.0 * (duTwoDayCount - duThreeDayCount) / duThreeDayCount * 100;
        Double duMoMCount = Double.valueOf(String.format("%.2f", dudouble));
        System.out.println(duMoMCount);


        //淘宝热销商品
        String tbsale = null;
        Integer tbsaleOneDayCount = testResultDao.tbsaleOneDayCount(tbsale);
        String tbsaleMinimumTimeCount = testResultDao.tbsaleMinimumTimeCount(tbsale);
        Integer tbsaleTwoDayCount = testResultDao.tbsaleTwoDayCount(tbsale);
        double tbsaledouble = 1.0 * (tbsaleOneDayCount - tbsaleTwoDayCount) / tbsaleTwoDayCount * 100;
        Double tbsaleMoMCount = Double.valueOf(String.format("%.2f", tbsaledouble));
        System.out.println(tbsaleMoMCount);



        //抖音热销商品
        String dysale = null;
        Integer dysaleOneDayCount = testResultDao.dysaleOneDayCount(dysale);
        String dysaleMinimumTimeCount = testResultDao.dysaleMinimumTimeCount(dysale);
        Integer dysaleTwoDayCount = testResultDao.dysaleTwoDayCount(dysale);
        double dysaledouble = 1.0 * (dysaleOneDayCount - dysaleTwoDayCount) / dysaleTwoDayCount * 100;
        Double dysaleMoMCount = Double.valueOf(String.format("%.2f", dysaledouble));
        System.out.println(dysaleMoMCount);

        int thirtythreshold = 30;
        int negativethirtythreshold = -30;
        int fiftythreshold = 50;
        int negativefiftythreshold = -50;

        if (jdMoMCount > negativefiftythreshold && jdMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">京东入库评论量昨日环比:"+ jdMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (jdMoMCount > thirtythreshold && jdMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">京东入库评论量昨日环比:"+ jdMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (jdMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">京东入库评论量昨日环比:"+ jdMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (jdMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">京东入库评论量昨日环比:"+ jdMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }


        //拼多多判断条件
        if (pddMoMCount > negativefiftythreshold && pddMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">拼多多入库商品量昨日环比:"+ pddMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (pddMoMCount > thirtythreshold && pddMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">拼多多入库商品量昨日环比:"+ pddMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (pddMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">拼多多入库商品量昨日环比:"+ pddMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (pddMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">拼多多入库商品量昨日环比:"+ pddMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }


        //苏宁判断条件
        if (suningMoMCount > negativefiftythreshold && suningMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">苏宁入库商品量昨日环比:"+ suningMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        else if (suningMoMCount > thirtythreshold && suningMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">苏宁入库商品量昨日环比:"+ suningMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (suningMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">苏宁入库商品量昨日环比:"+ suningMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (suningMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">苏宁入库商品量昨日环比:"+ suningMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }


       //考拉判断条件
        if (kaolaMoMCount > negativefiftythreshold && kaolaMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">考拉入库商品量昨日环比:"+ kaolaMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (kaolaMoMCount > thirtythreshold && kaolaMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">考拉入库商品量昨日环比:"+ kaolaMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (kaolaMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">考拉入库商品量昨日环比:"+ kaolaMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (kaolaMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">考拉入库商品量昨日环比:"+ kaolaMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }



       //淘宝判断条件
        if (tbMoMCount > negativefiftythreshold && tbMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (tbMoMCount > thirtythreshold && tbMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (tbMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (tbMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }



        //得物判断条件
        if (duMoMCount > negativefiftythreshold && duMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">得物入库商品量前日环比:"+ duMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (duMoMCount > thirtythreshold && duMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">得物入库商品量前日环比:"+ duMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (duMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">得物入库商品量前日环比:"+ duMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (duMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">得物入库商品量前日环比:"+ duMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }



        //淘宝热销商品判断条件
        if (tbsaleMoMCount > negativefiftythreshold && tbsaleMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbsaleMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (tbsaleMoMCount > thirtythreshold && tbsaleMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbsaleMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (tbsaleMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbsaleMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (tbsaleMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbsaleMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }




        //抖音热销商品判断条件
        if (dysaleMoMCount > negativefiftythreshold && dysaleMoMCount < negativethirtythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ dysaleMoMCount + "%" + "超过-30%</th></tr>").append("<br/>").append("<br/>");
        }
        if (dysaleMoMCount > thirtythreshold && dysaleMoMCount < fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ dysaleMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }

        if (dysaleMoMCount > fiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ dysaleMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }


        if (dysaleMoMCount < negativefiftythreshold) {
            content.append("<table border=\"5\" style=\"border:none 1px #FFFFFF;font-size=14px;;font-size:18px;\">");
            content.append("<tr style=\"color:#FF0000; font-size:20px\"><th align=\"center\">淘宝入库商品量昨日环比:"+ dysaleMoMCount + "%" + "超过-50%</th></tr>").append("<br/>").append("<br/>");
        }



        //京东html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">京东</th></tr>");
        content.append("<tr><th align=\"center\">前天入库的评论量</th><td align=\"center\">" + jdTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨天入库的评论量</th><td align=\"center\">" + jdOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + jdMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + jdMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //拼多多html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">拼多多</th></tr>");
        content.append("<tr><th align=\"center\">前天入库的商品量</th><td align=\"center\">" + pddTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨天入库的商品量</th><td align=\"center\">" + pddOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + pddMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + pddMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //苏宁html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">苏宁</th></tr>");
        content.append("<tr><th align=\"center\">前天入库的商品量</th><td align=\"center\">" + suningTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨天入库的商品量</th><td align=\"center\">" + suningOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + suningMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + suningMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //考拉html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">考拉</th></tr>");
        content.append("<tr><th align=\"center\">前天入库的商品量</th><td align=\"center\">" + kaolaTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨天入库的商品量</th><td align=\"center\">" + kaolaOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + kaolaMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + kaolaMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //淘宝html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">淘宝</th></tr>");
        content.append("<tr><th align=\"center\">前天入库的商品量</th><td align=\"center\">" + tbTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨天入库的商品量</th><td align=\"center\">" + tbOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + tbMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + tbMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");



        //得物html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">得物</th></tr>");
        content.append("<tr><th align=\"center\">前两天入库的商品量</th><td align=\"center\">" + duThreeDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">前天入库的商品量</th><td align=\"center\">" + duTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">前日环比</th><td align=\"center\">" + duMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + duMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //淘宝热销商品html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">淘宝热销商品</th></tr>");
        content.append("<tr><th align=\"center\">前天入库的数据量</th><td align=\"center\">" + tbsaleTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨天入库的数据量</th><td align=\"center\">" + tbsaleOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + tbsaleMoMCount + '%' + "</td></tr>");
        //content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + tbsaleMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");



        //抖音热销商品html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">抖音热销商品</th></tr>");
        content.append("<tr><th align=\"center\">前天入库的数据量</th><td align=\"center\">" + dysaleTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨天入库的数据量</th><td align=\"center\">" + dysaleOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">昨日环比</th><td align=\"center\">" + dysaleMoMCount + '%' + "</td></tr>");
        //content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + dysaleMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //发送邮件

        OhMyEmail.subject("数据源抓取量监控")
                .from("data source")
                .to("yanglei@kanda-data.com , yaokai@kanda-data.com")
                //.to("yaokai@kanda-data.com")
                .html(content.toString())
                .send();

    }
}


