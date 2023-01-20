package com.tencent.qcloud.tuikit.tuichat.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class OfflinePushInfo implements Serializable {
    public static final String IOS_OFFLINE_PUSH_DEFAULT_SOUND = "default";
    public static final String IOS_OFFLINE_PUSH_NO_SOUND = "push.no_sound";
    private String androidSoundFilePath;
    private int badgeMode;
    private String description;
    private byte[] extension;
    private String iosSoundFilePath;
    private int notifyMode;
    private String oppoChannelID;
    private int pushFlag;
    private String title;
    private int vivoClassification = 1;

    public void disablePush(boolean z) {
        if (z) {
            setPushFlag(1);
        } else {
            setPushFlag(0);
        }
    }

    public String getAndroidSound() {
        return this.androidSoundFilePath;
    }

    public int getBadgeMode() {
        return this.badgeMode;
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getExtension() {
        return this.extension;
    }

    public String getIOSSoundFilePath() {
        return this.iosSoundFilePath;
    }

    public int getNotifyMode() {
        return this.notifyMode;
    }

    public String getOppoChannelID() {
        return this.oppoChannelID;
    }

    public int getPushFlag() {
        return this.pushFlag;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVivoClassification() {
        return this.vivoClassification;
    }

    public boolean isDisablePush() {
        return getPushFlag() == 1;
    }

    public boolean isIgnoreIOSBadge() {
        return this.badgeMode == 1;
    }

    public void setAndroidOPPOChannelID(String str) {
        setOppoChannelID(str);
    }

    public void setAndroidSound(String str) {
        this.androidSoundFilePath = str;
    }

    public void setAndroidVIVOClassification(int i2) {
        setVivoClassification(i2);
    }

    public void setBadgeMode(int i2) {
        this.badgeMode = i2;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtension(byte[] bArr) {
        this.extension = bArr;
    }

    public void setIOSSound(String str) {
        this.iosSoundFilePath = str;
    }

    public void setIgnoreIOSBadge(boolean z) {
        if (z) {
            setBadgeMode(1);
        } else {
            setBadgeMode(0);
        }
    }

    public void setNotifyMode(int i2) {
        this.notifyMode = i2;
    }

    public void setOppoChannelID(String str) {
        this.oppoChannelID = str;
    }

    public void setPushFlag(int i2) {
        this.pushFlag = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVivoClassification(int i2) {
        this.vivoClassification = i2;
    }
}
