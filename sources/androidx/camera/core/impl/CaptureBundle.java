package androidx.camera.core.impl;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CaptureBundle {
    @Nullable
    List<CaptureStage> getCaptureStages();
}
