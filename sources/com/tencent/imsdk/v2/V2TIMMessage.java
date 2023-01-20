package com.tencent.imsdk.v2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FaceElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.GroupTipsElement;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageAtInfo;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageOfflinePushInfo;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class V2TIMMessage implements Serializable {
    public static final int V2TIM_ELEM_TYPE_CUSTOM = 2;
    public static final int V2TIM_ELEM_TYPE_FACE = 8;
    public static final int V2TIM_ELEM_TYPE_FILE = 6;
    public static final int V2TIM_ELEM_TYPE_GROUP_TIPS = 9;
    public static final int V2TIM_ELEM_TYPE_IMAGE = 3;
    public static final int V2TIM_ELEM_TYPE_LOCATION = 7;
    public static final int V2TIM_ELEM_TYPE_MERGER = 10;
    public static final int V2TIM_ELEM_TYPE_NONE = 0;
    public static final int V2TIM_ELEM_TYPE_SOUND = 4;
    public static final int V2TIM_ELEM_TYPE_TEXT = 1;
    public static final int V2TIM_ELEM_TYPE_VIDEO = 5;
    public static final int V2TIM_GROUP_MESSAGE_READ_MEMBERS_FILTER_READ = 0;
    public static final int V2TIM_GROUP_MESSAGE_READ_MEMBERS_FILTER_UNREAD = 1;
    public static final int V2TIM_MSG_STATUS_HAS_DELETED = 4;
    public static final int V2TIM_MSG_STATUS_LOCAL_IMPORTED = 5;
    public static final int V2TIM_MSG_STATUS_LOCAL_REVOKED = 6;
    public static final int V2TIM_MSG_STATUS_SENDING = 1;
    public static final int V2TIM_MSG_STATUS_SEND_FAIL = 3;
    public static final int V2TIM_MSG_STATUS_SEND_SUCC = 2;
    public static final int V2TIM_NOT_RECEIVE_MESSAGE = 1;
    public static final int V2TIM_PRIORITY_DEFAULT = 0;
    public static final int V2TIM_PRIORITY_HIGH = 1;
    public static final int V2TIM_PRIORITY_LOW = 3;
    public static final int V2TIM_PRIORITY_NORMAL = 2;
    public static final int V2TIM_RECEIVE_MESSAGE = 0;
    public static final int V2TIM_RECEIVE_NOT_NOTIFY_MESSAGE = 2;
    private Message message;

    public V2TIMMessage() {
        Message message = new Message();
        this.message = message;
        message.setClientTime(BaseManager.getInstance().getServerTime());
    }

    public String getCloudCustomData() {
        Message message = this.message;
        return message == null ? "" : message.getCloudCustomString();
    }

    public V2TIMCustomElem getCustomElem() {
        if (getElemType() != 0 && getElemType() == 2) {
            V2TIMCustomElem v2TIMCustomElem = new V2TIMCustomElem();
            v2TIMCustomElem.setMessage(this.message);
            v2TIMCustomElem.setElemIndex(0);
            return v2TIMCustomElem;
        }
        return null;
    }

    public int getElemType() {
        Message message = this.message;
        if (message != null && message.getMessageBaseElements().size() > 0) {
            MessageBaseElement messageBaseElement = this.message.getMessageBaseElements().get(0);
            if (messageBaseElement instanceof TextElement) {
                return 1;
            }
            if (messageBaseElement instanceof ImageElement) {
                return 3;
            }
            if (messageBaseElement instanceof VideoElement) {
                return 5;
            }
            if (messageBaseElement instanceof SoundElement) {
                return 4;
            }
            if (messageBaseElement instanceof FaceElement) {
                return 8;
            }
            if (messageBaseElement instanceof FileElement) {
                return 6;
            }
            if (messageBaseElement instanceof CustomElement) {
                return 2;
            }
            if (messageBaseElement instanceof LocationElement) {
                return 7;
            }
            if (messageBaseElement instanceof GroupTipsElement) {
                return 9;
            }
            return messageBaseElement instanceof MergerElement ? 10 : 0;
        }
        return 0;
    }

    public V2TIMFaceElem getFaceElem() {
        if (getElemType() != 0 && getElemType() == 8) {
            V2TIMFaceElem v2TIMFaceElem = new V2TIMFaceElem();
            v2TIMFaceElem.setMessage(this.message);
            v2TIMFaceElem.setElemIndex(0);
            return v2TIMFaceElem;
        }
        return null;
    }

    public String getFaceUrl() {
        Message message = this.message;
        if (message != null) {
            return message.getFaceUrl();
        }
        return null;
    }

    public V2TIMFileElem getFileElem() {
        if (getElemType() != 0 && getElemType() == 6) {
            V2TIMFileElem v2TIMFileElem = new V2TIMFileElem();
            v2TIMFileElem.setMessage(this.message);
            v2TIMFileElem.setElemIndex(0);
            return v2TIMFileElem;
        }
        return null;
    }

    public String getFriendRemark() {
        Message message = this.message;
        if (message != null) {
            return message.getFriendRemark();
        }
        return null;
    }

    public List<String> getGroupAtUserList() {
        Message message = this.message;
        if (message == null) {
            return new ArrayList();
        }
        List<MessageAtInfo> messageGroupAtInfoList = message.getMessageGroupAtInfoList();
        ArrayList arrayList = new ArrayList();
        for (MessageAtInfo messageAtInfo : messageGroupAtInfoList) {
            arrayList.add(messageAtInfo.getAtUserID());
        }
        return arrayList;
    }

    public String getGroupID() {
        Message message = this.message;
        if (message == null || message.getMessageType() != Message.MESSAGE_TYPE_GROUP) {
            return null;
        }
        return this.message.getGroupID();
    }

    public V2TIMGroupTipsElem getGroupTipsElem() {
        if (getElemType() != 0 && getElemType() == 9) {
            V2TIMGroupTipsElem v2TIMGroupTipsElem = new V2TIMGroupTipsElem();
            v2TIMGroupTipsElem.setMessage(this.message);
            v2TIMGroupTipsElem.setElemIndex(0);
            return v2TIMGroupTipsElem;
        }
        return null;
    }

    public V2TIMImageElem getImageElem() {
        if (getElemType() != 0 && getElemType() == 3) {
            V2TIMImageElem v2TIMImageElem = new V2TIMImageElem();
            v2TIMImageElem.setMessage(this.message);
            v2TIMImageElem.setElemIndex(0);
            return v2TIMImageElem;
        }
        return null;
    }

    public String getLocalCustomData() {
        Message message = this.message;
        return message == null ? "" : message.getLocalCustomString();
    }

    public int getLocalCustomInt() {
        Message message = this.message;
        if (message == null) {
            return 0;
        }
        return message.getLocalCustomNumber();
    }

    public V2TIMLocationElem getLocationElem() {
        if (getElemType() != 0 && getElemType() == 7) {
            V2TIMLocationElem v2TIMLocationElem = new V2TIMLocationElem();
            v2TIMLocationElem.setMessage(this.message);
            v2TIMLocationElem.setElemIndex(0);
            return v2TIMLocationElem;
        }
        return null;
    }

    public V2TIMMergerElem getMergerElem() {
        if (getElemType() != 0 && getElemType() == 10) {
            V2TIMMergerElem v2TIMMergerElem = new V2TIMMergerElem();
            v2TIMMergerElem.setMessage(this.message);
            v2TIMMergerElem.setElemIndex(0);
            return v2TIMMergerElem;
        }
        return null;
    }

    public Message getMessage() {
        return this.message;
    }

    public String getMsgID() {
        Message message = this.message;
        return message != null ? message.getMsgID() : "";
    }

    public String getNameCard() {
        Message message = this.message;
        if (message != null) {
            return message.getNameCard();
        }
        return null;
    }

    public String getNickName() {
        Message message = this.message;
        if (message != null) {
            return message.getNickName();
        }
        return null;
    }

    public V2TIMOfflinePushInfo getOfflinePushInfo() {
        Message message = this.message;
        if (message == null) {
            return null;
        }
        MessageOfflinePushInfo offlinePushInfo = message.getOfflinePushInfo();
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        v2TIMOfflinePushInfo.setMessageOfflinePushInfo(offlinePushInfo);
        return v2TIMOfflinePushInfo;
    }

    public int getPriority() {
        Message message = this.message;
        if (message != null) {
            return message.getPriority();
        }
        return 0;
    }

    public long getRandom() {
        Message message = this.message;
        if (message == null) {
            return 0L;
        }
        return message.getRandom();
    }

    public String getSender() {
        Message message = this.message;
        if (message != null) {
            return message.getSenderUserID();
        }
        return null;
    }

    public long getSeq() {
        Message message = this.message;
        if (message == null) {
            return 0L;
        }
        return message.getSeq();
    }

    public V2TIMSoundElem getSoundElem() {
        if (getElemType() != 0 && getElemType() == 4) {
            V2TIMSoundElem v2TIMSoundElem = new V2TIMSoundElem();
            v2TIMSoundElem.setMessage(this.message);
            v2TIMSoundElem.setElemIndex(0);
            return v2TIMSoundElem;
        }
        return null;
    }

    public int getStatus() {
        Message message = this.message;
        if (message == null) {
            return 1;
        }
        return message.getMessageStatus();
    }

    public V2TIMTextElem getTextElem() {
        if (getElemType() != 0 && getElemType() == 1) {
            V2TIMTextElem v2TIMTextElem = new V2TIMTextElem();
            v2TIMTextElem.setMessage(this.message);
            v2TIMTextElem.setElemIndex(0);
            return v2TIMTextElem;
        }
        return null;
    }

    public long getTimestamp() {
        Message message = this.message;
        if (message != null) {
            return message.getTimestamp();
        }
        return 0L;
    }

    public String getUserID() {
        Message message = this.message;
        if (message == null || message.getMessageType() != Message.MESSAGE_TYPE_C2C) {
            return null;
        }
        if (this.message.isMessageSender()) {
            return this.message.getReceiverUserID();
        }
        return this.message.getSenderUserID();
    }

    public V2TIMVideoElem getVideoElem() {
        if (getElemType() != 0 && getElemType() == 5) {
            V2TIMVideoElem v2TIMVideoElem = new V2TIMVideoElem();
            v2TIMVideoElem.setMessage(this.message);
            v2TIMVideoElem.setElemIndex(0);
            return v2TIMVideoElem;
        }
        return null;
    }

    public boolean isExcludedFromLastMessage() {
        Message message = this.message;
        if (message == null) {
            return false;
        }
        return message.isExcludedFromLastMessage();
    }

    public boolean isExcludedFromUnreadCount() {
        Message message = this.message;
        if (message == null) {
            return false;
        }
        return message.isExcludedFromUnreadCount();
    }

    public boolean isNeedReadReceipt() {
        Message message = this.message;
        if (message != null) {
            return message.isNeedReadReceipt();
        }
        return false;
    }

    public boolean isPeerRead() {
        Message message;
        int status = getStatus();
        if (status == 1 || status == 3 || (message = this.message) == null) {
            return false;
        }
        return message.isPeerRead();
    }

    public boolean isRead() {
        Message message = this.message;
        if (message != null) {
            return message.isSelfRead();
        }
        return true;
    }

    public boolean isSelf() {
        Message message = this.message;
        if (message != null) {
            return message.isMessageSender();
        }
        return true;
    }

    public void setCloudCustomData(String str) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setCloudCustomString(str);
    }

    public void setExcludedFromLastMessage(boolean z) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setExcludedFromLastMessage(z);
    }

    public void setExcludedFromUnreadCount(boolean z) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setExcludedFromUnreadCount(z);
    }

    public void setGroupAtUserList(List<String> list) {
        if (this.message == null || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            MessageAtInfo messageAtInfo = new MessageAtInfo();
            messageAtInfo.setAtUserID(str);
            arrayList.add(messageAtInfo);
        }
        this.message.setMessageGroupAtInfoList(arrayList);
    }

    public void setLocalCustomData(String str) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setLocalCustomString(str);
    }

    public void setLocalCustomInt(int i2) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setLocalCustomNumber(i2);
    }

    public void setMessage(Message message) {
        if (message == null) {
            return;
        }
        this.message = message;
    }

    public void setNeedReadReceipt(boolean z) {
        Message message = this.message;
        if (message != null) {
            message.setNeedReadReceipt(z);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V2TIMMessage--->");
        StringBuilder sb2 = new StringBuilder();
        V2TIMElem v2TIMElem = null;
        for (int i2 = 0; i2 < this.message.getMessageBaseElements().size(); i2++) {
            MessageBaseElement messageBaseElement = this.message.getMessageBaseElements().get(i2);
            if (messageBaseElement instanceof TextElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getTextElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMTextElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof CustomElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getCustomElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMCustomElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof ImageElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getImageElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMImageElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof SoundElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getSoundElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMSoundElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof VideoElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getVideoElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMVideoElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof FileElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getFileElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMFileElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof LocationElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getLocationElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMLocationElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof FaceElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getFaceElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMFaceElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof MergerElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getMergerElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMMergerElem) v2TIMElem).toString());
            } else if (messageBaseElement instanceof GroupTipsElement) {
                if (v2TIMElem == null) {
                    v2TIMElem = getGroupTipsElem();
                } else {
                    v2TIMElem = v2TIMElem.getNextElem();
                }
                sb2.append(((V2TIMGroupTipsElem) v2TIMElem).toString());
            }
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        sb.append("msgID:");
        sb.append(getMsgID());
        sb.append(", timestamp:");
        sb.append(getTimestamp());
        sb.append(", sender:");
        sb.append(getSender());
        sb.append(", nickname:");
        sb.append(getNickName());
        sb.append(", faceUrl:");
        sb.append(getFaceUrl());
        sb.append(", friendRemark:");
        sb.append(getFriendRemark());
        sb.append(", friendRemark:");
        sb.append(getFriendRemark());
        sb.append(", nameCard:");
        sb.append(getNameCard());
        sb.append(", groupID:");
        sb.append(getGroupID());
        sb.append(", userID:");
        sb.append(getUserID());
        sb.append(", seq:");
        sb.append(getSeq());
        sb.append(", random:");
        sb.append(getRandom());
        sb.append(", status:");
        sb.append(getStatus());
        sb.append(", isSelf:");
        sb.append(isSelf());
        sb.append(", isRead:");
        sb.append(isRead());
        sb.append(", isPeerRead:");
        sb.append(isPeerRead());
        sb.append(", needReadReceipt:");
        sb.append(isNeedReadReceipt());
        sb.append(", priority:");
        sb.append(getPriority());
        sb.append(", groupAtUserList:");
        sb.append(getGroupAtUserList());
        sb.append(", elemType:");
        sb.append(getElemType());
        sb.append(", localCustomData:");
        sb.append(getLocalCustomData());
        sb.append(", localCustomInt:");
        sb.append(getLocalCustomInt());
        sb.append(", cloudCustomData:");
        sb.append(getCloudCustomData());
        sb.append(", isExcludeFromUnreadCount:");
        sb.append(isExcludedFromUnreadCount());
        sb.append(", isExcludeFromLastMessage:");
        sb.append(isExcludedFromLastMessage());
        sb.append(", offlinePushInfo:");
        sb.append(getOfflinePushInfo());
        sb.append(", elemDesc:");
        sb.append(sb2.toString());
        return sb.toString();
    }
}
