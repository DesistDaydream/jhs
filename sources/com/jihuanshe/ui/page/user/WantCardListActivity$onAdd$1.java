package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.page.shop.AddCardActivityCreator;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantCardListActivity$onAdd$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ WantCardListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantCardListActivity$onAdd$1(WantCardListActivity wantCardListActivity) {
        super(1);
        this.this$0 = wantCardListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        WantBuyList f0 = this.this$0.f0();
        AddCardActivityCreator.create(1, f0 == null ? null : Integer.valueOf(f0.getId())).start(this.this$0);
    }
}
