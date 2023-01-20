package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import android.os.SystemClock;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class g implements Closeable {
    public final boolean a;
    public final i b;

    /* renamed from: d  reason: collision with root package name */
    public final String f455d;

    /* renamed from: e  reason: collision with root package name */
    public int f456e;

    /* renamed from: f  reason: collision with root package name */
    public int f457f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f458g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f459h;

    /* renamed from: i  reason: collision with root package name */
    private Map<Integer, l> f460i;

    /* renamed from: j  reason: collision with root package name */
    public final m f461j;

    /* renamed from: l  reason: collision with root package name */
    public long f463l;
    public final n n;
    public boolean o;
    public final Socket p;
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j q;
    public final j r;
    public final Set<Integer> s;
    public static final /* synthetic */ boolean u = true;
    public static final ExecutorService t = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp Http2Connection", true));

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> f454c = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    public long f462k = 0;

    /* renamed from: m  reason: collision with root package name */
    public n f464m = new n();

    /* loaded from: classes.dex */
    public class a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f465c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            super(str, objArr);
            this.b = i2;
            this.f465c = bVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.b(this.b, this.f465c);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f467c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i2, long j2) {
            super(str, objArr);
            this.b = i2;
            this.f467c = j2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.q.a(this.b, this.f467c);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        public final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f469c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f470d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f471e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Object[] objArr, boolean z, int i2, int i3, l lVar) {
            super(str, objArr);
            this.b = z;
            this.f469c = i2;
            this.f470d = i3;
            this.f471e = lVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.a(this.b, this.f469c, this.f470d, this.f471e);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f473c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            this.b = i2;
            this.f473c = list;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            if (g.this.f461j.a(this.b, this.f473c)) {
                try {
                    g.this.q.a(this.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                    synchronized (g.this) {
                        g.this.s.remove(Integer.valueOf(this.b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f475c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f476d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Object[] objArr, int i2, List list, boolean z) {
            super(str, objArr);
            this.b = i2;
            this.f475c = list;
            this.f476d = z;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            boolean a = g.this.f461j.a(this.b, this.f475c, this.f476d);
            if (a) {
                try {
                    g.this.q.a(this.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (a || this.f476d) {
                synchronized (g.this) {
                    g.this.s.remove(Integer.valueOf(this.b));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f478c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f479d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f480e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i3, boolean z) {
            super(str, objArr);
            this.b = i2;
            this.f478c = cVar;
            this.f479d = i3;
            this.f480e = z;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                boolean a = g.this.f461j.a(this.b, this.f478c, this.f479d, this.f480e);
                if (a) {
                    g.this.q.a(this.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                }
                if (a || this.f480e) {
                    synchronized (g.this) {
                        g.this.s.remove(Integer.valueOf(this.b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0022g extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f482c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0022g(String str, Object[] objArr, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            super(str, objArr);
            this.b = i2;
            this.f482c = bVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            g.this.f461j.a(this.b, this.f482c);
            synchronized (g.this) {
                g.this.s.remove(Integer.valueOf(this.b));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public Socket a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f484c;

        /* renamed from: d  reason: collision with root package name */
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f485d;

        /* renamed from: e  reason: collision with root package name */
        public i f486e = i.a;

        /* renamed from: f  reason: collision with root package name */
        public m f487f = m.a;

        /* renamed from: g  reason: collision with root package name */
        public boolean f488g;

        public h(boolean z) {
            this.f488g = z;
        }

        public h a(i iVar) {
            this.f486e = iVar;
            return this;
        }

        public h a(Socket socket, String str, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) {
            this.a = socket;
            this.b = str;
            this.f484c = eVar;
            this.f485d = dVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public static final i a = new a();

        /* loaded from: classes.dex */
        public static final class a extends i {
            @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
            public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException {
                iVar.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException;
    }

    /* loaded from: classes.dex */
    public class j extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b implements h.b {
        public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h b;

        /* loaded from: classes.dex */
        public class a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
            public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) {
                super(str, objArr);
                this.b = iVar;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                try {
                    g.this.b.a(this.b);
                } catch (IOException e2) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e b = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b();
                    b.a(4, "Http2Connection.Listener failure for " + g.this.f455d, e2);
                    try {
                        this.b.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
            public b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                g gVar = g.this;
                gVar.b.a(gVar);
            }
        }

        /* loaded from: classes.dex */
        public class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
            public final /* synthetic */ n b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, n nVar) {
                super(str, objArr);
                this.b = nVar;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                try {
                    g.this.q.a(this.b);
                } catch (IOException unused) {
                }
            }
        }

        public j(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h hVar) {
            super("OkHttp %s", g.this.f455d);
            this.b = hVar;
        }

        private void a(n nVar) {
            g.t.execute(new c("OkHttp %s ACK Settings", new Object[]{g.this.f455d}, nVar));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, int i3, int i4, boolean z) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, int i3, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
            g.this.a(i3, list);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, long j2) {
            g gVar = g.this;
            if (i2 == 0) {
                synchronized (gVar) {
                    g gVar2 = g.this;
                    gVar2.f463l += j2;
                    gVar2.notifyAll();
                }
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a2 = gVar.a(i2);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j2);
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            if (g.this.b(i2)) {
                g.this.a(i2, bVar);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i d2 = g.this.d(i2);
            if (d2 != null) {
                d2.c(bVar);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
            fVar.e();
            synchronized (g.this) {
                iVarArr = (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) g.this.f454c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[g.this.f454c.size()]);
                g.this.f458g = true;
            }
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                if (iVar.c() > i2 && iVar.f()) {
                    iVar.c(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
                    g.this.d(iVar.c());
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z, int i2, int i3) {
            if (!z) {
                g.this.b(true, i2, i3, null);
                return;
            }
            l c2 = g.this.c(i2);
            if (c2 != null) {
                c2.b();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z, int i2, int i3, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
            if (g.this.b(i2)) {
                g.this.a(i2, list, z);
                return;
            }
            synchronized (g.this) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a2 = g.this.a(i2);
                if (a2 != null) {
                    a2.a(list);
                    if (z) {
                        a2.i();
                        return;
                    }
                    return;
                }
                g gVar = g.this;
                if (!gVar.f458g && i2 > gVar.f456e && i2 % 2 != gVar.f457f % 2) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i(i2, g.this, false, z, list);
                    g gVar2 = g.this;
                    gVar2.f456e = i2;
                    gVar2.f454c.put(Integer.valueOf(i2), iVar);
                    g.t.execute(new a("OkHttp %s stream %d", new Object[]{g.this.f455d, Integer.valueOf(i2)}, iVar));
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i3) throws IOException {
            if (g.this.b(i2)) {
                g.this.a(i2, eVar, i3, z);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a2 = g.this.a(i2);
            if (a2 == null) {
                g.this.c(i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
                eVar.skip(i3);
                return;
            }
            a2.a(eVar, i3);
            if (z) {
                a2.i();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z, n nVar) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
            long j2;
            int i2;
            synchronized (g.this) {
                int c2 = g.this.n.c();
                if (z) {
                    g.this.n.a();
                }
                g.this.n.a(nVar);
                a(nVar);
                int c3 = g.this.n.c();
                iVarArr = null;
                if (c3 == -1 || c3 == c2) {
                    j2 = 0;
                } else {
                    j2 = c3 - c2;
                    g gVar = g.this;
                    if (!gVar.o) {
                        gVar.f(j2);
                        g.this.o = true;
                    }
                    if (!g.this.f454c.isEmpty()) {
                        iVarArr = (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) g.this.f454c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[g.this.f454c.size()]);
                    }
                }
                g.t.execute(new b("OkHttp %s settings", g.this.f455d));
            }
            if (iVarArr == null || j2 == 0) {
                return;
            }
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.a(j2);
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            Throwable th;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.INTERNAL_ERROR;
            try {
                try {
                    this.b.a(this);
                    do {
                    } while (this.b.a(false, (h.b) this));
                    bVar = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.NO_ERROR;
                } catch (IOException unused) {
                    bVar = bVar2;
                } catch (Throwable th2) {
                    th = th2;
                    bVar = bVar2;
                    try {
                        g.this.a(bVar, bVar2);
                    } catch (IOException unused2) {
                    }
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b);
                    throw th;
                }
                try {
                    try {
                        g.this.a(bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                    } catch (Throwable th3) {
                        th = th3;
                        g.this.a(bVar, bVar2);
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b);
                        throw th;
                    }
                } catch (IOException unused3) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar3 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR;
                    g.this.a(bVar3, bVar3);
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b);
                }
            } catch (IOException unused4) {
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b);
        }
    }

    public g(h hVar) {
        n nVar = new n();
        this.n = nVar;
        this.o = false;
        this.s = new LinkedHashSet();
        this.f461j = hVar.f487f;
        boolean z = hVar.f488g;
        this.a = z;
        this.b = hVar.f486e;
        int i2 = z ? 1 : 2;
        this.f457f = i2;
        if (z) {
            this.f457f = i2 + 2;
        }
        if (z) {
            this.f464m.a(7, 16777216);
        }
        String str = hVar.b;
        this.f455d = str;
        this.f459h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp %s Push Observer", str), true));
        nVar.a(7, 65535);
        nVar.a(5, 16384);
        this.f463l = nVar.c();
        this.p = hVar.a;
        this.q = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j(hVar.f485d, z);
        this.r = new j(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h(hVar.f484c, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[Catch: all -> 0x0067, TryCatch #1 {, blocks: (B:4:0x0005, B:21:0x0041, B:25:0x0050, B:22:0x0047, B:24:0x004b, B:29:0x0059, B:30:0x0060, B:5:0x0006, B:7:0x000a, B:9:0x001d, B:11:0x0025, B:16:0x002f, B:18:0x0035, B:19:0x003e, B:31:0x0061, B:32:0x0066), top: B:39:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i b(int r11, java.util.List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r7 = r10.q
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r10.f458g     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L61
            int r8 = r10.f457f     // Catch: java.lang.Throwable -> L67
            int r0 = r8 + 2
            r10.f457f = r0     // Catch: java.lang.Throwable -> L67
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i r9 = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i     // Catch: java.lang.Throwable -> L67
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L67
            if (r13 == 0) goto L2e
            long r0 = r10.f463l     // Catch: java.lang.Throwable -> L67
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L2e
            long r0 = r9.b     // Catch: java.lang.Throwable -> L67
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L2c
            goto L2e
        L2c:
            r13 = 0
            goto L2f
        L2e:
            r13 = 1
        L2f:
            boolean r0 = r9.g()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L3e
            java.util.Map<java.lang.Integer, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> r0 = r10.f454c     // Catch: java.lang.Throwable -> L67
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L67
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L67
        L3e:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            if (r11 != 0) goto L47
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r0 = r10.q     // Catch: java.lang.Throwable -> L6a
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L6a
            goto L50
        L47:
            boolean r0 = r10.a     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L59
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r0 = r10.q     // Catch: java.lang.Throwable -> L6a
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L6a
        L50:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6a
            if (r13 == 0) goto L58
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r11 = r10.q
            r11.flush()
        L58:
            return r9
        L59:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L6a
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L6a
            throw r11     // Catch: java.lang.Throwable -> L6a
        L61:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a r11 = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a     // Catch: java.lang.Throwable -> L67
            r11.<init>()     // Catch: java.lang.Throwable -> L67
            throw r11     // Catch: java.lang.Throwable -> L67
        L67:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            throw r11     // Catch: java.lang.Throwable -> L6a
        L6a:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6a
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.b(int, java.util.List, boolean):bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i");
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a(int i2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar;
        synchronized (this) {
            iVar = this.f454c.get(Integer.valueOf(i2));
        }
        return iVar;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a(List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    public void a(int i2, long j2) {
        t.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f455d, Integer.valueOf(i2)}, i2, j2));
    }

    public void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i3, boolean z) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        long j2 = i3;
        eVar.a(j2);
        eVar.a(cVar, j2);
        if (cVar.o() == j2) {
            this.f459h.execute(new f("OkHttp %s Push Data[%s]", new Object[]{this.f455d, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.o() + " != " + i3);
    }

    public void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        this.f459h.execute(new C0022g("OkHttp %s Push Reset[%s]", new Object[]{this.f455d, Integer.valueOf(i2)}, i2, bVar));
    }

    public void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        synchronized (this) {
            if (this.s.contains(Integer.valueOf(i2))) {
                c(i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
                return;
            }
            this.s.add(Integer.valueOf(i2));
            this.f459h.execute(new d("OkHttp %s Push Request[%s]", new Object[]{this.f455d, Integer.valueOf(i2)}, i2, list));
        }
    }

    public void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list, boolean z) {
        this.f459h.execute(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f455d, Integer.valueOf(i2)}, i2, list, z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.q.j());
        r6 = r3;
        r8.f463l -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r9, boolean r10, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r12 = r8.q
            r12.a(r10, r9, r11, r0)
            goto L60
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r3 = r8.f463l     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> r3 = r8.f454c     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L56
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L56
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r3 = r8.q     // Catch: java.lang.Throwable -> L56
            int r3 = r3.j()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f463l     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f463l = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r4 = r8.q
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.a(r5, r9, r11, r3)
            goto Ld
        L56:
            r9 = move-exception
            goto L5e
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.a(int, boolean, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c, long):void");
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        synchronized (this.q) {
            synchronized (this) {
                if (!this.f458g) {
                    this.f458g = true;
                    this.q.a(this.f456e, bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a);
                }
            }
        }
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar2) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
        if (!u && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        l[] lVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.f454c.isEmpty()) {
                iVarArr = null;
            } else {
                iVarArr = (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) this.f454c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[this.f454c.size()]);
                this.f454c.clear();
            }
            Map<Integer, l> map = this.f460i;
            if (map != null) {
                this.f460i = null;
                lVarArr = (l[]) map.values().toArray(new l[this.f460i.size()]);
            }
        }
        if (iVarArr != null) {
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                lVar.a();
            }
        }
        try {
            this.q.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.p.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    public void a(boolean z) throws IOException {
        if (z) {
            this.q.i();
            this.q.b(this.f464m);
            int c2 = this.f464m.c();
            if (c2 != 65535) {
                this.q.a(0, c2 - 65535);
            }
        }
        Thread thread = new Thread(this.r);
        thread.setName("gm_t_http2_connection" + SystemClock.uptimeMillis());
        thread.start();
    }

    public void a(boolean z, int i2, int i3, l lVar) throws IOException {
        synchronized (this.q) {
            if (lVar != null) {
                lVar.c();
            }
            this.q.a(z, i2, i3);
        }
    }

    public void b(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        this.q.a(i2, bVar);
    }

    public void b(boolean z, int i2, int i3, l lVar) {
        t.execute(new c("OkHttp %s ping %08x%08x", new Object[]{this.f455d, Integer.valueOf(i2), Integer.valueOf(i3)}, z, i2, i3, lVar));
    }

    public boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public l c(int i2) {
        l remove;
        synchronized (this) {
            Map<Integer, l> map = this.f460i;
            remove = map != null ? map.remove(Integer.valueOf(i2)) : null;
        }
        return remove;
    }

    public void c(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        t.execute(new a("OkHttp %s stream %d", new Object[]{this.f455d, Integer.valueOf(i2)}, i2, bVar));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.NO_ERROR, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i d(int i2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i remove;
        synchronized (this) {
            remove = this.f454c.remove(Integer.valueOf(i2));
            notifyAll();
        }
        return remove;
    }

    public void f(long j2) {
        this.f463l += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public void flush() throws IOException {
        this.q.flush();
    }

    public boolean i() {
        boolean z;
        synchronized (this) {
            z = this.f458g;
        }
        return z;
    }

    public int j() {
        int b2;
        synchronized (this) {
            b2 = this.n.b(Integer.MAX_VALUE);
        }
        return b2;
    }

    public void k() throws IOException {
        a(true);
    }
}
