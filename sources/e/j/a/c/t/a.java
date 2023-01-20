package e.j.a.c.t;

/* loaded from: classes2.dex */
public final class a {
    public static final float a = 1.0E-4f;

    private a() {
    }

    public static float a(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot(f4 - f2, f5 - f3);
    }

    public static float b(float f2, float f3, float f4, float f5, float f6, float f7) {
        return g(a(f2, f3, f4, f5), a(f2, f3, f6, f5), a(f2, f3, f6, f7), a(f2, f3, f4, f7));
    }

    public static float c(float f2, int i2) {
        float f3 = i2;
        int i3 = (int) (f2 / f3);
        if (Math.signum(f2) * f3 < 0.0f && i3 * i2 != f2) {
            i3--;
        }
        return f2 - (i3 * i2);
    }

    public static int d(int i2, int i3) {
        int i4 = i2 / i3;
        if ((i2 ^ i3) < 0 && i4 * i3 != i2) {
            i4--;
        }
        return i2 - (i4 * i3);
    }

    public static boolean e(float f2, float f3, float f4) {
        return f2 + f4 >= f3;
    }

    public static float f(float f2, float f3, float f4) {
        return ((1.0f - f4) * f2) + (f4 * f3);
    }

    private static float g(float f2, float f3, float f4, float f5) {
        return (f2 <= f3 || f2 <= f4 || f2 <= f5) ? (f3 <= f4 || f3 <= f5) ? f4 > f5 ? f4 : f5 : f3 : f2;
    }
}
