package com.jihuanshe.ui.widget;

import h.e2.c;
import h.e2.j.b;
import h.k2.u.q;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class CountDownTextView$start$3 extends SuspendLambda implements q<f<? super Integer>, Throwable, c<? super t1>, Object> {
    public int label;
    public final /* synthetic */ CountDownTextView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTextView$start$3(CountDownTextView countDownTextView, c<? super CountDownTextView$start$3> cVar) {
        super(3, cVar);
        this.this$0 = countDownTextView;
    }

    @Override // h.k2.u.q
    @e
    public final Object invoke(@d f<? super Integer> fVar, @e Throwable th, @e c<? super t1> cVar) {
        return new CountDownTextView$start$3(this.this$0, cVar).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            this.this$0.performClick();
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
