package com.jihuanshe.ui.page.user.wish;

import android.view.View;
import com.jihuanshe.model.Product;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import h.k2.u.l;
import h.r0;
import h.t1;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListFragment$onClickOp$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ WishListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListFragment$onClickOp$1(WishListFragment wishListFragment) {
        super(1);
        this.this$0 = wishListFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        WishListFragment wishListFragment = this.this$0;
        try {
            Result.a aVar = Result.Companion;
            Object tag = view.getTag(view.getId());
            if (tag instanceof Product) {
                ((WishListViewModel) wishListFragment.T()).v0(wishListFragment.requireActivity(), (Product) tag, new WishListFragment$onClickOp$1$1$1(wishListFragment, tag));
            }
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }
}
