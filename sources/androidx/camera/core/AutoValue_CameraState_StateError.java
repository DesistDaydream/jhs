package androidx.camera.core;

import androidx.annotation.Nullable;
import androidx.camera.core.CameraState;

/* loaded from: classes.dex */
public final class AutoValue_CameraState_StateError extends CameraState.StateError {
    private final Throwable cause;
    private final int code;

    public AutoValue_CameraState_StateError(int i2, @Nullable Throwable th) {
        this.code = i2;
        this.cause = th;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CameraState.StateError) {
            CameraState.StateError stateError = (CameraState.StateError) obj;
            if (this.code == stateError.getCode()) {
                Throwable th = this.cause;
                if (th == null) {
                    if (stateError.getCause() == null) {
                        return true;
                    }
                } else if (th.equals(stateError.getCause())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // androidx.camera.core.CameraState.StateError
    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // androidx.camera.core.CameraState.StateError
    public int getCode() {
        return this.code;
    }

    public int hashCode() {
        int i2 = (this.code ^ 1000003) * 1000003;
        Throwable th = this.cause;
        return i2 ^ (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "StateError{code=" + this.code + ", cause=" + this.cause + "}";
    }
}
