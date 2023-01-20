package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.ReviewMineInfo;
import com.jihuanshe.ui.widget.ReviewPopupWindow;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import e.g.d.a;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onClickMore$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$onClickMore$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ ReviewListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReviewListActivity reviewListActivity) {
            super(1);
            this.this$0 = reviewListActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            ReviewMineInfo value = ((ReviewListViewModel) this.this$0.L()).F0().getValue();
            if (value == null) {
                return;
            }
            int reviewId = value.getReviewId();
            ReviewListActivity reviewListActivity = this.this$0;
            a.j(((ReviewListViewModel) reviewListActivity.L()).z0(reviewId), null, new ReviewListActivity$onClickMore$1$1$1$1(reviewListActivity), 1, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onClickMore$1(ReviewListActivity reviewListActivity) {
        super(1);
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ReviewListActivity reviewListActivity = this.this$0;
        new ReviewPopupWindow(reviewListActivity, "删除", e.t.j.h.d.a.a(new AnonymousClass1(reviewListActivity))).showAsDropDown(view, -d.a.c(e.t.o.d.a, null, 1, null).d(55), 0);
    }
}
