package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.TopicInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class V2TIMTopicInfoResult implements Serializable {
    private TopicInfo topicInfo = new TopicInfo();

    public int getErrorCode() {
        TopicInfo topicInfo = this.topicInfo;
        if (topicInfo == null) {
            return 0;
        }
        return topicInfo.getErrorCode();
    }

    public String getErrorMessage() {
        TopicInfo topicInfo = this.topicInfo;
        return topicInfo == null ? "" : topicInfo.getErrorMessage();
    }

    public V2TIMTopicInfo getTopicInfo() {
        V2TIMTopicInfo v2TIMTopicInfo = new V2TIMTopicInfo();
        v2TIMTopicInfo.setTopicInfo(this.topicInfo);
        return v2TIMTopicInfo;
    }

    public void setTopicInfo(TopicInfo topicInfo) {
        this.topicInfo = topicInfo;
    }
}
