package com.jihuanshe.ui.page.order;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ext.AppbarKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.order.OrderListViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.util.Res;
import e.l.k.s1;
import h.k2.v.f0;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class OrderListActivity extends BaseActivity<OrderListViewModel> {
    @f.a.a.a
    @e
    private Boolean seller = Boolean.FALSE;
    @d
    private final w n = z.c(new OrderListActivity$adapter$2(this));

    /* loaded from: classes2.dex */
    public static final class a implements ViewModelProvider.Factory {
        public a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@d Class<T> cls) {
            return new OrderListViewModel(f0.g(OrderListActivity.this.Y(), Boolean.TRUE));
        }
    }

    @Override // com.vector.design.ui.activity.ActivityEx
    @e
    /* renamed from: W */
    public OrderListViewModel K() {
        return (OrderListViewModel) new ViewModelProvider(this, new a()).get(OrderListViewModel.class);
    }

    @d
    public final FragPagerAdapter X() {
        return (FragPagerAdapter) this.n.getValue();
    }

    @e
    public final Boolean Y() {
        return this.seller;
    }

    public final void Z(@e Boolean bool) {
        this.seller = bool;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundColor(Res.k(R.color.white));
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(new OrderListActivity$flowOfAppBar$1(this));
        AppbarKt.d(w(), 0, new OrderListActivity$flowOfAppBar$2(this), 1, null);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        s1 e2 = s1.e(getLayoutInflater());
        e2.i(this);
        e2.j((OrderListViewModel) L());
        return e2;
    }
}
