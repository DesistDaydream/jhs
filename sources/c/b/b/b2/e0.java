package c.b.b.b2;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.ImageOutputConfig;
import java.util.List;

/* compiled from: ImageOutputConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class e0 {
    @Nullable
    public static Size $default$getDefaultResolution(@Nullable ImageOutputConfig _this, Size size) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
    }

    @Nullable
    public static Size $default$getMaxResolution(@Nullable ImageOutputConfig _this, Size size) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
    }

    @Nullable
    public static List $default$getSupportedResolutions(@Nullable ImageOutputConfig _this, List list) {
        return (List) _this.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
    }

    @Nullable
    public static Size $default$getTargetResolution(@Nullable ImageOutputConfig _this, Size size) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
    }

    @NonNull
    public static Size $default$getDefaultResolution(ImageOutputConfig _this) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION);
    }

    @NonNull
    public static Size $default$getMaxResolution(ImageOutputConfig _this) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
    }

    @NonNull
    public static List $default$getSupportedResolutions(ImageOutputConfig _this) {
        return (List) _this.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS);
    }

    @NonNull
    public static Size $default$getTargetResolution(ImageOutputConfig _this) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
    }
}
