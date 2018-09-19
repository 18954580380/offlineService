package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.pojo.entity.HealthThemeTemplate;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.service.CasCustomersService;
import cn.koboro.offlineservice.service.HealthThemeTemplateService;
import cn.koboro.offlineservice.service.PendingCustomersService;
import cn.koboro.offlineservice.service.TodayServiceCustomersService;
import cn.koboro.offlineservice.utils.Validator;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/selectCrowd")
public class SelectCrowdController {
    @Resource
    private CasCustomersService casCustomersService;
    @Resource
    private PendingCustomersService pendingCustomersService;
    @Resource
    private HealthThemeTemplateService healthThemeTemplateService;
    @Resource
    private TodayServiceCustomersService todayServiceCustomersService;

    /**
     * 选择人群页面自定义筛选
     * @param modelMap
     * @param umap
     * @return
     */
    @GetMapping("/page")
    public String selectCrowdList(ModelMap modelMap, @RequestParam String healthThemeId){
        modelMap.put("taskId",199999);
        modelMap.put("healthThemeId",healthThemeId);
        return "crowd/list";
    }
    /**
     * 选择人群页面健康主题筛选
     * @param modelMap
     * @param umap
     * @return
     */
    @GetMapping("/page2")
    public String selectThemeList(ModelMap modelMap, @RequestParam String healthThemeId){
        Map map = new HashMap();
        List<HealthThemeTemplate> list = new ArrayList();
        List<HealthThemeTemplate> HealthThemeTemplatelist = healthThemeTemplateService.selectAllByThemeName(null);
        for(HealthThemeTemplate healthThemeTemplate:HealthThemeTemplatelist){
            if(healthThemeId.equals(healthThemeTemplate.getId().toString())){
                if(!Validator.isEmpty(healthThemeTemplate.getMainProblem())){
                    String mainProblem[]  = healthThemeTemplate.getMainProblem().split(",");
                        modelMap.put("mainProblem",mainProblem);
                }
                if(!Validator.isEmpty(healthThemeTemplate.getMainSymptom())){
                    String mainSymptom[]  = healthThemeTemplate.getMainSymptom().split(",");
                        modelMap.put("mainSymptom",mainSymptom);
                }
                if(!Validator.isEmpty(healthThemeTemplate.getPositiveIndex())){
                    String positiveIndex[] = healthThemeTemplate.getPositiveIndex().split(",");
                        modelMap.put("positiveIndex",positiveIndex);
                }
                if(!Validator.isEmpty(healthThemeTemplate.getHealthRisk())){
                    String healthRisk[]  = healthThemeTemplate.getHealthRisk().split(",");
                        modelMap.put("healthRisk",healthRisk);
                }
            }
        }
        modelMap.put("healthThemeId",healthThemeId);
        return "crowd/themelist";
    }

