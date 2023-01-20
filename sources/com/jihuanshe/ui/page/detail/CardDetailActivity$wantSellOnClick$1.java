package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.dialog.HomeWantSellDialog;
import com.jihuanshe.ui.page.shop.AddProductActivityCreator;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$wantSellOnClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.CardDetailActivity$wantSellOnClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ CardDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardDetailActivity cardDetailActivity) {
            super(0);
            this.this$0 = cardDetailActivity;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!f0.g(this.this$0.x0(), "ocg") && (!f0.g(this.this$0.w0(), "pkm") || !f0.g(this.this$0.x0(), "sc"))) {
                CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
                Integer id = value == null ? null : value.getId();
                GameBar.a aVar = GameBar.b;
                Game value2 = aVar.a().getValue();
                String gameKey = value2 == null ? null : value2.getGameKey();
                Game value3 = aVar.a().getValue();
                AddProductActivityCreator.create(id, gameKey, value3 != null ? value3.getGameSubKey() : null).start(this.this$0);
                return;
            }
            CardDetailActivity cardDetailActivity = this.this$0;
            Integer valueOf = Integer.valueOf(HomeWantSellDialog.y.a());
            CardDetailInfo value4 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
            new HomeWantSellDialog(cardDetailActivity, valueOf, value4 != null ? value4.getId() : null).y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$wantSellOnClick$1(CardDetailActivity cardDetailActivity) {
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
        this.this$0.w1(STATConstant.OP_CARD_OR_PACK_DETAIL.CLICK_SELL);
        e.l.l.a.d(new AnonymousClass1(this.this$0));
    }
}
