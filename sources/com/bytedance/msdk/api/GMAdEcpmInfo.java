package com.bytedance.msdk.api;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class GMAdEcpmInfo {
    private int a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f1942c;

    /* renamed from: d  reason: collision with root package name */
    private String f1943d;

    /* renamed from: e  reason: collision with root package name */
    private String f1944e;

    /* renamed from: f  reason: collision with root package name */
    private String f1945f;

    /* renamed from: g  reason: collision with root package name */
    private int f1946g;

    /* renamed from: h  reason: collision with root package name */
    private String f1947h;

    /* renamed from: i  reason: collision with root package name */
    private String f1948i;

    @Deprecated
    public int getAdNetworkPlatformId() {
        return this.a;
    }

    public String getAdNetworkPlatformName() {
        return this.b;
    }

    public String getAdNetworkRitId() {
        return this.f1943d;
    }

    public String getAdnName() {
        return TextUtils.isEmpty(this.f1942c) ? this.b : this.f1942c;
    }

    public String getCustomAdNetworkPlatformName() {
        return this.f1942c;
    }

    public String getErrorMsg() {
        return this.f1947h;
    }

    public String getLevelTag() {
        return this.f1944e;
    }

    public String getPreEcpm() {
        return this.f1945f;
    }

    public int getReqBiddingType() {
        return this.f1946g;
    }

    public String getRequestId() {
        return this.f1948i;
    }

    public void setAdNetworkPlatformId(int i2) {
        this.a = i2;
    }

    public void setAdNetworkPlatformName(String str) {
        this.b = str;
    }

    public void setAdNetworkRitId(String str) {
        this.f1943d = str;
    }

    public void setCustomAdNetworkPlatformName(String str) {
        this.f1942c = str;
    }

    public void setErrorMsg(String str) {
        this.f1947h = str;
    }

    public void setLevelTag(String str) {
        this.f1944e = str;
    }

    public void setPreEcpm(String str) {
        this.f1945f = str;
    }

    public void setReqBiddingType(int i2) {
        this.f1946g = i2;
    }

    public void setRequestId(String str) {
        this.f1948i = str;
    }

    public String toString() {
        return "{mSdkNum='" + this.a + "', mSlotId='" + this.f1943d + "', mLevelTag='" + this.f1944e + "', mEcpm=" + this.f1945f + ", mReqBiddingType=" + this.f1946g + "', mRequestId=" + this.f1948i + '}';
    }
}
