package com.jihuanshe.ui.page.shop;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ext.AppbarKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.shop.AddCardViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import e.l.g.b0;
import e.l.g.m0;
import e.l.h.j.b.f.b;
import e.l.k.g;
import e.t.j.h.d;
import e.t.j.h.l;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class AddCardActivity extends BaseActivity<AddCardViewModel> {
    @d
    public static final a u;
    public static final /* synthetic */ n<Object>[] v;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 3;
    @d
    private final l s;
    @d
    private final l t;
    @f.a.a.a
    private int type = -1;
    @f.a.a.a
    private int wid = -1;
    @d
    private final e n = BindViewKt.n(this, R.id.pack);
    @d
    private final w o = z.c(AddCardActivity$kindAdapter$2.INSTANCE);
    @d
    private final w p = z.c(AddCardActivity$packAdapter$2.INSTANCE);
    @d
    private final w q = z.c(AddCardActivity$layoutManager$2.INSTANCE);
    @d
    private final w r = z.c(AddCardActivity$decoration$2.INSTANCE);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(AddCardActivity.class), "listView", "getListView()Landroidx/recyclerview/widget/RecyclerView;"));
        v = nVarArr;
        u = new a(null);
    }

    public AddCardActivity() {
        d.e eVar = d.e.a;
        this.s = eVar.a(new AddCardActivity$onKindItemClick$1(this));
        this.t = eVar.a(new AddCardActivity$onPackItemClick$1(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        GameBar.a aVar = GameBar.b;
        if (aVar.a().getValue() == null) {
            e.l.h.j.b.e.b(this, R.string.error_network, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        } else {
            BinderKt.s(((AddCardViewModel) L()).q0(aVar.a().getValue()), this, false, false, 6, null);
        }
    }

    @k.e.a.d
    public final b W() {
        return (b) this.r.getValue();
    }

    @k.e.a.d
    public final b0 X() {
        return (b0) this.o.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Y() {
        return (LayoutManagers.a) this.q.getValue();
    }

    @k.e.a.d
    public final RecyclerView Z() {
        return (RecyclerView) this.n.a(this, v[0]);
    }

    @k.e.a.d
    public final l a0() {
        return this.s;
    }

    @k.e.a.d
    public final l b0() {
        return this.t;
    }

    @k.e.a.d
    public final m0 c0() {
        return (m0) this.p.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        F();
    }

    public final int d0() {
        return this.wid;
    }

    public final void e0(int i2) {
        this.type = i2;
    }

    public final void f0(int i2) {
        this.wid = i2;
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(AddCardActivity$flowOfAppBar$1.INSTANCE);
        AppbarKt.d(w(), 0, new AddCardActivity$flowOfAppBar$2(this), 1, null);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        g e2 = g.e(getLayoutInflater());
        e2.i(this);
        e2.j((AddCardViewModel) L());
        return e2;
    }
}
