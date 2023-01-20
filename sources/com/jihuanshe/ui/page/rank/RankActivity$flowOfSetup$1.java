package com.jihuanshe.ui.page.rank;

import com.jihuanshe.model.RankTypeInfo;
import com.jihuanshe.ui.page.rank.RankActivity;
import com.jihuanshe.ui.page.rank.RankActivity$flowOfSetup$1;
import com.jihuanshe.ui.widget.RankIndicatorView;
import com.jihuanshe.viewmodel.rank.RankViewModel;
import com.vector.view.pager.ViewPager;
import h.k2.u.a;
import h.t1;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankActivity$flowOfSetup$1 extends Lambda implements a<t1> {
    public final /* synthetic */ RankActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankActivity$flowOfSetup$1(RankActivity rankActivity) {
        super(0);
        this.this$0 = rankActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m27invoke$lambda1(RankActivity rankActivity) {
        List<RankTypeInfo> value = ((RankViewModel) rankActivity.L()).y0().getValue();
        if (value == null) {
            return;
        }
        int i2 = 0;
        for (Object obj : value) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            int rankingTypeID = ((RankTypeInfo) obj).getRankingTypeID();
            Integer h0 = rankActivity.h0();
            if (h0 != null && rankingTypeID == h0.intValue()) {
                ViewPager viewPager = rankActivity.i0().getViewPager();
                if (viewPager != null) {
                    viewPager.setCurrentItem(i2);
                }
                ((RankViewModel) rankActivity.L()).z0(i2);
            }
            i2 = i3;
        }
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RankIndicatorView i0 = this.this$0.i0();
        final RankActivity rankActivity = this.this$0;
        i0.postDelayed(new Runnable() { // from class: e.l.q.b.i.a
            @Override // java.lang.Runnable
            public final void run() {
                RankActivity$flowOfSetup$1.m27invoke$lambda1(RankActivity.this);
            }
        }, 10L);
    }
}
