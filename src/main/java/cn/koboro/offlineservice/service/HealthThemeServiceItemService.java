package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.pojo.entity.HealthThemeServiceItem;

import java.util.List;
import java.util.Map;

public interface HealthThemeServiceItemService {
	 List<HealthThemeServiceItem> findItemsByTaskId(Integer taskId);
	 List<Map<String,Object>> findOtherItems(Map<String,Object>map);
	 List<Map<String,Object>> findDoctors();

}
