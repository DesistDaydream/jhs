package com.bytedance.msdk.adapter.config;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* loaded from: classes.dex */
public interface IGMInitAdnResult {
    void fail(@NonNull AdError adError);

    void success();
}
