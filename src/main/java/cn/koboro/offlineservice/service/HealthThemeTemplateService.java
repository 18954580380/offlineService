package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.pojo.entity.HealthThemeTemplate;

import java.util.List;
import java.util.Map;

public interface HealthThemeTemplateService {
	List<HealthThemeTemplate>  selectAll();
	List<HealthThemeTemplate>  selectAllByThemeName(String themeName);
	List<Map<String,Object>>   findProblemDisease(String param);
	int save(HealthThemeTemplate healthThemeTemplate);
	int deleteById(String ids);
	HealthThemeTemplate findById(Integer id);
	int saveUpdate(HealthThemeTemplate healthThemeTemplate);

}
