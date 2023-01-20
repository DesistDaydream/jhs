package com.heytap.mcssdk.c;

import com.heytap.msp.push.mode.BaseMode;
import java.util.List;

/* loaded from: classes2.dex */
public class b extends BaseMode {
    private static final String a = "&";
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f3306c;

    /* renamed from: d  reason: collision with root package name */
    private String f3307d;

    /* renamed from: e  reason: collision with root package name */
    private String f3308e;

    /* renamed from: f  reason: collision with root package name */
    private int f3309f;

    /* renamed from: g  reason: collision with root package name */
    private String f3310g;

    /* renamed from: h  reason: collision with root package name */
    private int f3311h = -2;

    /* renamed from: i  reason: collision with root package name */
    private String f3312i;

    public static <T> String a(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(t);
            sb.append("&");
        }
        return sb.toString();
    }

    public String a() {
        return this.b;
    }

    public void a(int i2) {
        this.f3309f = i2;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.f3306c;
    }

    public void b(int i2) {
        this.f3311h = i2;
    }

    public void b(String str) {
        this.f3306c = str;
    }

    public String c() {
        return this.f3307d;
    }

    public void c(String str) {
        this.f3307d = str;
    }

    public String d() {
        return this.f3308e;
    }

    public void d(String str) {
        this.f3308e = str;
    }

    public int e() {
        return this.f3309f;
    }

    public void e(String str) {
        this.f3310g = str;
    }

    public String f() {
        return this.f3310g;
    }

    public void f(String str) {
        this.f3312i = str;
    }

    public int g() {
        return this.f3311h;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4105;
    }

    public String h() {
        return this.f3312i;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.f3307d + "', mSdkVersion='" + this.f3308e + "', mCommand=" + this.f3309f + "', mContent='" + this.f3310g + "', mAppPackage=" + this.f3312i + "', mResponseCode=" + this.f3311h + '}';
    }
}
