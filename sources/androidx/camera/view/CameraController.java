package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Size;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExperimentalAnalyzer;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraController;
import androidx.camera.view.RotationProvider;
import androidx.camera.view.transform.OutputTransform;
import androidx.camera.view.video.ExperimentalVideo;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.camera.view.video.OutputFileResults;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import e.j.c.a.a.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";
    @ExperimentalAnalyzer
    public static final int COORDINATE_SYSTEM_VIEW_REFERENCED = 1;
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached to CameraController.";
    private static final String TAG = "CameraController";
    public static final int TAP_TO_FOCUS_FAILED = 4;
    public static final int TAP_TO_FOCUS_FOCUSED = 2;
    public static final int TAP_TO_FOCUS_NOT_FOCUSED = 3;
    public static final int TAP_TO_FOCUS_NOT_STARTED = 0;
    public static final int TAP_TO_FOCUS_STARTED = 1;
    @ExperimentalVideo
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    @Nullable
    private ImageAnalysis.Analyzer mAnalysisAnalyzer;
    @Nullable
    private Executor mAnalysisBackgroundExecutor;
    @Nullable
    private Executor mAnalysisExecutor;
    private final Context mAppContext;
    @Nullable
    public Camera mCamera;
    @Nullable
    public ProcessCameraProvider mCameraProvider;
    @NonNull
    @VisibleForTesting
    public final RotationProvider.Listener mDeviceRotationListener;
    @NonNull
    public ImageAnalysis mImageAnalysis;
    @Nullable
    public OutputSize mImageAnalysisTargetSize;
    @NonNull
    public ImageCapture mImageCapture;
    @Nullable
    public Executor mImageCaptureIoExecutor;
    @Nullable
    public OutputSize mImageCaptureTargetSize;
    @NonNull
    private final a<Void> mInitializationFuture;
    @NonNull
    public Preview mPreview;
    @Nullable
    public Display mPreviewDisplay;
    @Nullable
    public OutputSize mPreviewTargetSize;
    private final RotationProvider mRotationProvider;
    @Nullable
    public Preview.SurfaceProvider mSurfaceProvider;
    @NonNull
    public VideoCapture mVideoCapture;
    @Nullable
    public OutputSize mVideoCaptureOutputSize;
    @Nullable
    public ViewPort mViewPort;
    public CameraSelector mCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
    private int mEnabledUseCases = 3;
    @NonNull
    public final AtomicBoolean mVideoIsRecording = new AtomicBoolean(false);
    private boolean mPinchToZoomEnabled = true;
    private boolean mTapToFocusEnabled = true;
    private final ForwardingLiveData<ZoomState> mZoomState = new ForwardingLiveData<>();
    private final ForwardingLiveData<Integer> mTorchState = new ForwardingLiveData<>();
    public final MutableLiveData<Integer> mTapToFocusState = new MutableLiveData<>(0);

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        @DoNotInline
        public static Context createAttributionContext(@NonNull Context context, @Nullable String str) {
            return context.createAttributionContext(str);
        }

        @Nullable
        @DoNotInline
        public static String getAttributionTag(@NonNull Context context) {
            return context.getAttributionTag();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface TapToFocusStates {
    }

    @OptIn(markerClass = {ExperimentalVideo.class})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface UseCases {
    }

    public CameraController(@NonNull Context context) {
        Context applicationContext = getApplicationContext(context);
        this.mAppContext = applicationContext;
        this.mPreview = new Preview.Builder().build();
        this.mImageCapture = new ImageCapture.Builder().build();
        this.mImageAnalysis = new ImageAnalysis.Builder().build();
        this.mVideoCapture = new VideoCapture.Builder().build();
        this.mInitializationFuture = Futures.transform(ProcessCameraProvider.getInstance(applicationContext), new Function() { // from class: c.b.d.c
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return CameraController.this.b((ProcessCameraProvider) obj);
            }
        }, CameraXExecutors.mainThreadExecutor());
        this.mRotationProvider = new RotationProvider(applicationContext);
        this.mDeviceRotationListener = new RotationProvider.Listener() { // from class: c.b.d.b
            {
                CameraController.this = this;
            }

            @Override // androidx.camera.view.RotationProvider.Listener
            public final void onRotationChanged(int i2) {
                CameraController.this.d(i2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Void b(ProcessCameraProvider processCameraProvider) {
        this.mCameraProvider = processCameraProvider;
        startCameraAndTrackStates();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(int i2) {
        this.mImageAnalysis.setTargetRotation(i2);
        this.mImageCapture.setTargetRotation(i2);
        this.mVideoCapture.setTargetRotation(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(CameraSelector cameraSelector) {
        this.mCameraSelector = cameraSelector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(int i2) {
        this.mEnabledUseCases = i2;
    }

    private static Context getApplicationContext(@NonNull Context context) {
        String attributionTag;
        Context applicationContext = context.getApplicationContext();
        return (Build.VERSION.SDK_INT < 30 || (attributionTag = Api30Impl.getAttributionTag(context)) == null) ? applicationContext : Api30Impl.createAttributionContext(applicationContext, attributionTag);
    }

    private boolean isCameraAttached() {
        return this.mCamera != null;
    }

    private boolean isCameraInitialized() {
        return this.mCameraProvider != null;
    }

    private boolean isOutputSizeEqual(@Nullable OutputSize outputSize, @Nullable OutputSize outputSize2) {
        if (outputSize == outputSize2) {
            return true;
        }
        return outputSize != null && outputSize.equals(outputSize2);
    }

    private boolean isPreviewViewAttached() {
        return (this.mSurfaceProvider == null || this.mViewPort == null || this.mPreviewDisplay == null) ? false : true;
    }

    private boolean isUseCaseEnabled(int i2) {
        return (i2 & this.mEnabledUseCases) != 0;
    }

    @OptIn(markerClass = {ExperimentalAnalyzer.class})
    private void restartCameraIfAnalyzerResolutionChanged(@Nullable ImageAnalysis.Analyzer analyzer, @Nullable ImageAnalysis.Analyzer analyzer2) {
        if (Objects.equals(analyzer == null ? null : analyzer.getTargetResolutionOverride(), analyzer2 != null ? analyzer2.getTargetResolutionOverride() : null)) {
            return;
        }
        unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), this.mImageAnalysis.getImageQueueDepth());
        startCameraAndTrackStates();
    }

    private void setTargetOutputSize(@NonNull ImageOutputConfig.Builder<?> builder, @Nullable OutputSize outputSize) {
        if (outputSize == null) {
            return;
        }
        if (outputSize.getResolution() != null) {
            builder.setTargetResolution(outputSize.getResolution());
        } else if (outputSize.getAspectRatio() != -1) {
            builder.setTargetAspectRatio(outputSize.getAspectRatio());
        } else {
            Logger.e(TAG, "Invalid target surface size. " + outputSize);
        }
    }

    private float speedUpZoomBy2X(float f2) {
        return f2 > 1.0f ? ((f2 - 1.0f) * 2.0f) + 1.0f : 1.0f - ((1.0f - f2) * 2.0f);
    }

    private void startListeningToRotationEvents() {
        this.mRotationProvider.addListener(CameraXExecutors.mainThreadExecutor(), this.mDeviceRotationListener);
    }

    private void stopListeningToRotationEvents() {
        this.mRotationProvider.removeListener(this.mDeviceRotationListener);
    }

    @MainThread
    private void unbindImageAnalysisAndRecreate(int i2, int i3) {
        ImageAnalysis.Analyzer analyzer;
        Threads.checkMainThread();
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mImageAnalysis);
        }
        ImageAnalysis.Builder imageQueueDepth = new ImageAnalysis.Builder().setBackpressureStrategy(i2).setImageQueueDepth(i3);
        setTargetOutputSize(imageQueueDepth, this.mImageAnalysisTargetSize);
        Executor executor = this.mAnalysisBackgroundExecutor;
        if (executor != null) {
            imageQueueDepth.setBackgroundExecutor(executor);
        }
        ImageAnalysis build = imageQueueDepth.build();
        this.mImageAnalysis = build;
        Executor executor2 = this.mAnalysisExecutor;
        if (executor2 == null || (analyzer = this.mAnalysisAnalyzer) == null) {
            return;
        }
        build.setAnalyzer(executor2, analyzer);
    }

    private void unbindImageCaptureAndRecreate(int i2) {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mImageCapture);
        }
        ImageCapture.Builder captureMode = new ImageCapture.Builder().setCaptureMode(i2);
        setTargetOutputSize(captureMode, this.mImageCaptureTargetSize);
        Executor executor = this.mImageCaptureIoExecutor;
        if (executor != null) {
            captureMode.setIoExecutor(executor);
        }
        this.mImageCapture = captureMode.build();
    }

    private void unbindPreviewAndRecreate() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mPreview);
        }
        Preview.Builder builder = new Preview.Builder();
        setTargetOutputSize(builder, this.mPreviewTargetSize);
        this.mPreview = builder.build();
    }

    private void unbindVideoAndRecreate() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mVideoCapture);
        }
        VideoCapture.Builder builder = new VideoCapture.Builder();
        setTargetOutputSize(builder, this.mVideoCaptureOutputSize);
        this.mVideoCapture = builder.build();
    }

    @SuppressLint({"MissingPermission", "WrongConstant"})
    @MainThread
    public void attachPreviewSurface(@NonNull Preview.SurfaceProvider surfaceProvider, @NonNull ViewPort viewPort, @NonNull Display display) {
        Threads.checkMainThread();
        if (this.mSurfaceProvider != surfaceProvider) {
            this.mSurfaceProvider = surfaceProvider;
            this.mPreview.setSurfaceProvider(surfaceProvider);
        }
        this.mViewPort = viewPort;
        this.mPreviewDisplay = display;
        startListeningToRotationEvents();
        startCameraAndTrackStates();
    }

    @MainThread
    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
        restartCameraIfAnalyzerResolutionChanged(analyzer, null);
    }

    @MainThread
    public void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
        }
        this.mPreview.setSurfaceProvider(null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        this.mPreviewDisplay = null;
        stopListeningToRotationEvents();
    }

    @Nullable
    @OptIn(markerClass = {ExperimentalVideo.class})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseGroup createUseCaseGroup() {
        if (!isCameraInitialized()) {
            Logger.d(TAG, CAMERA_NOT_INITIALIZED);
            return null;
        } else if (!isPreviewViewAttached()) {
            Logger.d(TAG, PREVIEW_VIEW_NOT_ATTACHED);
            return null;
        } else {
            UseCaseGroup.Builder addUseCase = new UseCaseGroup.Builder().addUseCase(this.mPreview);
            if (isImageCaptureEnabled()) {
                addUseCase.addUseCase(this.mImageCapture);
            } else {
                this.mCameraProvider.unbind(this.mImageCapture);
            }
            if (isImageAnalysisEnabled()) {
                addUseCase.addUseCase(this.mImageAnalysis);
            } else {
                this.mCameraProvider.unbind(this.mImageAnalysis);
            }
            if (isVideoCaptureEnabled()) {
                addUseCase.addUseCase(this.mVideoCapture);
            } else {
                this.mCameraProvider.unbind(this.mVideoCapture);
            }
            addUseCase.setViewPort(this.mViewPort);
            return addUseCase.build();
        }
    }

    @NonNull
    @MainThread
    public a<Void> enableTorch(boolean z) {
        Threads.checkMainThread();
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return Futures.immediateFuture(null);
        }
        return this.mCamera.getCameraControl().enableTorch(z);
    }

    @Nullable
    @MainThread
    public CameraControl getCameraControl() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraControl();
    }

    @Nullable
    @MainThread
    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraInfo();
    }

    @NonNull
    @MainThread
    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    @Nullable
    @MainThread
    public Executor getImageAnalysisBackgroundExecutor() {
        Threads.checkMainThread();
        return this.mAnalysisBackgroundExecutor;
    }

    @MainThread
    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    @MainThread
    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    @Nullable
    @MainThread
    public OutputSize getImageAnalysisTargetSize() {
        Threads.checkMainThread();
        return this.mImageAnalysisTargetSize;
    }

    @MainThread
    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    @Nullable
    @MainThread
    public Executor getImageCaptureIoExecutor() {
        Threads.checkMainThread();
        return this.mImageCaptureIoExecutor;
    }

    @MainThread
    public int getImageCaptureMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getCaptureMode();
    }

    @Nullable
    @MainThread
    public OutputSize getImageCaptureTargetSize() {
        Threads.checkMainThread();
        return this.mImageCaptureTargetSize;
    }

    @NonNull
    public a<Void> getInitializationFuture() {
        return this.mInitializationFuture;
    }

    @Nullable
    @MainThread
    public OutputSize getPreviewTargetSize() {
        Threads.checkMainThread();
        return this.mPreviewTargetSize;
    }

    @NonNull
    @MainThread
    public LiveData<Integer> getTapToFocusState() {
        Threads.checkMainThread();
        return this.mTapToFocusState;
    }

    @NonNull
    @MainThread
    public LiveData<Integer> getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    @Nullable
    @ExperimentalVideo
    @MainThread
    public OutputSize getVideoCaptureTargetSize() {
        Threads.checkMainThread();
        return this.mVideoCaptureOutputSize;
    }

    @NonNull
    @MainThread
    public LiveData<ZoomState> getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    @MainThread
    public boolean hasCamera(@NonNull CameraSelector cameraSelector) {
        Threads.checkMainThread();
        Preconditions.checkNotNull(cameraSelector);
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            try {
                return processCameraProvider.hasCamera(cameraSelector);
            } catch (CameraInfoUnavailableException e2) {
                Logger.w(TAG, "Failed to check camera availability", e2);
                return false;
            }
        }
        throw new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
    }

    @MainThread
    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(2);
    }

    @MainThread
    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(1);
    }

    @MainThread
    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    @ExperimentalVideo
    @MainThread
    public boolean isRecording() {
        Threads.checkMainThread();
        return this.mVideoIsRecording.get();
    }

    @MainThread
    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    @ExperimentalVideo
    @MainThread
    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(4);
    }

    public void onPinchToZoom(float f2) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
        } else if (!this.mPinchToZoomEnabled) {
            Logger.d(TAG, "Pinch to zoom disabled.");
        } else {
            Logger.d(TAG, "Pinch to zoom with scale: " + f2);
            ZoomState value = getZoomState().getValue();
            if (value == null) {
                return;
            }
            setZoomRatio(Math.min(Math.max(value.getZoomRatio() * speedUpZoomBy2X(f2), value.getMinZoomRatio()), value.getMaxZoomRatio()));
        }
    }

    public void onTapToFocus(MeteringPointFactory meteringPointFactory, float f2, float f3) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
        } else if (!this.mTapToFocusEnabled) {
            Logger.d(TAG, "Tap to focus disabled. ");
        } else {
            Logger.d(TAG, "Tap to focus started: " + f2 + ", " + f3);
            this.mTapToFocusState.postValue(1);
            MeteringPoint createPoint = meteringPointFactory.createPoint(f2, f3, AF_SIZE);
            Futures.addCallback(this.mCamera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(createPoint, 1).addPoint(meteringPointFactory.createPoint(f2, f3, 0.25f), 2).build()), new FutureCallback<FocusMeteringResult>() { // from class: androidx.camera.view.CameraController.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    if (th instanceof CameraControl.OperationCanceledException) {
                        Logger.d(CameraController.TAG, "Tap-to-focus is canceled by new action.");
                        return;
                    }
                    Logger.d(CameraController.TAG, "Tap to focus failed.", th);
                    CameraController.this.mTapToFocusState.postValue(4);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable FocusMeteringResult focusMeteringResult) {
                    if (focusMeteringResult == null) {
                        return;
                    }
                    Logger.d(CameraController.TAG, "Tap to focus onSuccess: " + focusMeteringResult.isFocusSuccessful());
                    CameraController.this.mTapToFocusState.postValue(Integer.valueOf(focusMeteringResult.isFocusSuccessful() ? 2 : 3));
                }
            }, CameraXExecutors.directExecutor());
        }
    }

    @MainThread
    public void setCameraSelector(@NonNull CameraSelector cameraSelector) {
        Threads.checkMainThread();
        final CameraSelector cameraSelector2 = this.mCameraSelector;
        if (cameraSelector2 == cameraSelector) {
            return;
        }
        this.mCameraSelector = cameraSelector;
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider == null) {
            return;
        }
        processCameraProvider.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
        startCameraAndTrackStates(new Runnable() { // from class: c.b.d.e
            {
                CameraController.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CameraController.this.f(cameraSelector2);
            }
        });
    }

    @OptIn(markerClass = {ExperimentalVideo.class})
    @MainThread
    public void setEnabledUseCases(int i2) {
        Threads.checkMainThread();
        final int i3 = this.mEnabledUseCases;
        if (i2 == i3) {
            return;
        }
        this.mEnabledUseCases = i2;
        if (!isVideoCaptureEnabled()) {
            stopRecording();
        }
        startCameraAndTrackStates(new Runnable() { // from class: c.b.d.d
            {
                CameraController.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CameraController.this.h(i3);
            }
        });
    }

    @MainThread
    public void setImageAnalysisAnalyzer(@NonNull Executor executor, @NonNull ImageAnalysis.Analyzer analyzer) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer2 = this.mAnalysisAnalyzer;
        if (analyzer2 == analyzer && this.mAnalysisExecutor == executor) {
            return;
        }
        this.mAnalysisExecutor = executor;
        this.mAnalysisAnalyzer = analyzer;
        this.mImageAnalysis.setAnalyzer(executor, analyzer);
        restartCameraIfAnalyzerResolutionChanged(analyzer2, analyzer);
    }

    @MainThread
    public void setImageAnalysisBackgroundExecutor(@Nullable Executor executor) {
        Threads.checkMainThread();
        if (this.mAnalysisBackgroundExecutor == executor) {
            return;
        }
        this.mAnalysisBackgroundExecutor = executor;
        unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), this.mImageAnalysis.getImageQueueDepth());
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisBackpressureStrategy(int i2) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getBackpressureStrategy() == i2) {
            return;
        }
        unbindImageAnalysisAndRecreate(i2, this.mImageAnalysis.getImageQueueDepth());
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisImageQueueDepth(int i2) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getImageQueueDepth() == i2) {
            return;
        }
        unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), i2);
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisTargetSize(@Nullable OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageAnalysisTargetSize, outputSize)) {
            return;
        }
        this.mImageAnalysisTargetSize = outputSize;
        unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), this.mImageAnalysis.getImageQueueDepth());
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureFlashMode(int i2) {
        Threads.checkMainThread();
        this.mImageCapture.setFlashMode(i2);
    }

    @MainThread
    public void setImageCaptureIoExecutor(@Nullable Executor executor) {
        Threads.checkMainThread();
        if (this.mImageCaptureIoExecutor == executor) {
            return;
        }
        this.mImageCaptureIoExecutor = executor;
        unbindImageCaptureAndRecreate(this.mImageCapture.getCaptureMode());
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureMode(int i2) {
        Threads.checkMainThread();
        if (this.mImageCapture.getCaptureMode() == i2) {
            return;
        }
        unbindImageCaptureAndRecreate(i2);
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureTargetSize(@Nullable OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageCaptureTargetSize, outputSize)) {
            return;
        }
        this.mImageCaptureTargetSize = outputSize;
        unbindImageCaptureAndRecreate(getImageCaptureMode());
        startCameraAndTrackStates();
    }

    @NonNull
    @MainThread
    public a<Void> setLinearZoom(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Threads.checkMainThread();
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return Futures.immediateFuture(null);
        }
        return this.mCamera.getCameraControl().setLinearZoom(f2);
    }

    @MainThread
    public void setPinchToZoomEnabled(boolean z) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = z;
    }

    @MainThread
    public void setPreviewTargetSize(@Nullable OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mPreviewTargetSize, outputSize)) {
            return;
        }
        this.mPreviewTargetSize = outputSize;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    @MainThread
    public void setTapToFocusEnabled(boolean z) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = z;
    }

    @ExperimentalVideo
    @MainThread
    public void setVideoCaptureTargetSize(@Nullable OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mVideoCaptureOutputSize, outputSize)) {
            return;
        }
        this.mVideoCaptureOutputSize = outputSize;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    @NonNull
    @MainThread
    public a<Void> setZoomRatio(float f2) {
        Threads.checkMainThread();
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return Futures.immediateFuture(null);
        }
        return this.mCamera.getCameraControl().setZoomRatio(f2);
    }

    @Nullable
    public abstract Camera startCamera();

    public void startCameraAndTrackStates() {
        startCameraAndTrackStates(null);
    }

    @ExperimentalVideo
    @SuppressLint({"MissingPermission"})
    @MainThread
    public void startRecording(@NonNull OutputFileOptions outputFileOptions, @NonNull Executor executor, @NonNull final OnVideoSavedCallback onVideoSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isVideoCaptureEnabled(), VIDEO_CAPTURE_DISABLED);
        this.mVideoCapture.d(outputFileOptions.toVideoCaptureOutputFileOptions(), executor, new VideoCapture.OnVideoSavedCallback() { // from class: androidx.camera.view.CameraController.1
            @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
            public void onError(int i2, @NonNull String str, @Nullable Throwable th) {
                CameraController.this.mVideoIsRecording.set(false);
                onVideoSavedCallback.onError(i2, str, th);
            }

            @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
            public void onVideoSaved(@NonNull VideoCapture.OutputFileResults outputFileResults) {
                CameraController.this.mVideoIsRecording.set(false);
                onVideoSavedCallback.onVideoSaved(OutputFileResults.create(outputFileResults.getSavedUri()));
            }
        });
        this.mVideoIsRecording.set(true);
    }

    @ExperimentalVideo
    @MainThread
    public void stopRecording() {
        Threads.checkMainThread();
        if (this.mVideoIsRecording.get()) {
            this.mVideoCapture.m();
        }
    }

    @MainThread
    public void takePicture(@NonNull ImageCapture.OutputFileOptions outputFileOptions, @NonNull Executor executor, @NonNull ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        updateMirroringFlagInOutputFileOptions(outputFileOptions);
        this.mImageCapture.n(outputFileOptions, executor, onImageSavedCallback);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void updateMirroringFlagInOutputFileOptions(@NonNull ImageCapture.OutputFileOptions outputFileOptions) {
        if (this.mCameraSelector.getLensFacing() == null || outputFileOptions.getMetadata().isReversedHorizontalSet()) {
            return;
        }
        outputFileOptions.getMetadata().setReversedHorizontal(this.mCameraSelector.getLensFacing().intValue() == 0);
    }

    @OptIn(markerClass = {TransformExperimental.class, ExperimentalAnalyzer.class})
    @MainThread
    public void updatePreviewViewTransform(@Nullable OutputTransform outputTransform) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        if (analyzer == null) {
            return;
        }
        if (outputTransform == null) {
            analyzer.updateTransform(null);
        } else if (analyzer.getTargetCoordinateSystem() == 1) {
            this.mAnalysisAnalyzer.updateTransform(outputTransform.getMatrix());
        }
    }

    public void startCameraAndTrackStates(@Nullable Runnable runnable) {
        try {
            this.mCamera = startCamera();
            if (!isCameraAttached()) {
                Logger.d(TAG, CAMERA_NOT_ATTACHED);
                return;
            }
            this.mZoomState.setSource(this.mCamera.getCameraInfo().getZoomState());
            this.mTorchState.setSource(this.mCamera.getCameraInfo().getTorchState());
        } catch (IllegalArgumentException e2) {
            if (runnable != null) {
                runnable.run();
            }
            throw new IllegalStateException("The selected camera does not support the enabled use cases. Please disable use case and/or select a different camera. e.g. #setVideoCaptureEnabled(false)", e2);
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class OutputSize {
        public static final int UNASSIGNED_ASPECT_RATIO = -1;
        private final int mAspectRatio;
        @Nullable
        private final Size mResolution;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* loaded from: classes.dex */
        public @interface OutputAspectRatio {
        }

        public OutputSize(int i2) {
            Preconditions.checkArgument(i2 != -1);
            this.mAspectRatio = i2;
            this.mResolution = null;
        }

        public int getAspectRatio() {
            return this.mAspectRatio;
        }

        @Nullable
        public Size getResolution() {
            return this.mResolution;
        }

        @NonNull
        public String toString() {
            return "aspect ratio: " + this.mAspectRatio + " resolution: " + this.mResolution;
        }

        public OutputSize(@NonNull Size size) {
            Preconditions.checkNotNull(size);
            this.mAspectRatio = -1;
            this.mResolution = size;
        }
    }

    @MainThread
    public void takePicture(@NonNull Executor executor, @NonNull ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        this.mImageCapture.l(executor, onImageCapturedCallback);
    }
}
