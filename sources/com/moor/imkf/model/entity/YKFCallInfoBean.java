package com.moor.imkf.model.entity;

/* loaded from: classes2.dex */
public class YKFCallInfoBean {
    private String exten;
    private boolean isCallIn;
    private boolean isVideo;
    private String password;
    private String roomId;
    private String userIcon;
    private String userName;
    private String videoType;

    public String getExten() {
        return this.exten;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getUserIcon() {
        return this.userIcon;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public boolean isCallIn() {
        return this.isCallIn;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public YKFCallInfoBean setCallIn(boolean z) {
        this.isCallIn = z;
        return this;
    }

    public YKFCallInfoBean setExten(String str) {
        this.exten = str;
        return this;
    }

    public YKFCallInfoBean setPassword(String str) {
        this.password = str;
        return this;
    }

    public YKFCallInfoBean setRoomId(String str) {
        this.roomId = str;
        return this;
    }

    public YKFCallInfoBean setUserIcon(String str) {
        this.userIcon = str;
        return this;
    }

    public YKFCallInfoBean setUserName(String str) {
        this.userName = str;
        return this;
    }

    public YKFCallInfoBean setVideo(boolean z) {
        this.isVideo = z;
        return this;
    }

    public YKFCallInfoBean setVideoType(String str) {
        this.videoType = str;
        return this;
    }
}
