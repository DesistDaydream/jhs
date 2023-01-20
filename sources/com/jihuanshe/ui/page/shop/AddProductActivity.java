package com.jihuanshe.ui.page.shop;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.jihuanshe.R;
import com.jihuanshe.base.bus.Bus;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.page.common.card.ConditionOpImpl;
import com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl;
import com.jihuanshe.ui.widget.ConditionView;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import e.l.g.o0;
import e.l.h.d.f;
import e.l.h.d.h;
import e.l.k.i;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.io.File;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.Flow;

@Creator
/* loaded from: classes2.dex */
public final class AddProductActivity extends BaseActivity<e.l.s.n.a> {
    public static final /* synthetic */ n<Object>[] x;
    @f.a.a.a
    private int cardVersionId;
    @f.a.a.a
    @d
    private String gameKey = "";
    @f.a.a.a
    @d
    private String gameSubKey = "";
    @d
    private final e n = BindViewKt.n(this, R.id.conditionView);
    @d
    private final e o = BindViewKt.n(this, R.id.productInfoView);
    @d
    private final w p = z.c(new AddProductActivity$conditionOp$2(this));
    @d
    private final w q = z.c(new AddProductActivity$productInfoOp$2(this));
    @d
    private final ProductManagerHeaderImpl r = new b();
    @d
    private final w s = z.c(AddProductActivity$adapter$2.INSTANCE);
    @d
    private final w t = z.c(AddProductActivity$layoutManager$2.INSTANCE);
    @d
    private final w u = z.c(AddProductActivity$decoration$2.INSTANCE);
    @d
    private final l v = d.e.a.a(new AddProductActivity$onItemClick$1(this));
    @k.e.a.d
    private final g w = e.t.j.h.d.a.a(new AddProductActivity$onClickConfirm$1(this));
    @f.a.a.a(true)
    private int wareHouseId;

    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AddProductActivity f4037c;

        public a(Bus bus, String str, AddProductActivity addProductActivity) {
            this.a = bus;
            this.b = str;
            this.f4037c = addProductActivity;
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
                this.f4037c.F();
            }
            new e.t.l.h();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends ProductManagerHeaderImpl {
        public b() {
            super(AddProductActivity.this, null);
        }

        @Override // com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl
        public void s(@k.e.a.d CardProductNew cardProductNew) {
            ((e.l.s.n.a) AddProductActivity.this.L()).A0().r(cardProductNew);
        }

        @Override // com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl
        @k.e.a.d
        public Flow<FileInfo> w(@k.e.a.d File file) {
            return ((e.l.s.n.a) AddProductActivity.this.L()).w0(file, null, PangleAdapterUtils.MEDIA_EXTRA_PRODUCT);
        }
    }

    static {
        n<Object>[] nVarArr = new n[7];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(AddProductActivity.class), "conditionLayout", "getConditionLayout()Lcom/jihuanshe/ui/widget/ConditionView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(AddProductActivity.class), "productInfoView", "getProductInfoView()Landroid/view/View;"));
        x = nVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConditionView a0() {
        return (ConditionView) this.n.a(this, x[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View j0() {
        return (View) this.o.a(this, x[1]);
    }

    private final void m0() {
        Bus e2 = f.b.e(this);
        e2.l(e2.e(), e2.d(), new a(e2, e.l.j.a.f12243m, this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        ((e.l.s.n.a) L()).A0().f(this, new AddProductActivity$onRetryClick$1(this));
        BinderKt.p(e.g.d.a.j(((e.l.s.n.a) L()).h(UserKV.f3913c.v(), this.cardVersionId, this.wareHouseId, this.gameKey, LifecycleOwnerKt.getLifecycleScope(this)), null, new AddProductActivity$onRetryClick$2(this), 1, null));
    }

    @k.e.a.d
    public final o0 Y() {
        return (o0) this.s.getValue();
    }

    public final int Z() {
        return this.cardVersionId;
    }

    @k.e.a.d
    public final ConditionOpImpl b0() {
        return (ConditionOpImpl) this.p.getValue();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b c0() {
        return (e.l.h.j.b.f.b) this.u.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        m(R.color.white);
        m0();
        F();
    }

    @k.e.a.d
    public final String d0() {
        return this.gameKey;
    }

    @k.e.a.d
    public final String e0() {
        return this.gameSubKey;
    }

    @k.e.a.d
    public final LayoutManagers.a f0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final g g0() {
        return this.w;
    }

    @k.e.a.d
    public final l h0() {
        return this.v;
    }

    @k.e.a.d
    public final e.l.q.b.b.a.d i0() {
        return (e.l.q.b.b.a.d) this.q.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(AddProductActivity$flowOfAppBar$1.INSTANCE);
    }

    @k.e.a.d
    public final ProductManagerHeaderImpl k0() {
        return this.r;
    }

    public final int l0() {
        return this.wareHouseId;
    }

    public final void n0(int i2) {
        this.cardVersionId = i2;
    }

    public final void o0(@k.e.a.d String str) {
        this.gameKey = str;
    }

    public final void p0(@k.e.a.d String str) {
        this.gameSubKey = str;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        i e2 = i.e(getLayoutInflater());
        e2.i(this);
        e2.j((e.l.s.n.a) L());
        return e2;
    }

    public final void q0(int i2) {
        this.wareHouseId = i2;
    }
}
