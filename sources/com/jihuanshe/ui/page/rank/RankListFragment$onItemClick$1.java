package com.jihuanshe.ui.page.rank;

import android.view.View;
import com.jihuanshe.model.RankCardInfo;
import com.jihuanshe.ui.page.detail.CardDetailActivityCreator;
import com.jihuanshe.ui.page.detail.CardPackDetailActivityCreator;
import com.jihuanshe.viewmodel.rank.RankListViewModel;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankListFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ RankListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankListFragment$onItemClick$1(RankListFragment rankListFragment) {
        super(2);
        this.this$0 = rankListFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<RankCardInfo> value = ((RankListViewModel) this.this$0.T()).p0().getValue();
        RankCardInfo rankCardInfo = value == null ? null : (RankCardInfo) CollectionsKt___CollectionsKt.J2(value, i2);
        if (rankCardInfo == null) {
            return;
        }
        if (f0.g(rankCardInfo.getType(), RankListFragment.E.b())) {
            CardPackDetailActivityCreator.create(Integer.valueOf(rankCardInfo.getId()), rankCardInfo.getGameKey(), rankCardInfo.getGameSubKey()).from("集换榜").start(this.this$0.getActivity());
        } else {
            CardDetailActivityCreator.create(Integer.valueOf(rankCardInfo.getId()), rankCardInfo.getGameKey(), rankCardInfo.getGameSubKey()).from("集换榜").start(this.this$0.getActivity());
        }
    }
}
