package service.imp;

import DAO.IInfoDAO;
import DAO.imp.InfoDAO;
import domain.Information;
import service.IInfoService;

import java.util.List;

/**
 * Information类对应的业务逻辑类 提供业务逻辑操作
 */
public class InfoService implements IInfoService{

    /**
     * 定义IInfoDAO类型的属性，以实现InfoService和IInfoDAO实现类之间的协作
     */
    private IInfoDAO infoDAO=new InfoDAO();

    /**
     * 默认构造函数
     */
    public InfoService() {

    }

    //添加一条发布信息到数据库
    public void addInfo(Information information) {
        // 如果信息为空，则返回，无需添加
        if (information.getTitle() == null)
            return;
        // 信息ID不为空，说明该信息在数据库中已存在，不应该是添加而应该是更新
//        if(information.getId() != null){
//
//        }
        // 往数据库中添加信息
        infoDAO.addInfo(information);
    }

    //获取所有信息列表
    public List<Information> getAllInfo() {
        return infoDAO.getAllInfo();
    }
}
