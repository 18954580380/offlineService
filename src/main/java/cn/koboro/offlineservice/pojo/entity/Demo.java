package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author HSL
 */
@Data
@Entity
@Table(name = "t_demo")
public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "project_name")
    private String projectName;
}
