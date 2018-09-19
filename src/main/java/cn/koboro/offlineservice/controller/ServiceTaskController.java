package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.pojo.entity.*;
import cn.koboro.offlineservice.service.*;
import cn.koboro.offlineservice.utils.FileUpload;
import cn.koboro.offlineservice.utils.Validator;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 *
 */
@Controller
public class ServiceTaskController {

    @Resource
    private HealthThemeTaskService healthThemeTaskService;
    @Resource
    private HealthThemeTemplateService healthThemeTemplateService;
    @Resource
    private ServiceTaskService serviceTaskService;
    @Resource
    private CasCustomersService casCustomersService;
    @Resource
    private PendingCustomersService pendingCustomersService;

    /**
     * 跳转页面
     *
     * @param model
     * @return 服务任务新建列表
     */
    @GetMapping(value = "/ServiceTask/index")
    public String list(ModelMap model) {
        return "ServiceTask/index";
    }

    /**
     * 健康主题动态获取
     */
    @ResponseBody
    @GetMapping("/selectHealthThemeTemplate")
    public Map healthThemeTemplateSelectAll() {
        Map map = new HashMap();
        List<HealthThemeTemplate> list = healthThemeTemplateService.selectAll();
        map.put("healthThemeTemplates", list);
        return map;
    }

    /**
     * 服务集团动态获取
     */
    @ResponseBody
    @GetMapping("/servicesGroupSelectAll")
    public Map servicesGroupSelectAll() {
        Map map = new HashMap();
        List<KoboroBloc> list = serviceTaskService.selectServicesGroup();
        map.put("servicesGroup", list);
        return map;
    }

    /**
     * servicesAvailable
     * 服务项目动态获取
     */
    @ResponseBody
    @GetMapping("/servicesAvailableSelectAll")
    public Map servicesAvailableSelectAll() {
        Map map = new HashMap();
        List<ServicesAvailable> list = serviceTaskService.servicesAvailableSelectAll();
        map.put("servicesAvailable", list);
        return map;
    }

    /**
     * doctorSelectAll
     * 健康管理师-医生动态获取
     */
    @ResponseBody
    @GetMapping("/doctorSelectAll")
    public Map doctorSelectAll() {
        Map map = new HashMap();
        List<KoboroDoctor> list = serviceTaskService.doctorSelectAll();
        map.put("koboroDoctor", list);
        return map;
    }

    /**
     * addServiceTaskController
     * 新增
     */
    @GetMapping("/addServiceTaskController")
    public String addServiceTaskController(
            @RequestParam(value = "servicesAvailableSelect",required = false) String[] servicesAvailableSelect,
            @RequestParam(value = "itemCeiling",required = false) Integer[] itemCeiling,
            @RequestParam(value = "isCheck",required = false) String[] isCheck,
            @RequestParam(value = "itemContext",required = false) String[] itemContext,
            @RequestParam(value = "doctorName",required = false) String[] doctorName,
            @RequestParam(value = "managerName",required = false) String[] managerName,
            @RequestParam(value = "doctorId",required = false) Integer[] doctorId,
            @RequestParam(value = "managerId",required = false) Integer[] managerId,
            @RequestParam(value = "mainProblemName",required = false) String[] mainProblemName,
            @RequestParam(value = "mainSymptomName",required = false) String[] mainSymptomName,
            @RequestParam(value = "positiveindexName",required = false) String[] positiveindexName,
            @RequestParam(value = "healthRiskName",required = false) String[] healthRiskName,
            @RequestParam(value = "servicesAvailableSelectManager",required = false) String[] servicesAvailableSelectManager,
            @RequestParam(value = "servicesAvailableSelectDoctor",required = false) String[] servicesAvailableSelectDoctor,
            @RequestParam Map<String, String> forMap) throws ParseException {
        KoboroDoctor current = casCustomersService.getDoctor();
        Date currentDate = new Date();
        List<HealthThemeServiceItem> items = new ArrayList<>();
        for (int i = 0; i < servicesAvailableSelect.length; i++) {
            if(!Validator.isEmpty(servicesAvailableSelect[i])){
                HealthThemeServiceItem item = new HealthThemeServiceItem();
                item.setIsCheck(isCheck[i]);
                if(!Validator.isEmpty(itemContext)){
                    item.setServiceContent(itemContext[i]);
                }
                item.setServiceProject(servicesAvailableSelect[i]);
                item.setServiceProjectCeiling(itemCeiling[i]);
                item.setCreatedTime(currentDate);
                item.setCreator(current.getDoctorName());
                item.setCreatorId(Long.valueOf(current.getId()));
                items.add(item);
            }
        }
        List<HealthThemeServiceItemJoinDoctor> doctors = new ArrayList<>();
        if(!Validator.isEmpty(doctorName)){
            for (int i = 0; i < doctorName.length; i++) {
                if (!Validator.isEmpty(doctorName[i])) {
                    HealthThemeServiceItemJoinDoctor doctor = combDoctors(null, doctorName[i], doctorId[i],
                            servicesAvailableSelectDoctor[i], currentDate, current, 2);
                    doctors.add(doctor);
                }
            }
        }
        if(!Validator.isEmpty(managerName)){
            for (int i = 0; i < managerName.length; i++) {
                if (!Validator.isEmpty(managerName[i])) {
                    HealthThemeServiceItemJoinDoctor manager = combDoctors(null, managerName[i], managerId[i],
                            servicesAvailableSelectManager[i], currentDate, current, 1);
                    doctors.add(manager);
                }
            }
        }
        int healthThemeTaskId = serviceTaskService.addServiceTask(forMap, items, doctors);
        String mainProblemNames = "";
        for(String s:mainProblemName){
            mainProblemNames += s+",";
        }
        String mainSymptomNames = "";
        for(String s:mainSymptomName){
            mainSymptomNames += s+",";
        }
        String positiveindexNames = "";
        for(String s:positiveindexName){
            positiveindexNames += s+",";
        }
        String healthRiskNames = "";
        for(String s:healthRiskName){
            healthRiskNames += s+",";
        }
        serviceTaskService.saveCrowd(mainProblemNames,mainSymptomNames,positiveindexNames,healthRiskNames,forMap.get("userIds"),"1", String.valueOf(healthThemeTaskId));
        return "healthThemeTask/list";
    }

