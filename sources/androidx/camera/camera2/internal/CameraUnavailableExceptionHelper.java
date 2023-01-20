package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraUnavailableExceptionHelper {
    private CameraUnavailableExceptionHelper() {
    }

    @NonNull
    public static CameraUnavailableException createFrom(@NonNull CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int reason = cameraAccessExceptionCompat.getReason();
        int i2 = 5;
        if (reason == 1) {
            i2 = 1;
        } else if (reason == 2) {
            i2 = 2;
        } else if (reason == 3) {
            i2 = 3;
        } else if (reason == 4) {
            i2 = 4;
        } else if (reason != 5) {
            i2 = reason != 10001 ? 0 : 6;
        }
        return new CameraUnavailableException(i2, cameraAccessExceptionCompat);
    }
}
