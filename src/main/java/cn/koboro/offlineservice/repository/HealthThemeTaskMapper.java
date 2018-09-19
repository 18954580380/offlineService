package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.pojo.entity.*;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface HealthThemeTaskMapper extends Mapper<HealthThemeTask>{
	List<Map<String,Object>> selectAllTasks(
			       @Param("themeName") String themeName,
			           @Param("serviceAddress") String serviceAddress,
			                @Param("blocName") String blocName);

	void deleteServiceTaskById(@Param("id") Integer id);

	HealthThemeTask selectServiceTaskById(@Param("id") String id);

	List<HealthThemeServiceItem> selectServiceHealthThemeServiceItem(@Param("id") Integer id);

	HealthThemeTemplate selectHealthThemeTemplate(@Param("themeId") Integer themeId);

	List<HealthThemeServiceItemJoinDoctor> selectHealthThemeServiceItemJoinDoctor(@Param("themeTaskId")Integer themeTaskId);

    List<HealthThemeTask> findTask(Integer blocId);

    List<Map<String,Object>> findTaskByBlocIdAndThemeName(@Param("blocId")Long blocId, @Param("themeName")String themeName);

	ThemeTaskActivity findActivityIdByTaskId(Integer themeTaskId);
}
