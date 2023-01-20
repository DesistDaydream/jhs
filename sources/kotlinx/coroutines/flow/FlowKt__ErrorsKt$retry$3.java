package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.k2.u.r;
import h.t1;
import i.b.v3.f;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {0, 0, 0}, l = {124}, m = "invokeSuspend", n = {"$this$retryWhen", "cause", "attempt"}, s = {"L$0", "L$1", "J$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements r<f<? super T>, Throwable, Long, c<? super Boolean>, Object> {
    public final /* synthetic */ p $predicate;
    public final /* synthetic */ long $retries;
    public long J$0;
    public Object L$0;
    public Object L$1;
    public int label;
    private f p$;
    private Throwable p$0;
    private long p$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$retry$3(long j2, p pVar, c cVar) {
        super(4, cVar);
        this.$retries = j2;
        this.$predicate = pVar;
    }

    @k.e.a.d
    public final c<t1> create(@k.e.a.d f<? super T> fVar, @k.e.a.d Throwable th, long j2, @k.e.a.d c<? super Boolean> cVar) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, cVar);
        flowKt__ErrorsKt$retry$3.p$ = fVar;
        flowKt__ErrorsKt$retry$3.p$0 = th;
        flowKt__ErrorsKt$retry$3.p$1 = j2;
        return flowKt__ErrorsKt$retry$3;
    }

    @Override // h.k2.u.r
    public final Object invoke(Object obj, Throwable th, Long l2, c<? super Boolean> cVar) {
        return ((FlowKt__ErrorsKt$retry$3) create((f) obj, th, l2.longValue(), cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (((java.lang.Boolean) r9).booleanValue() != false) goto L8;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r8.L$1
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r0 = r8.L$0
            i.b.v3.f r0 = (i.b.v3.f) r0
            h.r0.n(r9)
            goto L3f
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            h.r0.n(r9)
            i.b.v3.f r9 = r8.p$
            java.lang.Throwable r1 = r8.p$0
            long r3 = r8.p$1
            long r5 = r8.$retries
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L48
            h.k2.u.p r5 = r8.$predicate
            r8.L$0 = r9
            r8.L$1 = r1
            r8.J$0 = r3
            r8.label = r2
            java.lang.Object r9 = r5.invoke(r1, r8)
            if (r9 != r0) goto L3f
            return r0
        L3f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L48
            goto L49
        L48:
            r2 = 0
        L49:
            java.lang.Boolean r9 = h.e2.k.a.a.a(r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
