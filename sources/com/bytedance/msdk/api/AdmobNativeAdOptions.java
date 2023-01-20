package com.bytedance.msdk.api;

/* loaded from: classes.dex */
public class AdmobNativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    private int a = 1;
    private boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1899c = true;

    public int getAdChoicesPlacement() {
        return this.a;
    }

    public boolean isRequestMultipleImages() {
        return this.f1899c;
    }

    public boolean isReturnUrlsForImageAssets() {
        return this.b;
    }

    public AdmobNativeAdOptions setAdChoicesPlacement(int i2) {
        this.a = i2;
        return this;
    }

    public AdmobNativeAdOptions setRequestMultipleImages(boolean z) {
        this.f1899c = z;
        return this;
    }

    public AdmobNativeAdOptions setReturnUrlsForImageAssets(boolean z) {
        this.b = z;
        return this;
    }
}
