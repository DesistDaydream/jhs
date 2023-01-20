package e.j.a.b.c.n.u;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class l<L> {
    private final c a;
    private volatile L b;

    /* renamed from: c  reason: collision with root package name */
    private final a<L> f10284c;

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static final class a<L> {
        private final L a;
        private final String b;

        @e.j.a.b.c.m.a
        public a(L l2, String str) {
            this.a = l2;
            this.b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && this.b.equals(aVar.b);
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 31) + this.b.hashCode();
        }
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface b<L> {
        @e.j.a.b.c.m.a
        void a(L l2);

        @e.j.a.b.c.m.a
        void b();
    }

    /* loaded from: classes2.dex */
    public final class c extends e.j.a.b.f.a.o {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            e.j.a.b.c.r.a0.a(message.what == 1);
            l.this.e((b) message.obj);
        }
    }

    @e.j.a.b.c.m.a
    public l(@NonNull Looper looper, @NonNull L l2, @NonNull String str) {
        this.a = new c(looper);
        this.b = (L) e.j.a.b.c.r.a0.l(l2, "Listener must not be null");
        this.f10284c = new a<>(l2, e.j.a.b.c.r.a0.g(str));
    }

    @e.j.a.b.c.m.a
    public final void a() {
        this.b = null;
    }

    @NonNull
    @e.j.a.b.c.m.a
    public final a<L> b() {
        return this.f10284c;
    }

    @e.j.a.b.c.m.a
    public final boolean c() {
        return this.b != null;
    }

    @e.j.a.b.c.m.a
    public final void d(b<? super L> bVar) {
        e.j.a.b.c.r.a0.l(bVar, "Notifier must not be null");
        this.a.sendMessage(this.a.obtainMessage(1, bVar));
    }

    @e.j.a.b.c.m.a
    public final void e(b<? super L> bVar) {
        Object obj = (L) this.b;
        if (obj == null) {
            bVar.b();
            return;
        }
        try {
            bVar.a(obj);
        } catch (RuntimeException e2) {
            bVar.b();
            throw e2;
        }
    }
}
