package com.jihuanshe.viewmodel.main.shop;

import e.g.e.a;
import e.l.h.i.f;
import e.l.h.k.b;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopViewModel$getCards$4 extends Lambda implements l<a, t1> {
    public final /* synthetic */ ShopViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopViewModel$getCards$4(ShopViewModel shopViewModel) {
        super(1);
        this.this$0 = shopViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        f fVar;
        fVar = this.this$0.f4475c;
        fVar.h();
        b.a.b("ShopViewModel", f0.C("get card fail. ", aVar.h()));
    }
}
