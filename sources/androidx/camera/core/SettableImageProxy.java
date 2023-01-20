package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class SettableImageProxy extends ForwardingImageProxy {
    @Nullable
    private Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final int mWidth;

    public SettableImageProxy(ImageProxy imageProxy, ImageInfo imageInfo) {
        this(imageProxy, null, imageInfo);
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    @NonNull
    public synchronized Rect getCropRect() {
        if (this.mCropRect == null) {
            return new Rect(0, 0, getWidth(), getHeight());
        }
        return new Rect(this.mCropRect);
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public synchronized int getHeight() {
        return this.mHeight;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    @NonNull
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public synchronized int getWidth() {
        return this.mWidth;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public synchronized void setCropRect(@Nullable Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            if (!rect2.intersect(0, 0, getWidth(), getHeight())) {
                rect2.setEmpty();
            }
            rect = rect2;
        }
        this.mCropRect = rect;
    }

    public SettableImageProxy(ImageProxy imageProxy, @Nullable Size size, ImageInfo imageInfo) {
        super(imageProxy);
        if (size == null) {
            this.mWidth = super.getWidth();
            this.mHeight = super.getHeight();
        } else {
            this.mWidth = size.getWidth();
            this.mHeight = size.getHeight();
        }
        this.mImageInfo = imageInfo;
    }
}
