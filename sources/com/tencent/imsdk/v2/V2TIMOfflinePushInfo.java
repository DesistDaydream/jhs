package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageOfflinePushInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class V2TIMOfflinePushInfo implements Serializable {
    public static final String IOS_OFFLINE_PUSH_DEFAULT_SOUND = "default";
    public static final String IOS_OFFLINE_PUSH_NO_SOUND = "push.no_sound";
    private MessageOfflinePushInfo messageOfflinePushInfo;

    public void disablePush(boolean z) {
        if (this.messageOfflinePushInfo == null) {
            this.messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        if (z) {
            this.messageOfflinePushInfo.setPushFlag(1);
        } else {
            this.messageOfflinePushInfo.setPushFlag(0);
        }
    }

    public String getDesc() {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            return messageOfflinePushInfo.getDescription();
        }
        return null;
    }

    public byte[] getExt() {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo == null) {
            return null;
        }
        return messageOfflinePushInfo.getExtension();
    }

    public MessageOfflinePushInfo getMessageOfflinePushInfo() {
        return this.messageOfflinePushInfo;
    }

    public String getTitle() {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            return messageOfflinePushInfo.getTitle();
        }
        return null;
    }

    public boolean isDisablePush() {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        return messageOfflinePushInfo != null && messageOfflinePushInfo.getPushFlag() == 1;
    }

    public void setAndroidOPPOChannelID(String str) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            messageOfflinePushInfo.getAndroidConfig().setOppoChannelID(str);
        }
    }

    public void setAndroidSound(String str) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            messageOfflinePushInfo.getAndroidConfig().setSoundFilePath(str);
        }
    }

    public void setAndroidVIVOClassification(int i2) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            messageOfflinePushInfo.getAndroidConfig().setVivoClassification(i2);
        }
    }

    public void setDesc(String str) {
        if (this.messageOfflinePushInfo == null) {
            this.messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        this.messageOfflinePushInfo.setDescription(str);
    }

    public void setExt(byte[] bArr) {
        if (this.messageOfflinePushInfo == null) {
            this.messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        this.messageOfflinePushInfo.setExtension(bArr);
    }

    public void setIOSSound(String str) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            messageOfflinePushInfo.getApnsConfig().setSoundFilePath(str);
        }
    }

    public void setIgnoreIOSBadge(boolean z) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            if (z) {
                messageOfflinePushInfo.getApnsConfig().setBadgeMode(1);
            } else {
                messageOfflinePushInfo.getApnsConfig().setBadgeMode(0);
            }
        }
    }

    public void setMessageOfflinePushInfo(MessageOfflinePushInfo messageOfflinePushInfo) {
        this.messageOfflinePushInfo = messageOfflinePushInfo;
    }

    public void setTitle(String str) {
        if (this.messageOfflinePushInfo == null) {
            this.messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        this.messageOfflinePushInfo.setTitle(str);
    }
}
