package ke.co.ipandasoft.newsreader.base.activitybase;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ke.co.ipandasoft.newsreader.AppManager;
import ke.co.ipandasoft.newsreader.base.InitBase;



public abstract class BaseActivity extends AppCompatActivity implements LayoutRes, InitBase {
    CompositeDisposable compositeDisposable;



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AppManager.addActivity(this);
        super.onCreate(savedInstanceState);
        beforeInit();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
    }

    public void beforeInit() {
    }

    public void initView() {
    }


    public int getLayoutId() {
        return 1;
    }


    protected boolean needFullScreen() {
        return false;
    }

    protected void addDisposable(Disposable disposable) {
        if (this.compositeDisposable == null) {
            this.compositeDisposable = new CompositeDisposable();
        }
        this.compositeDisposable.add(disposable);
    }

    protected void clearDisposable() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        this.compositeDisposable = null;
    }

    protected void onDestroy() {
        super.onDestroy();
        AppManager.removeActivity(this);
        clearDisposable();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
