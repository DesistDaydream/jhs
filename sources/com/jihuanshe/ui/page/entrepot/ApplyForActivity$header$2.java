package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import android.view.ViewGroup;
import e.t.o.d;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForActivity$header$2 extends Lambda implements a<View> {
    public final /* synthetic */ ApplyForActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForActivity$header$2(ApplyForActivity applyForActivity) {
        super(0);
        this.this$0 = applyForActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final View invoke() {
        View view = new View(this.this$0);
        view.setBackgroundColor(-1);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, d.a.c(e.t.o.d.a, null, 1, null).d(34)));
        return view;
    }
}
