package com.jihuanshe.ui.page.shop;

import com.jihuanshe.R;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.PendingProduct;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import com.vector.util.Res;
import e.g.d.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseCardActivity$showAmendDialog$2 extends Lambda implements p<WantCard, Boolean, t1> {
    public final /* synthetic */ ApplyForItem $it;
    public final /* synthetic */ ChooseCardActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$showAmendDialog$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ WantCard $wantCard;
        public final /* synthetic */ ChooseCardActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChooseCardActivity chooseCardActivity, WantCard wantCard) {
            super(1);
            this.this$0 = chooseCardActivity;
            this.$wantCard = wantCard;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            PendingProduct value = this.this$0.m0().getValue();
            if (value != null) {
                Float wishPrice = this.$wantCard.getWishPrice();
                value.setPrice(wishPrice == null ? 0.0f : wishPrice.floatValue());
            }
            PendingProduct value2 = this.this$0.m0().getValue();
            if (value2 != null) {
                value2.setQuantity(this.$wantCard.getQuantity());
            }
            this.this$0.m0().n();
            e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), null, null, null, 0, null, 62, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardActivity$showAmendDialog$2(ChooseCardActivity chooseCardActivity, ApplyForItem applyForItem) {
        super(2);
        this.this$0 = chooseCardActivity;
        this.$it = applyForItem;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard, Boolean bool) {
        invoke2(wantCard, bool);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d WantCard wantCard, @e Boolean bool) {
        ApplyForViewModel Z = this.this$0.Z();
        Integer warehouseOrderProductId = this.$it.getWarehouseOrderProductId();
        int intValue = warehouseOrderProductId == null ? 0 : warehouseOrderProductId.intValue();
        Float wishPrice = wantCard.getWishPrice();
        a.j(Z.x0(intValue, wishPrice == null ? 0.0f : wishPrice.floatValue(), wantCard.getQuantity()), null, new AnonymousClass1(this.this$0, wantCard), 1, null);
    }
}
