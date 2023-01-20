package com.jihuanshe.ui.page.detail;

import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.detail.CardPackListViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.k.u;
import e.l.r.r;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.p;
import f.a.a.a;
import h.k2.v.n0;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class CardPackListActivity extends BaseActivity<CardPackListViewModel> {
    public static final /* synthetic */ n<Object>[] A;
    @a
    @e
    private String gameKey = "";
    @a
    @e
    private String gameSubKey = "";
    @d
    private final w n = z.c(new CardPackListActivity$game$2(this));
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.listView);
    @d
    private final h.m2.e p = BindViewKt.n(this, R.id.llBar);
    @a
    @e
    private PackDetailResult packInfo;
    @d
    private final g q;
    @d
    private final g r;
    @d
    private final w s;
    @d
    private final w t;
    @d
    private final w u;
    @d
    private final l v;
    @d
    private final p w;
    @d
    private final h.k2.u.l<Pair<String, String>, t1> x;
    @d
    private final h.k2.u.l<Boolean, t1> y;
    @d
    private final h.k2.u.l<List<Rarity>, t1> z;

    static {
        n<Object>[] nVarArr = new n[6];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(CardPackListActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(CardPackListActivity.class), "llBar", "getLlBar()Landroid/widget/LinearLayout;"));
        A = nVarArr;
    }

    public CardPackListActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.q = dVar.a(new CardPackListActivity$onClickNameCN$1(this));
        this.r = dVar.a(new CardPackListActivity$onClickNameOrigin$1(this));
        this.s = z.c(CardPackListActivity$adapter$2.INSTANCE);
        this.t = z.c(CardPackListActivity$layoutManager$2.INSTANCE);
        this.u = z.c(CardPackListActivity$decoration$2.INSTANCE);
        this.v = d.e.a.a(new CardPackListActivity$onItemClick$1(this));
        this.w = d.g.a.a(new CardPackListActivity$onLoadMore$1(this));
        this.x = new CardPackListActivity$chooseFilter$1(this);
        this.y = new CardPackListActivity$showState$1(this);
        this.z = new CardPackListActivity$onFilterRarity$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout f0() {
        return (LinearLayout) this.p.a(this, A[2]);
    }

    private final void n0() {
        ((CardPackListViewModel) L()).n().f(this, new CardPackListActivity$initObserver$1(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        Integer id;
        Game a0 = a0();
        if (a0 == null) {
            return;
        }
        r rVar = r.a;
        String M = M();
        String shortName = a0.getShortName();
        PackDetailResult l0 = l0();
        String nameCN = l0 == null ? null : l0.getNameCN();
        PackDetailResult l02 = l0();
        String number = l02 == null ? null : l02.getNumber();
        PackDetailResult l03 = l0();
        String releasedAt = l03 == null ? null : l03.getReleasedAt();
        PackDetailResult l04 = l0();
        rVar.k(M, shortName, nameCN, number, releasedAt, l04 == null ? null : l04.getCardVersionCount());
        CardPackListViewModel cardPackListViewModel = (CardPackListViewModel) L();
        PackDetailResult l05 = l0();
        BinderKt.p(BinderKt.e(e.g.d.a.j(CardPackListViewModel.r0(cardPackListViewModel, a0, (l05 == null || (id = l05.getId()) == null) ? 0 : id.intValue(), null, false, 12, null), null, new CardPackListActivity$onRetryClick$1$1(this), 1, null), this, e0(), false, 4, null));
    }

    @k.e.a.d
    public final e.l.g.g X() {
        return (e.l.g.g) this.s.getValue();
    }

    @k.e.a.d
    public final h.k2.u.l<Pair<String, String>, t1> Y() {
        return this.x;
    }

    @k.e.a.d
    public final e.l.h.j.b.f.a Z() {
        return (e.l.h.j.b.f.a) this.u.getValue();
    }

    @e
    public final Game a0() {
        return (Game) this.n.getValue();
    }

    @e
    public final String b0() {
        return this.gameKey;
    }

    @e
    public final String c0() {
        return this.gameSubKey;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        ((CardPackListViewModel) L()).v(-1);
        n0();
        F();
    }

    @k.e.a.d
    public final LayoutManagers.a d0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final ListView e0() {
        return (ListView) this.o.a(this, A[1]);
    }

    @k.e.a.d
    public final g g0() {
        return this.q;
    }

    @k.e.a.d
    public final g h0() {
        return this.r;
    }

    @k.e.a.d
    public final h.k2.u.l<List<Rarity>, t1> i0() {
        return this.z;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
    }

    @k.e.a.d
    public final l j0() {
        return this.v;
    }

    @k.e.a.d
    public final p k0() {
        return this.w;
    }

    @e
    public final PackDetailResult l0() {
        return this.packInfo;
    }

    @k.e.a.d
    public final h.k2.u.l<Boolean, t1> m0() {
        return this.y;
    }

    @k.e.a.d
    public final g o0(@k.e.a.d NImageView nImageView) {
        return e.t.j.h.d.a.a(new CardPackListActivity$onClickPreview$1(this, nImageView));
    }

    public final void p0(@e String str) {
        this.gameKey = str;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        u e2 = u.e(getLayoutInflater());
        e2.i(this);
        e2.j((CardPackListViewModel) L());
        return e2;
    }

    public final void q0(@e String str) {
        this.gameSubKey = str;
    }

    public final void r0(@e PackDetailResult packDetailResult) {
        this.packInfo = packDetailResult;
    }
}
