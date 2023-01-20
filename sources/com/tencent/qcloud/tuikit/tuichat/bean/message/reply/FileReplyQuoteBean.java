package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.FileReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView;

/* loaded from: classes3.dex */
public class FileReplyQuoteBean extends TUIReplyQuoteBean {
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public Class<? extends TUIReplyQuoteView> getReplyQuoteViewClass() {
        return FileReplyQuoteView.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof FileMessageBean) {
            this.fileName = ((FileMessageBean) tUIMessageBean).getFileName();
        }
    }
}
