package com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces;

import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface IConversationProvider {
    boolean addConversations(List<ConversationInfo> list);

    void attachAdapter(IConversationListAdapter iConversationListAdapter);

    boolean deleteConversations(List<ConversationInfo> list);

    List<ConversationInfo> getDataSource();

    boolean updateConversations(List<ConversationInfo> list);
}
