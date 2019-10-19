package ke.co.ipandasoft.newsreader.base;

import android.content.Context;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import java.util.Locale;



public class BaseApplication extends MultiDexApplication {

    private static final String TAG = BaseApplication.class.getName();
    private static BaseApplication context;


    public static BaseApplication getContext() {
        Log.e("GIVING CTX", "CONTEXT");
        return context;
    }

    public void onCreate() {
        super.onCreate();
        context = this;

    }



    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}
