package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 客户信息
 * @author zhangqingxin
 * KOBORO_CUSTOMER_INFORMATION
 */
@Entity
@Data
@Table(name = "KOBORO_CUSTOMER_INFORMATION")
public class CustomerInformation {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Long userId;      	      //acs_userId:新建客户时会同时生成acs_user
	private String archivalNumber;    //档案号
	private String name;              //姓名
	private String sex;               //性别
	private Date birthday;            //出生日期
	private String logout="N";        //是否注销     Y:已注销
	private String loginStatus;       //登录状态（app一个账户只能登录一台服务）
	@Transient
	private Integer age;               //年龄
	private String phoneNumber;       //手机号码
	private String telNo;             //固定电话
	private String email;             //邮箱
	private String idCardNo;          //身份证号
	private String companyName;       //公司名称
	private Long blocId;      	      //公司id-对应bloc中id-集团id
	private String dept;              //部门
	private Long deptId;              //部门id
	private String accessToken;       //登陆设备标志id
	
	private String province;		  //省
	private String city;			  //市
	private String area;			  //区
	private String street;			  //街道
	private String addrDetail;		  //详细地址
	
	private String contactAddress;    //联系地址 = 省 + 市 + 区  + 街道 + 详细地址
	private String clienteleType;     //客户类别
	private String membershipLevel;   //会员级别
	private String medicalInstitution;//体检机构
	private String servicePackage;    //服务套餐
	
	private String serviceOrganization;//服务机构
	private Long serviceOrganizationId;//服务机构Id
	
	private String insuranceOrganization;//保险机构
	private String healthManager;       //健康管理师
	private Long healthManagerId;       //健康管理师-用户acs_userId
	private String doctor;              //医生
	private Long doctorId;              //医生-用户acs_userId
	private Date serviceStartTime;      //服务开始时间
	private Date serviceEndTime;        //服务结束时间
	private String clienteleTrait;      //客户特征
	private String picture;             //照片
	private Boolean planState = false;  //true;代表用户今天有干预计划,false表示客户今天没有干预计划
	private String newMainDiseasse;     //最新的主要问题(主要问题+其他问题)-只有在批量处理选择人员时才统计一次-查询特别复杂只能做成这样
	private String newCurrentDiagnosis; //最新的主要疾病(主要疾病+其他疾病)-只有在批量处理选择人员时才统计一次-查询特别复杂只能做成这样
	
	/*年龄段：婴儿期（出生～1岁） 小儿期（1～3岁） 幼儿期（3～6岁） 少年期（7～17岁） 青年期（18～44岁）
			中年期（45～59岁） 年青老年期（60～74岁） 老年期（75～89岁） 长寿老年期（90岁以上）*/
	@Transient
	private String lifecycle;//生命周期（随着时间的变化生命周期也在变化）
	@Transient
	private String haveArchival = "无";//有无档案（基础档案、运动档案、营养档案，三个档案的列表都用的客户表）
	
	//健康干预页签 使用
	private String remindState = "no";     //提醒:yes;未提醒:no
	
	//体检设计（四级菜单）、体检报告（四级菜单）使用
	@Transient
	private String physicalType;          //体检类型(3种情况 6种类型)
	@Transient
	private String medicalPackageName;    //体检套餐
	@Transient
	private Date physicalCreateDate;      //体检设计时间
	@Transient
	private Date physicalPlanDate;        //预计体检日期
	@Transient
	private String physicalReport = "无"; //体检报告
	@Transient
	private String physicalReportIds; //体检报告
	@Transient
	private String physicalReportSuggest = "无"; //报告建议
	
	@Transient
	private String planContent;//计划内容
	@Transient
	private String planItemCount = "0条/0条";//3条/1条  3：常规计划 1:临时计划
	
	private String tokenId;//视频会诊中的tokenId
	
