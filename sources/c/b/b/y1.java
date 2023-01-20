package c.b.b;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.FocusMeteringAction;

/* compiled from: CameraInfo.java */
/* loaded from: classes.dex */
public final /* synthetic */ class y1 {
    public static boolean $default$isFocusMeteringSupported(@NonNull CameraInfo cameraInfo, FocusMeteringAction focusMeteringAction) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean $default$isPrivateReprocessingSupported(CameraInfo cameraInfo) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean $default$isYuvReprocessingSupported(CameraInfo cameraInfo) {
        return false;
    }
}
