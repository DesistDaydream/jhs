package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.IoConfig;
import c.b.b.b2.e0;
import c.b.b.b2.g0;
import c.b.b.c2.e;
import c.b.b.c2.g;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ImageCaptureConfig implements UseCaseConfig<ImageCapture>, ImageOutputConfig, IoConfig {
    public static final Config.Option<Integer> OPTION_BUFFER_FORMAT;
    public static final Config.Option<CaptureBundle> OPTION_CAPTURE_BUNDLE;
    public static final Config.Option<CaptureProcessor> OPTION_CAPTURE_PROCESSOR;
    public static final Config.Option<Integer> OPTION_FLASH_MODE;
    public static final Config.Option<Integer> OPTION_FLASH_TYPE;
    public static final Config.Option<Integer> OPTION_IMAGE_CAPTURE_MODE;
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER;
    public static final Config.Option<Integer> OPTION_JPEG_COMPRESSION_QUALITY;
    public static final Config.Option<Integer> OPTION_MAX_CAPTURE_STAGES;
    public static final Config.Option<Boolean> OPTION_SESSION_PROCESSOR_ENABLED;
    public static final Config.Option<Boolean> OPTION_USE_SOFTWARE_JPEG_ENCODER;
    private final OptionsBundle mConfig;

    static {
        Class cls = Integer.TYPE;
        OPTION_IMAGE_CAPTURE_MODE = Config.Option.create("camerax.core.imageCapture.captureMode", cls);
        OPTION_FLASH_MODE = Config.Option.create("camerax.core.imageCapture.flashMode", cls);
        OPTION_CAPTURE_BUNDLE = Config.Option.create("camerax.core.imageCapture.captureBundle", CaptureBundle.class);
        OPTION_CAPTURE_PROCESSOR = Config.Option.create("camerax.core.imageCapture.captureProcessor", CaptureProcessor.class);
        OPTION_BUFFER_FORMAT = Config.Option.create("camerax.core.imageCapture.bufferFormat", Integer.class);
        OPTION_MAX_CAPTURE_STAGES = Config.Option.create("camerax.core.imageCapture.maxCaptureStages", Integer.class);
        OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create("camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class);
        Class cls2 = Boolean.TYPE;
        OPTION_USE_SOFTWARE_JPEG_ENCODER = Config.Option.create("camerax.core.imageCapture.useSoftwareJpegEncoder", cls2);
        OPTION_FLASH_TYPE = Config.Option.create("camerax.core.imageCapture.flashType", cls);
        OPTION_JPEG_COMPRESSION_QUALITY = Config.Option.create("camerax.core.imageCapture.jpegCompressionQuality", cls);
        OPTION_SESSION_PROCESSOR_ENABLED = Config.Option.create("camerax.core.imageCapture.sessionProcessorEnabled", cls2);
    }

    public ImageCaptureConfig(@NonNull OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ boolean containsOption(Config.Option option) {
        boolean containsOption;
        containsOption = getConfig().containsOption(option);
        return containsOption;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        getConfig().findOptions(str, optionMatcher);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ int getAppTargetRotation(int i2) {
        int intValue;
        intValue = ((Integer) retrieveOption(ImageOutputConfig.OPTION_APP_TARGET_ROTATION, Integer.valueOf(i2))).intValue();
        return intValue;
    }

    @Nullable
    public Integer getBufferFormat(@Nullable Integer num) {
        return (Integer) retrieveOption(OPTION_BUFFER_FORMAT, num);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CameraSelector getCameraSelector() {
        return g0.$default$getCameraSelector(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CameraSelector getCameraSelector(CameraSelector cameraSelector) {
        return g0.$default$getCameraSelector(this, cameraSelector);
    }

    @Nullable
    public CaptureBundle getCaptureBundle(@Nullable CaptureBundle captureBundle) {
        return (CaptureBundle) retrieveOption(OPTION_CAPTURE_BUNDLE, captureBundle);
    }

    public int getCaptureMode() {
        return ((Integer) retrieveOption(OPTION_IMAGE_CAPTURE_MODE)).intValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return g0.$default$getCaptureOptionUnpacker(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        return g0.$default$getCaptureOptionUnpacker(this, optionUnpacker);
    }

    @Nullable
    public CaptureProcessor getCaptureProcessor(@Nullable CaptureProcessor captureProcessor) {
        return (CaptureProcessor) retrieveOption(OPTION_CAPTURE_PROCESSOR, captureProcessor);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    @NonNull
    public Config getConfig() {
        return this.mConfig;
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
        return g0.$default$getDefaultCaptureConfig(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
        return g0.$default$getDefaultCaptureConfig(this, captureConfig);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size getDefaultResolution() {
        return e0.$default$getDefaultResolution(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size getDefaultResolution(Size size) {
        return e0.$default$getDefaultResolution(this, size);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ SessionConfig getDefaultSessionConfig() {
        return g0.$default$getDefaultSessionConfig(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
        return g0.$default$getDefaultSessionConfig(this, sessionConfig);
    }

    public int getFlashMode(int i2) {
        return ((Integer) retrieveOption(OPTION_FLASH_MODE, Integer.valueOf(i2))).intValue();
    }

    public int getFlashType(int i2) {
        return ((Integer) retrieveOption(OPTION_FLASH_TYPE, Integer.valueOf(i2))).intValue();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return (ImageReaderProxyProvider) retrieveOption(OPTION_IMAGE_READER_PROXY_PROVIDER, null);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public int getInputFormat() {
        return ((Integer) retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
    }

    @Override // androidx.camera.core.internal.IoConfig
    @Nullable
    public Executor getIoExecutor(@Nullable Executor executor) {
        return (Executor) retrieveOption(IoConfig.OPTION_IO_EXECUTOR, executor);
    }

    @IntRange(from = 1, to = 100)
    public int getJpegQuality(@IntRange(from = 1, to = 100) int i2) {
        return ((Integer) retrieveOption(OPTION_JPEG_COMPRESSION_QUALITY, Integer.valueOf(i2))).intValue();
    }

    public int getMaxCaptureStages(int i2) {
        return ((Integer) retrieveOption(OPTION_MAX_CAPTURE_STAGES, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size getMaxResolution() {
        return e0.$default$getMaxResolution(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size getMaxResolution(Size size) {
        return e0.$default$getMaxResolution(this, size);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        Config.OptionPriority optionPriority;
        optionPriority = getConfig().getOptionPriority(option);
        return optionPriority;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Set getPriorities(Config.Option option) {
        Set priorities;
        priorities = getConfig().getPriorities(option);
        return priorities;
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return g0.$default$getSessionOptionUnpacker(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        return g0.$default$getSessionOptionUnpacker(this, optionUnpacker);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ List getSupportedResolutions() {
        return e0.$default$getSupportedResolutions(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ List getSupportedResolutions(List list) {
        return e0.$default$getSupportedResolutions(this, list);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ int getSurfaceOccupancyPriority() {
        int intValue;
        intValue = ((Integer) retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
        return intValue;
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ int getSurfaceOccupancyPriority(int i2) {
        int intValue;
        intValue = ((Integer) retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2))).intValue();
        return intValue;
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ int getTargetAspectRatio() {
        int intValue;
        intValue = ((Integer) retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)).intValue();
        return intValue;
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public /* synthetic */ Class getTargetClass() {
        return e.$default$getTargetClass(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public /* synthetic */ Class getTargetClass(Class cls) {
        return e.$default$getTargetClass(this, cls);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ Range getTargetFramerate() {
        return g0.$default$getTargetFramerate(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ Range getTargetFramerate(Range range) {
        return g0.$default$getTargetFramerate(this, range);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public /* synthetic */ String getTargetName() {
        return e.$default$getTargetName(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public /* synthetic */ String getTargetName(String str) {
        return e.$default$getTargetName(this, str);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size getTargetResolution() {
        return e0.$default$getTargetResolution(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size getTargetResolution(Size size) {
        return e0.$default$getTargetResolution(this, size);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ int getTargetRotation() {
        int intValue;
        intValue = ((Integer) retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION)).intValue();
        return intValue;
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ int getTargetRotation(int i2) {
        int intValue;
        intValue = ((Integer) retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i2))).intValue();
        return intValue;
    }

    @Override // androidx.camera.core.internal.UseCaseEventConfig
    public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback() {
        return g.$default$getUseCaseEventCallback(this);
    }

    @Override // androidx.camera.core.internal.UseCaseEventConfig
    public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        return g.$default$getUseCaseEventCallback(this, eventCallback);
    }

    public boolean hasCaptureMode() {
        return containsOption(OPTION_IMAGE_CAPTURE_MODE);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ boolean hasTargetAspectRatio() {
        boolean containsOption;
        containsOption = containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
        return containsOption;
    }

    public boolean isSessionProcessorEnabled() {
        return ((Boolean) retrieveOption(OPTION_SESSION_PROCESSOR_ENABLED, Boolean.FALSE)).booleanValue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isSoftwareJpegEncoderRequested() {
        return ((Boolean) retrieveOption(OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.FALSE)).booleanValue();
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Set listOptions() {
        Set listOptions;
        listOptions = getConfig().listOptions();
        return listOptions;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Object retrieveOption(Config.Option option) {
        Object retrieveOption;
        retrieveOption = getConfig().retrieveOption(option);
        return retrieveOption;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
        Object retrieveOption;
        retrieveOption = getConfig().retrieveOption(option, obj);
        return retrieveOption;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
        Object retrieveOptionWithPriority;
        retrieveOptionWithPriority = getConfig().retrieveOptionWithPriority(option, optionPriority);
        return retrieveOptionWithPriority;
    }

    @NonNull
    public Integer getBufferFormat() {
        return (Integer) retrieveOption(OPTION_BUFFER_FORMAT);
    }

    @NonNull
    public CaptureBundle getCaptureBundle() {
        return (CaptureBundle) retrieveOption(OPTION_CAPTURE_BUNDLE);
    }

    @NonNull
    public CaptureProcessor getCaptureProcessor() {
        return (CaptureProcessor) retrieveOption(OPTION_CAPTURE_PROCESSOR);
    }

    public int getFlashMode() {
        return ((Integer) retrieveOption(OPTION_FLASH_MODE)).intValue();
    }

    public int getFlashType() {
        return ((Integer) retrieveOption(OPTION_FLASH_TYPE)).intValue();
    }

    @Override // androidx.camera.core.internal.IoConfig
    @NonNull
    public Executor getIoExecutor() {
        return (Executor) retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
    }

    @IntRange(from = 1, to = 100)
    public int getJpegQuality() {
        return ((Integer) retrieveOption(OPTION_JPEG_COMPRESSION_QUALITY)).intValue();
    }

    public int getMaxCaptureStages() {
        return ((Integer) retrieveOption(OPTION_MAX_CAPTURE_STAGES)).intValue();
    }
}
