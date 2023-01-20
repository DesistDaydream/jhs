package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.c;

/* loaded from: classes.dex */
public class al {
    private static final String a = "PluginLoader";
    private static ClassLoader b;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public static void a(double d2, ak.b bVar, a aVar) {
        q qVar = (q) c.a().a(c.a.a).a();
        if (qVar != null) {
            qVar.startLoadRemotePhp(d2, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static void b(int i2) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.b(i2);
        }
    }

    public static Activity c() {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            return rVar.c();
        }
        return null;
    }

    public static boolean d() {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            return rVar.d();
        }
        return false;
    }

    public static boolean e() {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            return rVar.e();
        }
        return false;
    }

    public static boolean f() {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            return rVar.f();
        }
        return false;
    }

    public static void g() {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.g();
        }
    }

    public static void h() {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a();
        }
    }

    public static void b() {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.b();
        }
    }

    public static boolean a() {
        return cc.f1561d.booleanValue();
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        q qVar;
        if (a()) {
            if (b == null && (qVar = (q) c.a().a(c.a.a).a()) != null) {
                b = qVar.getClassLoaderFromJar(str, str2, str3, classLoader);
            }
            return b;
        }
        return classLoader;
    }

    public static void b(int i2, int i3) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a(i2, i3);
        }
    }

    public static void a(Context context, String str, String str2) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a(context, str, str2);
        }
    }

    public static void a(s sVar) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a(sVar);
        }
    }

    public static void a(int i2) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a(i2);
        }
    }

    public static void a(int i2, boolean z) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a(i2, z);
        }
    }

    public static View a(Context context) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            return rVar.a(context);
        }
        return null;
    }

    public static void a(Context context, String str) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a(context, str);
        }
    }

    public static void a(boolean z) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a(z);
        }
    }

    public static void a(int i2, int i3) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.b(i2, i3);
        }
    }

    public static void a(boolean z, int i2, int i3, int i4) {
        r rVar = (r) c.a().a(c.a.b).a();
        if (rVar != null) {
            rVar.a(z, i2, i3, i4);
        }
    }
}
