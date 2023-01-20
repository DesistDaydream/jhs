package com.jihuanshe.ui.page.detail;

import com.jihuanshe.model.DatePrice;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$initObserver$3 extends Lambda implements l<List<? extends DatePrice>, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$initObserver$3(CardDetailActivity cardDetailActivity) {
        super(1);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends DatePrice> list) {
        invoke2((List<DatePrice>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<DatePrice> list) {
        if (!list.isEmpty()) {
            this.this$0.i1(list);
        }
    }
}
