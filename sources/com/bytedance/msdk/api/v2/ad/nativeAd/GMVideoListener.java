package com.bytedance.msdk.api.v2.ad.nativeAd;

import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: classes.dex */
public interface GMVideoListener extends ITTAdatperCallback {
    void onProgressUpdate(long j2, long j3);

    void onVideoCompleted();

    void onVideoError(@NonNull AdError adError);

    void onVideoPause();

    void onVideoResume();

    void onVideoStart();
}
