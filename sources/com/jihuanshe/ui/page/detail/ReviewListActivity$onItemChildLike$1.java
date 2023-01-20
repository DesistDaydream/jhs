package com.jihuanshe.ui.page.detail;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.util.Res;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onItemChildLike$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListInfo $info;
    public final /* synthetic */ ImageView $iv;
    public final /* synthetic */ TextView $tv;
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onItemChildLike$1(ImageView imageView, ReviewListActivity reviewListActivity, ReviewListInfo reviewListInfo, TextView textView) {
        super(1);
        this.$iv = imageView;
        this.this$0 = reviewListActivity;
        this.$info = reviewListInfo;
        this.$tv = textView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        boolean z = false;
        if (f0.g(this.$iv.getImageTintList(), ColorStateList.valueOf(Res.k(R.color.black_b5b5b7)))) {
            ReviewListViewModel reviewListViewModel = (ReviewListViewModel) this.this$0.L();
            Integer reviewID = this.$info.getReviewID();
            int intValue = reviewID == null ? 0 : reviewID.intValue();
            Integer userID = this.$info.getUserID();
            int v = UserKV.f3913c.v();
            if (userID != null && userID.intValue() == v) {
                z = true;
            }
            reviewListViewModel.M0(intValue, z);
            ReviewListInfo reviewListInfo = this.$info;
            Integer likeCount = reviewListInfo.getLikeCount();
            reviewListInfo.setLikeCount(likeCount == null ? null : Integer.valueOf(likeCount.intValue() + 1));
            this.$tv.setText(this.$info.getLikeCountStr());
            this.$iv.setImageTintList(ColorStateList.valueOf(Res.k(R.color.common_color)));
            this.$iv.setImageDrawable(Res.q(Res.a, R.drawable.svg_like, null, 2, null));
            return;
        }
        ReviewListViewModel reviewListViewModel2 = (ReviewListViewModel) this.this$0.L();
        Integer reviewID2 = this.$info.getReviewID();
        int intValue2 = reviewID2 == null ? 0 : reviewID2.intValue();
        Integer userID2 = this.$info.getUserID();
        int v2 = UserKV.f3913c.v();
        if (userID2 != null && userID2.intValue() == v2) {
            z = true;
        }
        reviewListViewModel2.N0(intValue2, z);
        ReviewListInfo reviewListInfo2 = this.$info;
        Integer likeCount2 = reviewListInfo2.getLikeCount();
        reviewListInfo2.setLikeCount(likeCount2 == null ? null : Integer.valueOf(likeCount2.intValue() - 1));
        this.$tv.setText(this.$info.getLikeCountStr());
        this.$iv.setImageTintList(ColorStateList.valueOf(Res.k(R.color.black_b5b5b7)));
        this.$iv.setImageDrawable(Res.q(Res.a, R.drawable.svg_like_hollow, null, 2, null));
    }
}
