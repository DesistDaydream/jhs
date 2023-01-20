package com.jihuanshe.ui.page.user.wish;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ext.AppbarKt;
import com.jihuanshe.ui.BaseActivity;
import e.l.h.l.b;
import e.l.k.e3;
import inject.annotation.creator.Creator;
import k.e.a.d;

@Creator
/* loaded from: classes2.dex */
public final class WishListActivity extends BaseActivity<b> {
    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(WishListActivity$flowOfAppBar$1.INSTANCE);
        AppbarKt.d(w(), 0, new WishListActivity$flowOfAppBar$2(this), 1, null);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        return e3.c(getLayoutInflater());
    }
}
