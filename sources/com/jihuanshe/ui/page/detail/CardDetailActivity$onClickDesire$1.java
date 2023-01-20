package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickDesire$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickDesire$1(CardDetailActivity cardDetailActivity) {
        super(1);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        this.this$0.w1("愿望单");
        ((CardDetailViewModel) this.this$0.L()).g1(this.this$0.w0(), this.this$0.x0());
    }
}
