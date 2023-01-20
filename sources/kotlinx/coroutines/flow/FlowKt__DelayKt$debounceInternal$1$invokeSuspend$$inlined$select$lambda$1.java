package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.l;
import h.r0;
import h.t1;
import i.b.v3.c0.n;
import i.b.v3.f;
import i.b.w3.i0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lh/t1;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1 extends SuspendLambda implements l<c<? super t1>, Object> {
    public final /* synthetic */ f $downstream$inlined;
    public final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    public final /* synthetic */ Ref.LongRef $timeoutMillis$inlined;
    public final /* synthetic */ Ref.ObjectRef $values$inlined;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1(c cVar, Ref.ObjectRef objectRef, Ref.LongRef longRef, f fVar, Ref.ObjectRef objectRef2) {
        super(1, cVar);
        this.$lastValue$inlined = objectRef;
        this.$timeoutMillis$inlined = longRef;
        this.$downstream$inlined = fVar;
        this.$values$inlined = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@d c<?> cVar) {
        return new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1(cVar, this.$lastValue$inlined, this.$timeoutMillis$inlined, this.$downstream$inlined, this.$values$inlined);
    }

    @Override // h.k2.u.l
    public final Object invoke(c<? super t1> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1) create(cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            f fVar = this.$downstream$inlined;
            i0 i0Var = n.a;
            Object obj2 = this.$lastValue$inlined.element;
            if (obj2 == i0Var) {
                obj2 = null;
            }
            this.label = 1;
            if (fVar.emit(obj2, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            r0.n(obj);
        }
        this.$lastValue$inlined.element = null;
        return t1.a;
    }
}
