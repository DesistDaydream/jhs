package e.b.a.p.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* loaded from: classes.dex */
public class m<A, B> {
    private static final int b = 250;
    private final e.b.a.v.i<b<A>, B> a;

    /* loaded from: classes.dex */
    public class a extends e.b.a.v.i<b<A>, B> {
        public a(long j2) {
            super(j2);
        }

        @Override // e.b.a.v.i
        /* renamed from: q */
        public void m(@NonNull b<A> bVar, @Nullable B b) {
            bVar.c();
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<b<?>> f9705d = e.b.a.v.n.f(0);
        private int a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private A f9706c;

        private b() {
        }

        public static <A> b<A> a(A a, int i2, int i3) {
            b<A> bVar;
            Queue<b<?>> queue = f9705d;
            synchronized (queue) {
                bVar = (b<A>) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a, i2, i3);
            return bVar;
        }

        private void b(A a, int i2, int i3) {
            this.f9706c = a;
            this.b = i2;
            this.a = i3;
        }

        public void c() {
            Queue<b<?>> queue = f9705d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.b == bVar.b && this.a == bVar.a && this.f9706c.equals(bVar.f9706c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.f9706c.hashCode();
        }
    }

    public m() {
        this(250L);
    }

    public void a() {
        this.a.b();
    }

    @Nullable
    public B b(A a2, int i2, int i3) {
        b<A> a3 = b.a(a2, i2, i3);
        B j2 = this.a.j(a3);
        a3.c();
        return j2;
    }

    public void c(A a2, int i2, int i3, B b2) {
        this.a.n(b.a(a2, i2, i3), b2);
    }

    public m(long j2) {
        this.a = new a(j2);
    }
}
