package androidx.camera.core;

import android.util.Rational;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(21)
/* loaded from: classes.dex */
public class MeteringPoint {
    private float mNormalizedX;
    private float mNormalizedY;
    private float mSize;
    @Nullable
    private Rational mSurfaceAspectRatio;

    public MeteringPoint(float f2, float f3, float f4, @Nullable Rational rational) {
        this.mNormalizedX = f2;
        this.mNormalizedY = f3;
        this.mSize = f4;
        this.mSurfaceAspectRatio = rational;
    }

    public float getSize() {
        return this.mSize;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Rational getSurfaceAspectRatio() {
        return this.mSurfaceAspectRatio;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getX() {
        return this.mNormalizedX;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getY() {
        return this.mNormalizedY;
    }
}
