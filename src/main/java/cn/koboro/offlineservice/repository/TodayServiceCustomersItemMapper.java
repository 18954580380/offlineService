package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomersItem;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
public interface TodayServiceCustomersItemMapper extends Mapper<TodayServiceCustomersItem>{
	List<Map<String, Object>> findItemsByCus(TodayServiceCustomers todayServiceCustomers);
	void deleteCustomersItems(@Param("archivalNumber")String archivalNumber,@Param("themeTaskId")Integer themeTaskId,@Param("item")String item);
	List<Map<String,Object>> findCompleteDetail(@Param("archivalNumber")String archivalNumber,@Param("themeTaskId")Integer themeTaskId);
	List<TodayServiceCustomersItem> findServiceItemProcess(@Param("archivalNumber")String archivalNumber,@Param("themeTaskId")Integer themeTaskId);
}
