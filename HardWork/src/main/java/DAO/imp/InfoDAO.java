package DAO.imp;

import DAO.IInfoDAO;
import domain.Information;

import java.util.List;

public class InfoDAO implements IInfoDAO{
    public InfoDAO(){

    }

    //往数据库中添加信息
    public void addInfo(Information information){

        //初始化数据库访问类
        DatabaseDAO myDB = new DatabaseDAO();
        String sql = "insert into information"+
                "(Titile,Content,PublishingTime,PublishingUser,Type) values('"
                +information.getTitle()+"','"+information.getContent()+"','"
                +information.getPublishingtime()+"','"+information.getPublishuser()+"','"
                +information.getType()+"')";

        System.out.println("sql语句："+sql);

    }

    public List<Information> getAllInfo() {
        return null;
    }
}
