package com.jihuanshe.ui.page.common.card;

import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.model.CardProductNew;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ProductManagerHeaderImpl$clickProductDefaultCover$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProductNew $product;
    public final /* synthetic */ ProductManagerHeaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductManagerHeaderImpl$clickProductDefaultCover$1(CardProductNew cardProductNew, ProductManagerHeaderImpl productManagerHeaderImpl) {
        super(1);
        this.$product = cardProductNew;
        this.this$0 = productManagerHeaderImpl;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        CardProductNew cardProductNew = this.$product;
        if (cardProductNew == null) {
            return;
        }
        String cardVersionDefaultImage = cardProductNew.getCardVersionDefaultImage();
        if (cardVersionDefaultImage == null || cardVersionDefaultImage.length() == 0) {
            return;
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity == null) {
            Fragment m2 = this.this$0.m();
            activity = m2 == null ? null : m2.getActivity();
        }
        new k(activity, this.$product.getCardVersionDefaultImage(), (ImageView) view).t();
    }
}
