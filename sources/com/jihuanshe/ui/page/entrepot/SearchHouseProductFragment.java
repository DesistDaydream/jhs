package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.entrepot.SearchHouseProductViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.u0;
import e.l.k.s7;
import e.l.s.m.c;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.l;
import e.t.j.h.p;
import f.a.a.a;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SearchHouseProductFragment extends BaseFragment<SearchHouseProductViewModel> {
    public static final /* synthetic */ n<Object>[] y;
    @a
    private int uid = Constants.Companion.getWAREHOUSE_SELLER_USER_ID();
    @d
    private final w r = z.c(new SearchHouseProductFragment$parentViewModel$2(this));
    @d
    private final e s = BindViewKt.s(this, R.id.listView);
    @d
    private final w t = z.c(SearchHouseProductFragment$layoutManager$2.INSTANCE);
    @d
    private final w u = z.c(SearchHouseProductFragment$decoration$2.INSTANCE);
    @d
    private final w v = z.c(SearchHouseProductFragment$adapter$2.INSTANCE);
    @d
    private final l w = d.e.a.a(new SearchHouseProductFragment$onItemClick$1(this));
    @k.e.a.d
    private final p x = d.g.a.a(new SearchHouseProductFragment$onLoadMore$1(this));

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SearchHouseProductFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        y = nVarArr;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        SearchHouseProductViewModel searchHouseProductViewModel = (SearchHouseProductViewModel) T();
        int i2 = this.uid;
        String value = k0().s0().getValue();
        GameBar.a aVar = GameBar.b;
        Game value2 = aVar.a().getValue();
        String gameKey = value2 == null ? null : value2.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        Game value3 = aVar.a().getValue();
        String gameSubKey = value3 != null ? value3.getGameSubKey() : null;
        if (gameSubKey == null) {
            gameSubKey = "";
        }
        BinderKt.o(SearchHouseProductViewModel.s0(searchHouseProductViewModel, i2, value, gameKey, gameSubKey, null, 16, null), this);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        f.g(k0().s0(), null, new SearchHouseProductFragment$flowOfSetup$1(this), 1, null);
    }

    @k.e.a.d
    public final u0 e0() {
        return (u0) this.v.getValue();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.a f0() {
        return (e.l.h.j.b.f.a) this.u.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a g0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final ListView h0() {
        return (ListView) this.s.a(this, y[1]);
    }

    @k.e.a.d
    public final l i0() {
        return this.w;
    }

    @k.e.a.d
    public final p j0() {
        return this.x;
    }

    @k.e.a.d
    public final c k0() {
        return (c) this.r.getValue();
    }

    public final int l0() {
        return this.uid;
    }

    public final void m0(int i2) {
        this.uid = i2;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        s7 e2 = s7.e(getLayoutInflater());
        e2.i(this);
        e2.j((SearchHouseProductViewModel) T());
        return e2;
    }
}
