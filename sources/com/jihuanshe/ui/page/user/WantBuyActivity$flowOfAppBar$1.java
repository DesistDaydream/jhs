package com.jihuanshe.ui.page.user;

import com.jihuanshe.ui.widget.GameBarView;
import com.vector.design.ui.nav.ViewAttrs;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$flowOfAppBar$1 extends Lambda implements l<ViewAttrs, t1> {
    public final /* synthetic */ WantBuyActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$flowOfAppBar$1(WantBuyActivity wantBuyActivity) {
        super(1);
        this.this$0 = wantBuyActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ViewAttrs viewAttrs) {
        invoke2(viewAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ViewAttrs viewAttrs) {
        viewAttrs.s(new GameBarView(this.this$0, null, null, null, 14, null));
    }
}
