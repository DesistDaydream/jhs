package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageInfo;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ImageInfoProcessor {
    @Nullable
    CaptureStage getCaptureStage();

    boolean process(@NonNull ImageInfo imageInfo);
}
