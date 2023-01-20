package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.t3.w;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ProduceKt;

@d(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowViaChannel$1", f = "Builders.kt", i = {0}, l = {216}, m = "invokeSuspend", n = {"$this$channelFlow"}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/t3/w;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__BuildersKt$flowViaChannel$1 extends SuspendLambda implements p<w<? super T>, c<? super t1>, Object> {
    public final /* synthetic */ p $block;
    public Object L$0;
    public int label;
    private w p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__BuildersKt$flowViaChannel$1(p pVar, c cVar) {
        super(2, cVar);
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__BuildersKt$flowViaChannel$1 flowKt__BuildersKt$flowViaChannel$1 = new FlowKt__BuildersKt$flowViaChannel$1(this.$block, cVar);
        flowKt__BuildersKt$flowViaChannel$1.p$ = (w) obj;
        return flowKt__BuildersKt$flowViaChannel$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((FlowKt__BuildersKt$flowViaChannel$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            w wVar = this.p$;
            this.$block.invoke(wVar, wVar.getChannel());
            this.L$0 = wVar;
            this.label = 1;
            if (ProduceKt.b(wVar, null, this, 1, null) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            w wVar2 = (w) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
