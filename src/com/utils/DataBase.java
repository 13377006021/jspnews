package com.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DataBase {
    private static String URL = null;
    private static String USER = null;
    private static String PASSWORD = null;
    static{
        InputStream in = DataBase.class.getClassLoader().getResourceAsStream("dbconfig.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            Class.forName((String) p.get("DRIVER"));
            URL = (String) p.get("URL");
            USER = (String) p.get("USER");
            PASSWORD = (String) p.get("PASSWORD");
        } catch (Exception e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }


    }
    public static Connection getConn() throws SQLException {
        Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        return connection;
    }

    public static void close(Connection conn, Statement st, ResultSet re){
        try {
            if(conn!=null){
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(st!=null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(re!=null) {
                        re.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
