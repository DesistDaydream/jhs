package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import e.j.c.a.a.a;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CaptureSessionInterface {
    void cancelIssuedCaptureRequests();

    void close();

    @NonNull
    List<CaptureConfig> getCaptureConfigs();

    @Nullable
    SessionConfig getSessionConfig();

    void issueCaptureRequests(@NonNull List<CaptureConfig> list);

    @NonNull
    a<Void> open(@NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice, @NonNull SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener);

    @NonNull
    a<Void> release(boolean z);

    void setSessionConfig(@Nullable SessionConfig sessionConfig);
}
