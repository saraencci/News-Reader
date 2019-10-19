package ke.co.ipandasoft.newsreader.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ke.co.ipandasoft.newsreader.R;
import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

import static android.content.Context.ACTIVITY_SERVICE;



public class SimpleAppUtils {


    public static String getTxt4Et(EditText editText) {
        if (editText == null) {
            return "";
        }
        return editText.getText().toString();
    }


    public static void setTxt(TextView tv, CharSequence sequence) {
        if (tv != null && !TextUtils.isEmpty(sequence)) {
            tv.setText(sequence);
        }
    }

    public static boolean isValidPwd(String pwd) {
        return !TextUtils.isEmpty(pwd) && pwd.length() >= 6 && pwd.length() <= 20;
    }

    public static String getData4Result(Intent intent, String key) {
        if (intent == null) {
            return "";
        }
        String result = intent.getStringExtra(key);
        return TextUtils.isEmpty(result) ? "" : result;
    }

    public static void launchAppDetail(Context context, String marketPkg) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.football.soccerbook"));
            if (!TextUtils.isEmpty(marketPkg)) {
                //intent.setPackage(marketPkg);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {

            //PageJump.startActivity(context, FeedBackActivity.class);
        }
    }

    public static final void ShareApp(Activity mainActivity) {

        String str = mainActivity.getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);


        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "THIS APP HAS INFO ABOUT ALL JACKPOTS:https://play.google.com/store/apps/details?id=" + str);
        sendIntent.setType("text/plain");
        mainActivity.startActivity(Intent.createChooser(sendIntent, "SHARE JACKPOTS INFO WITH FRIENDS"));
    }

    public static void openGooglePlayIntent(Activity activity) {
        String str = activity.getPackageName();
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + str)));
        }
    }

    public static void MakeToast(Activity activity) {
        Toast.makeText(activity, "No network connectivity", Toast.LENGTH_SHORT).show();
    }


    public static final void sendEmail(Context activity) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setType("plain/text");
        emailIntent.setData(Uri.parse("mailto: futaabets254@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App Report (" + activity.getPackageName() + ")");
        activity.startActivity(Intent.createChooser(emailIntent, "Send mail to Developers..."));

    }

    public static final void showNetworkToast(Activity activity){

       PrettyDialog prettyDialog= new PrettyDialog(activity);
                prettyDialog.setTitle("Ooops!!!!");
                prettyDialog.setMessage("PLEASE CHECK NETWORK CONNECTIVITY AND RETRY AGAIN!");
                //prettyDialog.setIcon(R.drawable.personal_icon_photo_nor);
                prettyDialog.setIconTint(R.color.colorPrimary);
                prettyDialog.setIconCallback(new PrettyDialogCallback() {
                    @Override
                    public void onClick() {
                        return;
                    }
                });
                prettyDialog.addButton("Okay", R.color.white, R.color.colorPrimary,
                        new PrettyDialogCallback() {
                            @Override
                            public void onClick() {
                                prettyDialog.dismiss();
                                activity.finish();

                            }
                        });
                prettyDialog.show();

    }


    public static boolean IsTelegramInstalled(Activity activity, String telegramPackageName) {

            PackageManager pm = activity.getPackageManager();
            try
            {
                pm.getPackageInfo(telegramPackageName, PackageManager.GET_ACTIVITIES);
                return true;
            }
            catch (PackageManager.NameNotFoundException e)
            {
                return false;
            }

    }

    public static final void showLogOutDialog(Activity activity){

        PrettyDialog prettyDialog=new PrettyDialog(activity);
        prettyDialog.setTitle("ARE YOU SURE");
        prettyDialog.setCanceledOnTouchOutside(false);
        prettyDialog.setMessage("YOU WILL HAVE TO LOGIN AGAIN TO USE APP");
        //prettyDialog.setIcon(R.drawable.ic_close_white);
        prettyDialog.setIconTint(R.color.colorPrimary);
        prettyDialog.setIconCallback(new PrettyDialogCallback() {
            @Override
            public void onClick() {
                return;
            }
        });
        prettyDialog.addButton("Okay", R.color.white, R.color.colorPrimary,
                new PrettyDialogCallback() {
                    @Override
                    public void onClick() {
                        prettyDialog.dismiss();
                        try {
                            if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT) {
                                ((ActivityManager) activity.getApplicationContext().getSystemService(ACTIVITY_SERVICE))
                                        .clearApplicationUserData();
                            } else {
                                String packageName = activity.getApplicationContext().getPackageName();
                                Runtime runtime = Runtime.getRuntime();
                                runtime.exec("pm clear " + packageName);

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        prettyDialog.addButton("Cancel", R.color.white, R.color.colorPrimary, new PrettyDialogCallback() {
            @Override
            public void onClick() {
                prettyDialog.dismiss();
            }
        });
        prettyDialog.show();

    }

}
