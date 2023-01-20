package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$flowOfSetup$1 extends Lambda implements l<Game, t1> {
    public final /* synthetic */ WantBuyActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$flowOfSetup$1(WantBuyActivity wantBuyActivity) {
        super(1);
        this.this$0 = wantBuyActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Game game) {
        invoke2(game);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Game game) {
        boolean z;
        ListView h0;
        z = this.this$0.x;
        if (z) {
            this.this$0.x = false;
            return;
        }
        a t0 = WantBuyViewModel.t0((WantBuyViewModel) this.this$0.L(), null, 1, null);
        WantBuyActivity wantBuyActivity = this.this$0;
        h0 = wantBuyActivity.h0();
        BinderKt.k(BinderKt.e(t0, wantBuyActivity, h0, false, 4, null), this.this$0, false, 2, null);
    }
}
