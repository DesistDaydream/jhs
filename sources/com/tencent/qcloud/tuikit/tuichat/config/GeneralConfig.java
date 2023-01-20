package com.tencent.qcloud.tuikit.tuichat.config;

/* loaded from: classes3.dex */
public class GeneralConfig {
    public static final int DEFAULT_AUDIO_RECORD_MAX_TIME = 60;
    public static final int DEFAULT_VIDEO_RECORD_MAX_TIME = 15;
    private String appCacheDir;
    private boolean excludedFromLastMessage;
    private boolean excludedFromUnreadCount;
    private boolean isAndroidPrivateRing;
    private int audioRecordMaxTime = 60;
    private int videoRecordMaxTime = 15;
    private boolean showRead = true;
    private boolean isNeedReadReceipt = false;
    private String userNickname = "";
    private String userFaceUrl = "";

    public String getAppCacheDir() {
        return this.appCacheDir;
    }

    public int getAudioRecordMaxTime() {
        return this.audioRecordMaxTime;
    }

    public String getUserFaceUrl() {
        return this.userFaceUrl;
    }

    public String getUserNickname() {
        return this.userNickname;
    }

    public int getVideoRecordMaxTime() {
        return this.videoRecordMaxTime;
    }

    public boolean isAndroidPrivateRing() {
        return this.isAndroidPrivateRing;
    }

    public boolean isExcludedFromLastMessage() {
        return this.excludedFromLastMessage;
    }

    public boolean isExcludedFromUnreadCount() {
        return this.excludedFromUnreadCount;
    }

    public boolean isNeedReadReceipt() {
        return this.isNeedReadReceipt;
    }

    public boolean isShowRead() {
        return this.showRead;
    }

    public void setAndroidPrivateRing(boolean z) {
        this.isAndroidPrivateRing = z;
    }

    public GeneralConfig setAppCacheDir(String str) {
        this.appCacheDir = str;
        return this;
    }

    public GeneralConfig setAudioRecordMaxTime(int i2) {
        this.audioRecordMaxTime = i2;
        return this;
    }

    public void setExcludedFromLastMessage(boolean z) {
        this.excludedFromLastMessage = z;
    }

    public void setExcludedFromUnreadCount(boolean z) {
        this.excludedFromUnreadCount = z;
    }

    public void setNeedReadReceipt(boolean z) {
        this.isNeedReadReceipt = z;
    }

    public void setShowRead(boolean z) {
        this.showRead = z;
    }

    public void setUserFaceUrl(String str) {
        this.userFaceUrl = str;
    }

    public void setUserNickname(String str) {
        this.userNickname = str;
    }

    public GeneralConfig setVideoRecordMaxTime(int i2) {
        this.videoRecordMaxTime = i2;
        return this;
    }
}
