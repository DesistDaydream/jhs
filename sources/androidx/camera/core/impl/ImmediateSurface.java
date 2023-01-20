package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.futures.Futures;
import e.j.c.a.a.a;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ImmediateSurface extends DeferrableSurface {
    private final Surface mSurface;

    public ImmediateSurface(@NonNull Surface surface, @NonNull Size size, int i2) {
        super(size, i2);
        this.mSurface = surface;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public a<Surface> provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }

    public ImmediateSurface(@NonNull Surface surface) {
        this.mSurface = surface;
    }
}
