package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.l0;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.h.j.b.f.b;
import e.l.k.w2;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.p;
import f.a.a.a;
import h.k2.v.n0;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SubmitOrderReturnActivity extends BaseActivity<SubmitOrderReturnViewModel> {
    public static final /* synthetic */ n<Object>[] t;
    @a
    @e
    private Integer orderId;
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.listView);
    @d
    private final w o = z.c(SubmitOrderReturnActivity$layoutManager$2.INSTANCE);
    @d
    private final w p = z.c(SubmitOrderReturnActivity$decoration$2.INSTANCE);
    @d
    private final w q = z.c(SubmitOrderReturnActivity$adapter$2.INSTANCE);
    @d
    private final p r = d.g.a.a(new SubmitOrderReturnActivity$onLoadMore$1(this));
    @k.e.a.d
    private final g s = e.t.j.h.d.a.a(new SubmitOrderReturnActivity$onClickPay$1(this));

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SubmitOrderReturnActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        t = nVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView a0() {
        return (ListView) this.n.a(this, t[0]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        SubmitOrderReturnViewModel submitOrderReturnViewModel = (SubmitOrderReturnViewModel) L();
        Integer num = this.orderId;
        BinderKt.p(submitOrderReturnViewModel.F0(num == null ? 0 : num.intValue()));
        SubmitOrderReturnViewModel submitOrderReturnViewModel2 = (SubmitOrderReturnViewModel) L();
        Integer num2 = this.orderId;
        BinderKt.p(BinderKt.e(SubmitOrderReturnViewModel.E0(submitOrderReturnViewModel2, num2 != null ? num2.intValue() : 0, null, 2, null), this, a0(), false, 4, null));
    }

    @k.e.a.d
    public final l0 X() {
        return (l0) this.q.getValue();
    }

    @k.e.a.d
    public final b Y() {
        return (b) this.p.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Z() {
        return (LayoutManagers.a) this.o.getValue();
    }

    @k.e.a.d
    public final g b0() {
        return this.s;
    }

    @k.e.a.d
    public final p c0() {
        return this.r;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        F();
        f.b.e(this).g(e.l.j.a.r, new SubmitOrderReturnActivity$flowOfSetup$1(this));
    }

    @e
    public final Integer d0() {
        return this.orderId;
    }

    public final void e0(@e Integer num) {
        this.orderId = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(SubmitOrderReturnActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        i.d(f.b, e.l.j.a.v, null, 2, null);
        super.onDestroy();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        w2 e2 = w2.e(getLayoutInflater());
        e2.i(this);
        e2.j((SubmitOrderReturnViewModel) L());
        return e2;
    }
}
