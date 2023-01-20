package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import e.j.c.a.a.a;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraControl {

    /* loaded from: classes.dex */
    public static final class OperationCanceledException extends Exception {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(@NonNull String str) {
            super(str);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @NonNull
    a<Void> cancelFocusAndMetering();

    @NonNull
    a<Void> enableTorch(boolean z);

    @NonNull
    a<Integer> setExposureCompensationIndex(int i2);

    @NonNull
    a<Void> setLinearZoom(@FloatRange(from = 0.0d, to = 1.0d) float f2);

    @NonNull
    a<Void> setZoomRatio(float f2);

    @NonNull
    a<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction);
}
