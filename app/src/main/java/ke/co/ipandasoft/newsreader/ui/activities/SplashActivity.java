package ke.co.ipandasoft.newsreader.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;


import com.wang.avi.AVLoadingIndicatorView;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import ke.co.ipandasoft.newsreader.R;
import ke.co.ipandasoft.newsreader.base.activitybase.BaseActivity;
import ke.co.ipandasoft.newsreader.utils.PageJump;
import ke.co.ipandasoft.newsreader.utils.SimpleAppUtils;
import ke.co.ipandasoft.newsreader.utils.NetworkUtils;



public class SplashActivity extends BaseActivity {



    @BindView(R.id.avi_loading_view)
    AVLoadingIndicatorView avLoadingIndicatorView;
    private List<String> catnamesArray = new ArrayList<>();
    public static String TAG = SplashActivity.class.getSimpleName();


    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public int getLayoutId() {
        return R.layout.activity_spash;
    }


    @Override
    public void initView() {
        super.initView();
        if (NetworkUtils.isNetworkConnected(SplashActivity.this)){
            avLoadingIndicatorView.show();
            SleepMeth();

        }else {
            SimpleAppUtils.showNetworkToast(SplashActivity.this);
        }

    }



    private void SleepMeth() {

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                PageJump.startActivity(SplashActivity.this,HomeActivity.class);
            }
        },3000);

    }
}