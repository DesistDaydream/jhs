package com.jihuanshe.ui.page.rank;

import com.jihuanshe.viewmodel.rank.RankViewModel;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankActivity$onChooseCategory$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ RankActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankActivity$onChooseCategory$1(RankActivity rankActivity) {
        super(1);
        this.this$0 = rankActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        ((RankViewModel) this.this$0.L()).z0(i2);
    }
}
