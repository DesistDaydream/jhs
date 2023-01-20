package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ImageAnalysisNonBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    public final Executor mBackgroundExecutor;
    @Nullable
    @GuardedBy("mLock")
    @VisibleForTesting
    public ImageProxy mCachedImage;
    private final Object mLock = new Object();
    @Nullable
    @GuardedBy("mLock")
    private CacheAnalyzingImageProxy mPostedImage;

    /* loaded from: classes.dex */
    public static class CacheAnalyzingImageProxy extends ForwardingImageProxy {
        public final WeakReference<ImageAnalysisNonBlockingAnalyzer> mNonBlockingAnalyzerWeakReference;

        public CacheAnalyzingImageProxy(@NonNull ImageProxy imageProxy, @NonNull ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
            super(imageProxy);
            this.mNonBlockingAnalyzerWeakReference = new WeakReference<>(imageAnalysisNonBlockingAnalyzer);
            addOnImageCloseListener(new ForwardingImageProxy.OnImageCloseListener() { // from class: c.b.b.t
                {
                    ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy.this = this;
                }

                @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
                public final void onImageClose(ImageProxy imageProxy2) {
                    ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy.this.c(imageProxy2);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void c(ImageProxy imageProxy) {
            final ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer = this.mNonBlockingAnalyzerWeakReference.get();
            if (imageAnalysisNonBlockingAnalyzer != null) {
                imageAnalysisNonBlockingAnalyzer.mBackgroundExecutor.execute(new Runnable() { // from class: c.b.b.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageAnalysisNonBlockingAnalyzer.analyzeCachedImage();
                    }
                });
            }
        }
    }

    public ImageAnalysisNonBlockingAnalyzer(Executor executor) {
        this.mBackgroundExecutor = executor;
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    @Nullable
    public ImageProxy acquireImage(@NonNull ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireLatestImage();
    }

    public void analyzeCachedImage() {
        synchronized (this.mLock) {
            this.mPostedImage = null;
            ImageProxy imageProxy = this.mCachedImage;
            if (imageProxy != null) {
                this.mCachedImage = null;
                onValidImageAvailable(imageProxy);
            }
        }
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public void clearCache() {
        synchronized (this.mLock) {
            ImageProxy imageProxy = this.mCachedImage;
            if (imageProxy != null) {
                imageProxy.close();
                this.mCachedImage = null;
            }
        }
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public void onValidImageAvailable(@NonNull ImageProxy imageProxy) {
        synchronized (this.mLock) {
            if (!this.mIsAttached) {
                imageProxy.close();
            } else if (this.mPostedImage != null) {
                if (imageProxy.getImageInfo().getTimestamp() <= this.mPostedImage.getImageInfo().getTimestamp()) {
                    imageProxy.close();
                } else {
                    ImageProxy imageProxy2 = this.mCachedImage;
                    if (imageProxy2 != null) {
                        imageProxy2.close();
                    }
                    this.mCachedImage = imageProxy;
                }
            } else {
                final CacheAnalyzingImageProxy cacheAnalyzingImageProxy = new CacheAnalyzingImageProxy(imageProxy, this);
                this.mPostedImage = cacheAnalyzingImageProxy;
                Futures.addCallback(analyzeImage(cacheAnalyzingImageProxy), new FutureCallback<Void>() { // from class: androidx.camera.core.ImageAnalysisNonBlockingAnalyzer.1
                    {
                        ImageAnalysisNonBlockingAnalyzer.this = this;
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(Throwable th) {
                        cacheAnalyzingImageProxy.close();
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(Void r1) {
                    }
                }, CameraXExecutors.directExecutor());
            }
        }
    }
}
