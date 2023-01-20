package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.vivo.push.util.w;
import com.vivo.push.util.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class c<T> {
    public static final Object a = new Object();
    public List<T> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Context f8105c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f8106d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f8107e;

    public c(Context context) {
        this.f8105c = ContextDelegate.getContext(context);
        w b = w.b();
        b.a(this.f8105c);
        this.f8106d = b.c();
        this.f8107e = b.d();
        c();
    }

    private String b() {
        return y.b(this.f8105c).a(a(), null);
    }

    private void d(String str) {
        y.b(this.f8105c).b(a(), str);
    }

    public abstract String a();

    public abstract List<T> a(String str);

    public abstract String b(String str);

    public final void c() {
        synchronized (a) {
            g.a(a());
            this.b.clear();
            c(b());
        }
    }

    public final byte[] e() {
        byte[] bArr = this.f8106d;
        return (bArr == null || bArr.length <= 0) ? w.b().c() : bArr;
    }

    public final byte[] f() {
        byte[] bArr = this.f8107e;
        return (bArr == null || bArr.length <= 0) ? w.b().d() : bArr;
    }

    public final void d() {
        synchronized (a) {
            this.b.clear();
            d("");
            p.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
        } else if (str.length() > 10000) {
            p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
        } else {
            try {
                p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
                List<T> a2 = a(b(str));
                if (a2 != null) {
                    this.b.addAll(a2);
                }
            } catch (Exception e2) {
                d();
                p.d("CacheSettings", p.a(e2));
            }
        }
    }
}
