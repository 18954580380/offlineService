package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.CustomerInformation;
import cn.koboro.offlineservice.pojo.entity.RemindContentSend;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.properties.KoboroProperties;
import cn.koboro.offlineservice.repository.PendingCustomersMapper;
import cn.koboro.offlineservice.repository.RemindContentSendMapper;
import cn.koboro.offlineservice.service.PendingCustomersService;
import cn.koboro.offlineservice.utils.Connection;
import cn.koboro.offlineservice.utils.Validator;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class PendingCustomersServiceImpl implements PendingCustomersService{

    @Resource
    private PendingCustomersMapper pendingCustomersMapper;

    @Resource
    private RemindContentSendMapper remindContentSendMapper;
    @Resource
    private KoboroProperties koboroProperties;

    @Override
    @AutoPage
    public List<TodayServiceCustomers> selectPendingCustomers(TodayServiceCustomers todayServiceCustomers) {
        return pendingCustomersMapper.selectPendingCustomers(todayServiceCustomers);
    }

    @Override
    public int selectPendingCustomersCount(TodayServiceCustomers todayServiceCustomers) {
        return pendingCustomersMapper.selectPendingCustomersCount(todayServiceCustomers);
    }

    @Override
    public List<TodayServiceCustomers> selectSendAMessageCustomers(TodayServiceCustomers todayServiceCustomers) {
        return pendingCustomersMapper.selectSendAMessageCustomers(todayServiceCustomers);
    }
    /**
     * 生成待发送数据
     * @throws Exception
     */
    @Override
    public void createRemindContent(Map<String,String> map) throws ParseException {
        String string = map.get("sendDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date parse = sdf.parse(string);
        //生成待发送数据
        if(!Validator.isEmpty(map.get("remindComtent"))) {
            Long themeTaskId=Long.valueOf(map.get("themeTaskId").toString());
            String ids = map.get("id");
            String names = map.get("name");
            String archivalNumbers = map.get("archivalNumber");
            if (!Validator.isEmpty(ids)) {
                String[] idArr = ids.split(",");
                 String s = UUID.randomUUID().toString().replaceAll("-", "");
               /* if(map.get("sendDate") != null){
                    for (String id : idArr) {
                        //一个客户一条记录，没有项目名称
                        RemindContentSend rSend = new RemindContentSend();
                        TodayServiceCustomers cus = pendingCustomersMapper.selectCustomerInfortion(Long.valueOf(id));
                        rSend.setCustomerId(cus.getId().longValue());                       //客户id
                        rSend.setArchivalNumber(cus.getArchivalNumber());       //档案号
                        rSend.setUserName(cus.getName());                       //客户姓名
                        rSend.setContent(map.get("remindComtent"));//提醒内容
                        rSend.setType("消息推送");//
                        rSend.setDataIds(s);
                        rSend.setSendDate(parse);
                        rSend.setThemeTaskId(themeTaskId);//任务Id
                        rSend.setCreatedTime(new Date());
                        remindContentSendMapper.save(rSend);
                     }*/
                   /* String ss = koboroProperties.servcieSendAMessage();
                    Connection.newPOST().setParam("content",map.get("remindComtent")).setParam("archivalNumbers",
                            ids).setParam("systemType","kbr-offlineService").send(ss, null);*/
               /* }else{*/
                    String ss = koboroProperties.servcieSendAMessage();
                    Connection.newPOST().setParam("content",map.get("remindComtent")).setParam("archivalNumbers",
                            archivalNumbers).setParam("themeTaskId",
                            String.valueOf(themeTaskId)).setParam("systemType","kbr-offlineService").send(ss, null);
                /*}*/
            }
        }
    }
    @Override
    public List<Map> selectRemindContentSend() {
        return remindContentSendMapper.selectRemindContentSend();
    }

    @Override
    public List<TodayServiceCustomers> selectCustomize(TodayServiceCustomers todayServiceCustomers) {
        return  pendingCustomersMapper.selectCustomize(todayServiceCustomers);

    }

    @Override
    public List<Map<String, Object>> findTasksByLoginNameAndDate(String  date,Integer id) {
        return pendingCustomersMapper.findTasksByLoginNameAndDate(date,id);
    }

    @Override
    public void saveCustomers(TodayServiceCustomers todayServiceCustomers) {
        pendingCustomersMapper.saveCustomers(todayServiceCustomers);
    }

    @Override
    public TodayServiceCustomers selectCustomerInfortion(Long id) {
        return pendingCustomersMapper.selectCustomerInfortion(id);
    }

    @Override
    public TodayServiceCustomers selectCustomerInfortionById(String archivalNumber) {
        return  pendingCustomersMapper.selectCustomerInfortionById(archivalNumber);
    }

    @Override
    public void updCustomers(TodayServiceCustomers todayServiceCustomers) {
        pendingCustomersMapper.updCustomers(todayServiceCustomers);
    }

    @Override
    @AutoPage
    public List<CustomerInformation> selectCustomizeList(TodayServiceCustomers todayServiceCustomers) {
        return pendingCustomersMapper.selectCustomizeList(todayServiceCustomers);
    }


}
