package com.jihuanshe.ui.page.rank;

import androidx.lifecycle.ViewModelProvider;
import com.jihuanshe.viewmodel.rank.RankViewModel;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankListFragment$parentViewModel$2 extends Lambda implements a<RankViewModel> {
    public final /* synthetic */ RankListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankListFragment$parentViewModel$2(RankListFragment rankListFragment) {
        super(0);
        this.this$0 = rankListFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final RankViewModel invoke() {
        return (RankViewModel) new ViewModelProvider(this.this$0.requireActivity()).get(RankViewModel.class);
    }
}
