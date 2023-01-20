package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.ui.dialog.TipDialog;
import e.g.e.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForActivity$onRetryClick$1 extends Lambda implements l<a, t1> {
    public final /* synthetic */ ApplyForActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForActivity$onRetryClick$1(ApplyForActivity applyForActivity) {
        super(1);
        this.this$0 = applyForActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        if (aVar.h() == null) {
            return;
        }
        TipDialog tipDialog = new TipDialog(this.this$0, aVar.h());
        tipDialog.v(new ApplyForActivity$onRetryClick$1$1$1(this.this$0));
        tipDialog.y();
    }
}
