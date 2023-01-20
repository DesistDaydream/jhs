package com.jihuanshe.ui.page.detail;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$initObserver$4 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$initObserver$4(ReviewListActivity reviewListActivity) {
        super(1);
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        ConstraintLayout i0;
        if (z) {
            if (f0.g(((ReviewListViewModel) this.this$0.L()).L0().getValue(), Boolean.FALSE)) {
                i0 = this.this$0.i0();
                i0.setVisibility(8);
                return;
            }
            return;
        }
        ((ReviewListViewModel) this.this$0.L()).L0().n();
    }
}
