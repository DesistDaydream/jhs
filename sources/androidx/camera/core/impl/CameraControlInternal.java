package androidx.camera.core.impl;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import e.j.c.a.a.a;
import java.util.Collections;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraControlInternal extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = new CameraControlInternal() { // from class: androidx.camera.core.impl.CameraControlInternal.1
        @Override // androidx.camera.core.impl.CameraControlInternal
        public void addInteropConfig(@NonNull Config config) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void addZslConfig(@NonNull Size size, @NonNull SessionConfig.Builder builder) {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Void> cancelFocusAndMetering() {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void clearInteropConfig() {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Void> enableTorch(boolean z) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public int getFlashMode() {
            return 2;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public Config getInteropConfig() {
            return null;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public Rect getSensorRect() {
            return new Rect();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public SessionConfig getSessionConfig() {
            return SessionConfig.defaultEmptySessionConfig();
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Integer> setExposureCompensationIndex(int i2) {
            return Futures.immediateFuture(0);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void setFlashMode(int i2) {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Void> setLinearZoom(float f2) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Void> setZoomRatio(float f2) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void setZslDisabled(boolean z) {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
            return Futures.immediateFuture(FocusMeteringResult.emptyInstance());
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public a<List<Void>> submitStillCaptureRequests(@NonNull List<CaptureConfig> list, int i2, int i3) {
            return Futures.immediateFuture(Collections.emptyList());
        }
    };

    /* loaded from: classes.dex */
    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(@NonNull List<CaptureConfig> list);

        void onCameraControlUpdateSessionConfig();
    }

    void addInteropConfig(@NonNull Config config);

    void addZslConfig(@NonNull Size size, @NonNull SessionConfig.Builder builder);

    void clearInteropConfig();

    int getFlashMode();

    @NonNull
    Config getInteropConfig();

    @NonNull
    Rect getSensorRect();

    @NonNull
    SessionConfig getSessionConfig();

    void setFlashMode(int i2);

    void setZslDisabled(boolean z);

    @NonNull
    a<List<Void>> submitStillCaptureRequests(@NonNull List<CaptureConfig> list, int i2, int i3);

    /* loaded from: classes.dex */
    public static final class CameraControlException extends Exception {
        @NonNull
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraControlException(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }

        @NonNull
        public CameraCaptureFailure getCameraCaptureFailure() {
            return this.mCameraCaptureFailure;
        }

        public CameraControlException(@NonNull CameraCaptureFailure cameraCaptureFailure, @NonNull Throwable th) {
            super(th);
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }
    }
}
