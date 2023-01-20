package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.ImageReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView;

/* loaded from: classes3.dex */
public class ImageReplyQuoteBean extends TUIReplyQuoteBean {
    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public Class<? extends TUIReplyQuoteView> getReplyQuoteViewClass() {
        return ImageReplyQuoteView.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
    }
}
