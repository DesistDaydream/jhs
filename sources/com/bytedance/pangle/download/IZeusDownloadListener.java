package com.bytedance.pangle.download;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public interface IZeusDownloadListener {
    void onFailed(Throwable th, int i2, String str);

    void onProgress(long j2, long j3);

    void onStart();

    void onSuccess(String str, String str2, long j2);
}
