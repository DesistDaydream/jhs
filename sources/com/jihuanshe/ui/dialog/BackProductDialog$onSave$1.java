package com.jihuanshe.ui.dialog;

import android.view.View;
import android.widget.TextView;
import e.l.k.m3;
import h.k2.u.l;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BackProductDialog$onSave$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ BackProductDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackProductDialog$onSave$1(BackProductDialog backProductDialog) {
        super(1);
        this.this$0 = backProductDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@d View view) {
        TextView textView;
        CharSequence text;
        this.this$0.h();
        q<Integer, Integer, String, t1> listener = this.this$0.getListener();
        Integer valueOf = Integer.valueOf(this.this$0.getGoodsType());
        Integer valueOf2 = Integer.valueOf(this.this$0.getReturnType());
        m3 binding = this.this$0.getBinding();
        String str = null;
        if (binding != null && (textView = binding.f13107g) != null && (text = textView.getText()) != null) {
            str = text.toString();
        }
        if (str == null) {
            str = "";
        }
        listener.invoke(valueOf, valueOf2, str);
    }
}
