package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CaptureProcessorPipeline;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import c.b.b.n;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CaptureProcessorPipeline implements CaptureProcessor {
    private static final String TAG = "CaptureProcessorPipeline";
    @GuardedBy("mLock")
    public CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    @GuardedBy("mLock")
    private a<Void> mCloseFuture;
    @NonNull
    public final Executor mExecutor;
    private final int mMaxImages;
    @NonNull
    private final CaptureProcessor mPostCaptureProcessor;
    @NonNull
    private final CaptureProcessor mPreCaptureProcessor;
    @NonNull
    private final a<List<Void>> mUnderlyingCaptureProcessorsCloseFuture;
    private ImageReaderProxy mIntermediateImageReader = null;
    private ImageInfo mSourceImageInfo = null;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private boolean mClosed = false;
    @GuardedBy("mLock")
    private boolean mProcessing = false;

    public CaptureProcessorPipeline(@NonNull CaptureProcessor captureProcessor, int i2, @NonNull CaptureProcessor captureProcessor2, @NonNull Executor executor) {
        this.mPreCaptureProcessor = captureProcessor;
        this.mPostCaptureProcessor = captureProcessor2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(captureProcessor.getCloseFuture());
        arrayList.add(captureProcessor2.getCloseFuture());
        this.mUnderlyingCaptureProcessorsCloseFuture = Futures.allAsList(arrayList);
        this.mExecutor = executor;
        this.mMaxImages = i2;
    }

    public static /* synthetic */ void a(CallbackToFutureAdapter.Completer completer) {
        completer.set(null);
    }

    public static /* synthetic */ Void b(List list) {
        return null;
    }

    /* renamed from: c */
    public /* synthetic */ Object d(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = completer;
        }
        return "CaptureProcessorPipeline-close";
    }

    private void closeAndCompleteFutureIfNecessary() {
        boolean z;
        boolean z2;
        final CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            z = this.mClosed;
            z2 = this.mProcessing;
            completer = this.mCloseCompleter;
            if (z && !z2) {
                this.mIntermediateImageReader.close();
            }
        }
        if (!z || z2 || completer == null) {
            return;
        }
        this.mUnderlyingCaptureProcessorsCloseFuture.addListener(new Runnable() { // from class: c.b.b.m
            @Override // java.lang.Runnable
            public final void run() {
                CaptureProcessorPipeline.a(CallbackToFutureAdapter.Completer.this);
            }
        }, CameraXExecutors.directExecutor());
    }

    /* renamed from: g */
    public /* synthetic */ void h(ImageReaderProxy imageReaderProxy) {
        final ImageProxy acquireNextImage = imageReaderProxy.acquireNextImage();
        try {
            this.mExecutor.execute(new Runnable() { // from class: c.b.b.l
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureProcessorPipeline.this.f(acquireNextImage);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "The executor for post-processing might have been shutting down or terminated!");
            acquireNextImage.close();
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mClosed = true;
            this.mPreCaptureProcessor.close();
            this.mPostCaptureProcessor.close();
            closeAndCompleteFutureIfNecessary();
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    @NonNull
    public a<Void> getCloseFuture() {
        a<Void> nonCancellationPropagating;
        synchronized (this.mLock) {
            if (this.mClosed && !this.mProcessing) {
                nonCancellationPropagating = Futures.transform(this.mUnderlyingCaptureProcessorsCloseFuture, n.a, CameraXExecutors.directExecutor());
            } else {
                if (this.mCloseFuture == null) {
                    this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.k
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return CaptureProcessorPipeline.this.d(completer);
                        }
                    });
                }
                nonCancellationPropagating = Futures.nonCancellationPropagating(this.mCloseFuture);
            }
        }
        return nonCancellationPropagating;
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onOutputSurface(@NonNull Surface surface, int i2) {
        this.mPostCaptureProcessor.onOutputSurface(surface, i2);
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onResolutionUpdate(@NonNull Size size) {
        AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(size.getWidth(), size.getHeight(), 35, this.mMaxImages));
        this.mIntermediateImageReader = androidImageReaderProxy;
        this.mPreCaptureProcessor.onOutputSurface(androidImageReaderProxy.getSurface(), 35);
        this.mPreCaptureProcessor.onResolutionUpdate(size);
        this.mPostCaptureProcessor.onResolutionUpdate(size);
        this.mIntermediateImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: c.b.b.j
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                CaptureProcessorPipeline.this.h(imageReaderProxy);
            }
        }, CameraXExecutors.directExecutor());
    }

    /* renamed from: postProcess */
    public void f(ImageProxy imageProxy) {
        boolean z;
        synchronized (this.mLock) {
            z = this.mClosed;
        }
        if (!z) {
            Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
            Preconditions.checkNotNull(this.mSourceImageInfo);
            String next = this.mSourceImageInfo.getTagBundle().listKeys().iterator().next();
            int intValue = ((Integer) this.mSourceImageInfo.getTagBundle().getTag(next)).intValue();
            SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy, size, this.mSourceImageInfo);
            this.mSourceImageInfo = null;
            SettableImageProxyBundle settableImageProxyBundle = new SettableImageProxyBundle(Collections.singletonList(Integer.valueOf(intValue)), next);
            settableImageProxyBundle.addImageProxy(settableImageProxy);
            try {
                this.mPostCaptureProcessor.process(settableImageProxyBundle);
            } catch (Exception e2) {
                Logger.e(TAG, "Post processing image failed! " + e2.getMessage());
            }
        }
        synchronized (this.mLock) {
            this.mProcessing = false;
        }
        closeAndCompleteFutureIfNecessary();
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void process(@NonNull ImageProxyBundle imageProxyBundle) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mProcessing = true;
            a<ImageProxy> imageProxy = imageProxyBundle.getImageProxy(imageProxyBundle.getCaptureIds().get(0).intValue());
            Preconditions.checkArgument(imageProxy.isDone());
            try {
                this.mSourceImageInfo = imageProxy.get().getImageInfo();
                this.mPreCaptureProcessor.process(imageProxyBundle);
            } catch (InterruptedException | ExecutionException unused) {
                throw new IllegalArgumentException("Can not successfully extract ImageProxy from the ImageProxyBundle.");
            }
        }
    }
}
