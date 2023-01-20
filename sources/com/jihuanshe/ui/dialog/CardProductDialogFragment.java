package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Constants;
import com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl;
import com.jihuanshe.ui.widget.NumberView;
import com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import e.l.g.o0;
import e.l.k.y4;
import e.l.q.a.w;
import e.l.q.b.b.a.e;
import e.n.f;
import e.n.l;
import e.n.p;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.z;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class CardProductDialogFragment extends w implements e.l.s.l.b.b {
    @d
    public static final a w;
    public static final /* synthetic */ n<Object>[] x;

    /* renamed from: f  reason: collision with root package name */
    private int f3960f;

    /* renamed from: g  reason: collision with root package name */
    private int f3961g;
    @d
    private final g s;
    @d
    private final g t;
    @d
    private final g u;
    public e v;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ ProductBySellerCardVersionIdImpl f3959e = new ProductBySellerCardVersionIdImpl();
    @d

    /* renamed from: h  reason: collision with root package name */
    private String f3962h = "";
    @d

    /* renamed from: i  reason: collision with root package name */
    private String f3963i = "";
    @d

    /* renamed from: j  reason: collision with root package name */
    private final h.m2.e f3964j = BindViewKt.r(this, R.id.adder);
    @d

    /* renamed from: k  reason: collision with root package name */
    private final f<CardProductNew> f3965k = new f<>(null, 1, null);
    @d

    /* renamed from: l  reason: collision with root package name */
    private final p f3966l = new p(null, 1, null);
    @d

    /* renamed from: m  reason: collision with root package name */
    private final l f3967m = new l(1);
    @d
    private final l n = new l(1);
    @d
    private final h.w o = z.c(CardProductDialogFragment$adapter$2.INSTANCE);
    @d
    private final h.w p = z.c(CardProductDialogFragment$layoutManager$2.INSTANCE);
    @d
    private final h.w q = z.c(CardProductDialogFragment$decoration$2.INSTANCE);
    @d
    private final e.t.j.h.l r = d.e.a.a(new CardProductDialogFragment$onItemClick$1(this));

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.d
        public final CardProductDialogFragment a(@k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e String str, @k.e.a.e String str2) {
            CardProductDialogFragment cardProductDialogFragment = new CardProductDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.KEY_PARAM_USER_ID, num == null ? 0 : num.intValue());
            bundle.putString(Constants.KEY_PARAM_GAME_KEY, str);
            bundle.putInt(Constants.KEY_PARAM_CARD_VERSION_ID, num2 != null ? num2.intValue() : 0);
            bundle.putString(Constants.KEY_PARAM_GAME_SUB_KEY, str2);
            cardProductDialogFragment.setArguments(bundle);
            return cardProductDialogFragment;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends ProductManagerHeaderImpl {
        public b() {
            super(null, CardProductDialogFragment.this);
        }

        @Override // com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl, e.l.q.b.b.a.e
        public boolean a() {
            return false;
        }

        @Override // com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl
        public void s(@k.e.a.d CardProductNew cardProductNew) {
            CardProductDialogFragment.this.F().r(cardProductNew);
        }
    }

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(CardProductDialogFragment.class), "numEt", "getNumEt()Lcom/jihuanshe/ui/widget/NumberView;"));
        x = nVarArr;
        w = new a(null);
    }

    public CardProductDialogFragment() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.s = dVar.a(new CardProductDialogFragment$onJoin$1(this));
        this.t = dVar.a(new CardProductDialogFragment$onClickClose$1(this));
        this.u = dVar.a(new CardProductDialogFragment$onReportClick$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NumberView K() {
        return (NumberView) this.f3964j.a(this, x[0]);
    }

    @k.e.a.d
    public final o0 E() {
        return (o0) this.o.getValue();
    }

    @k.e.a.d
    public final f<CardProductNew> F() {
        return this.f3965k;
    }

    @k.e.a.d
    public final l G() {
        return this.n;
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b H() {
        return (e.l.h.j.b.f.b) this.q.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a I() {
        return (LayoutManagers.a) this.p.getValue();
    }

    @k.e.a.d
    public final l J() {
        return this.f3967m;
    }

    @k.e.a.d
    public final g L() {
        return this.t;
    }

    @k.e.a.d
    public final e.t.j.h.l M() {
        return this.r;
    }

    @k.e.a.d
    public final g N() {
        return this.s;
    }

    @k.e.a.d
    public final g O() {
        return this.u;
    }

    @k.e.a.d
    public final e P() {
        e eVar = this.v;
        Objects.requireNonNull(eVar);
        return eVar;
    }

    @k.e.a.d
    public final p Q() {
        return this.f3966l;
    }

    public final void R(@k.e.a.d e eVar) {
        this.v = eVar;
    }

    @Override // e.l.q.a.w
    public void d() {
        this.f3966l.f(this, new CardProductDialogFragment$flowOfSetup$1(this));
        BinderKt.p(e.g.d.a.j(h(this.f3960f, this.f3961g, 0, this.f3962h, LifecycleOwnerKt.getLifecycleScope(this)), null, new CardProductDialogFragment$flowOfSetup$2(this), 1, null));
    }

    @Override // e.l.s.l.b.b
    @k.e.a.d
    public e.g.d.a<CardProductNew> h(int i2, int i3, int i4, @k.e.a.d String str, @k.e.a.d LifecycleCoroutineScope lifecycleCoroutineScope) {
        return this.f3959e.h(i2, i3, i4, str, lifecycleCoroutineScope);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@k.e.a.d Context context) {
        super.onAttach(context);
        R(new b());
    }

    @Override // e.l.q.a.w
    @k.e.a.d
    public ViewDataBinding p(@k.e.a.e ViewGroup viewGroup) {
        y4 d2 = y4.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }

    @Override // e.l.q.a.w
    public void y(@k.e.a.e Bundle bundle) {
        this.f3960f = bundle == null ? 0 : bundle.getInt(Constants.KEY_PARAM_USER_ID);
        this.f3961g = bundle != null ? bundle.getInt(Constants.KEY_PARAM_CARD_VERSION_ID) : 0;
        String string = bundle == null ? null : bundle.getString(Constants.KEY_PARAM_GAME_KEY);
        if (string == null) {
            string = "";
        }
        this.f3962h = string;
        String string2 = bundle != null ? bundle.getString(Constants.KEY_PARAM_GAME_SUB_KEY) : null;
        this.f3963i = string2 != null ? string2 : "";
    }
}
