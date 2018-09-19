package cn.koboro.offlineservice.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

/**
 * @author xdw
 */
public class PermissionTag extends TagSupport {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        boolean result = false;

        // 通过成员变量获取HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
        Object obj = request.getSession().getAttribute("permissionList");
        if (null != obj) {
            List<String> permissionList = (List<String>) obj;
            for (String permission : permissionList) {
                if (name.equals(permission)) {
                    result = true;
                    break;
                }
            }
        }
        //EVAL_BODY_INCLUDE代表执行自定义标签中的内容，SKIP_BODY代表不执行自定义标签中的内容。
        return result ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }
}
