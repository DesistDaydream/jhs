package com.meizu.cloud.pushsdk.platform.message;

import com.baidu.mobads.sdk.internal.bc;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.android.tpush.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SubTagsStatus extends BasicPushStatus {
    private String pushId;
    private List<Tag> tagList;

    /* loaded from: classes2.dex */
    public class Tag implements Serializable {
        private int tagId;
        private String tagName;

        public Tag() {
        }

        public int getTagId() {
            return this.tagId;
        }

        public String getTagName() {
            return this.tagName;
        }

        public void setTagId(int i2) {
            this.tagId = i2;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }

        public String toString() {
            return "Tag{tagId=" + this.tagId + ", tagName='" + this.tagName + "'}";
        }
    }

    public SubTagsStatus() {
    }

    public SubTagsStatus(String str) {
        super(str);
    }

    public String getPushId() {
        return this.pushId;
    }

    public List<Tag> getTagList() {
        return this.tagList;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(JSONObject jSONObject) {
        if (!jSONObject.isNull(PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(PushConstants.KEY_PUSH_ID));
        }
        if (jSONObject.isNull(bc.f1477l)) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(bc.f1477l);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            Tag tag = new Tag();
            if (!jSONObject2.isNull("tagId")) {
                tag.tagId = jSONObject2.getInt("tagId");
            }
            if (!jSONObject2.isNull(Constants.FLAG_TAG_NAME)) {
                tag.tagName = jSONObject2.getString(Constants.FLAG_TAG_NAME);
            }
            arrayList.add(tag);
        }
        e.p.a.a.a.f(BasicPushStatus.TAG, "tags " + arrayList);
        setTagList(arrayList);
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public void setTagList(List<Tag> list) {
        this.tagList = list;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public String toString() {
        return super.toString() + " SubTagsStatus{pushId='" + this.pushId + "', tagList=" + this.tagList + '}';
    }
}
