package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.utils.StringUtil;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ExpressDetailsDialog$onClickCopy$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ExpressDetailsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressDetailsDialog$onClickCopy$1(ExpressDetailsDialog expressDetailsDialog) {
        super(1);
        this.this$0 = expressDetailsDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        StringUtil stringUtil = StringUtil.a;
        String expressNumber = this.this$0.getInfo().getExpressNumber();
        if (expressNumber == null) {
            expressNumber = "";
        }
        stringUtil.a(expressNumber);
    }
}
