package cn.koboro.offlineservice.controller;

import cn.koboro.offlineservice.pojo.entity.SystemMenu;
import cn.koboro.offlineservice.service.SystemMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xdw
 */
@Controller
public class MenuPageController {

    @Resource
    private SystemMenuService menuService;
    
    @RequestMapping(value = "/menu/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(ModelMap model) {
        List<SystemMenu> list = menuService.selectAll();
        model.put("list", list);
        return "menu/list";
    }

    @RequestMapping(value = "menu/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add() {
        return "menu/add";
    }
    
    @RequestMapping(value = "/menu/iframe", method = {RequestMethod.GET, RequestMethod.POST})
    public String testIframe(){
        return "menu/iframe";
    }
}
