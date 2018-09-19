package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.pojo.entity.HealthThemeTemplate;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface HealthThemeTemplateMapper extends Mapper<HealthThemeTemplate>{
	List<Map<String,Object>> findProblemDisease(String param);
	List<HealthThemeTemplate> selectAllByThemeName(@Param("themeName")String themeName);
}
