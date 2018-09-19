package cn.koboro.offlineservice.tag;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * xdw
 */
@Slf4j
public class DataDes extends TagSupport{

    private String value;

    @Override
    public int doStartTag() throws JspException {

        String  result="无";

        if(value != null){
            if(value.length()>11){
                result = value.substring(0,4)+"*****"+value.substring(value.length()-5);
            }else if(value.length() == 11){
                result = value.substring(0,2)+"*****"+value.substring(value.length()-4);
            }else if(value.length() > 6){
                result = value.substring(0,2)+"*****"+value.substring(value.length()-3);
            }else{
                result = value;
            }
        }

        try {
            JspWriter out = pageContext.getOut();
            out.print(result);
            out.flush();

        } catch (IOException ex) {
            log.error(ex.getMessage(),ex);
        }
        return SKIP_BODY;
    }


    public void setValue(String value) {
        this.value = value;
    }
}
