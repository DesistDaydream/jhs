package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.model.ReviewMineInfo;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onClickLikeMine$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onClickLikeMine$1(ReviewListActivity reviewListActivity) {
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
        Boolean bool = Boolean.FALSE;
        ReviewMineInfo value = ((ReviewListViewModel) this.this$0.L()).F0().getValue();
        if (value == null ? false : f0.g(value.isLike(), bool)) {
            ReviewListViewModel reviewListViewModel = (ReviewListViewModel) this.this$0.L();
            ReviewMineInfo value2 = ((ReviewListViewModel) this.this$0.L()).F0().getValue();
            reviewListViewModel.M0(value2 != null ? value2.getReviewId() : 0, true);
            List<ReviewListInfo> value3 = ((ReviewListViewModel) this.this$0.L()).E0().getValue();
            if (value3 != null) {
                ReviewListActivity reviewListActivity = this.this$0;
                for (ReviewListInfo reviewListInfo : value3) {
                    Integer reviewID = reviewListInfo.getReviewID();
                    ReviewMineInfo value4 = ((ReviewListViewModel) reviewListActivity.L()).F0().getValue();
                    if (f0.g(reviewID, value4 == null ? null : Integer.valueOf(value4.getReviewId()))) {
                        reviewListInfo.setLike(Boolean.TRUE);
                        Integer likeCount = reviewListInfo.getLikeCount();
                        reviewListInfo.setLikeCount(likeCount == null ? null : Integer.valueOf(likeCount.intValue() + 1));
                    }
                }
            }
        } else {
            ReviewListViewModel reviewListViewModel2 = (ReviewListViewModel) this.this$0.L();
            ReviewMineInfo value5 = ((ReviewListViewModel) this.this$0.L()).F0().getValue();
            reviewListViewModel2.N0(value5 != null ? value5.getReviewId() : 0, true);
            List<ReviewListInfo> value6 = ((ReviewListViewModel) this.this$0.L()).E0().getValue();
            if (value6 != null) {
                ReviewListActivity reviewListActivity2 = this.this$0;
                for (ReviewListInfo reviewListInfo2 : value6) {
                    Integer reviewID2 = reviewListInfo2.getReviewID();
                    ReviewMineInfo value7 = ((ReviewListViewModel) reviewListActivity2.L()).F0().getValue();
                    if (f0.g(reviewID2, value7 == null ? null : Integer.valueOf(value7.getReviewId()))) {
                        reviewListInfo2.setLike(bool);
                        Integer likeCount2 = reviewListInfo2.getLikeCount();
                        reviewListInfo2.setLikeCount(likeCount2 == null ? null : Integer.valueOf(likeCount2.intValue() - 1));
                    }
                }
            }
        }
        ((ReviewListViewModel) this.this$0.L()).E0().n();
    }
}
