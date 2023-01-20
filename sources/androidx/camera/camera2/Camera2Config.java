package androidx.camera.camera2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.UseCaseConfigFactory;
import c.b.a.a;
import c.b.a.b;
import c.b.a.c;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Camera2Config {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static final class DefaultProvider implements CameraXConfig.Provider {
        @Override // androidx.camera.core.CameraXConfig.Provider
        @NonNull
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.defaultConfig();
        }
    }

    private Camera2Config() {
    }

    public static /* synthetic */ CameraDeviceSurfaceManager a(Context context, Object obj, Set set) throws InitializationException {
        try {
            return new Camera2DeviceSurfaceManager(context, obj, set);
        } catch (CameraUnavailableException e2) {
            throw new InitializationException(e2);
        }
    }

    public static /* synthetic */ UseCaseConfigFactory b(Context context) throws InitializationException {
        return new Camera2UseCaseConfigFactory(context);
    }

    @NonNull
    public static CameraXConfig defaultConfig() {
        c cVar = c.a;
        b bVar = b.a;
        return new CameraXConfig.Builder().setCameraFactoryProvider(cVar).setDeviceSurfaceManagerProvider(bVar).setUseCaseConfigFactoryProvider(a.a).build();
    }
}
