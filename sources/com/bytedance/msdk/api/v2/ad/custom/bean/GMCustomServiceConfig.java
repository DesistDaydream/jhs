package com.bytedance.msdk.api.v2.ad.custom.bean;

/* loaded from: classes.dex */
public final class GMCustomServiceConfig {
    private final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2072c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2073d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2074e;

    public GMCustomServiceConfig(String str, String str2, int i2, int i3, String str3) {
        this.a = str;
        this.b = str2;
        this.f2072c = i2;
        this.f2073d = i3;
        this.f2074e = str3;
    }

    public String getADNNetworkName() {
        return this.a;
    }

    public String getADNNetworkSlotId() {
        return this.b;
    }

    public int getAdStyleType() {
        return this.f2072c;
    }

    public String getCustomAdapterJson() {
        return this.f2074e;
    }

    public int getSubAdtype() {
        return this.f2073d;
    }
}
