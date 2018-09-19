package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.service.CasCustomersService;
import cn.koboro.offlineservice.service.PendingCustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 发送消息
 */
@Controller
@RequestMapping("/sendAMessage")
public class SendAMessageController {

//    @Resource
//    private SendAMessageService sendAMessageService;
    @Resource
    private PendingCustomersService pendingCustomersService;
    @Resource
    private CasCustomersService casCustomersService;

    @GetMapping("/page")
    public String sendAMessage(ModelMap modelMap,@RequestParam String themeTaskId){
        TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
        todayServiceCustomers.setThemeTaskId(Integer.valueOf(themeTaskId));
        List<TodayServiceCustomers> list = pendingCustomersService.selectSendAMessageCustomers(todayServiceCustomers);
        modelMap.put("custList",list);
        modelMap.put("themeTaskId",themeTaskId);
        modelMap.put("custListSize",list.size());
        return "sendAMessage/list";
    }
    // 发送消息
    @GetMapping("/sendAMessageList")
    public String sendAMessageList(@RequestParam Map<String,String> map,ModelMap modelMap) throws ParseException {
        pendingCustomersService.createRemindContent(map);
        return "sendAMessage/list";
    }
    // 发送消息记录 recording
    @GetMapping("/pageRecording")
    public String pendingCustomers2(ModelMap modelMap,@RequestParam String themeTaskId){
        List<Map> list =pendingCustomersService.selectRemindContentSend();
        modelMap.put("themeTaskId",themeTaskId);
        modelMap.put("list",list);
        return "sendAMessage/recordingList";
    }

}
