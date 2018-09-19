package cn.koboro.offlineservice.tag;

import cn.koboro.offlineservice.constants.CommonConstants;
import cn.koboro.offlineservice.pojo.entity.Dict;
import cn.koboro.offlineservice.service.DictService;
import cn.koboro.offlineservice.service.impl.DictServiceImpl;
import cn.koboro.offlineservice.utils.SpringContextHolder;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xdw
 */
public class DictOederIterationTag extends BodyTagSupport {
    private String var;
    private Iterator<?> iterator;
    private String dictOrder;

    private DictService dictService = SpringContextHolder.getBean(DictServiceImpl.class);

    public void setVar(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }

    public void setIterator(Iterator<?> iterator) {
        this.iterator = iterator;
    }


    @Override
    public int doAfterBody() throws JspException {
        if (this.process()) {
            return EVAL_BODY_AGAIN;
        } else {
            return EVAL_PAGE;
        }

    }

    @Override
    public int doStartTag() throws JspException {
        if (this.process()) {
            return EVAL_BODY_INCLUDE;
        } else {
            return EVAL_PAGE;
        }
    }

    public void setDictOrder(String dictOrder) {
        this.dictOrder = dictOrder;
        List<Dict> list = new ArrayList<>();

        Condition condition = new Condition(Dict.class);
        Condition.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("type", CommonConstants.Dict.TYPE_CHILD);
        criteria.andEqualTo("dictOrder", dictOrder);
        List<Dict> dicts = dictService.selectByExample(condition);

        this.iterator = list.iterator();

    }

    private boolean process() {
        if (null == this.iterator || !this.iterator.hasNext()) {
            return false;
        }

        Dict entity = (Dict) iterator.next();
        pageContext.setAttribute(var, entity);
        return true;
    }

}


