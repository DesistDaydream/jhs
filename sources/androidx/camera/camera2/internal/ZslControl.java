package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.SessionConfig;

/* loaded from: classes.dex */
public interface ZslControl {
    void addZslConfig(@NonNull Size size, @NonNull SessionConfig.Builder builder);

    @Nullable
    ImageProxy dequeueImageFromBuffer();

    boolean enqueueImageToImageWriter(@NonNull ImageProxy imageProxy);

    void setZslDisabled(boolean z);
}
