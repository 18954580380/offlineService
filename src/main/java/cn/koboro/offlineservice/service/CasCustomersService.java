package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.pojo.entity.CustomerInformation;
import cn.koboro.offlineservice.pojo.entity.KoboroDoctor;

import java.util.List;
import java.util.Map;

public interface CasCustomersService {
	KoboroDoctor getDoctor();

    CustomerInformation selectCustomerInformationById(Long id);

    List<Map> selectCustomerInformationByblocName(String blocName,String name,String dept,
                                                  String phoneNumber,String sex,String main_health_problems_string,
                                                  String abnormal_clinical_indicators,String current_diagnosis,String partyBuilding);

    Map selectReportProblemList(String archivalNumber,String reportProblem);

    Map selectAssessmentList(String archivalNumber,String riskResult);

    int selectCustomerInformationMainProblemarrCount(String arr);

    int selectCustomerInformationMainSymptomarrCount(String arr);

    int selectCustomerInformationPositiveIndexarrCount(String arr);

    int selectCustomerInformationHealthRiskarrCount(String arr);

    List<Map> selectCustomerInformationMainProblemList(String arr);

    List<Map> selectCustomerInformationMainSymptomList(String arr);

    List<Map> selectCustomerInformationPositiveIndexList(String arr);

    List<Map> selectCustomerInformationHealthRiskList(String arr);

}