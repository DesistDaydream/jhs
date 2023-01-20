package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendOperationResult;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class V2TIMFriendOperationResult implements Serializable {
    private FriendOperationResult friendOperationResult;

    public int getResultCode() {
        return this.friendOperationResult.getResultCode();
    }

    public String getResultInfo() {
        return this.friendOperationResult.getResultInfo();
    }

    public String getUserID() {
        return this.friendOperationResult.getUserID();
    }

    public void setFriendOperationResult(FriendOperationResult friendOperationResult) {
        this.friendOperationResult = friendOperationResult;
    }
}
