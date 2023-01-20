package com.jihuanshe.ui.widget;

import com.jihuanshe.R;
import com.vector.util.Res;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.a;
import h.k2.u.p;
import h.r0;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class CountDownTextView$start$2 extends SuspendLambda implements p<Integer, c<? super t1>, Object> {
    public /* synthetic */ int I$0;
    public int label;
    public final /* synthetic */ CountDownTextView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTextView$start$2(CountDownTextView countDownTextView, c<? super CountDownTextView$start$2> cVar) {
        super(2, cVar);
        this.this$0 = countDownTextView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        CountDownTextView$start$2 countDownTextView$start$2 = new CountDownTextView$start$2(this.this$0, cVar);
        countDownTextView$start$2.I$0 = ((Number) obj).intValue();
        return countDownTextView$start$2;
    }

    @e
    public final Object invoke(int i2, @e c<? super t1> cVar) {
        return ((CountDownTextView$start$2) create(Integer.valueOf(i2), cVar)).invokeSuspend(t1.a);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, c<? super t1> cVar) {
        return invoke(num.intValue(), cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            this.this$0.setText(Res.a.v(R.string.ad_count_down_text, a.f(this.I$0)));
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
