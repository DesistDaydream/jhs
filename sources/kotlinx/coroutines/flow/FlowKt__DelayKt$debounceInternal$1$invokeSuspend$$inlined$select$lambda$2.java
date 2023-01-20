package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.v3.c0.n;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "value", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements p<Object, c<? super t1>, Object> {
    public final /* synthetic */ f $downstream$inlined;
    public final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    public final /* synthetic */ Ref.LongRef $timeoutMillis$inlined;
    public final /* synthetic */ Ref.ObjectRef $values$inlined;
    public Object L$0;
    public int label;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(c cVar, Ref.ObjectRef objectRef, Ref.LongRef longRef, f fVar, Ref.ObjectRef objectRef2) {
        super(2, cVar);
        this.$lastValue$inlined = objectRef;
        this.$timeoutMillis$inlined = longRef;
        this.$downstream$inlined = fVar;
        this.$values$inlined = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 = new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(cVar, this.$lastValue$inlined, this.$timeoutMillis$inlined, this.$downstream$inlined, this.$values$inlined);
        flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2.p$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, i.b.w3.i0] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            ?? r6 = this.p$0;
            if (r6 == 0) {
                Object obj2 = this.$lastValue$inlined.element;
                if (obj2 != null) {
                    f fVar = this.$downstream$inlined;
                    if (obj2 == n.a) {
                        obj2 = null;
                    }
                    this.L$0 = r6;
                    this.label = 1;
                    if (fVar.emit(obj2, this) == h2) {
                        return h2;
                    }
                }
            } else {
                this.$lastValue$inlined.element = r6;
                return t1.a;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            r0.n(obj);
        }
        this.$lastValue$inlined.element = n.f15866c;
        return t1.a;
    }
}
