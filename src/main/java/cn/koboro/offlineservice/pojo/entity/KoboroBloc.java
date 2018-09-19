package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 健康主题实体类
 * @author hsl
 */
@Data
@Entity
@Table(name = "koboro_bloc")
public class KoboroBloc {
	@Id
    @Column(name = "id")
    private Integer id;
    
    /** 公司名称 */
    @Column(name = "name")
    private String name;
    
    /** 父级ID */
    @Column(name = "parent_id")
    private Long parentId;
    
    /** 实际地址 */
    @Column(name = "actual_addr")
    private String actualAddr;

}

