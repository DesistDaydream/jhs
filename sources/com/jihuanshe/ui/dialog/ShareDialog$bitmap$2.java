package com.jihuanshe.ui.dialog;

import android.graphics.Bitmap;
import com.vector.ext.view.ViewKt;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShareDialog$bitmap$2 extends Lambda implements a<Bitmap> {
    public final /* synthetic */ ShareDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialog$bitmap$2(ShareDialog shareDialog) {
        super(0);
        this.this$0 = shareDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final Bitmap invoke() {
        return ViewKt.L(this.this$0.getRootView(), null, 1, null);
    }
}
