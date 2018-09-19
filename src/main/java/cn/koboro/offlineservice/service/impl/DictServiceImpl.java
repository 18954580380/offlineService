
package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.constants.CommonConstants;
import cn.koboro.offlineservice.enums.ResultEnum;
import cn.koboro.offlineservice.pojo.entity.Dict;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.repository.DictMapper;
import cn.koboro.offlineservice.service.DictService;
import cn.koboro.offlineservice.utils.ResultUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xdw
 */
@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictMapper dictMapper;

    private static final int TYPE_PARENT = CommonConstants.Dict.TYPE_PARENT;
    private static final int TYPE_CHILD = CommonConstants.Dict.TYPE_CHILD;


    @Override
    public ResultVO insertDict(Dict dict) {
        Condition condition = dictMapper.getCondition();
        Example.Criteria criteria = condition.createCriteria();
        if (isChild(dict.getType())) {
            criteria.andEqualTo("dictKey", dict.getDictKey());
            criteria.orEqualTo("dictValue", dict.getDictValue());

            List<Dict> dicts = this.selectByExample(condition);
            if (CollectionUtils.isNotEmpty(dicts)) {
                return ResultUtil.error(ResultEnum.REPEAT, "字典值/字典名");
            }
            Dict parent = dictMapper.selectByPrimaryKey(dict.getParentId());
            if (parent == null) {
                return ResultUtil.error(ResultEnum.PARENT_NULL);
            }
            dict.setDictOrder(parent.getDictOrder());
        } else if (isParent(dict.getType())) {
            criteria.andEqualTo("dictOrder", dict.getDictOrder());
            List<Dict> dicts = this.selectByExample(condition);
            if (CollectionUtils.isNotEmpty(dicts)) {
                return ResultUtil.error(ResultEnum.REPEAT, "分组");
            }
            dict.setParentId("0");
        } else {
            return ResultUtil.error(ResultEnum.TYPE_NULL);
        }
        return ResultUtil.success(dictMapper.insertSelective(dict));
    }
    @Override
    public int deleteByPrimaryKey(String id) {
        return dictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Dict dict) {
        return dictMapper.updateByPrimaryKey(dict);
    }

    @Override
    @AutoPage
    public List<Dict> selectAll() {
        return dictMapper.selectAll();
    }

    @Override
    public List<Dict> selectParent() {
        Condition condition = dictMapper.getCondition();
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("type",CommonConstants.Dict.TYPE_PARENT);
        return selectByExample(condition);
    }

    @Override
    public Dict selectByPrimaryKey(String id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @AutoPage
    @Override
    public List<Dict> selectByExample(Condition condition) {
        return dictMapper.selectByExample(condition);
    }

    @Override
    public List<Dict> selectBy(String key, Object value) {
        Condition condition = new Condition(Dict.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo(key, value);
        return dictMapper.selectByExample(condition);
    }


    /**
     * 是子类型
     *
     * @param type
     * @return
     */
    @Override
    public boolean isChild(Integer type) {
        if (type == null) {
            return false;
        } else if (type == TYPE_CHILD) {
            return true;
        }
        return false;
    }

    /**
     * 是子类型
     *
     * @param type
     * @return
     */
    @Override
    public boolean isParent(Integer type) {
        if (type == null) {
            return false;
        } else if (type == TYPE_PARENT) {
            return true;
        }
        return false;
    }
}
