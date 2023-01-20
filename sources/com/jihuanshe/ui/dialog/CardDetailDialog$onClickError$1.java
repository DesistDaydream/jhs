package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.model.Constants;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailDialog$onClickError$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailDialog$onClickError$1(CardDetailDialog cardDetailDialog) {
        super(1);
        this.this$0 = cardDetailDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        List<String> list;
        this.this$0.B = Constants.Companion.getERROR_CORRECTION();
        l<List<String>, t1> errorCorrect = this.this$0.getErrorCorrect();
        list = this.this$0.B;
        errorCorrect.invoke(list);
        this.this$0.h();
    }
}
