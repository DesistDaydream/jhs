package h.p2.b0.g.t.p;

import h.k2.v.f0;

/* loaded from: classes3.dex */
public final class c {
    public static final boolean a(@k.e.a.d Throwable th) {
        Class<?> cls = th.getClass();
        while (!f0.g(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    @k.e.a.d
    public static final RuntimeException b(@k.e.a.d Throwable th) {
        throw th;
    }
}