    /**
     * 自定义筛选选择人群列表
     * @param umap
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public ResultVO selectCrowdListAll(@RequestParam Map<String,String> umap){
        String blocName = umap.get("blocName");
        List<Map> customerInformationList = casCustomersService.selectCustomerInformationByblocName(blocName,umap.get("name"),umap.get("dept"),umap.get("phoneNumber")
                ,umap.get("sex"),umap.get("abnormal_clinical_indicators"),umap.get("current_diagnosis"),umap.get("partyBuilding"),umap.get("main_health_problems_string"));
        for(Map map:customerInformationList){
            Map reportProblemmap= casCustomersService.selectReportProblemList((String) map.get("archival_number"),umap.get("reportProblem"));
            if(!Validator.isEmpty(reportProblemmap)){
                map.put("reportProblem", Validator.isEmpty(reportProblemmap.get("report_problem"))?"":reportProblemmap.get("report_problem"));
                Map assessmentMap = casCustomersService.selectAssessmentList((String) map.get("archival_number"),umap.get("riskResult"));
                if(!Validator.isEmpty(assessmentMap)){
                    map.put("riskResult", Validator.isEmpty(assessmentMap.get("risk_result"))?"":assessmentMap.get("risk_result"));
                }else{
                    map.put("riskResult","");
                }
            }else{
                map.put("reportProblem","");
                Map assessmentMap = casCustomersService.selectAssessmentList((String) map.get("archival_number"),umap.get("riskResult"));
                if(!Validator.isEmpty(assessmentMap)){
                    map.put("riskResult", Validator.isEmpty(assessmentMap.get("risk_result"))?"":assessmentMap.get("risk_result"));
                }else{
                    map.put("riskResult","");
                }
            }
        }
         return ResultVO.success(new PageInfo(customerInformationList));
    }

    /**
     * 健康主题筛选 选择人群
     * @param umap
     * @return
     */
    @GetMapping("/selectCrowdHealthThemeScreeningList")
    @ResponseBody
    public ResultVO selectCrowdHealthThemeScreeningList(@RequestParam Map<String,String> umap){
        String blocName = umap.get("blocName");
             String mainProblemarr[] = Validator.isEmpty(umap.get("mainProblem"))?null:umap.get("mainProblem").split(",");
             String mainSymptomarr[] = Validator.isEmpty(umap.get("mainSymptom"))?null:umap.get("mainSymptom").split(",");
             String positiveIndexarr[] = Validator.isEmpty(umap.get("positiveIndex"))?null:umap.get("positiveIndex").split(",");
             String healthRiskarr[] = Validator.isEmpty(umap.get("healthRisk"))?null:umap.get("healthRisk").split(",");

        List arrayLists = new ArrayList();
        if(!Validator.isEmpty(mainProblemarr)){
            for(String arr:mainProblemarr) {
                if(!Validator.isEmpty(arr)) {
                    List<Map> list = casCustomersService.selectCustomerInformationMainProblemList(arr);
                    arrayLists.addAll(list);
                }
            }
        }
        //主要症状
        if(!Validator.isEmpty(mainSymptomarr)) {
            for (String arr : mainSymptomarr) {
                if (!Validator.isEmpty(arr)) {
                    List<Map> list =  casCustomersService.selectCustomerInformationMainSymptomList(arr);
                    arrayLists.addAll(list);
                }
            }
        }
        //阳性指标
            if(!Validator.isEmpty(positiveIndexarr)) {
                for (String arr : positiveIndexarr) {
                    if (!Validator.isEmpty(arr)) {
                        List<Map> list =  casCustomersService.selectCustomerInformationPositiveIndexList(arr);
                        arrayLists.addAll(list);
                    }
                }
            }
        //健康风险
        if(!Validator.isEmpty(healthRiskarr)) {
            for (String arr : healthRiskarr) {
                if (!Validator.isEmpty(arr)) {
                    List<Map> list =  casCustomersService.selectCustomerInformationHealthRiskList(arr);
                    arrayLists.addAll(list);
                }
            }
        }

        return ResultVO.success(new PageInfo(arrayLists));
    }
    /**
     * 选择人群查询数据返回
     */
    @GetMapping("/selectCrowdCount")
    @ResponseBody
    public ResultVO selectCrowdCount(@RequestParam("mainProblem") String mainProblem,
                          @RequestParam("mainSymptom") String mainSymptom,
                          @RequestParam("positiveIndex") String positiveIndex,
                          @RequestParam("healthRisk") String healthRisk
    ){
        String mainProblemarr[] = mainProblem.split(",");
        String mainSymptomarr[] = mainSymptom.split(",");
        String positiveIndexarr[] = positiveIndex.split(",");
        String healthRiskarr[] = healthRisk.split(",");
        Map map = new HashMap();
        //主要问题
        String mainProblemCount = "";
        for(String arr:mainProblemarr){
            if(!Validator.isEmpty(arr)) {
                String mainProblemName = arr;
                int i = casCustomersService.selectCustomerInformationMainProblemarrCount(arr);
                mainProblemCount += mainProblemName + i + ",";
            }
        }
        //主要症状
        String mainSymptomarrCount = "";
        for(String arr:mainSymptomarr){
            if(!Validator.isEmpty(arr)){
                String mainProblemName = arr;
                int i =  casCustomersService.selectCustomerInformationMainSymptomarrCount(arr);
                mainSymptomarrCount +=mainProblemName+i+",";
            }
        }
        //阳性指标
        String positiveIndexarrCount = "";
        for(String arr:positiveIndexarr){
            if(!Validator.isEmpty(arr)) {
                String positiveIndexName = arr;
                int i = casCustomersService.selectCustomerInformationPositiveIndexarrCount(arr);
                positiveIndexarrCount += positiveIndexName + i + ",";
            }
        }
        //健康风险
        String healthRiskarrCount = "";
        for(String arr:healthRiskarr){
            if(!Validator.isEmpty(arr)) {
                String healthRiskName = arr;
                int i = casCustomersService.selectCustomerInformationHealthRiskarrCount(arr);
                healthRiskarrCount += healthRiskName + i + ",";
            }
        }
        map.put("mainProblemCount",mainProblemCount);
        map.put("mainSymptomarrCount",mainSymptomarrCount);
        map.put("positiveIndexarrCount",positiveIndexarrCount);
        map.put("healthRiskarrCount",healthRiskarrCount);
        return  ResultVO.success(map);
    }
}
