package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.dialog.AddCardConsignmentDialog;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ApplyForActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.ApplyForActivity$onItemClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ ApplyForItem $card;
        public final /* synthetic */ ApplyForActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ApplyForItem applyForItem, ApplyForActivity applyForActivity) {
            super(0);
            this.$card = applyForItem;
            this.this$0 = applyForActivity;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Integer warehouseOrderProductId = this.$card.getWarehouseOrderProductId();
            if (warehouseOrderProductId == null) {
                return;
            }
            ApplyForActivity applyForActivity = this.this$0;
            BinderKt.k(e.g.d.a.j(((ApplyForViewModel) applyForActivity.L()).q0(warehouseOrderProductId.intValue()), null, new ApplyForActivity$onItemClick$1$1$1$1(applyForActivity), 1, null), applyForActivity, false, 2, null);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.ApplyForActivity$onItemClick$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements p<WantCard, Boolean, t1> {
        public final /* synthetic */ ApplyForItem $card;
        public final /* synthetic */ ApplyForActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.entrepot.ApplyForActivity$onItemClick$1$2$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
            public final /* synthetic */ ApplyForActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ApplyForActivity applyForActivity) {
                super(1);
                this.this$0 = applyForActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                invoke2(t1Var);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e t1 t1Var) {
                this.this$0.F();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApplyForActivity applyForActivity, ApplyForItem applyForItem) {
            super(2);
            this.this$0 = applyForActivity;
            this.$card = applyForItem;
        }

        @Override // h.k2.u.p
        public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard, Boolean bool) {
            invoke2(wantCard, bool);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d WantCard wantCard, @e Boolean bool) {
            ApplyForViewModel applyForViewModel = (ApplyForViewModel) this.this$0.L();
            Integer warehouseOrderProductId = this.$card.getWarehouseOrderProductId();
            int intValue = warehouseOrderProductId == null ? 0 : warehouseOrderProductId.intValue();
            Float wishPrice = wantCard.getWishPrice();
            BinderKt.k(e.g.d.a.j(applyForViewModel.x0(intValue, wishPrice == null ? 0.0f : wishPrice.floatValue(), wantCard.getQuantity()), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForActivity$onItemClick$1(ApplyForActivity applyForActivity) {
        super(2);
        this.this$0 = applyForActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<ApplyForItem> value = ((ApplyForViewModel) this.this$0.L()).r0().getValue();
        ApplyForItem applyForItem = value == null ? null : (ApplyForItem) CollectionsKt___CollectionsKt.J2(value, i2);
        if (applyForItem == null) {
            return;
        }
        ApplyForActivity applyForActivity = this.this$0;
        new AddCardConsignmentDialog(applyForActivity, ((ApplyForViewModel) applyForActivity.L()).t0(applyForItem), applyForItem, null, null, null, true, new AnonymousClass1(applyForItem, this.this$0), new AnonymousClass2(this.this$0, applyForItem), null, 568, null).y();
    }
}
