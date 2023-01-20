package com.jihuanshe.ui.page.user;

import android.view.View;
import com.vector.ext.view.ViewKt;
import e.l.q.a.k0.r;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$initObserver$5 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$initObserver$5(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        View X0;
        e.l.q.a.k0.l q0;
        r Y0;
        View X02;
        Runnable runnable;
        View X03;
        Runnable runnable2;
        e.l.q.a.k0.l q02;
        e.l.q.a.k0.l q03;
        r Y02;
        View X04;
        r Y03;
        if (z) {
            q02 = this.this$0.q0();
            q02.e();
            q03 = this.this$0.q0();
            q03.b();
            Y02 = this.this$0.Y0();
            Y02.e();
            X04 = this.this$0.X0();
            ViewKt.I(X04);
            Y03 = this.this$0.Y0();
            Y03.b();
            return;
        }
        X0 = this.this$0.X0();
        if (ViewKt.r(X0)) {
            q0 = this.this$0.q0();
            q0.a();
            Y0 = this.this$0.Y0();
            Y0.a();
            X02 = this.this$0.X0();
            runnable = this.this$0.J;
            X02.removeCallbacks(runnable);
            X03 = this.this$0.X0();
            runnable2 = this.this$0.J;
            X03.postDelayed(runnable2, 200L);
        }
    }
}
