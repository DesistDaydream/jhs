package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class TUIMessageBean implements Serializable {
    public static final int MSG_STATUS_DELETE = 274;
    public static final int MSG_STATUS_DOWNLOADED = 6;
    public static final int MSG_STATUS_DOWNLOADING = 4;
    public static final int MSG_STATUS_NORMAL = 0;
    public static final int MSG_STATUS_READ = 273;
    public static final int MSG_STATUS_REVOKE = 275;
    public static final int MSG_STATUS_SENDING = 1;
    public static final int MSG_STATUS_SEND_FAIL = 3;
    public static final int MSG_STATUS_SEND_SUCCESS = 2;
    public static final int MSG_STATUS_UN_DOWNLOAD = 5;
    private int downloadStatus;
    private String extra;
    private String id;
    private boolean isGroup;
    private long msgTime;
    private int status;
    private V2TIMMessage v2TIMMessage;
    private long readCount = 0;
    private long unreadCount = 1;

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFaceUrl() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        return v2TIMMessage != null ? v2TIMMessage.getFaceUrl() : "";
    }

    public String getFriendRemark() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        return v2TIMMessage != null ? v2TIMMessage.getFriendRemark() : "";
    }

    public String getGroupId() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        return v2TIMMessage != null ? v2TIMMessage.getGroupID() : "";
    }

    public String getId() {
        return this.id;
    }

    public final long getMessageTime() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            long timestamp = v2TIMMessage.getTimestamp();
            if (timestamp != 0) {
                return timestamp;
            }
        }
        return this.msgTime;
    }

    public long getMsgSeq() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getSeq();
        }
        return 0L;
    }

    public int getMsgType() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getElemType();
        }
        return 0;
    }

    public String getNameCard() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        return v2TIMMessage != null ? v2TIMMessage.getNameCard() : "";
    }

    public String getNickName() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        return v2TIMMessage != null ? v2TIMMessage.getNickName() : "";
    }

    public long getReadCount() {
        return this.readCount;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return null;
    }

    public String getSender() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        String sender = v2TIMMessage != null ? v2TIMMessage.getSender() : null;
        return TextUtils.isEmpty(sender) ? V2TIMManager.getInstance().getLoginUser() : sender;
    }

    public int getStatus() {
        return this.status;
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public String getUserDisplayName() {
        if (!TextUtils.isEmpty(getNameCard())) {
            return getNameCard();
        }
        if (!TextUtils.isEmpty(getFriendRemark())) {
            return getFriendRemark();
        }
        if (!TextUtils.isEmpty(getNickName())) {
            return getNickName();
        }
        return "UID：" + getSender();
    }

    public String getUserId() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        return v2TIMMessage != null ? v2TIMMessage.getUserID() : "";
    }

    public V2TIMMessage getV2TIMMessage() {
        return this.v2TIMMessage;
    }

    public boolean isAllRead() {
        return this.unreadCount == 0 && this.readCount > 0;
    }

    public boolean isGroup() {
        return this.isGroup;
    }

    public boolean isNeedReadReceipt() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.isNeedReadReceipt();
        }
        return false;
    }

    public boolean isPeerRead() {
        return this.unreadCount == 0 && this.readCount == 1;
    }

    public boolean isSelf() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.isSelf();
        }
        return true;
    }

    public boolean isUnread() {
        return this.readCount == 0;
    }

    public abstract String onGetDisplayString();

    public abstract void onProcessMessage(V2TIMMessage v2TIMMessage);

    public void setCommonAttribute(V2TIMMessage v2TIMMessage) {
        this.msgTime = System.currentTimeMillis() / 1000;
        this.v2TIMMessage = v2TIMMessage;
        if (v2TIMMessage == null) {
            return;
        }
        this.id = v2TIMMessage.getMsgID();
        boolean z = !TextUtils.isEmpty(v2TIMMessage.getGroupID());
        this.isGroup = z;
        if (!z && v2TIMMessage.isPeerRead()) {
            this.unreadCount = 0L;
            this.readCount = 1L;
        }
        if (v2TIMMessage.getStatus() == 6) {
            this.status = MSG_STATUS_REVOKE;
            if (isSelf()) {
                this.extra = TUIChatService.getAppContext().getString(R.string.revoke_tips_you);
            } else if (this.isGroup) {
                this.extra = TUIChatConstants.covert2HTMLString(getSender()) + TUIChatService.getAppContext().getString(R.string.revoke_tips);
            } else {
                this.extra = TUIChatService.getAppContext().getString(R.string.revoke_tips_other);
            }
        } else if (isSelf()) {
            if (v2TIMMessage.getStatus() == 3) {
                this.status = 3;
            } else if (v2TIMMessage.getStatus() == 2) {
                this.status = 2;
            } else if (v2TIMMessage.getStatus() == 1) {
                this.status = 1;
            }
        }
    }

    public void setDownloadStatus(int i2) {
        this.downloadStatus = i2;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setGroup(boolean z) {
        this.isGroup = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNeedReadReceipt(boolean z) {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            v2TIMMessage.setNeedReadReceipt(z);
        }
    }

    public void setPeerRead(boolean z) {
        if (z) {
            this.unreadCount = 0L;
            this.readCount = 1L;
            return;
        }
        this.unreadCount = 1L;
        this.readCount = 0L;
    }

    public void setReadCount(long j2) {
        this.readCount = j2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setUnreadCount(long j2) {
        this.unreadCount = j2;
    }

    public void setV2TIMMessage(V2TIMMessage v2TIMMessage) {
        this.v2TIMMessage = v2TIMMessage;
        setCommonAttribute(v2TIMMessage);
        onProcessMessage(v2TIMMessage);
    }
}
