package com.jihuanshe.ui.page.user;

import android.view.View;
import e.l.k.wf;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyMatchActivity$header$2 extends Lambda implements a<View> {
    public final /* synthetic */ WantBuyMatchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyMatchActivity$header$2(WantBuyMatchActivity wantBuyMatchActivity) {
        super(0);
        this.this$0 = wantBuyMatchActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final View invoke() {
        wf d2 = wf.d(this.this$0.getLayoutInflater());
        d2.h(this.this$0);
        return d2.getRoot();
    }
}
