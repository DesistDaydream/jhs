package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ExcludedSupportedSizesContainer {
    @NonNull
    private final String mCameraId;

    public ExcludedSupportedSizesContainer(@NonNull String str) {
        this.mCameraId = str;
    }

    @NonNull
    public List<Size> get(int i2) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk) DeviceQuirks.get(ExcludedSupportedSizesQuirk.class);
        if (excludedSupportedSizesQuirk == null) {
            return new ArrayList();
        }
        return excludedSupportedSizesQuirk.getExcludedSizes(this.mCameraId, i2);
    }
}
