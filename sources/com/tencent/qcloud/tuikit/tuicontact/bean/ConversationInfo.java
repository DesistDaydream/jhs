package com.tencent.qcloud.tuikit.tuicontact.bean;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ConversationInfo implements Serializable, Comparable<ConversationInfo> {
    public static final int TYPE_COMMON = 1;
    public static final int TYPE_CUSTOM = 2;
    public static final int TYPE_FORWAR_SELECT = 3;
    public static final int TYPE_RECENT_LABEL = 4;
    private String atInfoText;
    private String conversationId;
    private String groupType;
    private String iconPath;
    private List<Object> iconUrlList = new ArrayList();
    private String id;
    private boolean isGroup;
    private long lastMessageTime;
    private long orderKey;
    private boolean showDisturbIcon;
    private String title;
    private boolean top;
    private int type;
    private int unRead;

    public String getAtInfoText() {
        return this.atInfoText;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public List<Object> getIconUrlList() {
        return this.iconUrlList;
    }

    public String getId() {
        return this.id;
    }

    public long getLastMessageTime() {
        return this.lastMessageTime;
    }

    public long getOrderKey() {
        return this.orderKey;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public int getUnRead() {
        return this.unRead;
    }

    public boolean isGroup() {
        return this.isGroup;
    }

    public boolean isShowDisturbIcon() {
        return this.showDisturbIcon;
    }

    public boolean isTop() {
        return this.top;
    }

    public void setAtInfoText(String str) {
        this.atInfoText = str;
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }

    public void setGroup(boolean z) {
        this.isGroup = z;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setIconPath(String str) {
        this.iconPath = str;
    }

    public void setIconUrlList(List<Object> list) {
        this.iconUrlList = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLastMessageTime(long j2) {
        this.lastMessageTime = j2;
    }

    public void setOrderKey(long j2) {
        this.orderKey = j2;
    }

    public void setShowDisturbIcon(boolean z) {
        this.showDisturbIcon = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTop(boolean z) {
        this.top = z;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUnRead(int i2) {
        this.unRead = i2;
    }

    public String toString() {
        return "ConversationInfo{type=" + this.type + ", unRead=" + this.unRead + ", conversationId='" + this.conversationId + "', id='" + this.id + "', iconUrl='" + this.iconUrlList.size() + "', title='" + this.title + "', iconPath=" + this.iconPath + ", isGroup=" + this.isGroup + ", top=" + this.top + ", lastMessageTime=" + this.lastMessageTime + ", groupType=" + this.groupType + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull ConversationInfo conversationInfo) {
        int i2 = (this.orderKey > conversationInfo.orderKey ? 1 : (this.orderKey == conversationInfo.orderKey ? 0 : -1));
        if (i2 > 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }
}
