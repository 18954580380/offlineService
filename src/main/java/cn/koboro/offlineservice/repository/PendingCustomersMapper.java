package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.pojo.entity.CustomerInformation;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface PendingCustomersMapper extends Mapper<TodayServiceCustomers> {

    List<TodayServiceCustomers> selectPendingCustomers(TodayServiceCustomers todayServiceCustomers);

    List<Map<String,Object>> findTasksByLoginNameAndDate(
            @Param("date")String date,@Param("id")Integer id);

    int selectPendingCustomersCount(TodayServiceCustomers todayServiceCustomers);

    List<TodayServiceCustomers> selectSendAMessageCustomers(TodayServiceCustomers todayServiceCustomers);

    TodayServiceCustomers selectCustomerInfortion(@Param("id") Long id);

    List<TodayServiceCustomers> selectCustomize(TodayServiceCustomers todayServiceCustomers);

    void saveCustomers(TodayServiceCustomers todayServiceCustomers);

    TodayServiceCustomers selectCustomerInfortionById(@Param("archivalNumber") String archivalNumber);

    void updCustomers(TodayServiceCustomers todayServiceCustomers);

    List<CustomerInformation> selectCustomizeList(TodayServiceCustomers todayServiceCustomers);
}
