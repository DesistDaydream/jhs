package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import e.l.k.yf;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$header$2 extends Lambda implements a<View> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$header$2(ReplyListActivity replyListActivity) {
        super(0);
        this.this$0 = replyListActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final View invoke() {
        yf e2 = yf.e(this.this$0.getLayoutInflater());
        e2.i(this.this$0);
        e2.j((ReplyListViewModel) this.this$0.L());
        e2.setLifecycleOwner(this.this$0);
        return e2.getRoot();
    }
}
