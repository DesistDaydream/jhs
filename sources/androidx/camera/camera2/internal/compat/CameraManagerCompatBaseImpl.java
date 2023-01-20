package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.core.util.Preconditions;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CameraManagerCompatBaseImpl implements CameraManagerCompat.CameraManagerCompatImpl {
    public final CameraManager mCameraManager;
    public final Object mObject;

    /* loaded from: classes.dex */
    public static final class CameraManagerCompatParamsApi21 {
        public final Handler mCompatHandler;
        @GuardedBy("mWrapperMap")
        public final Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> mWrapperMap = new HashMap();

        public CameraManagerCompatParamsApi21(@NonNull Handler handler) {
            this.mCompatHandler = handler;
        }
    }

    public CameraManagerCompatBaseImpl(@NonNull Context context, @Nullable Object obj) {
        this.mCameraManager = (CameraManager) context.getSystemService("camera");
        this.mObject = obj;
    }

    public static CameraManagerCompatBaseImpl create(@NonNull Context context, @NonNull Handler handler) {
        return new CameraManagerCompatBaseImpl(context, new CameraManagerCompatParamsApi21(handler));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public CameraCharacteristics getCameraCharacteristics(@NonNull String str) throws CameraAccessExceptionCompat {
        try {
            return this.mCameraManager.getCameraCharacteristics(str);
        } catch (CameraAccessException e2) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e2);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public String[] getCameraIdList() throws CameraAccessExceptionCompat {
        try {
            return this.mCameraManager.getCameraIdList();
        } catch (CameraAccessException e2) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e2);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public CameraManager getCameraManager() {
        return this.mCameraManager;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @RequiresPermission(PermissionConstants.CAMERA)
    public void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(stateCallback);
        try {
            this.mCameraManager.openCamera(str, new CameraDeviceCompat.StateCallbackExecutorWrapper(executor, stateCallback), ((CameraManagerCompatParamsApi21) this.mObject).mCompatHandler);
        } catch (CameraAccessException e2) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e2);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        if (executor != null) {
            CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper = null;
            CameraManagerCompatParamsApi21 cameraManagerCompatParamsApi21 = (CameraManagerCompatParamsApi21) this.mObject;
            if (availabilityCallback != null) {
                synchronized (cameraManagerCompatParamsApi21.mWrapperMap) {
                    availabilityCallbackExecutorWrapper = cameraManagerCompatParamsApi21.mWrapperMap.get(availabilityCallback);
                    if (availabilityCallbackExecutorWrapper == null) {
                        availabilityCallbackExecutorWrapper = new CameraManagerCompat.AvailabilityCallbackExecutorWrapper(executor, availabilityCallback);
                        cameraManagerCompatParamsApi21.mWrapperMap.put(availabilityCallback, availabilityCallbackExecutorWrapper);
                    }
                }
            }
            this.mCameraManager.registerAvailabilityCallback(availabilityCallbackExecutorWrapper, cameraManagerCompatParamsApi21.mCompatHandler);
            return;
        }
        throw new IllegalArgumentException("executor was null");
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper;
        if (availabilityCallback != null) {
            CameraManagerCompatParamsApi21 cameraManagerCompatParamsApi21 = (CameraManagerCompatParamsApi21) this.mObject;
            synchronized (cameraManagerCompatParamsApi21.mWrapperMap) {
                availabilityCallbackExecutorWrapper = cameraManagerCompatParamsApi21.mWrapperMap.remove(availabilityCallback);
            }
        } else {
            availabilityCallbackExecutorWrapper = null;
        }
        if (availabilityCallbackExecutorWrapper != null) {
            availabilityCallbackExecutorWrapper.setDisabled();
        }
        this.mCameraManager.unregisterAvailabilityCallback(availabilityCallbackExecutorWrapper);
    }
}
