package c.b.b.c2;

import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.internal.CameraUseCaseAdapter;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Preview.SurfaceProvider {
    public static final /* synthetic */ a a = new a();

    @Override // androidx.camera.core.Preview.SurfaceProvider
    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        CameraUseCaseAdapter.b(surfaceRequest);
    }
}
