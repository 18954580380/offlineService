package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
/**
 * 健康主题实体类
 * @author hsl
 */
@Data
@Entity
@Table(name = "offline_service_health_theme_template")
public class HealthThemeTemplate {
	@Id
    @Column(name = "id",unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /** 主题名称 */
    @Column(name = "theme_name")
    private String themeName;
    
    /** 主要问题 */
    @Column(name = "main_problem")
    private String mainProblem;
    
    /** 主要症状 */
    @Column(name = "main_symptom")
    private String mainSymptom;
    
    /** 阳性指标 */
    @Column(name = "positive_index")
    private String positiveIndex;
    
    /** 健康风险 */
    @Column(name = "health_risk")
    private String healthRisk;
    
    /** 年龄段 */
    @Column(name = "age_group")
    private String ageGroup;
    
    /** 创建时间 */
    @Column(name = "create_time")
    private Date createTime;
    
    /** 修改时间 */
    @Column(name = "update_time")
    private Date updateTime;
    
    /** 创建者*/
    @Column(name = "creator")
    private String creator;
}