    private HealthThemeServiceItemJoinDoctor combDoctors(Integer id ,
                                                         String name, Integer doctorId, String serviceProject,
                                                         Date currentDate, KoboroDoctor current, Integer type) {
        HealthThemeServiceItemJoinDoctor doctor = new HealthThemeServiceItemJoinDoctor();
        doctor.setDoctorName(name);
        doctor.setDoctorId(doctorId);
        doctor.setServiceProject(serviceProject);
        doctor.setCreatedTime(currentDate);
        doctor.setCreator(current.getDoctorName());
        doctor.setCreatorId(Long.valueOf(current.getId()));
        doctor.setType(type);
        return doctor;
    }


    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @ResponseBody
    @PostMapping("/upload")
    public Map upload(MultipartFile file) {
        Map resultMap = new HashMap<>();
        try {
            String filePath = FileUpload.upload(file);
            if (filePath == null) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败");
                return resultMap;
            }
            resultMap.put("error", 0);
            resultMap.put("url", filePath);
            return resultMap;
        } catch (IOException e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传发生异常");
            return resultMap;
        }
    }

    /**
     * 服务任务列表删除
     * Service task list deletion
     */
    @ResponseBody
    @PostMapping("/deleteServiceTaskById")
    public String deleteServiceTaskById(@RequestParam String ids) {
        healthThemeTaskService.deleteServiceTaskById(ids);
        return "1";
    }

    /**
     * 跳转修改页面
     * @param id
     * @param modelMap
     * @return
     */
    @GetMapping("/updatePageServiceTask")
    public String updatePage(@RequestParam String id,ModelMap modelMap){
        //查询 服务健康主题任务 offline_service_health_theme_task
        HealthThemeTask healthThemeTask =  healthThemeTaskService.selectServiceTaskById(id);
        //上午结束时间
         String amEndTime = healthThemeTask.getAmEndTime();
         //上午开始时间
         String amStartTime = healthThemeTask.getAmStartTime();
         //下午开始时间
         String pmStartTime = healthThemeTask.getPmStartTime();
         //下午结束时间
         String pmEndTime = healthThemeTask.getPmEndTime();
        //查询服务健康主题服务项目 offline_service_health_theme_service_item
        List<HealthThemeServiceItem> healthThemeServiceItem = healthThemeTaskService.selectServiceHealthThemeServiceItem(healthThemeTask.getId());
        //查询健康主题模板 offline_service_health_theme_template
        HealthThemeTemplate healthThemeTemplate = healthThemeTaskService.selectHealthThemeTemplate(healthThemeTask.getThemeId());
        if(healthThemeServiceItem.size()!=0){
            List<HealthThemeServiceItemJoinDoctor> healthThemeServiceItemJoinDoctor = healthThemeTaskService.selectHealthThemeServiceItemJoinDoctor(healthThemeServiceItem.get(0).getThemeTaskId());
            modelMap.put("healthThemeServiceItemJoinDoctor", JSONArray.toJSONString(healthThemeServiceItemJoinDoctor));
        }else{
            modelMap.put("healthThemeServiceItemJoinDoctor", "");
        }
        modelMap.put("healthThemeTask",healthThemeTask);
        modelMap.put("healthThemeServiceItem", JSONArray.toJSONString(healthThemeServiceItem));
        modelMap.put("healthThemeTemplate",healthThemeTemplate);
        modelMap.put("pmEndTime",pmEndTime);
        modelMap.put("pmStartTime",pmStartTime);
        modelMap.put("amStartTime",amStartTime);
        modelMap.put("amEndTime",amEndTime);
        return "healthThemeTask/update";
    }

    /**
     * updServiceTaskController
     * 修改
     */
    @GetMapping("/updServiceTaskController")
    public String updServiceTaskController(
            @RequestParam(value = "servicesAvailableSelect",required = false) String[] servicesAvailableSelect,
            @RequestParam(value = "itemCeiling",required = false) Integer[] itemCeiling,
            @RequestParam(value = "isCheck",required = false) String[] isCheck,
            @RequestParam(value = "itemContext",required = false) String[] itemContext,
            @RequestParam(value = "doctorName",required = false) String[] doctorName,
            @RequestParam(value = "managerName",required = false) String[] managerName,
            @RequestParam(value = "doctorId",required = false) Integer[] doctorId,
            @RequestParam(value = "managerId",required = false) Integer[] managerId,
            @RequestParam(value = "healthThemeServiceItemId",required = false) Integer[] healthThemeServiceItemId, //服务项目Id
            @RequestParam(value = "mainProblemName",required = false) String[] mainProblemName,
            @RequestParam(value = "mainSymptomName",required = false) String[] mainSymptomName,
            @RequestParam(value = "positiveindexName",required = false) String[] positiveindexName,
            @RequestParam(value = "healthRiskName",required = false) String[] healthRiskName,
            @RequestParam(value = "servicesAvailableSelectManager",required = false) String[] servicesAvailableSelectManager,
            @RequestParam(value = "servicesAvailableSelectDoctor",required = false) String[] servicesAvailableSelectDoctor,
            @RequestParam Map<String, String> forMap) throws ParseException {
        KoboroDoctor current = casCustomersService.getDoctor();
        Date currentDate = new Date();
        List<HealthThemeServiceItem> items = new ArrayList<>();
        for (int i = 0; i < servicesAvailableSelect.length; i++) {
            HealthThemeServiceItem item = new HealthThemeServiceItem();
            item.setId(healthThemeServiceItemId[i]);
            item.setIsCheck(isCheck[i]);
            if(!Validator.isEmpty(itemContext)&& itemContext.length>0){
                item.setServiceContent(itemContext[i]);
            }
            item.setServiceProject(servicesAvailableSelect[i]);
            item.setServiceProjectCeiling(itemCeiling[i]);
            item.setCreatedTime(currentDate);
            item.setCreator(current.getDoctorName());
            item.setCreatorId(Long.valueOf(current.getId()));
            items.add(item);
        }
        List<HealthThemeServiceItemJoinDoctor> doctors = new ArrayList<>();
        for (int i = 0; i < doctorName.length; i++) {
            HealthThemeServiceItemJoinDoctor doctor = combDoctors(null,doctorName[i], doctorId[i],
                    servicesAvailableSelectDoctor[i], currentDate, current, 2);
            doctors.add(doctor);
        }
        for (int i = 0; i < managerName.length; i++) {
            HealthThemeServiceItemJoinDoctor manager = combDoctors(null,managerName[i], managerId[i],
                    servicesAvailableSelectManager[i], currentDate, current, 1);
            doctors.add(manager);
        }
        String mainProblemNames = "";
        for(String s:mainProblemName){
            mainProblemNames += s+",";
        }
        String mainSymptomNames = "";
        for(String s:mainSymptomName){
            mainSymptomNames += s+",";
        }
        String positiveindexNames = "";
        for(String s:positiveindexName){
            positiveindexNames += s+",";
        }
        String healthRiskNames = "";
        for(String s:healthRiskName){
            healthRiskNames += s+",";
        }
        serviceTaskService.updServiceTask(forMap, items,doctors);
        serviceTaskService.saveCrowd(mainProblemNames,mainSymptomNames,positiveindexNames,healthRiskNames,forMap.get("userIds"),"2", "2");
        return "healthThemeTask/list";
    }
}
