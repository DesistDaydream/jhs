package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$onClickHeader$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$onClickHeader$1(ReplyListActivity replyListActivity) {
        super(1);
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ReplyDetailInfo value = ((ReplyListViewModel) this.this$0.L()).E0().getValue();
        if (value == null) {
            return;
        }
        int userID = value.getUserID();
        SellerDetailActivityCreator.create(Integer.valueOf(userID), null).start(this.this$0);
    }
}
