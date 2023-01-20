package com.jihuanshe.ui.page.rank;

import com.jihuanshe.ui.page.rank.RankListFragment;
import com.jihuanshe.ui.page.rank.RankListFragment$initObserver$2;
import com.vector.view.scrollable.ListView;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankListFragment$initObserver$2 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ RankListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankListFragment$initObserver$2(RankListFragment rankListFragment) {
        super(1);
        this.this$0 = rankListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m29invoke$lambda0(RankListFragment rankListFragment) {
        rankListFragment.p0().Q(0, Boolean.FALSE);
        rankListFragment.B0();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        this.this$0.p0().e();
        this.this$0.M();
        ListView p0 = this.this$0.p0();
        final RankListFragment rankListFragment = this.this$0;
        p0.postDelayed(new Runnable() { // from class: e.l.q.b.i.d
            @Override // java.lang.Runnable
            public final void run() {
                RankListFragment$initObserver$2.m29invoke$lambda0(RankListFragment.this);
            }
        }, 100L);
    }
}
