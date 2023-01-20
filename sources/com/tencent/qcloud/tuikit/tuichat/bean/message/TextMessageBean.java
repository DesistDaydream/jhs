package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;

/* loaded from: classes3.dex */
public class TextMessageBean extends TUIMessageBean {
    private String selectText;
    private String text;

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return TextReplyQuoteBean.class;
    }

    public String getSelectText() {
        return this.selectText;
    }

    public String getText() {
        return this.text;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return this.text;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage.getTextElem() != null) {
            this.text = v2TIMMessage.getTextElem().getText();
        }
        setExtra(this.text);
    }

    public void setSelectText(String str) {
        this.selectText = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
