package androidx.camera.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ProcessingSurface;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.SingleImageProxyBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import e.j.c.a.a.a;
import java.util.concurrent.ScheduledExecutorService;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ProcessingSurface extends DeferrableSurface {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ProcessingSurfaceTextur";
    private final CameraCaptureCallback mCameraCaptureCallback;
    @NonNull
    @GuardedBy("mLock")
    public final CaptureProcessor mCaptureProcessor;
    public final CaptureStage mCaptureStage;
    private final Handler mImageReaderHandler;
    @GuardedBy("mLock")
    public final MetadataImageReader mInputImageReader;
    @GuardedBy("mLock")
    public final Surface mInputSurface;
    public final Object mLock;
    private final DeferrableSurface mOutputDeferrableSurface;
    @GuardedBy("mLock")
    public boolean mReleased;
    @NonNull
    private final Size mResolution;
    private String mTagBundleKey;
    private final ImageReaderProxy.OnImageAvailableListener mTransformedListener;

    public ProcessingSurface(int i2, int i3, int i4, @Nullable Handler handler, @NonNull CaptureStage captureStage, @NonNull CaptureProcessor captureProcessor, @NonNull DeferrableSurface deferrableSurface, @NonNull String str) {
        super(new Size(i2, i3), i4);
        this.mLock = new Object();
        ImageReaderProxy.OnImageAvailableListener onImageAvailableListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: c.b.b.a1
            {
                ProcessingSurface.this = this;
            }

            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                ProcessingSurface.this.g(imageReaderProxy);
            }
        };
        this.mTransformedListener = onImageAvailableListener;
        this.mReleased = false;
        Size size = new Size(i2, i3);
        this.mResolution = size;
        if (handler != null) {
            this.mImageReaderHandler = handler;
        } else {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                this.mImageReaderHandler = new Handler(myLooper);
            } else {
                throw new IllegalStateException("Creating a ProcessingSurface requires a non-null Handler, or be created  on a thread with a Looper.");
            }
        }
        ScheduledExecutorService newHandlerExecutor = CameraXExecutors.newHandlerExecutor(this.mImageReaderHandler);
        MetadataImageReader metadataImageReader = new MetadataImageReader(i2, i3, i4, 2);
        this.mInputImageReader = metadataImageReader;
        metadataImageReader.setOnImageAvailableListener(onImageAvailableListener, newHandlerExecutor);
        this.mInputSurface = metadataImageReader.getSurface();
        this.mCameraCaptureCallback = metadataImageReader.getCameraCaptureCallback();
        this.mCaptureProcessor = captureProcessor;
        captureProcessor.onResolutionUpdate(size);
        this.mCaptureStage = captureStage;
        this.mOutputDeferrableSurface = deferrableSurface;
        this.mTagBundleKey = str;
        Futures.addCallback(deferrableSurface.getSurface(), new FutureCallback<Surface>() { // from class: androidx.camera.core.ProcessingSurface.1
            {
                ProcessingSurface.this = this;
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Logger.e(ProcessingSurface.TAG, "Failed to extract Listenable<Surface>.", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Surface surface) {
                synchronized (ProcessingSurface.this.mLock) {
                    ProcessingSurface.this.mCaptureProcessor.onOutputSurface(surface, 1);
                }
            }
        }, CameraXExecutors.directExecutor());
        getTerminationFuture().addListener(new Runnable() { // from class: c.b.b.z0
            {
                ProcessingSurface.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ProcessingSurface.this.release();
            }
        }, CameraXExecutors.directExecutor());
    }

    /* renamed from: f */
    public /* synthetic */ void g(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            imageIncoming(imageReaderProxy);
        }
    }

    public void release() {
        synchronized (this.mLock) {
            if (this.mReleased) {
                return;
            }
            this.mInputImageReader.close();
            this.mInputSurface.release();
            this.mOutputDeferrableSurface.close();
            this.mReleased = true;
        }
    }

    @Nullable
    public CameraCaptureCallback getCameraCaptureCallback() {
        CameraCaptureCallback cameraCaptureCallback;
        synchronized (this.mLock) {
            if (!this.mReleased) {
                cameraCaptureCallback = this.mCameraCaptureCallback;
            } else {
                throw new IllegalStateException("ProcessingSurface already released!");
            }
        }
        return cameraCaptureCallback;
    }

    @GuardedBy("mLock")
    public void imageIncoming(ImageReaderProxy imageReaderProxy) {
        if (this.mReleased) {
            return;
        }
        ImageProxy imageProxy = null;
        try {
            imageProxy = imageReaderProxy.acquireNextImage();
        } catch (IllegalStateException e2) {
            Logger.e(TAG, "Failed to acquire next image.", e2);
        }
        if (imageProxy == null) {
            return;
        }
        ImageInfo imageInfo = imageProxy.getImageInfo();
        if (imageInfo == null) {
            imageProxy.close();
            return;
        }
        Integer num = (Integer) imageInfo.getTagBundle().getTag(this.mTagBundleKey);
        if (num == null) {
            imageProxy.close();
        } else if (this.mCaptureStage.getId() != num.intValue()) {
            Logger.w(TAG, "ImageProxyBundle does not contain this id: " + num);
            imageProxy.close();
        } else {
            SingleImageProxyBundle singleImageProxyBundle = new SingleImageProxyBundle(imageProxy, this.mTagBundleKey);
            this.mCaptureProcessor.process(singleImageProxyBundle);
            singleImageProxyBundle.close();
        }
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public a<Surface> provideSurface() {
        a<Surface> immediateFuture;
        synchronized (this.mLock) {
            immediateFuture = Futures.immediateFuture(this.mInputSurface);
        }
        return immediateFuture;
    }
}
