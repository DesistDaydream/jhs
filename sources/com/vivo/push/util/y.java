package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class y implements d {
    private static final HashMap<String, Integer> a = new HashMap<>();
    private static final HashMap<String, Long> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, String> f8175c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static y f8176d;

    /* renamed from: e  reason: collision with root package name */
    private Context f8177e;

    /* renamed from: f  reason: collision with root package name */
    private d f8178f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8179g;

    private y(Context context) {
        this.f8179g = false;
        this.f8177e = context;
        this.f8179g = a(context);
        p.d("SystemCache", "init status is " + this.f8179g + ";  curCache is " + this.f8178f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f8176d == null) {
                f8176d = new y(context.getApplicationContext());
            }
            yVar = f8176d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f8177e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        d dVar;
        f8175c.put(str, str2);
        if (!this.f8179g || (dVar = this.f8178f) == null) {
            return;
        }
        dVar.b(str, str2);
    }

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        v vVar = new v();
        this.f8178f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            x xVar = new x();
            this.f8178f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f8178f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        d dVar;
        String str3 = f8175c.get(str);
        return (str3 != null || (dVar = this.f8178f) == null) ? str3 : dVar.a(str, str2);
    }
}
