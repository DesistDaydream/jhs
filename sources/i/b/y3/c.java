package i.b.y3;

import h.o2.q;
import i.b.c1;
import i.b.w3.k0;
import i.b.w3.m0;
import i.b.x1;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Li/b/y3/c;", "Li/b/y3/d;", "Lh/t1;", "close", "()V", "", "toString", "()Ljava/lang/String;", "J0", "Lkotlinx/coroutines/CoroutineDispatcher;", "g", "Lkotlinx/coroutines/CoroutineDispatcher;", "I0", "()Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class c extends d {
    @k.e.a.d

    /* renamed from: g */
    private static final CoroutineDispatcher f15916g;

    /* renamed from: h */
    public static final c f15917h;

    static {
        int d2;
        c cVar = new c();
        f15917h = cVar;
        d2 = m0.d(c1.a, q.n(64, k0.a()), 0, 0, 12, null);
        f15916g = new f(cVar, d2, "Dispatchers.IO", 1);
    }

    private c() {
        super(0, 0, null, 7, null);
    }

    @k.e.a.d
    public final CoroutineDispatcher I0() {
        return f15916g;
    }

    @x1
    @k.e.a.d
    public final String J0() {
        return super.toString();
    }

    @Override // i.b.y3.d, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // i.b.y3.d, kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    public String toString() {
        return l.a;
    }
}
