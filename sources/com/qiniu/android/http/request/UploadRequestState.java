package com.qiniu.android.http.request;

/* loaded from: classes3.dex */
public class UploadRequestState {
    private boolean isUseOldServer;
    private boolean isUserCancel;

    public boolean isUseOldServer() {
        return this.isUseOldServer;
    }

    public boolean isUserCancel() {
        return this.isUserCancel;
    }

    public void setUseOldServer(boolean z) {
        this.isUseOldServer = z;
    }

    public void setUserCancel(boolean z) {
        this.isUserCancel = z;
    }

    /* renamed from: clone */
    public UploadRequestState m39clone() {
        UploadRequestState uploadRequestState = new UploadRequestState();
        uploadRequestState.isUseOldServer = this.isUseOldServer;
        uploadRequestState.isUserCancel = this.isUserCancel;
        return uploadRequestState;
    }
}
