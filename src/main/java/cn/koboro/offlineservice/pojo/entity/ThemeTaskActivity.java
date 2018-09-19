package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
/**
 * 主题任务活动关联表
 * @author admin
 *
 */
@Data
@Table(name = "offline_service_theme_task_activity")
public class ThemeTaskActivity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**活动ID**/
    @Column(name="activity_id")
    private Integer activityId;

    /**活动名称**/
    @Column(name="activity_name")
    private String activityName;

    /**主题任务Id**/
    @Column(name="theme_task_id")
    private Integer themeTaskId;

    @Transient
    private String startTime;

    /**活动开始时间**/
    @Column(name="activity_start_time")
    private Date activityStarttime;

    /**创建时间**/
    @Column(name="create_time")
    private Date createTime;
}
