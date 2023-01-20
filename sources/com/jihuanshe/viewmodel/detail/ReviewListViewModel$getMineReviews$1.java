package com.jihuanshe.viewmodel.detail;

import com.jihuanshe.model.ReviewMineInfo;
import com.jihuanshe.utils.StringUtil;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListViewModel$getMineReviews$1 extends Lambda implements l<ReviewMineInfo, t1> {
    public final /* synthetic */ ReviewListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListViewModel$getMineReviews$1(ReviewListViewModel reviewListViewModel) {
        super(1);
        this.this$0 = reviewListViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ReviewMineInfo reviewMineInfo) {
        invoke2(reviewMineInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e ReviewMineInfo reviewMineInfo) {
        this.this$0.L0().setValue(Boolean.TRUE);
        this.this$0.F0().setValue(reviewMineInfo);
        if (reviewMineInfo != null) {
            reviewMineInfo.setHandleContent(StringUtil.a.i(reviewMineInfo.getContent()));
        }
    }
}
