package com.tester.cases;


import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.tester.dao.TestResultDao;
import com.tester.utils.DateUtils;
import com.tester.utils.OhMyEmail;

import org.apache.ibatis.jdbc.Null;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.GeneralSecurityException;
import java.sql.ClientInfoStatus;
import java.text.DecimalFormat;
import java.util.*;

import static com.tester.utils.DateUtils.PATTERN_DAY;
import static com.tester.utils.DateUtils.reduceDays;
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


        content.append("<h1 font=red>你好：</h1>").append("本日数据源抓取量监控：").append("<br/>").append("<br/>");
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


        int thirtythreshold = 30;
        int fiftythreshold = 50;

        if (jddouble >= thirtythreshold  && jddouble <= fiftythreshold) {
            content.append("<tr style=\"font-size: 18px; color:#ff0000\"><th align=\"center\">京东入库评论量昨日环比:"+ jdMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }
        else if (jdMoMCount < fiftythreshold) {
            content.append("<tr style=\"font-size: 28px; color:#ff0000\"><th align=\"center\">京东入库评论量昨日环比:"+ jdMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }



        if (pdddouble >= thirtythreshold  && pdddouble <= fiftythreshold) {
            content.append("<tr style=\"font-size: 18px; color:#ff0000\"><th align=\"center\">拼多多入库商品量昨日环比:"+ pddMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }
        else if (pddMoMCount < fiftythreshold) {
            content.append("<tr style=\"font-size: 28px; color:#ff0000\"><th align=\"center\">拼多多入库商品量昨日环比:"+ pddMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }



        if (suningdouble >= thirtythreshold  && suningdouble <= fiftythreshold) {
            content.append("<tr style=\"font-size: 18px; color:#ff0000\"><th align=\"center\">苏宁入库商品量昨日环比:"+ suningMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }
        else if (suningMoMCount < fiftythreshold) {
            content.append("<tr style=\"font-size: 28px; color:#ff0000\"><th align=\"center\">苏宁入库商品量昨日环比:"+ suningMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }



        if (kaoladouble >= thirtythreshold  && kaoladouble <= fiftythreshold) {
            content.append("<tr style=\"font-size: 18px; color:#ff0000\"><th align=\"center\">考拉入库商品量昨日环比:"+ kaolaMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }
        else if (kaolaMoMCount > fiftythreshold) {
            content.append("<tr style=\"font-size: 28px; color:#ff0000\"><th align=\"center\">考拉入库商品量昨日环比:"+ kaolaMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }



        if (tbdouble >= thirtythreshold  && tbdouble <= fiftythreshold) {
            content.append("<tr style=\"font-size: 18px; color:#ff0000\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }
        else if (tbMoMCount > fiftythreshold) {
            content.append("<tr style=\"font-size: 28px; color:#ff0000\"><th align=\"center\">淘宝入库商品量昨日环比:"+ tbMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }



        if (dudouble >= thirtythreshold  && dudouble <= fiftythreshold) {
            content.append("<tr style=\"font-size: 18px; color:#ff0000\"><th align=\"center\">得物入库商品量前日环比:"+ duMoMCount + "%" + "超过30%</th></tr>").append("<br/>").append("<br/>");
        }
        else if (duMoMCount > fiftythreshold) {
            content.append("<tr style=\"font-size: 28px; color:#ff0000\"><th align=\"center\">得物入库商品量前日环比:"+ duMoMCount + "%" + "超过50%</th></tr>").append("<br/>").append("<br/>");
        }



        //京东html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">京东</th></tr>");
        content.append("<tr><th align=\"center\">前一天入库的评论量</th><td align=\"center\">" + jdOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">日环比</th><td align=\"center\">" + jdMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + jdMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //拼多多html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">拼多多</th></tr>");
        content.append("<tr><th align=\"center\">前一天入库的商品量</th><td align=\"center\">" + pddOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">日环比</th><td align=\"center\">" + pddMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + pddMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //苏宁html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">苏宁</th></tr>");
        content.append("<tr><th align=\"center\">前一天入库的商品量</th><td align=\"center\">" + suningOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">日环比</th><td align=\"center\">" + suningMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + suningMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //考拉html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">考拉</th></tr>");
        content.append("<tr><th align=\"center\">前一天入库的商品量</th><td align=\"center\">" + kaolaOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">日环比</th><td align=\"center\">" + kaolaMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + kaolaMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //淘宝html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">淘宝</th></tr>");
        content.append("<tr><th align=\"center\">前一天入库的商品量</th><td align=\"center\">" + tbOneDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">日环比</th><td align=\"center\">" + tbMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + tbMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");



        //得物html
        content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th align=\"center\">得物</th></tr>");
        content.append("<tr><th align=\"center\">前两天入库的商品量</th><td align=\"center\">" + duTwoDayCount + "</td></tr>");
        content.append("<tr><th align=\"center\">日环比</th><td align=\"center\">" + duMoMCount + '%' + "</td></tr>");
        content.append("<tr><th align=\"center\">平台表最小时间</th><td align=\"center\">" + duMinimumTimeCount + "</td></tr>");
        content.append("&nbsp;&nbsp;&nbsp;");
        content.append("</body></html>");


        //发送邮件

        OhMyEmail.subject("数据源抓取量监控")
                .from("yaokai")
                //.to("yanglei@kanda-data.com , yaokai@kanda-data.com")
                .to("yaokai@kanda-data.com")
                .html(content.toString())
                .send();

    }
}

