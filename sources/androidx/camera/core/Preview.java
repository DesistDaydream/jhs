package androidx.camera.core;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import c.b.b.b2.c0;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Preview extends UseCase {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final Executor DEFAULT_SURFACE_PROVIDER_EXECUTOR = CameraXExecutors.mainThreadExecutor();
    private static final String TAG = "Preview";
    @Nullable
    @VisibleForTesting
    public SurfaceRequest mCurrentSurfaceRequest;
    private boolean mHasUnsentSurfaceRequest;
    private DeferrableSurface mSessionDeferrableSurface;
    @Nullable
    private SurfaceProvider mSurfaceProvider;
    @NonNull
    private Executor mSurfaceProviderExecutor;
    @Nullable
    private Size mSurfaceSize;

    /* loaded from: classes.dex */
    public static final class Builder implements UseCaseConfig.Builder<Preview, PreviewConfig, Builder>, ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(@NonNull Config config) {
            return new Builder(MutableOptionsBundle.from(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureProcessor(@NonNull CaptureProcessor captureProcessor) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_PREVIEW_CAPTURE_PROCESSOR, captureProcessor);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setImageInfoProcessor(@NonNull ImageInfoProcessor imageInfoProcessor) {
            getMutableConfig().insertOption(PreviewConfig.IMAGE_INFO_PROCESSOR, imageInfoProcessor);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setIsRgba8888SurfaceRequired(boolean z) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_RGBA8888_SURFACE_REQUIRED, Boolean.valueOf(z));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Builder setSupportedResolutions(@NonNull List list) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setTargetClass(@NonNull Class cls) {
            return setTargetClass((Class<Preview>) cls);
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls != null && !cls.equals(Preview.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            setTargetClass(Preview.class);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(@NonNull PreviewConfig previewConfig) {
            return new Builder(MutableOptionsBundle.from((Config) previewConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public Preview build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) != null && getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) != null) {
                throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
            }
            return new Preview(getUseCaseConfig());
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public PreviewConfig getUseCaseConfig() {
            return new PreviewConfig(OptionsBundle.from(this.mMutableConfig));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setBackgroundExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCameraSelector(@NonNull CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultSessionConfig(@NonNull SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setMaxResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSurfaceOccupancyPriority(int i2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setTargetAspectRatio(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetClass(@NonNull Class<Preview> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID());
            }
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        public Builder setTargetName(@NonNull String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setTargetResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setTargetRotation(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i2));
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_APP_TARGET_ROTATION, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.internal.UseCaseEventConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setUseCaseEventCallback(@NonNull UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Defaults implements ConfigProvider<PreviewConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final PreviewConfig DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(2).setTargetAspectRatio(0).getUseCaseConfig();
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 2;

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public PreviewConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    /* loaded from: classes.dex */
    public interface SurfaceProvider {
        void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest);
    }

    @MainThread
    public Preview(@NonNull PreviewConfig previewConfig) {
        super(previewConfig);
        this.mSurfaceProviderExecutor = DEFAULT_SURFACE_PROVIDER_EXECUTOR;
        this.mHasUnsentSurfaceRequest = false;
    }

    /* renamed from: a */
    public /* synthetic */ void b(String str, PreviewConfig previewConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (isCurrentCamera(str)) {
            updateSessionConfig(createPipeline(str, previewConfig, size).build());
            notifyReset();
        }
    }

    @Nullable
    private Rect getCropRect(@Nullable Size size) {
        if (getViewPortCropRect() != null) {
            return getViewPortCropRect();
        }
        if (size != null) {
            return new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return null;
    }

    private boolean sendSurfaceRequestIfReady() {
        final SurfaceRequest surfaceRequest = this.mCurrentSurfaceRequest;
        final SurfaceProvider surfaceProvider = this.mSurfaceProvider;
        if (surfaceProvider == null || surfaceRequest == null) {
            return false;
        }
        this.mSurfaceProviderExecutor.execute(new Runnable() { // from class: c.b.b.t0
            @Override // java.lang.Runnable
            public final void run() {
                surfaceProvider.onSurfaceRequested(surfaceRequest);
            }
        });
        return true;
    }

    private void sendTransformationInfoIfReady() {
        CameraInternal camera = getCamera();
        SurfaceProvider surfaceProvider = this.mSurfaceProvider;
        Rect cropRect = getCropRect(this.mSurfaceSize);
        SurfaceRequest surfaceRequest = this.mCurrentSurfaceRequest;
        if (camera == null || surfaceProvider == null || cropRect == null) {
            return;
        }
        surfaceRequest.updateTransformationInfo(SurfaceRequest.TransformationInfo.of(cropRect, getRelativeRotation(camera), getAppTargetRotation()));
    }

    private void updateConfigAndOutput(@NonNull String str, @NonNull PreviewConfig previewConfig, @NonNull Size size) {
        updateSessionConfig(createPipeline(str, previewConfig, size).build());
    }

    public SessionConfig.Builder createPipeline(@NonNull final String str, @NonNull final PreviewConfig previewConfig, @NonNull final Size size) {
        Threads.checkMainThread();
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(previewConfig);
        CaptureProcessor captureProcessor = previewConfig.getCaptureProcessor(null);
        DeferrableSurface deferrableSurface = this.mSessionDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        SurfaceRequest surfaceRequest = new SurfaceRequest(size, getCamera(), previewConfig.isRgba8888SurfaceRequired(false));
        this.mCurrentSurfaceRequest = surfaceRequest;
        if (sendSurfaceRequestIfReady()) {
            sendTransformationInfoIfReady();
        } else {
            this.mHasUnsentSurfaceRequest = true;
        }
        if (captureProcessor != null) {
            CaptureStage.DefaultCaptureStage defaultCaptureStage = new CaptureStage.DefaultCaptureStage();
            final HandlerThread handlerThread = new HandlerThread("CameraX-preview_processing");
            handlerThread.start();
            String num = Integer.toString(defaultCaptureStage.hashCode());
            ProcessingSurface processingSurface = new ProcessingSurface(size.getWidth(), size.getHeight(), previewConfig.getInputFormat(), new Handler(handlerThread.getLooper()), defaultCaptureStage, captureProcessor, surfaceRequest.getDeferrableSurface(), num);
            createFrom.addCameraCaptureCallback(processingSurface.getCameraCaptureCallback());
            processingSurface.getTerminationFuture().addListener(new Runnable() { // from class: c.b.b.a
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quitSafely();
                }
            }, CameraXExecutors.directExecutor());
            this.mSessionDeferrableSurface = processingSurface;
            createFrom.addTag(num, Integer.valueOf(defaultCaptureStage.getId()));
        } else {
            final ImageInfoProcessor imageInfoProcessor = previewConfig.getImageInfoProcessor(null);
            if (imageInfoProcessor != null) {
                createFrom.addCameraCaptureCallback(new CameraCaptureCallback() { // from class: androidx.camera.core.Preview.1
                    {
                        Preview.this = this;
                    }

                    @Override // androidx.camera.core.impl.CameraCaptureCallback
                    public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                        super.onCaptureCompleted(cameraCaptureResult);
                        if (imageInfoProcessor.process(new CameraCaptureResultImageInfo(cameraCaptureResult))) {
                            Preview.this.notifyUpdated();
                        }
                    }
                });
            }
            this.mSessionDeferrableSurface = surfaceRequest.getDeferrableSurface();
        }
        createFrom.addSurface(this.mSessionDeferrableSurface);
        createFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: c.b.b.s0
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                Preview.this.b(str, previewConfig, size, sessionConfig, sessionError);
            }
        });
        return createFrom;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getDefaultConfig(boolean z, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(UseCaseConfigFactory.CaptureType.PREVIEW, 1);
        if (z) {
            config = c0.b(config, DEFAULT_CONFIG.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    public ResolutionInfo getResolutionInfo() {
        return super.getResolutionInfo();
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config) {
        return Builder.fromConfig(config);
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDetached() {
        DeferrableSurface deferrableSurface = this.mSessionDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mCurrentSurfaceRequest = null;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        if (builder.getMutableConfig().retrieveOption(PreviewConfig.OPTION_PREVIEW_CAPTURE_PROCESSOR, null) != null) {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
        } else {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        }
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size onSuggestedResolutionUpdated(@NonNull Size size) {
        this.mSurfaceSize = size;
        updateConfigAndOutput(getCameraId(), (PreviewConfig) getCurrentConfig(), this.mSurfaceSize);
        return size;
    }

    @UiThread
    public void setSurfaceProvider(@NonNull Executor executor, @Nullable SurfaceProvider surfaceProvider) {
        Threads.checkMainThread();
        if (surfaceProvider == null) {
            this.mSurfaceProvider = null;
            notifyInactive();
            return;
        }
        this.mSurfaceProvider = surfaceProvider;
        this.mSurfaceProviderExecutor = executor;
        notifyActive();
        if (this.mHasUnsentSurfaceRequest) {
            if (sendSurfaceRequestIfReady()) {
                sendTransformationInfoIfReady();
                this.mHasUnsentSurfaceRequest = false;
            }
        } else if (getAttachedSurfaceResolution() != null) {
            updateConfigAndOutput(getCameraId(), (PreviewConfig) getCurrentConfig(), getAttachedSurfaceResolution());
            notifyReset();
        }
    }

    public void setTargetRotation(int i2) {
        if (setTargetRotationInternal(i2)) {
            sendTransformationInfoIfReady();
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setViewPortCropRect(@NonNull Rect rect) {
        super.setViewPortCropRect(rect);
        sendTransformationInfoIfReady();
    }

    @NonNull
    public String toString() {
        return "Preview:" + getName();
    }

    @UiThread
    public void setSurfaceProvider(@Nullable SurfaceProvider surfaceProvider) {
        setSurfaceProvider(DEFAULT_SURFACE_PROVIDER_EXECUTOR, surfaceProvider);
    }
}
