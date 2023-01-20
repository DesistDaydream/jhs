package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class ce extends h {
    public final /* synthetic */ cd b;

    public ce(cd cdVar) {
        this.b = cdVar;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    public Object i() {
        String a;
        String a2;
        Context context;
        String a3;
        try {
            a = this.b.a("key_crash_trace");
            a2 = this.b.a("key_crash_ad");
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            ca a4 = ca.a();
            context = this.b.f1574h;
            a4.a(context);
            a3 = this.b.a("key_crash_source");
            a4.a(a3, a, a2);
            this.b.g();
            return null;
        } catch (Exception e2) {
            bj.a().a(e2);
            return null;
        }
    }
}
