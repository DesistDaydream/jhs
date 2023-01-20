package com.vector.view;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.t1;
import i.b.n0;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "com.vector.view.CaptchaView$start$1", f = "CaptchaView.kt", i = {0}, l = {42}, m = "invokeSuspend", n = {AdvanceSetting.NETWORK_TYPE}, s = {"I$2"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CaptchaView$start$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public int I$0;
    public int I$1;
    public int I$2;
    public Object L$0;
    public int label;
    public final /* synthetic */ CaptchaView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaView$start$1(CaptchaView captchaView, c<? super CaptchaView$start$1> cVar) {
        super(2, cVar);
        this.this$0 = captchaView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        return new CaptchaView$start$1(this.this$0, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d n0 n0Var, @e c<? super t1> cVar) {
        return ((CaptchaView$start$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005a -> B:14:0x005e). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r11.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 != r3) goto L1c
            int r1 = r11.I$2
            int r2 = r11.I$1
            int r4 = r11.I$0
            java.lang.Object r5 = r11.L$0
            com.vector.view.CaptchaView r5 = (com.vector.view.CaptchaView) r5
            h.r0.n(r12)
            r12 = r2
            r2 = r11
            goto L5e
        L1c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L24:
            h.r0.n(r12)
            com.vector.view.CaptchaView r12 = r11.this$0
            r12.setEnabled(r2)
            com.vector.view.CaptchaView r12 = r11.this$0
            int r12 = com.vector.view.CaptchaView.e(r12)
            int r12 = r12 + r3
            com.vector.view.CaptchaView r1 = r11.this$0
            r5 = r1
            r1 = r11
        L37:
            if (r2 >= r12) goto L7c
            java.lang.Integer r4 = h.e2.k.a.a.f(r2)
            int r4 = r4.intValue()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
            r7 = 1
            long r6 = r6.toMillis(r7)
            r1.L$0 = r5
            r1.I$0 = r2
            r1.I$1 = r12
            r1.I$2 = r4
            r1.label = r3
            java.lang.Object r6 = i.b.w0.b(r6, r1)
            if (r6 != r0) goto L5a
            return r0
        L5a:
            r10 = r2
            r2 = r1
            r1 = r4
            r4 = r10
        L5e:
            int r6 = com.vector.view.CaptchaView.e(r5)
            long r6 = (long) r6
            long r8 = (long) r1
            long r6 = r6 - r8
            h.k2.u.l r1 = r5.getSecondText()
            java.lang.Long r6 = h.e2.k.a.a.g(r6)
            java.lang.Object r1 = r1.invoke(r6)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
            int r1 = r4 + 1
            r10 = r2
            r2 = r1
            r1 = r10
            goto L37
        L7c:
            com.vector.view.CaptchaView r12 = r1.this$0
            r12.setEnabled(r3)
            com.vector.view.CaptchaView r12 = r1.this$0
            java.lang.String r0 = com.vector.view.CaptchaView.f(r12)
            r12.setText(r0)
            h.t1 r12 = h.t1.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vector.view.CaptchaView$start$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
