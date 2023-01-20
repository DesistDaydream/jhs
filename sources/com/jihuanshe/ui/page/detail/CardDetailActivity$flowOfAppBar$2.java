package com.jihuanshe.ui.page.detail;

import android.content.res.ColorStateList;
import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CardBaseInfoDetailDialog;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.design.ui.nav.ImageAttrs;
import com.vector.ext.AnyKt;
import com.vector.util.Res;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$flowOfAppBar$2 extends Lambda implements l<ImageAttrs, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.CardDetailActivity$flowOfAppBar$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ CardDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardDetailActivity cardDetailActivity) {
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
            if (AnyKt.k(((CardDetailViewModel) this.this$0.L()).C0().getValue())) {
                CardBaseInfoDetailDialog.a aVar = CardBaseInfoDetailDialog.f3950m;
                int cardID = ((CardDetailViewModel) this.this$0.L()).C0().getValue().getCardID();
                Integer id = ((CardDetailViewModel) this.this$0.L()).C0().getValue().getId();
                int intValue = id == null ? 0 : id.intValue();
                String w0 = this.this$0.w0();
                if (w0 == null) {
                    w0 = "";
                }
                aVar.a(cardID, intValue, w0).show(this.this$0.getSupportFragmentManager(), "card_detail");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$flowOfAppBar$2(CardDetailActivity cardDetailActivity) {
        super(1);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ImageAttrs imageAttrs) {
        invoke2(imageAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ImageAttrs imageAttrs) {
        d.a aVar = e.t.o.d.a;
        imageAttrs.y(d.a.c(aVar, null, 1, null).d(24));
        imageAttrs.D(d.a.c(aVar, null, 1, null).d(45));
        imageAttrs.v(d.a.c(aVar, null, 1, null).d(32));
        imageAttrs.x(R.drawable.svg_show_detail);
        imageAttrs.C(ColorStateList.valueOf(Res.k(R.color.black)));
        imageAttrs.t(R.drawable.bg_search_left_bar);
        imageAttrs.g(new AnonymousClass1(this.this$0));
    }
}
