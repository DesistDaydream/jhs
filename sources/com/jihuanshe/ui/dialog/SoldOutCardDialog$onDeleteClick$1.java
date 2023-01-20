package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SoldOutCardDialog$onDeleteClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ a<t1> $delete;
    public final /* synthetic */ SoldOutCardDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoldOutCardDialog$onDeleteClick$1(Context context, SoldOutCardDialog soldOutCardDialog, a<t1> aVar) {
        super(1);
        this.$context = context;
        this.this$0 = soldOutCardDialog;
        this.$delete = aVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        UseDialog useDialog = new UseDialog(this.$context);
        SoldOutCardDialog soldOutCardDialog = this.this$0;
        a<t1> aVar = this.$delete;
        useDialog.setContent(Res.w(Res.a, R.string.sell_tip_title, null, 2, null));
        useDialog.setOnClickRightButton(new SoldOutCardDialog$onDeleteClick$1$1$1(soldOutCardDialog, aVar));
        useDialog.y();
    }
}
