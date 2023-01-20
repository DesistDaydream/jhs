package com.jihuanshe.ui.dialog;

import com.jihuanshe.model.Game;
import h.k2.u.a;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailDialog$game$2 extends Lambda implements a<Game> {
    public final /* synthetic */ CardDetailDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailDialog$game$2(CardDetailDialog cardDetailDialog) {
        super(0);
        this.this$0 = cardDetailDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final Game invoke() {
        return e.l.l.a.b(this.this$0.getGameKey(), this.this$0.getGameSubKey());
    }
}
