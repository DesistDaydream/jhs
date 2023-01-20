package androidx.camera.core;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraClosedException extends RuntimeException {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraClosedException(String str, Throwable th) {
        super(str, th);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraClosedException(String str) {
        super(str);
    }
}
