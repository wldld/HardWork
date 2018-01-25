package DAO;

import domain.Information;

import java.util.List;

public interface IInfoDAO {

    //该方法实现添加有一条信息到数据库中
    public void addInfo(Information info);

    //该方法获取所有的信息表
public List<Information> getAllInfo();

}
