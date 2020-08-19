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


    //京东sql
    public Integer jdOneDayCount(String jd) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from jd.jd_comment_count where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 1 DAY));";
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

    public String jdMinimumTimeCount(String jd) throws SQLException {
        String s = null;
        String sql = "select min(date) as DATE from jd.jd_comment_count;";
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


    public Integer jdTwoDayCount(String jd) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from jd.jd_comment_count where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
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


    //拼多多sql
    public Integer pddOneDayCount(String pdd) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from pdd.pdd_product_sale where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 1 DAY));";
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

    public String pddMinimumTimeCount(String pdd) throws SQLException {
        String s = null;
        String sql = "select min(date) as DATE from pdd.pdd_product_sale;";
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


    public Integer pddTwoDayCount(String pdd) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from pdd.pdd_product_sale where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
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

    //苏宁sql
    public Integer suningOneDayCount(String suning) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from suning.suning_product_history where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 1 DAY));";
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

    public String suningMinimumTimeCount(String suning) throws SQLException {
        String s = null;
        String sql = "select min(date) as DATE from suning.suning_product_history;";
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


    public Integer suningTwoDayCount(String suning) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from suning.suning_product_history where `date` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
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

    //考拉sql
    public Integer kaolaOneDayCount(String kaola) throws SQLException {
        Integer i = null;
        String sql = "select count(ID) as numb from kaola.kaola2_product_sale_data where `DATE_TIME` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 1 DAY));";
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

    public String kaolaMinimumTimeCount(String kaola) throws SQLException {
        String s = null;
        String sql = "select min(DATE_TIME) as DATE from kaola.kaola2_product_sale_data;";
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


    public Integer kaolaTwoDayCount(String kaola) throws SQLException {
        Integer i = null;
        String sql = "select count(ID) as numb from kaola.kaola2_product_sale_data where `DATE_TIME` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
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

    //淘宝sql
    public Integer tbOneDayCount(String tb) throws SQLException {
        Integer i = null;
        String sql = "select count(NUMBER_ID) as numb from tb.tb_product_day_sale where `DATE` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 1 DAY));";
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

    public String tbMinimumTimeCount(String tb) throws SQLException {
        String s = null;
        String sql = "select min(DATE) as DATE from tb.tb_product_day_sale;";
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


    public Integer tbTwoDayCount(String tb) throws SQLException {
        Integer i = null;
        String sql = "select count(NUMBER_ID) as numb from tb.tb_product_day_sale where `DATE` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
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


    //得物sql
    public Integer duTwoDayCount(String du) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from du.du_day_sale where `sale_time` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY));";
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

    public String duMinimumTimeCount(String du) throws SQLException {
        String s = null;
        String sql = "select min(sale_time) as DATE from du.du_day_sale;";
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


    public Integer duThreeDayCount(String du) throws SQLException {
        Integer i = null;
        String sql = "select count(product_id) as numb from du.du_day_sale where `sale_time` = CONCAT(DATE_SUB(CURDATE(), INTERVAL 3 DAY));";
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