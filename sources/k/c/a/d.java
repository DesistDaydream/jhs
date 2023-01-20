package k.c.a;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k.c.a.f;
import k.c.a.g;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes4.dex */
public class d {
    private static final ExecutorService n = Executors.newCachedThreadPool();

    /* renamed from: e  reason: collision with root package name */
    public boolean f16264e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16266g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16267h;

    /* renamed from: j  reason: collision with root package name */
    public List<Class<?>> f16269j;

    /* renamed from: k  reason: collision with root package name */
    public List<k.c.a.r.d> f16270k;

    /* renamed from: l  reason: collision with root package name */
    public f f16271l;

    /* renamed from: m  reason: collision with root package name */
    public g f16272m;
    public boolean a = true;
    public boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16262c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16263d = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16265f = true;

    /* renamed from: i  reason: collision with root package name */
    public ExecutorService f16268i = n;

    public static Object e() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public d a(k.c.a.r.d dVar) {
        if (this.f16270k == null) {
            this.f16270k = new ArrayList();
        }
        this.f16270k.add(dVar);
        return this;
    }

    public c b() {
        return new c(this);
    }

    public d c(boolean z) {
        this.f16265f = z;
        return this;
    }

    public d d(ExecutorService executorService) {
        this.f16268i = executorService;
        return this;
    }

    public f f() {
        f fVar = this.f16271l;
        return fVar != null ? fVar : f.a.a();
    }

    public g g() {
        Object e2;
        g gVar = this.f16272m;
        if (gVar != null) {
            return gVar;
        }
        if (!k.c.a.q.a.c() || (e2 = e()) == null) {
            return null;
        }
        return new g.a((Looper) e2);
    }

    public d h(boolean z) {
        this.f16266g = z;
        return this;
    }

    public c i() {
        c cVar;
        synchronized (c.class) {
            if (c.t == null) {
                c.t = b();
                cVar = c.t;
            } else {
                throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
        }
        return cVar;
    }

    public d j(boolean z) {
        this.b = z;
        return this;
    }

    public d k(boolean z) {
        this.a = z;
        return this;
    }

    public d l(f fVar) {
        this.f16271l = fVar;
        return this;
    }

    public d m(boolean z) {
        this.f16263d = z;
        return this;
    }

    public d n(boolean z) {
        this.f16262c = z;
        return this;
    }

    public d o(Class<?> cls) {
        if (this.f16269j == null) {
            this.f16269j = new ArrayList();
        }
        this.f16269j.add(cls);
        return this;
    }

    public d p(boolean z) {
        this.f16267h = z;
        return this;
    }

    public d q(boolean z) {
        this.f16264e = z;
        return this;
    }
}
