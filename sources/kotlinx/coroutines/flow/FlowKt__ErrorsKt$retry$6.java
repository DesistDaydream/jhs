package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.a;
import h.e2.k.a.d;
import h.k2.u.l;
import h.k2.u.r;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ErrorsKt$retry$6 extends SuspendLambda implements r<f<? super T>, Throwable, Long, c<? super Boolean>, Object> {
    public final /* synthetic */ l $predicate;
    public final /* synthetic */ int $retries;
    public int label;
    private f p$;
    private Throwable p$0;
    private long p$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$retry$6(int i2, l lVar, c cVar) {
        super(4, cVar);
        this.$retries = i2;
        this.$predicate = lVar;
    }

    @k.e.a.d
    public final c<t1> create(@k.e.a.d f<? super T> fVar, @k.e.a.d Throwable th, long j2, @k.e.a.d c<? super Boolean> cVar) {
        FlowKt__ErrorsKt$retry$6 flowKt__ErrorsKt$retry$6 = new FlowKt__ErrorsKt$retry$6(this.$retries, this.$predicate, cVar);
        flowKt__ErrorsKt$retry$6.p$ = fVar;
        flowKt__ErrorsKt$retry$6.p$0 = th;
        flowKt__ErrorsKt$retry$6.p$1 = j2;
        return flowKt__ErrorsKt$retry$6;
    }

    @Override // h.k2.u.r
    public final Object invoke(Object obj, Throwable th, Long l2, c<? super Boolean> cVar) {
        return ((FlowKt__ErrorsKt$retry$6) create((f) obj, th, l2.longValue(), cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            return a.a(((Boolean) this.$predicate.invoke(this.p$0)).booleanValue() && this.p$1 < ((long) this.$retries));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
