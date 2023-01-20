package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import e.l.s.n.b;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchBankActivity$onClickSearch$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SearchBankActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBankActivity$onClickSearch$1(SearchBankActivity searchBankActivity) {
        super(1);
        this.this$0 = searchBankActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        BinderKt.p(BinderKt.k(((b) this.this$0.L()).q0(this.this$0.Y().getText().toString(), this.this$0.Z().getText().toString()), this.this$0, false, 2, null));
    }
}
