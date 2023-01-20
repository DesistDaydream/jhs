package com.tencent.imsdk.conversation;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class ConversationListener {
    public void onConversationChanged(List<Conversation> list) {
    }

    public void onNewConversation(List<Conversation> list) {
    }

    public void onSyncServerFailed() {
    }

    public void onSyncServerFinish() {
    }

    public void onSyncServerStart() {
    }

    public void onTotalUnreadMessageCountChanged(long j2) {
    }
}
