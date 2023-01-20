package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class i0 implements n0 {
    public byte[] a;
    public String b;

    /* renamed from: c */
    public String f3540c;

    /* renamed from: d */
    public String f3541d;

    /* renamed from: e */
    public String f3542e;

    /* renamed from: f */
    public List<q> f3543f;

    public i0(byte[] bArr, String str, String str2, String str3, String str4, List<q> list) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
        this.f3540c = str2;
        this.f3542e = str3;
        this.f3541d = str4;
        this.f3543f = list;
    }

    public final b0 a(Map<String, String> map) {
        return a0.a(this.b, this.a, map);
    }

    public final Map<String, String> a() {
        return d1.b(this.f3540c, this.f3542e, this.f3541d);
    }

    public final void b() {
        o0.c().a(new l0(this.f3543f, this.f3540c, this.f3541d, this.f3542e));
    }

    @Override // java.lang.Runnable
    public void run() {
        y.c("hmsSdk", "send data running");
        int b = a(a()).b();
        if (b != 200) {
            b();
            return;
        }
        y.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f3541d, this.f3542e, this.f3540c, Integer.valueOf(b));
    }
}
