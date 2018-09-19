package cn.koboro.offlineservice.tag;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cn.koboro.offlineservice.utils.MenuUtil;

import java.io.IOException;

/**
 * @author xdw
 */
@Slf4j
public class MenuTag extends TagSupport {

    private String loginName;

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            String menu = MenuUtil.getInstance().getMenuHtml();
            System.out.println(menu);
            out.print(menu);
            out.flush();
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
        return SKIP_BODY;
    }

}
