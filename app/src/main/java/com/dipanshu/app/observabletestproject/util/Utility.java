package com.dipanshu.app.observabletestproject.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dipanshu on 24-12-2017.
 */

public class Utility {


    public static String getDateDifference(long postsDate){
        Calendar current = Calendar.getInstance();
        current.setTime(new Date());

        // Get the represented date in milliseconds
        long currentMs = current.getTimeInMillis();

        // Calculate difference in milliseconds
        long diff = currentMs - postsDate;

        // Calculate difference in seconds
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        if (diffMinutes < 60){
            if (diffMinutes == 1)
                return diffMinutes + " minute ago";
            else
                return diffMinutes + " minutes ago";
        } else if (diffHours < 24){
            if (diffHours == 1)
                return diffHours + " hour ago";
            else
                return diffHours + " hours ago";
        }else if (diffDays < 30){
            if (diffDays == 1)
                return diffDays + " day ago";
            else
                return diffDays + " days ago";
        }else {
            return "a long time ago..";
        }
    }

    public static long timeInMillis(String timestamp){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
        Date date = null;
        long postDate = 0;
        try {
            date = df.parse(timestamp);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            postDate = calendar.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return postDate;
    }
}
