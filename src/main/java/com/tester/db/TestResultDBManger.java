package com.tester.db;

import java.sql.*;

public class TestResultDBManger{
    private static Connection conn = null;
    private  static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static Connection getConn() {
        String url = "jdbc:mysql://am-bp1274e57y5ql474b90650o.ads.aliyuncs.com:3306?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = (Connection) DriverManager.getConnection(url, "test_yaokai", "test_1018");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void close() {
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

}