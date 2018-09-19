package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.pojo.entity.HealthThemeTask;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.service.HealthThemeTaskService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 主题任务控制器
 * @author admin
 *
 */
@Controller
@RequestMapping("/healthThemeTask")
public class HealthThemeTaskController {
	@Resource
	private HealthThemeTaskService healthThemeTaskService;
	/**
	 * 进入任务列表页
	 * @param request
	 * @param modelMap
	 * @param map
	 * @return
	 */
	@GetMapping("/selectAll")
	public String selectAll(
			HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
	return "healthThemeTask/list";
	}
	/**
	 * 查询任务数据
	 * @param request
	 * @param modelMap
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@GetMapping("/findAllTask")
	public ResultVO findAllTask(
			HttpServletRequest request,ModelMap modelMap,@RequestParam Map<String,Object>map){
		List<Map<String,Object>>tasks=healthThemeTaskService.selectAllTasks(map);
		return ResultVO.success(new PageInfo<Map<String,Object>>(tasks));
	}
	/**
	 * 查询任务数据
	 * @param request
	 * @param modelMap
	 * @param map
	 * @return
	 */
	
	@GetMapping("/selectReleaseTime")
	public String selectReleaseTime(
			HttpServletRequest request,ModelMap modelMap,@RequestParam("taskId") String taskId){
	     HealthThemeTask themeTask=healthThemeTaskService.selectServiceTaskById(taskId);
	     modelMap.put("themeTask", themeTask);
		return "healthThemeTask/selectReleaseTime";
	}
	/**
	 * 查询任务数据
	 * @param request
	 * @param modelMap
	 * @param map
	 * @return
	 */
	@ResponseBody
	@PostMapping("/publish")
	public ResultVO publish(
			HttpServletRequest request,ModelMap modelMap,@RequestParam("taskId") String taskId,@RequestParam("releaseTime") String releaseTime){
		HealthThemeTask themeTask=healthThemeTaskService.selectServiceTaskById(taskId);
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(releaseTime);
			themeTask.setReleaseTime(date);
			healthThemeTaskService.updateReleaseTime(themeTask);
		} catch (ParseException e) {
			return ResultVO.error(0, "发布失败");
		}
		return ResultVO.success();
	}


  
}
