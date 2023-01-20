package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.CardVersionInfo;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.dialog.CardPackListDialog;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickMoreVer$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.CardDetailActivity$onClickMoreVer$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<CardVersionInfo, t1> {
        public final /* synthetic */ CardDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardDetailActivity cardDetailActivity) {
            super(1);
            this.this$0 = cardDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(CardVersionInfo cardVersionInfo) {
            invoke2(cardVersionInfo);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d CardVersionInfo cardVersionInfo) {
            CardDetailActivity cardDetailActivity = this.this$0;
            Integer id = cardVersionInfo.getId();
            cardDetailActivity.s1(id == null ? 0 : id.intValue());
            ((CardDetailViewModel) this.this$0.L()).L0().setValue(2);
            this.this$0.l0(STATConstant.OP_CARD_OR_PACK_DETAIL.CHANGE_VERSION);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickMoreVer$1(CardDetailActivity cardDetailActivity) {
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
        CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        if ((value == null ? null : value.getCardVersions()) == null) {
            return;
        }
        CardDetailActivity cardDetailActivity = this.this$0;
        CardDetailInfo value2 = ((CardDetailViewModel) cardDetailActivity.L()).C0().getValue();
        List<CardVersionInfo> cardVersions = value2 != null ? value2.getCardVersions() : null;
        Integer id = ((CardDetailViewModel) this.this$0.L()).C0().getValue().getId();
        new CardPackListDialog(cardDetailActivity, cardVersions, id == null ? 0 : id.intValue(), new AnonymousClass1(this.this$0)).y();
    }
}
