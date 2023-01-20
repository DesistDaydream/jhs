package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class TUIReplyQuoteBean implements Serializable {
    public String defaultAbstract;
    private TUIMessageBean messageBean;
    public int messageType;

    public String getDefaultAbstract() {
        return this.defaultAbstract;
    }

    public TUIMessageBean getMessageBean() {
        return this.messageBean;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public Class<? extends TUIReplyQuoteView> getReplyQuoteViewClass() {
        return null;
    }

    public abstract void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean);

    public void setDefaultAbstract(String str) {
        this.defaultAbstract = str;
    }

    public void setMessageBean(TUIMessageBean tUIMessageBean) {
        this.messageBean = tUIMessageBean;
    }

    public void setMessageType(int i2) {
        this.messageType = i2;
    }
}
