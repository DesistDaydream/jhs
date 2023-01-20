package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraFactory {

    /* loaded from: classes.dex */
    public interface Provider {
        @NonNull
        CameraFactory newInstance(@NonNull Context context, @NonNull CameraThreadConfig cameraThreadConfig, @Nullable CameraSelector cameraSelector) throws InitializationException;
    }

    @NonNull
    Set<String> getAvailableCameraIds();

    @NonNull
    CameraInternal getCamera(@NonNull String str) throws CameraUnavailableException;

    @Nullable
    Object getCameraManager();
}
