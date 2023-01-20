package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.tuichat.bean.C2CMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.util.List;

/* loaded from: classes3.dex */
public interface C2CChatEventListener {
    void exitC2CChat(String str);

    void handleRevoke(String str);

    void onFriendNameChanged(String str, String str2);

    void onReadReport(List<C2CMessageReceiptInfo> list);

    void onRecvNewMessage(TUIMessageBean tUIMessageBean);
}
