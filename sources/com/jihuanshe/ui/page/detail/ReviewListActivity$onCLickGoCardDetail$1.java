package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.model.stat.STATConstant;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onCLickGoCardDetail$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListInfo $info;
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onCLickGoCardDetail$1(ReviewListInfo reviewListInfo, ReviewListActivity reviewListActivity) {
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
        CardDetailActivityCreator.create(this.$info.getCvId(), this.this$0.m0(), this.this$0.n0()).from(STATConstant.PAGE.REVIEW_LIST).start(this.this$0);
    }
}
