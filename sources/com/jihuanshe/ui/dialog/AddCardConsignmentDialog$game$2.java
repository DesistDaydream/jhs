package com.jihuanshe.ui.dialog;

import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import h.k2.u.a;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardConsignmentDialog$game$2 extends Lambda implements a<Game> {
    public final /* synthetic */ AddCardConsignmentDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardConsignmentDialog$game$2(AddCardConsignmentDialog addCardConsignmentDialog) {
        super(0);
        this.this$0 = addCardConsignmentDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final Game invoke() {
        CardProductNew cardProduct = this.this$0.getCardProduct();
        return e.l.l.a.a(cardProduct == null ? null : cardProduct.getGameKey());
    }
}
