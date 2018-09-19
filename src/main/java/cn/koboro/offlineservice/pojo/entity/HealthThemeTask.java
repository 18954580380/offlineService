package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
/**
 * 健康主题关联任务表
 * @author admin
 *
 */
@Data
@Entity
@Table(name = "offline_service_health_theme_task")
public class HealthThemeTask {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**主题ID**/
	@Column(name="theme_id")
	private Integer themeId;
	
	/**主题名称**/
	@Column(name="theme_name")
	private String themeName;
	
	/**服务集团ID**/
	@Column(name="bloc_id")
	private Integer blocId;
	
	/**服务集团名称**/
	@Column(name="bloc_name")
	private String blocName;
	
	/**子公司Id**/
	@Column(name="subordinate_company_id")
	private Integer subordinateCompanyId;
	
	/**子公司名称**/
	@Column(name="subordinate_company_name")
	private String subordinateCompanyName;
	
	/**服务开始时间**/
	@Column(name="service_start_time")
	private Date serviceStartTime;
	
	/**服务结束时间**/
	@Column(name="service_end_time")
	private Date serviceEndTime;
	
	/**服务天数**/
	@Column(name="service_day")
	private Integer serviceDay;
	
	/**服务地址**/
	@Column(name="service_address")
	private String serviceAddress;
	
	/**图片地址**/
	@Column(name="img_url")
	private String imgUrl;

	/**预约时间段 0设置 1不设置**/
	@Column(name="appointment_time")
	private Integer appointmentTime;
	

	/**上午开始时间**/
	@Column(name="am_start_time")
	private String amStartTime;
	
	/**上午结束时间**/
	@Column(name="am_end_time")
	private String amEndTime;
	
	/**下午开始时间**/
	@Column(name="pm_start_time")
	private String pmStartTime;
	
	/**下午结束时间**/
	@Column(name="pm_end_time")
	private String pmEndTime;
	
	/**时间间隔**/
	@Column(name="time_interval")
	private Integer timeInterval;
	
	/**服务主体介绍**/
	@Column(name="service_introduction")
	private String serviceIntroduction;
	
	/**健康主题管理目标**/
	@Column(name="management_target")
	private String managementTarget;
	
	/**人数上限**/
	@Column(name="service_ceiling")
	private Integer serviceCeiling;
	
	/**服务支持**/
	@Column(name="service_support")
	private String serviceSupport;
	
	/**创建时间**/
	@Column(name="create_time")
	private Date createTime;
	
	/**修改时间**/
	@Column(name="update_Time")
	private Date updateTime;
	
	/**发布时间**/
	@Column(name="release_time")
	private Date releaseTime;
	
	
	

	
	
}
