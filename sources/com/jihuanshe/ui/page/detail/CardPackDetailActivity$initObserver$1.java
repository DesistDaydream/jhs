package com.jihuanshe.ui.page.detail;

import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import com.vector.util.LayoutManagers;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$initObserver$1 extends Lambda implements l<PackDetailResult, t1> {
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$initObserver$1(CardPackDetailActivity cardPackDetailActivity) {
        super(1);
        this.this$0 = cardPackDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(PackDetailResult packDetailResult) {
        invoke2(packDetailResult);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d PackDetailResult packDetailResult) {
        if (packDetailResult.getCardVersionsResult().isEmpty()) {
            ((CardPackDetailViewModel) this.this$0.L()).z0().setValue(LayoutManagers.f(LayoutManagers.a, 1, null, false, 6, null));
        } else if (packDetailResult.getCardVersionsResult().size() < 5) {
            ((CardPackDetailViewModel) this.this$0.L()).z0().setValue(LayoutManagers.f(LayoutManagers.a, packDetailResult.getCardVersionsResult().size(), null, false, 6, null));
        } else {
            ((CardPackDetailViewModel) this.this$0.L()).z0().setValue(LayoutManagers.f(LayoutManagers.a, 5, null, false, 6, null));
        }
    }
}
