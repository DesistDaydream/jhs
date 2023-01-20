package com.jihuanshe.ui.page.user.wish;

import com.jihuanshe.ui.page.search.SearchActivityCreator;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListActivity$flowOfAppBar$2 extends Lambda implements a<t1> {
    public final /* synthetic */ WishListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListActivity$flowOfAppBar$2(WishListActivity wishListActivity) {
        super(0);
        this.this$0 = wishListActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SearchActivityCreator.create(10).start(this.this$0);
    }
}
