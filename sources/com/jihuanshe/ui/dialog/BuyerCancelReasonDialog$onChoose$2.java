package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BuyerCancelReasonDialog$onChoose$2 extends Lambda implements l<View, t1> {
    public final /* synthetic */ BuyerCancelReasonDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyerCancelReasonDialog$onChoose$2(BuyerCancelReasonDialog buyerCancelReasonDialog) {
        super(1);
        this.this$0 = buyerCancelReasonDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    /* renamed from: invoke */
    public final void invoke2(@d View view) {
        Integer value = this.this$0.getReasonStr().getValue();
        if (value == null) {
            return;
        }
        int intValue = value.intValue();
        this.this$0.h();
        this.this$0.getListener().invoke(CollectionsKt___CollectionsKt.J2(this.this$0.getReasonList(), intValue - 1));
    }
}
