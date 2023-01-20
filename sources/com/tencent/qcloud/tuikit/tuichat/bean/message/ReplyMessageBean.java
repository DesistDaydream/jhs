package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ReplyReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;

/* loaded from: classes3.dex */
public class ReplyMessageBean extends TUIMessageBean {
    private TUIMessageBean contentMessageBean;
    private TUIMessageBean originMessageBean;
    private final String originMsgAbstract;
    private final String originMsgId;
    private final String originMsgSender;
    private final int originMsgType;
    private TUIReplyQuoteBean replyQuoteBean;
    private final int version;

    public ReplyMessageBean(ReplyPreviewBean replyPreviewBean) {
        this.originMsgId = replyPreviewBean.getMessageID();
        this.originMsgAbstract = replyPreviewBean.getMessageAbstract();
        this.originMsgSender = replyPreviewBean.getMessageSender();
        this.originMsgType = replyPreviewBean.getMessageType();
        this.version = replyPreviewBean.getVersion();
        this.originMessageBean = replyPreviewBean.getOriginalMessageBean();
    }

    private void generateDefaultReplyQuoteBean() {
        TextReplyQuoteBean textReplyQuoteBean = new TextReplyQuoteBean();
        this.replyQuoteBean = textReplyQuoteBean;
        textReplyQuoteBean.setDefaultAbstract(this.originMsgAbstract);
        this.replyQuoteBean.setMessageType(this.originMsgType);
    }

    private void generateReplyQuoteBean() {
        generateDefaultReplyQuoteBean();
        TUIMessageBean tUIMessageBean = this.originMessageBean;
        if (tUIMessageBean == null) {
            return;
        }
        Class<? extends TUIReplyQuoteBean> replyQuoteBeanClass = tUIMessageBean.getReplyQuoteBeanClass();
        if (replyQuoteBeanClass != null) {
            try {
                this.replyQuoteBean = replyQuoteBeanClass.newInstance();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            }
        }
        TUIReplyQuoteBean tUIReplyQuoteBean = this.replyQuoteBean;
        if (tUIReplyQuoteBean != null) {
            tUIReplyQuoteBean.onProcessReplyQuoteBean(this.originMessageBean);
            this.replyQuoteBean.setMessageBean(this.originMessageBean);
            this.replyQuoteBean.setMessageType(this.originMsgType);
            this.replyQuoteBean.setDefaultAbstract(this.originMsgAbstract);
        }
    }

    public TUIMessageBean getContentMessageBean() {
        return this.contentMessageBean;
    }

    public TUIMessageBean getOriginMessageBean() {
        return this.originMessageBean;
    }

    public String getOriginMsgAbstract() {
        return this.originMsgAbstract;
    }

    public String getOriginMsgId() {
        return this.originMsgId;
    }

    public String getOriginMsgSender() {
        return this.originMsgSender;
    }

    public int getOriginMsgType() {
        return this.originMsgType;
    }

    public TUIReplyQuoteBean getReplyQuoteBean() {
        return this.replyQuoteBean;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return ReplyReplyQuoteBean.class;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        TUIMessageBean tUIMessageBean = this.contentMessageBean;
        return tUIMessageBean != null ? tUIMessageBean.onGetDisplayString() : "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        this.contentMessageBean = ChatMessageParser.parseMessage(v2TIMMessage, true);
        generateReplyQuoteBean();
        setExtra(this.contentMessageBean.getExtra());
    }

    public void setOriginMessageBean(TUIMessageBean tUIMessageBean) {
        this.originMessageBean = tUIMessageBean;
        generateReplyQuoteBean();
    }

    public void setReplyQuoteBean(TUIReplyQuoteBean tUIReplyQuoteBean) {
        this.replyQuoteBean = tUIReplyQuoteBean;
    }
}
