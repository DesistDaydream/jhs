package com.jihuanshe.ui.page.search.fragments.cardrepo;

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
public final class CardRepoSearchFragment$showAmendDialog$2 extends Lambda implements p<WantCard, Boolean, t1> {
    public final /* synthetic */ ApplyForItem $it;
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$showAmendDialog$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ WantCard $wantCard;
        public final /* synthetic */ CardRepoSearchFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardRepoSearchFragment cardRepoSearchFragment, WantCard wantCard) {
            super(1);
            this.this$0 = cardRepoSearchFragment;
            this.$wantCard = wantCard;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            PendingProduct value = this.this$0.w0().getValue();
            if (value != null) {
                Float wishPrice = this.$wantCard.getWishPrice();
                value.setPrice(wishPrice == null ? 0.0f : wishPrice.floatValue());
            }
            PendingProduct value2 = this.this$0.w0().getValue();
            if (value2 != null) {
                value2.setQuantity(this.$wantCard.getQuantity());
            }
            this.this$0.w0().n();
            e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$showAmendDialog$2(CardRepoSearchFragment cardRepoSearchFragment, ApplyForItem applyForItem) {
        super(2);
        this.this$0 = cardRepoSearchFragment;
        this.$it = applyForItem;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard, Boolean bool) {
        invoke2(wantCard, bool);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d WantCard wantCard, @e Boolean bool) {
        ApplyForViewModel l0 = this.this$0.l0();
        Integer warehouseOrderProductId = this.$it.getWarehouseOrderProductId();
        int intValue = warehouseOrderProductId == null ? 0 : warehouseOrderProductId.intValue();
        Float wishPrice = wantCard.getWishPrice();
        a.j(l0.x0(intValue, wishPrice == null ? 0.0f : wishPrice.floatValue(), wantCard.getQuantity()), null, new AnonymousClass1(this.this$0, wantCard), 1, null);
    }
}
