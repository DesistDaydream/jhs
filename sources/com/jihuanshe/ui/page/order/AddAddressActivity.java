package com.jihuanshe.ui.page.order;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ext.AppbarKt;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.BaseActivity;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.l.h.l.b;
import e.l.n.c.k;
import e.n.p;
import e.t.j.h.d;
import e.t.j.h.g;
import f.a.a.a;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.n;
import inject.annotation.creator.Creator;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.StringsKt__StringsKt;

@Creator
/* loaded from: classes2.dex */
public final class AddAddressActivity extends BaseActivity<b> {
    public static final /* synthetic */ n<Object>[] C = {n0.r(new PropertyReference1Impl(n0.d(AddAddressActivity.class), "contact", "getContact()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(AddAddressActivity.class), "phone", "getPhone()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(AddAddressActivity.class), "provinceTv", "getProvinceTv()Landroid/widget/TextView;")), n0.r(new PropertyReference1Impl(n0.d(AddAddressActivity.class), "address", "getAddress()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(AddAddressActivity.class), "temp", "getTemp()Landroid/view/View;")), n0.r(new PropertyReference1Impl(n0.d(AddAddressActivity.class), "saveBtn", "getSaveBtn()Landroid/view/View;")), n0.r(new PropertyReference1Impl(n0.d(AddAddressActivity.class), "switchBtn", "getSwitchBtn()Lcom/google/android/material/switchmaterial/SwitchMaterial;"))};
    @SuppressLint({"SetTextI18n"})
    @d
    private final g A;
    @d
    private final g B;
    @a
    @e
    private String busEvent;
    @a(true)
    @e
    private UserAddress oldAddress;
    @e
    private String u;
    @e
    private String v;
    @e
    private String w;
    @d
    private final g z;
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.contactEt);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.phoneEt);
    @d
    private final h.m2.e p = BindViewKt.n(this, R.id.provinceEt);
    @d
    private final h.m2.e q = BindViewKt.n(this, R.id.addressEt);
    @d
    private final h.m2.e r = BindViewKt.n(this, R.id.chosen);
    @d
    private final h.m2.e s = BindViewKt.n(this, R.id.saveBtn);
    @d
    private final h.m2.e t = BindViewKt.n(this, R.id.btnSwitch);
    @d
    private p x = new p("+86");
    @d
    private final e.t.j.h.a y = d.c.a.a(new AddAddressActivity$onTextChanged$1(this));

    public AddAddressActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.z = dVar.a(new AddAddressActivity$onClickCode$1(this));
        this.A = dVar.a(new AddAddressActivity$onClickProvince$1(this));
        this.B = dVar.a(new AddAddressActivity$onClickSave$1(this));
    }

    public final boolean Y() {
        String obj = d0().getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj2 = StringsKt__StringsKt.B5(obj).toString();
        String obj3 = k0().getText().toString();
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj4 = StringsKt__StringsKt.B5(obj3).toString();
        String obj5 = Z().getText().toString();
        Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj6 = StringsKt__StringsKt.B5(obj5).toString();
        if (!(obj2.length() == 0)) {
            if (!(obj4.length() == 0)) {
                String str = this.u;
                if (!(str == null || str.length() == 0)) {
                    String str2 = this.v;
                    if (!(str2 == null || str2.length() == 0)) {
                        String str3 = this.w;
                        if (!(str3 == null || str3.length() == 0)) {
                            if (!(obj6.length() == 0)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void q0() {
        String obj = d0().getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj2 = StringsKt__StringsKt.B5(obj).toString();
        String obj3 = k0().getText().toString();
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj4 = StringsKt__StringsKt.B5(obj3).toString();
        String obj5 = Z().getText().toString();
        Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj6 = StringsKt__StringsKt.B5(obj5).toString();
        if (!(obj2.length() == 0)) {
            if (!(obj4.length() == 0)) {
                String str = this.u;
                if (!(str == null || str.length() == 0)) {
                    String str2 = this.v;
                    if (!(str2 == null || str2.length() == 0)) {
                        String str3 = this.w;
                        if (!(str3 == null || str3.length() == 0)) {
                            if (!(obj6.length() == 0)) {
                                if (f0.g(this.busEvent, e.l.j.a.f12237g)) {
                                    BinderKt.p(BinderKt.k(e.g.d.a.h(e.g.d.a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).p0(this.oldAddress.getId(), obj2, obj4, this.u, this.v, this.w, obj6, null, o0().isChecked() ? 1 : 0)), null, new AddAddressActivity$save$1(this, obj6, obj2, obj4), 1, null), LifecycleOwnerKt.getLifecycleScope(this), null, 2, null), this, false, 2, null));
                                    return;
                                } else {
                                    BinderKt.p(BinderKt.k(e.g.d.a.h(e.g.d.a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).n(obj2, obj4, this.u, this.v, this.w, obj6, null, o0().isChecked() ? 1 : 0)), null, new AddAddressActivity$save$2(this), 1, null), LifecycleOwnerKt.getLifecycleScope(this), null, 2, null), this, false, 2, null));
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        e.l.h.j.b.e.h(this, Res.w(Res.a, R.string.common_please_input_complete, null, 2, null), null, null, null, 0, null, 62, null);
    }

    @k.e.a.d
    public final EditText Z() {
        return (EditText) this.q.a(this, C[3]);
    }

    @e
    public final String a0() {
        return this.w;
    }

    @e
    public final String b0() {
        return this.busEvent;
    }

    @e
    public final String c0() {
        return this.v;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        if (this.oldAddress != null) {
            o0().setChecked(this.oldAddress.isDefault() == 1);
            this.u = this.oldAddress.getProvince();
            this.v = this.oldAddress.getCity();
            this.w = this.oldAddress.getDistrict();
        }
        Y();
    }

    @k.e.a.d
    public final EditText d0() {
        return (EditText) this.n.a(this, C[0]);
    }

    @e
    public final UserAddress e0() {
        return this.oldAddress;
    }

    @k.e.a.d
    public final g f0() {
        return this.z;
    }

    @k.e.a.d
    public final g g0() {
        return this.A;
    }

    @k.e.a.d
    public final g h0() {
        return this.B;
    }

    @k.e.a.d
    public final e.t.j.h.a i0() {
        return this.y;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(new AddAddressActivity$flowOfAppBar$1(this));
        AppbarKt.b(w(), 0, new AddAddressActivity$flowOfAppBar$2(this), 1, null);
    }

    @k.e.a.d
    public final p j0() {
        return this.x;
    }

    @k.e.a.d
    public final EditText k0() {
        return (EditText) this.o.a(this, C[1]);
    }

    @e
    public final String l0() {
        return this.u;
    }

    @k.e.a.d
    public final TextView m0() {
        return (TextView) this.p.a(this, C[2]);
    }

    @k.e.a.d
    public final View n0() {
        return (View) this.s.a(this, C[5]);
    }

    @k.e.a.d
    public final SwitchMaterial o0() {
        return (SwitchMaterial) this.t.a(this, C[6]);
    }

    @k.e.a.d
    public final View p0() {
        return (View) this.r.a(this, C[4]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        e.l.k.e d2 = e.l.k.e.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }

    public final void r0(@e String str) {
        this.w = str;
    }

    public final void s0(@e String str) {
        this.busEvent = str;
    }

    public final void t0(@e String str) {
        this.v = str;
    }

    public final void u0(@e UserAddress userAddress) {
        this.oldAddress = userAddress;
    }

    public final void v0(@k.e.a.d p pVar) {
        this.x = pVar;
    }

    public final void w0(@e String str) {
        this.u = str;
    }
}
