package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IActivityImpl {
    boolean dispatchKeyEvent(KeyEvent keyEvent);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void onActivityResult(int i2, int i3, Intent intent);

    void onAttachedToWindow();

    boolean onBackPressed();

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onDetachedFromWindow();

    boolean onKeyDown(int i2, KeyEvent keyEvent);

    boolean onKeyUp(int i2, KeyEvent keyEvent);

    void onNewIntent(Intent intent);

    void onPause();

    void onRestoreInstanceState(Bundle bundle);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    boolean onTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    void overridePendingTransition(int i2, int i3);

    void setActivity(Activity activity);

    void setLpBussParam(JSONObject jSONObject);
}
