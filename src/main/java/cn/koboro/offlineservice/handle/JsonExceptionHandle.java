package cn.koboro.offlineservice.handle;

import cn.koboro.offlineservice.exception.ApplicationException;
import cn.koboro.offlineservice.pojo.vo.ResultVO;
import cn.koboro.offlineservice.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author xdw
 */
@Slf4j
@ControllerAdvice("com.koboro.intergral.controller.json")
public class JsonExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO handle(Exception e) {
        if (e instanceof ApplicationException) {
            ApplicationException applicationException = (ApplicationException) e;
            return ResultUtil.error(applicationException.getCode(), applicationException.getMessage());
        } else {
            log.error("【系统异常 develop version】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }

}
