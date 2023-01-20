package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
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
public final class VideoCaptureConfig implements UseCaseConfig<VideoCapture>, ImageOutputConfig, ThreadConfig {
    public static final Config.Option<Integer> OPTION_AUDIO_BIT_RATE;
    public static final Config.Option<Integer> OPTION_AUDIO_CHANNEL_COUNT;
    public static final Config.Option<Integer> OPTION_AUDIO_MIN_BUFFER_SIZE;
    public static final Config.Option<Integer> OPTION_AUDIO_SAMPLE_RATE;
    public static final Config.Option<Integer> OPTION_BIT_RATE;
    public static final Config.Option<Integer> OPTION_INTRA_FRAME_INTERVAL;
    public static final Config.Option<Integer> OPTION_VIDEO_FRAME_RATE;
    private final OptionsBundle mConfig;

    static {
        Class cls = Integer.TYPE;
        OPTION_VIDEO_FRAME_RATE = Config.Option.create("camerax.core.videoCapture.recordingFrameRate", cls);
        OPTION_BIT_RATE = Config.Option.create("camerax.core.videoCapture.bitRate", cls);
        OPTION_INTRA_FRAME_INTERVAL = Config.Option.create("camerax.core.videoCapture.intraFrameInterval", cls);
        OPTION_AUDIO_BIT_RATE = Config.Option.create("camerax.core.videoCapture.audioBitRate", cls);
        OPTION_AUDIO_SAMPLE_RATE = Config.Option.create("camerax.core.videoCapture.audioSampleRate", cls);
        OPTION_AUDIO_CHANNEL_COUNT = Config.Option.create("camerax.core.videoCapture.audioChannelCount", cls);
        OPTION_AUDIO_MIN_BUFFER_SIZE = Config.Option.create("camerax.core.videoCapture.audioMinBufferSize", cls);
    }

    public VideoCaptureConfig(@NonNull OptionsBundle optionsBundle) {
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

    public int getAudioBitRate(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_BIT_RATE, Integer.valueOf(i2))).intValue();
    }

    public int getAudioChannelCount(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_CHANNEL_COUNT, Integer.valueOf(i2))).intValue();
    }

    public int getAudioMinBufferSize(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_MIN_BUFFER_SIZE, Integer.valueOf(i2))).intValue();
    }

    public int getAudioSampleRate(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_SAMPLE_RATE, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    public /* synthetic */ Executor getBackgroundExecutor() {
        return f.$default$getBackgroundExecutor(this);
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    public /* synthetic */ Executor getBackgroundExecutor(Executor executor) {
        return f.$default$getBackgroundExecutor(this, executor);
    }

    public int getBitRate(int i2) {
        return ((Integer) retrieveOption(OPTION_BIT_RATE, Integer.valueOf(i2))).intValue();
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

    public int getIFrameInterval(int i2) {
        return ((Integer) retrieveOption(OPTION_INTRA_FRAME_INTERVAL, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public int getInputFormat() {
        return 34;
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

    public int getVideoFrameRate(int i2) {
        return ((Integer) retrieveOption(OPTION_VIDEO_FRAME_RATE, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ boolean hasTargetAspectRatio() {
        boolean containsOption;
        containsOption = containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
        return containsOption;
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

    public int getAudioBitRate() {
        return ((Integer) retrieveOption(OPTION_AUDIO_BIT_RATE)).intValue();
    }

    public int getAudioChannelCount() {
        return ((Integer) retrieveOption(OPTION_AUDIO_CHANNEL_COUNT)).intValue();
    }

    public int getAudioMinBufferSize() {
        return ((Integer) retrieveOption(OPTION_AUDIO_MIN_BUFFER_SIZE)).intValue();
    }

    public int getAudioSampleRate() {
        return ((Integer) retrieveOption(OPTION_AUDIO_SAMPLE_RATE)).intValue();
    }

    public int getBitRate() {
        return ((Integer) retrieveOption(OPTION_BIT_RATE)).intValue();
    }

    public int getIFrameInterval() {
        return ((Integer) retrieveOption(OPTION_INTRA_FRAME_INTERVAL)).intValue();
    }

    public int getVideoFrameRate() {
        return ((Integer) retrieveOption(OPTION_VIDEO_FRAME_RATE)).intValue();
    }
}
