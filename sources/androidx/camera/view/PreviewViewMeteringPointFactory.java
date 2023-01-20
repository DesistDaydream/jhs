package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class PreviewViewMeteringPointFactory extends MeteringPointFactory {
    public static final PointF INVALID_POINT = new PointF(2.0f, 2.0f);
    @Nullable
    @GuardedBy("this")
    private Matrix mMatrix;
    @NonNull
    private final PreviewTransformation mPreviewTransformation;

    public PreviewViewMeteringPointFactory(@NonNull PreviewTransformation previewTransformation) {
        this.mPreviewTransformation = previewTransformation;
    }

    @Override // androidx.camera.core.MeteringPointFactory
    @NonNull
    @AnyThread
    public PointF convertPoint(float f2, float f3) {
        float[] fArr = {f2, f3};
        synchronized (this) {
            Matrix matrix = this.mMatrix;
            if (matrix == null) {
                return INVALID_POINT;
            }
            matrix.mapPoints(fArr);
            return new PointF(fArr[0], fArr[1]);
        }
    }

    @UiThread
    public void recalculate(@NonNull Size size, int i2) {
        Threads.checkMainThread();
        synchronized (this) {
            if (size.getWidth() != 0 && size.getHeight() != 0) {
                this.mMatrix = this.mPreviewTransformation.getPreviewViewToNormalizedSurfaceMatrix(size, i2);
                return;
            }
            this.mMatrix = null;
        }
    }
}
