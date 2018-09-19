package cn.koboro.offlineservice.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xdw
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResultEnum implements CodeEnum {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(-1, "未知错误"),
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 值重复
     */
    REPEAT(1, "{%s}值重复"),
    /**
     * 类型不存在
     */
    TYPE_NULL(81, "类型不存在"),
    /**
     * 父类型不存在
     */
    PARENT_NULL(89, "父类型不存在"),

    /**
     * 其他
     */
    OTHER(99, "{%s}");


    private Integer code;

    private String msg;

}
