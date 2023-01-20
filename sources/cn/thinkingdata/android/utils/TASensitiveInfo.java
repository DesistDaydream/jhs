package cn.thinkingdata.android.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;

/* loaded from: classes.dex */
public class TASensitiveInfo {
    @SuppressLint({"HardwareIds"})
    public String getAndroidID(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
