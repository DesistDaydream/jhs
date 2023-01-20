package com.jihuanshe.ui.page.detail;

import android.widget.LinearLayout;
import com.jihuanshe.R;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$showState$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$showState$1(ReplyListActivity replyListActivity) {
        super(1);
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        LinearLayout p0;
        LinearLayout p02;
        if (z) {
            p02 = this.this$0.p0();
            p02.setBackgroundResource(R.drawable.bg_filter_bar_white);
            return;
        }
        p0 = this.this$0.p0();
        p0.setBackgroundResource(R.drawable.bg_return_top);
    }
}
