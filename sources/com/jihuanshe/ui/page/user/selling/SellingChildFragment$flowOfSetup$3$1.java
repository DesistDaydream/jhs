package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.model.GameCard;
import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$flowOfSetup$3$1 extends Lambda implements l<GameCard, Boolean> {
    public final /* synthetic */ int $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$flowOfSetup$3$1(int i2) {
        super(1);
        this.$it = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(GameCard gameCard) {
        return Boolean.valueOf(invoke2(gameCard));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d GameCard gameCard) {
        Integer productId = gameCard.getProductId();
        return productId != null && productId.intValue() == this.$it;
    }
}
