package com.jihuanshe.ui.page.shop;

import com.jihuanshe.model.ApplyForItem;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseCardActivity$flowOfSetup$3 extends Lambda implements l<List<? extends ApplyForItem>, t1> {
    public final /* synthetic */ ChooseCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardActivity$flowOfSetup$3(ChooseCardActivity chooseCardActivity) {
        super(1);
        this.this$0 = chooseCardActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends ApplyForItem> list) {
        invoke2((List<ApplyForItem>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<ApplyForItem> list) {
        this.this$0.y0(list);
    }
}
