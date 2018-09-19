package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.pojo.entity.HealthThemeServiceItemJoinDoctor;
import cn.koboro.offlineservice.pojo.entity.KoboroDoctor;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomersItem;
import cn.koboro.offlineservice.repository.HealthThemeServiceItemJoinDoctorMapper;
import cn.koboro.offlineservice.repository.TodayServiceCustomersItemMapper;
import cn.koboro.offlineservice.repository.TodayServiceCustomersMapper;
import cn.koboro.offlineservice.service.TodayServiceCustomersItemService;
import cn.koboro.offlineservice.utils.Validator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class TodayServiceCustomersItemServiceImpl implements TodayServiceCustomersItemService {
	@Resource
	private TodayServiceCustomersItemMapper  todayServiceCustomersItemMapper;
	@Resource
	private TodayServiceCustomersMapper todayServiceCustomersMapper;
	@Resource
	private HealthThemeServiceItemJoinDoctorMapper healthThemeServiceItemJoinDoctorMapper;
    /**
     * 保存为用户选择的项目
     */
	@Override
	public boolean saveServiceItem(Map<String, Object> map) {
		//保存医生项目关联表
		saveDoctorItme(map);
		List<TodayServiceCustomersItem>list=mergeItem(map);
		//循环保存用户项目关系表
		for(TodayServiceCustomersItem tsi:list){
			todayServiceCustomersItemMapper.insert(tsi);
		}
		//根据用户主键 更新新用户服务状态,完成情况,修改时间
		if(list.size()>0){
			//用户表主键Id
			Integer customersId=Integer.valueOf(map.get("customersId").toString());
			TodayServiceCustomers todayServiceCustomers=todayServiceCustomersMapper.selectByPrimaryKey(customersId);
			String completeStatus="0/"+list.size();
			todayServiceCustomers.setCompleteStatus(completeStatus);
			todayServiceCustomers.setStatus(1);
			todayServiceCustomers.setUpdateTime(new Date());
			todayServiceCustomersMapper.updateByPrimaryKey(todayServiceCustomers);
		}
		return list.size()==0?false:true;
	}
	/**
	 * 保存医生项目关联表
	 */
	public void saveDoctorItme(Map<String, Object> map){
		KoboroDoctor koboroDoctor=(KoboroDoctor) map.get("koboroDoctor");
		String otherServiceItems=Validator.isEmpty(
				  map.get("otherServiceItems"))?"":map.get("otherServiceItems").toString();
		if(!Validator.isEmpty(otherServiceItems)){
			String item[]=otherServiceItems.split(",");
			//获取医生
			String doctors=map.get("otherServiceDoctor").toString();
			String[]doctorArr=doctors.split(";");
			for (int i = 0; i < doctorArr.length; i++) {
				String arr=doctorArr[i];
				String [] info=arr.split(",");
				HealthThemeServiceItemJoinDoctor healthThemeServiceItemJoinDoctor=new HealthThemeServiceItemJoinDoctor();
				healthThemeServiceItemJoinDoctor.setCreatedTime(new Date());
				healthThemeServiceItemJoinDoctor.setCreator(koboroDoctor.getDoctorName());
				healthThemeServiceItemJoinDoctor.setDoctorId(koboroDoctor.getId());
				healthThemeServiceItemJoinDoctor.setCreator(koboroDoctor.getDoctorName());
				healthThemeServiceItemJoinDoctor.setDoctorName(info[0]);
				healthThemeServiceItemJoinDoctor.setServiceProject(item[i]);
				healthThemeServiceItemJoinDoctor.setCreatorId(Long.valueOf(koboroDoctor.getId().toString()));
				healthThemeServiceItemJoinDoctor.setThemeTaskId(Integer.valueOf(map.get("taskId").toString()));
				healthThemeServiceItemJoinDoctor.setType(1);
				healthThemeServiceItemJoinDoctorMapper.insert(healthThemeServiceItemJoinDoctor);
			}
		}
	}
	/**
	 * 根据用户信息查询用户本次服务项目
	 */
	@Override
	public List<Map<String, Object>> findItemsByCus(TodayServiceCustomers todayServiceCustomers) {
		return todayServiceCustomersItemMapper.findItemsByCus(todayServiceCustomers);
	}
	 /**
	  * 放弃任务
	  */
	@Override
	public void abortMission(Map<String, Object> map) {
		String archivalNumber=map.get("archivalNumber").toString();
	    Integer themeTaskId=Integer.valueOf(map.get("themeTaskId").toString());
	    String serviceItems=map.get("serviceItems").toString();
		 String []items=serviceItems.split(",");
		 for(String item:items){
			 //删除放弃的任务
			 todayServiceCustomersItemMapper.deleteCustomersItems(archivalNumber,themeTaskId,item); 
		 }
		
	}
	/**
	 * 查询完成情况
	 */
	@Override
	public String findCompleteDetail(String archivalNumber, Integer themeTaskId) {		List<Map<String,Object>>datas=todayServiceCustomersItemMapper.findCompleteDetail(archivalNumber,themeTaskId);
		//总任务数量
		Integer itemNumber=0;
		Integer completeNumber=0;
		for(Map<String,Object>map:datas){
			if(!Validator.isEmpty(map.get("number"))){
				itemNumber+=Integer.valueOf(map.get("number").toString());
				if(
				    Integer.valueOf(map.get("status").toString())==1){
					completeNumber+=Integer.valueOf(map.get("number").toString());
				}
			}
		}
			return completeNumber.toString()+"/"+itemNumber.toString();
	}
	
	 /**
	  * 将页面传递的本次服务项目和自定义项目进行处理
	  * @param map
	  * @return
	  */
	private List<TodayServiceCustomersItem> mergeItem(Map<String,Object>map){
		KoboroDoctor koboroDoctor=(KoboroDoctor) map.get("koboroDoctor");
		Integer customersId=Integer.valueOf(map.get("customersId").toString());
		Integer  taskId=Integer.valueOf(map.get("taskId").toString());
		List<TodayServiceCustomersItem>list=new ArrayList<>();
		if(!Validator.isEmpty(map.get("serviceItems"))){
			list.addAll(strChangeArr(map.get("serviceItems").toString(),0,customersId,taskId,koboroDoctor));
		}
		if(!Validator.isEmpty(map.get("otherServiceItems"))){
			list.addAll(strChangeArr(map.get("otherServiceItems").toString(),1,customersId,taskId,koboroDoctor));
		}
		return list;
	}
	 /**
	  * 字符串转为数组存放list
	  */
	 public List<TodayServiceCustomersItem>strChangeArr(String str,Integer itemsType,Integer customersId,Integer taskId,KoboroDoctor koboroDoctor){
		 List<TodayServiceCustomersItem>list=new ArrayList<>();
		 TodayServiceCustomers TodayServiceCustomers=todayServiceCustomersMapper.selectByPrimaryKey(customersId);
		 String [] itemArr=str.split(",");
		 for(String item:itemArr){
			 TodayServiceCustomersItem todayServiceCustomersItem=new TodayServiceCustomersItem();
			 todayServiceCustomersItem.setServedItems(item);
			 todayServiceCustomersItem.setArchivalNumber(TodayServiceCustomers.getArchivalNumber());
			 todayServiceCustomersItem.setName(TodayServiceCustomers.getName());
			 todayServiceCustomersItem.setOperator(koboroDoctor.getDoctorName());
			 todayServiceCustomersItem.setPhoneNumber(TodayServiceCustomers.getPhoneNumber());
			 todayServiceCustomersItem.setItemsType(itemsType);
			 todayServiceCustomersItem.setStatus(0);
			 todayServiceCustomersItem.setThemeTaskId(taskId);
				list.add(todayServiceCustomersItem);
			}
			return list;
	 }
}
