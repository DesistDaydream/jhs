package com.jihuanshe.ui.page.shop;

import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import e.l.k.a2;
import e.l.s.n.b;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
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
public final class SearchBankActivity extends BaseActivity<b> {
    public static final /* synthetic */ n<Object>[] u;
    @d
    private final e n = BindViewKt.n(this, R.id.bankNameEt);
    @d
    private final e o = BindViewKt.n(this, R.id.bankSubNameEt);
    @d
    private final w p = z.c(SearchBankActivity$adapter$2.INSTANCE);
    @d
    private final w q = z.c(SearchBankActivity$layoutManager$2.INSTANCE);
    @d
    private final w r = z.c(SearchBankActivity$decoration$2.INSTANCE);
    @d
    private final g s = e.t.j.h.d.a.a(new SearchBankActivity$onClickSearch$1(this));
    @d
    private final l t = d.e.a.a(new SearchBankActivity$onItemClick$1(this));

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SearchBankActivity.class), "et1", "getEt1()Landroid/widget/EditText;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SearchBankActivity.class), "et2", "getEt2()Landroid/widget/EditText;"));
        u = nVarArr;
    }

    @k.e.a.d
    public final e.l.g.d W() {
        return (e.l.g.d) this.p.getValue();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b X() {
        return (e.l.h.j.b.f.b) this.r.getValue();
    }

    @k.e.a.d
    public final EditText Y() {
        return (EditText) this.n.a(this, u[0]);
    }

    @k.e.a.d
    public final EditText Z() {
        return (EditText) this.o.a(this, u[1]);
    }

    @k.e.a.d
    public final LayoutManagers.a a0() {
        return (LayoutManagers.a) this.q.getValue();
    }

    @k.e.a.d
    public final g b0() {
        return this.s;
    }

    @k.e.a.d
    public final l c0() {
        return this.t;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        m(R.color.white);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(SearchBankActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        a2 e2 = a2.e(getLayoutInflater());
        e2.i(this);
        e2.j((b) L());
        return e2;
    }
}
