package com.tencent.android.tpush.service.protocol;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;

/* loaded from: classes3.dex */
public enum MessageType {
    REGISTER(MiPushClient.COMMAND_REGISTER),
    ACCOUNT(Constants.FLAG_ACCOUNT),
    UNREGISTER(MiPushClient.COMMAND_UNREGISTER),
    TAG_INFO(RemoteMessageConst.Notification.TAG),
    ATTRIBUTE_INFO("attribute"),
    UPDATE_OTHER_TOKEN("update_channel_token"),
    PUSH_MESSAGE("push"),
    PUSH_VERIFY("push_stat"),
    COMMON_REPORT("common_report"),
    QUERY_TAGS("query_token_tags");
    
    private String str;

    MessageType(String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }
}
