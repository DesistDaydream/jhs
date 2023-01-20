package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.bj;

/* loaded from: classes.dex */
public class MobRewardVideoActivity extends Activity {
    private static IActivityImpl mRewardVideo;

    public static void setActivityImp(IActivityImpl iActivityImpl) {
        mRewardVideo = iActivityImpl;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null ? iActivityImpl.onBackPressed() : false) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.setActivity(this);
            mRewardVideo.onCreate(bundle);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
            mRewardVideo = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            if (classLoader != null) {
                bundle.setClassLoader(classLoader);
                Bundle bundle2 = bundle.getBundle("android:viewHierarchyState");
                if (bundle2 != null) {
                    bundle2.setClassLoader(classLoader);
                }
            }
            super.onRestoreInstanceState(bundle);
            IActivityImpl iActivityImpl = mRewardVideo;
            if (iActivityImpl != null) {
                iActivityImpl.onRestoreInstanceState(bundle);
            }
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(i2, i3);
        IActivityImpl iActivityImpl = mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i2, i3);
        }
    }
}
