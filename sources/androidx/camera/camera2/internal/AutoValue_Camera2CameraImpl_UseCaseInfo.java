package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.impl.SessionConfig;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AutoValue_Camera2CameraImpl_UseCaseInfo extends Camera2CameraImpl.UseCaseInfo {
    private final SessionConfig sessionConfig;
    private final Size surfaceResolution;
    private final String useCaseId;
    private final Class<?> useCaseType;

    public AutoValue_Camera2CameraImpl_UseCaseInfo(String str, Class<?> cls, SessionConfig sessionConfig, @Nullable Size size) {
        Objects.requireNonNull(str, "Null useCaseId");
        this.useCaseId = str;
        Objects.requireNonNull(cls, "Null useCaseType");
        this.useCaseType = cls;
        Objects.requireNonNull(sessionConfig, "Null sessionConfig");
        this.sessionConfig = sessionConfig;
        this.surfaceResolution = size;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Camera2CameraImpl.UseCaseInfo) {
            Camera2CameraImpl.UseCaseInfo useCaseInfo = (Camera2CameraImpl.UseCaseInfo) obj;
            if (this.useCaseId.equals(useCaseInfo.getUseCaseId()) && this.useCaseType.equals(useCaseInfo.getUseCaseType()) && this.sessionConfig.equals(useCaseInfo.getSessionConfig())) {
                Size size = this.surfaceResolution;
                if (size == null) {
                    if (useCaseInfo.getSurfaceResolution() == null) {
                        return true;
                    }
                } else if (size.equals(useCaseInfo.getSurfaceResolution())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    @NonNull
    public SessionConfig getSessionConfig() {
        return this.sessionConfig;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    @Nullable
    public Size getSurfaceResolution() {
        return this.surfaceResolution;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    @NonNull
    public String getUseCaseId() {
        return this.useCaseId;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    @NonNull
    public Class<?> getUseCaseType() {
        return this.useCaseType;
    }

    public int hashCode() {
        int hashCode = (((((this.useCaseId.hashCode() ^ 1000003) * 1000003) ^ this.useCaseType.hashCode()) * 1000003) ^ this.sessionConfig.hashCode()) * 1000003;
        Size size = this.surfaceResolution;
        return hashCode ^ (size == null ? 0 : size.hashCode());
    }

    public String toString() {
        return "UseCaseInfo{useCaseId=" + this.useCaseId + ", useCaseType=" + this.useCaseType + ", sessionConfig=" + this.sessionConfig + ", surfaceResolution=" + this.surfaceResolution + "}";
    }
}
