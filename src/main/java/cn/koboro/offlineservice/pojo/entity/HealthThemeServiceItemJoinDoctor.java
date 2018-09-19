package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "offline_service_health_theme_service_item_join_doctor")
public class HealthThemeServiceItemJoinDoctor {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**主题任务ID**/
	@Column(name="theme_task_id")
	private Integer themeTaskId;
	
	/**健康管理师ID 唯一**/
	@Column(name="doctor_id")
	private Integer  doctorId;
	
	/**健康管理师姓名**/
	@Column(name="doctor_name")
	private String doctorName;
	
	/**服务项目**/
	@Column(name="service_project")
	private String serviceProject;
	
	/**类型 1健康管理师 2医生**/
	@Column(name="type")
	private Integer type;

	/**创建着**/
	@Column(name="creator_id")
	private Long creatorId;

	/**创建着**/
	@Column(name="creator")
	private String creator;

	/**创建时间**/
	@Column(name="created_time")
	private Date createdTime;

}
