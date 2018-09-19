package cn.koboro.offlineservice.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xdw
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PointsTypeEnum implements CodeEnum {

    /**
     * 新增
     */
    NEW(0, "新增"),
    /**
     * 已消费
     */
    CONSUMPTION(1, "消费"),
    /**
     * 已失效
     */
    FAILURE(2, "失效");

    private Integer code;
    private String msg;

}
