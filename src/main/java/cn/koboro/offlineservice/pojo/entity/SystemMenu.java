package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author xdw
 */
@Data
@Table(name = "offline_service_system_menu")
public class SystemMenu {

    @Column(name = "id")
    private Long id;

    @NotNull(message = "菜单名不能为空")
    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_url")
    private String menuUrl;
    @Column(name = "param")
    private String param;
    @Column(name = "param_default")
    private String paramDefault;
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "sort")
    private String sort;
    @Column(name = "c_time")
    private Date createTime;
    @Column(name = "u_time")
    private Date updateTime;
    @Column(name = "is_del")
    private Integer isDel;
    @Column(name = "is_menu")
    private Integer isMenu;
    @Column(name = "img_class")
    private String imgClass;

    @Transient
    private List<SystemMenu> childes = null;

}
