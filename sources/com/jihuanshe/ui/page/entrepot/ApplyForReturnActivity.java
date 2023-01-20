package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.jihuanshe.R;
import com.jihuanshe.base.bus.Bus;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.b;
import e.l.g.c;
import e.l.h.d.f;
import e.l.h.d.h;
import e.l.k.q0;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.p;
import h.k2.v.f0;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class ApplyForReturnActivity extends BaseActivity<ApplyForReturnViewModel> {
    public static final /* synthetic */ n<Object>[] y;
    @d
    private final e n = BindViewKt.n(this, R.id.card_listView);
    @d
    private final e o = BindViewKt.n(this, R.id.listViewPart);
    @d
    private final List<ReturnCardInfo> p = new ArrayList();
    @d
    private final w q = z.c(ApplyForReturnActivity$layoutManager$2.INSTANCE);
    @d
    private final w r = z.c(ApplyForReturnActivity$decoration$2.INSTANCE);
    @d
    private final w s = z.c(new ApplyForReturnActivity$adapter$2(this));
    @d
    private final w t = z.c(new ApplyForReturnActivity$adapterPart$2(this));
    @d
    private final l u = d.e.a.a(new ApplyForReturnActivity$onItemClick$1(this));
    @k.e.a.d
    private final p v = d.g.a.a(new ApplyForReturnActivity$onLoadMore$1(this));
    @k.e.a.d
    private final g w;
    @k.e.a.d
    private final g x;

    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ApplyForReturnActivity f4024c;

        public a(Bus bus, String str, ApplyForReturnActivity applyForReturnActivity) {
            this.a = bus;
            this.b = str;
            this.f4024c = applyForReturnActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof UserAddress)) {
                ((ApplyForReturnViewModel) this.f4024c.L()).y0().setValue((UserAddress) f2);
            }
            new e.t.l.h();
        }
    }

    static {
        n<Object>[] nVarArr = new n[6];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(ApplyForReturnActivity.class), "cardListView", "getCardListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(ApplyForReturnActivity.class), "listViewPart", "getListViewPart()Lcom/vector/view/scrollable/ListView;"));
        y = nVarArr;
    }

    public ApplyForReturnActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.w = dVar.a(new ApplyForReturnActivity$chooseAddressOnClick$1(this));
        this.x = dVar.a(new ApplyForReturnActivity$onClickSubmit$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView a0() {
        return (ListView) this.n.a(this, y[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView f0() {
        return (ListView) this.o.a(this, y[1]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.e(ApplyForReturnViewModel.w0((ApplyForReturnViewModel) L(), null, 1, null), this, a0(), false, 4, null);
    }

    @k.e.a.d
    public final b Y() {
        return (b) this.s.getValue();
    }

    @k.e.a.d
    public final c Z() {
        return (c) this.t.getValue();
    }

    @k.e.a.d
    public final g b0() {
        return this.w;
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b c0() {
        return (e.l.h.j.b.f.b) this.r.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        f fVar = f.b;
        Bus e2 = fVar.e(this);
        e2.l(e2.e(), e2.d(), new a(e2, e.l.j.a.f12235e, this));
        fVar.e(this).g(e.l.j.a.v, new ApplyForReturnActivity$flowOfSetup$2(this));
        e.n.f.g(((ApplyForReturnViewModel) L()).A0(), null, new ApplyForReturnActivity$flowOfSetup$3(this), 1, null);
        e.n.f.g(((ApplyForReturnViewModel) L()).D0(), null, new ApplyForReturnActivity$flowOfSetup$4(this), 1, null);
        ((ApplyForReturnViewModel) L()).r0();
    }

    @k.e.a.d
    public final List<ReturnCardInfo> d0() {
        return this.p;
    }

    @k.e.a.d
    public final LayoutManagers.a e0() {
        return (LayoutManagers.a) this.q.getValue();
    }

    @k.e.a.d
    public final g g0() {
        return this.x;
    }

    @k.e.a.d
    public final l h0() {
        return this.u;
    }

    @k.e.a.d
    public final p i0() {
        return this.v;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(ApplyForReturnActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        q0 e2 = q0.e(getLayoutInflater());
        e2.i(this);
        e2.j((ApplyForReturnViewModel) L());
        return e2;
    }
}
