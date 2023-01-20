package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.model.Rarity;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$flowOfSetup$8 extends Lambda implements l<List<? extends Rarity>, t1> {
    public final /* synthetic */ SellingChildFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$flowOfSetup$8(SellingChildFragment sellingChildFragment) {
        super(1);
        this.this$0 = sellingChildFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
        invoke2((List<Rarity>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<Rarity> list) {
        this.this$0.m0().r0().setValue(list);
    }
}
