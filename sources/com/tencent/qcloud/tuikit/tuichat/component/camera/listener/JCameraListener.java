package com.tencent.qcloud.tuikit.tuichat.component.camera.listener;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public interface JCameraListener {
    void captureSuccess(Bitmap bitmap);

    void recordSuccess(String str, Bitmap bitmap, long j2);
}
