package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraCaptureResults {
    private CameraCaptureResults() {
    }

    @Nullable
    public static CameraCaptureResult retrieveCameraCaptureResult(@NonNull ImageInfo imageInfo) {
        if (imageInfo instanceof CameraCaptureResultImageInfo) {
            return ((CameraCaptureResultImageInfo) imageInfo).getCameraCaptureResult();
        }
        return null;
    }
}
