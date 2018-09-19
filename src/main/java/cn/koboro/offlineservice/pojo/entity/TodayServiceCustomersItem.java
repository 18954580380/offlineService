package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 今日服务对象 项目表
 * @author hsl
 */
@Data
@Entity
@Table(name = "offline_service_today_service_customers_item")
public class TodayServiceCustomersItem {
	@Id
    @Column(name = "id")
    private Integer id;
    
    /** 主题任务ID */
    @Column(name = "theme_task_id")
    private Integer themeTaskId;
    
    /** 用户档案号 */
    @Column(name = "archival_number")
    private String archivalNumber;
    
    /** 用户名**/
    @Column(name = "name")
    private String name;
    
    /** 联系方式**/
    @Column(name = "phone_number")
    private String phoneNumber;
    
    /** 被服务项目 */
    @Column(name = "served_items")
    private String servedItems;
    
    /** 0未完成,1完成 ,2放弃 */
    @Column(name = "status")
    private Integer status;
    
    /** 0本次服务项目 1自定义项目**/
    @Column(name = "items_type")
    private Integer itemsType;
    
    /**操作者姓名**/
    @Column(name = "operator")
    private String operator;
    
   
}
