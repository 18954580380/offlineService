package cn.koboro.offlineservice.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xdw
 */
@Slf4j
public class DateUtil {

    public static Date age2date(int age) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -age);
        return cal.getTime();
    }


    /**
     * yyyy-MM-dd
     *
     * @return
     */
    public static Date simpleString2date(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            log.info("date转换失败", e);
        }
        return date;
    }

    /**
     * 日期比较
     */
    public static boolean dataCompare(String data) {
        if (StringUtils.isBlank(data)) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//创建日期转换对象HH:mm:ss为时分秒，年月日为yyyy-MM-dd
        String dataStr = df.format(new Date());
        try {
            Date dt1 = df.parse(data);//将字符串转换为date类型
            Date dt2 = df.parse(dataStr);
            if (dt1.getTime() >= dt2.getTime())//比较时间大小,如果dt1大于dt2
            {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;

    }


    /**
     * yyyy-MM-dd
     *
     * @return
     */
    public static String formatConversion(Object dateStr) {
        if (Validator.isEmpty(dateStr)) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(dateStr);
        }
    }
    public static final SimpleDateFormat separatorSdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    public static List<String> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<String> lDate = new ArrayList<String>();
        lDate.add(sdf.format(beginDate));// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(sdf.format(cal.getTime()));
            } else {
                break;
            }
        }
        String data=sdf.format(endDate);
        lDate.add(data);// 把结束时间加入集合
        return lDate;
    }
    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) (((date2.getTime()+(1000*3600*24)) - date1.getTime()) / (1000*3600*24));
        return days;
    }
}