package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.OrderReturnDetail;
import com.jihuanshe.utils.StringUtil;
import com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConOrderDetailsActivity$onClickCopy$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ConOrderDetailsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConOrderDetailsActivity$onClickCopy$1(ConOrderDetailsActivity conOrderDetailsActivity) {
        super(1);
        this.this$0 = conOrderDetailsActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (((ConOrderDetailsViewModel) this.this$0.L()).r0().getValue() != null) {
            StringUtil stringUtil = StringUtil.a;
            CardConsignmentInfo value = ((ConOrderDetailsViewModel) this.this$0.L()).r0().getValue();
            stringUtil.a(String.valueOf(value == null ? null : value.getExpressNumber()));
        }
        if (((ConOrderDetailsViewModel) this.this$0.L()).t0().getValue() != null) {
            StringUtil stringUtil2 = StringUtil.a;
            OrderReturnDetail value2 = ((ConOrderDetailsViewModel) this.this$0.L()).t0().getValue();
            stringUtil2.a(String.valueOf(value2 != null ? value2.getExpressNumber() : null));
        }
    }
}
