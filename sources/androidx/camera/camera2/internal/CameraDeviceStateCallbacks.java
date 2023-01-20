package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraDeviceStateCallbacks {

    /* loaded from: classes.dex */
    public static final class ComboDeviceStateCallback extends CameraDevice.StateCallback {
        private final List<CameraDevice.StateCallback> mCallbacks = new ArrayList();

        public ComboDeviceStateCallback(@NonNull List<CameraDevice.StateCallback> list) {
            for (CameraDevice.StateCallback stateCallback : list) {
                if (!(stateCallback instanceof NoOpDeviceStateCallback)) {
                    this.mCallbacks.add(stateCallback);
                }
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback stateCallback : this.mCallbacks) {
                stateCallback.onClosed(cameraDevice);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback stateCallback : this.mCallbacks) {
                stateCallback.onDisconnected(cameraDevice);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            for (CameraDevice.StateCallback stateCallback : this.mCallbacks) {
                stateCallback.onError(cameraDevice, i2);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback stateCallback : this.mCallbacks) {
                stateCallback.onOpened(cameraDevice);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class NoOpDeviceStateCallback extends CameraDevice.StateCallback {
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
        }
    }

    private CameraDeviceStateCallbacks() {
    }

    @NonNull
    public static CameraDevice.StateCallback createComboCallback(@NonNull List<CameraDevice.StateCallback> list) {
        if (list.isEmpty()) {
            return createNoOpCallback();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new ComboDeviceStateCallback(list);
    }

    @NonNull
    public static CameraDevice.StateCallback createNoOpCallback() {
        return new NoOpDeviceStateCallback();
    }

    @NonNull
    public static CameraDevice.StateCallback createComboCallback(@NonNull CameraDevice.StateCallback... stateCallbackArr) {
        return createComboCallback(Arrays.asList(stateCallbackArr));
    }
}
