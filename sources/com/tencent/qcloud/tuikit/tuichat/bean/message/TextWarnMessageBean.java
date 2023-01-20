package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.imsdk.v2.V2TIMMessage;

/* loaded from: classes3.dex */
public class TextWarnMessageBean extends TUIMessageBean {
    private String title;

    public String getTitle() {
        return this.title;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return "[安全提醒]";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage.getCustomElem() != null) {
            try {
                TextWarnMessageBean textWarnMessageBean = (TextWarnMessageBean) new Gson().n(new String(v2TIMMessage.getCustomElem().getData()), TextWarnMessageBean.class);
                if (textWarnMessageBean != null) {
                    this.title = textWarnMessageBean.getTitle();
                }
            } catch (JsonSyntaxException unused) {
            }
            setExtra(this.title);
        }
    }
}
