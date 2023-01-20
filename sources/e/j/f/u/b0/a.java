package e.j.f.u.b0;

import com.google.zxing.NotFoundException;
import e.j.f.u.q;

/* loaded from: classes2.dex */
public abstract class a extends q {

    /* renamed from: g  reason: collision with root package name */
    private static final float f11574g = 0.2f;

    /* renamed from: h  reason: collision with root package name */
    private static final float f11575h = 0.45f;

    /* renamed from: i  reason: collision with root package name */
    private static final float f11576i = 0.7916667f;

    /* renamed from: j  reason: collision with root package name */
    private static final float f11577j = 0.89285713f;
    private final int[] b;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f11580e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f11581f;
    private final int[] a = new int[4];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f11578c = new float[4];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f11579d = new float[4];

    public a() {
        int[] iArr = new int[8];
        this.b = iArr;
        this.f11580e = new int[iArr.length / 2];
        this.f11581f = new int[iArr.length / 2];
    }

    @Deprecated
    public static int h(int[] iArr) {
        return e.j.f.q.l.a.d(iArr);
    }

    public static void i(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    public static void p(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    public static boolean q(int[] iArr) {
        int i2;
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + i2) + iArr[3]);
        if (f2 >= f11576i && f2 <= f11577j) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            for (int i5 : iArr) {
                if (i5 > i4) {
                    i4 = i5;
                }
                if (i5 < i3) {
                    i3 = i5;
                }
            }
            if (i4 < i3 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int r(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (q.e(iArr, iArr2[i2], f11575h) < 0.2f) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] j() {
        return this.b;
    }

    public final int[] k() {
        return this.a;
    }

    public final int[] l() {
        return this.f11581f;
    }

    public final float[] m() {
        return this.f11579d;
    }

    public final int[] n() {
        return this.f11580e;
    }

    public final float[] o() {
        return this.f11578c;
    }
}
