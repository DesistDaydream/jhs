package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CameraCaptureFailure {
    private final Reason mReason;

    /* loaded from: classes.dex */
    public enum Reason {
        ERROR
    }

    public CameraCaptureFailure(@NonNull Reason reason) {
        this.mReason = reason;
    }

    @NonNull
    public Reason getReason() {
        return this.mReason;
    }
}
