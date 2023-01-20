package kotlinx.coroutines.flow;

import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.q;
import h.t1;
import i.b.v3.f;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {181, 183, 185, 186, 188}, m = "invokeSuspend", n = {"$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Li/b/v3/f;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "count", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class StartedWhileSubscribed$command$1 extends SuspendLambda implements q<f<? super SharingCommand>, Integer, c<? super t1>, Object> {
    public int I$0;
    public Object L$0;
    public int label;
    private f p$;
    private int p$0;
    public final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, c cVar) {
        super(3, cVar);
        this.this$0 = startedWhileSubscribed;
    }

    @k.e.a.d
    public final c<t1> create(@k.e.a.d f<? super SharingCommand> fVar, int i2, @k.e.a.d c<? super t1> cVar) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, cVar);
        startedWhileSubscribed$command$1.p$ = fVar;
        startedWhileSubscribed$command$1.p$0 = i2;
        return startedWhileSubscribed$command$1;
    }

    @Override // h.k2.u.q
    public final Object invoke(f<? super SharingCommand> fVar, Integer num, c<? super t1> cVar) {
        return ((StartedWhileSubscribed$command$1) create(fVar, num.intValue(), cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r10.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L47
            if (r1 == r6) goto L3f
            if (r1 == r5) goto L35
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            goto L3f
        L18:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L20:
            int r1 = r10.I$0
            java.lang.Object r3 = r10.L$0
            i.b.v3.f r3 = (i.b.v3.f) r3
            h.r0.n(r11)
            goto La3
        L2b:
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$0
            i.b.v3.f r4 = (i.b.v3.f) r4
            h.r0.n(r11)
            goto L8f
        L35:
            int r1 = r10.I$0
            java.lang.Object r5 = r10.L$0
            i.b.v3.f r5 = (i.b.v3.f) r5
            h.r0.n(r11)
            goto L73
        L3f:
            java.lang.Object r0 = r10.L$0
            i.b.v3.f r0 = (i.b.v3.f) r0
            h.r0.n(r11)
            goto Lb3
        L47:
            h.r0.n(r11)
            i.b.v3.f r11 = r10.p$
            int r1 = r10.p$0
            if (r1 <= 0) goto L5f
            kotlinx.coroutines.flow.SharingCommand r2 = kotlinx.coroutines.flow.SharingCommand.START
            r10.L$0 = r11
            r10.I$0 = r1
            r10.label = r6
            java.lang.Object r11 = r11.emit(r2, r10)
            if (r11 != r0) goto Lb3
            return r0
        L5f:
            kotlinx.coroutines.flow.StartedWhileSubscribed r6 = r10.this$0
            long r6 = kotlinx.coroutines.flow.StartedWhileSubscribed.c(r6)
            r10.L$0 = r11
            r10.I$0 = r1
            r10.label = r5
            java.lang.Object r5 = i.b.w0.b(r6, r10)
            if (r5 != r0) goto L72
            return r0
        L72:
            r5 = r11
        L73:
            kotlinx.coroutines.flow.StartedWhileSubscribed r11 = r10.this$0
            long r6 = kotlinx.coroutines.flow.StartedWhileSubscribed.b(r11)
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto La4
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP
            r10.L$0 = r5
            r10.I$0 = r1
            r10.label = r4
            java.lang.Object r11 = r5.emit(r11, r10)
            if (r11 != r0) goto L8e
            return r0
        L8e:
            r4 = r5
        L8f:
            kotlinx.coroutines.flow.StartedWhileSubscribed r11 = r10.this$0
            long r5 = kotlinx.coroutines.flow.StartedWhileSubscribed.b(r11)
            r10.L$0 = r4
            r10.I$0 = r1
            r10.label = r3
            java.lang.Object r11 = i.b.w0.b(r5, r10)
            if (r11 != r0) goto La2
            return r0
        La2:
            r3 = r4
        La3:
            r5 = r3
        La4:
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r10.L$0 = r5
            r10.I$0 = r1
            r10.label = r2
            java.lang.Object r11 = r5.emit(r11, r10)
            if (r11 != r0) goto Lb3
            return r0
        Lb3:
            h.t1 r11 = h.t1.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
