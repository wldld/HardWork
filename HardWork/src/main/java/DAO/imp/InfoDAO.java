package DAO.imp;

import DAO.IInfoDAO;
import domain.Information;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class InfoDAO implements IInfoDAO{
    /**
     *默认构造函数
     */
    public InfoDAO(){

    }

    //该方法实现添加有一条信息到数据库中
    public void addInfo(Information info){
        DatabaseDAO myDB = new DatabaseDAO();

        String sql = "insert into information"+"(Title,Content,PublishingTime,PublishingUser,Type) values('"
                +info.getTitle()+"','"+info.getContent()+"','"
                +info.getPublishingtime()+"','"+info.getPublishinguser()+"','"+info.getType()+"')";

        System.out.println("sql语句 "+sql);
        try {
            myDB.executeSQL(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 该方法获取所有的信息表
     */
    public List<Information> getAllInfo(){
        String sql = "select * from information";
        return getInfoBySqlString(sql);
    }

    /**
     * 该方法通过执行一条查询的SQL语句来获取查询的结果，并把查询结果封装成信息列表返回。
     * @return list
     */
    public List<Information> getInfoBySqlString(String sql){
        List<Information> list= new ArrayList<>();
        DatabaseDAO myDB = new DatabaseDAO();
        try {
            ResultSet resultSet = myDB.getResultSet(sql);
            while (resultSet.next()){
                Information information = new Information();
                information.setId(resultSet.getInt("id"));
                information.setTitle(resultSet.getString("title"));
                information.setContent(resultSet.getString("content"));
                information.setPublishingtime(resultSet.getTimestamp("publishingtime"));
                information.setPublishinguser(resultSet.getString("publishinguser"));
                information.setType(resultSet.getString("type"));
                list.add(information);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                myDB.releaseConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //测试语句
//    public static void main(String[] args) {
//        Information information = new Information();
//        information.setId(1);
//        information.setTitle("Test");
//        information.setContent("Hello World");
//        information.setPublishinguser("yong");
//        information.setPublishingtime(new Timestamp(new java.util.Date().getTime()));
//        information.setType("runoob");
//        InfoDAO infoDAO = new InfoDAO();
//        infoDAO.addInfo(information);
//        List<Information> list = infoDAO.getAllInfo();
//        System.out.println(list);
//    }

}
