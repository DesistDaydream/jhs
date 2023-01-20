package com.tencent.imsdk.group;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class TopicOperationResult implements Serializable {
    private int errorCode;
    private String errorMessage;
    private String topicID;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getTopicID() {
        return this.topicID;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setTopicID(String str) {
        this.topicID = str;
    }
}
