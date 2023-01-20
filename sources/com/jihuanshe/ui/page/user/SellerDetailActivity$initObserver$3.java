package com.jihuanshe.ui.page.user;

import android.view.ViewGroup;
import com.google.android.material.appbar.AppBarLayout;
import com.jihuanshe.model.GameCard;
import h.k2.u.l;
import h.t1;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$initObserver$3 extends Lambda implements l<List<? extends GameCard>, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$initObserver$3(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends GameCard> list) {
        invoke2(list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<? extends GameCard> list) {
        if (!list.isEmpty()) {
            ViewGroup.LayoutParams layoutParams = this.this$0.F0().getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
            AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
            layoutParams2.d(3);
            this.this$0.F0().setLayoutParams(layoutParams2);
            this.this$0.E0().setNestedScrollingEnabled(true);
        }
    }
}
