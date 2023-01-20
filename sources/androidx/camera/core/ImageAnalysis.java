package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import androidx.core.util.Preconditions;
import c.b.b.b2.c0;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ImageAnalysis extends UseCase {
    @ExperimentalAnalyzer
    public static final int COORDINATE_SYSTEM_ORIGINAL = 0;
    private static final int DEFAULT_BACKPRESSURE_STRATEGY = 0;
    private static final int DEFAULT_IMAGE_QUEUE_DEPTH = 6;
    private static final int DEFAULT_OUTPUT_IMAGE_FORMAT = 1;
    private static final boolean DEFAULT_OUTPUT_IMAGE_ROTATION_ENABLED = false;
    private static final int NON_BLOCKING_IMAGE_DEPTH = 4;
    public static final int OUTPUT_IMAGE_FORMAT_RGBA_8888 = 2;
    public static final int OUTPUT_IMAGE_FORMAT_YUV_420_888 = 1;
    public static final int STRATEGY_BLOCK_PRODUCER = 1;
    public static final int STRATEGY_KEEP_ONLY_LATEST = 0;
    private static final String TAG = "ImageAnalysis";
    private final Object mAnalysisLock;
    @Nullable
    private DeferrableSurface mDeferrableSurface;
    public final ImageAnalysisAbstractAnalyzer mImageAnalysisAbstractAnalyzer;
    @GuardedBy("mAnalysisLock")
    private Analyzer mSubscribedAnalyzer;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final Boolean DEFAULT_ONE_PIXEL_SHIFT_ENABLED = null;

    /* loaded from: classes.dex */
    public interface Analyzer {
        void analyze(@NonNull ImageProxy imageProxy);

        @ExperimentalAnalyzer
        int getTargetCoordinateSystem();

        @Nullable
        @ExperimentalAnalyzer
        Size getTargetResolutionOverride();

        @ExperimentalAnalyzer
        void updateTransform(@Nullable Matrix matrix);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface BackpressureStrategy {
    }

    /* loaded from: classes.dex */
    public static final class Builder implements ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder>, UseCaseConfig.Builder<ImageAnalysis, ImageAnalysisConfig, Builder> {
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
        public Builder setBackpressureStrategy(int i2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_BACKPRESSURE_STRATEGY, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setImageQueueDepth(int i2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_QUEUE_DEPTH, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setImageReaderProxyProvider(@NonNull ImageReaderProxyProvider imageReaderProxyProvider) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, imageReaderProxyProvider);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setOnePixelShiftEnabled(boolean z) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_ONE_PIXEL_SHIFT_ENABLED, Boolean.valueOf(z));
            return this;
        }

        @NonNull
        public Builder setOutputImageFormat(int i2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_FORMAT, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setOutputImageRotationEnabled(boolean z) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_ROTATION_ENABLED, Boolean.valueOf(z));
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
            return setTargetClass((Class<ImageAnalysis>) cls);
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls != null && !cls.equals(ImageAnalysis.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            setTargetClass(ImageAnalysis.class);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(@NonNull ImageAnalysisConfig imageAnalysisConfig) {
            return new Builder(MutableOptionsBundle.from((Config) imageAnalysisConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public ImageAnalysis build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) != null && getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) != null) {
                throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
            }
            return new ImageAnalysis(getUseCaseConfig());
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ImageAnalysisConfig getUseCaseConfig() {
            return new ImageAnalysisConfig(OptionsBundle.from(this.mMutableConfig));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        @NonNull
        public Builder setBackgroundExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
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
        public Builder setTargetClass(@NonNull Class<ImageAnalysis> cls) {
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
    public static final class Defaults implements ConfigProvider<ImageAnalysisConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final ImageAnalysisConfig DEFAULT_CONFIG;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 1;
        private static final Size DEFAULT_TARGET_RESOLUTION;

        static {
            Size size = new Size(640, 480);
            DEFAULT_TARGET_RESOLUTION = size;
            DEFAULT_CONFIG = new Builder().setDefaultResolution(size).setSurfaceOccupancyPriority(1).setTargetAspectRatio(0).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public ImageAnalysisConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface OutputImageFormat {
    }

    public ImageAnalysis(@NonNull ImageAnalysisConfig imageAnalysisConfig) {
        super(imageAnalysisConfig);
        this.mAnalysisLock = new Object();
        if (((ImageAnalysisConfig) getCurrentConfig()).getBackpressureStrategy(0) == 1) {
            this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisBlockingAnalyzer();
        } else {
            this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisNonBlockingAnalyzer(imageAnalysisConfig.getBackgroundExecutor(CameraXExecutors.highPriorityExecutor()));
        }
        this.mImageAnalysisAbstractAnalyzer.setOutputImageFormat(getOutputImageFormat());
        this.mImageAnalysisAbstractAnalyzer.setOutputImageRotationEnabled(isOutputImageRotationEnabled());
    }

    public static /* synthetic */ void a(SafeCloseImageReaderProxy safeCloseImageReaderProxy, SafeCloseImageReaderProxy safeCloseImageReaderProxy2) {
        safeCloseImageReaderProxy.safeClose();
        if (safeCloseImageReaderProxy2 != null) {
            safeCloseImageReaderProxy2.safeClose();
        }
    }

    /* renamed from: b */
    public /* synthetic */ void c(String str, ImageAnalysisConfig imageAnalysisConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        clearPipeline();
        this.mImageAnalysisAbstractAnalyzer.clearCache();
        if (isCurrentCamera(str)) {
            updateSessionConfig(createPipeline(str, imageAnalysisConfig, size).build());
            notifyReset();
        }
    }

    private boolean isFlipWH(@NonNull CameraInternal cameraInternal) {
        return isOutputImageRotationEnabled() && getRelativeRotation(cameraInternal) % 180 != 0;
    }

    private void tryUpdateRelativeRotation() {
        CameraInternal camera = getCamera();
        if (camera != null) {
            this.mImageAnalysisAbstractAnalyzer.setRelativeRotation(getRelativeRotation(camera));
        }
    }

    public void clearAnalyzer() {
        synchronized (this.mAnalysisLock) {
            this.mImageAnalysisAbstractAnalyzer.setAnalyzer(null, null);
            if (this.mSubscribedAnalyzer != null) {
                notifyInactive();
            }
            this.mSubscribedAnalyzer = null;
        }
    }

    public void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
            this.mDeferrableSurface = null;
        }
    }

    public SessionConfig.Builder createPipeline(@NonNull final String str, @NonNull final ImageAnalysisConfig imageAnalysisConfig, @NonNull final Size size) {
        final SafeCloseImageReaderProxy safeCloseImageReaderProxy;
        Threads.checkMainThread();
        Executor executor = (Executor) Preconditions.checkNotNull(imageAnalysisConfig.getBackgroundExecutor(CameraXExecutors.highPriorityExecutor()));
        boolean z = true;
        int imageQueueDepth = getBackpressureStrategy() == 1 ? getImageQueueDepth() : 4;
        if (imageAnalysisConfig.getImageReaderProxyProvider() != null) {
            safeCloseImageReaderProxy = new SafeCloseImageReaderProxy(imageAnalysisConfig.getImageReaderProxyProvider().newInstance(size.getWidth(), size.getHeight(), getImageFormat(), imageQueueDepth, 0L));
        } else {
            safeCloseImageReaderProxy = new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(size.getWidth(), size.getHeight(), getImageFormat(), imageQueueDepth));
        }
        boolean isFlipWH = getCamera() != null ? isFlipWH(getCamera()) : false;
        int height = isFlipWH ? size.getHeight() : size.getWidth();
        int width = isFlipWH ? size.getWidth() : size.getHeight();
        int i2 = getOutputImageFormat() == 2 ? 1 : 35;
        boolean z2 = getImageFormat() == 35 && getOutputImageFormat() == 2;
        if (getImageFormat() != 35 || ((getCamera() == null || getRelativeRotation(getCamera()) == 0) && !Boolean.TRUE.equals(getOnePixelShiftEnabled()))) {
            z = false;
        }
        final SafeCloseImageReaderProxy safeCloseImageReaderProxy2 = (z2 || z) ? new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(height, width, i2, safeCloseImageReaderProxy.getMaxImages())) : null;
        if (safeCloseImageReaderProxy2 != null) {
            this.mImageAnalysisAbstractAnalyzer.setProcessedImageReaderProxy(safeCloseImageReaderProxy2);
        }
        tryUpdateRelativeRotation();
        safeCloseImageReaderProxy.setOnImageAvailableListener(this.mImageAnalysisAbstractAnalyzer, executor);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(imageAnalysisConfig);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(safeCloseImageReaderProxy.getSurface(), size, getImageFormat());
        this.mDeferrableSurface = immediateSurface;
        immediateSurface.getTerminationFuture().addListener(new Runnable() { // from class: c.b.b.q
            @Override // java.lang.Runnable
            public final void run() {
                ImageAnalysis.a(safeCloseImageReaderProxy, safeCloseImageReaderProxy2);
            }
        }, CameraXExecutors.mainThreadExecutor());
        createFrom.addSurface(this.mDeferrableSurface);
        createFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: c.b.b.p
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                ImageAnalysis.this.c(str, imageAnalysisConfig, size, sessionConfig, sessionError);
            }
        });
        return createFrom;
    }

    public int getBackpressureStrategy() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getBackpressureStrategy(0);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getDefaultConfig(boolean z, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS, 1);
        if (z) {
            config = c0.b(config, DEFAULT_CONFIG.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    public int getImageQueueDepth() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getImageQueueDepth(6);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Boolean getOnePixelShiftEnabled() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getOnePixelShiftEnabled(DEFAULT_ONE_PIXEL_SHIFT_ENABLED);
    }

    public int getOutputImageFormat() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getOutputImageFormat(1);
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

    public boolean isOutputImageRotationEnabled() {
        return ((ImageAnalysisConfig) getCurrentConfig()).isOutputImageRotationEnabled(Boolean.FALSE).booleanValue();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onAttached() {
        this.mImageAnalysisAbstractAnalyzer.attach();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDetached() {
        clearPipeline();
        this.mImageAnalysisAbstractAnalyzer.detach();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @NonNull
    @OptIn(markerClass = {ExperimentalAnalyzer.class})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        Size targetResolutionOverride;
        Boolean onePixelShiftEnabled = getOnePixelShiftEnabled();
        boolean contains = cameraInfoInternal.getCameraQuirks().contains(OnePixelShiftQuirk.class);
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
        if (onePixelShiftEnabled != null) {
            contains = onePixelShiftEnabled.booleanValue();
        }
        imageAnalysisAbstractAnalyzer.setOnePixelShiftEnabled(contains);
        synchronized (this.mAnalysisLock) {
            Analyzer analyzer = this.mSubscribedAnalyzer;
            targetResolutionOverride = analyzer != null ? analyzer.getTargetResolutionOverride() : null;
        }
        if (targetResolutionOverride != null) {
            builder.getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, targetResolutionOverride);
        }
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size onSuggestedResolutionUpdated(@NonNull Size size) {
        updateSessionConfig(createPipeline(getCameraId(), (ImageAnalysisConfig) getCurrentConfig(), size).build());
        return size;
    }

    public void setAnalyzer(@NonNull Executor executor, @NonNull final Analyzer analyzer) {
        synchronized (this.mAnalysisLock) {
            this.mImageAnalysisAbstractAnalyzer.setAnalyzer(executor, new Analyzer() { // from class: c.b.b.o
                @Override // androidx.camera.core.ImageAnalysis.Analyzer
                public final void analyze(ImageProxy imageProxy) {
                    analyzer.analyze(imageProxy);
                }

                @Override // androidx.camera.core.ImageAnalysis.Analyzer
                public /* synthetic */ int getTargetCoordinateSystem() {
                    return z1.$default$getTargetCoordinateSystem(this);
                }

                @Override // androidx.camera.core.ImageAnalysis.Analyzer
                public /* synthetic */ Size getTargetResolutionOverride() {
                    return z1.$default$getTargetResolutionOverride(this);
                }

                @Override // androidx.camera.core.ImageAnalysis.Analyzer
                public /* synthetic */ void updateTransform(Matrix matrix) {
                    z1.$default$updateTransform(this, matrix);
                }
            });
            if (this.mSubscribedAnalyzer == null) {
                notifyActive();
            }
            this.mSubscribedAnalyzer = analyzer;
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSensorToBufferTransformMatrix(@NonNull Matrix matrix) {
        this.mImageAnalysisAbstractAnalyzer.setSensorToBufferTransformMatrix(matrix);
    }

    public void setTargetRotation(int i2) {
        if (setTargetRotationInternal(i2)) {
            tryUpdateRelativeRotation();
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewPortCropRect(@NonNull Rect rect) {
        super.setViewPortCropRect(rect);
        this.mImageAnalysisAbstractAnalyzer.setViewPortCropRect(rect);
    }

    @NonNull
    public String toString() {
        return "ImageAnalysis:" + getName();
    }
}
