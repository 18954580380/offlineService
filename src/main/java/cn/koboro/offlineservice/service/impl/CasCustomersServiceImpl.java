package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.CustomerInformation;
import cn.koboro.offlineservice.pojo.entity.KoboroDoctor;
import cn.koboro.offlineservice.repository.CustomerInformationMapper;
import cn.koboro.offlineservice.repository.HealthThemeServiceItemMapper;
import cn.koboro.offlineservice.service.CasCustomersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CasCustomersServiceImpl implements CasCustomersService{
    @Resource
    private CustomerInformationMapper customerInformationMapper;
    @Resource
    private HealthThemeServiceItemMapper healthThemeServiceItemMapper;
	/**
	 * 获取登陆用户用户名
	 */
    public KoboroDoctor getDoctor() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null || subject.getPrincipals() == null) {
        	return null;
        }else{
        	String login_name=(String) subject.getPrincipals().getPrimaryPrincipal();
        	//根据用户名查询用户信息
        	KoboroDoctor koboroDoctor=healthThemeServiceItemMapper.findDoctorByLoginName(login_name);
        	return koboroDoctor;
        }
    }

    @Override
    public CustomerInformation selectCustomerInformationById(Long id) {
        return customerInformationMapper.selectCustomerInformationById(id);
    }

    @Override
    @AutoPage
    public List<Map> selectCustomerInformationByblocName(String blocName,String name,String dept,String phoneNumber,String sex,String main_health_problems_string,
                                                         String abnormal_clinical_indicators,String current_diagnosis,String partyBuilding) {
        return customerInformationMapper.selectCustomerInformationByblocName(blocName,name,dept,phoneNumber,sex,main_health_problems_string,abnormal_clinical_indicators,current_diagnosis,partyBuilding);
    }

    @Override
    public Map selectReportProblemList(String archivalNumber,String reportProblem) {
        return customerInformationMapper.selectReportProblemList(archivalNumber,reportProblem);
    }

    @Override
    public Map selectAssessmentList(String archivalNumber,String riskResult){
        return customerInformationMapper.selectAssessmentList(archivalNumber,riskResult);
    }

    @Override
    public int selectCustomerInformationMainProblemarrCount(String arr) {
        return customerInformationMapper.selectCustomerInformationMainProblemarrCount(arr);
    }

    @Override
    public int selectCustomerInformationMainSymptomarrCount(String arr) {
        return customerInformationMapper.selectCustomerInformationMainSymptomarrCount(arr);
    }

    @Override
    public int selectCustomerInformationPositiveIndexarrCount(String arr) {
        return customerInformationMapper.selectCustomerInformationPositiveIndexarrCount(arr);
    }

    @Override
    public int selectCustomerInformationHealthRiskarrCount(String arr) {
        return customerInformationMapper.selectCustomerInformationHealthRiskarrCount(arr);
    }

    @Override
    public List<Map> selectCustomerInformationMainProblemList(String arr) {
        return customerInformationMapper.selectCustomerInformationMainProblemList(arr);
    }

    @Override
    public List<Map> selectCustomerInformationMainSymptomList(String arr) {
        return customerInformationMapper.selectCustomerInformationMainSymptomList(arr);
    }

    @Override
    public List<Map> selectCustomerInformationPositiveIndexList(String arr) {
        return customerInformationMapper.selectCustomerInformationPositiveIndexList(arr);
    }

    @Override
    public List<Map> selectCustomerInformationHealthRiskList(String arr) {
        return customerInformationMapper.selectCustomerInformationHealthRiskList(arr);
    }


}
