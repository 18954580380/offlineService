package cn.koboro.offlineservice.handle;

import cn.koboro.offlineservice.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 *
 * @author xdw
 */
@Slf4j
@ControllerAdvice("com.koboro.integral.controller.page")
public class PageExceptionHandle {



    @ExceptionHandler(value = Exception.class)
    public String handle(Exception e, HttpServletRequest request) {
        if (e instanceof ApplicationException) {
            ApplicationException applicationException = (ApplicationException) e;
//            return ResultUtil.error(applicationException.getCode(), applicationException.getMessage());
            request.setAttribute("errorCode", applicationException.getCode());
            request.setAttribute("errorMsg", applicationException.getMessage());
            request.setAttribute("errorException", e);
        } else {
            log.error("【系统异常 develop version】{}", e);
            request.setAttribute("errorCode", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.setAttribute("errorMsg", e.getMessage());
            request.setAttribute("errorException", e);
        }
        return "common/error";
    }

}
