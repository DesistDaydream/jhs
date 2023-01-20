package com.jihuanshe.ui.page.user;

import android.widget.TextView;
import com.jihuanshe.model.Game;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$flowOfSetup$3 extends Lambda implements l<Game, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$flowOfSetup$3(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Game game) {
        invoke2(game);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Game game) {
        TextView textView;
        if (!this.this$0.f1()) {
            textView = this.this$0.X;
            if (textView != null) {
                textView.setText(game.getName());
            }
            this.this$0.m1(true);
            return;
        }
        this.this$0.t1(false);
    }
}
