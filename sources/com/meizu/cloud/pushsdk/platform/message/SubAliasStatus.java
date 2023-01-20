package com.meizu.cloud.pushsdk.platform.message;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SubAliasStatus extends BasicPushStatus {
    private String alias;
    private String pushId;

    public SubAliasStatus() {
    }

    public SubAliasStatus(String str) {
        super(str);
    }

    public String getAlias() {
        return this.alias;
    }

    public String getPushId() {
        return this.pushId;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(JSONObject jSONObject) {
        if (!jSONObject.isNull(PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(PushConstants.KEY_PUSH_ID));
        }
        if (jSONObject.isNull(PushConstants.SUB_ALIAS_STATUS_NAME)) {
            return;
        }
        setAlias(jSONObject.getString(PushConstants.SUB_ALIAS_STATUS_NAME));
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public String toString() {
        return super.toString() + " SubAliasStatus{pushId='" + this.pushId + "', alias='" + this.alias + "'}";
    }
}
