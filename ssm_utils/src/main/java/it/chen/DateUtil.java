package it.chen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 * 日期转换
 */

public class DateUtil {
    /**
     * date转字符串
     * @param time
     * @param pattern
     * @return
     */
   public static String dateTimeString(Date time,String pattern){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
       String format = simpleDateFormat.format(time);
       return format;
   }

    /**
     * 字符串转日期
     * @param timestr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date dateTimeDate(String timestr,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date parse = simpleDateFormat.parse(timestr);
        return parse;
    }
}
