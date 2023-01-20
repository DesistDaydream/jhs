package com.tencent.qcloud.tuikit.tuichat.component.camera.listener;

/* loaded from: classes3.dex */
public interface CaptureListener {
    void recordEnd(long j2);

    void recordError();

    void recordShort(long j2);

    void recordStart();

    void recordZoom(float f2);

    void takePictures();
}
