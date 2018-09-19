package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.pojo.entity.HealthThemeServiceItem;
import cn.koboro.offlineservice.repository.HealthThemeServiceItemMapper;
import cn.koboro.offlineservice.service.HealthThemeServiceItemService;
import cn.koboro.offlineservice.utils.Validator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class HealthThemeServiceItemServiceImpl implements HealthThemeServiceItemService {
	@Resource
	private  HealthThemeServiceItemMapper healthThemeServiceItemMapper;
    /**
     * 根据主题任务Id,查询所有的项目
     */
	@Override
	public List<HealthThemeServiceItem> findItemsByTaskId(Integer taskId) {
		return healthThemeServiceItemMapper.findItemsByTaskId(taskId);
	}
	/**
	 * 查询更多服务项目
	 */
	@Override
	public List<Map<String, Object>> findOtherItems(Map<String,Object>map) {
		String name=Validator.isEmpty(map.get("name"))?"":map.get("name").toString();
		List<Map<String, Object>> items=healthThemeServiceItemMapper.findOtherItems(name);
		return splitItems(items);
	}
   /**
    * 处理拼接的项目内容
    */
	private List<Map<String,Object>> splitItems(List<Map<String,Object>>items){
		for(Map<String,Object>map:items){
			List<String>itemContent=new ArrayList<>();
			if(!Validator.isEmpty(map.get("item"))){
				itemContent= Arrays.asList(map.get("item").toString().split(","));
			}
			map.put("itemContent",itemContent);
		}
		return items;
	}
	/**
	 * 查询所有的医生管理师
	 */
	@Override
	public List<Map<String, Object>> findDoctors() {
	   return healthThemeServiceItemMapper.findDoctors();
	}
}
