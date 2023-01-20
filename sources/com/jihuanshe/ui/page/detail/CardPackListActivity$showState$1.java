package com.jihuanshe.ui.page.detail;

import android.widget.LinearLayout;
import com.jihuanshe.R;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackListActivity$showState$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ CardPackListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackListActivity$showState$1(CardPackListActivity cardPackListActivity) {
        super(1);
        this.this$0 = cardPackListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        LinearLayout f0;
        LinearLayout f02;
        if (z) {
            f02 = this.this$0.f0();
            f02.setBackgroundResource(R.drawable.bg_filter_bar_white);
            return;
        }
        f0 = this.this$0.f0();
        f0.setBackgroundResource(R.drawable.bg_return_top);
    }
}
