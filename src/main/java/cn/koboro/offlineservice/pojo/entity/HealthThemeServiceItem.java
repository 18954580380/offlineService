package cn.koboro.offlineservice.pojo.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.koboro.offlineservice.utils.json.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 主题任务服务项目关联表
 * @author admin
 *
 */
@Data
@Entity
@Table(name = "offline_service_health_theme_service_item")
public class HealthThemeServiceItem {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**主题任务ID**/
	@Column(name="theme_task_id")
	private Integer themeTaskId;
	
	/**服务项目**/
	@Column(name="service_project")
	private String serviceProject;

	/**服务项目人数上限**/
	@Column(name="service_project_ceiling")
	private Integer serviceProjectCeiling;
	
	/**服务项目内容**/
	@Column(name="service_content")
	private String serviceContent;
	
	/**是否为必查项目  默认0 非必查 1 必查 **/
	@Column(name="is_check")
	private String isCheck;
	
	/**已报名多少人**/
	@Column(name="number")
	private String number;

	/**创建着**/
	@Column(name="creator_id")
	private Long creatorId;

	/**创建着**/
	@Column(name="creator")
	private String creator;

	/**创建时间**/
	@JsonSerialize(using = Date2LongSerializer.class)
	@Column(name="created_time")
	private Date createdTime;


}
