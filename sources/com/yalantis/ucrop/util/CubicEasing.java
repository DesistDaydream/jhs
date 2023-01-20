package com.yalantis.ucrop.util;

/* loaded from: classes3.dex */
public final class CubicEasing {
    public static float easeIn(float f2, float f3, float f4, float f5) {
        float f6 = f2 / f5;
        return (f4 * f6 * f6 * f6) + f3;
    }

    public static float easeInOut(float f2, float f3, float f4, float f5) {
        float f6;
        float f7 = f2 / (f5 / 2.0f);
        float f8 = f4 / 2.0f;
        if (f7 < 1.0f) {
            f6 = f8 * f7 * f7 * f7;
        } else {
            float f9 = f7 - 2.0f;
            f6 = f8 * ((f9 * f9 * f9) + 2.0f);
        }
        return f6 + f3;
    }

    public static float easeOut(float f2, float f3, float f4, float f5) {
        float f6 = (f2 / f5) - 1.0f;
        return (f4 * ((f6 * f6 * f6) + 1.0f)) + f3;
    }
}
