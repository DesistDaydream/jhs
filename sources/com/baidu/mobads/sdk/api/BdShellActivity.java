package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.ap;
import com.baidu.mobads.sdk.internal.bi;
import com.baidu.mobads.sdk.internal.bj;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BdShellActivity extends Activity {
    private static boolean canShowWhenLock;
    private static ActionBarColorTheme mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private bj mAdLogger = bj.a();
    private ClassLoader mLoader;
    private IActivityImpl mProxyActivity;

    public static void canLpShowWhenLocked(boolean z) {
        canShowWhenLock = z;
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return mSActionBarColorTheme;
    }

    public static Class<?> getActivityClass() {
        return BdShellActivity.class;
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static void setActionBarColor(int i2, int i3, int i4, int i5) {
        mSActionBarColorTheme = new ActionBarColorTheme(i2, i3, i4, i5);
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchKeyEvent(keyEvent) : false) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onActivityResult(i2, i3, intent);
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Class<?> a;
        super.onCreate(bundle);
        Intent intent = getIntent();
        try {
            ClassLoader a2 = bi.a(this);
            this.mLoader = a2;
            if (intent != null) {
                intent.setExtrasClassLoader(a2);
            }
            String str = "";
            if (intent != null) {
                str = intent.getStringExtra("activityImplName");
                if ("Dialog".equals(intent.getStringExtra("theme"))) {
                    setTheme(R.style.bd_activity_dialog_theme);
                }
            }
            Object obj = null;
            if (!TextUtils.isEmpty(str) && (a = ap.a(str, this.mLoader)) != null) {
                obj = a.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            if (obj != null) {
                this.mProxyActivity = (IActivityImpl) obj;
            }
            if (this.mProxyActivity != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("bar_close_color", mSActionBarColorTheme.closeColor);
                    jSONObject.put("bar_pro_color", mSActionBarColorTheme.progressColor);
                    jSONObject.put("bar_title_color", mSActionBarColorTheme.titleColor);
                    jSONObject.put("bar_bg_color", mSActionBarColorTheme.backgroundColor);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.mProxyActivity.setLpBussParam(jSONObject);
                this.mProxyActivity.setActivity(this);
                if (intent != null) {
                    this.mProxyActivity.onCreate(bundle);
                }
            }
        } catch (Exception e3) {
            bj.a().c(e3);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyDown(i2, keyEvent) : false) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyUp(i2, keyEvent) : false) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(i2, i3);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i2, i3);
        }
    }

    /* loaded from: classes.dex */
    public static class ActionBarColorTheme implements Serializable {
        public int backgroundColor;
        public int closeColor;
        public int progressColor;
        public int titleColor;
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);

        public ActionBarColorTheme(int i2, int i3, int i4, int i5) {
            this.closeColor = i2;
            this.titleColor = i3;
            this.progressColor = i4;
            this.backgroundColor = i5;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return this.backgroundColor == actionBarColorTheme.backgroundColor && this.titleColor == actionBarColorTheme.titleColor && this.closeColor == actionBarColorTheme.closeColor && this.progressColor == actionBarColorTheme.progressColor;
        }

        public int getBackgroundColor() {
            return this.backgroundColor;
        }

        public int getCloseColor() {
            return this.closeColor;
        }

        public int getProgressColor() {
            return this.progressColor;
        }

        public int getTitleColor() {
            return this.titleColor;
        }

        public void setBackgroundColor(int i2) {
            this.backgroundColor = i2;
        }

        public void setCloseColor(int i2) {
            this.closeColor = i2;
        }

        public void setProgressColor(int i2) {
            this.progressColor = i2;
        }

        public void setTitleColor(int i2) {
            this.titleColor = i2;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.closeColor = actionBarColorTheme.closeColor;
            this.titleColor = actionBarColorTheme.titleColor;
            this.progressColor = actionBarColorTheme.progressColor;
            this.backgroundColor = actionBarColorTheme.backgroundColor;
        }
    }
}
