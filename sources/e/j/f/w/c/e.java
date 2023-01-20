package e.j.f.w.c;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    private static final int f11745c = 21522;

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f11746d = {new int[]{f11745c, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    private final ErrorCorrectionLevel a;
    private final byte b;

    private e(int i2) {
        this.a = ErrorCorrectionLevel.forBits((i2 >> 3) & 3);
        this.b = (byte) (i2 & 7);
    }

    public static e a(int i2, int i3) {
        e b = b(i2, i3);
        return b != null ? b : b(i2 ^ f11745c, i3 ^ f11745c);
    }

    private static e b(int i2, int i3) {
        int[][] iArr;
        int e2;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int[] iArr2 : f11746d) {
            int i6 = iArr2[0];
            if (i6 != i2 && i6 != i3) {
                int e3 = e(i2, i6);
                if (e3 < i4) {
                    i5 = iArr2[1];
                    i4 = e3;
                }
                if (i2 != i3 && (e2 = e(i3, i6)) < i4) {
                    i5 = iArr2[1];
                    i4 = e2;
                }
            } else {
                return new e(iArr2[1]);
            }
        }
        if (i4 <= 3) {
            return new e(i5);
        }
        return null;
    }

    public static int e(int i2, int i3) {
        return Integer.bitCount(i2 ^ i3);
    }

    public byte c() {
        return this.b;
    }

    public ErrorCorrectionLevel d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.a == eVar.a && this.b == eVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.ordinal() << 3) | this.b;
    }
}
