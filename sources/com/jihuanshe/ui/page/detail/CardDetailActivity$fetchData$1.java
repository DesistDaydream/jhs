package com.jihuanshe.ui.page.detail;

import android.widget.TextView;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.view.scrollable.ListView;
import e.g.e.a;
import e.l.h.i.e;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$fetchData$1 extends Lambda implements l<CardDetailInfo, t1> {
    public final /* synthetic */ String $op;
    public final /* synthetic */ CardDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.CardDetailActivity$fetchData$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<e<GameCard>, t1> {
        public final /* synthetic */ String $op;
        public final /* synthetic */ CardDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, CardDetailActivity cardDetailActivity) {
            super(1);
            this.$op = str;
            this.this$0 = cardDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(e<GameCard> eVar) {
            invoke2(eVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@k.e.a.e e<GameCard> eVar) {
            String str = this.$op;
            if (str == null) {
                this.this$0.x1();
                return;
            }
            if (str.length() > 0) {
                this.this$0.w1(this.$op);
            }
        }
    }

    /* renamed from: com.jihuanshe.ui.page.detail.CardDetailActivity$fetchData$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<a, t1> {
        public final /* synthetic */ String $op;
        public final /* synthetic */ CardDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, CardDetailActivity cardDetailActivity) {
            super(1);
            this.$op = str;
            this.this$0 = cardDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
            invoke2(aVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d a aVar) {
            String str = this.$op;
            if (str == null) {
                this.this$0.x1();
                return;
            }
            if (str.length() > 0) {
                this.this$0.w1(this.$op);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$fetchData$1(CardDetailActivity cardDetailActivity, String str) {
        super(1);
        this.this$0 = cardDetailActivity;
        this.$op = str;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CardDetailInfo cardDetailInfo) {
        invoke2(cardDetailInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.e CardDetailInfo cardDetailInfo) {
        Integer id;
        ListView A0;
        TextView C0 = this.this$0.C0();
        if (C0 != null) {
            C0.setText(cardDetailInfo == null ? null : cardDetailInfo.getNameCN());
        }
        CardDetailViewModel cardDetailViewModel = (CardDetailViewModel) this.this$0.L();
        CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        e.g.d.a o = e.g.d.a.o(e.g.d.a.j(CardDetailViewModel.R0(cardDetailViewModel, (value == null || (id = value.getId()) == null) ? 0 : id.intValue(), this.this$0.w0(), this.this$0.x0(), null, 8, null), null, new AnonymousClass1(this.$op, this.this$0), 1, null), null, new AnonymousClass2(this.$op, this.this$0), 1, null);
        CardDetailActivity cardDetailActivity = this.this$0;
        A0 = cardDetailActivity.A0();
        BinderKt.p(BinderKt.e(o, cardDetailActivity, A0, false, 4, null));
        BinderKt.p(((CardDetailViewModel) this.this$0.L()).Z0(this.this$0.w0(), this.this$0.x0()));
        BinderKt.p(((CardDetailViewModel) this.this$0.L()).a1(this.this$0.U0(), this.this$0.w0()));
    }
}
