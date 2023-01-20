package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.Map;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ExtendedCameraConfigProviderStore {
    private static final Object LOCK = new Object();
    @GuardedBy("LOCK")
    private static final Map<Object, CameraConfigProvider> CAMERA_CONFIG_PROVIDERS = new HashMap();

    private ExtendedCameraConfigProviderStore() {
    }

    public static void addConfig(@NonNull Object obj, @NonNull CameraConfigProvider cameraConfigProvider) {
        synchronized (LOCK) {
            CAMERA_CONFIG_PROVIDERS.put(obj, cameraConfigProvider);
        }
    }

    @NonNull
    public static CameraConfigProvider getConfigProvider(@NonNull Object obj) {
        CameraConfigProvider cameraConfigProvider;
        synchronized (LOCK) {
            cameraConfigProvider = CAMERA_CONFIG_PROVIDERS.get(obj);
        }
        return cameraConfigProvider == null ? CameraConfigProvider.EMPTY : cameraConfigProvider;
    }
}
