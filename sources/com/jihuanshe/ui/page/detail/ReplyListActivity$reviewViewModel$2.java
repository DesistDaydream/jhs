package com.jihuanshe.ui.page.detail;

import androidx.lifecycle.ViewModelProvider;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$reviewViewModel$2 extends Lambda implements a<ReviewListViewModel> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$reviewViewModel$2(ReplyListActivity replyListActivity) {
        super(0);
        this.this$0 = replyListActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final ReviewListViewModel invoke() {
        return (ReviewListViewModel) new ViewModelProvider(this.this$0).get(ReviewListViewModel.class);
    }
}
