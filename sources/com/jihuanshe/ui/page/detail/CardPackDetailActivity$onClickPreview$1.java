package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import com.vector.network.image.NImageView;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$onClickPreview$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ NImageView $image;
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$onClickPreview$1(CardPackDetailActivity cardPackDetailActivity, NImageView nImageView) {
        super(1);
        this.this$0 = cardPackDetailActivity;
        this.$image = nImageView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        CardPackDetailActivity cardPackDetailActivity = this.this$0;
        PackDetailResult value = ((CardPackDetailViewModel) cardPackDetailActivity.L()).B0().getValue();
        new k(cardPackDetailActivity, value == null ? null : value.getImg(), this.$image).t();
    }
}
