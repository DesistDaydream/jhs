package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.PackDetailResult;
import com.vector.network.image.NImageView;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackListActivity$onClickPreview$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ NImageView $image;
    public final /* synthetic */ CardPackListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackListActivity$onClickPreview$1(CardPackListActivity cardPackListActivity, NImageView nImageView) {
        super(1);
        this.this$0 = cardPackListActivity;
        this.$image = nImageView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        CardPackListActivity cardPackListActivity = this.this$0;
        PackDetailResult l0 = cardPackListActivity.l0();
        new k(cardPackListActivity, l0 == null ? null : l0.getImg(), this.$image).t();
    }
}
