package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private String user ="root";
    private String password="mbkmbk";
    private String url= "jdbc:mysql://192.168.3.36:3306/runoob/";

    public Connection getConnection() throws Exception{
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection(url,user,password);

        System.out.println("HelloWorld");

        return connection;
    }

    public static void main(String[] args) throws Exception {
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getConnection();
    }
}
