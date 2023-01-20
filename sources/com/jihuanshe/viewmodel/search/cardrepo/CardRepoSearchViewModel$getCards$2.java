package com.jihuanshe.viewmodel.search.cardrepo;

import e.g.e.a;
import e.l.h.k.b;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchViewModel$getCards$2 extends Lambda implements l<a, t1> {
    public final /* synthetic */ CardRepoSearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchViewModel$getCards$2(CardRepoSearchViewModel cardRepoSearchViewModel) {
        super(1);
        this.this$0 = cardRepoSearchViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        this.this$0.D0(false);
        this.this$0.y0().h();
        b.a.b("CardRepoSearchViewModel", f0.C("get card fail. ", aVar.h()));
    }
}
