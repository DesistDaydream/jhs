package com.jihuanshe.ui.page.rank;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.viewmodel.rank.RankViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankActivity$onFilterGame$1 extends Lambda implements l<Game, t1> {
    public final /* synthetic */ RankActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankActivity$onFilterGame$1(RankActivity rankActivity) {
        super(1);
        this.this$0 = rankActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Game game) {
        invoke2(game);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Game game) {
        ((RankViewModel) this.this$0.L()).r0().setValue(game);
        BinderKt.n(((RankViewModel) this.this$0.L()).A0(), this.this$0);
    }
}
