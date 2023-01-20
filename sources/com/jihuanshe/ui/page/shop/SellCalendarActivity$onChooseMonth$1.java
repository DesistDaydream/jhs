package com.jihuanshe.ui.page.shop;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.viewmodel.shop.SellCalendarViewModel;
import com.vector.view.scrollable.ListView;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarActivity$onChooseMonth$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ SellCalendarActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarActivity$onChooseMonth$1(SellCalendarActivity sellCalendarActivity) {
        super(1);
        this.this$0 = sellCalendarActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        ListView g0;
        Integer t0 = ((SellCalendarViewModel) this.this$0.L()).t0(i2);
        if (t0 == null || t0.intValue() < 0) {
            return;
        }
        g0 = this.this$0.g0();
        RecyclerView.LayoutManager layoutManager = g0.getScrollable().getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        linearLayoutManager.scrollToPositionWithOffset(t0.intValue(), 0);
    }
}
