package com.tester.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.tester.db.TestResultDBManger;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public class TestResultDao {

    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;


    //淘宝热销商品sql
    public Integer tbsaleTwoDayCount(String tbsale) throws SQLException {
        Integer i = null;
        String sql = "select count(number_id) as numb from ba.hotsale30days where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            i = rs.getInt("numb");
            System.out.println(rs.getInt("numb"));
        }
        return i;
    }

    public String tbsaleMinimumTimeCount(String tbsale) throws SQLException {
        String s = null;
        String sql = "select min(date) as date from ba.hotsale30days;";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            s = rs.getString("DATE");
            System.out.println(rs.getString("DATE"));
        }
        return s;
    }


    public Integer tbsaleThreeDayCount(String tbsale) throws SQLException {
        Integer i = null;
        String sql = "select count(number_id) as numb from ba.hotsale30days where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 3 DAY));";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            i = rs.getInt("numb");
            System.out.println(rs.getInt("numb"));
        }
        return i;
    }


    //抖音热销商品sql
    public Integer dysaleTwoDayCount(String dysale) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from ba.dy_hotsale30days where `date_time` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            i = rs.getInt("numb");
            System.out.println(rs.getInt("numb"));
        }
        return i;
    }

    public String dysaleMinimumTimeCount(String dysale) throws SQLException {
        String s = null;
        String sql = "select min(date_time) as date from ba.dy_hotsale30days;";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            s = rs.getString("DATE");
            System.out.println(rs.getString("DATE"));
        }
        return s;
    }


    public Integer dysaleThreeDayCount(String dysale) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from ba.dy_hotsale30days where `date_time` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 3 DAY));";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            i = rs.getInt("numb");
            System.out.println(rs.getInt("numb"));
        }
        return i;
    }


    //京东日销sql
    public Integer jdsaleTwoDayCount(String jdsale) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from ba.jd_product_day where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            i = rs.getInt("numb");
            System.out.println(rs.getInt("numb"));
        }
        return i;
    }

    public String jdsaleMinimumTimeCount(String jdsale) throws SQLException {
        String s = null;
        String sql = "select min(date) as date from ba.jd_product_day;";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            s = rs.getString("DATE");
            System.out.println(rs.getString("DATE"));
        }
        return s;
    }


    public Integer jdsaleThreeDayCount(String jdsale) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from ba.jd_product_day where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 3 DAY));";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            i = rs.getInt("numb");
            System.out.println(rs.getInt("numb"));
        }
        return i;
    }



    //苏宁日销sql
    public Integer suningsaleTwoDayCount(String suningsale) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from ba.suning_product_day where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            i = rs.getInt("numb");
            System.out.println(rs.getInt("numb"));
        }
        return i;
    }

    public String suningsaleMinimumTimeCount(String suningsale) throws SQLException {
        String s = null;
        String sql = "select min(date) as date from ba.suning_product_day;";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            s = rs.getString("DATE");
            System.out.println(rs.getString("DATE"));
        }
        return s;
    }


    public Integer suningsaleThreeDayCount(String suningsale) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from ba.suning_product_day where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 3 DAY));";
        conn = TestResultDBManger.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List list = new ArrayList();
        if (rs.next()){
            i = rs.getInt("numb");
            System.out.println(rs.getInt("numb"));
        }
        return i;
    }
}