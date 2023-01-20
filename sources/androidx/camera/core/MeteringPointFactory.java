package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class MeteringPointFactory {
    @Nullable
    private Rational mSurfaceAspectRatio;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MeteringPointFactory() {
        this(null);
    }

    public static float getDefaultPointSize() {
        return 0.15f;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract PointF convertPoint(float f2, float f3);

    @NonNull
    public final MeteringPoint createPoint(float f2, float f3) {
        return createPoint(f2, f3, getDefaultPointSize());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MeteringPointFactory(@Nullable Rational rational) {
        this.mSurfaceAspectRatio = rational;
    }

    @NonNull
    public final MeteringPoint createPoint(float f2, float f3, float f4) {
        PointF convertPoint = convertPoint(f2, f3);
        return new MeteringPoint(convertPoint.x, convertPoint.y, f4, this.mSurfaceAspectRatio);
    }
}
