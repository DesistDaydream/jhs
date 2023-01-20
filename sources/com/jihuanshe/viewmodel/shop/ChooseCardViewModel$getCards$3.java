package com.jihuanshe.viewmodel.shop;

import e.g.e.a;
import e.l.h.k.b;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseCardViewModel$getCards$3 extends Lambda implements l<a, t1> {
    public final /* synthetic */ ChooseCardViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardViewModel$getCards$3(ChooseCardViewModel chooseCardViewModel) {
        super(1);
        this.this$0 = chooseCardViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        this.this$0.P0(false);
        this.this$0.I0().h();
        b.a.b("ChooseCardViewModel", f0.C("get card fail. ", aVar.h()));
    }
}
