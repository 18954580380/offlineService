package cn.koboro.offlineservice.handle;

import com.github.pagehelper.PageInfo;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ctx处理
 *
 * @author xdw
 */
public class PageInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && modelAndView.getModelMap() != null) {
//            modelAndView.getModelMap().addAttribute("ctx",request.getContextPath());
//            modelAndView.getModelMap().get()
            modelAndView.getModel().put("page", new PageInfo<>((List) modelAndView.getModel().get("page")));
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}
