package cn.koboro.offlineservice.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;

public interface ServiceAnalyzeMapper{
	List<Map<String,Object>>  selectAllData(@Param("blocName") String  blocName,@Param("themeName")String themeName,@Param("date") String date,@Param("taskId") String taskId);
	List<Map<String, Object>> findServiceNumber(@Param("taskId") Integer taskId);
	List<TodayServiceCustomers> findCustomersByTaskId(@Param("taskId")Integer taskId);
	List<Map<String, Object>> findDoctorDetail(@Param("taskId")Integer taskId);
	List<Map<String, Object>> findServiceDetail(@Param("taskId")Integer taskId);

}
