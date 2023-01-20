package com.jihuanshe.ui.page.shop;

import com.jihuanshe.model.CardProductNew;
import e.l.s.n.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddProductActivity$onRetryClick$2 extends Lambda implements l<CardProductNew, t1> {
    public final /* synthetic */ AddProductActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddProductActivity$onRetryClick$2(AddProductActivity addProductActivity) {
        super(1);
        this.this$0 = addProductActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CardProductNew cardProductNew) {
        invoke2(cardProductNew);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e CardProductNew cardProductNew) {
        if (cardProductNew != null) {
            cardProductNew.setUserUploadPhotoPath(null);
        }
        ((a) this.this$0.L()).A0().r(cardProductNew);
    }
}
