package service;

import domain.Information;

import java.util.List;

public interface IInfoService {
    //添加一条发布信息到数据库
    public void addInfo(Information information);

    //获取所有信息列表
    public List<Information> getAllInfo();
}
