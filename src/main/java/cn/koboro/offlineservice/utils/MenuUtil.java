
package cn.koboro.offlineservice.utils;

import cn.koboro.offlineservice.pojo.entity.SystemMenu;
import cn.koboro.offlineservice.service.SystemMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xdw
 */
@Slf4j
public class MenuUtil {

    private String context = null;

    private static final Long ROOT_PARENT_ID = 0L;

    private static MenuUtil menuUtil = null;

    public static MenuUtil getInstance() {
        if (menuUtil == null) {
            synchronized (MenuUtil.class) {
                if (menuUtil == null) {
                    menuUtil = new MenuUtil();
                }
            }
        }
        return menuUtil;
    }

    public List<SystemMenu> toTree(List<SystemMenu> menuList) {

        Map<Long, SystemMenu> menuMap = new HashMap<>();

        List<SystemMenu> tree = new ArrayList<>();
        for (int i = 0; i < menuList.size(); i++) {
            //菜单系统自行处理
        	SystemMenu currentMenu = menuList.get(i);
            if (currentMenu.getIsDel() == 0) {
                continue;
            }

            Long parentId = currentMenu.getParentId();
            menuMap.put(currentMenu.getId(), currentMenu);
            if (ROOT_PARENT_ID.equals(parentId)) {
                tree.add(currentMenu);
            } else {
            	SystemMenu parent = menuMap.get(parentId);
                if (parent != null) {
                    List<SystemMenu> childes = parent.getChildes();
                    if (childes == null) {
                        parent.setChildes(childes = new ArrayList());
                    }
                    childes.add(currentMenu);
                }
            }
        }

        return tree;
    }

    /**
     * author:xdw
     * function：得到菜单列表
     */
    public String getMenuHtml() {
        List<SystemMenu> menus = getRelevanceMenus();
        return getMenuHtml(menus).toString();
    }

    private final static String MENU_LI_LABEL = "<i class=\"fa fa-lg fa-fw %s\"></i>";

    private final static String MENU_SPAN_LABEL = "<span class=\"%1$s\">%2$s</span>";
    private final static String PARENT_CLASS = "menu-item-parent";

    private StringBuffer getMenuHtml(List<SystemMenu> menus) {

        StringBuffer sb = new StringBuffer();
        if (context == null) {
            initContext();
        }

        treeHtml(sb, context, menus, getActiveUrl());
//        if (log.isDebugEnabled()) {
//            log.debug(sb.toString());
//        }
        return sb;
    }

    private void treeHtml(StringBuffer sb, String context, List<SystemMenu> menus, String url) {
        if (CollectionUtils.isEmpty(menus)) {
            return;
        }
        sb.append("<ul>");
        for (SystemMenu menu : menus) {
            if (menu == null) {
                continue;
            }
            log.debug("tag:" + "_" + menu.getMenuUrl());
            if (StringUtils.isNotBlank(url) && url.equals(menu.getMenuUrl())) {
                sb.append(" <li class='active'> ");
                setLastActiveUrl(url);
            } else {
                sb.append(" <li> ");
            }
            addOneMenu(sb, context, menu, url);

            if (menu.getChildes() != null) {
                treeHtml(sb, context, menu.getChildes(), url);
            }

            sb.append("</li>");

        }
        sb.append("</ul>");
    }

    private void addOneMenu(StringBuffer sb, String context, SystemMenu menu, String url) {
        sb.append(" <a href='");
        if (StringUtils.isNotBlank(menu.getMenuUrl())) {
            sb.append(context).append(menu.getMenuUrl());//添加链接
        } else {
            sb.append("javaScript:void(0)");
        }
        sb.append("'>");

        String imgClass = menu.getImgClass() != null ? menu.getImgClass() : "";
        sb.append(String.format(MENU_LI_LABEL, imgClass));

        String menuName = menu.getMenuName() != null ? menu.getMenuName() : "";
        String classStyle = "";
        if (ROOT_PARENT_ID.equals(menu.getParentId())) {
            classStyle = PARENT_CLASS;
        } else {
            classStyle = "";
        }
        sb.append(String.format(MENU_SPAN_LABEL, classStyle, menuName));

//        if(menu.getChildes()!=null){
//            sb.append("<b class=\"collapse-sign\"><em class=\"fa fa-expand-o\"></em></b>");
//        }

        sb.append("</a>");
    }

    private List<SystemMenu> getRelevanceMenus() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();

        List<SystemMenu> menus = (List<SystemMenu>) session.getAttribute("menus");
        //todo 测试用，改为登陆注入
        if (CollectionUtils.isEmpty(menus)) {
            menus = SpringContextHolder.getBean(SystemMenuService.class).selectAll();
            session.setAttribute("menus", menus);
        }

        List<SystemMenu> relevanceMenus = (List<SystemMenu>) session.getAttribute("relevanceMenus");

        if (relevanceMenus != null) {
            return relevanceMenus;
        } else {
            if (menus != null) {
                List<SystemMenu> tree = toTree(menus);
                session.setAttribute("relevanceMenus", tree);
                return tree;
            }
            return null;
        }
    }

    private void initContext() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        context = request.getContextPath();
    }

    //获取菜单选中的URL
    private String getActiveUrl() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();

        List<SystemMenu> menus = (List<SystemMenu>) session.getAttribute("menus");
        List<String> urls = (List<String>) session.getAttribute("urls");
        if (CollectionUtils.isEmpty(urls)) {
            if (urls == null) {
                urls = new ArrayList();
            }
            for (SystemMenu menu : menus) {
                if (StringUtils.isNotBlank(menu.getMenuUrl())) {
                    urls.add(menu.getMenuUrl());
                }
            }
            session.setAttribute("urls", urls);
        }

        String url = request.getServletPath();
        if (urls.contains(url)) {
            return url;
        } else {
            return (String) session.getAttribute("lastActiveUrl");
        }
    }

    private void setLastActiveUrl(String url) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("lastActiveUrl", url);
    }
}
