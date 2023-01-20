package com.tencent.qcloud.tuikit.tuichat.util;

/* loaded from: classes3.dex */
public class AngleUtil {
    public static int getSensorAngle(float f2, float f3) {
        if (Math.abs(f2) <= Math.abs(f3)) {
            return (f3 <= 7.0f && f3 < -7.0f) ? 180 : 0;
        } else if (f2 > 4.0f) {
            return 270;
        } else {
            return f2 < -4.0f ? 90 : 0;
        }
    }
}
