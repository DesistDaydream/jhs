package com.jihuanshe.ui.page.shop;

import android.content.Intent;
import android.view.View;
import com.jihuanshe.model.BankDetail;
import e.l.s.n.b;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchBankActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SearchBankActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBankActivity$onItemClick$1(SearchBankActivity searchBankActivity) {
        super(2);
        this.this$0 = searchBankActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<BankDetail> value = ((b) this.this$0.L()).p0().getValue();
        this.this$0.setResult(-1, new Intent().putExtra("bank", value == null ? null : value.get(i2)));
        this.this$0.finish();
    }
}
