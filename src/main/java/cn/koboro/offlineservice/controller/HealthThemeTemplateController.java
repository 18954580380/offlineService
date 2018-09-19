package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.constants.Constant;
import cn.koboro.offlineservice.pojo.entity.HealthThemeTemplate;
import cn.koboro.offlineservice.pojo.entity.KoboroDoctor;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.service.CasCustomersService;
import cn.koboro.offlineservice.service.HealthThemeTemplateService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 健康主题控制器
 *
 * @author admin
 */
@Controller
@RequestMapping("/healthTheme")
public class HealthThemeTemplateController {
    @Resource
    private HealthThemeTemplateService healthThemeTemplateService;
    @Resource
    private CasCustomersService casCustomersService;

    /**
     * 进入主题列表页面
     *
     * @param request
     * @param modelMap
     * @return
     */
    @GetMapping("/selectAll")
    public String selectAll(HttpServletRequest request, ModelMap modelMap) {
        //获取当前登录用户名
         casCustomersService.getDoctor().getDoctorName();
        return "healthThemeTemplate/list";
    }

    /**
     * 查询所有的健康主题
     *
     * @param request
     * @param modelMap
     * @return
     */
    @ResponseBody
    @GetMapping("/findTemplate")
    public ResultVO findTemplate(HttpServletRequest request, @RequestParam(defaultValue = "") String themeName) {
        List<HealthThemeTemplate> list = healthThemeTemplateService.selectAllByThemeName(themeName);
        return ResultVO.success(new PageInfo<HealthThemeTemplate>(list));
    }

    /**
     * 进入添加健康主题页面
     *
     * @param request
     * @param modelMap
     * @return
     */
    @GetMapping("/add")
    public String add(HttpServletRequest request, ModelMap modelMap) {
        modelMap = getFactors(modelMap);
        return "healthThemeTemplate/add";
    }

    /**
     * 保存主题
     *
     * @param request
     * @param modelMap
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public ResultVO save(HttpServletRequest request, ModelMap modelMap, HealthThemeTemplate healthThemeTemplate) {
        KoboroDoctor koboroDoctor = casCustomersService.getDoctor();
        healthThemeTemplate.setCreateTime(new Date());
        healthThemeTemplate.setCreator(koboroDoctor.getDoctorName());
        int count = healthThemeTemplateService.save(healthThemeTemplate);
        return count==1?ResultVO.success():ResultVO.error(0, "保存主题失败");
    }

    /**
     * 根据ID删除主题 备注:目前只是单纯根据id删除主题，后续会删除和主题有关的表数据
     *
     * @param request
     * @param modelMap
     * @return
     */
    @PostMapping("/deleteById")
    @ResponseBody
    public ResultVO deleteById(HttpServletRequest request, ModelMap modelMap, @RequestParam("ids") String ids) {
        int count = healthThemeTemplateService.deleteById(ids);
        return count==1?ResultVO.success():ResultVO.error(0, "删除主题失败");
    }

    /**
     * 进入修改页面
     *
     * @param request
     * @param modelMap
     * @return
     */
    @GetMapping("/updateById")
    public String updateById(HttpServletRequest request, ModelMap modelMap, HealthThemeTemplate healthThemeTemplate) {
        healthThemeTemplate = healthThemeTemplateService.findById(healthThemeTemplate.getId());
        modelMap = getFactors(modelMap);
        modelMap.put("healthThemeTemplate", healthThemeTemplate);
        return "/healthThemeTemplate/update";
    }

    /**
     * 保存修改
     *
     * @param request
     * @param modelMap
     * @return
     */
    @PostMapping("/saveUpdate")
    @ResponseBody
    public ResultVO saveUpdate(HttpServletRequest request, ModelMap modelMap, HealthThemeTemplate healthThemeTemplate) {
        healthThemeTemplate.setUpdateTime(new Date());
        int count = healthThemeTemplateService.saveUpdate(healthThemeTemplate);
        return count==1?ResultVO.success():ResultVO.error(0, "修改主题失败");
    }

    /**
     * 抽离主题关联的因素
     *
     * @return
     */
    public ModelMap getFactors(ModelMap modelMap) {
        //主要问题
        List<Map<String, Object>> mainProblems = healthThemeTemplateService.findProblemDisease("诊断疾病");
        //主要症状
        List<Map<String, Object>> mainSymptoms = healthThemeTemplateService.findProblemDisease("主要问题");
        //阳性指标
        List<Map<String, Object>> positiveIndexs = healthThemeTemplateService.findProblemDisease("临床异常指标");
        //健康风险
        List<String> healthRisks = Arrays.asList(Constant.healthRisks);
        //年龄段
        List<String> ageGroups = Arrays.asList(Constant.ageGroups);
        modelMap.put("mainProblems", mainProblems);
        modelMap.put("mainSymptoms", mainSymptoms);
        modelMap.put("positiveIndexs", positiveIndexs);
        modelMap.put("healthRisks", healthRisks);
        modelMap.put("ageGroups", ageGroups);
        return modelMap;

    }
}
