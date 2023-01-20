package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.view.TransformExperimental;

@RequiresApi(21)
@TransformExperimental
/* loaded from: classes.dex */
public final class OutputTransform {
    @NonNull
    public final Matrix mMatrix;
    @NonNull
    public final Size mViewPortSize;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public OutputTransform(@NonNull Matrix matrix, @NonNull Size size) {
        this.mMatrix = matrix;
        this.mViewPortSize = size;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Matrix getMatrix() {
        return this.mMatrix;
    }

    @NonNull
    public Size getViewPortSize() {
        return this.mViewPortSize;
    }
}
