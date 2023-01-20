package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.FaceReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView;

/* loaded from: classes3.dex */
public class FaceReplyQuoteBean extends TUIReplyQuoteBean {
    private byte[] data;
    private int index;

    public byte[] getData() {
        byte[] bArr = this.data;
        return bArr != null ? bArr : new byte[0];
    }

    public int getIndex() {
        return this.index;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public Class<? extends TUIReplyQuoteView> getReplyQuoteViewClass() {
        return FaceReplyQuoteView.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof FaceMessageBean) {
            FaceMessageBean faceMessageBean = (FaceMessageBean) tUIMessageBean;
            this.data = faceMessageBean.getData();
            this.index = faceMessageBean.getIndex();
        }
    }
}
