package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import e.j.b.a.c;

@c
@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class OutputSurface {
    @NonNull
    public static OutputSurface create(@NonNull Surface surface, @NonNull Size size, int i2) {
        return new AutoValue_OutputSurface(surface, size, i2);
    }

    public abstract int getImageFormat();

    @NonNull
    public abstract Size getSize();

    @NonNull
    public abstract Surface getSurface();
}
