package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.SystemMenu;
import cn.koboro.offlineservice.repository.SystemMenuMapper;
import cn.koboro.offlineservice.service.SystemMenuService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xdw
 */
@Service
public class MenuServiceImpl implements SystemMenuService {

    @Resource
    private SystemMenuMapper menuMapper;

    @Override
    public int insertSelective(SystemMenu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(SystemMenu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    @AutoPage
    public List<SystemMenu> selectAll() {
        Condition condition = menuMapper.getCondition();
        condition.createCriteria().andNotEqualTo("isDel", -1);
        return menuMapper.selectByExample(condition);
    }

    @Override
    public SystemMenu selectByPrimaryKey(String id) {
        return menuMapper.selectByPrimaryKey(id);
    }

}
