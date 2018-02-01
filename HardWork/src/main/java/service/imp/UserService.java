package service.imp;


import DAO.IUserDAO;
import DAO.imp.UserDAO;
import domain.User;
import service.IUserService;

import java.util.List;


/**
 * 用户服务类，用来处理业务逻辑
 */
public class UserService implements IUserService {

    /**
     * 定义IUserDAO类型的属性，以实现UserService和IUserDAO实现类之间的协作
     */
    //为什么这么做？
    private IUserDAO userDAO = new UserDAO();

    /**
     * 默认构造函数
     */
    public UserService(){

    }


    /**
     * 添加注册用户信息到数据库，若用户名不存在则添加，否则不添加
     * @param user
     */
    public void addUser(User user){
        // 如果用户为空，则返回，无需添加
        if (user.getUsername() == null)
            return;
        // 获得用户名
        String userName = user.getUsername();
        // 从数据库中查询用户名为userName的用户
        List<User> users = userDAO.getUserByUserName(userName);
        // 如果返回的用户记录数目小于等于0，说明该用户名不存在
        if (users.size() <= 0) {
            // 往数据库中添加用户
            userDAO.addUser(user);
        } else {
            // 抛出异常
            throw new RuntimeException("该用户名已存在，请更换用户名！");
        }
    }


    //根据用户编号获取用户信息
    public User getUserByID(int id){
        // 如果id为空，则返回
        if (id <= 0)
            return null;
        return userDAO.getUserById(id);
    }

    //验证用户登录名和密码是否合法
    public User validateUser(String userName, String password){
        //调用数据访问方法获取用户名对应的用户信息
        List<User> users = userDAO.getUserByUserName(userName);
        if (users != null && users.size() != 0){
            if (users.get(0).getPassword().equals(password)) {
                //如果用户名和密码合法，则返回用户的完整信息，否则返回null
                return users.get(0);
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    //验证用户名是否已经存在
    public boolean isUserExist(String userName) {
        List<User> users = userDAO.getUserByUserName(userName);
        if(users.size()!=0)
            return true;
        else
            return false;
    }
}
