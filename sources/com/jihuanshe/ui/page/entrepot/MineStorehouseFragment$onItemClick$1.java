package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.dialog.AddCardConsignmentDialog;
import com.jihuanshe.ui.dialog.WaitCheckDialog;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
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
public final class MineStorehouseFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.MineStorehouseFragment$onItemClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements p<WantCard, Boolean, t1> {
        public final /* synthetic */ WarehouseProductInfo $card;
        public final /* synthetic */ MineStorehouseFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WarehouseProductInfo warehouseProductInfo, MineStorehouseFragment mineStorehouseFragment) {
            super(2);
            this.$card = warehouseProductInfo;
            this.this$0 = mineStorehouseFragment;
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
            MineStorehouseFragment mineStorehouseFragment = this.this$0;
            BinderKt.j(a.j(((MineStorehouseViewModel) mineStorehouseFragment.T()).I0(this.$card.getWarehouseProductId(), wishPrice.floatValue()), null, new MineStorehouseFragment$onItemClick$1$1$1$1(mineStorehouseFragment), 1, null), mineStorehouseFragment, false, 2, null);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.MineStorehouseFragment$onItemClick$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements p<WantCard, Boolean, t1> {
        public final /* synthetic */ WarehouseProductInfo $card;
        public final /* synthetic */ boolean $isSold;
        public final /* synthetic */ MineStorehouseFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WarehouseProductInfo warehouseProductInfo, boolean z, MineStorehouseFragment mineStorehouseFragment) {
            super(2);
            this.$card = warehouseProductInfo;
            this.$isSold = z;
            this.this$0 = mineStorehouseFragment;
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
                MineStorehouseFragment mineStorehouseFragment = this.this$0;
                WarehouseProductInfo warehouseProductInfo = this.$card;
                a.j(((MineStorehouseViewModel) mineStorehouseFragment.T()).I0(warehouseProductInfo.getWarehouseProductId(), wishPrice.floatValue()), null, new MineStorehouseFragment$onItemClick$1$2$1$1(mineStorehouseFragment, bool, wantCard, warehouseProductInfo), 1, null);
            } else if (!f0.e(wantCard.getWishPrice(), this.$card.getPrice()) && f0.g(bool, Boolean.valueOf(this.$isSold))) {
                Float wishPrice2 = wantCard.getWishPrice();
                if (wishPrice2 == null) {
                    return;
                }
                MineStorehouseFragment mineStorehouseFragment2 = this.this$0;
                WarehouseProductInfo warehouseProductInfo2 = this.$card;
                a.j(((MineStorehouseViewModel) mineStorehouseFragment2.T()).I0(warehouseProductInfo2.getWarehouseProductId(), wishPrice2.floatValue()), null, new MineStorehouseFragment$onItemClick$1$2$2$1(warehouseProductInfo2, wantCard, mineStorehouseFragment2), 1, null);
            } else if (!f0.e(wantCard.getWishPrice(), this.$card.getPrice()) || f0.g(bool, Boolean.valueOf(this.$isSold))) {
            } else {
                this.this$0.w0(bool, wantCard.getWishPrice(), this.$card);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$onItemClick$1(MineStorehouseFragment mineStorehouseFragment) {
        super(2);
        this.this$0 = mineStorehouseFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<WarehouseProductInfo> value = ((MineStorehouseViewModel) this.this$0.T()).v0().getValue();
        WarehouseProductInfo warehouseProductInfo = value == null ? null : (WarehouseProductInfo) CollectionsKt___CollectionsKt.J2(value, i2);
        if (warehouseProductInfo == null) {
            return;
        }
        Integer value2 = ((MineStorehouseViewModel) this.this$0.T()).F0().getValue();
        boolean z = value2 != null && value2.intValue() == 1;
        String k0 = this.this$0.k0();
        if (f0.g(k0, "FRAGMENT_CHECK")) {
            Integer value3 = ((MineStorehouseViewModel) this.this$0.T()).F0().getValue();
            if (value3 != null && value3.intValue() == 1) {
                new WaitCheckDialog(this.this$0.requireContext(), ((MineStorehouseViewModel) this.this$0.T()).B0(warehouseProductInfo), warehouseProductInfo, null, new AnonymousClass1(warehouseProductInfo, this.this$0), 8, null).y();
            }
        } else if (f0.g(k0, "FRAGMENT_HOUSE")) {
            new AddCardConsignmentDialog(this.this$0.requireContext(), ((MineStorehouseViewModel) this.this$0.T()).B0(warehouseProductInfo), null, warehouseProductInfo, null, Boolean.valueOf(z), true, null, new AnonymousClass2(warehouseProductInfo, z, this.this$0), null, 656, null).y();
        }
    }
}
