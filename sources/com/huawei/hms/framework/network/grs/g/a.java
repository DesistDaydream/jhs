package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class a {
    public d a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final c f3478c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3479d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f3480e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3481f;

    /* renamed from: g  reason: collision with root package name */
    private final GrsBaseInfo f3482g;

    /* renamed from: h  reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.c f3483h;

    /* renamed from: com.huawei.hms.framework.network.grs.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0096a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public a(String str, int i2, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.b = str;
        this.f3478c = cVar;
        this.f3479d = i2;
        this.f3480e = context;
        this.f3481f = str2;
        this.f3482g = grsBaseInfo;
        this.f3483h = cVar2;
    }

    private String a(String str) {
        return Uri.parse(str).getPath();
    }

    private EnumC0096a h() {
        if (this.b.isEmpty()) {
            return EnumC0096a.GRSDEFAULT;
        }
        String a = a(this.b);
        return a.contains("1.0") ? EnumC0096a.GRSGET : a.contains("2.0") ? EnumC0096a.GRSPOST : EnumC0096a.GRSDEFAULT;
    }

    public Context a() {
        return this.f3480e;
    }

    public c b() {
        return this.f3478c;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.f3479d;
    }

    public String e() {
        return this.f3481f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.f3483h;
    }

    public Callable<d> g() {
        if (EnumC0096a.GRSDEFAULT.equals(h())) {
            return null;
        }
        return EnumC0096a.GRSGET.equals(h()) ? new f(this.b, this.f3479d, this.f3478c, this.f3480e, this.f3481f, this.f3482g) : new g(this.b, this.f3479d, this.f3478c, this.f3480e, this.f3481f, this.f3482g, this.f3483h);
    }
}
