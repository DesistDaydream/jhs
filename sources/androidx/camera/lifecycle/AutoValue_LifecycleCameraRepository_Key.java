package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.lifecycle.LifecycleOwner;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AutoValue_LifecycleCameraRepository_Key extends LifecycleCameraRepository.Key {
    private final CameraUseCaseAdapter.CameraId cameraId;
    private final LifecycleOwner lifecycleOwner;

    public AutoValue_LifecycleCameraRepository_Key(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        Objects.requireNonNull(lifecycleOwner, "Null lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        Objects.requireNonNull(cameraId, "Null cameraId");
        this.cameraId = cameraId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LifecycleCameraRepository.Key) {
            LifecycleCameraRepository.Key key = (LifecycleCameraRepository.Key) obj;
            return this.lifecycleOwner.equals(key.getLifecycleOwner()) && this.cameraId.equals(key.getCameraId());
        }
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    @NonNull
    public CameraUseCaseAdapter.CameraId getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    @NonNull
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public int hashCode() {
        return ((this.lifecycleOwner.hashCode() ^ 1000003) * 1000003) ^ this.cameraId.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.lifecycleOwner + ", cameraId=" + this.cameraId + "}";
    }
}
