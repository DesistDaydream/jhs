package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class z implements v {
    private Context a;
    private Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private Object f9221c;

    /* renamed from: d  reason: collision with root package name */
    private Method f9222d = null;

    /* renamed from: e  reason: collision with root package name */
    private Method f9223e = null;

    /* renamed from: f  reason: collision with root package name */
    private Method f9224f = null;

    /* renamed from: g  reason: collision with root package name */
    private Method f9225g = null;

    public z(Context context) {
        this.a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.f9221c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("miui invoke error", e2);
            return null;
        }
    }

    private void a(Context context) {
        try {
            Class<?> a = jl.a(context, "com.android.id.impl.IdProviderImpl");
            this.b = a;
            this.f9221c = a.newInstance();
            this.f9222d = this.b.getMethod("getUDID", Context.class);
            this.f9223e = this.b.getMethod("getOAID", Context.class);
            this.f9224f = this.b.getMethod("getVAID", Context.class);
            this.f9225g = this.b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("miui load class error", e2);
        }
    }

    @Override // com.xiaomi.push.v
    public boolean a() {
        return (this.b == null || this.f9221c == null) ? false : true;
    }

    @Override // com.xiaomi.push.v
    public String b() {
        return a(this.a, this.f9223e);
    }
}
