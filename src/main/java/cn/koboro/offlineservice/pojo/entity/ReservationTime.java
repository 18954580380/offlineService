package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 预约时间间隔表
 * @author hsl
 */
@Data
@Entity
@Table(name = "offline_service_reservation_time")
public class ReservationTime {
	@Id
    @Column(name = "id")
    private Integer id;
    
    /** 主题任务ID */
    @Column(name = "theme_task_id")
    private Integer themeTaskId;
    
    /** 间隔时间 开始时间 */
    @Column(name = "start_time")
    private String startTime;
    
    /** 间隔时间 结束时间 */
    @Column(name = "end_time")
    private String endTime;
    
    /** 时间间隔所属上午或者下午 */
    @Column(name = "morning_or_afternoon")
    private String morningOrAfternoon;
    
    /** 报名人数   */
    @Column(name = "number")
    private Integer number = 0;
}
