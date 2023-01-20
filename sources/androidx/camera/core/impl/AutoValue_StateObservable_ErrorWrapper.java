package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.StateObservable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AutoValue_StateObservable_ErrorWrapper extends StateObservable.ErrorWrapper {
    private final Throwable error;

    public AutoValue_StateObservable_ErrorWrapper(Throwable th) {
        Objects.requireNonNull(th, "Null error");
        this.error = th;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StateObservable.ErrorWrapper) {
            return this.error.equals(((StateObservable.ErrorWrapper) obj).getError());
        }
        return false;
    }

    @Override // androidx.camera.core.impl.StateObservable.ErrorWrapper
    @NonNull
    public Throwable getError() {
        return this.error;
    }

    public int hashCode() {
        return this.error.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.error + "}";
    }
}
