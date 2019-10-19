package ke.co.ipandasoft.newsreader.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;



public class PageJump {
    public static void startActivity(Context context, Class nextActivity) {
        context.startActivity(new Intent(context, nextActivity));
    }

    public static void startActivityOut(Context context, Class nextActivity) {
        Intent intent=new Intent(context,nextActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void startActivityWithData(Context context, Class nextActivity, String name, String newTitle) {
        Intent intent = new Intent(context, nextActivity);
        intent.putExtra("param_url", name);
        intent.putExtra("news_title", newTitle);
        context.startActivity(intent);
    }

    public static void startActivityWithData(Context context, Class nextActivity, Bundle bundle) {
        Intent intent = new Intent(context, nextActivity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public static void startActivityOutBroswer(Context context, Class nextActivity,String urlPage,int mode,String newsTitle) {
        Intent intent=new Intent(context,nextActivity);
        intent.putExtra("param_url",urlPage);
        intent.putExtra("param_mode",mode);
        intent.putExtra("news_title",newsTitle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
