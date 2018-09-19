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
@Table(name = "koboro_doctor")
public class KoboroDoctor {
	@Id
    @Column(name = "id")
    private Integer id;
    
    /** 医生姓名 */
    @Column(name = "doctor_name")
    private String doctorName;

    /** 类型 */
    @Column(name = "doctor_type")
    private String doctorType;

    /** 唯一Id */
    @Column(name = "doctor_id")
    private String doctorId;
}

