package DAO.imp;

import DAO.IInfoDAO;
import domain.Information;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoDAO implements IInfoDAO{
    public InfoDAO(){

    }

    //往数据库中添加信息
    public void addInfo(Information information){

        String sql = "insert into information"+
                "(Titile,Content,PublishingTime,PublishingUser,Type) values('"
                +information.getTitle()+"','"+information.getContent()+"','"
                +information.getPublishingtime()+"','"+information.getPublishuser()+"','"
                +information.getType()+"')";

        System.out.println("sql语句："+sql);
        try{
            crudDAO.executeSQL(sql); //调用增删改查，添加信息
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    /*
     *从数据库中获得所有信息
     */
    public List<Information> getAllInfo() {
        return null;
    }

    public List<Information> getInfoBySqlString(String sql){
        List<Information> information = new ArrayList<Information>();
        return  information;
    }
}
