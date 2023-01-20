package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import e.j.b.a.c;

@c
@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class ImmutableImageInfo implements ImageInfo {
    public static ImageInfo create(@NonNull TagBundle tagBundle, long j2, int i2, Matrix matrix) {
        return new AutoValue_ImmutableImageInfo(tagBundle, j2, i2, matrix);
    }

    @Override // androidx.camera.core.ImageInfo
    public abstract int getRotationDegrees();

    @Override // androidx.camera.core.ImageInfo
    @NonNull
    public abstract Matrix getSensorToBufferTransformMatrix();

    @Override // androidx.camera.core.ImageInfo
    @NonNull
    public abstract TagBundle getTagBundle();

    @Override // androidx.camera.core.ImageInfo
    public abstract long getTimestamp();

    @Override // androidx.camera.core.ImageInfo
    public void populateExifData(@NonNull ExifData.Builder builder) {
        builder.setOrientationDegrees(getRotationDegrees());
    }
}
