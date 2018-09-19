package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.pojo.entity.CustomerInformation;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface PendingCustomersService {

    List<TodayServiceCustomers> selectPendingCustomers(TodayServiceCustomers todayServiceCustomers);

    int selectPendingCustomersCount(TodayServiceCustomers todayServiceCustomers);


    List<TodayServiceCustomers> selectSendAMessageCustomers(TodayServiceCustomers todayServiceCustomers);

    void createRemindContent(Map<String,String> map) throws ParseException;

    List<Map> selectRemindContentSend();

    List<TodayServiceCustomers> selectCustomize(TodayServiceCustomers todayServiceCustomers);

    List<Map<String,Object>> findTasksByLoginNameAndDate(String  date,Integer id);

    void saveCustomers(TodayServiceCustomers todayServiceCustomers);

    TodayServiceCustomers selectCustomerInfortion(Long id);

    TodayServiceCustomers selectCustomerInfortionById(String archivalNumber);

    void updCustomers(TodayServiceCustomers todayServiceCustomers);

    List<CustomerInformation> selectCustomizeList(TodayServiceCustomers todayServiceCustomers);
}
