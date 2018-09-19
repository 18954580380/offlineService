package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;

import java.util.List;
import java.util.Map;

public interface TodayServiceCustomersService {
	 List<Map<String,Object>> findTasksByLoginNameAndDate(Integer doctorId,String date);
	 List<TodayServiceCustomers> findCustomersByTaskId(Integer taskId,Map<String,Object>map);
	 List<TodayServiceCustomers> findStatusCustomersByTaskId(Integer taskId);
	 TodayServiceCustomers findTodayServiceCustomersById(Integer customersId);
	 List<Map<String,Object>>findServiceRecord(String archivalNumber,String date);
	 void updateStatus(String archivalNumber,Integer themeTaskId);

    void updatetodayServiceCustomers(TodayServiceCustomers todayServiceCustomers);

    int applyTask(TodayServiceCustomers todayServiceCustomers);
}
