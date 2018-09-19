package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.core.IBaseMapper;
import cn.koboro.offlineservice.pojo.entity.HealthThemeServiceItemJoinDoctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HealthThemeServiceItemJoinDoctorMapper extends IBaseMapper<HealthThemeServiceItemJoinDoctor> {

    List<Map<String,Object>> findSeriveceTeam(@Param("themeTaskId") Integer themeTaskId);
}
