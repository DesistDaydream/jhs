package com.meizu.cloud.pushsdk.handler;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.d.f.e;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes2.dex */
public class MzPushMessage implements Serializable {
    private static final String TAG = "MzPushMessage";
    private String content;
    private int notifyId;
    private int pushType;
    private String selfDefineContentString;
    private String taskId;
    private String title;

    public static MzPushMessage fromMessageV3(MessageV3 messageV3) {
        MzPushMessage mzPushMessage = new MzPushMessage();
        mzPushMessage.setTitle(messageV3.getTitle());
        mzPushMessage.setContent(messageV3.getContent());
        mzPushMessage.setTaskId(messageV3.getTaskId());
        mzPushMessage.setPushType(0);
        mzPushMessage.setNotifyId(com.meizu.cloud.pushsdk.notification.model.a.b(messageV3));
        mzPushMessage.setSelfDefineContentString(selfDefineContentString(messageV3.getWebUrl(), messageV3.getParamsMap()));
        return mzPushMessage;
    }

    private static String selfDefineContentString(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            if (map != null) {
                str = map.get("sk");
                if (TextUtils.isEmpty(str)) {
                    str = e.a((Map) map).toString();
                }
            } else {
                str = null;
            }
        }
        e.p.a.a.a.f(TAG, "self json " + str);
        return str;
    }

    public String getContent() {
        return this.content;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getPushType() {
        return this.pushType;
    }

    public String getSelfDefineContentString() {
        return this.selfDefineContentString;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setNotifyId(int i2) {
        this.notifyId = i2;
    }

    public void setPushType(int i2) {
        this.pushType = i2;
    }

    public void setSelfDefineContentString(String str) {
        this.selfDefineContentString = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MzPushMessage{title='" + this.title + "', content='" + this.content + "', pushType=" + this.pushType + ", taskId='" + this.taskId + "', selfDefineContentString='" + this.selfDefineContentString + "', notifyId=" + this.notifyId + '}';
    }
}
