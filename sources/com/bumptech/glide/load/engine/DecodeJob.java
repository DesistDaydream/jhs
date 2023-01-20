package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import e.b.a.p.i;
import e.b.a.p.k.e;
import e.b.a.p.k.g;
import e.b.a.p.k.h;
import e.b.a.p.k.l;
import e.b.a.p.k.q;
import e.b.a.p.k.r;
import e.b.a.p.k.s;
import e.b.a.p.k.t;
import e.b.a.p.k.u;
import e.b.a.p.k.w;
import e.b.a.p.m.d.o;
import e.b.a.v.p.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DecodeJob<R> implements e.a, Runnable, Comparable<DecodeJob<?>>, a.f {
    private static final String G = "DecodeJob";
    private DataSource A;
    private e.b.a.p.j.d<?> B;
    private volatile e.b.a.p.k.e C;
    private volatile boolean D;
    private volatile boolean E;
    private boolean F;

    /* renamed from: d */
    private final e f1687d;

    /* renamed from: e */
    private final Pools.Pool<DecodeJob<?>> f1688e;

    /* renamed from: h */
    private e.b.a.e f1691h;

    /* renamed from: i */
    private e.b.a.p.c f1692i;

    /* renamed from: j */
    private Priority f1693j;

    /* renamed from: k */
    private l f1694k;

    /* renamed from: l */
    private int f1695l;

    /* renamed from: m */
    private int f1696m;
    private h n;
    private e.b.a.p.f o;
    private b<R> p;
    private int q;
    private Stage r;
    private RunReason s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private e.b.a.p.c x;
    private e.b.a.p.c y;
    private Object z;
    private final e.b.a.p.k.f<R> a = new e.b.a.p.k.f<>();
    private final List<Throwable> b = new ArrayList();

    /* renamed from: c */
    private final e.b.a.v.p.c f1686c = e.b.a.v.p.c.a();

    /* renamed from: f */
    private final d<?> f1689f = new d<>();

    /* renamed from: g */
    private final f f1690g = new f();

    /* loaded from: classes.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* loaded from: classes.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        /* renamed from: c */
        public static final /* synthetic */ int[] f1697c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f1697c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1697c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b<R> {
        void b(s<R> sVar, DataSource dataSource, boolean z);

        void c(GlideException glideException);

        void e(DecodeJob<?> decodeJob);
    }

    /* loaded from: classes.dex */
    public final class c<Z> implements g.a<Z> {
        private final DataSource a;

        public c(DataSource dataSource) {
            DecodeJob.this = r1;
            this.a = dataSource;
        }

        @Override // e.b.a.p.k.g.a
        @NonNull
        public s<Z> a(@NonNull s<Z> sVar) {
            return DecodeJob.this.w(this.a, sVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d<Z> {
        private e.b.a.p.c a;
        private e.b.a.p.h<Z> b;

        /* renamed from: c */
        private r<Z> f1698c;

        public void a() {
            this.a = null;
            this.b = null;
            this.f1698c = null;
        }

        public void b(e eVar, e.b.a.p.f fVar) {
            e.b.a.v.p.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.a, new e.b.a.p.k.d(this.b, this.f1698c, fVar));
            } finally {
                this.f1698c.f();
                e.b.a.v.p.b.e();
            }
        }

        public boolean c() {
            return this.f1698c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <X> void d(e.b.a.p.c cVar, e.b.a.p.h<X> hVar, r<X> rVar) {
            this.a = cVar;
            this.b = hVar;
            this.f1698c = rVar;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        e.b.a.p.k.y.a a();
    }

    /* loaded from: classes.dex */
    public static class f {
        private boolean a;
        private boolean b;

        /* renamed from: c */
        private boolean f1699c;

        private boolean a(boolean z) {
            return (this.f1699c || z || this.b) && this.a;
        }

        public synchronized boolean b() {
            this.b = true;
            return a(false);
        }

        public synchronized boolean c() {
            this.f1699c = true;
            return a(false);
        }

        public synchronized boolean d(boolean z) {
            this.a = true;
            return a(z);
        }

        public synchronized void e() {
            this.b = false;
            this.a = false;
            this.f1699c = false;
        }
    }

    public DecodeJob(e eVar, Pools.Pool<DecodeJob<?>> pool) {
        this.f1687d = eVar;
        this.f1688e = pool;
    }

    private <Data, ResourceType> s<R> A(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) throws GlideException {
        e.b.a.p.f m2 = m(dataSource);
        e.b.a.p.j.e<Data> l2 = this.f1691h.i().l(data);
        try {
            return qVar.b(l2, m2, this.f1695l, this.f1696m, new c(dataSource));
        } finally {
            l2.a();
        }
    }

    private void B() {
        int i2 = a.a[this.s.ordinal()];
        if (i2 == 1) {
            this.r = l(Stage.INITIALIZE);
            this.C = k();
            z();
        } else if (i2 == 2) {
            z();
        } else if (i2 == 3) {
            j();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private void C() {
        Throwable th;
        this.f1686c.c();
        if (this.D) {
            if (this.b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    private <Data> s<R> h(e.b.a.p.j.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long b2 = e.b.a.v.h.b();
            s<R> i2 = i(data, dataSource);
            if (Log.isLoggable(G, 2)) {
                p("Decoded result " + i2, b2);
            }
            return i2;
        } finally {
            dVar.a();
        }
    }

    private <Data> s<R> i(Data data, DataSource dataSource) throws GlideException {
        return A(data, dataSource, (q<Data, ?, R>) this.a.h(data.getClass()));
    }

    private void j() {
        if (Log.isLoggable(G, 2)) {
            long j2 = this.t;
            q("Retrieved data", j2, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        s<R> sVar = null;
        try {
            sVar = h(this.B, this.z, this.A);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.y, this.A);
            this.b.add(e2);
        }
        if (sVar != null) {
            s(sVar, this.A, this.F);
        } else {
            z();
        }
    }

    private e.b.a.p.k.e k() {
        int i2 = a.b[this.r.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.r);
                }
                return new w(this.a, this);
            }
            return new e.b.a.p.k.b(this.a, this);
        }
        return new t(this.a, this);
    }

    private Stage l(Stage stage) {
        int i2 = a.b[stage.ordinal()];
        if (i2 == 1) {
            if (this.n.a()) {
                return Stage.DATA_CACHE;
            }
            return l(Stage.DATA_CACHE);
        } else if (i2 == 2) {
            return this.u ? Stage.FINISHED : Stage.SOURCE;
        } else if (i2 == 3 || i2 == 4) {
            return Stage.FINISHED;
        } else {
            if (i2 == 5) {
                if (this.n.b()) {
                    return Stage.RESOURCE_CACHE;
                }
                return l(Stage.RESOURCE_CACHE);
            }
            throw new IllegalArgumentException("Unrecognized stage: " + stage);
        }
    }

    @NonNull
    private e.b.a.p.f m(DataSource dataSource) {
        e.b.a.p.f fVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return fVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.a.w();
        e.b.a.p.e<Boolean> eVar = o.f9767k;
        Boolean bool = (Boolean) fVar.a(eVar);
        if (bool == null || (bool.booleanValue() && !z)) {
            e.b.a.p.f fVar2 = new e.b.a.p.f();
            fVar2.b(this.o);
            fVar2.c(eVar, Boolean.valueOf(z));
            return fVar2;
        }
        return fVar;
    }

    private int n() {
        return this.f1693j.ordinal();
    }

    private void p(String str, long j2) {
        q(str, j2, null);
    }

    private void q(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(e.b.a.v.h.a(j2));
        sb.append(", load key: ");
        sb.append(this.f1694k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v(G, sb.toString());
    }

    private void r(s<R> sVar, DataSource dataSource, boolean z) {
        C();
        this.p.b(sVar, dataSource, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s(s<R> sVar, DataSource dataSource, boolean z) {
        if (sVar instanceof e.b.a.p.k.o) {
            ((e.b.a.p.k.o) sVar).a();
        }
        r rVar = 0;
        if (this.f1689f.c()) {
            sVar = r.c(sVar);
            rVar = sVar;
        }
        r(sVar, dataSource, z);
        this.r = Stage.ENCODE;
        try {
            if (this.f1689f.c()) {
                this.f1689f.b(this.f1687d, this.o);
            }
            u();
        } finally {
            if (rVar != 0) {
                rVar.f();
            }
        }
    }

    private void t() {
        C();
        this.p.c(new GlideException("Failed to load resource", new ArrayList(this.b)));
        v();
    }

    private void u() {
        if (this.f1690g.b()) {
            y();
        }
    }

    private void v() {
        if (this.f1690g.c()) {
            y();
        }
    }

    private void y() {
        this.f1690g.e();
        this.f1689f.a();
        this.a.a();
        this.D = false;
        this.f1691h = null;
        this.f1692i = null;
        this.o = null;
        this.f1693j = null;
        this.f1694k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.b.clear();
        this.f1688e.release(this);
    }

    private void z() {
        this.w = Thread.currentThread();
        this.t = e.b.a.v.h.b();
        boolean z = false;
        while (!this.E && this.C != null && !(z = this.C.c())) {
            this.r = l(this.r);
            this.C = k();
            if (this.r == Stage.SOURCE) {
                b();
                return;
            }
        }
        if ((this.r == Stage.FINISHED || this.E) && !z) {
            t();
        }
    }

    public boolean D() {
        Stage l2 = l(Stage.INITIALIZE);
        return l2 == Stage.RESOURCE_CACHE || l2 == Stage.DATA_CACHE;
    }

    @Override // e.b.a.p.k.e.a
    public void a(e.b.a.p.c cVar, Exception exc, e.b.a.p.j.d<?> dVar, DataSource dataSource) {
        dVar.a();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.getDataClass());
        this.b.add(glideException);
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.p.e(this);
            return;
        }
        z();
    }

    @Override // e.b.a.p.k.e.a
    public void b() {
        this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.e(this);
    }

    @Override // e.b.a.v.p.a.f
    @NonNull
    public e.b.a.v.p.c d() {
        return this.f1686c;
    }

    @Override // e.b.a.p.k.e.a
    public void e(e.b.a.p.c cVar, Object obj, e.b.a.p.j.d<?> dVar, DataSource dataSource, e.b.a.p.c cVar2) {
        this.x = cVar;
        this.z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.y = cVar2;
        this.F = cVar != this.a.c().get(0);
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.DECODE_DATA;
            this.p.e(this);
            return;
        }
        e.b.a.v.p.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            j();
        } finally {
            e.b.a.v.p.b.e();
        }
    }

    public void f() {
        this.E = true;
        e.b.a.p.k.e eVar = this.C;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: g */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int n = n() - decodeJob.n();
        return n == 0 ? this.q - decodeJob.q : n;
    }

    public DecodeJob<R> o(e.b.a.e eVar, Object obj, l lVar, e.b.a.p.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, i<?>> map, boolean z, boolean z2, boolean z3, e.b.a.p.f fVar, b<R> bVar, int i4) {
        this.a.u(eVar, obj, cVar, i2, i3, hVar, cls, cls2, priority, fVar, map, z, z2, this.f1687d);
        this.f1691h = eVar;
        this.f1692i = cVar;
        this.f1693j = priority;
        this.f1694k = lVar;
        this.f1695l = i2;
        this.f1696m = i3;
        this.n = hVar;
        this.u = z3;
        this.o = fVar;
        this.p = bVar;
        this.q = i4;
        this.s = RunReason.INITIALIZE;
        this.v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.b.a.v.p.b.b("DecodeJob#run(model=%s)", this.v);
        e.b.a.p.j.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    t();
                    if (dVar != null) {
                        dVar.a();
                    }
                    e.b.a.v.p.b.e();
                    return;
                }
                B();
                if (dVar != null) {
                    dVar.a();
                }
                e.b.a.v.p.b.e();
            } catch (CallbackException e2) {
                throw e2;
            }
        }
    }

    @NonNull
    public <Z> s<Z> w(DataSource dataSource, @NonNull s<Z> sVar) {
        s<Z> sVar2;
        i<Z> iVar;
        EncodeStrategy encodeStrategy;
        e.b.a.p.c cVar;
        Class<?> cls = sVar.get().getClass();
        e.b.a.p.h<Z> hVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            i<Z> r = this.a.r(cls);
            iVar = r;
            sVar2 = r.transform(this.f1691h, sVar, this.f1695l, this.f1696m);
        } else {
            sVar2 = sVar;
            iVar = null;
        }
        if (!sVar.equals(sVar2)) {
            sVar.recycle();
        }
        if (this.a.v(sVar2)) {
            hVar = this.a.n(sVar2);
            encodeStrategy = hVar.b(this.o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        e.b.a.p.h hVar2 = hVar;
        if (this.n.d(!this.a.x(this.x), dataSource, encodeStrategy)) {
            if (hVar2 != null) {
                int i2 = a.f1697c[encodeStrategy.ordinal()];
                if (i2 == 1) {
                    cVar = new e.b.a.p.k.c(this.x, this.f1692i);
                } else if (i2 == 2) {
                    cVar = new u(this.a.b(), this.x, this.f1692i, this.f1695l, this.f1696m, iVar, cls, this.o);
                } else {
                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                }
                r c2 = r.c(sVar2);
                this.f1689f.d(cVar, hVar2, c2);
                return c2;
            }
            throw new Registry.NoResultEncoderAvailableException(sVar2.get().getClass());
        }
        return sVar2;
    }

    public void x(boolean z) {
        if (this.f1690g.d(z)) {
            y();
        }
    }
}
