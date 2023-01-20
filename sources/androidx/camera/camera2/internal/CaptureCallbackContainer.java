package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.Objects;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CaptureCallbackContainer extends CameraCaptureCallback {
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;

    private CaptureCallbackContainer(CameraCaptureSession.CaptureCallback captureCallback) {
        Objects.requireNonNull(captureCallback, "captureCallback is null");
        this.mCaptureCallback = captureCallback;
    }

    public static CaptureCallbackContainer create(CameraCaptureSession.CaptureCallback captureCallback) {
        return new CaptureCallbackContainer(captureCallback);
    }

    @NonNull
    public CameraCaptureSession.CaptureCallback getCaptureCallback() {
        return this.mCaptureCallback;
    }
}
