package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.t3.w;
import i.b.v3.c0.n;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", i = {0, 0}, l = {352}, m = "invokeSuspend", n = {"$this$produce", "$this$collect$iv"}, s = {"L$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/t3/w;", "", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements p<w<? super Object>, c<? super t1>, Object> {
    public Object L$0;
    public Object L$1;
    public int label;
    private w p$;
    public final /* synthetic */ FlowKt__DelayKt$debounceInternal$1 this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$values$1$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements f<T> {
        public final /* synthetic */ w a;

        public a(w wVar) {
            this.a = wVar;
        }

        @Override // i.b.v3.f
        @e
        public Object emit(Object obj, @k.e.a.d c cVar) {
            w wVar = this.a;
            if (obj == null) {
                obj = n.a;
            }
            Object N = wVar.N(obj, cVar);
            return N == b.h() ? N : t1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$values$1(FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1, c cVar) {
        super(2, cVar);
        this.this$0 = flowKt__DelayKt$debounceInternal$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__DelayKt$debounceInternal$1$values$1 flowKt__DelayKt$debounceInternal$1$values$1 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.this$0, cVar);
        flowKt__DelayKt$debounceInternal$1$values$1.p$ = (w) obj;
        return flowKt__DelayKt$debounceInternal$1$values$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(w<? super Object> wVar, c<? super t1> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$values$1) create(wVar, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            w wVar = this.p$;
            Flow flow = this.this$0.$this_debounceInternal;
            a aVar = new a(wVar);
            this.L$0 = wVar;
            this.L$1 = flow;
            this.label = 1;
            if (flow.e(aVar, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Flow flow2 = (Flow) this.L$1;
            w wVar2 = (w) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
