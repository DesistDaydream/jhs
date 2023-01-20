package c.b.a;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import java.util.Set;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements CameraDeviceSurfaceManager.Provider {
    public static final /* synthetic */ b a = new b();

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager.Provider
    public final CameraDeviceSurfaceManager newInstance(Context context, Object obj, Set set) {
        return Camera2Config.a(context, obj, set);
    }
}
