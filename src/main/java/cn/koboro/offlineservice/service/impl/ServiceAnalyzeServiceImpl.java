package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.repository.ServiceAnalyzeMapper;
import cn.koboro.offlineservice.service.ServiceAnalyzeService;
import cn.koboro.offlineservice.utils.Validator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ServiceAnalyzeServiceImpl implements ServiceAnalyzeService {
	@Resource
	private  ServiceAnalyzeMapper serviceAnalyzeMapper;
    /**
     * 服务汇总详情列表
     */
	@AutoPage
	@Override
	public List<Map<String, Object>> selectAllData(Map<String, Object> map) {
		String blocName=Validator.isEmpty(
				map.get("blocName"))?"":map.get("blocName").toString();
		String themeName=Validator.isEmpty(
				map.get("themeName"))?"":map.get("themeName").toString();
		String date=Validator.isEmpty(
				map.get("date"))?"":map.get("date").toString();
		String taskId=Validator.isEmpty(
				map.get("taskId"))?"":map.get("taskId").toString();
		List<Map<String,Object>>datas=serviceAnalyzeMapper.selectAllData(blocName,themeName,date,taskId);
		return datas;
	}
	/**
	 * 各项目服务人数
	 */
	@Override
	public List<Map<String, Object>> findServiceNumber(Map<String, Object> map) {
		Integer taskId=Integer.valueOf(map.get("taskId").toString());
		List<Map<String, Object>> itemServiceNumber=serviceAnalyzeMapper.findServiceNumber(taskId);
		return itemServiceNumber;
	}
	/**
	 * 邀约情况
	 */
	@Override
	public Map<String,Object> findInviteCase(Map<String, Object> map) {
		Integer taskId=Integer.valueOf(map.get("taskId").toString());
		//查询本次任务所有的客户
		List<TodayServiceCustomers>customers=serviceAnalyzeMapper.findCustomersByTaskId(taskId);
		return getSourceNumber(customers);
	}
	/**
	 * 查询本次服务任务下的健康管理师和医生
	 */
     @Override
	public List<Map<String, Object>> findDoctorDetail(Map<String, Object> map) {
		return serviceAnalyzeMapper.findDoctorDetail(
				Integer.valueOf(map.get("taskId").toString()));
	}
     /**
      * 查询客户列表以及服务项目
      */
     @AutoPage
     @Override
     public List<Map<String, Object>> findServiceDetail(Map<String, Object> map) {
     	return serviceAnalyzeMapper.findServiceDetail(
				Integer.valueOf(map.get("taskId").toString()));
     }
   /**
    * 获取每种来源人数
    */
	public  Map<String, Object> getSourceNumber(List<TodayServiceCustomers>customers){
		        Map<String,Object>map=new HashMap<String,Object>();
		        //定义每种来源变量
				Integer filtrateCustomers=0;//主题筛选
				Integer applyCustomers=0;// 报名
				Integer notCompleteTaskCustomers=0;//任务未完成
				Integer notComplateSetMealCustomers=0;//套餐未完成
				Integer notServiceCustomers=0;//上次未服务
				Integer customCustomer=0;//自定义客户
				Integer totleCustomeer=customers.size();
				for(TodayServiceCustomers c:customers){
					if(!Validator.isEmpty(c.getSource())){
						String source=c.getSource();
						if(source.contains("0")){
							filtrateCustomers+=1;
						}
						if(source.contains("1")){
							applyCustomers+=1;
						}
						if(source.contains("2")){
							notCompleteTaskCustomers+=1;
						}
						if(source.contains("3")){
							notComplateSetMealCustomers+=1;
						}
						if(source.contains("4")){
							notServiceCustomers+=1;
						}
						if(source.contains("5")){
							customCustomer+=1;
						}
					}
				}
				map.put("filtrateCustomers", filtrateCustomers);
				map.put("applyCustomers", applyCustomers);
				map.put("notCompleteTaskCustomers", notCompleteTaskCustomers);
				map.put("notComplateSetMealCustomers", notComplateSetMealCustomers);
				map.put("notServiceCustomers", notServiceCustomers);
				map.put("customCustomer", customCustomer);
				map.put("totleCustomeer", totleCustomeer);
				return map;
	}
	
}
