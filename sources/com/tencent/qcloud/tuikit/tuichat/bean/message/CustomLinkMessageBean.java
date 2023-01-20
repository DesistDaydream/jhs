package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomLinkReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class CustomLinkMessageBean extends TUIMessageBean {
    private String link;
    private String text;

    public String getLink() {
        return this.link;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return CustomLinkReplyQuoteBean.class;
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
        this.text = TUIChatService.getAppContext().getString(R.string.no_support_msg);
        this.link = "";
        try {
            HashMap hashMap = (HashMap) new Gson().n(new String(v2TIMMessage.getCustomElem().getData()), HashMap.class);
            if (hashMap != null) {
                this.text = (String) hashMap.get("text");
                this.link = (String) hashMap.get("link");
            }
        } catch (JsonSyntaxException unused) {
        }
        setExtra(this.text);
    }
}
