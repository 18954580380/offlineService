package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.*;
import cn.koboro.offlineservice.repository.*;
import cn.koboro.offlineservice.service.HealthThemeTaskService;
import cn.koboro.offlineservice.utils.DateUtil;
import cn.koboro.offlineservice.utils.PropertiesUtil;
import cn.koboro.offlineservice.utils.Validator;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class HealthThemeTaskServiceImpl implements HealthThemeTaskService{
	@Resource
	private HealthThemeTaskMapper healthThemeTaskMapper;
	@Resource
	private CustomerInformationMapper customerInformationMapper;
	@Resource
	private TodayServiceCustomersMapper todayServiceCustomersMapper;
	@Resource
	private TodayServiceCustomersItemMapper todayServiceCustomersItemMapper;
	@Resource
	private HealthThemeTemplateMapper healthThemeTemplateMapper;
	@Resource
	private HealthThemeServiceItemMapper healthThemeServiceItemMapper;
	@Resource
	private  HealthThemeServiceItemJoinDoctorMapper healthThemeServiceItemJoinDoctorMapper;
	@Resource
	private ReservationTimeMapper reservationTimeMapper;
    /**
     * 主题任务列表
     */
	@AutoPage
	@Override
	public List<Map<String, Object>> selectAllTasks(Map<String, Object> map) {
		//主题名称
		String themeName=Validator.isEmpty(map.get("themeName"))?"":map.get("themeName").toString();
		//服务地点
		String serviceAddress=Validator.isEmpty(
				map.get("serviceAddress"))?"":map.get("serviceAddress").toString();
		//服务集团
		String blocName=Validator.isEmpty(map.get("blocName"))?"":map.get("blocName").toString();
		List<Map<String,Object>>tasks=healthThemeTaskMapper.selectAllTasks(themeName,serviceAddress,blocName);
		return isRelease(tasks);
	}
   /**
    * 是否发布
    * @param tasks
    * @return
    */
	public  List<Map<String, Object>> isRelease(List<Map<String,Object>>tasks){
		for(Map<String, Object> map:tasks){
			if(Validator.isEmpty(map.get("release_time"))){
				map.put("status", "未发布");
			}else{
				map.put("status", "已发布");
				/*String releaseTime=map.get("release_time").toString();
				if(DateUtil.dataCompare(releaseTime)){
					map.put("status", "已发布");
				}else{
					map.put("status", "未发布");
				}*/
			}
		}
		return tasks;
	}
	@Override
	public int insert(HealthThemeTask healthThemeTask){
		return healthThemeTaskMapper.insert(healthThemeTask);
	}
	//删除服务任务
	@Override
	public void deleteServiceTaskById(String ids) {
		String[] arr = ids.split(",");
		for (String id :arr){
			healthThemeTaskMapper.deleteServiceTaskById(Integer.valueOf(id));
		}
	}

	@Override
	public HealthThemeTask selectServiceTaskById(String id) {
		return healthThemeTaskMapper.selectServiceTaskById(id);
	}

	@Override
	public List<HealthThemeServiceItem> selectServiceHealthThemeServiceItem(Integer id) {
		return healthThemeTaskMapper.selectServiceHealthThemeServiceItem(id);
	}

	@Override
	public HealthThemeTemplate selectHealthThemeTemplate(Integer themeId) {
		return healthThemeTaskMapper.selectHealthThemeTemplate(themeId);
	}

	@Override
	@AutoPage
	public  List<HealthThemeServiceItemJoinDoctor> selectHealthThemeServiceItemJoinDoctor(Integer themeTaskId) {
		return healthThemeTaskMapper.selectHealthThemeServiceItemJoinDoctor(themeTaskId);
	}
	/**
	 * 修改发布时间
	 */
	@Override
	public void updateReleaseTime(HealthThemeTask themeTask) {
		healthThemeTaskMapper.updateByPrimaryKey(themeTask);
	}

	/**
	 * 查询主题任务列表
	 * @param blocId
	 * @return
	 */
	@Override
	public List<HealthThemeTask> findTask(Integer blocId) {
		List<HealthThemeTask>tasks=new ArrayList<>();
		List<HealthThemeTask>healthThemeTasks=healthThemeTaskMapper.findTask(blocId);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//过滤掉结束的任务
		for(HealthThemeTask h:healthThemeTasks){
			String startTime=simpleDateFormat.format(h.getServiceStartTime());
			String endTime=simpleDateFormat.format(h.getServiceEndTime());
			//未开始
			if(!DateUtil.dataCompare(startTime)){
				tasks.add(h);
			}
		}
		return tasks;
	}

	/**
	 *根据条件查询主题任务
	 * @param archivalNumber 档案号
	 * @param themeName 主题名称
	 * @param status 状态
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectTasks(String archivalNumber, String themeName, String status) {
		List<Map<String,Object>>datas=new ArrayList<>();
		//根据档案号查询blocId
		Long  blocId=customerInformationMapper.findBlocIdByArchivalNumber(archivalNumber);
		//根据blocId查询所有的健康任务
		List<Map<String,Object>>tasks=healthThemeTaskMapper.findTaskByBlocIdAndThemeName(blocId,themeName);
		//获取ftp信息
		Map<String,String>ftpData=PropertiesUtil.getPropertiesValue(new String[]{"host"});
		String host=ftpData.get("host");
		for (Map<String,Object>map:tasks) {
			//查询当前用户是否参与此服务
		    Integer taskId=Integer.valueOf(map.get("id").toString());
			TodayServiceCustomers  todayServiceCustomers=todayServiceCustomersMapper.findCustomersByTaskIdAndArchivalNumber(taskId,archivalNumber);
			if(Validator.isEmpty(todayServiceCustomers)){
				map.put("is_join",2);//未参与
			}else{
				map.put("is_join",1);//已参与
			}
			String startTime=DateUtil.formatConversion(map.get("service_start_time"));
			String endTime=DateUtil.formatConversion(map.get("service_end_time"));
			map.put("service_start_time",startTime);
			map.put("release_time",DateUtil.formatConversion(map.get("release_time")));
			if(!Validator.isEmpty(map.get("img_url"))){
				map.put("img_url",host+map.get("img_url").toString());
			}else{
				map.put("img_url","");
			}
			//未开始
			if(!DateUtil.dataCompare(startTime)){
				map.put("status",1);
				if("1".equals(status)){
					datas.add(map);
				}
			}else{
				if(!DateUtil.dataCompare(endTime)){
					map.put("status",2);
					//进行中
					if("2".equals(status)){
						datas.add(map);
					}
				}else{
					map.put("status",3);
					//已结束
					if("3".equals(status)){
						datas.add(map);
					}

				}
			}

		}
		if(Validator.isEmpty(themeName) && !Validator.isEmpty(status)){
             return datas;
		}
		sortList(tasks);
		return tasks;
	}

	/**
	 *服务进程 App
	 * @param archivalNumber 档案号
	 * @param themeTaskId 主题任务Id
	 * @return
	 */
	@Override
	public List<Map<String, Object>> serviceProcess(String archivalNumber, Integer themeTaskId) {
		List<Map<String,Object>>datas=new ArrayList<>();
		Map<String,Object>map=new HashedMap();
		HealthThemeTask healthThemeTask=healthThemeTaskMapper.selectByPrimaryKey(themeTaskId);
		map.put("themeName",healthThemeTask.getThemeName());
		map.put("startTime",DateUtil.formatConversion(healthThemeTask.getServiceStartTime()));
		map.put("serviceAddress",healthThemeTask.getServiceAddress());
		//用户头像
		CustomerInformation customerInformation=customerInformationMapper.selectCustomerInformationByArchivalNumber(archivalNumber);
		map.put("headImg",customerInformation.getPicture());
		//是否报名
		map.put("isSign",isSign(themeTaskId,archivalNumber));
		//查询所有的服务项目
		List<TodayServiceCustomersItem>todayServiceCustomersItems=todayServiceCustomersItemMapper.findServiceItemProcess(archivalNumber,themeTaskId);
		//过滤处理中项目 status=3
		List<TodayServiceCustomersItem> filterList = todayServiceCustomersItems.stream().filter(todayServiceCustomersItem -> todayServiceCustomersItem.getStatus() != 3).collect(Collectors.toList());
		map.put("serviceProcess",filterList);
		datas.add(map);
		return datas;
	}

	/**
	 * 服务日信息 App
	 * @param themeTaskId 主题任务ID
	 * @return
	 */
	@Override
	public Map<String, Object> serviceInformation(Integer themeTaskId) {
		Map<String,Object>map=new HashMap<>();
		HealthThemeTask healthThemeTask=healthThemeTaskMapper.selectByPrimaryKey(themeTaskId);
		map.put("themeName",healthThemeTask.getThemeName());
		map.put("themeTaskId",healthThemeTask.getId());
		map.put("serviceIntroduction",healthThemeTask.getServiceIntroduction());
		map.put("managementTarget",healthThemeTask.getManagementTarget());
		//服务人群关联因素
	    Integer themeId= healthThemeTask.getThemeId();
	    HealthThemeTemplate healthThemeTemplate=healthThemeTemplateMapper.selectByPrimaryKey(themeId);
	    List<String>serviceGroup=getFactors(healthThemeTemplate);
	    map.put("serviceGroup",serviceGroup);
	    // 服务项目
		List<HealthThemeServiceItem> serviceItems=healthThemeServiceItemMapper.findItemsByTaskId(themeTaskId);
		map.put("serviceItems",serviceItems);
		//服务团队
		List<Map<String,Object>>serviceTeam=findServiceTeamDetail(themeTaskId);
		map.put("serviceTeam",serviceTeam);
		return map;
	}
	/**
	 * 特色服务项目介绍
	 * @param itemName
	 * @param themeTaskId
	 * @return
	 */
	@Override
	public  Map<String,Object> itemIntroduce(Integer themeTaskId,String itemName) {
		Map<String,Object>map=new HashMap<>();
		String datas= healthThemeServiceItemMapper.findServiceIntroduction(themeTaskId,itemName);
		if(!Validator.isEmpty(datas)){
			map.put("serviceContent",datas);
		}else{
			map.put("serviceContent","");
		}
		return map;
	}

	/**
	 * 查询服务团队
	 * @param themeTaskId
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findSerivceTeam(Integer themeTaskId) {
		//服务团队
		List<Map<String,Object>>serviceTeam=findServiceTeamDetail(themeTaskId);
		return serviceTeam;
	}
	/**
	 *报名
	 * @param themeTaskId 主题任务id
	 * @return
	 */
	@Override
	public Map<String, Object> findActivityIdByTaskId(Integer themeTaskId) {
		Map<String,Object>map=new HashMap<>();
		ThemeTaskActivity themeTaskActivity=healthThemeTaskMapper.findActivityIdByTaskId(themeTaskId);
		map.put("activityId",themeTaskActivity.getActivityId());
	    Integer days=DateUtil.differentDaysByMillisecond(new Date(),themeTaskActivity.getActivityStarttime());
	    map.put("startTime",days);
		return map;
	}

	/**
	 * 预约到访时间
	 * @param themeTaskId
	 * @return
	 */
	@Override
	public Map<String, Object> findAppointmentTime(Integer themeTaskId) {
		Map<String,Object>map=new HashMap<>();
		//查询时间段
		List<ReservationTime> reservationTimes=reservationTimeMapper.findReservationTimeByTaskId(themeTaskId);
		if(Validator.isEmpty(reservationTimes)){
			map.put("status",0);
			return map;
		}else{
			map.put("status",1);
		}
		HealthThemeTask healthThemeTask=healthThemeTaskMapper.selectByPrimaryKey(themeTaskId);
		List<String>dates=DateUtil.getDatesBetweenTwoDate(healthThemeTask.getServiceStartTime(),healthThemeTask.getServiceEndTime());
		map.put("dates",dates);
		//剩余报名人数
		int serviceCeiling=healthThemeTask.getServiceCeiling();
		if(serviceCeiling==0){
			map.put("serviceCeiling","");//人数不限制
		}else{
		  List<TodayServiceCustomers>todayServiceCustomersList=todayServiceCustomersMapper.findStatusCustomersByTaskId(themeTaskId);
		  if (Validator.isEmpty(todayServiceCustomersList)){

		  }else{
			  for (TodayServiceCustomers todayServiceCustomers:todayServiceCustomersList) {
				  String source=todayServiceCustomers.getSource();
				  if(source.contains("1")){
					  --serviceCeiling;
					 }
			  }
		  }
			map.put("serviceCeiling",serviceCeiling);
		}
		List<ReservationTime>amList=new ArrayList<>();
		List<ReservationTime>pmList=new ArrayList<>();
		for (ReservationTime reservationTime:reservationTimes) {
			if("上午".equals(reservationTime.getMorningOrAfternoon())){
				amList.add(reservationTime);
			}
			else{
				pmList.add(reservationTime);
			}
		}
		map.put("amDates",amList);//上午
		map.put("pmDates",pmList);//下午
		return map;
	}

	/**
	 * 内文消息接口
	 * @param archivalNumber 档案号
	 * @param themeTaskId 主题任务Id
	 * @return
	 */
	@Override
	public Map<String, Object>findTextMessage(String archivalNumber, Integer themeTaskId) {
		  Map<String,Object>map=new HashMap<>();
		  //获取ftp信息
		  Map<String,String>ftpData=PropertiesUtil.getPropertiesValue(new String[]{"host"});
		  String host=ftpData.get("host");
          HealthThemeTask h=healthThemeTaskMapper.selectByPrimaryKey(themeTaskId);
		  String startTime=DateUtil.formatConversion(h.getServiceStartTime());
		  map.put("serviceStartTime",startTime);
		  map.put("themeName",h.getThemeName());
		  map.put("serviceAddress",h.getServiceAddress());
		  map.put("imgUrl",Validator.isEmpty(h.getImgUrl())?"":host+h.getImgUrl());
		  //用户信息
		  CustomerInformation customerInformation=customerInformationMapper.selectCustomerInformationByArchivalNumber(archivalNumber);
		  map.put("name",customerInformation.getName());
		  map.put("sex",customerInformation.getSex());
          map.put("isSign",isSign(themeTaskId,archivalNumber));
		 //特色服务项目
		 List<HealthThemeServiceItem> serviceItems=healthThemeServiceItemMapper.findItemsByTaskId(themeTaskId);
		 map.put("serviceItems",serviceItems);
		 return map;
	}

	/**
	 * 是否报名
	 * @param themeTaskId
	 * @param archivalNumber
	 * @return
	 */
    public String  isSign(Integer themeTaskId,String archivalNumber){
		String isSign="1";
		//是否报名
		TodayServiceCustomers todayServiceCustomers=todayServiceCustomersMapper.findCustomersByTaskIdAndArchivalNumber(themeTaskId,archivalNumber);
		if(Validator.isEmpty(todayServiceCustomers)){
		}else{
			String source=todayServiceCustomers.getSource();
			if(source.contains("1")){
				isSign="2";
			}
		}
		return  isSign;
	}
	/**
	 * 排序
	 */
    public void sortList(List<Map<String,Object>>list){
		//查询列表  排序按照未开始  一开始  结束
		Collections.sort(list, new Comparator<Map<String,Object>>() {
			public int compare(Map o1, Map o2) {
				return o1.get("status").toString().compareTo(o2.get("status").toString());
			}
		});
	}
	/**
	 * 获取关联因素
	 */
	public  List<String> getFactors(HealthThemeTemplate healthThemeTemplate){
		 List<String>serviceGroup=new ArrayList<>();
		if(!Validator.isEmpty(healthThemeTemplate.getMainProblem())){
			serviceGroup.add(healthThemeTemplate.getMainProblem());
		}
		if(!Validator.isEmpty(healthThemeTemplate.getMainSymptom())){
			serviceGroup.add(healthThemeTemplate.getMainSymptom());
		}
		if(!Validator.isEmpty(healthThemeTemplate.getPositiveIndex())){
			serviceGroup.add(healthThemeTemplate.getPositiveIndex());
		}
		if(!Validator.isEmpty(healthThemeTemplate.getHealthRisk())){
			serviceGroup.add(healthThemeTemplate.getHealthRisk());
		}
		if(!Validator.isEmpty(healthThemeTemplate.getAgeGroup())){
			serviceGroup.add(healthThemeTemplate.getAgeGroup());
		}
         return  serviceGroup;
	}
	/**
	 * 查询服务团队
	 */
	public  List<Map<String,Object>> findServiceTeamDetail(Integer themeTaskId){
		List<Map<String,Object>>serviceTeam=healthThemeServiceItemJoinDoctorMapper.findSeriveceTeam(themeTaskId);
		for (Map<String,Object>dataMap:serviceTeam) {
			String headImg="";
			if(!Validator.isEmpty(dataMap.get("picture"))){
				headImg=dataMap.get("picture").toString();
			}
			dataMap.put("headImg",headImg);
		}
		return serviceTeam;
	}
}
