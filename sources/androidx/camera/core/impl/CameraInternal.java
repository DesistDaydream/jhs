package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import e.j.c.a.a.a;
import java.util.Collection;
import java.util.LinkedHashSet;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    /* loaded from: classes.dex */
    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);
        
        private final boolean mHoldsCameraSlot;

        State(boolean z) {
            this.mHoldsCameraSlot = z;
        }

        public boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }
    }

    void attachUseCases(@NonNull Collection<UseCase> collection);

    void close();

    void detachUseCases(@NonNull Collection<UseCase> collection);

    @Override // androidx.camera.core.Camera
    @NonNull
    CameraControl getCameraControl();

    @NonNull
    CameraControlInternal getCameraControlInternal();

    @Override // androidx.camera.core.Camera
    @NonNull
    CameraInfo getCameraInfo();

    @NonNull
    CameraInfoInternal getCameraInfoInternal();

    @Override // androidx.camera.core.Camera
    @NonNull
    LinkedHashSet<CameraInternal> getCameraInternals();

    @NonNull
    Observable<State> getCameraState();

    @Override // androidx.camera.core.Camera
    @NonNull
    CameraConfig getExtendedConfig();

    void open();

    @NonNull
    a<Void> release();

    void setActiveResumingMode(boolean z);

    @Override // androidx.camera.core.Camera
    void setExtendedConfig(@Nullable CameraConfig cameraConfig);
}
