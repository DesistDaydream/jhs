package com.jihuanshe.ui.page.rank;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.RankTypeInfo;
import com.jihuanshe.viewmodel.rank.RankListViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankListFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ RankListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankListFragment$onLoadMore$1(RankListFragment rankListFragment) {
        super(2);
        this.this$0 = rankListFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        RankListViewModel rankListViewModel = (RankListViewModel) this.this$0.T();
        Integer value = this.this$0.t0().p0().getValue();
        String a = (value != null && value.intValue() == 1) ? RankListFragment.E.a() : RankListFragment.E.b();
        RankTypeInfo u0 = this.this$0.u0();
        int rankingTypeID = u0 == null ? 0 : u0.getRankingTypeID();
        Game value2 = this.this$0.t0().r0().getValue();
        String gameKey = value2 == null ? null : value2.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        Game value3 = this.this$0.t0().r0().getValue();
        String gameSubKey = value3 != null ? value3.getGameSubKey() : null;
        BinderKt.p(BinderKt.d(rankListViewModel.r0(a, rankingTypeID, gameKey, gameSubKey != null ? gameSubKey : "", state), this.this$0, gVar, true));
    }
}
