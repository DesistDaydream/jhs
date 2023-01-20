package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.view.TransformExperimental;
import androidx.camera.view.TransformUtils;

@RequiresApi(21)
@TransformExperimental
/* loaded from: classes.dex */
public final class ImageProxyTransformFactory {
    private boolean mUsingCropRect;
    private boolean mUsingRotationDegrees;

    private RectF getCropRect(@NonNull ImageProxy imageProxy) {
        if (this.mUsingCropRect) {
            return new RectF(imageProxy.getCropRect());
        }
        return new RectF(0.0f, 0.0f, imageProxy.getWidth(), imageProxy.getHeight());
    }

    public static RectF getRotatedCropRect(RectF rectF, int i2) {
        if (TransformUtils.is90or270(i2)) {
            return new RectF(0.0f, 0.0f, rectF.height(), rectF.width());
        }
        return new RectF(0.0f, 0.0f, rectF.width(), rectF.height());
    }

    private int getRotationDegrees(@NonNull ImageProxy imageProxy) {
        if (this.mUsingRotationDegrees) {
            return imageProxy.getImageInfo().getRotationDegrees();
        }
        return 0;
    }

    @NonNull
    public OutputTransform getOutputTransform(@NonNull ImageProxy imageProxy) {
        int rotationDegrees = getRotationDegrees(imageProxy);
        RectF cropRect = getCropRect(imageProxy);
        Matrix rectToRect = TransformUtils.getRectToRect(cropRect, getRotatedCropRect(cropRect, rotationDegrees), rotationDegrees);
        rectToRect.preConcat(TransformUtils.getNormalizedToBuffer(imageProxy.getCropRect()));
        return new OutputTransform(rectToRect, TransformUtils.rectToSize(imageProxy.getCropRect()));
    }

    public boolean isUsingCropRect() {
        return this.mUsingCropRect;
    }

    public boolean isUsingRotationDegrees() {
        return this.mUsingRotationDegrees;
    }

    public void setUsingCropRect(boolean z) {
        this.mUsingCropRect = z;
    }

    public void setUsingRotationDegrees(boolean z) {
        this.mUsingRotationDegrees = z;
    }
}
