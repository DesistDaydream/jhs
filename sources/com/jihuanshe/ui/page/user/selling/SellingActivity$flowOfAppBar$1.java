package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.ui.widget.GameBarView;
import com.vector.design.ui.nav.ViewAttrs;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingActivity$flowOfAppBar$1 extends Lambda implements l<ViewAttrs, t1> {
    public final /* synthetic */ SellingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingActivity$flowOfAppBar$1(SellingActivity sellingActivity) {
        super(1);
        this.this$0 = sellingActivity;
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
