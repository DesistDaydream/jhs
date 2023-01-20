package com.jihuanshe.ui.page.rank;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;
import h.k2.u.r;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankListFragment$onViewScroll$1 extends Lambda implements r<RecyclerView, Integer, Integer, Integer, t1> {
    public final /* synthetic */ RankListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankListFragment$onViewScroll$1(RankListFragment rankListFragment) {
        super(4);
        this.this$0 = rankListFragment;
    }

    @Override // h.k2.u.r
    public /* bridge */ /* synthetic */ t1 invoke(RecyclerView recyclerView, Integer num, Integer num2, Integer num3) {
        invoke(recyclerView, num.intValue(), num2.intValue(), num3.intValue());
        return t1.a;
    }

    public final void invoke(@e RecyclerView recyclerView, int i2, int i3, int i4) {
        ValueAnimator valueAnimator;
        RankListFragment rankListFragment = this.this$0;
        rankListFragment.F0(rankListFragment.w0() + i3);
        valueAnimator = this.this$0.B;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        if (this.this$0.w0() > this.this$0.x0() && this.this$0.z0()) {
            RankListFragment rankListFragment2 = this.this$0;
            rankListFragment2.G0(0, -rankListFragment2.k0().Y().getHeight(), 300L);
        } else if (this.this$0.w0() >= this.this$0.x0() || this.this$0.z0()) {
        } else {
            RankListFragment rankListFragment3 = this.this$0;
            rankListFragment3.G0(-rankListFragment3.k0().Y().getHeight(), 0, 300L);
        }
    }
}
