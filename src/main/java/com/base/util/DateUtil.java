package com.base.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: CTW
 * @description: 时间工具
 * @author: laoyangtou
 * @create: 2018-08-10 13:08
 **/
public class DateUtil {

    public static int currentYear(){
        Calendar calendar = Calendar.getInstance();
        int currentYear  = calendar.get(Calendar.YEAR);
        System.out.println(currentYear);

        String webUrl = "http://www.ntsc.ac.cn";
        try {
            URL url = new URL(webUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
            long time = conn.getDate();
            System.out.println(time);
            Date date = new Date(time);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            String currentTime = sdf.format(date);
            int year = Integer.parseInt(currentTime.substring(0,4));
            return year;
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return currentYear;
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return currentYear;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return currentYear;
        }
    }
}
