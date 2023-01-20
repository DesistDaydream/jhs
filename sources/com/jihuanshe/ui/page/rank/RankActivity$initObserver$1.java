package com.jihuanshe.ui.page.rank;

import android.widget.TextView;
import com.jihuanshe.model.RankTypeInfo;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankActivity$initObserver$1 extends Lambda implements l<RankTypeInfo, t1> {
    public final /* synthetic */ RankActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankActivity$initObserver$1(RankActivity rankActivity) {
        super(1);
        this.this$0 = rankActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(RankTypeInfo rankTypeInfo) {
        invoke2(rankTypeInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d RankTypeInfo rankTypeInfo) {
        TextView j0 = this.this$0.j0();
        if (j0 == null) {
            return;
        }
        j0.setText(rankTypeInfo.getRankingTypeName());
    }
}
