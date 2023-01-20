package com.tencent.android.tpush.stat;

import android.content.Context;
import java.lang.Thread;

/* loaded from: classes3.dex */
public final class a implements Thread.UncaughtExceptionHandler {
    private static com.tencent.android.tpush.stat.b.c a = com.tencent.android.tpush.stat.b.b.b();
    private static volatile a b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f6398c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6399d = false;

    /* renamed from: e  reason: collision with root package name */
    private Context f6400e;

    private a(Context context) {
        this.f6400e = null;
        this.f6400e = context;
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
        return b;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f6399d) {
            com.tencent.android.tpush.stat.b.c cVar = a;
            cVar.f("already handle the uncaugth exception:" + th);
            return;
        }
        this.f6399d = true;
        a.h("catch app crash");
        StatServiceImpl.a(this.f6400e, th);
        if (f6398c != null) {
            a.h("Call the original uncaught exception handler.");
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f6398c;
            if (uncaughtExceptionHandler instanceof a) {
                return;
            }
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public void a() {
        if (f6398c != null) {
            return;
        }
        f6398c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(b);
        com.tencent.android.tpush.stat.b.c cVar = a;
        cVar.h("set up java crash handler:" + b);
    }
}
