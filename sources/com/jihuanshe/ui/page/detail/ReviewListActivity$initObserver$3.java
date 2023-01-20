package com.jihuanshe.ui.page.detail;

import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$initObserver$3 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$initObserver$3(ReviewListActivity reviewListActivity) {
        super(1);
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        if (this.this$0.J0()) {
            this.this$0.b1(false);
        } else {
            this.this$0.F();
        }
    }
}
