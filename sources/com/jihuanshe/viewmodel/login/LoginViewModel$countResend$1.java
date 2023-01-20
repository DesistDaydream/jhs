package com.jihuanshe.viewmodel.login;

import h.e2.c;
import h.k2.u.p;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class LoginViewModel$countResend$1 extends SuspendLambda implements p<f<? super Integer>, c<? super t1>, Object> {
    public int I$0;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ LoginViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$countResend$1(LoginViewModel loginViewModel, c<? super LoginViewModel$countResend$1> cVar) {
        super(2, cVar);
        this.this$0 = loginViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        LoginViewModel$countResend$1 loginViewModel$countResend$1 = new LoginViewModel$countResend$1(this.this$0, cVar);
        loginViewModel$countResend$1.L$0 = obj;
        return loginViewModel$countResend$1;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d f<? super Integer> fVar, @e c<? super t1> cVar) {
        return ((LoginViewModel$countResend$1) create(fVar, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (r1 < 0) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005e -> B:20:0x0061). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            int r1 = r7.I$0
            java.lang.Object r4 = r7.L$0
            i.b.v3.f r4 = (i.b.v3.f) r4
            h.r0.n(r8)
            r8 = r4
            r4 = r7
            goto L61
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L22:
            int r1 = r7.I$0
            java.lang.Object r4 = r7.L$0
            i.b.v3.f r4 = (i.b.v3.f) r4
            h.r0.n(r8)
            r8 = r4
            r4 = r7
            goto L52
        L2e:
            h.r0.n(r8)
            java.lang.Object r8 = r7.L$0
            i.b.v3.f r8 = (i.b.v3.f) r8
            com.jihuanshe.viewmodel.login.LoginViewModel r1 = r7.this$0
            int r1 = com.jihuanshe.viewmodel.login.LoginViewModel.z0(r1)
            if (r1 < 0) goto L63
            r4 = r7
        L3e:
            int r5 = r1 + (-1)
            java.lang.Integer r1 = h.e2.k.a.a.f(r1)
            r4.L$0 = r8
            r4.I$0 = r5
            r4.label = r3
            java.lang.Object r1 = r8.emit(r1, r4)
            if (r1 != r0) goto L51
            return r0
        L51:
            r1 = r5
        L52:
            r5 = 1000(0x3e8, double:4.94E-321)
            r4.L$0 = r8
            r4.I$0 = r1
            r4.label = r2
            java.lang.Object r5 = i.b.w0.b(r5, r4)
            if (r5 != r0) goto L61
            return r0
        L61:
            if (r1 >= 0) goto L3e
        L63:
            h.t1 r8 = h.t1.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.login.LoginViewModel$countResend$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
