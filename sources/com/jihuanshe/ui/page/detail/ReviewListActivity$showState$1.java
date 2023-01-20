package com.jihuanshe.ui.page.detail;

import android.widget.LinearLayout;
import com.jihuanshe.R;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$showState$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$showState$1(ReviewListActivity reviewListActivity) {
        super(1);
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        LinearLayout r0;
        LinearLayout r02;
        if (z) {
            r02 = this.this$0.r0();
            r02.setBackgroundResource(R.drawable.bg_filter_bar_white);
            return;
        }
        r0 = this.this$0.r0();
        r0.setBackgroundResource(R.drawable.bg_return_top);
    }
}
