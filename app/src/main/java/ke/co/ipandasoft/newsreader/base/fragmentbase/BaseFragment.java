package ke.co.ipandasoft.newsreader.base.fragmentbase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ke.co.ipandasoft.newsreader.base.InitBase;
import ke.co.ipandasoft.newsreader.base.LayoutRes;


public abstract class BaseFragment extends Fragment implements LayoutRes, InitBase {
    private final String isFragmentHide = "STATE_SAVE_IS_HIDDEN";
    protected boolean isCreated = false;
    protected View root;
    CompositeDisposable compositeDisposable;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        beforeInit();
        init(inflater, container);
        return this.root;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void init(LayoutInflater inflater, @Nullable ViewGroup container) {
        if (this.root == null) {
            this.root = inflater.inflate(getLayoutId(), null);
            ButterKnife.bind(this, this.root);
            return;
        }
        ViewGroup parent = (ViewGroup) this.root.getParent();
        if (parent != null) {
            parent.removeView(this.root);
        }
    }

    public void beforeInit() {
    }

    public void initView() {
    }


    public CharSequence getFragmentTitle() {
        return null;
    }

    protected void addDisposable(Disposable disposable) {
        if (this.compositeDisposable == null) {
            this.compositeDisposable = new CompositeDisposable();
        }
        this.compositeDisposable.add(disposable);
    }

    protected void clearDispoable() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        this.compositeDisposable = null;
    }

    public void onResume() {
        super.onResume();

    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        clearDispoable();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("STATE_SAVE_IS_HIDDEN", isHidden());
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArgumentsData();
        this.isCreated = true;
        if (savedInstanceState != null) {
            boolean isHidden = savedInstanceState.getBoolean("STATE_SAVE_IS_HIDDEN");
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            if (isHidden) {
                transaction.hide(this);
            } else {
                transaction.show(this);
            }
            transaction.commit();
        }
    }

    public void getArgumentsData() {
    }

}
