package com.meizu.cloud.pushsdk.notification;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class PushNotificationBuilder {
    private String appLabel;
    private Bitmap appLargeIcon;
    private String clickPackageName;
    private Context context;
    private int mLargeIcon;
    private int mNotificationDefaults;
    private int mNotificationFlags;
    private String mNotificationSound;
    private int mStatusBarIcon;
    private long[] mVibratePattern;

    public PushNotificationBuilder() {
    }

    public PushNotificationBuilder(Context context) {
        this.context = context;
    }

    public String getAppLabel() {
        return this.appLabel;
    }

    public Bitmap getAppLargeIcon() {
        return this.appLargeIcon;
    }

    public String getClickPackageName() {
        return this.clickPackageName;
    }

    public Context getContext() {
        return this.context;
    }

    public int getLargeIcon() {
        return this.mLargeIcon;
    }

    public int getNotificationDefaults() {
        return this.mNotificationDefaults;
    }

    public int getNotificationFlags() {
        return this.mNotificationFlags;
    }

    public String getNotificationSound() {
        return this.mNotificationSound;
    }

    public int getStatusBarIcon() {
        return this.mStatusBarIcon;
    }

    public long[] getVibratePattern() {
        return this.mVibratePattern;
    }

    public void setAppLabel(String str) {
        this.appLabel = str;
    }

    public void setAppLargeIcon(Bitmap bitmap) {
        this.appLargeIcon = bitmap;
    }

    public void setClickPackageName(String str) {
        this.clickPackageName = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setLargeIcon(int i2) {
        this.mLargeIcon = i2;
    }

    public void setNotificationDefaults(int i2) {
        this.mNotificationDefaults = i2;
    }

    public void setNotificationFlags(int i2) {
        this.mNotificationFlags = i2;
    }

    public void setNotificationSound(String str) {
        this.mNotificationSound = str;
    }

    public void setStatusBarIcon(int i2) {
        this.mStatusBarIcon = i2;
    }

    public void setVibratePattern(long[] jArr) {
        this.mVibratePattern = jArr;
    }
}
