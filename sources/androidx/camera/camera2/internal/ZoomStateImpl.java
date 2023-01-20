package androidx.camera.camera2.internal;

import androidx.annotation.RequiresApi;
import androidx.camera.core.ZoomState;
import androidx.core.math.MathUtils;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ZoomStateImpl implements ZoomState {
    private float mLinearZoom;
    private final float mMaxZoomRatio;
    private final float mMinZoomRatio;
    private float mZoomRatio;

    public ZoomStateImpl(float f2, float f3) {
        this.mMaxZoomRatio = f2;
        this.mMinZoomRatio = f3;
    }

    private float getPercentageByRatio(float f2) {
        float f3 = this.mMaxZoomRatio;
        float f4 = this.mMinZoomRatio;
        if (f3 == f4) {
            return 0.0f;
        }
        if (f2 == f3) {
            return 1.0f;
        }
        if (f2 == f4) {
            return 0.0f;
        }
        float f5 = 1.0f / f4;
        return ((1.0f / f2) - f5) / ((1.0f / f3) - f5);
    }

    private float getRatioByPercentage(float f2) {
        if (f2 == 1.0f) {
            return this.mMaxZoomRatio;
        }
        if (f2 == 0.0f) {
            return this.mMinZoomRatio;
        }
        float f3 = this.mMaxZoomRatio;
        float f4 = this.mMinZoomRatio;
        double d2 = 1.0f / f4;
        return (float) MathUtils.clamp(1.0d / (d2 + (((1.0f / f3) - d2) * f2)), f4, f3);
    }

    @Override // androidx.camera.core.ZoomState
    public float getLinearZoom() {
        return this.mLinearZoom;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.mMaxZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.mMinZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    public void setLinearZoom(float f2) throws IllegalArgumentException {
        if (f2 <= 1.0f && f2 >= 0.0f) {
            this.mLinearZoom = f2;
            this.mZoomRatio = getRatioByPercentage(f2);
            return;
        }
        throw new IllegalArgumentException("Requested linearZoom " + f2 + " is not within valid range [0..1]");
    }

    public void setZoomRatio(float f2) throws IllegalArgumentException {
        if (f2 <= this.mMaxZoomRatio && f2 >= this.mMinZoomRatio) {
            this.mZoomRatio = f2;
            this.mLinearZoom = getPercentageByRatio(f2);
            return;
        }
        throw new IllegalArgumentException("Requested zoomRatio " + f2 + " is not within valid range [" + this.mMinZoomRatio + " , " + this.mMaxZoomRatio + "]");
    }
}
