package e.b.a.p.k.y;

import android.util.Log;
import e.b.a.m.a;
import e.b.a.p.k.y.a;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: f  reason: collision with root package name */
    private static final String f9640f = "DiskLruCacheWrapper";

    /* renamed from: g  reason: collision with root package name */
    private static final int f9641g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f9642h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static e f9643i;
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9644c;

    /* renamed from: e  reason: collision with root package name */
    private e.b.a.m.a f9646e;

    /* renamed from: d  reason: collision with root package name */
    private final c f9645d = new c();
    private final m a = new m();

    @Deprecated
    public e(File file, long j2) {
        this.b = file;
        this.f9644c = j2;
    }

    public static a c(File file, long j2) {
        return new e(file, j2);
    }

    @Deprecated
    public static synchronized a d(File file, long j2) {
        e eVar;
        synchronized (e.class) {
            if (f9643i == null) {
                f9643i = new e(file, j2);
            }
            eVar = f9643i;
        }
        return eVar;
    }

    private synchronized e.b.a.m.a e() throws IOException {
        if (this.f9646e == null) {
            this.f9646e = e.b.a.m.a.m0(this.b, 1, 1, this.f9644c);
        }
        return this.f9646e;
    }

    private synchronized void f() {
        this.f9646e = null;
    }

    @Override // e.b.a.p.k.y.a
    public void a(e.b.a.p.c cVar, a.b bVar) {
        e.b.a.m.a e2;
        String b = this.a.b(cVar);
        this.f9645d.a(b);
        try {
            if (Log.isLoggable(f9640f, 2)) {
                Log.v(f9640f, "Put: Obtained: " + b + " for for Key: " + cVar);
            }
            try {
                e2 = e();
            } catch (IOException e3) {
                if (Log.isLoggable(f9640f, 5)) {
                    Log.w(f9640f, "Unable to put to disk cache", e3);
                }
            }
            if (e2.M(b) != null) {
                return;
            }
            a.c F = e2.F(b);
            if (F != null) {
                try {
                    if (bVar.a(F.f(0))) {
                        F.e();
                    }
                    F.b();
                    return;
                } catch (Throwable th) {
                    F.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + b);
        } finally {
            this.f9645d.b(b);
        }
    }

    @Override // e.b.a.p.k.y.a
    public File b(e.b.a.p.c cVar) {
        String b = this.a.b(cVar);
        if (Log.isLoggable(f9640f, 2)) {
            Log.v(f9640f, "Get: Obtained: " + b + " for for Key: " + cVar);
        }
        try {
            a.e M = e().M(b);
            if (M != null) {
                return M.b(0);
            }
            return null;
        } catch (IOException e2) {
            if (Log.isLoggable(f9640f, 5)) {
                Log.w(f9640f, "Unable to get from disk cache", e2);
                return null;
            }
            return null;
        }
    }

    @Override // e.b.a.p.k.y.a
    public synchronized void clear() {
        try {
            e().delete();
        } catch (IOException e2) {
            if (Log.isLoggable(f9640f, 5)) {
                Log.w(f9640f, "Unable to clear disk cache or disk cache cleared externally", e2);
            }
        }
        f();
    }

    @Override // e.b.a.p.k.y.a
    public void delete(e.b.a.p.c cVar) {
        try {
            e().A0(this.a.b(cVar));
        } catch (IOException e2) {
            if (Log.isLoggable(f9640f, 5)) {
                Log.w(f9640f, "Unable to delete from disk cache", e2);
            }
        }
    }
}
