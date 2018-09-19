package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

import cn.koboro.offlineservice.utils.Validator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 今日服务对象表
 * @author hsl
 */
@Data
@Entity
@Table(name = "offline_service_today_Service_customers")
public class TodayServiceCustomers {
	@Id
    @Column(name = "id")
    private Integer id;
    
    /** 主题任务ID */
    @Column(name = "theme_task_id")
    private Integer themeTaskId;
    
    /** 用户档案号 */
    @Column(name = "archival_number")
    private String archivalNumber;
    
    /** 用户姓名 */
    @Column(name = "name")
    private String name;
    
    /** 部门ID */
    @Column(name = "dept_id")
    private Long deptId;
    
    /** 部门名称 */
    @Column(name = "dept")
    private String dept;
    
    /** 性别:1男 2女 */
    @Column(name = "sex")
    private Integer sex;
    
    /** 联系方式 */
    @Column(name = "phone_number")
    private String phoneNumber;
    
    /** 是否参加本次任务  0未参加 1参加 */
    @Column(name = "is_join")
    private Integer isJoin;
    
    /** 时间段   如果是通过报名 会有一个时间段*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "time_quantum")
    private Date timeQuantum;
    
    /** 时间间隔所属上午或者下午 */
    @Column(name = "morning_or_afternoon")
    private String morningOrAfternoon;
    
    /** 0主题筛选客户 1主动报名客户  2任务未未完成客户 3套餐未完成用户 4上次服务未完成客户 5自定义客户 多个来源使用,隔开*/
    @Column(name = "source")
    private String source;
    
    /**将source数字字符串转为文字描述  @Transient查询数据库忽略字段**/ 
    @Transient
	private String sourceName;
    
    /**0 未服务 1服务中 2已完成*/
    @Column(name = "status")
    private Integer status;
    
    /**0 未出方案 1处理中 2已出方案*/
    @Column(name = "doctor_flag")
    private Integer doctorflag;
    
    /**完成情况 数据库字段舍弃*/
    @Transient
    private String completeStatus;
    
    /**创建时间*/
    @Column(name = "create_time")
    private Date createTime;
    
    /**修改时间*/
    @Column(name = "update_time")
    private Date updateTime;
    
    @Transient
    private String code;
    public String getSourceName() {
        String str="";
        if(StringUtils.isBlank(source)){
            return str;
        }
    	if(source.contains("0")){
    		str+="主题筛选,";
    	}
    	if(source.contains("1")){
    		str+="主动报名,";
    	}
    	if(source.contains("2")){
    		str+="任务未完成,";
    	}
    	if(source.contains("3")){
    		str+="套餐未完成,";
    	}
    	if(source.contains("4")){
    		str+="上次服务未完成,";
    	}
    	if(source.contains("5")){
    		str+="自定义客户,";
    	}
    	if(!Validator.isEmpty(str)){
    	str=str.substring(0, str.length()-1);
    	}
		return str;
	}
}
