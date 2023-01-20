package androidx.camera.camera2.internal.compat.quirk;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CamcorderProfileResolutionQuirk implements Quirk {
    private static final String TAG = "CamcorderProfileResolutionQuirk";
    private final List<Size> mSupportedResolutions;

    public CamcorderProfileResolutionQuirk(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        List<Size> emptyList;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            Logger.e(TAG, "StreamConfigurationMap is null");
        }
        Size[] sizeArr = null;
        if (Build.VERSION.SDK_INT < 23) {
            if (streamConfigurationMap != null) {
                sizeArr = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
            }
        } else if (streamConfigurationMap != null) {
            sizeArr = streamConfigurationMap.getOutputSizes(34);
        }
        if (sizeArr != null) {
            emptyList = Arrays.asList((Size[]) sizeArr.clone());
        } else {
            emptyList = Collections.emptyList();
        }
        this.mSupportedResolutions = emptyList;
        Logger.d(TAG, "mSupportedResolutions = " + emptyList);
    }

    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    @NonNull
    public List<Size> getSupportedResolutions() {
        return new ArrayList(this.mSupportedResolutions);
    }
}
