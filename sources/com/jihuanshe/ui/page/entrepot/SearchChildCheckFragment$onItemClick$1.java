package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.dialog.AddCardConsignmentDialog;
import com.jihuanshe.ui.dialog.WaitCheckDialog;
import com.jihuanshe.viewmodel.entrepot.SearchChildCheckViewModel;
import e.g.d.a;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchChildCheckFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SearchChildCheckFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment$onItemClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements p<WantCard, Boolean, t1> {
        public final /* synthetic */ WarehouseProductInfo $card;
        public final /* synthetic */ SearchChildCheckFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WarehouseProductInfo warehouseProductInfo, SearchChildCheckFragment searchChildCheckFragment) {
            super(2);
            this.$card = warehouseProductInfo;
            this.this$0 = searchChildCheckFragment;
        }

        @Override // h.k2.u.p
        public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard, Boolean bool) {
            invoke2(wantCard, bool);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d WantCard wantCard, @e Boolean bool) {
            Float wishPrice;
            if (f0.e(wantCard.getWishPrice(), this.$card.getPrice()) || (wishPrice = wantCard.getWishPrice()) == null) {
                return;
            }
            SearchChildCheckFragment searchChildCheckFragment = this.this$0;
            a.j(((SearchChildCheckViewModel) searchChildCheckFragment.T()).u0(this.$card.getWarehouseProductId(), wishPrice.floatValue()), null, new SearchChildCheckFragment$onItemClick$1$1$1$1(searchChildCheckFragment), 1, null);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment$onItemClick$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements p<WantCard, Boolean, t1> {
        public final /* synthetic */ WarehouseProductInfo $card;
        public final /* synthetic */ boolean $isSold;
        public final /* synthetic */ SearchChildCheckFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WarehouseProductInfo warehouseProductInfo, boolean z, SearchChildCheckFragment searchChildCheckFragment) {
            super(2);
            this.$card = warehouseProductInfo;
            this.$isSold = z;
            this.this$0 = searchChildCheckFragment;
        }

        @Override // h.k2.u.p
        public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard, Boolean bool) {
            invoke2(wantCard, bool);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d WantCard wantCard, @e Boolean bool) {
            if (!f0.e(wantCard.getWishPrice(), this.$card.getPrice()) && !f0.g(bool, Boolean.valueOf(this.$isSold))) {
                Float wishPrice = wantCard.getWishPrice();
                if (wishPrice == null) {
                    return;
                }
                SearchChildCheckFragment searchChildCheckFragment = this.this$0;
                WarehouseProductInfo warehouseProductInfo = this.$card;
                a.j(((SearchChildCheckViewModel) searchChildCheckFragment.T()).u0(warehouseProductInfo.getWarehouseProductId(), wishPrice.floatValue()), null, new SearchChildCheckFragment$onItemClick$1$2$1$1(searchChildCheckFragment, bool, wantCard, warehouseProductInfo), 1, null);
            } else if (!f0.e(wantCard.getWishPrice(), this.$card.getPrice()) && f0.g(bool, Boolean.valueOf(this.$isSold))) {
                Float wishPrice2 = wantCard.getWishPrice();
                if (wishPrice2 == null) {
                    return;
                }
                SearchChildCheckFragment searchChildCheckFragment2 = this.this$0;
                WarehouseProductInfo warehouseProductInfo2 = this.$card;
                a.j(((SearchChildCheckViewModel) searchChildCheckFragment2.T()).u0(warehouseProductInfo2.getWarehouseProductId(), wishPrice2.floatValue()), null, new SearchChildCheckFragment$onItemClick$1$2$2$1(searchChildCheckFragment2), 1, null);
            } else if (!f0.e(wantCard.getWishPrice(), this.$card.getPrice()) || f0.g(bool, Boolean.valueOf(this.$isSold))) {
            } else {
                this.this$0.o0(bool, wantCard.getWishPrice(), this.$card.getWarehouseProductId());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchChildCheckFragment$onItemClick$1(SearchChildCheckFragment searchChildCheckFragment) {
        super(2);
        this.this$0 = searchChildCheckFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<WarehouseProductInfo> value = ((SearchChildCheckViewModel) this.this$0.T()).q0().getValue();
        WarehouseProductInfo warehouseProductInfo = value == null ? null : (WarehouseProductInfo) CollectionsKt___CollectionsKt.J2(value, i2);
        if (warehouseProductInfo == null) {
            return;
        }
        boolean g2 = f0.g(this.this$0.g0(), SearchChildCheckFragment.C);
        String g0 = this.this$0.g0();
        int hashCode = g0.hashCode();
        if (hashCode != -1325842777) {
            if (hashCode != -1292100439) {
                if (hashCode == -278206615 && g0.equals(SearchChildCheckFragment.B)) {
                    new WaitCheckDialog(this.this$0.requireContext(), ((SearchChildCheckViewModel) this.this$0.T()).r0(warehouseProductInfo), warehouseProductInfo, null, new AnonymousClass1(warehouseProductInfo, this.this$0), 8, null).y();
                    return;
                }
                return;
            } else if (!g0.equals(SearchChildCheckFragment.D)) {
                return;
            }
        } else if (!g0.equals(SearchChildCheckFragment.C)) {
            return;
        }
        new AddCardConsignmentDialog(this.this$0.requireContext(), ((SearchChildCheckViewModel) this.this$0.T()).r0(warehouseProductInfo), null, warehouseProductInfo, null, Boolean.valueOf(g2), true, null, new AnonymousClass2(warehouseProductInfo, g2, this.this$0), null, 656, null).y();
    }
}
