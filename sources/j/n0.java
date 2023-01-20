package j;

import com.caverock.androidsvg.SVG;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.t1;
import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b \u0010\tB\t\b\u0016¢\u0006\u0004\b \u0010!J\u0013\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0004J\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001d¨\u0006\""}, d2 = {"Lj/n0;", "", "", "g", "(J)J", "f", "nanosToWait", "Lh/t1;", "k", "(J)V", "bytesPerSecond", "waitByteCount", "maxByteCount", e.j.a.b.c.f.f10128d, "(JJJ)V", "byteCount", "j", "now", am.av, "(JJ)J", "Lj/m0;", MessageKey.MSG_SOURCE, "i", "(Lj/m0;)Lj/m0;", "Lj/k0;", "sink", "h", "(Lj/k0;)Lj/k0;", "c", "J", "allocatedUntil", "b", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class n0 {
    private long a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f15995c;

    /* renamed from: d  reason: collision with root package name */
    private long f15996d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"j/n0$a", "Lj/q;", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", "write", "(Lj/m;J)V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a extends q {
        public final /* synthetic */ k0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k0 k0Var, k0 k0Var2) {
            super(k0Var2);
            this.b = k0Var;
        }

        @Override // j.q, j.k0
        public void write(@k.e.a.d m mVar, long j2) throws IOException {
            while (j2 > 0) {
                try {
                    long j3 = n0.this.j(j2);
                    super.write(mVar, j3);
                    j2 -= j3;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"j/n0$b", "Lj/r;", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b extends r {
        public final /* synthetic */ m0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m0 m0Var, m0 m0Var2) {
            super(m0Var2);
            this.b = m0Var;
        }

        @Override // j.r, j.m0
        public long read(@k.e.a.d m mVar, long j2) {
            try {
                return super.read(mVar, n0.this.j(j2));
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }

    public n0(long j2) {
        this.f15996d = j2;
        this.b = SVG.A;
        this.f15995c = SVG.F;
    }

    public static /* synthetic */ void e(n0 n0Var, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = n0Var.b;
        }
        long j5 = j3;
        if ((i2 & 4) != 0) {
            j4 = n0Var.f15995c;
        }
        n0Var.d(j2, j5, j4);
    }

    private final long f(long j2) {
        return (j2 * 1000000000) / this.a;
    }

    private final long g(long j2) {
        return (j2 * this.a) / 1000000000;
    }

    private final void k(long j2) {
        long j3 = j2 / 1000000;
        wait(j3, (int) (j2 - (1000000 * j3)));
    }

    public final long a(long j2, long j3) {
        if (this.a == 0) {
            return j3;
        }
        long max = Math.max(this.f15996d - j2, 0L);
        long g2 = this.f15995c - g(max);
        if (g2 >= j3) {
            this.f15996d = j2 + max + f(j3);
            return j3;
        }
        long j4 = this.b;
        if (g2 >= j4) {
            this.f15996d = j2 + f(this.f15995c);
            return g2;
        }
        long min = Math.min(j4, j3);
        long f2 = max + f(min - this.f15995c);
        if (f2 == 0) {
            this.f15996d = j2 + f(this.f15995c);
            return min;
        }
        return -f2;
    }

    @h.k2.h
    public final void b(long j2) {
        e(this, j2, 0L, 0L, 6, null);
    }

    @h.k2.h
    public final void c(long j2, long j3) {
        e(this, j2, j3, 0L, 4, null);
    }

    @h.k2.h
    public final void d(long j2, long j3, long j4) {
        synchronized (this) {
            if (!(j2 >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j3 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (j4 >= j3) {
                this.a = j2;
                this.b = j3;
                this.f15995c = j4;
                notifyAll();
                t1 t1Var = t1.a;
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    @k.e.a.d
    public final k0 h(@k.e.a.d k0 k0Var) {
        return new a(k0Var, k0Var);
    }

    @k.e.a.d
    public final m0 i(@k.e.a.d m0 m0Var) {
        return new b(m0Var, m0Var);
    }

    public final long j(long j2) {
        long a2;
        if (j2 > 0) {
            synchronized (this) {
                while (true) {
                    a2 = a(System.nanoTime(), j2);
                    if (a2 < 0) {
                        k(-a2);
                    }
                }
            }
            return a2;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public n0() {
        this(System.nanoTime());
    }
}
