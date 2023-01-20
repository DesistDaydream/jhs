package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.a;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements p<n0, c<? super T>, Object> {
    public final /* synthetic */ a $block;
    public int label;
    private n0 p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterruptibleKt$runInterruptible$2(a aVar, c cVar) {
        super(2, cVar);
        this.$block = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.$block, cVar);
        interruptibleKt$runInterruptible$2.p$ = (n0) obj;
        return interruptibleKt$runInterruptible$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, Object obj) {
        return ((InterruptibleKt$runInterruptible$2) create(n0Var, (c) obj)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object d2;
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            d2 = InterruptibleKt.d(this.p$.getCoroutineContext(), this.$block);
            return d2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
