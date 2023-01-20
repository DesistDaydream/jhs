package com.tencent.qcloud.tuikit.tuicontact.bean;

import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class ChatInfo implements Serializable {
    public static final int TYPE_C2C = 1;
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_INVALID = 0;
    private static List<V2TIMGroupAtInfo> atInfoList;
    private String chatName;
    private String groupType;
    private String id;
    private boolean isTopChat;
    private int type = 1;

    public List<V2TIMGroupAtInfo> getAtInfoList() {
        return atInfoList;
    }

    public String getChatName() {
        return this.chatName;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public String getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public boolean isTopChat() {
        return this.isTopChat;
    }

    public void setChatName(String str) {
        this.chatName = str;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTopChat(boolean z) {
        this.isTopChat = z;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
