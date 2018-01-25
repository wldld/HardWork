package DAO.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class crudDAO {
    static Connection connection = null;

    static {
        try {
            connection = DatabaseDAO.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param SQL查询语句
     * @return 数据库查询结果集
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    //此处为什么不像往常那样返回User,因为有多张表格，返回之不一定是user。
    public static ResultSet getResultSet(String sql) throws SQLException,ClassNotFoundException{
        System.out.println("SQL语句："+sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    /**
     * 直接执行一条对数据库修改（包括增删改）的SQL语句,然后释放连接
     * @param SQL增删改语句
     * @throws SQLException
     */
    public static void executeSQL(String sql) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        DatabaseDAO.releaseConnection(connection);
    }

}
