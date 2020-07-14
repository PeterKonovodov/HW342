package com.example.hw342;

import android.app.Activity;

public class Utils {
    public final static int THEME_MARGIN_MIDDLE = 1;
    public final static int THEME_MARGIN_SMALL = 2;
    public final static int THEME_DEFAULT = 0;
    private static int sTheme = THEME_DEFAULT;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(final Activity activity, int theme) {
        sTheme = theme;
        activity.recreate();
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(final Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.MarginLargeTheme);
                break;
            case THEME_MARGIN_MIDDLE:
                activity.setTheme(R.style.MarginMiddleTheme);
                break;
            case THEME_MARGIN_SMALL:
                activity.setTheme(R.style.MarginSmallTheme);
                break;
        }
    }
}