package ke.co.ipandasoft.newsreader.utils;

import android.widget.Toast;

import ke.co.ipandasoft.newsreader.base.BaseApplication;


public class ToastUtils {
    private static Toast toast = null;

    public static void showShortToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
        }
        toast.show();
    }

    public static void showLongToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_LONG);
        } else {
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(msg);
        }
        toast.show();
    }

    public static void showShortToastCenter(String msg) {
        Toast toast = Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_SHORT);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    public static void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }
}
