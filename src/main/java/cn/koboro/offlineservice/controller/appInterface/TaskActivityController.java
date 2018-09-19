package cn.koboro.offlineservice.controller.appInterface;

import cn.koboro.offlineservice.pojo.entity.HealthThemeTask;
import cn.koboro.offlineservice.pojo.entity.ThemeTaskActivity;
import cn.koboro.offlineservice.pojo.entity.TodayServiceCustomers;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.service.HealthThemeTaskService;
import cn.koboro.offlineservice.service.ThemeTaskActivityService;
import cn.koboro.offlineservice.service.TodayServiceCustomersService;
import cn.koboro.offlineservice.utils.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/taskActivity")
public class TaskActivityController {
    @Resource
    private HealthThemeTaskService healthThemeTaskService;
    @Resource
    private ThemeTaskActivityService themeTaskActivityService;
    @Resource
    private TodayServiceCustomersService todayServiceCustomersService;

    /**
     * 主题任务列表    活动后台使用
     *
     * @param blocId 集团Id
     * @return
     */
    @ResponseBody
    @GetMapping("/findTask")
    public ResultVO findTask(@RequestParam("blocId") Integer blocId) {
        List<HealthThemeTask> healthThemeTasks = healthThemeTaskService.findTask(blocId);
        return ResultVO.success(healthThemeTasks);
    }

    /**
     * @param themeTaskActivity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addTaskActivity", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO addTaskActivity(ThemeTaskActivity themeTaskActivity) {
        themeTaskActivity.setCreateTime(new Date());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=sdf.parse(themeTaskActivity.getStartTime());
        }catch (Exception e){
            return ResultVO.error(0, "解析开始时间失败");
        }
        themeTaskActivity.setActivityStarttime(date);
        int count = themeTaskActivityService.addTaskActivity(themeTaskActivity);
        if (count == 1) {
            return ResultVO.success();
        }
        return ResultVO.error(0, "请求失败");
    }

    /**
     * 报名主题活动
     *
     * @param todayServiceCustomers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/applyTask", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO applyTask(TodayServiceCustomers todayServiceCustomers) {
        int count = todayServiceCustomersService.applyTask(todayServiceCustomers);
        if (count == 1) {
            return ResultVO.success();
        }
        return ResultVO.error(0, "请求失败");
    }

    /**
     * App健康主题日列表
     *
     * @param archivalNumber 档案号
     * @param themeName      主题名称
     * @param status         状态 1未开始 2进行中 3一结束
     * @return
     */
    @RequestMapping(value = "/selectTasks", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultVO selectTasks(@RequestParam("archivalNumber") String archivalNumber,
                                @RequestParam(defaultValue = "") String themeName,
                                @RequestParam(defaultValue = "") String status) {
        if (Validator.isEmpty(archivalNumber)) {
            return ResultVO.error(0, "档案号不能为空");
        }
        List<Map<String, Object>> data = healthThemeTaskService.selectTasks(archivalNumber, themeName, status);
        return ResultVO.success(data);
    }

    /**
     * 服务进程 APP
     *
     * @param archivalNumber 档案号
     * @param themeTaskId    服务主题任务Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/serviceProcess", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO serviceProcess(@RequestParam("archivalNumber") String archivalNumber,
                                   @RequestParam("themeTaskId") Integer themeTaskId) {
        if (Validator.isEmpty(archivalNumber) || Validator.isEmpty(themeTaskId)) {
            return ResultVO.error(0, "档案号和主题任务ID不能为空");
        }
        List<Map<String, Object>> datas = healthThemeTaskService.serviceProcess(archivalNumber, themeTaskId);
        return ResultVO.success(datas);
    }

    /**
     * 服务日信息 APP
     *
     * @param themeTaskId 健康主题任务ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/serviceInformation", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO serviceInformation(@RequestParam("themeTaskId") Integer themeTaskId) {
        if (Validator.isEmpty(themeTaskId)) {
            return ResultVO.error(0, "服务主题ID不能为空");
        }
        Map<String, Object> map = healthThemeTaskService.serviceInformation(themeTaskId);
        return ResultVO.success(map);
    }

    /**
     * 特色服务项目介绍   暂时废弃
     *
     * @param itemName 服务项目名称
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/itemIntroduce", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO itemIntroduce(@RequestParam("themeTaskId") Integer themeTaskId, @RequestParam("itemName") String itemName) {
        if (Validator.isEmpty(itemName)) {
            return ResultVO.error(0, "服务项目名称不能为空");
        }
        Map<String, Object> datas = healthThemeTaskService.itemIntroduce(themeTaskId, itemName);
        return ResultVO.success(datas);
    }

    /**
     * 服务团队介绍
     * @param themeTaskId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/serviceTeam", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO serviceTeam(@RequestParam("themeTaskId") Integer themeTaskId) {
        if (Validator.isEmpty(themeTaskId)) {
            return ResultVO.error(0, "主题任务Id不能为空");
        }
        List<Map<String, Object>> datas = healthThemeTaskService.findSerivceTeam(themeTaskId);
        return ResultVO.success(datas);
    }

    /**
     * 报名  入口健康主题
     * @param themeTaskId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/applyThemeTask", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO applyThemeTask(@RequestParam("themeTaskId") Integer themeTaskId) {
        if (Validator.isEmpty(themeTaskId)) {
            return ResultVO.error(0, "主题任务Id不能为空");
        }
        Map<String,Object>datas = healthThemeTaskService.findActivityIdByTaskId(themeTaskId);
        return ResultVO.success(datas);
    }
    /**
     * 预约到访时间
     * @param themeTaskId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/appointmentTime", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO appointmentTime(@RequestParam("themeTaskId") Integer themeTaskId) {
        if (Validator.isEmpty(themeTaskId)) {
            return ResultVO.error(0, "主题任务Id不能为空");
        }
        Map<String,Object>datas = healthThemeTaskService.findAppointmentTime(themeTaskId);
        return ResultVO.success(datas);
    }

    /**
     * 内文消息
     * @param archivalNumber 档案号
     * @param themeTaskId  主题任务Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/textMessage", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultVO textMessage(@RequestParam("archivalNumber") String archivalNumber,
                                   @RequestParam("themeTaskId") Integer themeTaskId) {
        if (Validator.isEmpty(archivalNumber) || Validator.isEmpty(themeTaskId)) {
            return ResultVO.error(0, "档案号和主题任务ID不能为空");
        }
        Map<String, Object>datas = healthThemeTaskService.findTextMessage(archivalNumber, themeTaskId);
        return ResultVO.success(datas);
    }
}