package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.model.ReviewMineInfo;
import com.jihuanshe.ui.widget.ReviewPopupWindow;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.util.Res;
import e.g.d.a;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onItemChildMore$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListInfo $info;
    public final /* synthetic */ ReviewListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$onItemChildMore$1$1  reason: invalid class name */
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
            a.j(((ReviewListViewModel) reviewListActivity.L()).z0(reviewId), null, new ReviewListActivity$onItemChildMore$1$1$1$1(reviewListActivity), 1, null);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$onItemChildMore$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<View, t1> {
        public final /* synthetic */ ReviewListInfo $info;
        public final /* synthetic */ ReviewListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ReviewListActivity reviewListActivity, ReviewListInfo reviewListInfo) {
            super(1);
            this.this$0 = reviewListActivity;
            this.$info = reviewListInfo;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            this.this$0.j1(this.$info);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onItemChildMore$1(ReviewListInfo reviewListInfo, ReviewListActivity reviewListActivity) {
        super(1);
        this.$info = reviewListInfo;
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer userID = this.$info.getUserID();
        int v = UserKV.f3913c.v();
        if (userID != null && userID.intValue() == v) {
            new ReviewPopupWindow(this.this$0, Res.w(Res.a, R.string.common_delete, null, 2, null), e.t.j.h.d.a.a(new AnonymousClass1(this.this$0))).showAsDropDown(view, -d.a.c(e.t.o.d.a, null, 1, null).d(55), 0);
        } else {
            new ReviewPopupWindow(this.this$0, Res.w(Res.a, R.string.common_report, null, 2, null), e.t.j.h.d.a.a(new AnonymousClass2(this.this$0, this.$info))).showAsDropDown(view, -d.a.c(e.t.o.d.a, null, 1, null).d(55), 0);
        }
    }
}
