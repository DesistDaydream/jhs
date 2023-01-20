package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.core.Logger;
import java.nio.BufferUnderflowException;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class FlashAvailabilityChecker {
    private static final String TAG = "FlashAvailability";

    private FlashAvailabilityChecker() {
    }

    private static boolean checkFlashAvailabilityNormally(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Boolean bool = (Boolean) cameraCharacteristicsCompat.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null) {
            Logger.w(TAG, "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static boolean checkFlashAvailabilityWithPossibleBufferUnderflow(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        try {
            return checkFlashAvailabilityNormally(cameraCharacteristicsCompat);
        } catch (BufferUnderflowException unused) {
            return false;
        }
    }

    public static boolean isFlashAvailable(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        if (DeviceQuirks.get(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
            Logger.d(TAG, "Device has quirk " + FlashAvailabilityBufferUnderflowQuirk.class.getSimpleName() + ". Checking for flash availability safely...");
            return checkFlashAvailabilityWithPossibleBufferUnderflow(cameraCharacteristicsCompat);
        }
        return checkFlashAvailabilityNormally(cameraCharacteristicsCompat);
    }
}
