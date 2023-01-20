package com.jihuanshe.ui.page.user;

import com.jihuanshe.model.WantBuyList;
import com.vector.design.ui.nav.TextAttrs;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantCardListActivity$flowOfAppBar$1 extends Lambda implements l<TextAttrs, t1> {
    public final /* synthetic */ WantCardListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantCardListActivity$flowOfAppBar$1(WantCardListActivity wantCardListActivity) {
        super(1);
        this.this$0 = wantCardListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(TextAttrs textAttrs) {
        invoke2(textAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d TextAttrs textAttrs) {
        WantBuyList f0 = this.this$0.f0();
        textAttrs.J(f0 == null ? null : f0.getName());
    }
}
