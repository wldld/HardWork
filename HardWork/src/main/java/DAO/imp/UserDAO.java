package DAO.imp;

import DAO.IUserDAO;
import domain.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{

    //添加一个用户到数据库中
    public void addUser(User user){
        String sql = "insert into user(username,password,realname,gender,age,personalsignature) values('"
                +user.getUsername()+"','"+user.getPassword()+"','"+user.getRealname()+"','"+user.getGender()+"','"+user.getAge()+"','"+user.getPersonalSignature()+"')";
        DatabaseDAO myDB = new DatabaseDAO();
        try {
            myDB.executeSQL(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据用户编号获得用户信息，以User对象的形式返回，一行记录
    public User getUserById(int id){
        String sql = "select * from user where id = "+id+"";
        DatabaseDAO myDB = new DatabaseDAO();
        User user = new User();
        try {
            ResultSet resultSet = myDB.getResultSet(sql);
            if(resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getInt("age"));
                user.setPassword(resultSet.getString("password"));
                user.setPersonalSignature(resultSet.getString("personalsignature"));
                user.setRealname(resultSet.getString("realname"));
                user.setUsername(resultSet.getString("username"));
            }
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }catch (ClassNotFoundException cnfEx){
            cnfEx.printStackTrace();
        }finally {
            try {
                myDB.releaseConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    //根据用户名获取用户信息，以User对象返回,一行或多行记录
    public List<User> getUserByUserName(String userName){
        User user = new User();
        DatabaseDAO myDB = new DatabaseDAO();
        List<User> list= new ArrayList<>();
        String sql = "select * from user where username= '"+userName+"'";

        try {
            ResultSet resultSet = myDB.getResultSet(sql);
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRealname(resultSet.getString("realname"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getInt("age"));
                user.setPersonalSignature(resultSet.getString("personalsignature"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                myDB.releaseConnection();
            }catch (SQLException sqlEx){
                sqlEx.printStackTrace();
            }
        }
        return list;
    }
//测试代码1：测试以上的方法
//    public static void main(String[] args) {
//        User user = new User();
//        user.setUsername("yong");
//        user.setPassword("123456");
//        user.setRealname("Shay");
//        user.setAge(25);
//        user.setGender("helloWorld");
//        user.setPersonalSignature("HandsomeBoy!");
//        UserDAO userDAO = new UserDAO();
//        User user1 = new User();
//        List<User> list = null;
//        userDAO.addUser(user);
//        user1 = userDAO.getUserById(1);
//        System.out.println(user1);
//        list = userDAO.getUserByUserName("yong");
//        System.out.println(list);
//    }

    //测试代码2：测试connection被关闭后，怎么办？
//    public static void main(String[] args) {
//        DatabaseDAO databaseDAO = new DatabaseDAO();
//        Connection connection = null;
//        User user = new User();
//        try {
//            connection = databaseDAO.getConnection();
//            DatabaseDAO.releaseConnection();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
////            connection = null;
//            connection = databaseDAO.getConnection();
//            ResultSet resultSet = databaseDAO.getResultSet("select * from user where id = 1");
//            if(resultSet.next()){
//                user.setId(resultSet.getInt("id"));
//                user.setUsername(resultSet.getString("username"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
