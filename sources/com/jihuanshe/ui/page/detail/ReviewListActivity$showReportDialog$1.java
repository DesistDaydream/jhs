package com.jihuanshe.ui.page.detail;

import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ImageErrorInfo;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$showReportDialog$1 extends Lambda implements l<ImageErrorInfo, t1> {
    public final /* synthetic */ ReviewListInfo $info;
    public final /* synthetic */ ReviewListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$showReportDialog$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ ReviewListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReviewListActivity reviewListActivity) {
            super(1);
            this.this$0 = reviewListActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            e.l.h.j.b.e.b(this.this$0, R.string.report_success, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$showReportDialog$1(ReviewListActivity reviewListActivity, ReviewListInfo reviewListInfo) {
        super(1);
        this.this$0 = reviewListActivity;
        this.$info = reviewListInfo;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ImageErrorInfo imageErrorInfo) {
        invoke2(imageErrorInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ImageErrorInfo imageErrorInfo) {
        ReviewListViewModel reviewListViewModel = (ReviewListViewModel) this.this$0.L();
        Integer reviewID = this.$info.getReviewID();
        BinderKt.k(BinderKt.p(a.j(reviewListViewModel.Q0(reviewID == null ? 0 : reviewID.intValue(), imageErrorInfo.getReason(), imageErrorInfo.getContent(), imageErrorInfo.getImages()), null, new AnonymousClass1(this.this$0), 1, null)), this.this$0, false, 2, null);
    }
}
