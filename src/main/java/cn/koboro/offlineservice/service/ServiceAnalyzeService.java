package cn.koboro.offlineservice.service;

import java.util.List;
import java.util.Map;

public interface ServiceAnalyzeService {
	List<Map<String,Object>> selectAllData(Map<String,Object>map);
	List<Map<String,Object>> findServiceNumber(Map<String,Object>map);
	Map<String,Object> findInviteCase(Map<String,Object>map);
	List<Map<String,Object>>findDoctorDetail(Map<String,Object>map);
	List<Map<String,Object>> findServiceDetail(Map<String,Object>map);

}
