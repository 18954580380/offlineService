
package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.Dict;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @author xdw
 */
public interface DictService {

    /**
     * 插入消息记录
     * @param dict
     * @return
     */
    ResultVO insertDict(Dict dict);

    /**
     * 根据ID 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改 根据ID
     * @param dict
     * @return
     */
    int updateByPrimaryKey(Dict dict);

    @AutoPage
    List<Dict> selectAll();

    List<Dict> selectParent();

    Dict selectByPrimaryKey(String id);

    @AutoPage
    List<Dict> selectByExample(Condition example);

    List<Dict> selectBy(String key, Object value);

    boolean isChild(Integer type);

    boolean isParent(Integer type);
}
