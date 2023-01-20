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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lh/t1;", AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements p<t1, c<? super t1>, Object> {
    public final /* synthetic */ f $downstream$inlined;
    public final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    public final /* synthetic */ y $ticker$inlined;
    public final /* synthetic */ Ref.ObjectRef $values$inlined;
    public Object L$0;
    public Object L$1;
    public int label;
    private t1 p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(c cVar, Ref.ObjectRef objectRef, y yVar, Ref.ObjectRef objectRef2, f fVar) {
        super(2, cVar);
        this.$values$inlined = objectRef;
        this.$ticker$inlined = yVar;
        this.$lastValue$inlined = objectRef2;
        this.$downstream$inlined = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 = new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(cVar, this.$values$inlined, this.$ticker$inlined, this.$lastValue$inlined, this.$downstream$inlined);
        flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2.p$0 = (t1) obj;
        return flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(t1 t1Var, c<? super t1> cVar) {
        return ((FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2) create(t1Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            t1 t1Var = this.p$0;
            Ref.ObjectRef objectRef = this.$lastValue$inlined;
            Object obj2 = objectRef.element;
            if (obj2 != null) {
                objectRef.element = null;
                f fVar = this.$downstream$inlined;
                Object obj3 = obj2 != n.a ? obj2 : null;
                this.L$0 = t1Var;
                this.L$1 = obj2;
                this.label = 1;
                if (fVar.emit(obj3, this) == h2) {
                    return h2;
                }
            } else {
                return t1.a;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            t1 t1Var2 = (t1) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
