package kotlinx.coroutines.flow;

import com.qq.e.comm.adevent.AdEventType;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.v3.f;
import i.b.v3.x;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;

@d(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {0, 0, 0}, l = {AdEventType.VIDEO_PRELOADED}, m = "invokeSuspend", n = {"$this$flow", "started", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Li/b/v3/f;", "Lkotlinx/coroutines/flow/SharingCommand;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class StartedLazily$command$1 extends SuspendLambda implements p<f<? super SharingCommand>, c<? super t1>, Object> {
    public final /* synthetic */ x $subscriptionCount;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private f p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(x xVar, c cVar) {
        super(2, cVar);
        this.$subscriptionCount = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, cVar);
        startedLazily$command$1.p$ = (f) obj;
        return startedLazily$command$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(f<? super SharingCommand> fVar, c<? super t1> cVar) {
        return ((StartedLazily$command$1) create(fVar, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            f fVar = this.p$;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            x xVar = this.$subscriptionCount;
            StartedLazily$command$1$invokeSuspend$$inlined$collect$1 startedLazily$command$1$invokeSuspend$$inlined$collect$1 = new StartedLazily$command$1$invokeSuspend$$inlined$collect$1(fVar, booleanRef);
            this.L$0 = fVar;
            this.L$1 = booleanRef;
            this.L$2 = xVar;
            this.label = 1;
            if (xVar.e(startedLazily$command$1$invokeSuspend$$inlined$collect$1, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Flow flow = (Flow) this.L$2;
            Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.L$1;
            f fVar2 = (f) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
