package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 体检项目
 * @author 姜涛
 */
@Data
@Entity
@Table(name = "koboro_service_content")
public class ServicesAvailable {
	@Id
    @Column(name = "id")
    private Integer id;
    
    /** 项目内容 */
    @Column(name = "name")
    private String name;

}

