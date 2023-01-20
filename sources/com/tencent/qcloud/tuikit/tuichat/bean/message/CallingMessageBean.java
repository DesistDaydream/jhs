package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;

/* loaded from: classes3.dex */
public class CallingMessageBean extends TextMessageBean {
    public static final int ACTION_ID_AUDIO_CALL = 1;
    public static final int ACTION_ID_VIDEO_CALL = 2;
    private int callType;
    private String text;

    public int getCallType() {
        return this.callType;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean, com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return TextReplyQuoteBean.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean
    public String getText() {
        return this.text;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean, com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return this.text;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean, com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage.getTextElem() != null) {
            this.text = v2TIMMessage.getTextElem().getText();
        }
        setExtra(this.text);
    }

    public void setCallType(int i2) {
        this.callType = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean
    public void setText(String str) {
        this.text = str;
    }
}
