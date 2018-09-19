package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.HealthThemeTemplate;
import cn.koboro.offlineservice.repository.HealthThemeTemplateMapper;
import cn.koboro.offlineservice.service.HealthThemeTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HealthThemeTemplateServiceImpl implements HealthThemeTemplateService {
    @Resource
    private HealthThemeTemplateMapper healthThemeTemplateMapper;

    /**
     * 查询所有的健康主题
     */
    @AutoPage
    @Override
    public List<HealthThemeTemplate> selectAll() {
        return healthThemeTemplateMapper.selectAll();
    }

    /**
     * 查询主要问题,诊断疾病
     */
    @Override
    public List<Map<String, Object>> findProblemDisease(String param) {
        return healthThemeTemplateMapper.findProblemDisease(param);
    }

    /**
     * 保存
     */
    @Override
    public int save(HealthThemeTemplate healthThemeTemplate) {
        return healthThemeTemplateMapper.insertSelective(healthThemeTemplate);
    }

    /**
     * 根据id删除主题
     */
    @Override
    public int deleteById(String ids) {
        String[] id = ids.split(",");
        int count = 0;
        for (String healthThemeTemplateId : id) {
            HealthThemeTemplate healthThemeTemplate = new HealthThemeTemplate();
            healthThemeTemplate.setId(Integer.valueOf(healthThemeTemplateId));
            count += healthThemeTemplateMapper.delete(healthThemeTemplate);
        }

        return count;
    }

    /**
     * 根据id主键查询主题信息
     */
    @Override
    public HealthThemeTemplate findById(Integer id) {
        return healthThemeTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存修改
     */
    @Override
    public int saveUpdate(HealthThemeTemplate healthThemeTemplate) {
        return healthThemeTemplateMapper.updateByPrimaryKeySelective(healthThemeTemplate);
    }

    /**
     * 查询所有主题根据主题名称
     */
    @AutoPage
    @Override
    public List<HealthThemeTemplate> selectAllByThemeName(String themeName) {
        return healthThemeTemplateMapper.selectAllByThemeName(themeName);
    }

}
