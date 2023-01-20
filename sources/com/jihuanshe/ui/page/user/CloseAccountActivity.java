package com.jihuanshe.ui.page.user;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.g.d.a;
import e.l.h.l.b;
import e.l.k.a0;
import e.l.n.c.v;
import e.n.i;
import e.n.p;
import e.t.j.h.g;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class CloseAccountActivity extends BaseActivity<b> {
    public static final /* synthetic */ n<Object>[] t = {n0.r(new PropertyReference1Impl(n0.d(CloseAccountActivity.class), "regularTv", "getRegularTv()Landroid/widget/TextView;"))};
    @d
    private final e n = BindViewKt.n(this, R.id.regularTv);
    @d
    private final p o = new p(null, 1, null);
    @d
    private final p p = new p(null, 1, null);
    @d
    private final p q = new p(null, 1, null);
    @d
    private final i r = new i(Boolean.FALSE);
    @d
    private final g s = e.t.j.h.d.a.a(new CloseAccountActivity$onConfirm$1(this));

    private final TextView Y() {
        return (TextView) this.n.a(this, t[0]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(a.j(a.h(FlowKt.c(((v) e.l.n.a.d(v.class, true, false, false, 60L, true)).b()), LifecycleOwnerKt.getLifecycleScope(this), null, 2, null), null, new CloseAccountActivity$onRetryClick$1(this), 1, null), this, false, false, 6, null);
    }

    @d
    public final p W() {
        return this.p;
    }

    @d
    public final g X() {
        return this.s;
    }

    @d
    public final i Z() {
        return this.r;
    }

    @d
    public final p a0() {
        return this.q;
    }

    @d
    public final p b0() {
        return this.o;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        Y().setText(e.l.h.f.e.e(new SpannableStringBuilder(Res.w(Res.a, R.string.close_regular, null, 2, null)), Res.k(R.color.service_charge_color), 19, 30, new CloseAccountActivity$flowOfSetup$1(this)));
        Y().setMovementMethod(LinkMovementMethod.getInstance());
        F();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(CloseAccountActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        a0 d2 = a0.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }
}
