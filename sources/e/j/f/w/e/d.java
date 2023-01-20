package e.j.f.w.e;

/* loaded from: classes2.dex */
public final class d {
    private static final int a = 3;
    private static final int b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static final int f11763c = 40;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11764d = 10;

    private d() {
    }

    public static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    private static int b(b bVar, boolean z) {
        int d2 = z ? bVar.d() : bVar.e();
        int e2 = z ? bVar.e() : bVar.d();
        byte[][] c2 = bVar.c();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            byte b2 = -1;
            int i4 = 0;
            for (int i5 = 0; i5 < e2; i5++) {
                byte b3 = z ? c2[i3][i5] : c2[i5][i3];
                if (b3 == b2) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + 3;
                    }
                    b2 = b3;
                    i4 = 1;
                }
            }
            if (i4 >= 5) {
                i2 += (i4 - 5) + 3;
            }
        }
        return i2;
    }

    public static int c(b bVar) {
        byte[][] c2 = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2 - 1; i3++) {
            byte[] bArr = c2[i3];
            int i4 = 0;
            while (i4 < e2 - 1) {
                byte b2 = bArr[i4];
                int i5 = i4 + 1;
                if (b2 == bArr[i5]) {
                    int i6 = i3 + 1;
                    if (b2 == c2[i6][i4] && b2 == c2[i6][i5]) {
                        i2++;
                    }
                }
                i4 = i5;
            }
        }
        return i2 * 3;
    }

    public static int d(b bVar) {
        byte[][] c2 = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            for (int i4 = 0; i4 < e2; i4++) {
                byte[] bArr = c2[i3];
                int i5 = i4 + 6;
                if (i5 < e2 && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (g(bArr, i4 - 4, i4) || g(bArr, i4 + 7, i4 + 11))) {
                    i2++;
                }
                int i6 = i3 + 6;
                if (i6 < d2 && c2[i3][i4] == 1 && c2[i3 + 1][i4] == 0 && c2[i3 + 2][i4] == 1 && c2[i3 + 3][i4] == 1 && c2[i3 + 4][i4] == 1 && c2[i3 + 5][i4] == 0 && c2[i6][i4] == 1 && (h(c2, i4, i3 - 4, i3) || h(c2, i4, i3 + 7, i3 + 11))) {
                    i2++;
                }
            }
        }
        return i2 * 40;
    }

    public static int e(b bVar) {
        byte[][] c2 = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            byte[] bArr = c2[i3];
            for (int i4 = 0; i4 < e2; i4++) {
                if (bArr[i4] == 1) {
                    i2++;
                }
            }
        }
        int d3 = bVar.d() * bVar.e();
        return ((Math.abs((i2 << 1) - d3) * 10) / d3) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean f(int i2, int i3, int i4) {
        int i5;
        int i6;
        switch (i2) {
            case 0:
                i4 += i3;
                i5 = i4 & 1;
                break;
            case 1:
                i5 = i4 & 1;
                break;
            case 2:
                i5 = i3 % 3;
                break;
            case 3:
                i5 = (i4 + i3) % 3;
                break;
            case 4:
                i4 /= 2;
                i3 /= 3;
                i4 += i3;
                i5 = i4 & 1;
                break;
            case 5:
                int i7 = i4 * i3;
                i5 = (i7 & 1) + (i7 % 3);
                break;
            case 6:
                int i8 = i4 * i3;
                i6 = (i8 & 1) + (i8 % 3);
                i5 = i6 & 1;
                break;
            case 7:
                i6 = ((i4 * i3) % 3) + ((i4 + i3) & 1);
                i5 = i6 & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i2)));
        }
        return i5 == 0;
    }

    private static boolean g(byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i2, int i3, int i4) {
        int min = Math.min(i4, bArr.length);
        for (int max = Math.max(i3, 0); max < min; max++) {
            if (bArr[max][i2] == 1) {
                return false;
            }
        }
        return true;
    }
}
