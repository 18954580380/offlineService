package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 提醒记录表。
 * 提交检查建议、提交健康处方（+营养处方+运动处方）、提交体检设计、保存基础档案：需要给客户推送消息“有新的健康方案，请您一定查看”，并且在提醒记录表生成数据。
 * 健康工作站-客户管理-进入客户处理-健康干预-执行：修改提醒时间（可能修改多条记录），同时修改计划日期，等待定时提醒调用。
 * 健康工作站-健康干预-批量提醒（+6个页面创建临时计划）：发送日期为空，立即给客户推送消息“今日有健康新计划，请查看”，并且提醒记录表生成记录,
 * 发送日期不为空，在批量提醒表RemindContentBatch（或者6个页面对应的4张表+HealthInterves）生成记录，等待定时提醒调用。
 * 定时提醒需要查询计划对应的6张表（常规计划和临时计划都在）、RemindContentBatch批量提醒表，然后给客户推送消息“今日有健康新计划，请查看”，
 * 并且在提醒记录表生成记录（提前一个月、提前一周、提前一天；提前三天、当天；每天8点、12点、20点）。（定时计划是在原记录上修改计划日期）
 * 实时提醒（立即提醒、手动提醒）：一个客户的一条消息，在提醒记录表生成一条记录。（保存基础档案，客户收到一条消息，生成3条记录。）
 * 定时提醒（自动提醒）：客户收到一条消息可能在提醒记录表有多条记录。除了吃药，其他计划每天只在8点给客户发一条消息。吃药每天提醒三次，提醒一次生成一条记录。
 * @author lenove1
 */
@Data
@Entity
@Table(name = "KOBORO_REMIND_CONTENT_SEND")
public class RemindContentSend{
	private static final long serialVersionUID = 1L;
	private Long customerId;      //客户id(有的数据没有客户id)
	private String archivalNumber;//档案号
	private Date createdTime;//档案号
	private String userName;      //客户姓名
	private String type;          //提醒类别：健康处方、专项检查、健康监测、周期性评估、周期健康档案、体检管理、预约面诊
	private String name;          //提醒名称 (系统维护中的名称)
	private String content;       //提醒内容（根据系统维护中RemindContent的提醒类别自动带出提醒内容。临时计划、批量提醒、健康干预页签执行，医生可修改提醒内容）
	private Date sendDate;        //提醒时间
	private Boolean isAuto = true;//是否是自动提醒：手动false、自动true
	private String dataIds;       //项目id、药品id（批量提醒只能选择客户，不能选择项目）
	private String itemNames;     //项目名称、药品名称
	private Boolean whetherRead = false;//是否已读（APP使用）
	private Long themeTaskId ;//主题任务id  线下服务使用字段
}