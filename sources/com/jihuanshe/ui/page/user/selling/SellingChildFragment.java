package com.jihuanshe.ui.page.user.selling;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.jihuanshe.R;
import com.jihuanshe.base.bus.Bus;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.h.d.f;
import e.l.h.d.h;
import e.l.k.k6;
import e.l.s.m.c;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.p;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SellingChildFragment extends BaseFragment<SellingChildViewModel> {
    public static final /* synthetic */ n<Object>[] C;
    @f.a.a.a(true)
    private boolean search;
    @f.a.a.a
    @e
    private Integer type;
    @d
    private final w r = z.c(new SellingChildFragment$searchViewModel$2(this));
    @d
    private final w s = z.c(new SellingChildFragment$parentViewModel$2(this));
    @d
    private final h.m2.e t = BindViewKt.s(this, R.id.listView);
    @d
    private final h.m2.e u = BindViewKt.s(this, R.id.btn);
    @d
    private final w v = z.c(SellingChildFragment$layoutManager$2.INSTANCE);
    @d
    private final w w = z.c(SellingChildFragment$decoration$2.INSTANCE);
    @d
    private final w x = z.c(SellingChildFragment$adapter$2.INSTANCE);
    @d
    private final p y = d.g.a.a(new SellingChildFragment$onLoadMore$1(this));
    @k.e.a.d
    private final g z = e.t.j.h.d.a.a(new SellingChildFragment$onClickAdd$1(this));
    @k.e.a.d
    private final l A = d.e.a.a(new SellingChildFragment$onItemClick$1(this));
    private boolean B = true;

    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SellingChildFragment f4040c;

        public a(Bus bus, String str, SellingChildFragment sellingChildFragment) {
            this.a = bus;
            this.b = str;
            this.f4040c = sellingChildFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof Integer)) {
                int intValue = ((Number) f2).intValue();
                List<GameCard> value = ((SellingChildViewModel) this.f4040c.T()).D0().getValue();
                List<GameCard> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                if (L5 != null) {
                    e.t.l.p.d(L5, new SellingChildFragment$flowOfSetup$3$1(intValue));
                    ((SellingChildViewModel) this.f4040c.T()).D0().setValue(L5);
                }
            }
            new e.t.l.h();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SellingChildFragment f4041c;

        public b(Bus bus, String str, SellingChildFragment sellingChildFragment) {
            this.a = bus;
            this.b = str;
            this.f4041c = sellingChildFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof GameCard)) {
                GameCard gameCard = (GameCard) f2;
                List<GameCard> value = ((SellingChildViewModel) this.f4041c.T()).D0().getValue();
                T t = null;
                List<GameCard> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                if (L5 != null) {
                    Iterator<T> it = L5.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        if (f0.g(((GameCard) next).getProductId(), gameCard.getProductId())) {
                            t = next;
                            break;
                        }
                    }
                    GameCard gameCard2 = (GameCard) t;
                    if (gameCard2 != null) {
                        int onSell = gameCard.getOnSell();
                        Integer type = this.f4041c.getType();
                        if (type == null || onSell != type.intValue()) {
                            L5.remove(gameCard2);
                            ((SellingChildViewModel) this.f4041c.T()).D0().setValue(L5);
                        } else {
                            gameCard2.setCardPrice(gameCard.getCardPrice());
                            gameCard2.setDefaultProduct(gameCard.getDefaultProduct());
                            gameCard2.setQuantity(gameCard.getQuantity());
                            gameCard2.setCondition(gameCard.getCondition());
                            gameCard2.setImage(gameCard.getImage());
                            ((SellingChildViewModel) this.f4041c.T()).D0().n();
                        }
                    }
                }
            }
            new e.t.l.h();
        }
    }

    static {
        n<Object>[] nVarArr = new n[7];
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(SellingChildFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(SellingChildFragment.class), "btn", "getBtn()Landroid/view/View;"));
        C = nVarArr;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        SellingChildViewModel sellingChildViewModel = (SellingChildViewModel) T();
        int intValue = this.type.intValue();
        String value = m0().q0().getValue();
        Pair<String, String> value2 = m0().v0().getValue();
        e.g.d.a E0 = SellingChildViewModel.E0(sellingChildViewModel, intValue, value, value2 == null ? null : value2.getSecond(), null, 8, null);
        if (n0()) {
            BinderKt.t(E0, this, false, 2, null);
        } else {
            BinderKt.e(E0, this, i0(), false, 4, null);
        }
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        Integer num;
        GameBar.b.a().f(this, new SellingChildFragment$flowOfSetup$1(this));
        f fVar = f.b;
        fVar.e(this).g(e.l.j.a.f12241k, new SellingChildFragment$flowOfSetup$2(this));
        Bus e2 = fVar.e(this);
        e2.l(e2.e(), e2.d(), new a(e2, e.l.j.a.f12242l, this));
        Bus e3 = fVar.e(this);
        e3.l(e3.e(), e3.d(), new b(e3, e.l.j.a.f12243m, this));
        m0().p0().f(this, new SellingChildFragment$flowOfSetup$5(this));
        m0().s0().f(this, new SellingChildFragment$flowOfSetup$6(this));
        m0().x0().f(this, new SellingChildFragment$flowOfSetup$7(this));
        e.n.f.g(((SellingChildViewModel) T()).N(), null, new SellingChildFragment$flowOfSetup$8(this), 1, null);
        o0().s0().f(this, new SellingChildFragment$flowOfSetup$9(this));
        boolean z = this.search;
        if (!z || (z && (num = this.type) != null && num.intValue() == 0)) {
            M();
        }
        this.B = false;
    }

    @k.e.a.d
    public final e.l.g.f e0() {
        return (e.l.g.f) this.x.getValue();
    }

    @k.e.a.d
    public final View f0() {
        return (View) this.u.a(this, C[3]);
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b g0() {
        return (e.l.h.j.b.f.b) this.w.getValue();
    }

    @e
    public final Integer getType() {
        return this.type;
    }

    @k.e.a.d
    public final LayoutManagers.a h0() {
        return (LayoutManagers.a) this.v.getValue();
    }

    @k.e.a.d
    public final ListView i0() {
        return (ListView) this.t.a(this, C[2]);
    }

    @k.e.a.d
    public final g j0() {
        return this.z;
    }

    @k.e.a.d
    public final l k0() {
        return this.A;
    }

    @k.e.a.d
    public final p l0() {
        return this.y;
    }

    @k.e.a.d
    public final e.l.s.o.d.a m0() {
        return (e.l.s.o.d.a) this.s.getValue();
    }

    public final boolean n0() {
        return this.search;
    }

    @k.e.a.d
    public final c o0() {
        return (c) this.r.getValue();
    }

    public final boolean p0() {
        return this.B;
    }

    public final void q0(boolean z) {
        this.B = z;
    }

    public final void r0(boolean z) {
        this.search = z;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        k6 e2 = k6.e(getLayoutInflater());
        e2.i(this);
        e2.j((SellingChildViewModel) T());
        return e2;
    }

    public final void s0(@e Integer num) {
        this.type = num;
    }
}
