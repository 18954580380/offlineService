package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.core.IBaseMapper;
import cn.koboro.offlineservice.pojo.entity.HealthThemeServiceItem;
import cn.koboro.offlineservice.pojo.entity.KoboroDoctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HealthThemeServiceItemMapper extends IBaseMapper<HealthThemeServiceItem> {
    List<HealthThemeServiceItem> findItemsByTaskId(@Param("taskId") Integer taskId);

    List<Map<String, Object>> findOtherItems(@Param("name") String name);

    List<Map<String, Object>> findDoctors();

    KoboroDoctor findDoctorByLoginName(@Param("login_name") String loginName);

    String findServiceIntroduction(@Param("taskId") Integer taskId, @Param("itemName") String itemName);
}
