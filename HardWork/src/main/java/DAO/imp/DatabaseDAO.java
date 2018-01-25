package DAO.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDAO {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/runoob?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String user = "root";
    private static String password = "123456";

    //获取数据库连接对象
    public static Connection getConnection() throws Exception{
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    //关闭数据库连接对象
    public static void releaseConnection(Connection connection) throws SQLException{
        if(!connection.isClosed()){
            connection.close();
        }
    }

//    public static void main(String[] args) throws Exception{
//        Connection connection = getConnection();
//        if(!connection.isClosed()){
//            System.out.println("successed connect to mysql");
//        }
//    }
}
