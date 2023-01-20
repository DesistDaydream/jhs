package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.SupportedRepeatingSurfaceSize;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import c.b.a.d.j1;
import c.b.b.b2.g0;
import c.b.b.c2.e;
import c.b.b.c2.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public class MeteringRepeatingSession {
    private static final String TAG = "MeteringRepeating";
    private DeferrableSurface mDeferrableSurface;
    @NonNull
    private final SessionConfig mSessionConfig;
    @NonNull
    private final SupportedRepeatingSurfaceSize mSupportedRepeatingSurfaceSize = new SupportedRepeatingSurfaceSize();

    /* loaded from: classes.dex */
    public static class MeteringRepeatingConfig implements UseCaseConfig<UseCase> {
        @NonNull
        private final Config mConfig;

        public MeteringRepeatingConfig() {
            MutableOptionsBundle create = MutableOptionsBundle.create();
            create.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, new Camera2SessionOptionUnpacker());
            this.mConfig = create;
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

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ SessionConfig getDefaultSessionConfig() {
            return g0.$default$getDefaultSessionConfig(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
            return g0.$default$getDefaultSessionConfig(this, sessionConfig);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig
        public /* synthetic */ int getInputFormat() {
            int intValue;
            intValue = ((Integer) retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
            return intValue;
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

        @Override // androidx.camera.core.internal.UseCaseEventConfig
        public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback() {
            return g.$default$getUseCaseEventCallback(this);
        }

        @Override // androidx.camera.core.internal.UseCaseEventConfig
        public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback) {
            return g.$default$getUseCaseEventCallback(this, eventCallback);
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
    }

    public MeteringRepeatingSession(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull DisplayInfoManager displayInfoManager) {
        MeteringRepeatingConfig meteringRepeatingConfig = new MeteringRepeatingConfig();
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        Size properPreviewSize = getProperPreviewSize(cameraCharacteristicsCompat, displayInfoManager);
        Logger.d(TAG, "MeteringSession SurfaceTexture size: " + properPreviewSize);
        surfaceTexture.setDefaultBufferSize(properPreviewSize.getWidth(), properPreviewSize.getHeight());
        final Surface surface = new Surface(surfaceTexture);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(meteringRepeatingConfig);
        createFrom.setTemplateType(1);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        this.mDeferrableSurface = immediateSurface;
        Futures.addCallback(immediateSurface.getTerminationFuture(), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.MeteringRepeatingSession.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r1) {
                surface.release();
                surfaceTexture.release();
            }
        }, CameraXExecutors.directExecutor());
        createFrom.addSurface(this.mDeferrableSurface);
        this.mSessionConfig = createFrom.build();
    }

    @NonNull
    private Size getProperPreviewSize(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull DisplayInfoManager displayInfoManager) {
        Size[] outputSizes;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            Logger.e(TAG, "Can not retrieve SCALER_STREAM_CONFIGURATION_MAP.");
            return new Size(0, 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        } else {
            outputSizes = streamConfigurationMap.getOutputSizes(34);
        }
        if (outputSizes == null) {
            Logger.e(TAG, "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] supportedSizes = this.mSupportedRepeatingSurfaceSize.getSupportedSizes(outputSizes);
        List asList = Arrays.asList(supportedSizes);
        Collections.sort(asList, j1.a);
        Size previewSize = displayInfoManager.getPreviewSize();
        long min = Math.min(previewSize.getWidth() * previewSize.getHeight(), 307200L);
        Size size = null;
        int length = supportedSizes.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            Size size2 = supportedSizes[i2];
            int i3 = ((size2.getWidth() * size2.getHeight()) > min ? 1 : ((size2.getWidth() * size2.getHeight()) == min ? 0 : -1));
            if (i3 == 0) {
                return size2;
            }
            if (i3 <= 0) {
                i2++;
                size = size2;
            } else if (size != null) {
                return size;
            }
        }
        return (Size) asList.get(0);
    }

    public void clear() {
        Logger.d(TAG, "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = null;
    }

    @NonNull
    public String getName() {
        return TAG;
    }

    @NonNull
    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }
}
