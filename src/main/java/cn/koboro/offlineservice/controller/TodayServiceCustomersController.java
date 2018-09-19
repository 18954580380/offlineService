package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.pojo.entity.HealthThemeServiceItem;
import cn.koboro.offlineservice.pojo.entity.ReservationTime;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.service.*;
import cn.koboro.offlineservice.utils.Validator;

import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 今日服务对象Controller
 * @author admin
 *
 */
@Controller
@RequestMapping("/todayServiceCustomers")
public class TodayServiceCustomersController {
  @Resource
  private TodayServiceCustomersService todayServiceCustomersService;
  @Resource
  private CasCustomersService  casCustomersService;
  @Resource
  private ReservationTimeService  reservationTimeService;
  @Resource
  private HealthThemeServiceItemService healthThemeServiceItemService;
  @Resource
  private TodayServiceCustomersItemService todayServiceCustomersItemService;
  /**
   * 今日服务对象头部数据
   * @param request
   * @param modelMap
   * @return
   */
  @GetMapping("/selectAll")
  public String selectAll(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	  //获取当前登录用户的ID
	  Integer doctor_id=casCustomersService.getDoctor().getId();
	  //获取时间任务查询时间
	  String date=Validator.isEmpty(
			  map.get("date"))?new SimpleDateFormat("yyyy-MM-dd")
					  .format(new Date()):map.get("date").toString();
	  //查询当前登陆者所在当前时间段的主题任务信息
	   List<Map<String,Object>>tasks= todayServiceCustomersService.findTasksByLoginNameAndDate(doctor_id,date);
	   Integer taskId=Validator.isEmpty(
			   tasks)?0:Integer.valueOf(tasks.get(0).get("id").toString());
	   String bolocName=Validator.isEmpty(
			   tasks)?"":tasks.get(0).get("bloc_name").toString();
	   //获取这个任务时间段
	  List<ReservationTime>reservationTimes=reservationTimeService.findReservationTimeByTaskId(taskId);
	  reservationTimes=splicingPeriod(reservationTimes);
	  //获取每种状态下的人数
	  modelMap=getCustomersCount(modelMap,taskId);
	  modelMap.put("date", date);
	  modelMap.put("bolocName", bolocName);
	  modelMap.put("taskId", taskId);
	  modelMap.put("reservationTimes", reservationTimes);
	  return Validator.isEmpty(map.get("status")
			  )?"todayServiceCustomers/list":"todayServiceCustomers/inServiceList";
  }
  /**
   * 今日服务对象列表 
   * @param request
   * @param modelMap
   * @return
   */
  @ResponseBody
  @GetMapping("/findServiceCustomer")
  public  ResultVO findServiceCustomer(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	      if(Validator.isEmpty(map.get("taskId"))){
	    	  return ResultVO.error(0, "任务id为空");
	      }
          Integer taskId=Integer.valueOf(map.get("taskId").toString());
		  //查询当前任务id下所有的用户并根据时间查询
		  List<TodayServiceCustomers>customers=todayServiceCustomersService.findCustomersByTaskId(taskId,map);
		  //获取每位用户的完成情况
		  customers=getCustomersCompleteStatus(customers);
		  return  ResultVO.success(new PageInfo<TodayServiceCustomers>(customers));
		
  }
  /**
   * 根据档案号和任务Id获取用户的服务完成情况
   * @param customers
   * @return
   */
  public List<TodayServiceCustomers> getCustomersCompleteStatus(List<TodayServiceCustomers> customers){
	  for(TodayServiceCustomers cus:customers){
		  String completeStatus=todayServiceCustomersItemService.findCompleteDetail(cus.getArchivalNumber(),cus.getThemeTaskId());
		  cus.setCompleteStatus(completeStatus);
	  }
	  return customers;
  }
	/**
	 * 今日服务对象列表 已完成
	 * @param request
	 * @param ModelMap
	 * @return
	 */
	@GetMapping("/selectCompletedList")
	public String selectCompletedList(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
		//获取当前登录用户名
//		String loginName=casCustomersService.getUsername();
		Integer doctorId=casCustomersService.getDoctor().getId();
		//获取时间任务查询时间
		String date=Validator.isEmpty(
				map.get("date"))?new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date()):map.get("date").toString();
		//查询当前登陆者所在当前时间段的主题任务信息
		List<Map<String,Object>>tasks= todayServiceCustomersService.findTasksByLoginNameAndDate(doctorId,date);
		Integer taskId=Validator.isEmpty(
				tasks)?0:Integer.valueOf(tasks.get(0).get("id").toString());
		String bolocName=Validator.isEmpty(
				tasks)?"":tasks.get(0).get("bloc_name").toString();
		//获取这个任务时间段
		List<ReservationTime>reservationTimes=reservationTimeService.findReservationTimeByTaskId(taskId);
		reservationTimes=splicingPeriod(reservationTimes);
		//查询当前任务id下所有的用户并根据时间查询
		modelMap=getCustomersCount(modelMap,taskId);
		modelMap.put("date", date);
		modelMap.put("bolocName", bolocName);
		modelMap.put("taskId", taskId);
		modelMap.put("reservationTimes", reservationTimes);
		modelMap.put("map", map);
		return "todayServiceCustomers/completedList";
	}
	/**
	 * 今日服务已完成列表
	 * @return
	 */
	@GetMapping("/selectCompletedListAll")
	@ResponseBody
	public ResultVO selectCompletedListAll(@RequestParam Map<String,Object>map){
		//获取当前 登陆者Id
		Integer doctorId=casCustomersService.getDoctor().getId();
		//获取时间任务查询时间
		String date=Validator.isEmpty(
				map.get("date"))?new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date()):map.get("date").toString();
		//查询当前登陆者所在当前时间段的主题任务信息
		List<Map<String,Object>>tasks= todayServiceCustomersService.findTasksByLoginNameAndDate(doctorId,date);
		Integer taskId=Validator.isEmpty(
				tasks)?0:Integer.valueOf(tasks.get(0).get("id").toString());
		String bolocName=Validator.isEmpty(
				tasks)?"":tasks.get(0).get("bloc_name").toString();
		//获取这个任务时间段
		List<ReservationTime>reservationTimes=reservationTimeService.findReservationTimeByTaskId(taskId);
		reservationTimes=splicingPeriod(reservationTimes);
		//查询当前任务id下所有的用户并根据时间查询
		List<TodayServiceCustomers> customers =todayServiceCustomersService.findCustomersByTaskId(taskId,map);
		for (TodayServiceCustomers todayServiceCustomers:customers){
			String themeTaskName = todayServiceCustomersItemService.findCompleteDetail(todayServiceCustomers.getArchivalNumber(),todayServiceCustomers.getThemeTaskId());
			todayServiceCustomers.setCompleteStatus(themeTaskName);
		}
		return ResultVO.success(new PageInfo<>(customers));
	}
	/**
	 * 今日服务对象列表 已完成 详情
	 * @return
	 */
	@GetMapping("/selectDetailsList")
	public String selectDetailsList(ModelMap modelMap,@RequestParam Map<String,Object>map){
		TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
		todayServiceCustomers.setThemeTaskId(Integer.parseInt((String) map.get("themeTaskId")));
		todayServiceCustomers.setArchivalNumber((String) map.get("archivalNumber"));
		List<Map<String,Object>>list=todayServiceCustomersItemService.findItemsByCus(todayServiceCustomers);
		modelMap.put("list",list);
		return "todayServiceCustomers/detailslist";
	}
  /**
   * 进入选择任务页面
   * @param request
   * @param ModelMap
   * @return
   */
  @GetMapping("/selectItem")
  public String selectItem(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	  //获取时间任务查询时间
	  String date=map.get("date").toString();
	  //主题任务Id
	  Integer taskId=Integer.valueOf(map.get("taskId").toString());
	  //客户Id
	  Integer customersId=Integer.valueOf(map.get("cid").toString());
	  modelMap=getCustomersCount(modelMap,taskId);
	  TodayServiceCustomers todayServiceCustomers=todayServiceCustomersService.findTodayServiceCustomersById(customersId);
	  //查询本次服务项目
	  List<HealthThemeServiceItem>items=healthThemeServiceItemService.findItemsByTaskId(taskId);
	  modelMap.put("date", date);
	  modelMap.put("todayServiceCustomers", todayServiceCustomers);
	  modelMap.put("taskId", taskId);
	  modelMap.put("items", items);
	  modelMap.put("customersId", customersId);
	  return "todayServiceCustomers/selectItem";
  }
  /**
   * 查询所有的医生
   * @return
   */
  @ResponseBody
  @GetMapping("/findDoctors")
  public List<Map<String,Object>>findDoctors(){
	   List<Map<String,Object>>doctors=healthThemeServiceItemService.findDoctors();
	   return doctors;
  }
  /**
   * 查询更多服务项目
   * @param request
   * @param ModelMap
   * @return
   */
  @ResponseBody
  @GetMapping("/findOtherItem")
  public List<Map<String,Object>> findOtherItem(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	  //查询更多项目
	  List<Map<String,Object>>otherItems=healthThemeServiceItemService.findOtherItems(map);
	  return otherItems;
  }
  /**
   * 保存为用户分配的服务项目
   * @param request
   * @param ModelMap
   * @return
   */
  @ResponseBody
  @PostMapping("/saveServiceItem")
  public boolean saveServiceItem(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	  map.put("koboroDoctor", casCustomersService.getDoctor());
	  boolean flag=todayServiceCustomersItemService.saveServiceItem(map);
	  return flag;
  }
  /**
   * 服务中用户详情
   * @param request
   * @param ModelMap
   * @return
   */
  @GetMapping("/detail")
  public String detail(HttpServletRequest request,ModelMap modelMap,TodayServiceCustomers todayServiceCustomers){
	  List<Map<String,Object>>items=todayServiceCustomersItemService.findItemsByCus(todayServiceCustomers);
	  modelMap.put("items", items);
	  modelMap.put("customers", todayServiceCustomers);
	  return "todayServiceCustomers/detail";
  }
  /**
   * 打印预览
   * @param request
   * @param ModelMap
   * @return
   */
  @GetMapping("/printItems")
  public String printItems(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
      //查询用户信息
	  TodayServiceCustomers todayServiceCustomers=todayServiceCustomersService.findTodayServiceCustomersById(
			  Integer.valueOf(map.get("customersId").toString()));
	  //根据用户信息查询所有的服务项目
	  List<Map<String,Object>>items=todayServiceCustomersItemService.findItemsByCus(todayServiceCustomers);
	  modelMap.put("todayServiceCustomers", todayServiceCustomers);
	  modelMap.put("items", items);
	  modelMap.put("date", map.get("date"));
	  return "todayServiceCustomers/print";
  }
  /**
   * 进入查询当前用户的服务记录信息页面
   * @param request
   * @param modelMap
   * @param map
   * @return
   */
  @GetMapping("/findServiceRecord")
  public String findServiceRecord(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	  //客户主表ID
	  Integer customersId=Integer.valueOf(map.get("customersId").toString());
	  //查询用户信息
	  TodayServiceCustomers todayServiceCustomers=todayServiceCustomersService.findTodayServiceCustomersById(
			  customersId);
	  String date=Validator.isEmpty(
			map.get("date"))?"":map.get("date").toString();
    modelMap.put("todayServiceCustomers", todayServiceCustomers);
    modelMap.put("customersId", customersId);
	modelMap.put("date", date);
	return "todayServiceCustomers/records";
  }
  /**
   * 查询当前用户的服务记录信息
   * @param request
   * @param modelMap
   * @param map
   * @return
   */
  @ResponseBody
  @GetMapping("/findServiceRecordData")
  public List<Map<String,Object>> findServiceRecordData(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	  //客户主表ID
	  Integer customersId=Integer.valueOf(map.get("customersId").toString());
	  //查询用户信息
	  TodayServiceCustomers todayServiceCustomers=todayServiceCustomersService.findTodayServiceCustomersById(
			  customersId);
	  String date=Validator.isEmpty(
			map.get("date"))?"":map.get("date").toString();
	//查询服务记录
	List<Map<String,Object>>records=todayServiceCustomersService.findServiceRecord(todayServiceCustomers.getArchivalNumber(),date);
	modelMap.put("records", records);
	return records;
  }
  /**
   * 放弃任务
   * @param request
   * @param modelMap
   * @param map
   * @return
   */
  @ResponseBody
  @PostMapping("/abortMission")
  public boolean abortMission(HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	 todayServiceCustomersItemService.abortMission(map);
	//查询完成情况
	String completeStatus= todayServiceCustomersItemService.findCompleteDetail(
			map.get("archivalNumber").toString(),Integer.valueOf(map.get("themeTaskId").toString()));
    //判断是否所有的服务项目都已经完成
	String[]number=completeStatus.split("/");
	if(number[0].equals(number[1])){
		//更新客户项目完成状态
		todayServiceCustomersService.updateStatus(map.get("archivalNumber").toString(),Integer.valueOf(map.get("themeTaskId").toString()));
	}
	return true;
  }
  /**
   * 根据服务状态获取任务下每个状态的服务人员数量
   * @param customers
   * @param status
   * @return
   */
  public Integer getCostomersByStatus(List<TodayServiceCustomers> customers,Integer status){
	  Integer count=0;
	  for(TodayServiceCustomers c:customers){
		  if(c.getStatus()==status)
		   count+=1;
	  }
	  return count;
  }
  /**
   * 拼接时间段,页面显示
   * @return
   */
  public   List<ReservationTime> splicingPeriod( List<ReservationTime> reservationTimes){
	  for( ReservationTime reservationTime: reservationTimes){
		   String startTime=reservationTime.getStartTime()+"-"+reservationTime.getEndTime();
		   reservationTime.setStartTime(startTime);
	     }
	  return reservationTimes;
  }
  /**
   * 获取每种状态下的人数  未服务，服务，已完成
   * @return
   */
  public  ModelMap  getCustomersCount( ModelMap modelMap,Integer taskId){
	  //查询当前任务id下所有的用户
	  List<TodayServiceCustomers>customers=todayServiceCustomersService.findStatusCustomersByTaskId(taskId);
	  //未服务
	  Integer notService=getCostomersByStatus(customers,0);
	  //服务中
	  Integer inService=getCostomersByStatus(customers,1);		  
	   //已完成
	  Integer completeService=getCostomersByStatus(customers,2);
	  modelMap.put("notService", notService);
	  modelMap.put("inService", inService);
	  modelMap.put("completeService", completeService);
	  return modelMap;
  }
  
}
