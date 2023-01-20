package com.jihuanshe.ui.page.common.card;

import android.view.View;
import com.jihuanshe.model.CardProductNew;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ProductManagerHeaderImpl$clickDeleteImage$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProductNew $product;
    public final /* synthetic */ ProductManagerHeaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductManagerHeaderImpl$clickDeleteImage$1(CardProductNew cardProductNew, ProductManagerHeaderImpl productManagerHeaderImpl) {
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
        if (cardProductNew.hasImage()) {
            this.$product.clearImage();
        }
        this.$product.setClickCloseDefaultImage(true);
        this.this$0.s(this.$product);
    }
}
