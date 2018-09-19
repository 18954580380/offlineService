package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.pojo.entity.CustomerInformation;
import cn.koboro.offlineservice.pojo.entity.KoboroDoctor;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.service.CasCustomersService;
import cn.koboro.offlineservice.service.PendingCustomersService;
import cn.koboro.offlineservice.service.TodayServiceCustomersService;
import cn.koboro.offlineservice.utils.Validator;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 查询全部待邀约客户
 */
@Controller
@RequestMapping("/pendingcustomers")
public class PendingCustomersController {
    @Resource
    private PendingCustomersService pendingCustomersService;
    @Resource
    private CasCustomersService casCustomersService;
    @Resource
    private TodayServiceCustomersService todayServiceCustomersService;

    /**
     * 待邀约客户页面
     * @param modelMap
     * @param map
     * @return
     */
    @GetMapping("/page")
    public String pendingCustomers(ModelMap modelMap,@RequestParam Map<String,String> map){
        //获取当前登录用户名
        String userName=casCustomersService.getDoctor().getDoctorName();
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        String dateforamt = datetime.substring(0,10);
        String date ="";
        if(!Validator.isEmpty(map.get("date"))){
            date = map.get("date");
        }else{
            date = dateforamt;
        }
        KoboroDoctor koboroDoctor = casCustomersService.getDoctor();
        List<Map<String,Object>> list2 =  pendingCustomersService.findTasksByLoginNameAndDate(date,koboroDoctor.getId());
        List list = new ArrayList();
        TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
        if(list2.size()==0){
            todayServiceCustomers.setThemeTaskId(0);
        }else{
            todayServiceCustomers.setThemeTaskId((Integer) list2.get(0).get("id"));
        }
        todayServiceCustomers.setDept(map.get("dept"));
        todayServiceCustomers.setName(map.get("name"));
        todayServiceCustomers.setPhoneNumber(map.get("phoneNumber"));
        int count1 =  pendingCustomersService.selectPendingCustomersCount(todayServiceCustomers);
        if(Validator.isEmpty(map.get("source"))){
            todayServiceCustomers.setCode("1");
        }else{
            todayServiceCustomers.setCode("");
        }
        todayServiceCustomers.setSource(map.get("source"));
        List pendingCustomersList = new ArrayList();
        if(todayServiceCustomers.getThemeTaskId()!=0){
             pendingCustomersList = pendingCustomersService.selectPendingCustomers(todayServiceCustomers);
        }
        for (int i=0;i<6;i++){
            todayServiceCustomers.setSource(String.valueOf(i));
            int count =  pendingCustomersService.selectPendingCustomersCount(todayServiceCustomers);
            list.add(count);
        }
        modelMap.put("a",list.get(0));
        modelMap.put("b",list.get(1));
        modelMap.put("c",list.get(2));
        modelMap.put("d",list.get(3));
        modelMap.put("e",list.get(4));
        modelMap.put("count",count1);
        modelMap.put("date",date);
        modelMap.put("pendingCustomersList",pendingCustomersList);
        modelMap.put("themeTaskId",list2.size()==0?0:list2.get(0).get("id"));
        return "PendingCustomers/list";
    }

