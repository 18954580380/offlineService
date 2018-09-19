package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.constants.Constant;
import cn.koboro.offlineservice.pojo.entity.*;
import cn.koboro.offlineservice.repository.*;
import cn.koboro.offlineservice.service.ServiceTaskService;
import cn.koboro.offlineservice.utils.DateUtil;
import cn.koboro.offlineservice.utils.StringUtil;
import cn.koboro.offlineservice.utils.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zoe
 */
@Service
@Transactional
public class ServiceTaskServiceImpl implements ServiceTaskService {
    @Resource
    private KoboroBlocMapper koboroBlocMapper;
    @Resource
    private ServicesAvailableMapper servicesAvailableMapper;
    @Resource
    private KoboroDoctorMapper koboroDoctorMapper;
    @Resource
    private HealthThemeTaskMapper healthThemeTaskMapper;
    @Resource
    private ReservationTimeMapper reservationTimeMapper;
    @Resource
    private HealthThemeServiceItemMapper itemMapper;
    @Resource
    private HealthThemeServiceItemJoinDoctorMapper doctorMapper;
    @Resource
    private CustomerInformationMapper customerInformationMapper;
    @Resource
    private PendingCustomersMapper pendingCustomersMapper;
    @Resource
    private TodayServiceCustomersMapper todayServiceCustomersMapper;
    @Resource
    private HealthThemeTemplateMapper healthThemeTemplateMapper;
    @Override
    public List<KoboroBloc> selectServicesGroup() {
        return koboroBlocMapper.selectAll();
    }

    @Override
    public List<ServicesAvailable> servicesAvailableSelectAll() {
        return servicesAvailableMapper.selectAll();
    }

    @Override
    public List<KoboroDoctor> doctorSelectAll() {

        return koboroDoctorMapper.selectAll();
    }

