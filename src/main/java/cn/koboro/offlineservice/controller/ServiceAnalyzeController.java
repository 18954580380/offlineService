package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.service.ServiceAnalyzeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 线下服务汇总调度器
 * @author admin
 *
 */
@Controller
@RequestMapping("/serviceAnalyze")
public class ServiceAnalyzeController {
	@Resource
	private ServiceAnalyzeService serviceAnalyzeService;
	/**
	 * 进入线下服务汇总任务列表
	 * @return
	 */
	@GetMapping("/list")
	public String list(){
		return "serviceAnalyze/list";
	}
	
	/**
	 * 线下服务汇总详情 任务列表数据
	 * @param request
	 * @param map
	 * @return
	 */
	@ResponseBody
	@GetMapping("/selectAllData")
	public ResultVO selectAllData(HttpServletRequest request,@RequestParam Map<String,Object>map){
		List<Map<String,Object>>datas=serviceAnalyzeService.selectAllData(map);
		return ResultVO.success(new PageInfo<Map<String,Object>>(datas));
	}
	/**
	 * 今日服务情况汇总头部数据
	 * @param request
	 * @param map
	 * @return
	 */
	@GetMapping("/serviceStatistics")
	public String serviceStatistics(HttpServletRequest request,@RequestParam Map<String,Object>map,ModelMap modelMap){
		//基础信息
		List<Map<String,Object>>baseDatas=serviceAnalyzeService.selectAllData(map);
		//各项目服务人数
		List<Map<String,Object>>itemServiceNumber=serviceAnalyzeService.findServiceNumber(map);
		//邀约服务情况
		Map<String,Object>inviteCase=serviceAnalyzeService.findInviteCase(map);
		//健康管理师和医生
		List<Map<String,Object>>doctorDetail=serviceAnalyzeService.findDoctorDetail(map);
		modelMap.put("taskId", map.get("taskId"));
		modelMap.put("inviteCase", inviteCase);
		modelMap.put("doctorDetail", doctorDetail);
		modelMap.put("baseDatas", baseDatas);
		modelMap.put("itemServiceNumber", itemServiceNumber);
		return "serviceAnalyze/detail";
	}
	/**
	 * 查询用户和服务项目
	 * @param request
	 * @param map
	 * @return
	 */
	@ResponseBody
	@GetMapping("/findServiceDetail")
	public ResultVO findServiceDetail(HttpServletRequest request,@RequestParam Map<String,Object>map){
		List<Map<String,Object>>customerServices=serviceAnalyzeService.findServiceDetail(map);
		return ResultVO.success(new PageInfo<Map<String,Object>>(customerServices));
	}

}
