package com.tencent.qcloud.tuicore;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.util.TUIBuild;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TUIThemeManager {
    private static final String SP_KEY_LANGUAGE = "language";
    private static final String SP_KEY_THEME = "theme";
    private static final String SP_THEME_AND_LANGUAGE_NAME = "TUIThemeAndLanguage";
    private static final String TAG = "TUIThemeManager";
    public static final int THEME_LIGHT = 0;
    public static final int THEME_LIVELY = 1;
    public static final int THEME_SERIOUS = 2;
    private String currentLanguage;
    private int currentTheme;
    private Locale defaultLocale;
    private boolean isInit;
    private final List<Integer> lightThemeResIds;
    private final List<Integer> livelyThemeResIds;
    private final List<Integer> seriousThemeResIds;

    /* loaded from: classes3.dex */
    public static class ThemeAndLanguageCallback implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            TUIThemeManager.getInstance().applyTheme(activity);
            TUIThemeManager.getInstance().applyLanguage(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    /* loaded from: classes3.dex */
    public @interface ThemeIds {
    }

    /* loaded from: classes3.dex */
    public static final class ThemeManagerHolder {
        private static final TUIThemeManager instance = new TUIThemeManager();

        private ThemeManagerHolder() {
        }
    }

    public static void addLightTheme(int i2) {
        if (i2 == 0 || getInstance().lightThemeResIds.contains(Integer.valueOf(i2))) {
            return;
        }
        getInstance().lightThemeResIds.add(Integer.valueOf(i2));
    }

    public static void addLivelyTheme(int i2) {
        if (i2 == 0 || getInstance().livelyThemeResIds.contains(Integer.valueOf(i2))) {
            return;
        }
        getInstance().livelyThemeResIds.add(Integer.valueOf(i2));
    }

    public static void addSeriousTheme(int i2) {
        if (i2 == 0 || getInstance().seriousThemeResIds.contains(Integer.valueOf(i2))) {
            return;
        }
        getInstance().seriousThemeResIds.add(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTheme(Context context) {
        if (context == null) {
            return;
        }
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            int i2 = this.currentTheme;
            if (i2 == 1) {
                context.setTheme(R.style.TUIBaseLivelyTheme);
            } else if (i2 == 2) {
                context.setTheme(R.style.TUIBaseSeriousTheme);
            } else {
                context.setTheme(R.style.TUIBaseLightTheme);
            }
            theme = context.getTheme();
        }
        mergeTheme(theme);
    }

    public static int getAttrResId(Context context, int i2) {
        if (context == null || i2 == 0) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public static TUIThemeManager getInstance() {
        return ThemeManagerHolder.instance;
    }

    private Locale getLocale(Context context) {
        if (TUIBuild.getVersionInt() < 24) {
            return context.getResources().getConfiguration().locale;
        }
        return context.getResources().getConfiguration().getLocales().get(0);
    }

    private String getProcessName(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private void mergeTheme(Resources.Theme theme) {
        if (theme == null) {
            return;
        }
        List<Integer> list = this.lightThemeResIds;
        int i2 = this.currentTheme;
        if (i2 == 1) {
            list = this.livelyThemeResIds;
        } else if (i2 == 2) {
            list = this.seriousThemeResIds;
        }
        for (Integer num : list) {
            theme.applyStyle(num.intValue(), true);
        }
    }

    public static void setTheme(Context context) {
        getInstance().setThemeInternal(context);
    }

    private void setThemeInternal(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (!this.isInit) {
            this.isInit = true;
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new ThemeAndLanguageCallback());
                new WebView(applicationContext).destroy();
            }
            Locale locale = getLocale(applicationContext);
            SharedPreferences sharedPreferences = context.getSharedPreferences(SP_THEME_AND_LANGUAGE_NAME, 0);
            this.currentLanguage = sharedPreferences.getString("language", locale.getLanguage());
            this.currentTheme = sharedPreferences.getInt(SP_KEY_THEME, 0);
            applyLanguage(applicationContext);
        }
        applyTheme(applicationContext);
    }

    public void applyLanguage(Context context) {
        if (context == null) {
            return;
        }
        Locale locale = getLocale(context);
        if ("en".equals(this.currentLanguage)) {
            locale = Locale.ENGLISH;
        } else if ("zh".equals(this.currentLanguage)) {
            locale = Locale.CHINA;
        } else {
            Locale locale2 = this.defaultLocale;
            if (locale2 != null) {
                locale = locale2;
            }
        }
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (TUIBuild.getVersionInt() >= 17) {
            configuration.setLocale(locale);
        }
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT >= 25) {
            context.createConfigurationContext(configuration).getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }

    public void changeLanguage(Context context, String str) {
        if (context == null || TextUtils.equals(str, this.currentLanguage)) {
            return;
        }
        this.currentLanguage = str;
        SharedPreferences.Editor edit = context.getSharedPreferences(SP_THEME_AND_LANGUAGE_NAME, 0).edit();
        edit.putString("language", str);
        edit.commit();
        applyLanguage(context.getApplicationContext());
        applyLanguage(context);
    }

    public void changeTheme(Context context, @ThemeIds int i2) {
        if (context == null || i2 == this.currentTheme) {
            return;
        }
        this.currentTheme = i2;
        SharedPreferences.Editor edit = context.getSharedPreferences(SP_THEME_AND_LANGUAGE_NAME, 0).edit();
        edit.putInt(SP_KEY_THEME, i2);
        edit.commit();
        applyTheme(context.getApplicationContext());
        applyTheme(context);
    }

    public String getCurrentLanguage() {
        return this.currentLanguage;
    }

    public int getCurrentTheme() {
        return this.currentTheme;
    }

    public void setDefaultLocale(Locale locale) {
        this.defaultLocale = locale;
    }

    private TUIThemeManager() {
        this.isInit = false;
        this.lightThemeResIds = new ArrayList();
        this.livelyThemeResIds = new ArrayList();
        this.seriousThemeResIds = new ArrayList();
        this.currentTheme = 0;
        this.currentLanguage = "";
        this.defaultLocale = null;
    }
}
