package com.jihuanshe.ui.page.shop;

import androidx.lifecycle.ViewModelProvider;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarActivity$wishViewModel$2 extends Lambda implements a<WishListViewModel> {
    public final /* synthetic */ SellCalendarActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarActivity$wishViewModel$2(SellCalendarActivity sellCalendarActivity) {
        super(0);
        this.this$0 = sellCalendarActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final WishListViewModel invoke() {
        return (WishListViewModel) new ViewModelProvider(this.this$0).get(WishListViewModel.class);
    }
}
