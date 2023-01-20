package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickLike$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickLike$1(CardDetailActivity cardDetailActivity) {
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
        Integer likeCount;
        Integer id;
        Integer likeCount2;
        Integer id2;
        Boolean bool = Boolean.FALSE;
        this.this$0.w1(STATConstant.OP_CARD_OR_PACK_DETAIL.CLICK_LIKE);
        CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        int i2 = 0;
        Integer num = null;
        if (value == null ? false : f0.g(value.isLike(), bool)) {
            CardDetailViewModel cardDetailViewModel = (CardDetailViewModel) this.this$0.L();
            CardDetailInfo value2 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
            if (value2 != null && (id2 = value2.getId()) != null) {
                i2 = id2.intValue();
            }
            cardDetailViewModel.c1(i2);
            CardDetailInfo value3 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
            if (value3 != null) {
                value3.setLike(Boolean.TRUE);
            }
            CardDetailInfo value4 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
            if (value4 != null) {
                CardDetailInfo value5 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
                if (value5 != null && (likeCount2 = value5.getLikeCount()) != null) {
                    num = Integer.valueOf(likeCount2.intValue() + 1);
                }
                value4.setLikeCount(num);
            }
        } else {
            CardDetailViewModel cardDetailViewModel2 = (CardDetailViewModel) this.this$0.L();
            CardDetailInfo value6 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
            if (value6 != null && (id = value6.getId()) != null) {
                i2 = id.intValue();
            }
            cardDetailViewModel2.f1(i2);
            CardDetailInfo value7 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
            if (value7 != null) {
                value7.setLike(bool);
            }
            CardDetailInfo value8 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
            if (value8 != null) {
                CardDetailInfo value9 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
                if (value9 != null && (likeCount = value9.getLikeCount()) != null) {
                    num = Integer.valueOf(likeCount.intValue() - 1);
                }
                value8.setLikeCount(num);
            }
        }
        ((CardDetailViewModel) this.this$0.L()).C0().n();
    }
}
