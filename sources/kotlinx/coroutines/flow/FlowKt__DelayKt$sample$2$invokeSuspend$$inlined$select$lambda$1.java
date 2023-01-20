package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.t3.y;
import i.b.v3.c0.n;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1 extends SuspendLambda implements p<Object, c<? super t1>, Object> {
    public final /* synthetic */ f $downstream$inlined;
    public final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    public final /* synthetic */ y $ticker$inlined;
    public final /* synthetic */ Ref.ObjectRef $values$inlined;
    public int label;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1(c cVar, Ref.ObjectRef objectRef, y yVar, Ref.ObjectRef objectRef2, f fVar) {
        super(2, cVar);
        this.$values$inlined = objectRef;
        this.$ticker$inlined = yVar;
        this.$lastValue$inlined = objectRef2;
        this.$downstream$inlined = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1 flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1 = new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1(cVar, this.$values$inlined, this.$ticker$inlined, this.$lastValue$inlined, this.$downstream$inlined);
        flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1.p$0 = obj;
        return flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, i.b.w3.i0] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            ?? r2 = this.p$0;
            if (r2 == 0) {
                this.$ticker$inlined.b(new ChildCancelledException());
                this.$lastValue$inlined.element = n.f15866c;
            } else {
                this.$lastValue$inlined.element = r2;
            }
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
