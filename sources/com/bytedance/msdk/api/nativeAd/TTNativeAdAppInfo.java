package com.bytedance.msdk.api.nativeAd;

import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class TTNativeAdAppInfo {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f1985c;

    /* renamed from: d  reason: collision with root package name */
    private String f1986d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f1987e;

    /* renamed from: f  reason: collision with root package name */
    private String f1988f;

    /* renamed from: g  reason: collision with root package name */
    private String f1989g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, Object> f1990h;

    public Map<String, Object> getAppInfoExtra() {
        return this.f1990h;
    }

    public String getAppName() {
        return this.a;
    }

    public String getAuthorName() {
        return this.b;
    }

    public long getPackageSizeBytes() {
        return this.f1985c;
    }

    public Map<String, String> getPermissionsMap() {
        return this.f1987e;
    }

    public String getPermissionsUrl() {
        return this.f1986d;
    }

    public String getPrivacyAgreement() {
        return this.f1988f;
    }

    public String getVersionName() {
        return this.f1989g;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.f1990h = map;
    }

    public void setAppName(String str) {
        this.a = str;
    }

    public void setAuthorName(String str) {
        this.b = str;
    }

    public void setPackageSizeBytes(long j2) {
        this.f1985c = j2;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.f1987e = map;
    }

    public void setPermissionsUrl(String str) {
        this.f1986d = str;
    }

    public void setPrivacyAgreement(String str) {
        this.f1988f = str;
    }

    public void setVersionName(String str) {
        this.f1989g = str;
    }
}
