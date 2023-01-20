package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.j;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class i {
    private static Context a = null;
    private static long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static String f1224c = "default";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1225d;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.a f1226e;

    /* renamed from: h  reason: collision with root package name */
    private static volatile ConcurrentHashMap<Integer, String> f1229h;

    /* renamed from: j  reason: collision with root package name */
    private static volatile int f1231j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile String f1232k;

    /* renamed from: f  reason: collision with root package name */
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.b f1227f = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.b();

    /* renamed from: g  reason: collision with root package name */
    private static b f1228g = new b();

    /* renamed from: i  reason: collision with root package name */
    private static j f1230i = null;

    public static long a() {
        return b;
    }

    public static void a(Context context, e eVar) {
        b = System.currentTimeMillis();
        a = context;
        f1226e = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.a(context, eVar);
    }

    public static Context b() {
        return a;
    }

    public static String c() {
        return f1224c;
    }

    public static b d() {
        return f1228g;
    }

    public static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.a e() {
        return f1226e;
    }

    public static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.b f() {
        return f1227f;
    }

    public static int g() {
        return f1231j;
    }

    public static String h() {
        return f1232k;
    }

    public static ConcurrentHashMap<Integer, String> i() {
        return f1229h;
    }

    public static j j() {
        if (f1230i == null) {
            synchronized (i.class) {
                f1230i = new j(a);
            }
        }
        return f1230i;
    }

    public static boolean k() {
        return f1225d;
    }
}
