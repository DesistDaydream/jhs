package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.ThreadConfig;
import c.b.b.b2.e0;
import c.b.b.b2.g0;
import c.b.b.c2.e;
import c.b.b.c2.f;
import c.b.b.c2.g;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class PreviewConfig implements UseCaseConfig<Preview>, ImageOutputConfig, ThreadConfig {
    public static final Config.Option<ImageInfoProcessor> IMAGE_INFO_PROCESSOR = Config.Option.create("camerax.core.preview.imageInfoProcessor", ImageInfoProcessor.class);
    public static final Config.Option<CaptureProcessor> OPTION_PREVIEW_CAPTURE_PROCESSOR = Config.Option.create("camerax.core.preview.captureProcessor", CaptureProcessor.class);
    public static final Config.Option<Boolean> OPTION_RGBA8888_SURFACE_REQUIRED = Config.Option.create("camerax.core.preview.isRgba8888SurfaceRequired", Boolean.class);
    private final OptionsBundle mConfig;

    public PreviewConfig(@NonNull OptionsBundle optionsBundle) {
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

    @Override // androidx.camera.core.internal.ThreadConfig
    public /* synthetic */ Executor getBackgroundExecutor() {
        return f.$default$getBackgroundExecutor(this);
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    public /* synthetic */ Executor getBackgroundExecutor(Executor executor) {
        return f.$default$getBackgroundExecutor(this, executor);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CameraSelector getCameraSelector() {
        return g0.$default$getCameraSelector(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CameraSelector getCameraSelector(CameraSelector cameraSelector) {
        return g0.$default$getCameraSelector(this, cameraSelector);
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
        return (CaptureProcessor) retrieveOption(OPTION_PREVIEW_CAPTURE_PROCESSOR, captureProcessor);
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

    @Nullable
    public ImageInfoProcessor getImageInfoProcessor(@Nullable ImageInfoProcessor imageInfoProcessor) {
        return (ImageInfoProcessor) retrieveOption(IMAGE_INFO_PROCESSOR, imageInfoProcessor);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public int getInputFormat() {
        return ((Integer) retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
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

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ boolean hasTargetAspectRatio() {
        boolean containsOption;
        containsOption = containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
        return containsOption;
    }

    public boolean isRgba8888SurfaceRequired(boolean z) {
        return ((Boolean) retrieveOption(OPTION_RGBA8888_SURFACE_REQUIRED, Boolean.valueOf(z))).booleanValue();
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
    public CaptureProcessor getCaptureProcessor() {
        return (CaptureProcessor) retrieveOption(OPTION_PREVIEW_CAPTURE_PROCESSOR);
    }

    @NonNull
    public ImageInfoProcessor getImageInfoProcessor() {
        return (ImageInfoProcessor) retrieveOption(IMAGE_INFO_PROCESSOR);
    }
}
