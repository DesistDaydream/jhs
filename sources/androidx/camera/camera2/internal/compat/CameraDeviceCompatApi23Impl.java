package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;
import java.util.List;

@RequiresApi(23)
/* loaded from: classes.dex */
public class CameraDeviceCompatApi23Impl extends CameraDeviceCompatBaseImpl {
    public CameraDeviceCompatApi23Impl(@NonNull CameraDevice cameraDevice, @Nullable Object obj) {
        super(cameraDevice, obj);
    }

    public static CameraDeviceCompatApi23Impl create(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        return new CameraDeviceCompatApi23Impl(cameraDevice, new CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21(handler));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(@NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        CameraDeviceCompatBaseImpl.checkPreconditions(this.mCameraDevice, sessionConfigurationCompat);
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(sessionConfigurationCompat.getExecutor(), sessionConfigurationCompat.getStateCallback());
        List<Surface> unpackSurfaces = CameraDeviceCompatBaseImpl.unpackSurfaces(sessionConfigurationCompat.getOutputConfigurations());
        Handler handler = ((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) Preconditions.checkNotNull((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) this.mImplParams)).mCompatHandler;
        InputConfigurationCompat inputConfiguration = sessionConfigurationCompat.getInputConfiguration();
        try {
            if (inputConfiguration != null) {
                InputConfiguration inputConfiguration2 = (InputConfiguration) inputConfiguration.unwrap();
                Preconditions.checkNotNull(inputConfiguration2);
                this.mCameraDevice.createReprocessableCaptureSession(inputConfiguration2, unpackSurfaces, stateCallbackExecutorWrapper, handler);
            } else if (sessionConfigurationCompat.getSessionType() == 1) {
                this.mCameraDevice.createConstrainedHighSpeedCaptureSession(unpackSurfaces, stateCallbackExecutorWrapper, handler);
            } else {
                createBaseCaptureSession(this.mCameraDevice, unpackSurfaces, stateCallbackExecutorWrapper, handler);
            }
        } catch (CameraAccessException e2) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e2);
        }
    }
}
