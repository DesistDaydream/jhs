package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraInfo;
import c.b.b.b2.a;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraConfigProvider {
    public static final CameraConfigProvider EMPTY = a.a;

    @Nullable
    CameraConfig getConfig(@NonNull CameraInfo cameraInfo, @NonNull Context context);
}
