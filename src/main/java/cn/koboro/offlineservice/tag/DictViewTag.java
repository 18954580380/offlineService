
package cn.koboro.offlineservice.tag;

import cn.koboro.offlineservice.pojo.entity.Dict;
import cn.koboro.offlineservice.service.DictService;
import cn.koboro.offlineservice.service.impl.DictServiceImpl;
import cn.koboro.offlineservice.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xdw
 */
@Slf4j
public class DictViewTag extends TagSupport {

    private String key;

    private DictService dictService = SpringContextHolder.getBean(DictServiceImpl.class);

    private static final Map<String, String> DICT_MAP = new HashMap<>();

    public DictViewTag() {
        init();
    }

    @Override
    public int doStartTag() throws JspException {


        try {
            JspWriter out = pageContext.getOut();
            String value = "";
            if (DICT_MAP.get(key) != null) {
                value = DICT_MAP.get(key);
            } else {
                refreshDict();
            }
            out.print(value);
            out.flush();

        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
        return SKIP_BODY;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private void init() {
        List<Dict> dicts = dictService.selectAll();
    }

    private void refreshDict(){
        List<Dict> dicts = dictService.selectAll();
        for (Dict dict : dicts) {
            String value = DICT_MAP.get(dict.getDictKey());
            if (StringUtils.isEmpty(value)) {
                DICT_MAP.put(dict.getDictKey(), dict.getDictValue());
            }
        }
    }

    private void thermalLoading(){
//        dictService.selectByPrimaryKey()
    }

}
