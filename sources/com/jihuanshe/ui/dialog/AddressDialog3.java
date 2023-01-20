package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.CityCodeSet;
import com.vector.util.UIUtil;
import com.xres.address_selector.db.entity.City;
import com.xres.address_selector.db.entity.Province;
import com.xres.address_selector.widget.address_selector.AddressSelectorView3;
import e.l.k.i3;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import e.t.o.d;
import h.k2.u.q;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class AddressDialog3 extends BaseDialog {
    @d
    private final CityCodeSet t;
    @e
    private i3 u;
    @e
    private q<? super String, ? super String, ? super String, t1> v;
    private final int w;
    @d
    private final g x;

    public AddressDialog3(@d Context context, @d CityCodeSet cityCodeSet) {
        super(context);
        this.t = cityCodeSet;
        this.w = UIUtil.c() + d.a.c(e.t.o.d.a, null, 1, null).d(58);
        this.x = e.t.j.h.d.a.a(new AddressDialog3$onClose$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public ViewDataBinding d() {
        i3 e2 = i3.e(getLayoutInflater(), this, false);
        this.u = e2;
        AddressSelectorView3 addressSelectorView3 = e2.a;
        List<Province> province = this.t.getProvince();
        if (province == null) {
            province = CollectionsKt__CollectionsKt.E();
        }
        List<List<City>> city = this.t.getCity();
        if (city == null) {
            city = CollectionsKt__CollectionsKt.E();
        }
        addressSelectorView3.z(province, city);
        this.u.a.setOnSelectCompletedListener(new AddressDialog3$createBinding$1(this));
        this.u.h(this);
        return this.u;
    }

    @e
    public final i3 getBinding() {
        return this.u;
    }

    @k.e.a.d
    public final CityCodeSet getData() {
        return this.t;
    }

    public final int getH() {
        return this.w;
    }

    @e
    public final q<String, String, String, t1> getListener() {
        return this.v;
    }

    @k.e.a.d
    public final g getOnClose() {
        return this.x;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public k l(@k.e.a.d View view) {
        return new r(view);
    }

    public final void setBinding(@e i3 i3Var) {
        this.u = i3Var;
    }

    public final void setListener(@e q<? super String, ? super String, ? super String, t1> qVar) {
        this.v = qVar;
    }
}
