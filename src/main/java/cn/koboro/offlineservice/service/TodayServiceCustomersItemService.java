package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;

import java.util.List;
import java.util.Map;

public interface TodayServiceCustomersItemService {
	 boolean saveServiceItem(Map<String,Object>map);
	 List<Map<String,Object>> findItemsByCus(TodayServiceCustomers todayServiceCustomers);
	 void abortMission(Map<String,Object>map);
	 String findCompleteDetail(String archivalNumber,Integer themeTaskId);
		
}
