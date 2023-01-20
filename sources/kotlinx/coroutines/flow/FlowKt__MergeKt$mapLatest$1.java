package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.k2.u.q;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {0, 0, 1, 1}, l = {214, 214}, m = "invokeSuspend", n = {"$this$transformLatest", AdvanceSetting.NETWORK_TYPE, "$this$transformLatest", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__MergeKt$mapLatest$1 extends SuspendLambda implements q<f<? super R>, T, c<? super t1>, Object> {
    public final /* synthetic */ p $transform;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private f p$;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MergeKt$mapLatest$1(p pVar, c cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    @k.e.a.d
    public final c<t1> create(@k.e.a.d f<? super R> fVar, T t, @k.e.a.d c<? super t1> cVar) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.$transform, cVar);
        flowKt__MergeKt$mapLatest$1.p$ = fVar;
        flowKt__MergeKt$mapLatest$1.p$0 = t;
        return flowKt__MergeKt$mapLatest$1;
    }

    @Override // h.k2.u.q
    public final Object invoke(Object obj, Object obj2, c<? super t1> cVar) {
        return ((FlowKt__MergeKt$mapLatest$1) create((f) obj, obj2, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        f fVar;
        f fVar2;
        Object obj2;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            fVar = this.p$;
            Object obj3 = this.p$0;
            p pVar = this.$transform;
            this.L$0 = fVar;
            this.L$1 = obj3;
            this.L$2 = fVar;
            this.label = 1;
            Object invoke = pVar.invoke(obj3, this);
            if (invoke == h2) {
                return h2;
            }
            fVar2 = fVar;
            obj2 = obj3;
            obj = invoke;
        } else if (i2 != 1) {
            if (i2 == 2) {
                f fVar3 = (f) this.L$0;
                r0.n(obj);
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            fVar = (f) this.L$2;
            obj2 = this.L$1;
            fVar2 = (f) this.L$0;
            r0.n(obj);
        }
        this.L$0 = fVar2;
        this.L$1 = obj2;
        this.label = 2;
        if (fVar.emit(obj, this) == h2) {
            return h2;
        }
        return t1.a;
    }
}
