package cn.koboro.offlineservice.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * demo_controller
 *
 * @author admin
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request, ModelMap modelMap) {
        System.out.printf("username: %s", getUsername());
        modelMap.put("username", getUsername());
        return "demo/demo";
    }

    private String DEFAULTUSER = "用户";

    //获取登陆用户用户名
    public String getUsername() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null || subject.getPrincipals() == null) {
            return DEFAULTUSER;
        }
        return (String) subject.getPrincipals().getPrimaryPrincipal();
    }
}
