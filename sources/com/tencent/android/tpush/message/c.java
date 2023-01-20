package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class c {
    private static String a;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f6153c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f6154d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f6155e = "";

    /* renamed from: f  reason: collision with root package name */
    private Context f6156f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f6157g;

    public c(Context context, Intent intent) {
        this.f6156f = null;
        this.f6157g = null;
        this.f6156f = context.getApplicationContext();
        this.f6157g = intent;
    }

    public boolean a(PushMessageManager pushMessageManager, long j2, long j3, long j4) {
        return true;
    }
}
