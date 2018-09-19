package cn.koboro.offlineservice.tag;

import org.apache.taglibs.standard.tag.common.fmt.FormatDateSupport;

import javax.servlet.jsp.JspTagException;
import java.util.Date;

/**
 * @author xdw
 */
public class FormatDateTag extends FormatDateSupport {
    public FormatDateTag() {

    }

    public void setValue(Date value) throws JspTagException {
        this.value = value;
        if(this.type == null){
            setPattern();
        }


    }

    public void setType(String type) throws JspTagException {
        this.type = type;
        setPattern();
    }

    public void setDateStyle(String dateStyle) throws JspTagException {
        this.dateStyle = dateStyle;
    }

    public void setTimeStyle(String timeStyle) throws JspTagException {
        this.timeStyle = timeStyle;
    }

    public void setPattern(){
        if("date".equals(type)){
            this.pattern = "yyyy-MM-dd";
        }else if("time".equals(type)){
            this.pattern = "HH:mm:ss";
        }else {
            this.pattern = "yyyy-MM-dd HH:mm:ss";
        }
    }

    public void setTimeZone(Object timeZone) throws JspTagException {
        this.timeZone = timeZone;
    }
}
