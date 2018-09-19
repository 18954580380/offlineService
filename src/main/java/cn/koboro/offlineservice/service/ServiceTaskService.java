package cn.koboro.offlineservice.service;


import cn.koboro.offlineservice.pojo.entity.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ServiceTaskService {
    List<KoboroBloc> selectServicesGroup();

    List<ServicesAvailable> servicesAvailableSelectAll();

    List<KoboroDoctor> doctorSelectAll();

    int addServiceTask(Map<String, String> forMap, List<HealthThemeServiceItem> items,
                        List<HealthThemeServiceItemJoinDoctor> doctors) throws ParseException;

    void updServiceTask(Map<String, String> forMap, List<HealthThemeServiceItem> items,
                        List<HealthThemeServiceItemJoinDoctor> doctors) throws ParseException;

    void saveCrowd(String mainProblemNames, String mainSymptomNames, String positiveindexNames,
                   String healthRiskNames, String userIds, String s,String themeTaskId);
}
