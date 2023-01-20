package com.jihuanshe.ui.page.user;

import android.net.Uri;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$imagePicker$1 extends Lambda implements l<Uri, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$imagePicker$1(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Uri uri) {
        invoke2(uri);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Uri uri) {
        this.this$0.c1(uri);
    }
}
