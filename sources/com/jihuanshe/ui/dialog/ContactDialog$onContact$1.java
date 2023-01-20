package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import com.jihuanshe.model.User;
import e.l.q.b.f.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ContactDialog$onContact$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ContactDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactDialog$onContact$1(Context context, ContactDialog contactDialog) {
        super(1);
        this.$context = context;
        this.this$0 = contactDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Context context = this.$context;
        User value = this.this$0.getViewModel().X0().getValue();
        String valueOf = String.valueOf(value == null ? null : Integer.valueOf(value.getId()));
        User value2 = this.this$0.getViewModel().X0().getValue();
        g.a(context, valueOf, value2 != null ? value2.getName() : null);
    }
}
