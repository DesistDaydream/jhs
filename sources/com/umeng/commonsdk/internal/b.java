package com.umeng.commonsdk.internal;

import android.content.Context;

/* loaded from: classes3.dex */
public class b {
    private static b b;
    private Context a;

    /* renamed from: c */
    private c f7401c;

    private b(Context context) {
        this.a = context;
        this.f7401c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context.getApplicationContext());
            }
            bVar = b;
        }
        return bVar;
    }

    public c a() {
        return this.f7401c;
    }
}
