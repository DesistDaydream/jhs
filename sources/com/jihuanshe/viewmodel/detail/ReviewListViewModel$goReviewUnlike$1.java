package com.jihuanshe.viewmodel.detail;

import com.jihuanshe.model.ReviewMineInfo;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListViewModel$goReviewUnlike$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ boolean $isMine;
    public final /* synthetic */ ReviewListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListViewModel$goReviewUnlike$1(boolean z, ReviewListViewModel reviewListViewModel) {
        super(1);
        this.$isMine = z;
        this.this$0 = reviewListViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        Integer likeCount;
        if (this.$isMine) {
            ReviewMineInfo value = this.this$0.F0().getValue();
            if (value != null) {
                value.setLike(Boolean.FALSE);
            }
            ReviewMineInfo value2 = this.this$0.F0().getValue();
            if (value2 != null) {
                ReviewMineInfo value3 = this.this$0.F0().getValue();
                Integer num = null;
                if (value3 != null && (likeCount = value3.getLikeCount()) != null) {
                    num = Integer.valueOf(likeCount.intValue() - 1);
                }
                value2.setLikeCount(num);
            }
            this.this$0.F0().n();
        }
    }
}