    @Override
    public int addServiceTask(Map<String, String> forMap, List<HealthThemeServiceItem> items,
                               List<HealthThemeServiceItemJoinDoctor> doctors) throws ParseException {
        HealthThemeTask healthThemeTask = new HealthThemeTask();
        /**服务集团名称**/
        String servicesGroupName = forMap.get("servicesGroupInputName");
        /**子公司名称**/
        String subsidiaryName = forMap.get("subsidiaryInputName");
        /**服务集团ID**/
        String servicesGroupId = forMap.get("servicesGroupName");
        /**子公司Id**/
        String subsidiaryId = forMap.get("subsidiaryName");
        /**服务开始时间**/
        String activityTimeName = forMap.get("activityTimeName");
        /**服务开始时间**/
        String serviceAddress = forMap.get("serviceLocationName");
        /**健康主题管理目标**/
        String managementTarget = forMap.get("managementTarget");
        /**服务主体介绍**/
        String serviceIntroduction = forMap.get("serviceIntroduction");
        /**人数上限**/
        String serviceCeiling = forMap.get("serviceCeiling");
        /**人数上限**/
        String serviceSupport = forMap.get("serviceSupport");
        /**主题ID**/
        String themeId = forMap.get("themeId");
        /**主题图片**/
        String imgUrl = forMap.get("imgUrl");
        /**时间段**/
        Integer  appointmentTime=Integer.valueOf(forMap.get("appointmentTime").toString());
        if (StringUtils.isNotEmpty(imgUrl)) {
            healthThemeTask.setImgUrl(imgUrl);
        }
        if (StringUtils.isNotEmpty(servicesGroupId)) {
            healthThemeTask.setBlocId(Integer.parseInt(servicesGroupId));
        }
        if (StringUtils.isNotEmpty(subsidiaryId)) {
            healthThemeTask.setSubordinateCompanyId(Integer.parseInt(subsidiaryId));
        }
        if (StringUtils.isNotEmpty(serviceCeiling)) {
            healthThemeTask.setServiceCeiling(Integer.parseInt(serviceCeiling));
        }
        if (StringUtils.isNotEmpty(themeId)) {
            healthThemeTask.setThemeId(Integer.parseInt(themeId));
        }
        healthThemeTask.setAppointmentTime(appointmentTime);
        healthThemeTask.setBlocName(servicesGroupName);
        healthThemeTask.setSubordinateCompanyName(subsidiaryName);
        healthThemeTask.setManagementTarget(managementTarget);
        healthThemeTask.setServiceIntroduction(serviceIntroduction);
        healthThemeTask.setServiceSupport(serviceSupport);

        if (StringUtils.isNotEmpty(activityTimeName)) {
            /*获取时间   切割时间*/
            String[] splitstr = activityTimeName.split("-");
            String serviceStartTime = splitstr[0];
            String serviceEndTime = splitstr[1];
            /*赋值*/
            healthThemeTask.setServiceStartTime(DateUtil.separatorSdf.parse(serviceStartTime));
            healthThemeTask.setServiceEndTime(DateUtil.separatorSdf.parse(serviceEndTime));
            /*既然活动时间不为空 则必有活动天数*/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(sdf.parse(serviceStartTime));
            c2.setTime(sdf.parse(serviceEndTime));
            Integer serviceDay = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR) + 1;
            healthThemeTask.setServiceDay(serviceDay);
        }
        if (StringUtils.isNotEmpty(serviceAddress)) {
            healthThemeTask.setServiceAddress(serviceAddress);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        //上午时间段1
        String startTime = forMap.get("appointmentPeriodAM1");
        //上午时间段2
        String endTime = forMap.get("appointmentPeriodAM2");
        healthThemeTask.setAmStartTime(startTime);
        healthThemeTask.setAmEndTime(endTime);

        //下午时间段1
        String pmStartTime = forMap.get("appointmentPeriodPM1");
        //下午时间段2
        String pmEndTime = forMap.get("appointmentPeriodPM2");
        healthThemeTask.setPmStartTime(pmStartTime);
        healthThemeTask.setPmEndTime(pmEndTime);
        healthThemeTask.setThemeName(forMap.get("themeName"));

        //时间间隔
        String timeLagName = forMap.get("timeLagName");
        Integer timeLag = null;
        if (StringUtil.isNotEmpty(timeLagName)) {
            timeLag = Integer.valueOf(timeLagName);
            healthThemeTask.setTimeInterval(timeLag);
        }
        healthThemeTaskMapper.insertSelective(healthThemeTask);
        List<ReservationTime> rtList = new ArrayList<>();
        if (timeLag != null) {
            //上午时间段
            List<ReservationTime> amRT = timeDivision(timeLag, startTime, endTime, healthThemeTask.getId());
            //下午时间段
            List<ReservationTime> pmRT = timeDivision(timeLag, pmStartTime, pmEndTime, healthThemeTask.getId());
            rtList.addAll(amRT);
            rtList.addAll(pmRT);
        } else {
            //上午时间段
            ReservationTime art = new ReservationTime();
            art.setThemeTaskId(healthThemeTask.getId());
            art.setMorningOrAfternoon("上午");
            art.setStartTime(sdf.format(startTime));
            art.setStartTime(sdf.format(endTime));
            rtList.add(art);
            //下午时间段
            ReservationTime prt = new ReservationTime();
            prt.setThemeTaskId(healthThemeTask.getId());
            prt.setMorningOrAfternoon("下午");
            prt.setStartTime(sdf.format(pmStartTime));
            prt.setStartTime(sdf.format(pmEndTime));
            rtList.add(prt);
        }
        reservationTimeMapper.insertList(rtList);
        items.forEach(e -> {
            e.setThemeTaskId(healthThemeTask.getId());
        });
        if(items.size()!=0){
            itemMapper.insertList(items);
        }
        doctors.forEach(e -> {
            e.setThemeTaskId(healthThemeTask.getId());
        });
        if(doctors.size()!=0){
            doctorMapper.insertList(doctors);
        }
        return healthThemeTask.getId();
    }
    @Override
    public void updServiceTask(Map<String, String> forMap, List<HealthThemeServiceItem> items,
                               List<HealthThemeServiceItemJoinDoctor> doctors) throws ParseException {
        HealthThemeTask healthThemeTask = new HealthThemeTask();
        /**服务集团名称**/
        String servicesGroupName = forMap.get("servicesGroupInputName");
        /**子公司名称**/
        String subsidiaryName = forMap.get("subsidiaryInputName");
        /**服务集团ID**/
        String servicesGroupId = forMap.get("servicesGroupName");
        /**子公司Id**/
        String subsidiaryId = forMap.get("subsidiaryName");
        /**服务开始时间**/
        String activityTimeName = forMap.get("activityTimeName");
        /**服务开始时间**/
        String serviceAddress = forMap.get("serviceLocationName");
        /**健康主题管理目标**/
        String managementTarget = forMap.get("managementTarget");
        /**服务主体介绍**/
        String serviceIntroduction = forMap.get("serviceIntroduction");
        /**人数上限**/
        String serviceCeiling = forMap.get("serviceCeiling");
        /**人数上限**/
        String serviceSupport = forMap.get("serviceSupport");
        /**主题图片**/
        String imgUrl = forMap.get("imgUrl");
        /**时间段**/
        Integer  appointmentTime=Integer.valueOf(forMap.get("appointmentTime").toString());
        if (StringUtils.isNotEmpty(imgUrl)) {
            healthThemeTask.setImgUrl(imgUrl);
        }
        if (StringUtils.isNotEmpty(servicesGroupId)) {
            healthThemeTask.setBlocId(Integer.parseInt(servicesGroupId));
        }
        if (StringUtils.isNotEmpty(subsidiaryId)) {
            healthThemeTask.setSubordinateCompanyId(Integer.parseInt(subsidiaryId));
        }
        if (StringUtils.isNotEmpty(serviceCeiling)) {
            healthThemeTask.setServiceCeiling(Integer.parseInt(serviceCeiling));
        }

        healthThemeTask.setId(Integer.valueOf(forMap.get("servicesGroupInputId")));
        healthThemeTask.setBlocName(servicesGroupName);
        healthThemeTask.setSubordinateCompanyName(subsidiaryName);
        healthThemeTask.setManagementTarget(managementTarget);
        healthThemeTask.setServiceIntroduction(serviceIntroduction);
        healthThemeTask.setServiceSupport(serviceSupport);
        healthThemeTask.setAppointmentTime(appointmentTime);

        if (StringUtils.isNotEmpty(activityTimeName)) {
            /*获取时间   切割时间*/
            String[] splitstr = activityTimeName.split("-");
            String serviceStartTime = splitstr[0];
            String serviceEndTime = splitstr[1];
            /*赋值*/
            healthThemeTask.setServiceStartTime(DateUtil.separatorSdf.parse(serviceStartTime));
            healthThemeTask.setServiceEndTime(DateUtil.separatorSdf.parse(serviceEndTime));
            /*既然活动时间不为空 则必有活动天数*/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(sdf.parse(serviceStartTime));
            c2.setTime(sdf.parse(serviceEndTime));
            Integer serviceDay = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR) + 1;
            healthThemeTask.setServiceDay(serviceDay);
        }
        if (StringUtils.isNotEmpty(serviceAddress)) {
            healthThemeTask.setServiceAddress(serviceAddress);
        }
        //上午时间段1
        String startTime = forMap.get("appointmentPeriodAM1");
        //上午时间段2
        String endTime = forMap.get("appointmentPeriodAM2");
        healthThemeTask.setAmStartTime(startTime);
        healthThemeTask.setAmEndTime(endTime);
        //下午时间段1
        String pmStartTime = forMap.get("appointmentPeriodPM1");
        //下午时间段2
        String pmEndTime = forMap.get("appointmentPeriodPM2");
        healthThemeTask.setPmStartTime(pmStartTime);
        healthThemeTask.setPmEndTime(pmEndTime);
        healthThemeTask.setThemeName(forMap.get("themeName"));
        //时间间隔
        String timeLagName = forMap.get("timeLagName");
        Integer timeLag = null;
        if (StringUtil.isNotEmpty(timeLagName)) {
            timeLag = Integer.valueOf(timeLagName);
            healthThemeTask.setTimeInterval(timeLag);
        }
        healthThemeTaskMapper.updateByPrimaryKeySelective(healthThemeTask);
        List<ReservationTime> rtList = new ArrayList<>();
        if (timeLag != null) {
            //上午时间段
            List<ReservationTime> amRT = timeDivision(timeLag, startTime, endTime, healthThemeTask.getId());
            //下午时间段
            List<ReservationTime> pmRT = timeDivision(timeLag, pmStartTime, pmEndTime, healthThemeTask.getId());
            rtList.addAll(amRT);
            rtList.addAll(pmRT);
            //删除时间段  从新创建
            reservationTimeMapper.deleteByTaskId(healthThemeTask.getId());
        } else {
            //上午时间段
            ReservationTime art = new ReservationTime();
            art.setThemeTaskId(healthThemeTask.getId());
            art.setMorningOrAfternoon("上午");
            art.setStartTime(startTime);
            art.setStartTime(endTime);
            rtList.add(art);
            //下午时间段
            ReservationTime prt = new ReservationTime();
            prt.setThemeTaskId(healthThemeTask.getId());
            prt.setMorningOrAfternoon("下午");
            prt.setStartTime(pmStartTime);
            prt.setStartTime(pmEndTime);
            rtList.add(prt);
        }
        reservationTimeMapper.insertList(rtList);
        items.forEach(e -> {
            if(!Validator.isEmpty(e.getId())){
                e.setThemeTaskId(healthThemeTask.getId());
                itemMapper.updateByPrimaryKeySelective(e);
            }else{
                itemMapper.updateByPrimaryKey(e);
            }

        });
        doctors.forEach(e -> {
            if(!Validator.isEmpty(e.getId())){
                e.setThemeTaskId(healthThemeTask.getId());
                doctorMapper.updateByPrimaryKeySelective(e);
            }else{
                doctorMapper.updateByPrimaryKey(e);
            }
        });
    }
    @Override
    public void saveCrowd( String mainProblemNames,
                           String mainSymptomNames,
                           String positiveindexNames,
                           String healthRiskNames,
                           String userIds,
                           String status,
                           String themeTaskId
    ){
        //任务Id
        //
        String[] mainProblemarr = mainProblemNames.split(",");
        String[] mainSymptomarr = mainSymptomNames.split(",");
        String[] positiveIndexarr = positiveindexNames.split(",");
        String[] healthRiskarr = healthRiskNames.split(",");
        String[] userarr = userIds.split(",");

        if("2".equals(status)){
            List<CustomerInformation> list=new ArrayList();
            //主要问题
            for(String arr:mainProblemarr){
                if(!Validator.isEmpty(arr)) {
                    List<Map<String,Object>> map = healthThemeTemplateMapper.findProblemDisease("诊断疾病");
                    for(Map<String, Object> list2 :map){
                        if(arr.indexOf(list2.get("name").toString())!=-1) {
                            List<CustomerInformation> customerInformationlist = customerInformationMapper.selectCustomerInformationMainProblemarr(list2.get("name").toString());
                            list.addAll(customerInformationlist);
                        }
                    }
                }
            }
            //主要症状
            for(String arr:mainSymptomarr){
                if(!Validator.isEmpty(arr)){
                    List<Map<String,Object>> map = healthThemeTemplateMapper.findProblemDisease("主要问题");
                    for(Map<String, Object> list2 :map) {
                        if (arr.indexOf(list2.get("name").toString()) != -1) {
                            List<CustomerInformation> customerInformationlist = customerInformationMapper.selectCustomerInformationMainSymptomarr(list2.get("name").toString());
                            list.addAll(customerInformationlist);
                        }
                    }
                }
            }
            //阳性指标
            for(String arr:positiveIndexarr){
                if(!Validator.isEmpty(arr)) {
                    String[] aa = Constant.positiveIndexs;
                    for(String a :aa) {
                        if (arr.indexOf(a) != -1) {
                            List<CustomerInformation> customerInformationlist = customerInformationMapper.selectCustomerInformationPositiveIndexarr(a);
                            list.addAll(customerInformationlist);
                        }
                    }
                }
            }
            //健康风险
            for(String arr:healthRiskarr){
                if(!Validator.isEmpty(arr)) {
                    String[] aa = Constant.healthRisks;
                    for(String a :aa) {
                        if (arr.indexOf(a) != -1) {
                            List<CustomerInformation> customerInformationlist = customerInformationMapper.selectCustomerInformationHealthRiskarr(a);
                            list.addAll(customerInformationlist);
                        }
                    }
                }
            }
            for (String id:userarr){
                if(!Validator.isEmpty(id)) {
                    CustomerInformation customerInformation = customerInformationMapper.selectCustomerInformationByArchivalNumber(id);
                    list.add(customerInformation);
                }
            }
            //根据任务id查询任务下所有的用户信息
            //查询服务用户
            TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
            todayServiceCustomers.setThemeTaskId(Integer.valueOf(themeTaskId));
            todayServiceCustomers.setCreateTime(new java.util.Date());
            List<TodayServiceCustomers>todayServiceCustomersList=todayServiceCustomersMapper.findCustomersByTaskId(todayServiceCustomers);
            Set<String> list2 = list.stream().collect(Collectors.groupingBy(CustomerInformation::getArchivalNumber)).keySet();
            System.out.println(list2);
            for (TodayServiceCustomers customers:todayServiceCustomersList){
                for (CustomerInformation customerInformation:list){
                    //判断服务客户表是否存在客户
                    if(customers.getArchivalNumber().equals(customerInformation.getArchivalNumber())){
                            if(customers.getSource().indexOf(0)!=-1){
                                //服务客户表里存在筛选的类型就不东
                            }else{
                                TodayServiceCustomers todayServiceCustomers2 = new TodayServiceCustomers();
                                todayServiceCustomers2.setId(customers.getId());
                                todayServiceCustomers2.setCreateTime(new java.util.Date());
                                todayServiceCustomers2.setSource(String.valueOf(0)+","+customers.getSource());
                                todayServiceCustomersMapper.updateByPrimaryKeySelective(todayServiceCustomers2);
                            }

                    }else{
                        //服务客户表没有的情况下
                        TodayServiceCustomers todayServiceCustomers2 = new TodayServiceCustomers();
                        todayServiceCustomers2.setThemeTaskId(Integer.valueOf(themeTaskId));
                        todayServiceCustomers2.setCreateTime(new java.util.Date());
                        todayServiceCustomers2.setSource(String.valueOf(0));
                        todayServiceCustomersMapper.insertSelective(todayServiceCustomers2);
                    }
                }
            }
        }else{
            //主要问题
            for(String arr:mainProblemarr){
                if(!Validator.isEmpty(arr)) {
                    List<Map<String,Object>> map = healthThemeTemplateMapper.findProblemDisease("诊断疾病");
                    for(Map<String, Object> list :map){
                        if(arr.indexOf(list.get("name").toString())!=-1){
                            List<CustomerInformation> customerInformationlist = customerInformationMapper.selectCustomerInformationMainProblemarr(list.get("name").toString());
                            for(CustomerInformation customerInformation :customerInformationlist){
                                //是否存在的用户
                                TodayServiceCustomers todayServiceCustomersUser = todayServiceCustomersMapper.selectUserByArchivalNumber(customerInformation.getArchivalNumber());
                                if(Validator.isEmpty(todayServiceCustomersUser)){
                                    //查询出用户
                                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                                    todayServiceCustomers.setDept(customerInformation.getDept());
                                    todayServiceCustomers.setName(customerInformation.getName());
                                    todayServiceCustomers.setCreateTime(new Date());
                                    todayServiceCustomers.setIsJoin(0);
                                    if("男".equals(customerInformation.getSex())){
                                        todayServiceCustomers.setSex(1);
                                    }else{
                                        todayServiceCustomers.setSex(2);
                                    }
                                    todayServiceCustomers.setSource("0");
                                    todayServiceCustomers.setStatus(0);
                                    todayServiceCustomers.setThemeTaskId(Integer.valueOf(themeTaskId));
                                    todayServiceCustomers.setDoctorflag(0);
                                    todayServiceCustomers.setPhoneNumber(customerInformation.getPhoneNumber());
                                    todayServiceCustomers.setArchivalNumber(customerInformation.getArchivalNumber());
                                    pendingCustomersMapper.saveCustomers(todayServiceCustomers);
                                }else{
                                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                                    todayServiceCustomers.setSource(","+todayServiceCustomersUser.getSource());
                                    todayServiceCustomers.setSource(todayServiceCustomersUser.getArchivalNumber());
                                    pendingCustomersMapper.updCustomers(todayServiceCustomers);
                                }
                            }
                        }
                    }
                }
            }
            //主要症状
            for(String arr:mainSymptomarr){
                if(!Validator.isEmpty(arr)){
                    List<Map<String,Object>> map = healthThemeTemplateMapper.findProblemDisease("主要问题");
                    for(Map<String, Object> list :map){
                        if(arr.indexOf(list.get("name").toString())!=-1) {
                            List<CustomerInformation> customerInformationlist = customerInformationMapper.selectCustomerInformationMainSymptomarr(list.get("name").toString());
                            for(CustomerInformation customerInformation :customerInformationlist){
                                //是否存在的用户
                                TodayServiceCustomers customerInformationService = pendingCustomersMapper.selectCustomerInfortionById(customerInformation.getArchivalNumber());
                                if(Validator.isEmpty(customerInformationService)){
                                    //查询出用户
                                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                                    todayServiceCustomers.setDept(customerInformation.getDept());
                                    todayServiceCustomers.setName(customerInformation.getName());
                                    todayServiceCustomers.setCreateTime(new Date());
                                    todayServiceCustomers.setIsJoin(0);
                                    todayServiceCustomers.setSource("0");
                                    if("男".equals(customerInformation.getSex())){
                                        todayServiceCustomers.setSex(1);
                                    }else{
                                        todayServiceCustomers.setSex(2);
                                    }
                                    todayServiceCustomers.setStatus(0);
                                    todayServiceCustomers.setThemeTaskId(Integer.valueOf(themeTaskId));
                                    todayServiceCustomers.setDoctorflag(0);
                                    todayServiceCustomers.setPhoneNumber(customerInformation.getPhoneNumber());
                                    todayServiceCustomers.setArchivalNumber(customerInformation.getArchivalNumber());
                                    pendingCustomersMapper.saveCustomers(todayServiceCustomers);
                                }else{
                                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                                    todayServiceCustomers.setSource(","+customerInformationService.getSource());
                                    todayServiceCustomers.setSource(customerInformationService.getArchivalNumber());
                                    pendingCustomersMapper.updCustomers(todayServiceCustomers);
                                }
                            }
                        }///
                    }
                }
            }
            //阳性指标
            for(String arr:positiveIndexarr){
                if(!Validator.isEmpty(arr)) {
                    String[] aa = Constant.positiveIndexs;
                    for(String a :aa){
                        if (arr.indexOf(a)!=-1){
                            List<CustomerInformation> customerInformationlist = customerInformationMapper.selectCustomerInformationPositiveIndexarr(a);
                            for(CustomerInformation customerInformation :customerInformationlist){
                                //是否存在的用户
                                TodayServiceCustomers customerInformationService = pendingCustomersMapper.selectCustomerInfortionById(customerInformation.getArchivalNumber());
                                if(Validator.isEmpty(customerInformationService)){
                                    //查询出用户
                                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                                    todayServiceCustomers.setDept(customerInformation.getDept());
                                    todayServiceCustomers.setName(customerInformation.getName());
                                    todayServiceCustomers.setCreateTime(new Date());
                                    todayServiceCustomers.setIsJoin(0);
                                    todayServiceCustomers.setSource("0");
                                    if("男".equals(customerInformation.getSex())){
                                        todayServiceCustomers.setSex(1);
                                    }else{
                                        todayServiceCustomers.setSex(2);
                                    }
                                    todayServiceCustomers.setStatus(0);
                                    todayServiceCustomers.setThemeTaskId(Integer.valueOf(themeTaskId));
                                    todayServiceCustomers.setDoctorflag(0);
                                    todayServiceCustomers.setPhoneNumber(customerInformation.getPhoneNumber());
                                    todayServiceCustomers.setArchivalNumber(customerInformation.getArchivalNumber());
                                    pendingCustomersMapper.saveCustomers(todayServiceCustomers);
                                }else{
                                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                                    todayServiceCustomers.setSource(","+customerInformationService.getSource());
                                    todayServiceCustomers.setSource(customerInformationService.getArchivalNumber());
                                    pendingCustomersMapper.updCustomers(todayServiceCustomers);
                                }
                            }
                        }
                    }
                }
            }
            //健康风险
            for(String arr:healthRiskarr){
                if(!Validator.isEmpty(arr)) {
                    String[] aa = Constant.healthRisks;
                    for(String a :aa) {
                        if (arr.indexOf(a) != -1) {
                            List<CustomerInformation> customerInformationlist = customerInformationMapper.selectCustomerInformationHealthRiskarr(a);
                            for (CustomerInformation customerInformation : customerInformationlist) {
                                //是否存在的用户
                                TodayServiceCustomers customerInformationService = pendingCustomersMapper.selectCustomerInfortionById(customerInformation.getArchivalNumber());
                                if (Validator.isEmpty(customerInformationService)) {
                                    //查询出用户
                                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                                    todayServiceCustomers.setDept(customerInformation.getDept());
                                    todayServiceCustomers.setName(customerInformation.getName());
                                    todayServiceCustomers.setCreateTime(new Date());
                                    todayServiceCustomers.setIsJoin(0);
                                    todayServiceCustomers.setSource("0");
                                    if("男".equals(customerInformation.getSex())){
                                        todayServiceCustomers.setSex(1);
                                    }else{
                                        todayServiceCustomers.setSex(2);
                                    }
                                    todayServiceCustomers.setStatus(0);
                                    todayServiceCustomers.setThemeTaskId(Integer.valueOf(themeTaskId));
                                    todayServiceCustomers.setDoctorflag(0);
                                    todayServiceCustomers.setPhoneNumber(customerInformation.getPhoneNumber());
                                    todayServiceCustomers.setArchivalNumber(customerInformation.getArchivalNumber());
                                    pendingCustomersMapper.saveCustomers(todayServiceCustomers);
                                } else {
                                    TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                                    todayServiceCustomers.setSource("," + customerInformationService.getSource());
                                    todayServiceCustomers.setSource(customerInformationService.getArchivalNumber());
                                    pendingCustomersMapper.updCustomers(todayServiceCustomers);
                                }
                            }
                        }
                    }
                }
            }
            for (String id:userarr){
                if(!Validator.isEmpty(id)){
                    //用户
                    CustomerInformation customerInformation = customerInformationMapper.selectCustomerInformationByArchivalNumber(id);
                    //是否存在的用户
                    TodayServiceCustomers customerInformationService = pendingCustomersMapper.selectCustomerInfortionById(customerInformation.getArchivalNumber());
                    if(Validator.isEmpty(customerInformationService)){
                        //查询出用户
                        TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                        todayServiceCustomers.setDept(customerInformation.getDept());
                        todayServiceCustomers.setName(customerInformation.getName());
                        todayServiceCustomers.setCreateTime(new Date());
                        todayServiceCustomers.setIsJoin(0);
                        todayServiceCustomers.setSource("0");
                        if("男".equals(customerInformation.getSex())){
                            todayServiceCustomers.setSex(1);
                        }else{
                            todayServiceCustomers.setSex(2);
                        }
                        todayServiceCustomers.setStatus(0);
                        todayServiceCustomers.setThemeTaskId(Integer.valueOf(themeTaskId));
                        todayServiceCustomers.setDoctorflag(0);
                        todayServiceCustomers.setPhoneNumber(customerInformation.getPhoneNumber());
                        todayServiceCustomers.setArchivalNumber(customerInformation.getArchivalNumber());
                        todayServiceCustomersMapper.insertSelective(todayServiceCustomers);
                    }else{
                        TodayServiceCustomers todayServiceCustomers = new TodayServiceCustomers();
                        todayServiceCustomers.setSource(","+customerInformationService.getSource());
                        todayServiceCustomers.setSource(customerInformationService.getArchivalNumber());
                        pendingCustomersMapper.updCustomers(todayServiceCustomers);
                    }
                }
            }
        }
    }
    //分割时间方法
    private List<ReservationTime> timeDivision(int timeLag, String startHour, String endHour, Integer taskId) throws ParseException {
        Calendar currCal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date startTime = sdf.parse(startHour);
        Date endTime = sdf.parse(endHour);
        currCal.setTime(startTime);
        List list = new ArrayList();
        Calendar start = null;
        while (currCal.getTimeInMillis() <= endTime.getTime()) {
            ReservationTime rt = new ReservationTime();
            rt.setThemeTaskId(taskId);
//            rt.setMorningOrAfternoon();
            String startStr = String.format("%1$tH:%1$tM", start);
            String endStr = String.format("%1$tH:%1$tM", currCal);
//            String end = String.format("%1$tH:%1$tM", calendar);
            if (start != null) {
                rt.setStartTime(startStr);
                rt.setEndTime(endStr);
                rt.setMorningOrAfternoon(start.get(Calendar.AM_PM) == 0 ? "上午" : "下午");
//                list.add(start + "->" + end);
                list.add(rt);
            } else {
                start = Calendar.getInstance();
            }
            start.setTime(currCal.getTime());
            currCal.add(Calendar.MINUTE, timeLag);
        }
        return list;
    }
}
