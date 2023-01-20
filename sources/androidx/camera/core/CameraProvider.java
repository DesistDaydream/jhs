package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraProvider {
    @NonNull
    List<CameraInfo> getAvailableCameraInfos();

    boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException;
}
