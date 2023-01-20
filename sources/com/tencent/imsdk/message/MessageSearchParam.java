package com.tencent.imsdk.message;

import com.tencent.imsdk.conversation.ConversationKey;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class MessageSearchParam implements Serializable {
    private ConversationKey conversationKey;
    private List<String> keywordList;
    private List<Integer> messageTypeList;
    private List<String> senderUserIDList;
    private int keywordListMatchType = 0;
    private long searchTimePosition = 0;
    private long searchTimePeriod = 0;
    private int pageIndex = 0;
    private int pageSize = 0;

    public ConversationKey getConversationKey() {
        return this.conversationKey;
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public int getKeywordListMatchType() {
        return this.keywordListMatchType;
    }

    public List<Integer> getMessageTypeList() {
        return this.messageTypeList;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getSearchTimePeriod() {
        return this.searchTimePeriod;
    }

    public long getSearchTimePosition() {
        return this.searchTimePosition;
    }

    public List<String> getSenderUserIDList() {
        return this.senderUserIDList;
    }

    public void setConversationKey(ConversationKey conversationKey) {
        this.conversationKey = conversationKey;
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }

    public void setKeywordListMatchType(int i2) {
        this.keywordListMatchType = i2;
    }

    public void setMessageTypeList(List<Integer> list) {
        this.messageTypeList = list;
    }

    public void setPageIndex(int i2) {
        this.pageIndex = i2;
    }

    public void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public void setSearchTimePeriod(long j2) {
        this.searchTimePeriod = j2;
    }

    public void setSearchTimePosition(long j2) {
        this.searchTimePosition = j2;
    }

    public void setSenderUserIDList(List<String> list) {
        this.senderUserIDList = list;
    }
}
