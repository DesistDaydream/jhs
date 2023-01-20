package com.jihuanshe.ui.widget;

import h.e2.c;
import h.k2.u.p;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class CountDownTextView$start$1 extends SuspendLambda implements p<f<? super Integer>, c<? super t1>, Object> {
    public int I$0;
    public int I$1;
    private /* synthetic */ Object L$0;
    public int label;

    public CountDownTextView$start$1(c<? super CountDownTextView$start$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        CountDownTextView$start$1 countDownTextView$start$1 = new CountDownTextView$start$1(cVar);
        countDownTextView$start$1.L$0 = obj;
        return countDownTextView$start$1;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d f<? super Integer> fVar, @e c<? super t1> cVar) {
        return ((CountDownTextView$start$1) create(fVar, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0060 -> B:19:0x0062). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            int r1 = r9.I$0
            java.lang.Object r4 = r9.L$0
            i.b.v3.f r4 = (i.b.v3.f) r4
            h.r0.n(r10)
            r10 = r4
            r4 = r9
            goto L62
        L1a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L22:
            int r1 = r9.I$1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$0
            i.b.v3.f r5 = (i.b.v3.f) r5
            h.r0.n(r10)
            r10 = r5
            r5 = r9
            goto L4f
        L30:
            h.r0.n(r10)
            java.lang.Object r10 = r9.L$0
            i.b.v3.f r10 = (i.b.v3.f) r10
            r1 = 4
            r4 = r9
        L39:
            int r5 = r1 + (-1)
            r6 = 1000(0x3e8, double:4.94E-321)
            r4.L$0 = r10
            r4.I$0 = r5
            r4.I$1 = r1
            r4.label = r3
            java.lang.Object r6 = i.b.w0.b(r6, r4)
            if (r6 != r0) goto L4c
            return r0
        L4c:
            r8 = r5
            r5 = r4
            r4 = r8
        L4f:
            java.lang.Integer r1 = h.e2.k.a.a.f(r1)
            r5.L$0 = r10
            r5.I$0 = r4
            r5.label = r2
            java.lang.Object r1 = r10.emit(r1, r5)
            if (r1 != r0) goto L60
            return r0
        L60:
            r1 = r4
            r4 = r5
        L62:
            if (r1 >= 0) goto L39
            h.t1 r10 = h.t1.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.widget.CountDownTextView$start$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
