package com.huawei.secure.android.common.util;

/* loaded from: classes2.dex */
public class SecurityCommonException extends Exception {

    /* renamed from: c  reason: collision with root package name */
    private static final long f3718c = 1;
    private String a;
    private String b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.b;
    }

    public String getRetCd() {
        return this.a;
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
