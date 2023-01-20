package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Config;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ImageOutputConfig extends ReadableConfig {
    public static final int INVALID_ROTATION = -1;
    public static final Config.Option<Integer> OPTION_APP_TARGET_ROTATION;
    public static final Config.Option<Size> OPTION_DEFAULT_RESOLUTION;
    public static final Config.Option<Size> OPTION_MAX_RESOLUTION;
    public static final Config.Option<List<Pair<Integer, Size[]>>> OPTION_SUPPORTED_RESOLUTIONS;
    public static final Config.Option<Integer> OPTION_TARGET_ASPECT_RATIO = Config.Option.create("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);
    public static final Config.Option<Size> OPTION_TARGET_RESOLUTION;
    public static final Config.Option<Integer> OPTION_TARGET_ROTATION;
    public static final int ROTATION_NOT_SPECIFIED = -1;

    /* loaded from: classes.dex */
    public interface Builder<B> {
        @NonNull
        B setDefaultResolution(@NonNull Size size);

        @NonNull
        B setMaxResolution(@NonNull Size size);

        @NonNull
        B setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list);

        @NonNull
        B setTargetAspectRatio(int i2);

        @NonNull
        B setTargetResolution(@NonNull Size size);

        @NonNull
        B setTargetRotation(int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OptionalRotationValue {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RotationDegreesValue {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RotationValue {
    }

    static {
        Class cls = Integer.TYPE;
        OPTION_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.targetRotation", cls);
        OPTION_APP_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.appTargetRotation", cls);
        OPTION_TARGET_RESOLUTION = Config.Option.create("camerax.core.imageOutput.targetResolution", Size.class);
        OPTION_DEFAULT_RESOLUTION = Config.Option.create("camerax.core.imageOutput.defaultResolution", Size.class);
        OPTION_MAX_RESOLUTION = Config.Option.create("camerax.core.imageOutput.maxResolution", Size.class);
        OPTION_SUPPORTED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.supportedResolutions", List.class);
    }

    int getAppTargetRotation(int i2);

    @NonNull
    Size getDefaultResolution();

    @Nullable
    Size getDefaultResolution(@Nullable Size size);

    @NonNull
    Size getMaxResolution();

    @Nullable
    Size getMaxResolution(@Nullable Size size);

    @NonNull
    List<Pair<Integer, Size[]>> getSupportedResolutions();

    @Nullable
    List<Pair<Integer, Size[]>> getSupportedResolutions(@Nullable List<Pair<Integer, Size[]>> list);

    int getTargetAspectRatio();

    @NonNull
    Size getTargetResolution();

    @Nullable
    Size getTargetResolution(@Nullable Size size);

    int getTargetRotation();

    int getTargetRotation(int i2);

    boolean hasTargetAspectRatio();
}
