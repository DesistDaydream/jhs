package com.jihuanshe.ui.page.shop;

import com.jihuanshe.ui.page.shop.SellCalendarActivity;
import com.vector.view.scrollable.ListView;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarActivity$flowOfSetup$1 extends Lambda implements l<Object, t1> {
    public final /* synthetic */ SellCalendarActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarActivity$flowOfSetup$1(SellCalendarActivity sellCalendarActivity) {
        super(1);
        this.this$0 = sellCalendarActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
        invoke2(obj);
        return t1.a;
    }

    @Override // h.k2.u.l
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Object obj) {
        ListView g0;
        g0 = this.this$0.g0();
        final SellCalendarActivity sellCalendarActivity = this.this$0;
        g0.postDelayed(new Runnable() { // from class: e.l.q.b.k.a
            @Override // java.lang.Runnable
            public final void run() {
                SellCalendarActivity.b0(SellCalendarActivity.this);
            }
        }, 50L);
    }
}
