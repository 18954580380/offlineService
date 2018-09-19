package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.pojo.entity.ThemeTaskActivity;
import cn.koboro.offlineservice.repository.ThemeTaskActivityMapper;
import cn.koboro.offlineservice.service.ThemeTaskActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional
public class ThemeTaskActivityServiceImpl implements ThemeTaskActivityService {
    @Resource
    private ThemeTaskActivityMapper themeTaskActivityMapper;
    @Override
    public int addTaskActivity(ThemeTaskActivity themeTaskActivity) {
        return themeTaskActivityMapper.insert(themeTaskActivity);
    }
}
