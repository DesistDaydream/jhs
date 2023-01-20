package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.ReviewMineInfo;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onClickHeader$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onClickHeader$1(ReviewListActivity reviewListActivity) {
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
        SellerDetailActivityCreator.create(value == null ? null : Integer.valueOf(value.getUserID()), null).start(this.this$0);
    }
}
