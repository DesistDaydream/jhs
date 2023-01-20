package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReportDialog$onClickConfirm$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReportDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportDialog$onClickConfirm$1(ReportDialog reportDialog) {
        super(1);
        this.this$0 = reportDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@d View view) {
        int v = this.this$0.getAdapter().v();
        this.this$0.h();
        l<String, t1> listener = this.this$0.getListener();
        List<String> value = this.this$0.getReason().getValue();
        listener.invoke(value == null ? null : (String) CollectionsKt___CollectionsKt.J2(value, v));
    }
}
