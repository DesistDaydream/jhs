package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.eth.ext.FlowKt;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.ext.bind.BindViewKt;
import e.l.k.q4;
import e.l.n.c.k;
import e.l.q.a.w;
import e.l.q.b.b.a.c;
import e.n.f;
import e.t.j.h.g;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.z;
import java.io.File;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public class EditProductDialog extends w {
    @d
    public static final a x;
    public static final /* synthetic */ n<Object>[] y;

    /* renamed from: e  reason: collision with root package name */
    private int f3969e;

    /* renamed from: f  reason: collision with root package name */
    private int f3970f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private String f3971g = "";
    @d

    /* renamed from: h  reason: collision with root package name */
    private String f3972h = "";
    @d

    /* renamed from: i  reason: collision with root package name */
    private final f<GameCard> f3973i = new f<>(null, 1, null);
    @d

    /* renamed from: j  reason: collision with root package name */
    private final f<CardProductNew> f3974j = new f<>(null, 1, null);
    @d

    /* renamed from: k  reason: collision with root package name */
    private final h.w f3975k = z.c(new EditProductDialog$conditionOp$2(this));
    @d

    /* renamed from: l  reason: collision with root package name */
    private final f<e.l.q.b.b.a.d> f3976l = new f<>(null, 1, null);
    @d

    /* renamed from: m  reason: collision with root package name */
    private final g f3977m;
    @d
    private final h.w n;
    @d
    private final h.w o;
    @d
    private final e p;
    @d
    private final e q;
    @d
    private final e r;
    @d
    private final e s;
    @d
    private final e t;
    @d
    private final g u;
    @d
    private final g v;
    public e.l.q.b.b.a.e w;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final EditProductDialog a(@k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e String str, @k.e.a.e String str2) {
            EditProductDialog editProductDialog = new EditProductDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.KEY_PARAM_PRODUCT_ID, num == null ? 0 : num.intValue());
            bundle.putString(Constants.KEY_PARAM_GAME_KEY, str);
            bundle.putInt(Constants.KEY_PARAM_CARD_VERSION_ID, num2 != null ? num2.intValue() : 0);
            bundle.putString(Constants.KEY_PARAM_GAME_SUB_KEY, str2);
            editProductDialog.setArguments(bundle);
            return editProductDialog;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends ProductManagerHeaderImpl {
        public b() {
            super(null, EditProductDialog.this);
        }

        @Override // com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl
        public void s(@d CardProductNew cardProductNew) {
            EditProductDialog.this.E().r(cardProductNew);
        }

        @Override // com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl
        @d
        public Flow<FileInfo> w(@d File file) {
            return EditProductDialog.this.S().w0(file, null, PangleAdapterUtils.MEDIA_EXTRA_PRODUCT);
        }
    }

    static {
        n<Object>[] nVarArr = new n[8];
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(EditProductDialog.class), "priceEt", "getPriceEt()Landroid/widget/EditText;"));
        nVarArr[4] = n0.r(new PropertyReference1Impl(n0.d(EditProductDialog.class), "numEt", "getNumEt()Landroid/widget/EditText;"));
        nVarArr[5] = n0.r(new PropertyReference1Impl(n0.d(EditProductDialog.class), "remarkEt", "getRemarkEt()Landroid/widget/EditText;"));
        nVarArr[6] = n0.r(new PropertyReference1Impl(n0.d(EditProductDialog.class), "switch", "getSwitch()Lcom/google/android/material/switchmaterial/SwitchMaterial;"));
        nVarArr[7] = n0.r(new PropertyReference1Impl(n0.d(EditProductDialog.class), "dSwitch", "getDSwitch()Lcom/google/android/material/switchmaterial/SwitchMaterial;"));
        y = nVarArr;
        x = new a(null);
    }

    public EditProductDialog() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.f3977m = dVar.a(new EditProductDialog$onDeleteClick$1(this));
        this.n = z.c(new EditProductDialog$viewModel$2(this));
        this.o = z.c(new EditProductDialog$useHeight$2(this));
        this.p = BindViewKt.r(this, R.id.priceEt);
        this.q = BindViewKt.r(this, R.id.numEt);
        this.r = BindViewKt.r(this, R.id.remarkEt);
        this.s = BindViewKt.r(this, R.id.soldSwitch);
        this.t = BindViewKt.r(this, R.id.defaultSwitch);
        this.u = dVar.a(new EditProductDialog$onSave$1(this));
        this.v = dVar.a(new EditProductDialog$onClickClose$1(this));
    }

    @d
    public final f<CardProductNew> E() {
        return this.f3974j;
    }

    @d
    public final c F() {
        return (c) this.f3975k.getValue();
    }

    @d
    public final SwitchMaterial G() {
        return (SwitchMaterial) this.t.a(this, y[7]);
    }

    @d
    public final EditText H() {
        return (EditText) this.q.a(this, y[4]);
    }

    @d
    public final g I() {
        return this.v;
    }

    @d
    public final g J() {
        return this.f3977m;
    }

    @d
    public final g K() {
        return this.u;
    }

    @d
    public final EditText L() {
        return (EditText) this.p.a(this, y[3]);
    }

    @d
    public final f<GameCard> M() {
        return this.f3973i;
    }

    @d
    public final f<e.l.q.b.b.a.d> N() {
        return this.f3976l;
    }

    @d
    public final e.l.q.b.b.a.e O() {
        e.l.q.b.b.a.e eVar = this.w;
        Objects.requireNonNull(eVar);
        return eVar;
    }

    @d
    public final EditText P() {
        return (EditText) this.r.a(this, y[5]);
    }

    @d
    public final SwitchMaterial Q() {
        return (SwitchMaterial) this.s.a(this, y[6]);
    }

    public final int R() {
        return ((Number) this.o.getValue()).intValue();
    }

    @d
    public final UploadViewModel S() {
        return (UploadViewModel) this.n.getValue();
    }

    public final void T(@d e.l.q.b.b.a.e eVar) {
        this.w = eVar;
    }

    @Override // e.l.q.a.w
    public void d() {
        BinderKt.p(e.g.d.a.h(e.g.d.a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).y(this.f3969e)), null, new EditProductDialog$flowOfSetup$1(this), 1, null), LifecycleOwnerKt.getLifecycleScope(this), null, 2, null));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@d Context context) {
        super.onAttach(context);
        T(new b());
    }

    @Override // e.l.q.a.w
    @d
    public ViewDataBinding p(@k.e.a.e ViewGroup viewGroup) {
        q4 e2 = q4.e(getLayoutInflater(), viewGroup, false);
        e2.h(this);
        return e2;
    }

    @Override // e.l.q.a.w
    public int u() {
        return 80;
    }

    @Override // e.l.q.a.w
    public void y(@k.e.a.e Bundle bundle) {
        this.f3969e = bundle == null ? 0 : bundle.getInt(Constants.KEY_PARAM_PRODUCT_ID);
        String string = bundle == null ? null : bundle.getString(Constants.KEY_PARAM_GAME_KEY);
        if (string == null) {
            string = "";
        }
        this.f3971g = string;
        this.f3970f = bundle != null ? bundle.getInt(Constants.KEY_PARAM_CARD_VERSION_ID) : 0;
        String string2 = bundle != null ? bundle.getString(Constants.KEY_PARAM_GAME_SUB_KEY) : null;
        this.f3972h = string2 != null ? string2 : "";
    }
}
