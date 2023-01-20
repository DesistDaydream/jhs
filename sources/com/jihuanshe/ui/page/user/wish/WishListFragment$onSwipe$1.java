package com.jihuanshe.ui.page.user.wish;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import e.t.v.j.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListFragment$onSwipe$1 extends Lambda implements l<g<?>, t1> {
    public final /* synthetic */ WishListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListFragment$onSwipe$1(WishListFragment wishListFragment) {
        super(1);
        this.this$0 = wishListFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar) {
        invoke2(gVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar) {
        BinderKt.e(WishListViewModel.u0((WishListViewModel) this.this$0.T(), this.this$0.getType(), this.this$0.j0(), null, 4, null), this.this$0, gVar, false, 4, null);
    }
}
