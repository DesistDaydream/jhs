package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    public float mDRotate;
    public float mDScaleX;
    public float mDScaleY;
    public float mDTranslateX;
    public float mDTranslateY;
    public float mRotate;

    public void applyTransform(float f2, float f3, int i2, int i3, float[] fArr) {
        float f4;
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f5 + this.mDTranslateX;
        float f9 = f6 + this.mDTranslateY;
        float f10 = f8 + (this.mDScaleX * (f2 - 0.5f) * 2.0f);
        float f11 = f9 + (this.mDScaleY * f7);
        float radians = (float) Math.toRadians(this.mDRotate);
        double radians2 = (float) Math.toRadians(this.mRotate);
        double d2 = i3 * f7;
        fArr[0] = f10 + (((float) ((((-i2) * f4) * Math.sin(radians2)) - (Math.cos(radians2) * d2))) * radians);
        fArr[1] = f11 + (radians * ((float) (((i2 * f4) * Math.cos(radians2)) - (d2 * Math.sin(radians2)))));
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f2) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f2);
            this.mRotate = splineSet.get(f2);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f2);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f2);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f2);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f2);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f2) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f2);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        if (keyCycleOscillator != null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f2);
        }
        if (keyCycleOscillator2 != null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f2);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f2);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f2);
        }
    }
}
