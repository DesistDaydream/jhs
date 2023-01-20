package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onItemChildAllReply$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListInfo $info;
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onItemChildAllReply$1(ReviewListInfo reviewListInfo, ReviewListActivity reviewListActivity) {
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
        ReplyListActivityCreator create = ReplyListActivityCreator.create(this.$info.getReviewID());
        Pair<String, String> value = ((ReviewListViewModel) this.this$0.L()).B0().getValue();
        create.sortIndex(Integer.valueOf(f0.g(value == null ? null : value.getSecond(), Constants.Companion.getSORT_TYPE_REVIEW().get(1).getSecond()) ? 1 : 0)).start(this.this$0);
    }
}
