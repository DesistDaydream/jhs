package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.o.a.a.a;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onFilterItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onFilterItemClick$1(SellerDetailActivity sellerDetailActivity) {
        super(2);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        GameBar.b.a().setValue(a.a.e().get(i2));
        i.b(f.b, e.l.j.a.f12234d, null, 2, null);
        ((SellerDetailViewModel) this.this$0.L()).U0().setValue(Boolean.FALSE);
    }
}
