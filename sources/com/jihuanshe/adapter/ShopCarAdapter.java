package com.jihuanshe.adapter;

import android.graphics.Bitmap;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.ui.page.user.SellerDetailActivity;
import e.l.r.h0;
import e.t.j.h.g;
import e.t.r.a.n.c;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class ShopCarAdapter extends e.t.k.a.c.a<CardProduct> {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final SellerDetailActivity f3769d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f3770e;

    /* loaded from: classes2.dex */
    public static final class a implements c {
        @Override // e.t.r.a.n.c
        @d
        public Bitmap a(@d Bitmap bitmap) {
            return h0.a.a(bitmap);
        }
    }

    public ShopCarAdapter(@d SellerDetailActivity sellerDetailActivity) {
        super(null, 1, null);
        this.f3769d = sellerDetailActivity;
        this.f3770e = CollectionsKt__CollectionsKt.P(new a());
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_shop_card;
    }

    @d
    public final SellerDetailActivity v() {
        return this.f3769d;
    }

    @d
    public final List<c> w() {
        return this.f3770e;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: x */
    public void u(@d CardProduct cardProduct, @d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this.f3769d);
        viewDataBinding.setVariable(8, cardProduct);
        viewDataBinding.setVariable(2, this);
    }

    @d
    public final g y(@e String str) {
        return e.t.j.h.d.a.a(new ShopCarAdapter$onClickImage$1(str, this));
    }
}
