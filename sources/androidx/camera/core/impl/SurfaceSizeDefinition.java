package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.RequiresApi;
import e.j.b.a.c;

@c
@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class SurfaceSizeDefinition {
    public static SurfaceSizeDefinition create(Size size, Size size2, Size size3) {
        return new AutoValue_SurfaceSizeDefinition(size, size2, size3);
    }

    public abstract Size getAnalysisSize();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();
}
