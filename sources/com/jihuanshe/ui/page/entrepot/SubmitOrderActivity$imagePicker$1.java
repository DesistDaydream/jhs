package com.jihuanshe.ui.page.entrepot;

import android.net.Uri;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$imagePicker$1 extends Lambda implements l<Uri, t1> {
    public final /* synthetic */ SubmitOrderActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderActivity$imagePicker$1(SubmitOrderActivity submitOrderActivity) {
        super(1);
        this.this$0 = submitOrderActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Uri uri) {
        invoke2(uri);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Uri uri) {
        this.this$0.j0(uri);
    }
}
