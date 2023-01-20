package c.b.b.b2;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* compiled from: UseCaseConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 {
    @Nullable
    public static CameraSelector $default$getCameraSelector(@Nullable UseCaseConfig _this, CameraSelector cameraSelector) {
        return (CameraSelector) _this.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
    }

    @Nullable
    public static CaptureConfig.OptionUnpacker $default$getCaptureOptionUnpacker(@Nullable UseCaseConfig _this, CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker) _this.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
    }

    @Nullable
    public static CaptureConfig $default$getDefaultCaptureConfig(@Nullable UseCaseConfig _this, CaptureConfig captureConfig) {
        return (CaptureConfig) _this.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
    }

    @Nullable
    public static SessionConfig $default$getDefaultSessionConfig(@Nullable UseCaseConfig _this, SessionConfig sessionConfig) {
        return (SessionConfig) _this.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
    }

    @Nullable
    public static SessionConfig.OptionUnpacker $default$getSessionOptionUnpacker(@Nullable UseCaseConfig _this, SessionConfig.OptionUnpacker optionUnpacker) {
        return (SessionConfig.OptionUnpacker) _this.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
    }

    @Nullable
    public static Range $default$getTargetFramerate(@Nullable UseCaseConfig _this, Range range) {
        return (Range) _this.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, range);
    }

    @NonNull
    public static CameraSelector $default$getCameraSelector(UseCaseConfig _this) {
        return (CameraSelector) _this.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR);
    }

    @NonNull
    public static CaptureConfig.OptionUnpacker $default$getCaptureOptionUnpacker(UseCaseConfig _this) {
        return (CaptureConfig.OptionUnpacker) _this.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
    }

    @NonNull
    public static CaptureConfig $default$getDefaultCaptureConfig(UseCaseConfig _this) {
        return (CaptureConfig) _this.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
    }

    @NonNull
    public static SessionConfig $default$getDefaultSessionConfig(UseCaseConfig _this) {
        return (SessionConfig) _this.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
    }

    @NonNull
    public static SessionConfig.OptionUnpacker $default$getSessionOptionUnpacker(UseCaseConfig _this) {
        return (SessionConfig.OptionUnpacker) _this.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
    }

    @NonNull
    public static Range $default$getTargetFramerate(UseCaseConfig _this) {
        return (Range) _this.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE);
    }
}
