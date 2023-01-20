package kotlinx.coroutines.flow;

import h.e2.c;
import h.k2.v.c0;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$2"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1 implements f<T> {
    public final /* synthetic */ f a;
    public final /* synthetic */ FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2 b;

    public FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1(f fVar, FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2 flowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2) {
        this.a = fVar;
        this.b = flowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2;
    }

    @e
    public Object a(Object obj, @d c cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1.1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @e
            public final Object invokeSuspend(@d Object obj2) {
                this.result = obj2;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1.this.emit(null, this);
            }
        };
        c0.e(5);
        return this.b.b.invoke(this.a, obj, cVar);
    }

    @Override // i.b.v3.f
    @e
    public Object emit(Object obj, @d c cVar) {
        return this.b.b.invoke(this.a, obj, cVar);
    }
}
