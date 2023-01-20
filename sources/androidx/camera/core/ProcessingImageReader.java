package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import c.b.b.y0;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ProcessingImageReader implements ImageReaderProxy {
    private static final int EXIF_MAX_SIZE_BYTES = 64000;
    private static final String TAG = "ProcessingImageReader";
    @NonNull
    public final CaptureProcessor mCaptureProcessor;
    @GuardedBy("mLock")
    public CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    @GuardedBy("mLock")
    private a<Void> mCloseFuture;
    @GuardedBy("mLock")
    public Executor mErrorCallbackExecutor;
    @Nullable
    @GuardedBy("mLock")
    public Executor mExecutor;
    @GuardedBy("mLock")
    public final ImageReaderProxy mInputImageReader;
    @Nullable
    @GuardedBy("mLock")
    public ImageReaderProxy.OnImageAvailableListener mListener;
    @GuardedBy("mLock")
    public OnProcessingErrorCallback mOnProcessingErrorCallback;
    @GuardedBy("mLock")
    public final ImageReaderProxy mOutputImageReader;
    @NonNull
    public final Executor mPostProcessExecutor;
    @NonNull
    private final a<Void> mUnderlyingCaptureProcessorCloseFuture;
    public final Object mLock = new Object();
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.ProcessingImageReader.1
        {
            ProcessingImageReader.this = this;
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
            ProcessingImageReader.this.imageIncoming(imageReaderProxy);
        }
    };
    private ImageReaderProxy.OnImageAvailableListener mImageProcessedListener = new AnonymousClass2();
    private FutureCallback<List<ImageProxy>> mCaptureStageReadyCallback = new AnonymousClass3();
    @GuardedBy("mLock")
    public boolean mClosed = false;
    @GuardedBy("mLock")
    public boolean mProcessing = false;
    private String mTagBundleKey = new String();
    @NonNull
    @GuardedBy("mLock")
    public SettableImageProxyBundle mSettableImageProxyBundle = new SettableImageProxyBundle(Collections.emptyList(), this.mTagBundleKey);
    private final List<Integer> mCaptureIdList = new ArrayList();
    private a<List<ImageProxy>> mSettableImageProxyFutureList = Futures.immediateFuture(new ArrayList());

    /* renamed from: androidx.camera.core.ProcessingImageReader$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements ImageReaderProxy.OnImageAvailableListener {
        public AnonymousClass2() {
            ProcessingImageReader.this = r1;
        }

        /* renamed from: a */
        public /* synthetic */ void b(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
            onImageAvailableListener.onImageAvailable(ProcessingImageReader.this);
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
            final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
            Executor executor;
            synchronized (ProcessingImageReader.this.mLock) {
                ProcessingImageReader processingImageReader = ProcessingImageReader.this;
                onImageAvailableListener = processingImageReader.mListener;
                executor = processingImageReader.mExecutor;
                processingImageReader.mSettableImageProxyBundle.reset();
                ProcessingImageReader.this.setupSettableImageProxyBundleCallbacks();
            }
            if (onImageAvailableListener != null) {
                if (executor != null) {
                    executor.execute(new Runnable() { // from class: c.b.b.u0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ProcessingImageReader.AnonymousClass2.this.b(onImageAvailableListener);
                        }
                    });
                } else {
                    onImageAvailableListener.onImageAvailable(ProcessingImageReader.this);
                }
            }
        }
    }

    /* renamed from: androidx.camera.core.ProcessingImageReader$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements FutureCallback<List<ImageProxy>> {
        public AnonymousClass3() {
            ProcessingImageReader.this = r1;
        }

        public static /* synthetic */ void a(OnProcessingErrorCallback onProcessingErrorCallback, Exception exc) {
            onProcessingErrorCallback.notifyProcessingError(exc.getMessage(), exc.getCause());
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onFailure(Throwable th) {
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onSuccess(@Nullable List<ImageProxy> list) {
            ProcessingImageReader processingImageReader;
            synchronized (ProcessingImageReader.this.mLock) {
                ProcessingImageReader processingImageReader2 = ProcessingImageReader.this;
                if (processingImageReader2.mClosed) {
                    return;
                }
                processingImageReader2.mProcessing = true;
                SettableImageProxyBundle settableImageProxyBundle = processingImageReader2.mSettableImageProxyBundle;
                final OnProcessingErrorCallback onProcessingErrorCallback = processingImageReader2.mOnProcessingErrorCallback;
                Executor executor = processingImageReader2.mErrorCallbackExecutor;
                try {
                    processingImageReader2.mCaptureProcessor.process(settableImageProxyBundle);
                } catch (Exception e2) {
                    synchronized (ProcessingImageReader.this.mLock) {
                        ProcessingImageReader.this.mSettableImageProxyBundle.reset();
                        if (onProcessingErrorCallback != null && executor != null) {
                            executor.execute(new Runnable() { // from class: c.b.b.v0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ProcessingImageReader.AnonymousClass3.a(ProcessingImageReader.OnProcessingErrorCallback.this, e2);
                                }
                            });
                        }
                    }
                }
                synchronized (ProcessingImageReader.this.mLock) {
                    processingImageReader = ProcessingImageReader.this;
                    processingImageReader.mProcessing = false;
                }
                processingImageReader.closeAndCompleteFutureIfNecessary();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnProcessingErrorCallback {
        void notifyProcessingError(@Nullable String str, @Nullable Throwable th);
    }

    public ProcessingImageReader(@NonNull Builder builder) {
        if (builder.mInputImageReader.getMaxImages() >= builder.mCaptureBundle.getCaptureStages().size()) {
            ImageReaderProxy imageReaderProxy = builder.mInputImageReader;
            this.mInputImageReader = imageReaderProxy;
            int width = imageReaderProxy.getWidth();
            int height = imageReaderProxy.getHeight();
            int i2 = builder.mOutputFormat;
            if (i2 == 256) {
                width = ((int) (width * height * 1.5f)) + EXIF_MAX_SIZE_BYTES;
                height = 1;
            }
            AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(width, height, i2, imageReaderProxy.getMaxImages()));
            this.mOutputImageReader = androidImageReaderProxy;
            this.mPostProcessExecutor = builder.mPostProcessExecutor;
            CaptureProcessor captureProcessor = builder.mCaptureProcessor;
            this.mCaptureProcessor = captureProcessor;
            captureProcessor.onOutputSurface(androidImageReaderProxy.getSurface(), builder.mOutputFormat);
            captureProcessor.onResolutionUpdate(new Size(imageReaderProxy.getWidth(), imageReaderProxy.getHeight()));
            this.mUnderlyingCaptureProcessorCloseFuture = captureProcessor.getCloseFuture();
            setCaptureBundle(builder.mCaptureBundle);
            return;
        }
        throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
    }

    /* renamed from: a */
    public /* synthetic */ void b(CallbackToFutureAdapter.Completer completer) {
        cancelSettableImageProxyBundleFutureList();
        if (completer != null) {
            completer.set(null);
        }
    }

    public static /* synthetic */ Void c(Void r0) {
        return null;
    }

    private void cancelSettableImageProxyBundleFutureList() {
        synchronized (this.mLock) {
            if (!this.mSettableImageProxyFutureList.isDone()) {
                this.mSettableImageProxyFutureList.cancel(true);
            }
            this.mSettableImageProxyBundle.reset();
        }
    }

    /* renamed from: d */
    public /* synthetic */ Object e(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = completer;
        }
        return "ProcessingImageReader-close";
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        ImageProxy acquireLatestImage;
        synchronized (this.mLock) {
            acquireLatestImage = this.mOutputImageReader.acquireLatestImage();
        }
        return acquireLatestImage;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        ImageProxy acquireNextImage;
        synchronized (this.mLock) {
            acquireNextImage = this.mOutputImageReader.acquireNextImage();
        }
        return acquireNextImage;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mListener = null;
            this.mExecutor = null;
            this.mInputImageReader.clearOnImageAvailableListener();
            this.mOutputImageReader.clearOnImageAvailableListener();
            if (!this.mProcessing) {
                this.mSettableImageProxyBundle.close();
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mInputImageReader.clearOnImageAvailableListener();
            this.mOutputImageReader.clearOnImageAvailableListener();
            this.mClosed = true;
            this.mCaptureProcessor.close();
            closeAndCompleteFutureIfNecessary();
        }
    }

    public void closeAndCompleteFutureIfNecessary() {
        boolean z;
        boolean z2;
        final CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            z = this.mClosed;
            z2 = this.mProcessing;
            completer = this.mCloseCompleter;
            if (z && !z2) {
                this.mInputImageReader.close();
                this.mSettableImageProxyBundle.close();
                this.mOutputImageReader.close();
            }
        }
        if (!z || z2) {
            return;
        }
        this.mUnderlyingCaptureProcessorCloseFuture.addListener(new Runnable() { // from class: c.b.b.x0
            @Override // java.lang.Runnable
            public final void run() {
                ProcessingImageReader.this.b(completer);
            }
        }, CameraXExecutors.directExecutor());
    }

    @Nullable
    public CameraCaptureCallback getCameraCaptureCallback() {
        synchronized (this.mLock) {
            ImageReaderProxy imageReaderProxy = this.mInputImageReader;
            if (imageReaderProxy instanceof MetadataImageReader) {
                return ((MetadataImageReader) imageReaderProxy).getCameraCaptureCallback();
            }
            return new CameraCaptureCallback() { // from class: androidx.camera.core.ProcessingImageReader.4
                {
                    ProcessingImageReader.this = this;
                }
            };
        }
    }

    @NonNull
    public a<Void> getCloseFuture() {
        a<Void> nonCancellationPropagating;
        synchronized (this.mLock) {
            if (this.mClosed && !this.mProcessing) {
                nonCancellationPropagating = Futures.transform(this.mUnderlyingCaptureProcessorCloseFuture, y0.a, CameraXExecutors.directExecutor());
            } else {
                if (this.mCloseFuture == null) {
                    this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.w0
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return ProcessingImageReader.this.e(completer);
                        }
                    });
                }
                nonCancellationPropagating = Futures.nonCancellationPropagating(this.mCloseFuture);
            }
        }
        return nonCancellationPropagating;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mInputImageReader.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mOutputImageReader.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mInputImageReader.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mInputImageReader.getSurface();
        }
        return surface;
    }

    @NonNull
    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mInputImageReader.getWidth();
        }
        return width;
    }

    public void imageIncoming(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            try {
                ImageProxy acquireNextImage = imageReaderProxy.acquireNextImage();
                if (acquireNextImage != null) {
                    Integer num = (Integer) acquireNextImage.getImageInfo().getTagBundle().getTag(this.mTagBundleKey);
                    if (!this.mCaptureIdList.contains(num)) {
                        Logger.w(TAG, "ImageProxyBundle does not contain this id: " + num);
                        acquireNextImage.close();
                    } else {
                        this.mSettableImageProxyBundle.addImageProxy(acquireNextImage);
                    }
                }
            } catch (IllegalStateException e2) {
                Logger.e(TAG, "Failed to acquire latest image.", e2);
            }
        }
    }

    public void setCaptureBundle(@NonNull CaptureBundle captureBundle) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            cancelSettableImageProxyBundleFutureList();
            if (captureBundle.getCaptureStages() != null) {
                if (this.mInputImageReader.getMaxImages() >= captureBundle.getCaptureStages().size()) {
                    this.mCaptureIdList.clear();
                    for (CaptureStage captureStage : captureBundle.getCaptureStages()) {
                        if (captureStage != null) {
                            this.mCaptureIdList.add(Integer.valueOf(captureStage.getId()));
                        }
                    }
                } else {
                    throw new IllegalArgumentException("CaptureBundle is larger than InputImageReader.");
                }
            }
            String num = Integer.toString(captureBundle.hashCode());
            this.mTagBundleKey = num;
            this.mSettableImageProxyBundle = new SettableImageProxyBundle(this.mCaptureIdList, num);
            setupSettableImageProxyBundleCallbacks();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener) Preconditions.checkNotNull(onImageAvailableListener);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
            this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, executor);
            this.mOutputImageReader.setOnImageAvailableListener(this.mImageProcessedListener, executor);
        }
    }

    public void setOnProcessingErrorCallback(@NonNull Executor executor, @NonNull OnProcessingErrorCallback onProcessingErrorCallback) {
        synchronized (this.mLock) {
            this.mErrorCallbackExecutor = executor;
            this.mOnProcessingErrorCallback = onProcessingErrorCallback;
        }
    }

    @GuardedBy("mLock")
    public void setupSettableImageProxyBundleCallbacks() {
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.mCaptureIdList) {
            arrayList.add(this.mSettableImageProxyBundle.getImageProxy(num.intValue()));
        }
        this.mSettableImageProxyFutureList = Futures.allAsList(arrayList);
        Futures.addCallback(Futures.allAsList(arrayList), this.mCaptureStageReadyCallback, this.mPostProcessExecutor);
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        @NonNull
        public final CaptureBundle mCaptureBundle;
        @NonNull
        public final CaptureProcessor mCaptureProcessor;
        @NonNull
        public final ImageReaderProxy mInputImageReader;
        public int mOutputFormat;
        @NonNull
        public Executor mPostProcessExecutor;

        public Builder(@NonNull ImageReaderProxy imageReaderProxy, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
            this.mPostProcessExecutor = Executors.newSingleThreadExecutor();
            this.mInputImageReader = imageReaderProxy;
            this.mCaptureBundle = captureBundle;
            this.mCaptureProcessor = captureProcessor;
            this.mOutputFormat = imageReaderProxy.getImageFormat();
        }

        public ProcessingImageReader build() {
            return new ProcessingImageReader(this);
        }

        @NonNull
        public Builder setOutputFormat(int i2) {
            this.mOutputFormat = i2;
            return this;
        }

        @NonNull
        public Builder setPostProcessExecutor(@NonNull Executor executor) {
            this.mPostProcessExecutor = executor;
            return this;
        }

        public Builder(int i2, int i3, int i4, int i5, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
            this(new MetadataImageReader(i2, i3, i4, i5), captureBundle, captureProcessor);
        }
    }
}
