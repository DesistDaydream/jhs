package i.b.s3;

import h.e2.c;
import h.k2.v.u;
import h.t1;
import i.b.e1;
import i.b.l2;
import i.b.v0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Li/b/s3/a;", "Li/b/l2;", "Li/b/v0;", "B0", "()Li/b/s3/a;", "immediate", "<init>", "()V", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class a extends l2 implements v0 {
    private a() {
    }

    @d
    public abstract a B0();

    @Override // i.b.v0
    @e
    public Object m0(long j2, @d c<? super t1> cVar) {
        return v0.a.a(this, j2, cVar);
    }

    @Override // i.b.v0
    @d
    public e1 t(long j2, @d Runnable runnable, @d CoroutineContext coroutineContext) {
        return v0.a.b(this, j2, runnable, coroutineContext);
    }

    public /* synthetic */ a(u uVar) {
        this();
    }
}
