package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.WarehouseProductInfo;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class SearchChildCheckViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<WarehouseProductInfo>> f4436c = new NLive<>(null, 1, null);

    @d
    public final NLive<List<WarehouseProductInfo>> q0() {
        return this.f4436c;
    }

    @d
    public final CardProductNew r0(@d WarehouseProductInfo warehouseProductInfo) {
        CardProductNew cardProductNew = new CardProductNew(0.0f, 0.0f, 0, null, null, null, null, null, null, 0.0f, false, null, false, null, null, null, null, null, 262143, null);
        cardProductNew.setGameKey(warehouseProductInfo.getGameKey());
        cardProductNew.setAvgPrice((warehouseProductInfo.getAvgPrice() == null || f0.g(warehouseProductInfo.getAvgPrice(), "")) ? 0.0f : Float.parseFloat(warehouseProductInfo.getAvgPrice()));
        cardProductNew.setCardId(warehouseProductInfo.getCardId());
        cardProductNew.setCardNameCn(warehouseProductInfo.getCardName());
        cardProductNew.setCardVersionImage(warehouseProductInfo.getCardVersionImageUrl());
        cardProductNew.setCardVersionNumber(warehouseProductInfo.getCardVersionNumber());
        cardProductNew.setCardVersionRarity(warehouseProductInfo.getCardVersionRarity());
        String minPrice = warehouseProductInfo.getMinPrice();
        cardProductNew.setMinPrice(minPrice == null || minPrice.length() == 0 ? 0.0f : Float.parseFloat(warehouseProductInfo.getMinPrice()));
        cardProductNew.setNeedPublishLocation(false);
        cardProductNew.setProducts(CollectionsKt__CollectionsKt.E());
        cardProductNew.setWarehousePendingProducts(CollectionsKt__CollectionsKt.E());
        cardProductNew.setWarehouseProducts(CollectionsKt__CollectionsKt.E());
        return cardProductNew;
    }

    @d
    public final a<e<WarehouseProductInfo>> s0(@d String str, @k.e.a.e LoadMore.State state, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, @k.e.a.e String str5) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.k((k) e.l.n.a.d(k.class, true, false, false, 60L, true), str, str2, str3, str4, str5, this.b.a(state).d(), null, null, 192, null)), this.f4436c, this.b.f()), null, new SearchChildCheckViewModel$getWarehouseProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> u0(int i2, float f2) {
        return a.h(FlowKt.c(k.a.m((k) e.l.n.a.d(k.class, true, false, false, 60L, true), Integer.valueOf(i2), f2, null, null, 12, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> v0(int i2, float f2) {
        return a.h(FlowKt.c(k.a.p((k) e.l.n.a.d(k.class, true, false, false, 60L, true), Integer.valueOf(i2), f2, null, null, 12, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> w0(int i2, float f2) {
        return a.h(FlowKt.c(k.a.r((k) e.l.n.a.d(k.class, true, false, false, 60L, true), Integer.valueOf(i2), f2, null, null, 12, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
