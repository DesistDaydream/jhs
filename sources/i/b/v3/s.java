package i.b.v3;

import com.umeng.analytics.pro.am;
import h.t1;
import i.b.q0;
import kotlin.Metadata;
import kotlinx.coroutines.flow.SharedFlowImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Li/b/v3/s;", "Li/b/v3/c0/c;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "c", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)Z", "", "Lh/e2/c;", "Lh/t1;", e.j.a.b.c.f.f10128d, "(Lkotlinx/coroutines/flow/SharedFlowImpl;)[Lkotlin/coroutines/Continuation;", "", am.av, "J", "index", "b", "Lh/e2/c;", "cont", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class s extends i.b.v3.c0.c<SharedFlowImpl<?>> {
    @h.k2.d
    public long a = -1;
    @h.k2.d
    @k.e.a.e
    public h.e2.c<? super t1> b;

    @Override // i.b.v3.c0.c
    /* renamed from: c */
    public boolean a(@k.e.a.d SharedFlowImpl<?> sharedFlowImpl) {
        if (this.a >= 0) {
            return false;
        }
        this.a = sharedFlowImpl.a0();
        return true;
    }

    @Override // i.b.v3.c0.c
    @k.e.a.d
    /* renamed from: d */
    public h.e2.c<t1>[] b(@k.e.a.d SharedFlowImpl<?> sharedFlowImpl) {
        if (q0.b()) {
            if (!(this.a >= 0)) {
                throw new AssertionError();
            }
        }
        long j2 = this.a;
        this.a = -1L;
        this.b = null;
        return sharedFlowImpl.Z(j2);
    }
}
