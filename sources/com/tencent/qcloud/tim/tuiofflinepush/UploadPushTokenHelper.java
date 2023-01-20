package com.tencent.qcloud.tim.tuiofflinepush;

/* loaded from: classes3.dex */
public class UploadPushTokenHelper {
    private static UploadPushTokenHelper instance = new UploadPushTokenHelper();
    private IPushUploader uploader;

    private UploadPushTokenHelper() {
    }

    public static UploadPushTokenHelper getInstance() {
        return instance;
    }

    public IPushUploader getUploader() {
        return this.uploader;
    }

    public void setUploader(IPushUploader iPushUploader) {
        this.uploader = iPushUploader;
    }
}
