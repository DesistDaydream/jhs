package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import e.j.b.a.c;

@c
@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class SurfaceConfig {

    /* loaded from: classes.dex */
    public enum ConfigSize {
        ANALYSIS(0),
        PREVIEW(1),
        RECORD(2),
        MAXIMUM(3),
        NOT_SUPPORT(4);
        
        public final int mId;

        ConfigSize(int i2) {
            this.mId = i2;
        }

        public int getId() {
            return this.mId;
        }
    }

    /* loaded from: classes.dex */
    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        RAW
    }

    @NonNull
    public static SurfaceConfig create(@NonNull ConfigType configType, @NonNull ConfigSize configSize) {
        return new AutoValue_SurfaceConfig(configType, configSize);
    }

    @NonNull
    public abstract ConfigSize getConfigSize();

    @NonNull
    public abstract ConfigType getConfigType();

    public final boolean isSupported(@NonNull SurfaceConfig surfaceConfig) {
        return surfaceConfig.getConfigSize().getId() <= getConfigSize().getId() && surfaceConfig.getConfigType() == getConfigType();
    }
}
