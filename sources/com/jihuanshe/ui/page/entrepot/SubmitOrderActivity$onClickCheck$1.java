package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$onClickCheck$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SubmitOrderActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderActivity$onClickCheck$1(SubmitOrderActivity submitOrderActivity) {
        super(1);
        this.this$0 = submitOrderActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        UseDialog useDialog = new UseDialog(this.this$0);
        SubmitOrderActivity submitOrderActivity = this.this$0;
        useDialog.setContent(Res.w(Res.a, R.string.apply_for_check_only_place, null, 2, null));
        useDialog.setOnClickRightButton(new SubmitOrderActivity$onClickCheck$1$1$1(submitOrderActivity));
        useDialog.y();
    }
}
