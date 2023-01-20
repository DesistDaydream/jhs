package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.TagBundle;
import java.nio.ByteBuffer;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class AndroidImageProxy implements ImageProxy {
    @GuardedBy("this")
    private final Image mImage;
    private final ImageInfo mImageInfo;
    @GuardedBy("this")
    private final PlaneProxy[] mPlanes;

    /* loaded from: classes.dex */
    public static final class PlaneProxy implements ImageProxy.PlaneProxy {
        @GuardedBy("this")
        private final Image.Plane mPlane;

        public PlaneProxy(Image.Plane plane) {
            this.mPlane = plane;
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        @NonNull
        public synchronized ByteBuffer getBuffer() {
            return this.mPlane.getBuffer();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public synchronized int getPixelStride() {
            return this.mPlane.getPixelStride();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public synchronized int getRowStride() {
            return this.mPlane.getRowStride();
        }
    }

    public AndroidImageProxy(Image image) {
        this.mImage = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.mPlanes = new PlaneProxy[planes.length];
            for (int i2 = 0; i2 < planes.length; i2++) {
                this.mPlanes[i2] = new PlaneProxy(planes[i2]);
            }
        } else {
            this.mPlanes = new PlaneProxy[0];
        }
        this.mImageInfo = ImmutableImageInfo.create(TagBundle.emptyBundle(), image.getTimestamp(), 0, new Matrix());
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public synchronized void close() {
        this.mImage.close();
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public synchronized Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    @Override // androidx.camera.core.ImageProxy
    public synchronized int getFormat() {
        return this.mImage.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public synchronized int getHeight() {
        return this.mImage.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    @ExperimentalGetImage
    public synchronized Image getImage() {
        return this.mImage;
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public synchronized ImageProxy.PlaneProxy[] getPlanes() {
        return this.mPlanes;
    }

    @Override // androidx.camera.core.ImageProxy
    public synchronized int getWidth() {
        return this.mImage.getWidth();
    }

    @Override // androidx.camera.core.ImageProxy
    public synchronized void setCropRect(@Nullable Rect rect) {
        this.mImage.setCropRect(rect);
    }
}
