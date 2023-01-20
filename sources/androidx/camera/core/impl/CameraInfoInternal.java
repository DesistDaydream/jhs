package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraInfoInternal extends CameraInfo {
    void addSessionCaptureCallback(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback);

    @NonNull
    CamcorderProfileProvider getCamcorderProfileProvider();

    @NonNull
    String getCameraId();

    @NonNull
    Quirks getCameraQuirks();

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    CameraSelector getCameraSelector();

    @Nullable
    Integer getLensFacing();

    void removeSessionCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback);
}
