package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CameraDeviceCompatBaseImpl implements CameraDeviceCompat.CameraDeviceCompatImpl {
    public final CameraDevice mCameraDevice;
    public final Object mImplParams;

    /* loaded from: classes.dex */
    public static class CameraDeviceCompatParamsApi21 {
        public final Handler mCompatHandler;

        public CameraDeviceCompatParamsApi21(@NonNull Handler handler) {
            this.mCompatHandler = handler;
        }
    }

    public CameraDeviceCompatBaseImpl(@NonNull CameraDevice cameraDevice, @Nullable Object obj) {
        this.mCameraDevice = (CameraDevice) Preconditions.checkNotNull(cameraDevice);
        this.mImplParams = obj;
    }

    private static void checkPhysicalCameraIdValid(CameraDevice cameraDevice, @NonNull List<OutputConfigurationCompat> list) {
        String id = cameraDevice.getId();
        for (OutputConfigurationCompat outputConfigurationCompat : list) {
            String physicalCameraId = outputConfigurationCompat.getPhysicalCameraId();
            if (physicalCameraId != null && !physicalCameraId.isEmpty()) {
                Logger.w("CameraDeviceCompat", "Camera " + id + ": Camera doesn't support physicalCameraId " + physicalCameraId + ". Ignoring.");
            }
        }
    }

    public static void checkPreconditions(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) {
        Preconditions.checkNotNull(cameraDevice);
        Preconditions.checkNotNull(sessionConfigurationCompat);
        Preconditions.checkNotNull(sessionConfigurationCompat.getStateCallback());
        List<OutputConfigurationCompat> outputConfigurations = sessionConfigurationCompat.getOutputConfigurations();
        if (outputConfigurations != null) {
            if (sessionConfigurationCompat.getExecutor() != null) {
                checkPhysicalCameraIdValid(cameraDevice, outputConfigurations);
                return;
            }
            throw new IllegalArgumentException("Invalid executor");
        }
        throw new IllegalArgumentException("Invalid output configurations");
    }

    public static CameraDeviceCompatBaseImpl create(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        return new CameraDeviceCompatBaseImpl(cameraDevice, new CameraDeviceCompatParamsApi21(handler));
    }

    public static List<Surface> unpackSurfaces(@NonNull List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (OutputConfigurationCompat outputConfigurationCompat : list) {
            arrayList.add(outputConfigurationCompat.getSurface());
        }
        return arrayList;
    }

    public void createBaseCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull List<Surface> list, @NonNull CameraCaptureSession.StateCallback stateCallback, @NonNull Handler handler) throws CameraAccessExceptionCompat {
        try {
            cameraDevice.createCaptureSession(list, stateCallback, handler);
        } catch (CameraAccessException e2) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e2);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(@NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        checkPreconditions(this.mCameraDevice, sessionConfigurationCompat);
        if (sessionConfigurationCompat.getInputConfiguration() == null) {
            if (sessionConfigurationCompat.getSessionType() != 1) {
                CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(sessionConfigurationCompat.getExecutor(), sessionConfigurationCompat.getStateCallback());
                createBaseCaptureSession(this.mCameraDevice, unpackSurfaces(sessionConfigurationCompat.getOutputConfigurations()), stateCallbackExecutorWrapper, ((CameraDeviceCompatParamsApi21) this.mImplParams).mCompatHandler);
                return;
            }
            throw new IllegalArgumentException("High speed capture sessions not supported until API 23");
        }
        throw new IllegalArgumentException("Reprocessing sessions not supported until API 23");
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    @NonNull
    public CameraDevice unwrap() {
        return this.mCameraDevice;
    }
}
