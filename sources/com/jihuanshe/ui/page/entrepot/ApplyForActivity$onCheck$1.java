package com.jihuanshe.ui.page.entrepot;

import android.widget.CompoundButton;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForActivity$onCheck$1 extends Lambda implements p<CompoundButton, Boolean, t1> {
    public final /* synthetic */ ApplyForActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForActivity$onCheck$1(ApplyForActivity applyForActivity) {
        super(2);
        this.this$0 = applyForActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(CompoundButton compoundButton, Boolean bool) {
        invoke(compoundButton, bool.booleanValue());
        return t1.a;
    }

    public final void invoke(@d CompoundButton compoundButton, boolean z) {
        this.this$0.b0().setValue(Boolean.valueOf(z));
    }
}
