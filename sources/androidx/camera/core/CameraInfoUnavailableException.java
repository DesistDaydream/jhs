package androidx.camera.core;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraInfoUnavailableException extends Exception {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInfoUnavailableException(String str, Throwable th) {
        super(str, th);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInfoUnavailableException(String str) {
        super(str);
    }
}
