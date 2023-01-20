package com.jihuanshe.ui.page.detail;

import com.jihuanshe.adapter.ReplyListAdapter;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$adapter$2 extends Lambda implements a<ReplyListAdapter> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$adapter$2(ReplyListActivity replyListActivity) {
        super(0);
        this.this$0 = replyListActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final ReplyListAdapter invoke() {
        ReplyListActivity replyListActivity = this.this$0;
        return new ReplyListAdapter(replyListActivity, (ReplyListViewModel) replyListActivity.L());
    }
}
