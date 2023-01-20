package com.bytedance.msdk.api.v2.ad;

/* loaded from: classes.dex */
public interface GMAdAppDownloadListener {
    void onDownloadFailed(long j2, long j3, String str, String str2);

    void onDownloadFinished(long j2, String str, String str2);

    void onDownloadPaused(long j2, long j3, String str, String str2);

    void onDownloadProgress(long j2, long j3, int i2, int i3);

    void onDownloadStarted();

    void onIdle();

    void onInstalled(String str, String str2);
}
