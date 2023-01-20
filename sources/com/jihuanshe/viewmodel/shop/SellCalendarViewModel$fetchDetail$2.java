package com.jihuanshe.viewmodel.shop;

import e.g.e.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarViewModel$fetchDetail$2 extends Lambda implements l<a, t1> {
    public final /* synthetic */ int $record;
    public final /* synthetic */ SellCalendarViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarViewModel$fetchDetail$2(SellCalendarViewModel sellCalendarViewModel, int i2) {
        super(1);
        this.this$0 = sellCalendarViewModel;
        this.$record = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        if (this.this$0.A0().size() > this.$record) {
            this.this$0.A0().set(this.$record, 0);
        }
    }
}
