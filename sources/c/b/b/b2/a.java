package c.b.b.b2;

import android.content.Context;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements CameraConfigProvider {
    public static final /* synthetic */ a a = new a();

    @Override // androidx.camera.core.impl.CameraConfigProvider
    public final CameraConfig getConfig(CameraInfo cameraInfo, Context context) {
        return y.a(cameraInfo, context);
    }
}
