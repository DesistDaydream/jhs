package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class CameraCaptureCallback {
    public void onCaptureCancelled() {
    }

    public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
    }
}
