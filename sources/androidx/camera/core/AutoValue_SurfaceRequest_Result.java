package androidx.camera.core;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AutoValue_SurfaceRequest_Result extends SurfaceRequest.Result {
    private final int resultCode;
    private final Surface surface;

    public AutoValue_SurfaceRequest_Result(int i2, Surface surface) {
        this.resultCode = i2;
        Objects.requireNonNull(surface, "Null surface");
        this.surface = surface;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceRequest.Result) {
            SurfaceRequest.Result result = (SurfaceRequest.Result) obj;
            return this.resultCode == result.getResultCode() && this.surface.equals(result.getSurface());
        }
        return false;
    }

    @Override // androidx.camera.core.SurfaceRequest.Result
    public int getResultCode() {
        return this.resultCode;
    }

    @Override // androidx.camera.core.SurfaceRequest.Result
    @NonNull
    public Surface getSurface() {
        return this.surface;
    }

    public int hashCode() {
        return ((this.resultCode ^ 1000003) * 1000003) ^ this.surface.hashCode();
    }

    public String toString() {
        return "Result{resultCode=" + this.resultCode + ", surface=" + this.surface + "}";
    }
}
