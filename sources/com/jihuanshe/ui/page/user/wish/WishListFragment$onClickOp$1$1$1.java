package com.jihuanshe.ui.page.user.wish;

import com.jihuanshe.model.Product;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import h.k2.u.a;
import h.t1;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListFragment$onClickOp$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ Object $item;
    public final /* synthetic */ WishListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListFragment$onClickOp$1$1$1(WishListFragment wishListFragment, Object obj) {
        super(0);
        this.this$0 = wishListFragment;
        this.$item = obj;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List<Product> value = ((WishListViewModel) this.this$0.T()).r0().getValue();
        int indexOf = value == null ? -1 : value.indexOf(this.$item);
        if (indexOf < 0) {
            this.this$0.g0().notifyDataSetChanged();
        } else {
            this.this$0.g0().notifyItemChanged(indexOf);
        }
    }
}
