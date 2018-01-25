package DAO;

import domain.User;

import java.util.List;

public interface IUserDAO {
    //添加一个用户到数据库中
    public void addUser(User user);

    //根据用户编号获得用户信息，以User对象的形式返回
    public User getUserById(String id);

    //根据用户名获取用户信息，以User对象返回
    public List<User> getUserByUserName(String userName);
}
