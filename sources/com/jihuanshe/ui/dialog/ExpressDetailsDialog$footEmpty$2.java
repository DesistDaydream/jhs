package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.widget.TextView;
import e.t.o.d;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ExpressDetailsDialog$footEmpty$2 extends Lambda implements a<TextView> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressDetailsDialog$footEmpty$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final TextView invoke() {
        TextView textView = new TextView(this.$context);
        textView.setHeight(d.a.c(e.t.o.d.a, null, 1, null).d(26));
        return textView;
    }
}
