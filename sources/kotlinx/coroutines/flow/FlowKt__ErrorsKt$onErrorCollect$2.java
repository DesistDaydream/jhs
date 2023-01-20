package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.l;
import h.k2.u.q;
import h.r0;
import h.t1;
import i.b.v3.f;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$2", f = "Errors.kt", i = {0, 0, 0, 0}, l = {227}, m = "invokeSuspend", n = {"$this$catch", e.a, "$this$emitAll$iv", "flow$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "", e.a, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ErrorsKt$onErrorCollect$2 extends SuspendLambda implements q<f<? super T>, Throwable, c<? super t1>, Object> {
    public final /* synthetic */ Flow $fallback;
    public final /* synthetic */ l $predicate;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    private f p$;
    private Throwable p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$onErrorCollect$2(l lVar, Flow flow, c cVar) {
        super(3, cVar);
        this.$predicate = lVar;
        this.$fallback = flow;
    }

    @k.e.a.d
    public final c<t1> create(@k.e.a.d f<? super T> fVar, @k.e.a.d Throwable th, @k.e.a.d c<? super t1> cVar) {
        FlowKt__ErrorsKt$onErrorCollect$2 flowKt__ErrorsKt$onErrorCollect$2 = new FlowKt__ErrorsKt$onErrorCollect$2(this.$predicate, this.$fallback, cVar);
        flowKt__ErrorsKt$onErrorCollect$2.p$ = fVar;
        flowKt__ErrorsKt$onErrorCollect$2.p$0 = th;
        return flowKt__ErrorsKt$onErrorCollect$2;
    }

    @Override // h.k2.u.q
    public final Object invoke(Object obj, Throwable th, c<? super t1> cVar) {
        return ((FlowKt__ErrorsKt$onErrorCollect$2) create((f) obj, th, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            f fVar = this.p$;
            Throwable th = this.p$0;
            if (((Boolean) this.$predicate.invoke(th)).booleanValue()) {
                Flow flow = this.$fallback;
                this.L$0 = fVar;
                this.L$1 = th;
                this.L$2 = fVar;
                this.L$3 = flow;
                this.label = 1;
                if (flow.e(fVar, this) == h2) {
                    return h2;
                }
            } else {
                throw th;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Flow flow2 = (Flow) this.L$3;
            f fVar2 = (f) this.L$2;
            Throwable th2 = (Throwable) this.L$1;
            f fVar3 = (f) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
