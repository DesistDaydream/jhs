package kotlinx.coroutines;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.q2.o;
import h.t1;
import i.b.v;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@d(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {949, 951}, m = "invokeSuspend", n = {"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lh/q2/o;", "Li/b/v;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements p<o<? super v>, c<? super t1>, Object> {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    private o p$;
    public final /* synthetic */ JobSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, c cVar) {
        super(2, cVar);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, cVar);
        jobSupport$children$1.p$ = (o) obj;
        return jobSupport$children$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(o<? super v> oVar, c<? super t1> cVar) {
        return ((JobSupport$children$1) create(oVar, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0081 -> B:27:0x009d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009a -> B:27:0x009d). Please submit an issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            java.lang.Object r1 = r10.L$5
            i.b.u r1 = (i.b.u) r1
            java.lang.Object r1 = r10.L$4
            i.b.w3.s r1 = (i.b.w3.s) r1
            java.lang.Object r4 = r10.L$3
            i.b.w3.q r4 = (i.b.w3.q) r4
            java.lang.Object r5 = r10.L$2
            i.b.m2 r5 = (i.b.m2) r5
            java.lang.Object r6 = r10.L$1
            java.lang.Object r7 = r10.L$0
            h.q2.o r7 = (h.q2.o) r7
            h.r0.n(r11)
            r11 = r10
            goto L9d
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            java.lang.Object r0 = r10.L$0
            h.q2.o r0 = (h.q2.o) r0
            h.r0.n(r11)
            goto La2
        L3a:
            h.r0.n(r11)
            h.q2.o r11 = r10.p$
            kotlinx.coroutines.JobSupport r1 = r10.this$0
            java.lang.Object r1 = r1.z0()
            boolean r4 = r1 instanceof i.b.u
            if (r4 == 0) goto L5b
            r2 = r1
            i.b.u r2 = (i.b.u) r2
            i.b.v r2 = r2.f15846e
            r10.L$0 = r11
            r10.L$1 = r1
            r10.label = r3
            java.lang.Object r11 = r11.d(r2, r10)
            if (r11 != r0) goto La2
            return r0
        L5b:
            boolean r4 = r1 instanceof i.b.v1
            if (r4 == 0) goto La2
            r4 = r1
            i.b.v1 r4 = (i.b.v1) r4
            i.b.m2 r4 = r4.c()
            if (r4 == 0) goto La2
            java.lang.Object r5 = r4.U()
        */
        //  java.lang.String r6 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            java.util.Objects.requireNonNull(r5, r6)
            i.b.w3.s r5 = (i.b.w3.s) r5
            r7 = r11
            r6 = r1
            r1 = r5
            r11 = r10
            r5 = r4
        L78:
            boolean r8 = h.k2.v.f0.g(r1, r4)
            r8 = r8 ^ r3
            if (r8 == 0) goto La2
            boolean r8 = r1 instanceof i.b.u
            if (r8 == 0) goto L9d
            r8 = r1
            i.b.u r8 = (i.b.u) r8
            i.b.v r9 = r8.f15846e
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r5
            r11.L$3 = r4
            r11.L$4 = r1
            r11.L$5 = r8
            r11.label = r2
            java.lang.Object r8 = r7.d(r9, r11)
            if (r8 != r0) goto L9d
            return r0
        L9d:
            i.b.w3.s r1 = r1.V()
            goto L78
        La2:
            h.t1 r11 = h.t1.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
