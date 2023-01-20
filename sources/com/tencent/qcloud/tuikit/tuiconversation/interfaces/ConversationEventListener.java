package com.tencent.qcloud.tuikit.tuiconversation.interfaces;

import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface ConversationEventListener {
    void clearConversationMessage(String str, boolean z);

    void deleteConversation(String str);

    void deleteConversation(String str, boolean z);

    long getUnreadTotal();

    boolean isTopConversation(String str);

    void onConversationChanged(List<ConversationInfo> list);

    void onFriendRemarkChanged(String str, String str2);

    void onLoginSuccess();

    void onNewConversation(List<ConversationInfo> list);

    void setConversationTop(String str, boolean z, IUIKitCallback<Void> iUIKitCallback);

    void updateTotalUnreadMessageCount(long j2);
}
