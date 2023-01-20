package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.entrepot.SearchChildCheckViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.s0;
import e.l.h.j.b.f.b;
import e.l.k.o7;
import e.l.s.m.c;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.l;
import e.t.j.h.p;
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
public final class SearchChildCheckFragment extends BaseFragment<SearchChildCheckViewModel> {
    public static final /* synthetic */ n<Object>[] A;
    @d
    public static final String B = "waiting_audit";
    @d
    public static final String C = "on_sale";
    @d
    public static final String D = "not_listed";
    @d
    public static final a z;
    @f.a.a.a
    @d
    private String cardStatus = "";
    @d
    private final w r = z.c(new SearchChildCheckFragment$parentViewModel$2(this));
    @d
    private final e s = BindViewKt.s(this, R.id.listView);
    @d
    private final w t = z.c(SearchChildCheckFragment$layoutManager$2.INSTANCE);
    @d
    private final w u = z.c(SearchChildCheckFragment$decoration$2.INSTANCE);
    @d
    private final w v = z.c(new SearchChildCheckFragment$adapter$2(this));
    @d
    private final l w = d.e.a.a(new SearchChildCheckFragment$onItemClick$1(this));
    @k.e.a.d
    private final f0 x;
    @k.e.a.d
    private final p y;

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
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SearchChildCheckFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        A = nVarArr;
        z = new a(null);
    }

    public SearchChildCheckFragment() {
        d.g gVar = d.g.a;
        this.x = gVar.b(new SearchChildCheckFragment$onSwipe$1(this));
        this.y = gVar.a(new SearchChildCheckFragment$onLoadMore$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(Boolean bool, Float f2, int i2) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            if (f2 == null) {
                return;
            }
            e.g.d.a.j(((SearchChildCheckViewModel) T()).w0(i2, f2.floatValue()), null, new SearchChildCheckFragment$onSoldOrOffSold$1$1(this), 1, null);
        } else if (f2 == null) {
        } else {
            e.g.d.a.j(((SearchChildCheckViewModel) T()).v0(i2, f2.floatValue()), null, new SearchChildCheckFragment$onSoldOrOffSold$2$1(this), 1, null);
        }
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        e.g.d.a s0;
        s0 = ((SearchChildCheckViewModel) T()).s0(this.cardStatus, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : n0().s0().getValue(), (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
        BinderKt.o(s0, this);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        f.g(n0().s0(), null, new SearchChildCheckFragment$flowOfSetup$1(this), 1, null);
    }

    @k.e.a.d
    public final s0 f0() {
        return (s0) this.v.getValue();
    }

    @k.e.a.d
    public final String g0() {
        return this.cardStatus;
    }

    @k.e.a.d
    public final b h0() {
        return (b) this.u.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a i0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final ListView j0() {
        return (ListView) this.s.a(this, A[1]);
    }

    @k.e.a.d
    public final l k0() {
        return this.w;
    }

    @k.e.a.d
    public final p l0() {
        return this.y;
    }

    @k.e.a.d
    public final f0 m0() {
        return this.x;
    }

    @k.e.a.d
    public final c n0() {
        return (c) this.r.getValue();
    }

    public final void p0(@k.e.a.d String str) {
        this.cardStatus = str;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        o7 e2 = o7.e(getLayoutInflater());
        e2.i(this);
        e2.j((SearchChildCheckViewModel) T());
        return e2;
    }
}
