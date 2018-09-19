
package cn.koboro.offlineservice.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author xdw
 */
@Data
@Entity
@Table(name = "t_md_dict")
public class Dict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotNull(groups = Child.class, message = "字典key_不能为空")
    @Pattern(groups = Child.class, regexp = "\\S+", message = "字典key格式不正确")
    @Column(name = "dict_key")
    private String dictKey;

    @NotNull(message = "字典值_不能为空")
    @Pattern(regexp = "\\S+", message = "字典值格式不正确")
    @Column(name = "dict_value")
    private String dictValue;

    @Column(name = "parent_id")
    private String parentId;

    @NotNull(groups = Parent.class, message = "分组_不能为空")
    @Pattern(groups = Parent.class, regexp = "\\w+", message = "分组只能输入数字、字母和下划线")
    @Column(name = "dict_order")
    private String dictOrder;

    @NotNull(groups = Parent.class, message = "类型不符合")
    private Integer type;

    public interface Child {
    }

    public interface Parent {
    }

}
