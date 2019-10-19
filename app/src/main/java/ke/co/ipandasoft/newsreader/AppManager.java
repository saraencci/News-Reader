package ke.co.ipandasoft.newsreader;

import android.app.Activity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AppManager {
    private static final Stack<Activity> activityStack = new Stack();

    public static void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    public static Activity currentActivity() {
        if (activityStack.isEmpty()) {
            return null;
        }
        return activityStack.lastElement();
    }

    public static Activity getActivity(Class<?> clazz) {
        if (!activityStack.isEmpty()) {
            Iterator it = activityStack.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                if (activity.getClass().equals(clazz)) {
                    return activity;
                }
            }
        }
        return null;
    }

    public static void removeActivity(Activity activity) {
        if (!activityStack.isEmpty() && activity != null) {
            activityStack.remove(activity);
        }
    }

    public static void finishActivity(Class<?> cls) {
        if (!activityStack.isEmpty()) {
            Activity activity;
            List<Activity> removed = new LinkedList();
            Iterator it = activityStack.iterator();
            while (it.hasNext()) {
                activity = (Activity) it.next();
                if (activity.getClass().equals(cls)) {
                    removed.add(activity);
                    activity.finish();
                }
            }
            for (Activity activity2 : removed) {
                activityStack.remove(activity2);
            }
            removed.clear();
        }
    }

    public static void finishAllActivity() {
        if (!activityStack.isEmpty()) {
            for (int i = activityStack.size() - 1; i >= 0; i--) {
                if (activityStack.get(i) != null) {
                    activityStack.get(i).finish();
                }
            }
            activityStack.clear();
        }
    }

    public static boolean containActivity(Class<?> clazz) {
        if (activityStack.isEmpty()) {
            return false;
        }
        Iterator it = activityStack.iterator();
        while (it.hasNext()) {
            if (((Activity) it.next()).getClass().equals(clazz)) {
                return true;
            }
        }
        return false;
    }
}
