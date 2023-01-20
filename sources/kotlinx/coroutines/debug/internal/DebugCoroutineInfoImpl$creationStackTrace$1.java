package kotlinx.coroutines.debug.internal;

import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.q2.o;
import h.r0;
import h.t1;
import i.b.u3.b.g;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@d(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lh/q2/o;", "Ljava/lang/StackTraceElement;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements p<o<? super StackTraceElement>, c<? super t1>, Object> {
    public final /* synthetic */ g $bottom;
    public Object L$0;
    public int label;
    private o p$;
    public final /* synthetic */ DebugCoroutineInfoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$creationStackTrace$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, g gVar, c cVar) {
        super(2, cVar);
        this.this$0 = debugCoroutineInfoImpl;
        this.$bottom = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        DebugCoroutineInfoImpl$creationStackTrace$1 debugCoroutineInfoImpl$creationStackTrace$1 = new DebugCoroutineInfoImpl$creationStackTrace$1(this.this$0, this.$bottom, cVar);
        debugCoroutineInfoImpl$creationStackTrace$1.p$ = (o) obj;
        return debugCoroutineInfoImpl$creationStackTrace$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(o<? super StackTraceElement> oVar, c<? super t1> cVar) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) create(oVar, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            o<? super StackTraceElement> oVar = this.p$;
            DebugCoroutineInfoImpl debugCoroutineInfoImpl = this.this$0;
            h.e2.k.a.c callerFrame = this.$bottom.getCallerFrame();
            this.L$0 = oVar;
            this.label = 1;
            if (debugCoroutineInfoImpl.i(oVar, callerFrame, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            o oVar2 = (o) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
