package androidx.camera.core;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ZoomState {
    float getLinearZoom();

    float getMaxZoomRatio();

    float getMinZoomRatio();

    float getZoomRatio();
}
