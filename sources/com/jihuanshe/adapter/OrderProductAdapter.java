package com.jihuanshe.adapter;

import android.app.Activity;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;
import com.vector.network.image.NImageView;
import e.l.g.e;
import e.t.j.h.g;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class OrderProductAdapter extends e<CardProduct> {
    @d

    /* renamed from: c  reason: collision with root package name */
    private final Activity f3755c;

    public OrderProductAdapter(@d Activity activity) {
        this.f3755c = activity;
    }

    @Override // e.l.g.e
    public int b() {
        return R.layout.item_order_product;
    }

    @d
    public final Activity h() {
        return this.f3755c;
    }

    @Override // e.l.g.e
    /* renamed from: i */
    public void d(@k.e.a.e CardProduct cardProduct, @k.e.a.e ViewDataBinding viewDataBinding) {
        if (viewDataBinding == null || cardProduct == null) {
            return;
        }
        viewDataBinding.setVariable(8, cardProduct);
        viewDataBinding.setVariable(2, this);
    }

    @d
    public final g j(@d String str, @d NImageView nImageView) {
        return e.t.j.h.d.a.a(new OrderProductAdapter$onClickImage$1(this, str, nImageView));
    }
}
