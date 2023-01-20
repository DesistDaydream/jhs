package e.b.a.p.m.h;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import e.b.a.v.l;
import e.b.a.v.n;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g {
    private final e.b.a.n.a a;
    private final Handler b;

    /* renamed from: c */
    private final List<b> f9820c;

    /* renamed from: d */
    public final e.b.a.j f9821d;

    /* renamed from: e */
    private final e.b.a.p.k.x.e f9822e;

    /* renamed from: f */
    private boolean f9823f;

    /* renamed from: g */
    private boolean f9824g;

    /* renamed from: h */
    private boolean f9825h;

    /* renamed from: i */
    private e.b.a.i<Bitmap> f9826i;

    /* renamed from: j */
    private a f9827j;

    /* renamed from: k */
    private boolean f9828k;

    /* renamed from: l */
    private a f9829l;

    /* renamed from: m */
    private Bitmap f9830m;
    private e.b.a.p.i<Bitmap> n;
    private a o;
    @Nullable
    private d p;
    private int q;
    private int r;
    private int s;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a extends e.b.a.t.k.e<Bitmap> {
        private final Handler a;
        public final int b;

        /* renamed from: c */
        private final long f9831c;

        /* renamed from: d */
        private Bitmap f9832d;

        public a(Handler handler, int i2, long j2) {
            this.a = handler;
            this.b = i2;
            this.f9831c = j2;
        }

        public Bitmap a() {
            return this.f9832d;
        }

        @Override // e.b.a.t.k.p
        public void onLoadCleared(@Nullable Drawable drawable) {
            this.f9832d = null;
        }

        @Override // e.b.a.t.k.p
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable e.b.a.t.l.f fVar) {
            onResourceReady((Bitmap) obj, (e.b.a.t.l.f<? super Bitmap>) fVar);
        }

        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable e.b.a.t.l.f<? super Bitmap> fVar) {
            this.f9832d = bitmap;
            this.a.sendMessageAtTime(this.a.obtainMessage(1, this), this.f9831c);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public class c implements Handler.Callback {
        public static final int b = 1;

        /* renamed from: c */
        public static final int f9833c = 2;

        public c() {
            g.this = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.o((a) message.obj);
                return true;
            } else if (i2 == 2) {
                g.this.f9821d.r((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    public g(e.b.a.c cVar, e.b.a.n.a aVar, int i2, int i3, e.b.a.p.i<Bitmap> iVar, Bitmap bitmap) {
        this(cVar.h(), e.b.a.c.D(cVar.getContext()), aVar, null, k(e.b.a.c.D(cVar.getContext()), i2, i3), iVar, bitmap);
    }

    private static e.b.a.p.c g() {
        return new e.b.a.u.e(Double.valueOf(Math.random()));
    }

    private static e.b.a.i<Bitmap> k(e.b.a.j jVar, int i2, int i3) {
        return jVar.m().l(e.b.a.t.h.Z0(e.b.a.p.k.h.b).S0(true).I0(true).x0(i2, i3));
    }

    private void n() {
        if (!this.f9823f || this.f9824g) {
            return;
        }
        if (this.f9825h) {
            l.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.j();
            this.f9825h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            o(aVar);
            return;
        }
        this.f9824g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.a.i();
        this.a.b();
        this.f9829l = new a(this.b, this.a.l(), uptimeMillis);
        this.f9826i.l(e.b.a.t.h.q1(g())).h(this.a).j1(this.f9829l);
    }

    private void p() {
        Bitmap bitmap = this.f9830m;
        if (bitmap != null) {
            this.f9822e.d(bitmap);
            this.f9830m = null;
        }
    }

    private void t() {
        if (this.f9823f) {
            return;
        }
        this.f9823f = true;
        this.f9828k = false;
        n();
    }

    private void u() {
        this.f9823f = false;
    }

    public void a() {
        this.f9820c.clear();
        p();
        u();
        a aVar = this.f9827j;
        if (aVar != null) {
            this.f9821d.r(aVar);
            this.f9827j = null;
        }
        a aVar2 = this.f9829l;
        if (aVar2 != null) {
            this.f9821d.r(aVar2);
            this.f9829l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f9821d.r(aVar3);
            this.o = null;
        }
        this.a.clear();
        this.f9828k = true;
    }

    public ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    public Bitmap c() {
        a aVar = this.f9827j;
        return aVar != null ? aVar.a() : this.f9830m;
    }

    public int d() {
        a aVar = this.f9827j;
        if (aVar != null) {
            return aVar.b;
        }
        return -1;
    }

    public Bitmap e() {
        return this.f9830m;
    }

    public int f() {
        return this.a.c();
    }

    public e.b.a.p.i<Bitmap> h() {
        return this.n;
    }

    public int i() {
        return this.s;
    }

    public int j() {
        return this.a.f();
    }

    public int l() {
        return this.a.p() + this.q;
    }

    public int m() {
        return this.r;
    }

    @VisibleForTesting
    public void o(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f9824g = false;
        if (this.f9828k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f9823f) {
            if (this.f9825h) {
                this.b.obtainMessage(2, aVar).sendToTarget();
            } else {
                this.o = aVar;
            }
        } else {
            if (aVar.a() != null) {
                p();
                a aVar2 = this.f9827j;
                this.f9827j = aVar;
                for (int size = this.f9820c.size() - 1; size >= 0; size--) {
                    this.f9820c.get(size).a();
                }
                if (aVar2 != null) {
                    this.b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            n();
        }
    }

    public void q(e.b.a.p.i<Bitmap> iVar, Bitmap bitmap) {
        this.n = (e.b.a.p.i) l.d(iVar);
        this.f9830m = (Bitmap) l.d(bitmap);
        this.f9826i = this.f9826i.l(new e.b.a.t.h().L0(iVar));
        this.q = n.h(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    public void r() {
        l.a(!this.f9823f, "Can't restart a running animation");
        this.f9825h = true;
        a aVar = this.o;
        if (aVar != null) {
            this.f9821d.r(aVar);
            this.o = null;
        }
    }

    @VisibleForTesting
    public void s(@Nullable d dVar) {
        this.p = dVar;
    }

    public void v(b bVar) {
        if (!this.f9828k) {
            if (!this.f9820c.contains(bVar)) {
                boolean isEmpty = this.f9820c.isEmpty();
                this.f9820c.add(bVar);
                if (isEmpty) {
                    t();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    public void w(b bVar) {
        this.f9820c.remove(bVar);
        if (this.f9820c.isEmpty()) {
            u();
        }
    }

    public g(e.b.a.p.k.x.e eVar, e.b.a.j jVar, e.b.a.n.a aVar, Handler handler, e.b.a.i<Bitmap> iVar, e.b.a.p.i<Bitmap> iVar2, Bitmap bitmap) {
        this.f9820c = new ArrayList();
        this.f9821d = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f9822e = eVar;
        this.b = handler;
        this.f9826i = iVar;
        this.a = aVar;
        q(iVar2, bitmap);
    }
}
