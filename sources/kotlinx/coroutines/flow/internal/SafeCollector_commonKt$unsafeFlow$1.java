package kotlinx.coroutines.flow.internal;

import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.k2.v.c0;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SafeCollector_commonKt$unsafeFlow$1 implements Flow<T> {
    public final /* synthetic */ p a;

    public SafeCollector_commonKt$unsafeFlow$1(p pVar) {
        this.a = pVar;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@d f<? super T> fVar, @d c<? super t1> cVar) {
        Object invoke = this.a.invoke(fVar, cVar);
        return invoke == b.h() ? invoke : t1.a;
    }

    @k.e.a.e
    public Object h(@d f fVar, @d c cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1$collect$1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @k.e.a.e
            public final Object invokeSuspend(@d Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return SafeCollector_commonKt$unsafeFlow$1.this.e(null, this);
            }
        };
        c0.e(5);
        this.a.invoke(fVar, cVar);
        return t1.a;
    }
}
