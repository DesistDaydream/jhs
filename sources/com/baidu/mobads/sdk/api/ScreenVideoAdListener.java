package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f2);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f2);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
