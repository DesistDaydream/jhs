package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.MergeReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView;

/* loaded from: classes3.dex */
public class MergeReplyQuoteBean extends TUIReplyQuoteBean {
    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public Class<? extends TUIReplyQuoteView> getReplyQuoteViewClass() {
        return MergeReplyQuoteView.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
    }
}
