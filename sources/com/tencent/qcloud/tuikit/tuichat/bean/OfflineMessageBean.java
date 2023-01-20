package com.tencent.qcloud.tuikit.tuichat.bean;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class OfflineMessageBean {
    public static final int REDIRECT_ACTION_CALL = 2;
    public static final int REDIRECT_ACTION_CHAT = 1;
    public int version = 1;
    public int chatType = 1;
    public int action = 1;
    public String sender = "";
    public String nickname = "";
    public String faceUrl = "";
    public String content = "";
    public long sendTime = 0;

    @NonNull
    public String toString() {
        return "OfflineMessageBean{version=" + this.version + ", chatType='" + this.chatType + "', action=" + this.action + ", sender=" + this.sender + ", nickname=" + this.nickname + ", faceUrl=" + this.faceUrl + ", content=" + this.content + ", sendTime=" + this.sendTime + '}';
    }
}
