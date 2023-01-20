package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

/* loaded from: classes2.dex */
public interface IBridgeActivityDelegate {
    int getRequestCode();

    void onBridgeActivityCreate(Activity activity);

    void onBridgeActivityDestroy();

    boolean onBridgeActivityResult(int i2, int i3, Intent intent);

    void onBridgeConfigurationChanged();

    void onKeyUp(int i2, KeyEvent keyEvent);
}
