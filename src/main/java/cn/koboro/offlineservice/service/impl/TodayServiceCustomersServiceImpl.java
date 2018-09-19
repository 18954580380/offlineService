package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.CustomerInformation;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.repository.CustomerInformationMapper;
import cn.koboro.offlineservice.repository.TodayServiceCustomersMapper;
import cn.koboro.offlineservice.service.TodayServiceCustomersService;
import cn.koboro.offlineservice.utils.Validator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class TodayServiceCustomersServiceImpl implements TodayServiceCustomersService {
	@Resource
	private TodayServiceCustomersMapper todayServiceCustomersMapper;
	@Resource
	private CustomerInformationMapper customerInformationMapper;
	/**
	 * 根据当前登陆者和时间查询主题任务信息
	 */
	@Override
	@AutoPage
	public List<Map<String,Object>> findTasksByLoginNameAndDate(Integer doctorId, String date) {
		return todayServiceCustomersMapper.findTasksByLoginNameAndDate(doctorId,date);
	}
	/**
	 * 查询当前任务下所有的客户
	 */
	@AutoPage
	@Override
	public List<TodayServiceCustomers> findCustomersByTaskId(Integer taskId,Map<String,Object>map) {
		 //获取所有的参数
		TodayServiceCustomers todayServiceCustomers=new TodayServiceCustomers();
		Integer status=Validator.isEmpty(map.get("status"))?0:Integer.valueOf(map.get("status").toString());
		String  dept=Validator.isEmpty(map.get("dept"))?"":map.get("dept").toString();
		String  phoneNumber=Validator.isEmpty(map.get("phoneNumber"))?"":map.get("phoneNumber").toString();
		String  name=Validator.isEmpty(map.get("name"))?"":map.get("name").toString();
		String  source=Validator.isEmpty(map.get("source"))?"":map.get("source").toString();
		String  morningOrAfternoon=Validator.isEmpty(
				map.get("morningOrAfternoon"))?"":map.get("morningOrAfternoon").toString();
		todayServiceCustomers.setStatus(status);
		todayServiceCustomers.setDept(dept);
		todayServiceCustomers.setPhoneNumber(phoneNumber);
		todayServiceCustomers.setName(name);
		todayServiceCustomers.setSource(source);
		if(!Validator.isEmpty(map.get("timeQuantum"))){
		     try {
		     	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     	 Date time=sdf.parse(map.get("timeQuantum").toString());
				 todayServiceCustomers.setTimeQuantum(time);
			 }catch (Exception e){

			 }

		}
		todayServiceCustomers.setThemeTaskId(taskId);
		todayServiceCustomers.setMorningOrAfternoon(morningOrAfternoon);
		return todayServiceCustomersMapper.findCustomersByTaskId(todayServiceCustomers);
	}
	/**
	 * 根据Id查询今日服务对象
	 */
	@Override
	public TodayServiceCustomers findTodayServiceCustomersById(Integer customersId) {
		return todayServiceCustomersMapper.selectByPrimaryKey(customersId);
	}
	/**
	 * 查询任务每种状态下的人数
	 */
	@Override
	public List<TodayServiceCustomers> findStatusCustomersByTaskId(Integer taskId) {
		return todayServiceCustomersMapper.findStatusCustomersByTaskId(taskId);
	}
	/**
	 * 查询服务记录
	 */
	@Override
	public List<Map<String, Object>> findServiceRecord(String archivalNumber,String date) {
		
		return todayServiceCustomersMapper.findServiceRecord(archivalNumber,date);
	}
	/**
	 * 更新用户本次服务完成状态
	 */
	@Override
	public void updateStatus(String archivalNumber, Integer themeTaskId) {
		todayServiceCustomersMapper.updateStatus(archivalNumber,themeTaskId);
		
	}

	@Override
	public void updatetodayServiceCustomers(TodayServiceCustomers todayServiceCustomers) {
		todayServiceCustomersMapper.updateByPrimaryKeySelective(todayServiceCustomers);
	}

	/**
	 * 报名
	 * @param todayServiceCustomers
	 * @return
	 */
	@Override
	public int applyTask(TodayServiceCustomers todayServiceCustomers) {
		Integer  taskId=todayServiceCustomers.getThemeTaskId();
		String archivalNumber=  todayServiceCustomers.getArchivalNumber();
		//查询是否存在记录,存在更新source字段
		TodayServiceCustomers tsc=todayServiceCustomersMapper.findCustomersByTaskIdAndArchivalNumber(taskId,archivalNumber);
        if(!Validator.isEmpty(tsc)){
        	String source=tsc.getSource();
        	tsc.setSource(source+",1");
			tsc.setUpdateTime(new Date());
			tsc.setTimeQuantum(todayServiceCustomers.getTimeQuantum());
			return todayServiceCustomersMapper.updateByPrimaryKey(tsc);
		}
	    //新建
   		CustomerInformation customerInformation= customerInformationMapper.selectCustomerInformationByArchivalNumber(archivalNumber);
        todayServiceCustomers.setSource("1");
        todayServiceCustomers.setCreateTime(new Date());
		todayServiceCustomers.setDeptId(customerInformation.getDeptId());
		todayServiceCustomers.setDept(customerInformation.getDept());
		todayServiceCustomers.setIsJoin(1);
		todayServiceCustomers.setDoctorflag(0);
		todayServiceCustomers.setName(customerInformation.getName());
		todayServiceCustomers.setPhoneNumber(customerInformation.getPhoneNumber());
		todayServiceCustomers.setSex(customerInformation.getSex().equals("男")?1:2);
		todayServiceCustomers.setStatus(1);
		return todayServiceCustomersMapper.insert(todayServiceCustomers);
	}
}
