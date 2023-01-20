package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import e.l.k.ag;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$header$2 extends Lambda implements a<View> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$header$2(ReviewListActivity reviewListActivity) {
        super(0);
        this.this$0 = reviewListActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final View invoke() {
        ag e2 = ag.e(this.this$0.getLayoutInflater());
        e2.setLifecycleOwner(this.this$0);
        e2.i(this.this$0);
        e2.j((ReviewListViewModel) this.this$0.L());
        return e2.getRoot();
    }
}
