package com.jihuanshe.ui.page.main.shop;

import android.widget.ImageView;
import com.vector.design.ui.nav.ViewAttrs;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$flowOfAppBar$2 extends Lambda implements l<ViewAttrs, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$flowOfAppBar$2(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ViewAttrs viewAttrs) {
        invoke2(viewAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ViewAttrs viewAttrs) {
        ImageView imageView;
        imageView = this.this$0.R;
        viewAttrs.s(imageView);
        viewAttrs.o(17);
        d.a aVar = e.t.o.d.a;
        viewAttrs.p(d.a.c(aVar, null, 1, null).d(32));
        viewAttrs.t(d.a.c(aVar, null, 1, null).d(45));
        viewAttrs.r(d.a.c(aVar, null, 1, null).d(12));
    }
}
