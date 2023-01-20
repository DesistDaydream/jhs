package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.v3.h;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", i = {0}, l = {50}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__CollectKt$launchIn$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Flow $this_launchIn;
    public Object L$0;
    public int label;
    private n0 p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__CollectKt$launchIn$1(Flow flow, c cVar) {
        super(2, cVar);
        this.$this_launchIn = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__CollectKt$launchIn$1 flowKt__CollectKt$launchIn$1 = new FlowKt__CollectKt$launchIn$1(this.$this_launchIn, cVar);
        flowKt__CollectKt$launchIn$1.p$ = (n0) obj;
        return flowKt__CollectKt$launchIn$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, c<? super t1> cVar) {
        return ((FlowKt__CollectKt$launchIn$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            n0 n0Var = this.p$;
            Flow flow = this.$this_launchIn;
            this.L$0 = n0Var;
            this.label = 1;
            if (h.z(flow, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            n0 n0Var2 = (n0) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
