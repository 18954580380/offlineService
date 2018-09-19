package cn.koboro.offlineservice.utils;

import cn.koboro.offlineservice.enums.ResultEnum;
import cn.koboro.offlineservice.pojo.vo.ResultVO;

/**
 * @author xdw
 */
public class ResultUtil {

    public static ResultVO success(Object object) {
        ResultVO result = new ResultVO();
        result.setResultEnums(ResultEnum.SUCCESS);
        result.setData(object);
        return result;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO result = new ResultVO();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static ResultVO error(ResultEnum resultEnum, String... args) {
        ResultVO result = new ResultVO();
        result.setResultEnums(resultEnum, args);
        return result;
    }
}
