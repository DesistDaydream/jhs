package com.jihuanshe.ui.page.search.fragments.cardrepo;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.PendingProduct;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.ui.dialog.AddCardConsignmentDialog;
import com.jihuanshe.ui.dialog.SoldOutCardDialog;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel;
import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.j;
import e.l.h.j.b.f.b;
import e.l.k.m7;
import e.l.s.m.c;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.p;
import f.a.a.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class CardRepoSearchFragment extends BaseFragment<CardRepoSearchViewModel> {
    public static final /* synthetic */ n<Object>[] F;
    @e
    private f<PendingProduct> C;
    @e
    private Integer D;
    @a
    @e
    private CardPackage cardPackage;
    @a
    @e
    private Integer type;
    @a
    @e
    private Integer wid;
    @d
    private final h.m2.e r = BindViewKt.s(this, R.id.rarityBtn);
    @d
    private final l<List<Rarity>, t1> s = new CardRepoSearchFragment$onFilterRarity$1(this);
    @d
    private final w t = z.c(new CardRepoSearchFragment$parentViewModel$2(this));
    @d
    private final h.m2.e u = BindViewKt.s(this, R.id.listView);
    @d
    private final w v = z.c(new CardRepoSearchFragment$applyForViewModel$2(this));
    @d
    private final w w = z.c(new CardRepoSearchFragment$sellingViewModel$2(this));
    @d
    private final w x = z.c(CardRepoSearchFragment$adapter$2.INSTANCE);
    @d
    private final w y = z.c(CardRepoSearchFragment$layoutManager$2.INSTANCE);
    @d
    private final w z = z.c(CardRepoSearchFragment$decoration$2.INSTANCE);
    @d
    private final g A = e.t.j.h.d.a.a(new CardRepoSearchFragment$onClickSearch$1(this));
    @d
    private final p B = d.g.a.a(new CardRepoSearchFragment$onLoadMore$1(this));
    @k.e.a.d
    private final e.t.j.h.l E = d.e.a.a(new CardRepoSearchFragment$onItemClick$1(this));

    static {
        n<Object>[] nVarArr = new n[8];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(CardRepoSearchFragment.class), "rarityBtn", "getRarityBtn()Lcom/jihuanshe/ui/widget/RarityFilterBtn;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(CardRepoSearchFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        F = nVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(Boolean bool, WantCard wantCard, GameCard gameCard) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            BinderKt.p(BinderKt.j(e.g.d.a.j(y0().L0(wantCard), null, new CardRepoSearchFragment$onSoldOrOffSold$1(this, gameCard), 1, null), this, false, 2, null));
        } else {
            BinderKt.p(BinderKt.j(e.g.d.a.j(y0().M0(gameCard.getProductId()), null, new CardRepoSearchFragment$onSoldOrOffSold$2(this, gameCard), 1, null), this, false, 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0() {
        e.g.d.a e2;
        CardRepoSearchViewModel cardRepoSearchViewModel = (CardRepoSearchViewModel) T();
        Game value = GameBar.b.a().getValue();
        CardPackage cardPackage = this.cardPackage;
        String value2 = u0().s0().getValue();
        if (value2 == null) {
            value2 = "";
        }
        e.g.d.a u0 = CardRepoSearchViewModel.u0(cardRepoSearchViewModel, value, cardPackage, value2, null, 8, null);
        if (u0 == null || (e2 = BinderKt.e(u0, this, p0(), false, 4, null)) == null) {
            return;
        }
        BinderKt.j(e2, this, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(List<ApplyForItem> list) {
        if (this.C == null) {
            return;
        }
        for (ApplyForItem applyForItem : list) {
            Integer warehouseOrderProductId = applyForItem.getWarehouseOrderProductId();
            PendingProduct value = this.C.getValue();
            if (f0.g(warehouseOrderProductId, value == null ? null : Integer.valueOf(value.getWarehouseOrderProductId()))) {
                new AddCardConsignmentDialog(requireActivity(), l0().t0(applyForItem), applyForItem, null, null, null, true, new CardRepoSearchFragment$showAmendDialog$1(applyForItem, this), new CardRepoSearchFragment$showAmendDialog$2(this, applyForItem), null, 568, null).y();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(List<? extends GameCard> list) {
        List<GameCard> products;
        List<GameCard> products2;
        if (this.D == null) {
            return;
        }
        CardProductNew value = ((CardRepoSearchViewModel) T()).x0().getValue();
        if (((value == null || (products = value.getProducts()) == null) ? null : (GameCard) CollectionsKt___CollectionsKt.J2(products, this.D.intValue())) == null) {
            return;
        }
        for (GameCard gameCard : list) {
            Integer productId = gameCard.getProductId();
            CardProductNew value2 = ((CardRepoSearchViewModel) T()).x0().getValue();
            if (f0.g(productId, ((value2 == null || (products2 = value2.getProducts()) == null) ? null : (GameCard) CollectionsKt___CollectionsKt.J2(products2, this.D.intValue())).getProductId())) {
                gameCard.setGame(GameBar.b.a().getValue());
                new SoldOutCardDialog(requireActivity(), gameCard, true, new CardRepoSearchFragment$showOnSellAmendDialog$1(this, gameCard), new CardRepoSearchFragment$showOnSellAmendDialog$2(gameCard, this)).y();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c u0() {
        return (c) this.t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RarityFilterBtn x0() {
        return (RarityFilterBtn) this.r.a(this, F[0]);
    }

    public final void C0(@e CardPackage cardPackage) {
        this.cardPackage = cardPackage;
    }

    public final void D0(@e Integer num) {
        this.D = num;
    }

    public final void E0(@e f<PendingProduct> fVar) {
        this.C = fVar;
    }

    public final void F0(@e Integer num) {
        this.type = num;
    }

    public final void G0(@e Integer num) {
        this.wid = num;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        u0().s0().f(this, new CardRepoSearchFragment$flowOfSetup$1(this));
        l0().s0().f(this, new CardRepoSearchFragment$flowOfSetup$2(this));
        l0().r0().f(this, new CardRepoSearchFragment$flowOfSetup$3(this));
        y0().D0().f(this, new CardRepoSearchFragment$flowOfSetup$4(this));
        ((CardRepoSearchViewModel) T()).v0().j(this, new CardRepoSearchFragment$flowOfSetup$5(this));
    }

    @e
    public final Integer getType() {
        return this.type;
    }

    @k.e.a.d
    public final j k0() {
        return (j) this.x.getValue();
    }

    @k.e.a.d
    public final ApplyForViewModel l0() {
        return (ApplyForViewModel) this.v.getValue();
    }

    @e
    public final CardPackage m0() {
        return this.cardPackage;
    }

    @k.e.a.d
    public final b n0() {
        return (b) this.z.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a o0() {
        return (LayoutManagers.a) this.y.getValue();
    }

    @k.e.a.d
    public final ListView p0() {
        return (ListView) this.u.a(this, F[2]);
    }

    @k.e.a.d
    public final g q0() {
        return this.A;
    }

    @k.e.a.d
    public final l<List<Rarity>, t1> r0() {
        return this.s;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        m7 e2 = m7.e(getLayoutInflater());
        e2.i(this);
        e2.j((CardRepoSearchViewModel) T());
        return e2;
    }

    @k.e.a.d
    public final e.t.j.h.l s0() {
        return this.E;
    }

    @k.e.a.d
    public final p t0() {
        return this.B;
    }

    @e
    public final Integer v0() {
        return this.D;
    }

    @e
    public final f<PendingProduct> w0() {
        return this.C;
    }

    @k.e.a.d
    public final SellingChildViewModel y0() {
        return (SellingChildViewModel) this.w.getValue();
    }

    @e
    public final Integer z0() {
        return this.wid;
    }
}
