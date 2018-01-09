package project.android.fkq.movingsquare.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 获取当前日期 返回string 形如2017-01-01
     * @return data
     */
    public static String getDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);
        return date;
    }
}
