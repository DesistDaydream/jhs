package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.tuichat.bean.GroupMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.util.List;

/* loaded from: classes3.dex */
public interface GroupChatEventListener {
    void clearGroupMessage(String str);

    void exitGroupChat(String str);

    void handleRevoke(String str);

    void onApplied(int i2);

    void onGroupForceExit(String str);

    void onGroupNameChanged(String str, String str2);

    void onReadReport(List<GroupMessageReceiptInfo> list);

    void onRecvNewMessage(TUIMessageBean tUIMessageBean);
}