	//定时提醒使用。每天客户只收到一条消息，提醒记录表生成多条记录。
	@Transient
	private Boolean havePlanToday = false;    //当天是否有计划（健康监测、专项检查、周期性评估、周期健康档案、预约面诊）
	@Transient
	private Boolean havePlanThree = false;    //三天后是否有计划（健康监测、专项检查、周期性评估、周期健康档案、预约面诊）
	private Boolean whetherSendToday = false; //是否给客户推送过消息（当天有计划）。每天0点定时设为false
	private Boolean whetherSendThree = false; //是否给客户推送过消息（三天后有计划）。每天0点定时设为false
	//APP-我-今日计划。是否提醒
	private Boolean remindPrescription = true;//功能配方计划
	private Boolean remindQuota = true;       //健康监测计划
	private Boolean remindFourArchives = true;//健康档案计划
	private Boolean remindAssessment = true;  //风险评估计划
	//APP-我-我的消息。点击时间
	private Date myMsgClickTime;              //“我-我的消息”点击时间
	private Date systemMsgClickTime;          //“我-我的消息-系统消息”点击时间
	private Date consultMsgClickTime;         //“我-我的消息-咨询服务”点击时间    被首页点赞心使用
	private Date firstLoginTime;              //第一次手机登录时间(第一次手机登录推送消息“宝葫芦里有您的营养、运动指导建议，请您查看呦！ ”，只推送一次，以后不推送)
	//我的运动-专业运动
	private Date firstProfessoinalSportsDate; //第一次徒步问卷时间。我的运动里面做问卷回写时间（只能做一次问卷），首页问卷不回写。
	private String sportsStage;               //运动阶段：热身阶段、第一阶段、第二阶段、null。（我的运动和首页  做问卷都回写）
	private String amount;
	private Date loginDate;                   //登录日期
	private Integer userSource=0;//用户来源（0：后台创建及导入，1：商城注册，2：APP端注册）
	private String memberId="";//利安唯一用户ID
/***************************************************************************************/
	
