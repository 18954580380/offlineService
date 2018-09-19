package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TodayServiceCustomersMapper extends Mapper<TodayServiceCustomers>{
	 List<Map<String,Object>> findTasksByLoginNameAndDate(
			@Param("doctorId")Integer doctorId,@Param("date")String date);
	 List<TodayServiceCustomers> findCustomersByTaskId(TodayServiceCustomers todayServiceCustomers);
	 List<TodayServiceCustomers> findStatusCustomersByTaskId(@Param("taskId") Integer taskId);
	 List<Map<String, Object>> findServiceRecord(@Param("archivalNumber") String archivalNumber,@Param("date") String date);
	 void updateStatus(@Param("archivalNumber")  String archivalNumber,@Param("themeTaskId") Integer themeTaskId);

	TodayServiceCustomers selectUserByArchivalNumber(@Param("archivalNumber") String archivalNumber);

	TodayServiceCustomers  findCustomersByTaskIdAndArchivalNumber(@Param("taskId") Integer taskId, @Param("archivalNumber") String archivalNumber);
}
