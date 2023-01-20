package com.bytedance.msdk.api;

/* loaded from: classes.dex */
public class AdLoadInfo {
    public static final String AD_LOADED = "广告加载成功";
    public static final String AD_LOADING = "广告请求中";
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f1880c;

    /* renamed from: d  reason: collision with root package name */
    private String f1881d;

    /* renamed from: e  reason: collision with root package name */
    private int f1882e;

    /* renamed from: f  reason: collision with root package name */
    private String f1883f;

    public String getAdType() {
        return this.f1881d;
    }

    public String getAdnName() {
        return this.b;
    }

    public String getCustomAdnName() {
        return this.f1880c;
    }

    public int getErrCode() {
        return this.f1882e;
    }

    public String getErrMsg() {
        return this.f1883f;
    }

    public String getMediationRit() {
        return this.a;
    }

    public AdLoadInfo setAdType(String str) {
        this.f1881d = str;
        return this;
    }

    public AdLoadInfo setAdnName(String str) {
        this.b = str;
        return this;
    }

    public AdLoadInfo setCustomAdnName(String str) {
        this.f1880c = str;
        return this;
    }

    public AdLoadInfo setErrCode(int i2) {
        this.f1882e = i2;
        return this;
    }

    public AdLoadInfo setErrMsg(String str) {
        this.f1883f = str;
        return this;
    }

    public AdLoadInfo setMediationRit(String str) {
        this.a = str;
        return this;
    }

    public String toString() {
        return "{mediationRit='" + this.a + "', adnName='" + this.b + "', customAdnName='" + this.f1880c + "', adType='" + this.f1881d + "', errCode=" + this.f1882e + ", errMsg=" + this.f1883f + '}';
    }
}
