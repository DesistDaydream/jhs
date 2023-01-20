package com.jihuanshe.ui.page.detail;

import android.graphics.Rect;
import android.view.View;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.ui.widget.imagepreview.GPreviewBuilder;
import com.jihuanshe.ui.widget.imagepreview.enitity.ImageViewInfo;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.network.image.NImageView;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickPreview$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ NImageView $image;
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickPreview$1(CardDetailActivity cardDetailActivity, NImageView nImageView) {
        super(1);
        this.this$0 = cardDetailActivity;
        this.$image = nImageView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (((CardDetailViewModel) this.this$0.L()).E0().getValue() != null && (!((CardDetailViewModel) this.this$0.L()).E0().getValue().isEmpty())) {
            ArrayList arrayList = new ArrayList();
            Rect rect = new Rect();
            this.$image.getGlobalVisibleRect(rect);
            for (CardViewInfo cardViewInfo : ((CardDetailViewModel) this.this$0.L()).E0().getValue()) {
                arrayList.add(new ImageViewInfo(cardViewInfo.getImage(), rect, String.valueOf(cardViewInfo.getUserId()), cardViewInfo.getUserName(), cardViewInfo.getAvatar()));
            }
            GPreviewBuilder.a(this.this$0).f(arrayList).n(false).e(0).c(false).o(GPreviewBuilder.IndicatorType.Number).q();
            return;
        }
        CardDetailActivity cardDetailActivity = this.this$0;
        CardDetailInfo value = ((CardDetailViewModel) cardDetailActivity.L()).C0().getValue();
        new k(cardDetailActivity, value == null ? null : value.getImg(), this.$image).t();
    }
}
