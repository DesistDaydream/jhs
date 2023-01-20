package kotlinx.coroutines.flow;

import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 implements Flow<T> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ p b;

    public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(Flow flow, p pVar) {
        this.a = flow;
        this.b = pVar;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@d f fVar, @d c cVar) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Object e2 = this.a.e(new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1(fVar, booleanRef, this), cVar);
        return e2 == b.h() ? e2 : t1.a;
    }
}
