package c.b.a;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraThreadConfig;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements CameraFactory.Provider {
    public static final /* synthetic */ c a = new c();

    @Override // androidx.camera.core.impl.CameraFactory.Provider
    public final CameraFactory newInstance(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) {
        return new Camera2CameraFactory(context, cameraThreadConfig, cameraSelector);
    }
}
