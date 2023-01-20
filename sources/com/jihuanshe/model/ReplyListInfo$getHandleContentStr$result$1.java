package com.jihuanshe.model;

import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListInfo$getHandleContentStr$result$1 extends Lambda implements a<t1> {
    public final /* synthetic */ ReplyListInfo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListInfo$getHandleContentStr$result$1(ReplyListInfo replyListInfo) {
        super(0);
        this.this$0 = replyListInfo;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SellerDetailActivityCreator.create(this.this$0.getReplyUserID(), null).start(e.t.a.b());
    }
}
