package com.jihuanshe.ui.page.main.shop;

import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class ShopFragment$initObserver$6 extends Lambda implements l<Pair<? extends String, ? extends String>, t1> {
    public final /* synthetic */ Ref.BooleanRef $isFirst;
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$initObserver$6(Ref.BooleanRef booleanRef, ShopFragment shopFragment) {
        super(1);
        this.$isFirst = booleanRef;
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends String, ? extends String> pair) {
        invoke2((Pair<String, String>) pair);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Pair<String, String> pair) {
        Ref.BooleanRef booleanRef = this.$isFirst;
        if (!booleanRef.element) {
            this.this$0.R0(f0.g(pair.getSecond(), "wish") ? "求购" : "在售");
        } else {
            booleanRef.element = false;
        }
    }
}
