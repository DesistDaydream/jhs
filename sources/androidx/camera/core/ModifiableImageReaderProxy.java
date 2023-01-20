package androidx.camera.core;

import android.graphics.Matrix;
import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.TagBundle;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ModifiableImageReaderProxy extends AndroidImageReaderProxy {
    private volatile Integer mRotationDegrees;
    private volatile Matrix mSensorToBufferTransformMatrix;
    private volatile TagBundle mTagBundle;
    private volatile Long mTimestamp;

    public ModifiableImageReaderProxy(@NonNull ImageReader imageReader) {
        super(imageReader);
        this.mTagBundle = null;
        this.mTimestamp = null;
        this.mRotationDegrees = null;
        this.mSensorToBufferTransformMatrix = null;
    }

    private ImageProxy modifyImage(ImageProxy imageProxy) {
        ImageInfo imageInfo = imageProxy.getImageInfo();
        return new SettableImageProxy(imageProxy, ImmutableImageInfo.create(this.mTagBundle != null ? this.mTagBundle : imageInfo.getTagBundle(), this.mTimestamp != null ? this.mTimestamp.longValue() : imageInfo.getTimestamp(), this.mRotationDegrees != null ? this.mRotationDegrees.intValue() : imageInfo.getRotationDegrees(), this.mSensorToBufferTransformMatrix != null ? this.mSensorToBufferTransformMatrix : imageInfo.getSensorToBufferTransformMatrix()));
    }

    @Override // androidx.camera.core.AndroidImageReaderProxy, androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        return modifyImage(super.acquireNextImage());
    }

    @Override // androidx.camera.core.AndroidImageReaderProxy, androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        return modifyImage(super.acquireNextImage());
    }

    public void setImageRotationDegrees(int i2) {
        this.mRotationDegrees = Integer.valueOf(i2);
    }

    public void setImageSensorToBufferTransformaMatrix(@NonNull Matrix matrix) {
        this.mSensorToBufferTransformMatrix = matrix;
    }

    public void setImageTagBundle(@NonNull TagBundle tagBundle) {
        this.mTagBundle = tagBundle;
    }

    public void setImageTimeStamp(long j2) {
        this.mTimestamp = Long.valueOf(j2);
    }
}
