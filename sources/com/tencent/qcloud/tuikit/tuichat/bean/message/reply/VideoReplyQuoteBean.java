package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.VideoReplyQuoteView;

/* loaded from: classes3.dex */
public class VideoReplyQuoteBean extends TUIReplyQuoteBean {
    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public Class<? extends TUIReplyQuoteView> getReplyQuoteViewClass() {
        return VideoReplyQuoteView.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
    }
}
