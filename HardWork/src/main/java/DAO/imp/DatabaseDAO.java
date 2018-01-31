package DAO.imp;

import java.sql.*;

public class DatabaseDAO {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/runoob?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String user = "root";
    private static String password = "123456";

    public static Connection connection=null;

    //获取数据库连接对象
    public static Connection getConnection() throws Exception{
        Class.forName(driver);
        if (connection == null) {
            connection = DriverManager.getConnection(url,user,password);
        }
        return connection;
    }

    //关闭数据库连接对象
    public static void releaseConnection() throws SQLException{
        if(!connection.isClosed()){
            connection.close();
            connection = null;
        }
    }

    /**
     * 执行一个SQL查询语句，并返回查询的结果集
     * @param sql
     * @return resultSet
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ResultSet getResultSet(String sql) throws SQLException,ClassNotFoundException{
        System.out.println("SQL语句"+sql);
        if(connection == null ){
            try{
                this.connection = getConnection();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    /**
     * 直接执行一条对数据库修改（包括增删改）的SQL语句
     * @param sql
     * @throws SQLException
     */
    public void executeSQL(String sql) throws SQLException{
        if(connection == null){
            try {
                connection = getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        releaseConnection();
    }


}
