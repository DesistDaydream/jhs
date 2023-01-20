package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public class AndroidImageReaderProxy implements ImageReaderProxy {
    @GuardedBy("mLock")
    private final ImageReader mImageReader;
    private final Object mLock = new Object();

    public AndroidImageReaderProxy(ImageReader imageReader) {
        this.mImageReader = imageReader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.onImageAvailable(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(Executor executor, final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReader imageReader) {
        executor.execute(new Runnable() { // from class: c.b.b.c
            @Override // java.lang.Runnable
            public final void run() {
                AndroidImageReaderProxy.this.b(onImageAvailableListener);
            }
        });
    }

    private boolean isImageReaderContextNotInitializedException(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        Image image;
        synchronized (this.mLock) {
            try {
                image = this.mImageReader.acquireLatestImage();
            } catch (RuntimeException e2) {
                if (!isImageReaderContextNotInitializedException(e2)) {
                    throw e2;
                }
                image = null;
            }
            if (image == null) {
                return null;
            }
            return new AndroidImageProxy(image);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        Image image;
        synchronized (this.mLock) {
            try {
                image = this.mImageReader.acquireNextImage();
            } catch (RuntimeException e2) {
                if (!isImageReaderContextNotInitializedException(e2)) {
                    throw e2;
                }
                image = null;
            }
            if (image == null) {
                return null;
            }
            return new AndroidImageProxy(image);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mImageReader.setOnImageAvailableListener(null, null);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            this.mImageReader.close();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mImageReader.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mImageReader.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReader.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mImageReader.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mImageReader.getWidth();
        }
        return width;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull final Executor executor) {
        synchronized (this.mLock) {
            this.mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: c.b.b.b
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    AndroidImageReaderProxy.this.d(executor, onImageAvailableListener, imageReader);
                }
            }, MainThreadAsyncHandler.getInstance());
        }
    }
}
