package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class b {
    private static b a;
    private ScheduledExecutorService b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f4934c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4935d;

    /* renamed from: e  reason: collision with root package name */
    private final com.meizu.cloud.pushsdk.platform.b.b f4936e;

    /* renamed from: f  reason: collision with root package name */
    private final g f4937f;

    /* renamed from: g  reason: collision with root package name */
    private final f f4938g;

    /* renamed from: h  reason: collision with root package name */
    private final e f4939h;

    /* renamed from: i  reason: collision with root package name */
    private final d f4940i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f4941j;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        this.f4934c = applicationContext;
        a aVar = new a(applicationContext);
        this.f4935d = aVar;
        if (z) {
            this.b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.d.b.a.b.a();
        }
        this.f4941j = z2;
        this.f4936e = new com.meizu.cloud.pushsdk.platform.b.b(applicationContext, aVar, this.b, z2);
        this.f4937f = new g(applicationContext, aVar, this.b, z2);
        this.f4938g = new f(applicationContext, aVar, this.b, z2);
        this.f4939h = new e(applicationContext, aVar, this.b, z2);
        this.f4940i = new d(applicationContext, aVar, this.b, z2);
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context, true);
                }
            }
        }
        return a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f4935d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f4936e.a(z);
        this.f4937f.a(z);
        this.f4938g.a(z);
        this.f4940i.a(z);
        this.f4939h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f4934c, this.b, this.f4941j);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f4934c, this.b, this.f4941j);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f4936e.b(str);
        this.f4936e.c(str2);
        this.f4936e.d(str3);
        return this.f4936e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f4938g.b(str);
        this.f4938g.c(str2);
        this.f4938g.d(str3);
        this.f4938g.a(str4);
        this.f4938g.a(2);
        return this.f4938g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f4938g.b(str);
        this.f4938g.c(str2);
        this.f4938g.d(str3);
        this.f4938g.a(str4);
        this.f4938g.a(i2);
        this.f4938g.b(z);
        return this.f4938g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f4939h.b(str);
        this.f4939h.c(str2);
        this.f4939h.d(str3);
        this.f4939h.e(str4);
        this.f4939h.a(0);
        this.f4939h.a(str5);
        return this.f4939h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f4938g.b(str);
        this.f4938g.c(str2);
        this.f4938g.d(str3);
        this.f4938g.a(str4);
        this.f4938g.a(3);
        this.f4938g.b(z);
        return this.f4938g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f4934c, this.b, this.f4941j);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f4937f.b(str);
        this.f4937f.c(str2);
        this.f4937f.d(str3);
        return this.f4937f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f4939h.b(str);
        this.f4939h.c(str2);
        this.f4939h.d(str3);
        this.f4939h.e(str4);
        this.f4939h.a(2);
        return this.f4939h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f4939h.b(str);
        this.f4939h.c(str2);
        this.f4939h.d(str3);
        this.f4939h.e(str4);
        this.f4939h.a(1);
        this.f4939h.a(str5);
        return this.f4939h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f4939h.b(str);
        this.f4939h.c(str2);
        this.f4939h.d(str3);
        this.f4939h.e(str4);
        this.f4939h.a(3);
        return this.f4939h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f4940i.b(str);
        this.f4940i.c(str2);
        this.f4940i.d(str3);
        this.f4940i.e(str4);
        this.f4940i.a(0);
        this.f4940i.a(str5);
        return this.f4940i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f4940i.b(str);
        this.f4940i.c(str2);
        this.f4940i.d(str3);
        this.f4940i.e(str4);
        this.f4940i.a(2);
        return this.f4940i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f4940i.b(str);
        this.f4940i.c(str2);
        this.f4940i.d(str3);
        this.f4940i.e(str4);
        this.f4940i.a(1);
        this.f4940i.a(str5);
        return this.f4940i.m();
    }
}
