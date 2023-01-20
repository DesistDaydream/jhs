package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public class MetadataImageReader implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    private static final String TAG = "MetadataImageReader";
    @GuardedBy("mLock")
    private final List<ImageProxy> mAcquiredImageProxies;
    private CameraCaptureCallback mCameraCaptureCallback;
    @GuardedBy("mLock")
    private boolean mClosed;
    @Nullable
    @GuardedBy("mLock")
    private Executor mExecutor;
    @GuardedBy("mLock")
    private int mImageProxiesIndex;
    @GuardedBy("mLock")
    private final ImageReaderProxy mImageReaderProxy;
    @Nullable
    @GuardedBy("mLock")
    public ImageReaderProxy.OnImageAvailableListener mListener;
    private final Object mLock;
    @GuardedBy("mLock")
    private final List<ImageProxy> mMatchedImageProxies;
    @GuardedBy("mLock")
    private final LongSparseArray<ImageInfo> mPendingImageInfos;
    @GuardedBy("mLock")
    private final LongSparseArray<ImageProxy> mPendingImages;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener;

    public MetadataImageReader(int i2, int i3, int i4, int i5) {
        this(createImageReaderProxy(i2, i3, i4, i5));
    }

    /* renamed from: a */
    public /* synthetic */ void b(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.onImageAvailable(this);
    }

    private static ImageReaderProxy createImageReaderProxy(int i2, int i3, int i4, int i5) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(i2, i3, i4, i5));
    }

    private void dequeImageProxy(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            int indexOf = this.mMatchedImageProxies.indexOf(imageProxy);
            if (indexOf >= 0) {
                this.mMatchedImageProxies.remove(indexOf);
                int i2 = this.mImageProxiesIndex;
                if (indexOf <= i2) {
                    this.mImageProxiesIndex = i2 - 1;
                }
            }
            this.mAcquiredImageProxies.remove(imageProxy);
        }
    }

    private void enqueueImageProxy(SettableImageProxy settableImageProxy) {
        final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
        Executor executor;
        synchronized (this.mLock) {
            onImageAvailableListener = null;
            if (this.mMatchedImageProxies.size() < getMaxImages()) {
                settableImageProxy.addOnImageCloseListener(this);
                this.mMatchedImageProxies.add(settableImageProxy);
                onImageAvailableListener = this.mListener;
                executor = this.mExecutor;
            } else {
                Logger.d("TAG", "Maximum image number reached.");
                settableImageProxy.close();
                executor = null;
            }
        }
        if (onImageAvailableListener != null) {
            if (executor != null) {
                executor.execute(new Runnable() { // from class: c.b.b.q0
                    {
                        MetadataImageReader.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MetadataImageReader.this.b(onImageAvailableListener);
                    }
                });
            } else {
                onImageAvailableListener.onImageAvailable(this);
            }
        }
    }

    private void matchImages() {
        synchronized (this.mLock) {
            for (int size = this.mPendingImageInfos.size() - 1; size >= 0; size--) {
                ImageInfo valueAt = this.mPendingImageInfos.valueAt(size);
                long timestamp = valueAt.getTimestamp();
                ImageProxy imageProxy = this.mPendingImages.get(timestamp);
                if (imageProxy != null) {
                    this.mPendingImages.remove(timestamp);
                    this.mPendingImageInfos.removeAt(size);
                    enqueueImageProxy(new SettableImageProxy(imageProxy, valueAt));
                }
            }
            removeStaleData();
        }
    }

    private void removeStaleData() {
        synchronized (this.mLock) {
            if (this.mPendingImages.size() != 0 && this.mPendingImageInfos.size() != 0) {
                Long valueOf = Long.valueOf(this.mPendingImages.keyAt(0));
                Long valueOf2 = Long.valueOf(this.mPendingImageInfos.keyAt(0));
                Preconditions.checkArgument(valueOf2.equals(valueOf) ? false : true);
                if (valueOf2.longValue() > valueOf.longValue()) {
                    for (int size = this.mPendingImages.size() - 1; size >= 0; size--) {
                        if (this.mPendingImages.keyAt(size) < valueOf2.longValue()) {
                            this.mPendingImages.valueAt(size).close();
                            this.mPendingImages.removeAt(size);
                        }
                    }
                } else {
                    for (int size2 = this.mPendingImageInfos.size() - 1; size2 >= 0; size2--) {
                        if (this.mPendingImageInfos.keyAt(size2) < valueOf.longValue()) {
                            this.mPendingImageInfos.removeAt(size2);
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        synchronized (this.mLock) {
            if (this.mMatchedImageProxies.isEmpty()) {
                return null;
            }
            if (this.mImageProxiesIndex < this.mMatchedImageProxies.size()) {
                ArrayList<ImageProxy> arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.mMatchedImageProxies.size() - 1; i2++) {
                    if (!this.mAcquiredImageProxies.contains(this.mMatchedImageProxies.get(i2))) {
                        arrayList.add(this.mMatchedImageProxies.get(i2));
                    }
                }
                for (ImageProxy imageProxy : arrayList) {
                    imageProxy.close();
                }
                int size = this.mMatchedImageProxies.size() - 1;
                this.mImageProxiesIndex = size;
                List<ImageProxy> list = this.mMatchedImageProxies;
                this.mImageProxiesIndex = size + 1;
                ImageProxy imageProxy2 = list.get(size);
                this.mAcquiredImageProxies.add(imageProxy2);
                return imageProxy2;
            }
            throw new IllegalStateException("Maximum image number reached.");
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        synchronized (this.mLock) {
            if (this.mMatchedImageProxies.isEmpty()) {
                return null;
            }
            if (this.mImageProxiesIndex < this.mMatchedImageProxies.size()) {
                List<ImageProxy> list = this.mMatchedImageProxies;
                int i2 = this.mImageProxiesIndex;
                this.mImageProxiesIndex = i2 + 1;
                ImageProxy imageProxy = list.get(i2);
                this.mAcquiredImageProxies.add(imageProxy);
                return imageProxy;
            }
            throw new IllegalStateException("Maximum image number reached.");
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mListener = null;
            this.mExecutor = null;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            for (ImageProxy imageProxy : new ArrayList(this.mMatchedImageProxies)) {
                imageProxy.close();
            }
            this.mMatchedImageProxies.clear();
            this.mImageReaderProxy.close();
            this.mClosed = true;
        }
    }

    public CameraCaptureCallback getCameraCaptureCallback() {
        return this.mCameraCaptureCallback;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mImageReaderProxy.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mImageReaderProxy.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReaderProxy.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mImageReaderProxy.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mImageReaderProxy.getWidth();
        }
        return width;
    }

    /* renamed from: imageIncoming */
    public void d(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            int i2 = 0;
            do {
                ImageProxy imageProxy = null;
                try {
                    imageProxy = imageReaderProxy.acquireNextImage();
                    if (imageProxy != null) {
                        i2++;
                        this.mPendingImages.put(imageProxy.getImageInfo().getTimestamp(), imageProxy);
                        matchImages();
                    }
                } catch (IllegalStateException e2) {
                    Logger.d(TAG, "Failed to acquire next image.", e2);
                }
                if (imageProxy == null) {
                    break;
                }
            } while (i2 < imageReaderProxy.getMaxImages());
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            dequeImageProxy(imageProxy);
        }
    }

    public void resultIncoming(CameraCaptureResult cameraCaptureResult) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mPendingImageInfos.put(cameraCaptureResult.getTimestamp(), new CameraCaptureResultImageInfo(cameraCaptureResult));
            matchImages();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener) Preconditions.checkNotNull(onImageAvailableListener);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
            this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, executor);
        }
    }

    public MetadataImageReader(@NonNull ImageReaderProxy imageReaderProxy) {
        this.mLock = new Object();
        this.mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.MetadataImageReader.1
            {
                MetadataImageReader.this = this;
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                super.onCaptureCompleted(cameraCaptureResult);
                MetadataImageReader.this.resultIncoming(cameraCaptureResult);
            }
        };
        this.mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: c.b.b.p0
            {
                MetadataImageReader.this = this;
            }

            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy2) {
                MetadataImageReader.this.d(imageReaderProxy2);
            }
        };
        this.mClosed = false;
        this.mPendingImageInfos = new LongSparseArray<>();
        this.mPendingImages = new LongSparseArray<>();
        this.mAcquiredImageProxies = new ArrayList();
        this.mImageReaderProxy = imageReaderProxy;
        this.mImageProxiesIndex = 0;
        this.mMatchedImageProxies = new ArrayList(getMaxImages());
    }
}
