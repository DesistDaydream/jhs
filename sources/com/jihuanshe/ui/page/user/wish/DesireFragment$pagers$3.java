package com.jihuanshe.ui.page.user.wish;

import com.jihuanshe.model.Constants;
import h.k2.u.l;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class DesireFragment$pagers$3 extends Lambda implements l<Integer, WishListFragment> {
    public final /* synthetic */ DesireFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesireFragment$pagers$3(DesireFragment desireFragment) {
        super(1);
        this.this$0 = desireFragment;
    }

    public final WishListFragment invoke(int i2) {
        return WishListFragmentCreator.create(Constants.Companion.getSEARCH_TYPE_PACK(), 2).search(Boolean.valueOf(this.this$0.i0())).get();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ WishListFragment invoke(Integer num) {
        return invoke(num.intValue());
    }
}
