package ke.co.ipandasoft.newsreader.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeParser {


    public static String ConvertTime(String time) throws ParseException {
        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();
        Log.e("Time zone: ", tz.getDisplayName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat outputDateFormat = new SimpleDateFormat("HH:mm");
        outputDateFormat.setTimeZone(tz);
        Date date = simpleDateFormat.parse(time);
        String finalLocalTime = outputDateFormat.format(date);

        return finalLocalTime;
    }

    public static String ConvertNewsTime(String newsDate){

        Date dateParsed=null;
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");


        try {
            dateParsed=temp.parse(newsDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return String.valueOf(dateParsed);
    }

    public static String ConvertServerTime(String time) throws ParseException {
        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();
        Log.e("Time zone: ", tz.getDisplayName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat outputDateFormat = new SimpleDateFormat("HH:mm");
        outputDateFormat.setTimeZone(tz);
        Date date = simpleDateFormat.parse(time);
        String finalLocalTime = outputDateFormat.format(date);

        return finalLocalTime;
    }


}
