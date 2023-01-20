package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.ApplyForOrder;
import com.jihuanshe.model.CardProductNew;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.x;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class ApplyForViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c */
    private final NLive<List<ApplyForItem>> f4414c = new NLive<>(null, 1, null);
    @d

    /* renamed from: d */
    private final NLive<ApplyForOrder> f4415d = new NLive<>(null, 1, null);

    public static /* synthetic */ a v0(ApplyForViewModel applyForViewModel, Integer num, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = 0;
        }
        if ((i2 & 2) != 0) {
            state = null;
        }
        return applyForViewModel.u0(num, state);
    }

    @d
    public final a<t1> q0(int i2) {
        return a.h(FlowKt.c(x.a.b((x) e.l.n.a.d(x.class, true, false, false, 60L, true), i2, null, null, 6, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<ApplyForItem>> r0() {
        return this.f4414c;
    }

    @d
    public final NLive<ApplyForOrder> s0() {
        return this.f4415d;
    }

    @d
    public final CardProductNew t0(@d ApplyForItem applyForItem) {
        CardProductNew cardProductNew = new CardProductNew(0.0f, 0.0f, 0, null, null, null, null, null, null, 0.0f, false, null, false, null, null, null, null, null, 262143, null);
        cardProductNew.setGameKey(applyForItem.getGameKey());
        Float avgPrice = applyForItem.getAvgPrice();
        cardProductNew.setAvgPrice(avgPrice == null ? 0.0f : avgPrice.floatValue());
        cardProductNew.setCardId(applyForItem.getCardId().intValue());
        cardProductNew.setPrice(applyForItem.getPrice());
        cardProductNew.setCardNameCn(applyForItem.getCardName());
        cardProductNew.setCardVersionImage(applyForItem.getCardVersionImageUrl());
        cardProductNew.setCardVersionNumber(applyForItem.getCardVersionNumber());
        cardProductNew.setCardVersionRarity(applyForItem.getCardVersionRarity());
        cardProductNew.setMinPrice(applyForItem.getMinPrice());
        cardProductNew.setNeedPublishLocation(applyForItem.getNeedPublishLocation().booleanValue());
        cardProductNew.setProducts(CollectionsKt__CollectionsKt.E());
        cardProductNew.setWarehousePendingProducts(CollectionsKt__CollectionsKt.E());
        cardProductNew.setWarehouseProducts(CollectionsKt__CollectionsKt.E());
        return cardProductNew;
    }

    @d
    public final a<e<ApplyForItem>> u0(@k.e.a.e Integer num, @k.e.a.e LoadMore.State state) {
        Integer warehouseOrderId;
        x xVar = (x) e.l.n.a.d(x.class, true, false, false, 60L, true);
        ApplyForOrder value = this.f4415d.getValue();
        int i2 = 0;
        if (value != null && (warehouseOrderId = value.getWarehouseOrderId()) != null) {
            i2 = warehouseOrderId.intValue();
        }
        return a.h(a.o(BinderKt.b(FlowKt.c(x.a.c(xVar, i2, this.b.a(state).d(), null, null, 12, null)), this.f4414c, this.b.f()), null, new ApplyForViewModel$getWarehouseOrderList$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<ApplyForOrder> w0() {
        return a.h(FlowKt.a(x.a.d((x) e.l.n.a.d(x.class, true, false, false, 60L, true), null, null, 3, null), this.f4415d), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> x0(int i2, float f2, int i3) {
        return a.h(FlowKt.c(x.a.f((x) e.l.n.a.d(x.class, true, false, false, 60L, true), i2, f2, i3, null, null, 24, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
