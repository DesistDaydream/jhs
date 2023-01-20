package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;

/* loaded from: classes2.dex */
public class SettingUtil {
    private static final String TAG = "SettingUtil";

    public static int getSecureInt(ContentResolver contentResolver, String str, int i2) {
        try {
            return Settings.Secure.getInt(contentResolver, str, i2);
        } catch (RuntimeException e2) {
            Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", e2);
            return i2;
        }
    }

    public static int getSystemInt(ContentResolver contentResolver, String str, int i2) {
        try {
            return Settings.System.getInt(contentResolver, str, i2);
        } catch (RuntimeException e2) {
            Logger.e(TAG, "Settings System getInt throwFromSystemServer:", e2);
            return i2;
        }
    }
}
