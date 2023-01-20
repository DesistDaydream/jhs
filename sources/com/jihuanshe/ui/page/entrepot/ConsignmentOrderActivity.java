package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.util.Res;
import e.l.k.i0;
import e.t.j.h.g;
import h.k2.v.u;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class ConsignmentOrderActivity extends BaseActivity<ConsignmentOrderViewModel> {
    @d
    public static final a p = new a(null);
    public static final int q = 1;
    public static final int r = 2;
    @d
    private final w n = z.c(new ConsignmentOrderActivity$adapter$2(this));
    @d
    private final g o = e.t.j.h.d.a.a(new ConsignmentOrderActivity$onClickButton$1(this));
    @f.a.a.a
    @e
    private Integer typeOrder;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements ViewModelProvider.Factory {
        public b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@d Class<T> cls) {
            Integer Z = ConsignmentOrderActivity.this.Z();
            return new ConsignmentOrderViewModel(Z == null ? 1 : Z.intValue());
        }
    }

    @Override // com.vector.design.ui.activity.ActivityEx
    @e
    /* renamed from: W */
    public ConsignmentOrderViewModel K() {
        return (ConsignmentOrderViewModel) new ViewModelProvider(this, new b()).get(ConsignmentOrderViewModel.class);
    }

    @d
    public final FragPagerAdapter X() {
        return (FragPagerAdapter) this.n.getValue();
    }

    @d
    public final g Y() {
        return this.o;
    }

    @e
    public final Integer Z() {
        return this.typeOrder;
    }

    public final void a0(@e Integer num) {
        this.typeOrder = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundColor(Res.k(R.color.white));
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(new ConsignmentOrderActivity$flowOfAppBar$1(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        i0 e2 = i0.e(getLayoutInflater());
        e2.i(this);
        e2.j((ConsignmentOrderViewModel) L());
        return e2;
    }
}
