package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class UseCaseConfigUtil {
    private UseCaseConfigUtil() {
    }

    public static void updateTargetRotationAndRelatedConfigs(@NonNull UseCaseConfig.Builder<?, ?, ?> builder, int i2) {
        Size targetResolution;
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) builder.getUseCaseConfig();
        int targetRotation = imageOutputConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i2) {
            ((ImageOutputConfig.Builder) builder).setTargetRotation(i2);
        }
        if (targetRotation == -1 || i2 == -1 || targetRotation == i2) {
            return;
        }
        if (Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(i2) - CameraOrientationUtil.surfaceRotationToDegrees(targetRotation)) % 180 != 90 || (targetResolution = imageOutputConfig.getTargetResolution(null)) == null) {
            return;
        }
        ((ImageOutputConfig.Builder) builder).setTargetResolution(new Size(targetResolution.getHeight(), targetResolution.getWidth()));
    }
}
