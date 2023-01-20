package com.jihuanshe.viewmodel.detail;

import com.jihuanshe.model.CardDetailInfo;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailViewModel$getCardDetail$2 extends Lambda implements l<CardDetailInfo, t1> {
    public final /* synthetic */ CardDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailViewModel$getCardDetail$2(CardDetailViewModel cardDetailViewModel) {
        super(1);
        this.this$0 = cardDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CardDetailInfo cardDetailInfo) {
        invoke2(cardDetailInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e CardDetailInfo cardDetailInfo) {
        this.this$0.C0().setValue(cardDetailInfo);
    }
}
