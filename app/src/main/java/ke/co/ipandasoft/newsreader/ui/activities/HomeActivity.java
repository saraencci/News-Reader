package ke.co.ipandasoft.newsreader.ui.activities;


import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.chivorn.smarttoolbar.SmartToolbar;
import com.google.android.material.navigation.NavigationView;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import ke.co.ipandasoft.newsreader.R;
import ke.co.ipandasoft.newsreader.base.activitybase.BaseActivity;
import ke.co.ipandasoft.newsreader.utils.SimpleAppUtils;
import ke.co.ipandasoft.newsreader.utils.ToastUtils;


public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    List<Fragment> fragmentList = new ArrayList();
    @BindView(R.id.toolbar)
    SmartToolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private List<String> catnamesArray = new ArrayList<>();
    private boolean doubleBackToExitPressedOnce=false;
    public static String TAG = HomeActivity.class.getSimpleName();
    private boolean isActivityIsVisible = true;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        super.initView();
        setToolBar();
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public int getLayoutId() {

        return R.layout.activity_home;
    }


    public void onResume() {
        super.onResume();
        setDrawer();
        isActivityIsVisible=true;
    }

    public void setDrawer() {

    }



    private void setToolBar() {

        toolbar.setTitleText("NEWS READER");
        toolbar.setLeftButtonIcon(getResources().getDrawable(R.drawable.ic_menu_24dp));
        toolbar.setOnLeftButtonClickListener(v -> {
            if (HomeActivity.this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                HomeActivity.this.drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                HomeActivity.this.drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            return;
        }
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
        doubleBackToExitPressedOnce = true;
        ToastUtils.showShortToast("Double Click Faster To exit App....");
        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
    }


    @Override
    protected void onPause() {
        super.onPause();
        isActivityIsVisible = false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        drawerLayout.closeDrawer(GravityCompat.START);
        if (menuItem.isChecked()) {
            return true;
        }else if (menuItem.getItemId()==R.id.log_out){
            SimpleAppUtils.showLogOutDialog(HomeActivity.this);
        }
        return false;
    }
}
