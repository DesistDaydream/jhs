package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.model.stat.STATConstant;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$onCLickGoCardDetail$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReplyDetailInfo $info;
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$onCLickGoCardDetail$1(ReplyDetailInfo replyDetailInfo, ReplyListActivity replyListActivity) {
        super(1);
        this.$info = replyDetailInfo;
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ReplyDetailInfo replyDetailInfo = this.$info;
        if (replyDetailInfo == null) {
            return;
        }
        CardDetailActivityCreator.create(replyDetailInfo.getCvId(), this.$info.getGameKey(), this.$info.getGameSubKey()).from(STATConstant.PAGE.REPLY_DETAIL).start(this.this$0);
    }
}
