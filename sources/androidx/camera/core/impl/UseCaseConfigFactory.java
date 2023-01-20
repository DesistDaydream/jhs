package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.InitializationException;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface UseCaseConfigFactory {
    public static final UseCaseConfigFactory EMPTY_INSTANCE = new UseCaseConfigFactory() { // from class: androidx.camera.core.impl.UseCaseConfigFactory.1
        @Override // androidx.camera.core.impl.UseCaseConfigFactory
        @Nullable
        public Config getConfig(@NonNull CaptureType captureType, int i2) {
            return null;
        }
    };

    /* loaded from: classes.dex */
    public enum CaptureType {
        IMAGE_CAPTURE,
        PREVIEW,
        IMAGE_ANALYSIS,
        VIDEO_CAPTURE
    }

    /* loaded from: classes.dex */
    public interface Provider {
        @NonNull
        UseCaseConfigFactory newInstance(@NonNull Context context) throws InitializationException;
    }

    @Nullable
    Config getConfig(@NonNull CaptureType captureType, int i2);
}
