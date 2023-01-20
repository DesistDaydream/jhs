package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ImageInfo {
    int getRotationDegrees();

    @NonNull
    Matrix getSensorToBufferTransformMatrix();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    TagBundle getTagBundle();

    long getTimestamp();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void populateExifData(@NonNull ExifData.Builder builder);
}