    /**
     * 待邀约客户列表
     * @param modelMap
     * @param map
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public ResultVO pendingCustomerslist(ModelMap modelMap,@RequestParam Map<String,String> map){
        //获取当前登录用户名
    	 String userName=casCustomersService.getDoctor().getDoctorName();
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        String dateforamt = datetime.substring(0,10);
        String date ="";
        if(!Validator.isEmpty(map.get("date"))){
            date = map.get("date");
        }else{
            date = dateforamt;
        }
        KoboroDoctor koboroDoctor = casCustomersService.getDoctor();
        List<Map<String,Object>> list2 =  pendingCustomersService.findTasksByLoginNameAndDate(
                date,koboroDoctor.getId());
        TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
        if(list2.size()==0){
            todayServiceCustomers.setThemeTaskId(0);
        }else{
            todayServiceCustomers.setThemeTaskId((Integer) list2.get(0).get("id"));
        }
        todayServiceCustomers.setDept(map.get("dept"));
        todayServiceCustomers.setName(map.get("name"));
        System.out.println(map.get("source"));
        todayServiceCustomers.setPhoneNumber(map.get("phoneNumber"));
        if(Validator.isEmpty(map.get("source"))){
            todayServiceCustomers.setCode("1");
        }else{
            todayServiceCustomers.setCode("");
        }
        todayServiceCustomers.setSource(map.get("source"));
        List pendingCustomersList = new ArrayList();
        if(todayServiceCustomers.getThemeTaskId()!=0){
             pendingCustomersList = pendingCustomersService.selectPendingCustomers(todayServiceCustomers);
        }
        return ResultVO.success(new PageInfo(pendingCustomersList));
    }

    /**
     * 自定义 页面
     */
    @GetMapping("/selectCustomize")
    public String selectCustomize(ModelMap modelMap,@RequestParam Map<String,String> map){
        //获取当前登录用户名
    	String userName=casCustomersService.getDoctor().getDoctorName();
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        String dateforamt = datetime.substring(0,10);
        String date ="";
        if(!Validator.isEmpty(map.get("date"))){
            date = map.get("date");
        }else{
            date = dateforamt;
        }
        KoboroDoctor koboroDoctor = casCustomersService.getDoctor();
        List<Map<String,Object>> list2 =  pendingCustomersService.findTasksByLoginNameAndDate(
                date,koboroDoctor.getId());
        TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
        if(list2.size()==0){
            todayServiceCustomers.setThemeTaskId(0);
        }else{
            todayServiceCustomers.setThemeTaskId((Integer) list2.get(0).get("id"));
        }
        todayServiceCustomers.setDept(map.get("dept"));
        todayServiceCustomers.setName(map.get("name"));
        todayServiceCustomers.setPhoneNumber(map.get("phoneNumber"));
        List<TodayServiceCustomers> list = pendingCustomersService.selectCustomize(todayServiceCustomers);
        modelMap.put("list",list);
        return "PendingCustomers/customizelist";
    }
    /**
     * 自定义页面
     */
    @GetMapping("/customizePage")
    public String customizePage(ModelMap modelMap,@RequestParam Map<String,String> map){
        return "PendingCustomers/customizePage";
    }
    /**
     * 自定义列表
     */
    @GetMapping("/customizeList")
    @ResponseBody
    public ResultVO customizeList(ModelMap modelMap,@RequestParam Map<String,String> map){
        //获取当前登录用户名
    	String userName=casCustomersService.getDoctor().getDoctorName();
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        String dateforamt = datetime.substring(0,10);
        String date ="";
        if(!Validator.isEmpty(map.get("date"))){
            date = map.get("date");
        }else{
            date = dateforamt;
        }
        KoboroDoctor koboroDoctor = casCustomersService.getDoctor();
        List<Map<String,Object>> list2 =  pendingCustomersService.findTasksByLoginNameAndDate(
                date,koboroDoctor.getId());
        TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
        if(list2.size()==0){
            todayServiceCustomers.setThemeTaskId(0);
        }else{
            todayServiceCustomers.setThemeTaskId((Integer) list2.get(0).get("id"));
        }
        todayServiceCustomers.setDept(map.get("dept"));
        todayServiceCustomers.setName(map.get("name"));
        todayServiceCustomers.setPhoneNumber(map.get("phoneNumber"));
        List<CustomerInformation> list = pendingCustomersService.selectCustomizeList(todayServiceCustomers);
        return ResultVO.success(new PageInfo(list));
    }
    /**
     * 自定义 添加页面 添加方法
     */
    @GetMapping("/saveCustomize")
    public String saveCustomize(@RequestParam Map<String,String> map){
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        String date = datetime.substring(0,10);
        KoboroDoctor koboroDoctor = casCustomersService.getDoctor();
        List<Map<String,Object>> list2 =  pendingCustomersService.findTasksByLoginNameAndDate(
                date,koboroDoctor.getId());
        //获取当前登录用户名
        String arr[] = map.get("ids").split(",");
        System.out.println(arr);
            for (String id:arr){
                //查询出用户
                CustomerInformation customerInformation = casCustomersService.selectCustomerInformationById(
                        Long.valueOf(id));
                TodayServiceCustomers customerInformationService = pendingCustomersService.selectCustomerInfortionById(customerInformation.getArchivalNumber());
                if(Validator.isEmpty(customerInformationService)){
                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                    todayServiceCustomers.setDept(customerInformation.getDept());
                    todayServiceCustomers.setName(customerInformation.getName());
                    todayServiceCustomers.setCreateTime(new Date());
                    todayServiceCustomers.setIsJoin(0);
                    todayServiceCustomers.setSource("5");
                    if("男".equals(customerInformation.getSex())){
                        todayServiceCustomers.setSex(1);
                    }else{
                        todayServiceCustomers.setSex(2);
                    }
                    todayServiceCustomers.setStatus(0);
                    todayServiceCustomers.setDoctorflag(0);
                    todayServiceCustomers.setPhoneNumber(customerInformation.getPhoneNumber());
                    todayServiceCustomers.setArchivalNumber(customerInformation.getArchivalNumber());
                    todayServiceCustomers.setThemeTaskId((Integer) list2.get(0).get("id"));
                    pendingCustomersService.saveCustomers(todayServiceCustomers);
                }else{
                    if(customerInformationService.getSource().indexOf("5") != -1){
                        //数据库有自定义的类型就不动
                    }else{
                        TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                        todayServiceCustomers.setId(customerInformationService.getId());
                        todayServiceCustomers.setSource(customerInformationService.getSource()+",5");
                        todayServiceCustomersService.updatetodayServiceCustomers(todayServiceCustomers);
                    }

                }
            }
         return "PendingCustomers/customizelist";
    }
}
