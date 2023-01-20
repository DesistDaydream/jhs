package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureFailure;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraCaptureFailure;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Camera2CameraCaptureFailure extends CameraCaptureFailure {
    private final CaptureFailure mCaptureFailure;

    public Camera2CameraCaptureFailure(@NonNull CameraCaptureFailure.Reason reason, @NonNull CaptureFailure captureFailure) {
        super(reason);
        this.mCaptureFailure = captureFailure;
    }

    @NonNull
    public CaptureFailure getCaptureFailure() {
        return this.mCaptureFailure;
    }
}
