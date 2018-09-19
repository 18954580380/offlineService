package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.SystemMenu;

import java.util.List;

/**
 * @author xdw
 */
public interface SystemMenuService {

    /**
     * 插入消息记录
     * @param menu
     * @return
     */
    int insertSelective(SystemMenu systemMenu);

    /**
     * 根据ID 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改 根据ID
     * @param menu
     * @return
     */
    int updateByPrimaryKey(SystemMenu systemMenu);

    @AutoPage
    List<SystemMenu> selectAll();

    SystemMenu selectByPrimaryKey(String id);
}
