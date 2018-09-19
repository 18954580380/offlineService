package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.pojo.entity.HealthThemeServiceItem;
import cn.koboro.offlineservice.pojo.entity.HealthThemeServiceItemJoinDoctor;
import cn.koboro.offlineservice.pojo.entity.HealthThemeTask;
import cn.koboro.offlineservice.pojo.entity.HealthThemeTemplate;

import java.util.List;
import java.util.Map;

public interface HealthThemeTaskService {
	List<Map<String,Object>> selectAllTasks(Map<String,Object>map);

    int insert(HealthThemeTask healthThemeTask);

    void deleteServiceTaskById(String ids);

    HealthThemeTask selectServiceTaskById(String id);

    List<HealthThemeServiceItem> selectServiceHealthThemeServiceItem(Integer id);

    HealthThemeTemplate selectHealthThemeTemplate(Integer themeId);

    List<HealthThemeServiceItemJoinDoctor> selectHealthThemeServiceItemJoinDoctor(Integer themeTaskId);
    
    void updateReleaseTime(HealthThemeTask themeTask);

    List<HealthThemeTask> findTask(Integer blocId);

    List<Map<String,Object>> selectTasks(String archivalNumber, String themeName, String status);

    List<Map<String,Object>> serviceProcess(String archivalNumber, Integer themeTaskId);

    Map<String,Object> serviceInformation(Integer themeTaskId);

    Map<String,Object> itemIntroduce(Integer themeTaskId,String itemName);

    List<Map<String,Object>> findSerivceTeam(Integer themeTaskId);

    Map<String,Object> findActivityIdByTaskId(Integer themeTaskId);

    Map<String,Object> findAppointmentTime(Integer themeTaskId);

    Map<String,Object> findTextMessage(String archivalNumber, Integer themeTaskId);
}
