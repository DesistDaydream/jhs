package com.baidu.mobads.sdk.api;

import android.app.Application;
import com.baidu.mobads.sdk.internal.al;

/* loaded from: classes.dex */
public class NovelSDKConfig {
    public static void attachBaseContext(Application application, String str, String str2) {
        al.a(application, str, str2);
    }

    public static boolean isInitNovelSDK() {
        return al.f();
    }
}
