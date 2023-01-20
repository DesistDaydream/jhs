package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.entrepot.StorehouseViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.util.Res;
import e.l.k.m1;
import e.t.j.h.g;
import h.k2.v.u;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class StorehouseActivity extends BaseActivity<StorehouseViewModel> {
    @d
    public static final a q = new a(null);
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    @d
    public static final String u = "FRAGMENT_CHECK";
    @d
    public static final String v = "FRAGMENT_HOUSE";
    @d
    public static final String w = "FRAGMENT_OUT";
    @f.a.a.a
    @e
    private Integer inType;
    @d
    private final w n = z.c(new StorehouseActivity$adapter$2(this));
    @d
    private final g o;
    @d
    private final g p;

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
            Integer a0 = StorehouseActivity.this.a0();
            return new StorehouseViewModel(a0 == null ? 1 : a0.intValue());
        }
    }

    public StorehouseActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.o = dVar.a(new StorehouseActivity$applyForReturnOnClick$1(this));
        this.p = dVar.a(new StorehouseActivity$applyForOnClick$1(this));
    }

    @Override // com.vector.design.ui.activity.ActivityEx
    @e
    /* renamed from: W */
    public StorehouseViewModel K() {
        return (StorehouseViewModel) new ViewModelProvider(this, new b()).get(StorehouseViewModel.class);
    }

    @d
    public final FragPagerAdapter X() {
        return (FragPagerAdapter) this.n.getValue();
    }

    @d
    public final g Y() {
        return this.p;
    }

    @d
    public final g Z() {
        return this.o;
    }

    @e
    public final Integer a0() {
        return this.inType;
    }

    public final void b0(@e Integer num) {
        this.inType = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundColor(Res.k(R.color.white));
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(StorehouseActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        m1 e2 = m1.e(getLayoutInflater());
        e2.i(this);
        e2.j((StorehouseViewModel) L());
        return e2;
    }
}
