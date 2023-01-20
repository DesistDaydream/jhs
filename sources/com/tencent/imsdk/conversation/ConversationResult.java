package com.tencent.imsdk.conversation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ConversationResult implements Serializable {
    private List<Conversation> conversationList = new ArrayList();
    private boolean isFinish;
    private long nextSeq;

    public void addConversation(Conversation conversation) {
        this.conversationList.add(conversation);
    }

    public List<Conversation> getConversationList() {
        return this.conversationList;
    }

    public long getNextSeq() {
        return this.nextSeq;
    }

    public boolean isFinish() {
        return this.isFinish;
    }
}
