package com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces;

import com.tencent.qcloud.tuicore.component.interfaces.ILayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout;

/* loaded from: classes3.dex */
public interface IConversationLayout extends ILayout {
    void clearConversationMessage(ConversationInfo conversationInfo);

    void deleteConversation(ConversationInfo conversationInfo);

    ConversationListLayout getConversationList();

    void setConversationTop(ConversationInfo conversationInfo, IUIKitCallback iUIKitCallback);
}