	public String getArchivalNumber() {
		return archivalNumber;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public void setArchivalNumber(String archivalNumber) {
		this.archivalNumber = archivalNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getClienteleType() {
		return clienteleType;
	}
	public void setClienteleType(String clienteleType) {
		this.clienteleType = clienteleType;
	}
	public String getMembershipLevel() {
		return membershipLevel;
	}
	public void setMembershipLevel(String membershipLevel) {
		this.membershipLevel = membershipLevel;
	}
	public String getMedicalInstitution() {
		return medicalInstitution;
	}
	public void setMedicalInstitution(String medicalInstitution) {
		this.medicalInstitution = medicalInstitution;
	}
	public String getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getServiceOrganization() {
		return serviceOrganization;
	}
	public void setServiceOrganization(String serviceOrganization) {
		this.serviceOrganization = serviceOrganization;
	}
	public String getInsuranceOrganization() {
		return insuranceOrganization;
	}
	public void setInsuranceOrganization(String insuranceOrganization) {
		this.insuranceOrganization = insuranceOrganization;
	}
	public String getHealthManager() {
		return healthManager;
	}
	public void setHealthManager(String healthManager) {
		this.healthManager = healthManager;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public Date getServiceStartTime() {
		return serviceStartTime;
	}
	public void setServiceStartTime(Date serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}
	public Date getServiceEndTime() {
		return serviceEndTime;
	}
	public void setServiceEndTime(Date serviceEndTime) {
		this.serviceEndTime = serviceEndTime;
	}
	public String getClienteleTrait() {
		return clienteleTrait;
	}
	public void setClienteleTrait(String clienteleTrait) {
		this.clienteleTrait = clienteleTrait;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public Long getBlocId() {
		return blocId;
	}
	public void setBlocId(Long blocId) {
		this.blocId = blocId;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Long getServiceOrganizationId() {
		return serviceOrganizationId;
	}
	public void setServiceOrganizationId(Long serviceOrganizationId) {
		this.serviceOrganizationId = serviceOrganizationId;
	}
	
	public Date getFirstProfessoinalSportsDate() {
		return firstProfessoinalSportsDate;
	}
	public void setFirstProfessoinalSportsDate(Date firstProfessoinalSportsDate) {
		this.firstProfessoinalSportsDate = firstProfessoinalSportsDate;
	}
	public Integer getAge() {
		if(birthday != null){
			long day = (new Date().getTime() - birthday.getTime()) / (24*60*60*1000) + 1;
			String year = String.valueOf(day/365f).replace(".", ",");//小数点无法用split拆分
			String ageStr= year.split(",")[0];
			return Integer.parseInt(ageStr);
		}
		return null;
	}
	public String getLifecycle() {
		return lifecycle;
	}
	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public String getRemindState() {
		return remindState;
	}
	public void setRemindState(String remindState) {
		this.remindState = remindState;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getHealthManagerId() {
		return healthManagerId;
	}
	public void setHealthManagerId(Long healthManagerId) {
		this.healthManagerId = healthManagerId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Boolean getPlanState() {
		return planState;
	}
	public void setPlanState(Boolean planState) {
		this.planState = planState;
	}
	public String getNewMainDiseasse() {
		return newMainDiseasse;
	}
	public void setNewMainDiseasse(String newMainDiseasse) {
		this.newMainDiseasse = newMainDiseasse;
	}
	public String getNewCurrentDiagnosis() {
		return newCurrentDiagnosis;
	}
	public void setNewCurrentDiagnosis(String newCurrentDiagnosis) {
		this.newCurrentDiagnosis = newCurrentDiagnosis;
	}
	public String getPhysicalType() {
		return physicalType;
	}
	public void setPhysicalType(String physicalType) {
		this.physicalType = physicalType;
	}
	public String getMedicalPackageName() {
		return medicalPackageName;
	}
	public void setMedicalPackageName(String medicalPackageName) {
		this.medicalPackageName = medicalPackageName;
	}
	public Date getPhysicalCreateDate() {
		return physicalCreateDate;
	}
	public void setPhysicalCreateDate(Date physicalCreateDate) {
		this.physicalCreateDate = physicalCreateDate;
	}
	public Date getPhysicalPlanDate() {
		return physicalPlanDate;
	}
	public void setPhysicalPlanDate(Date physicalPlanDate) {
		this.physicalPlanDate = physicalPlanDate;
	}
	public String getPhysicalReport() {
		return physicalReport;
	}
	public void setPhysicalReport(String physicalReport) {
		this.physicalReport = physicalReport;
	}
	public String getPhysicalReportSuggest() {
		return physicalReportSuggest;
	}
	public void setPhysicalReportSuggest(String physicalReportSuggest) {
		this.physicalReportSuggest = physicalReportSuggest;
	}
	public String getPhysicalReportIds() {
		return physicalReportIds;
	}
	public void setPhysicalReportIds(String physicalReportIds) {
		this.physicalReportIds = physicalReportIds;
	}
	public String getPlanItemCount() {
		return planItemCount;
	}
	public void setPlanItemCount(String planItemCount) {
		this.planItemCount = planItemCount;
	}
	public String getLogout() {
		return logout;
	}
	public void setLogout(String logout) {
		this.logout = logout;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public Boolean getHavePlanToday() {
		return havePlanToday;
	}
	public void setHavePlanToday(Boolean havePlanToday) {
		this.havePlanToday = havePlanToday;
	}
	public Boolean getHavePlanThree() {
		return havePlanThree;
	}
	public void setHavePlanThree(Boolean havePlanThree) {
		this.havePlanThree = havePlanThree;
	}
	public Boolean getRemindPrescription() {
		return remindPrescription;
	}
	public void setRemindPrescription(Boolean remindPrescription) {
		this.remindPrescription = remindPrescription;
	}
	public Boolean getRemindQuota() {
		return remindQuota;
	}
	public void setRemindQuota(Boolean remindQuota) {
		this.remindQuota = remindQuota;
	}
	public Boolean getRemindFourArchives() {
		return remindFourArchives;
	}
	public void setRemindFourArchives(Boolean remindFourArchives) {
		this.remindFourArchives = remindFourArchives;
	}
	public Date getMyMsgClickTime() {
		return myMsgClickTime;
	}
	public void setMyMsgClickTime(Date myMsgClickTime) {
		this.myMsgClickTime = myMsgClickTime;
	}
	public Date getSystemMsgClickTime() {
		return systemMsgClickTime;
	}
	public void setSystemMsgClickTime(Date systemMsgClickTime) {
		this.systemMsgClickTime = systemMsgClickTime;
	}
	public Date getConsultMsgClickTime() {
		return consultMsgClickTime;
	}
	public void setConsultMsgClickTime(Date consultMsgClickTime) {
		this.consultMsgClickTime = consultMsgClickTime;
	}
	public String getHaveArchival() {
		return haveArchival;
	}
	public void setHaveArchival(String haveArchival) {
		this.haveArchival = haveArchival;
	}
	public Date getFirstLoginTime() {
		return firstLoginTime;
	}
	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}
	public Boolean getWhetherSendToday() {
		return whetherSendToday;
	}
	public void setWhetherSendToday(Boolean whetherSendToday) {
		this.whetherSendToday = whetherSendToday;
	}
	public Boolean getWhetherSendThree() {
		return whetherSendThree;
	}
	public void setWhetherSendThree(Boolean whetherSendThree) {
		this.whetherSendThree = whetherSendThree;
	}
	public String getSportsStage() {
		return sportsStage;
	}
	public void setSportsStage(String sportsStage) {
		this.sportsStage = sportsStage;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getRemindAssessment() {
		return remindAssessment;
	}
	public void setRemindAssessment(Boolean remindAssessment) {
		this.remindAssessment = remindAssessment;
	}
	public Integer getUserSource() {
		return userSource;
	}
	public void setUserSource(Integer userSource) {
		this.userSource = userSource;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
