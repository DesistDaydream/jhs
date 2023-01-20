package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_int108;

import android.os.SystemClock;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.m;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.f;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: e  reason: collision with root package name */
    private static a f1182e;
    private Thread.UncaughtExceptionHandler a;

    /* renamed from: c  reason: collision with root package name */
    private b f1183c;
    private HashSet<Thread.UncaughtExceptionHandler> b = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private long f1184d = -1;

    private a() {
        b();
    }

    public static a a() {
        if (f1182e == null) {
            f1182e = new a();
        }
        return f1182e;
    }

    private void a(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.a.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    private void b() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.a == null) {
                this.a = defaultUncaughtExceptionHandler;
            } else {
                this.b.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    private void b(Thread thread, Throwable th) {
        List<f> c2 = i.d().c();
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.JAVA;
        for (f fVar : c2) {
            try {
                fVar.a(cVar, m.a(th), thread);
            } catch (Throwable th2) {
                j.b(th2);
            }
        }
    }

    private boolean c(Thread thread, Throwable th) {
        g b = i.d().b();
        if (b != null) {
            try {
                if (!b.a(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public void a(b bVar) {
        this.f1183c = bVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        b bVar;
        if (SystemClock.uptimeMillis() - this.f1184d < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f1184d = SystemClock.uptimeMillis();
            boolean c2 = c(thread, th);
            if (c2) {
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.JAVA;
                b(thread, th);
                if (c2 && (bVar = this.f1183c) != null && bVar.a(th)) {
                    this.f1183c.a(currentTimeMillis, thread, th);
                    Log.i("crash_dispatcher", "end dispose " + th);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
