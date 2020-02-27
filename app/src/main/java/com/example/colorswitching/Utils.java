package com.example.colorswitching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public class Utils {
    private static int sTheme;

    public final static int THEME_GREEN = 0;
    public final static int THEME_BLACK = 1;
    public final static int THEME_BLUE = 2;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_GREEN:
                activity.setTheme(R.style.ThemeGreen);
                break;
            case THEME_BLACK:
                activity.setTheme(R.style.ThemeBlack);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.ThemeBlue);
                break;
        }
    }
}
