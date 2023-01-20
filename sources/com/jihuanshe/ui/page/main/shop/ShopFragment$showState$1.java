package com.jihuanshe.ui.page.main.shop;

import android.widget.LinearLayout;
import com.jihuanshe.R;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$showState$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$showState$1(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        LinearLayout v0;
        LinearLayout v02;
        if (z) {
            v02 = this.this$0.v0();
            v02.setBackgroundResource(R.drawable.bg_filter_bar_white);
            return;
        }
        v0 = this.this$0.v0();
        v0.setBackgroundResource(R.drawable.bg_return_top);
    }
}
