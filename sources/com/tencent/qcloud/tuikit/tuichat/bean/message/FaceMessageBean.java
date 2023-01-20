package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMFaceElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: classes3.dex */
public class FaceMessageBean extends TUIMessageBean {
    private V2TIMFaceElem faceElem;

    public byte[] getData() {
        V2TIMFaceElem v2TIMFaceElem = this.faceElem;
        return v2TIMFaceElem != null ? v2TIMFaceElem.getData() : new byte[0];
    }

    public int getIndex() {
        V2TIMFaceElem v2TIMFaceElem = this.faceElem;
        if (v2TIMFaceElem != null) {
            return v2TIMFaceElem.getIndex();
        }
        return 0;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return FaceReplyQuoteBean.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return getExtra();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        V2TIMFaceElem faceElem = v2TIMMessage.getFaceElem();
        this.faceElem = faceElem;
        if (faceElem.getIndex() >= 1 && this.faceElem.getData() != null) {
            setExtra(new String(this.faceElem.getData()));
        } else {
            TUIChatLog.e("FaceMessageBean", "faceElem data is null or index<1");
        }
    }
}
