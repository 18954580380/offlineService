package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.pojo.entity.CustomerInformation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


public interface CustomerInformationMapper extends Mapper<CustomerInformation> {

    CustomerInformation selectCustomerInformationById(@Param("id") Long id);
    CustomerInformation selectCustomerInformationByArchivalNumber(@Param("archivalNumber") String archivalNumber);

    List<CustomerInformation> selectCustomerInformation(CustomerInformation customerInformation);

    List<Map> selectCustomerInformationByblocName(@Param("blocName") String blocName,
                                                  @Param("name") String name,
                                                  @Param("dept") String dept,
                                                  @Param("phoneNumber") String phoneNumber,
                                                  @Param("sex") String sex,
                                                  @Param("main_health_problems_string") String main_health_problems_string,
                                                  @Param("abnormal_clinical_indicators") String abnormal_clinical_indicators,
                                                  @Param("current_diagnosis") String current_diagnosis,
                                                  @Param("partyBuilding") String partyBuilding
                                                  );

    Map selectReportProblemList(@Param("archivalNumber") String archivalNumber,@Param("reportProblem") String reportProblem);

    Map selectAssessmentList(@Param("archivalNumber") String archivalNumber,@Param("riskResult") String riskResult);

    int selectCustomerInformationMainProblemarrCount(@Param("arr") String arr);

    int selectCustomerInformationMainSymptomarrCount(@Param("arr") String arr);

    int selectCustomerInformationPositiveIndexarrCount(@Param("arr") String arr);

    int selectCustomerInformationHealthRiskarrCount(@Param("arr") String arr);

    List<CustomerInformation> selectCustomerInformationMainProblemarr(@Param("arr") String arr);

    List<CustomerInformation> selectCustomerInformationMainSymptomarr(@Param("arr") String arr);

    List<CustomerInformation> selectCustomerInformationPositiveIndexarr(@Param("arr") String arr);

    List<CustomerInformation> selectCustomerInformationHealthRiskarr(@Param("arr") String arr);

    List<Map> selectCustomerInformationMainProblemList(@Param("arr")String arr);

    List<Map> selectCustomerInformationMainSymptomList(@Param("arr")String arr);

    List<Map> selectCustomerInformationPositiveIndexList(@Param("arr")String arr);

    List<Map> selectCustomerInformationHealthRiskList(@Param("arr")String arr);

    Long findBlocIdByArchivalNumber(@Param("archivalNumber") String archivalNumber);
}
