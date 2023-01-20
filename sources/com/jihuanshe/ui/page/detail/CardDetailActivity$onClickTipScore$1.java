package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickTipScore$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ int $type;
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickTipScore$1(CardDetailActivity cardDetailActivity, int i2) {
        super(1);
        this.this$0 = cardDetailActivity;
        this.$type = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        String w;
        UseDialog useDialog = new UseDialog(this.this$0);
        if (this.$type == 0) {
            w = Res.w(Res.a, R.string.tips_no_avg_score, null, 2, null);
        } else {
            w = Res.w(Res.a, R.string.tips_no_avg_price, null, 2, null);
        }
        useDialog.setContent(w);
        useDialog.C();
        useDialog.setRightButtonText(Res.w(Res.a, R.string.sure, null, 2, null));
        useDialog.y();
    }
}
