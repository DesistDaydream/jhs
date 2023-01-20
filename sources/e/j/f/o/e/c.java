package e.j.f.o.e;

/* loaded from: classes2.dex */
public final class c {
    public static final int a = 33;
    public static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f11359c = 32;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11360d = 4;

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f11361e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private c() {
    }

    private static int[] a(e.j.f.q.a aVar, int i2, int i3) {
        int[] iArr = new int[i3];
        int n = aVar.n() / i2;
        for (int i4 = 0; i4 < n; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= aVar.j((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    private static void b(e.j.f.q.b bVar, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    bVar.r(i6, i5);
                    bVar.r(i6, i7);
                    bVar.r(i5, i6);
                    bVar.r(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        bVar.r(i8, i8);
        int i9 = i8 + 1;
        bVar.r(i9, i8);
        bVar.r(i8, i9);
        int i10 = i2 + i3;
        bVar.r(i10, i8);
        bVar.r(i10, i9);
        bVar.r(i10, i10 - 1);
    }

    private static void c(e.j.f.q.b bVar, boolean z, int i2, e.j.f.q.a aVar) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (aVar.j(i4)) {
                    bVar.r(i5, i3 - 5);
                }
                if (aVar.j(i4 + 7)) {
                    bVar.r(i3 + 5, i5);
                }
                if (aVar.j(20 - i4)) {
                    bVar.r(i5, i3 + 5);
                }
                if (aVar.j(27 - i4)) {
                    bVar.r(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (aVar.j(i4)) {
                bVar.r(i6, i3 - 7);
            }
            if (aVar.j(i4 + 10)) {
                bVar.r(i3 + 7, i6);
            }
            if (aVar.j(29 - i4)) {
                bVar.r(i6, i3 + 7);
            }
            if (aVar.j(39 - i4)) {
                bVar.r(i3 - 7, i6);
            }
            i4++;
        }
    }

    public static a d(byte[] bArr) {
        return e(bArr, 33, 0);
    }

    public static a e(byte[] bArr, int i2, int i3) {
        e.j.f.q.a aVar;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        e.j.f.q.a a2 = new d(bArr).a();
        int n = ((a2.n() * i2) / 100) + 11;
        int n2 = a2.n() + n;
        int i8 = 0;
        int i9 = 1;
        if (i3 != 0) {
            z = i3 < 0;
            i5 = Math.abs(i3);
            if (i5 <= (z ? 4 : 32)) {
                i6 = j(i5, z);
                i4 = f11361e[i5];
                int i10 = i6 - (i6 % i4);
                aVar = i(a2, i4);
                if (aVar.n() + n <= i10) {
                    if (z && aVar.n() > (i4 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
            }
        } else {
            e.j.f.q.a aVar2 = null;
            int i11 = 0;
            int i12 = 0;
            while (i11 <= 32) {
                boolean z2 = i11 <= 3;
                int i13 = z2 ? i11 + 1 : i11;
                int j2 = j(i13, z2);
                if (n2 <= j2) {
                    if (aVar2 == null || i12 != f11361e[i13]) {
                        int i14 = f11361e[i13];
                        i12 = i14;
                        aVar2 = i(a2, i14);
                    }
                    int i15 = j2 - (j2 % i12);
                    if ((!z2 || aVar2.n() <= (i12 << 6)) && aVar2.n() + n <= i15) {
                        aVar = aVar2;
                        i4 = i12;
                        z = z2;
                        i5 = i13;
                        i6 = j2;
                    }
                }
                i11++;
                i8 = 0;
                i9 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        e.j.f.q.a f2 = f(aVar, i6, i4);
        int n3 = aVar.n() / i4;
        e.j.f.q.a g2 = g(z, i5, n3);
        int i16 = (z ? 11 : 14) + (i5 << 2);
        int[] iArr = new int[i16];
        int i17 = 2;
        if (z) {
            for (int i18 = 0; i18 < i16; i18++) {
                iArr[i18] = i18;
            }
            i7 = i16;
        } else {
            int i19 = i16 / 2;
            i7 = i16 + 1 + (((i19 - 1) / 15) * 2);
            int i20 = i7 / 2;
            for (int i21 = 0; i21 < i19; i21++) {
                int i22 = (i21 / 15) + i21;
                iArr[(i19 - i21) - i9] = (i20 - i22) - 1;
                iArr[i19 + i21] = i22 + i20 + i9;
            }
        }
        e.j.f.q.b bVar = new e.j.f.q.b(i7);
        int i23 = 0;
        int i24 = 0;
        while (i23 < i5) {
            int i25 = ((i5 - i23) << i17) + (z ? 9 : 12);
            int i26 = 0;
            while (i26 < i25) {
                int i27 = i26 << 1;
                while (i8 < i17) {
                    if (f2.j(i24 + i27 + i8)) {
                        int i28 = i23 << 1;
                        bVar.r(iArr[i28 + i8], iArr[i28 + i26]);
                    }
                    if (f2.j((i25 << 1) + i24 + i27 + i8)) {
                        int i29 = i23 << 1;
                        bVar.r(iArr[i29 + i26], iArr[((i16 - 1) - i29) - i8]);
                    }
                    if (f2.j((i25 << 2) + i24 + i27 + i8)) {
                        int i30 = (i16 - 1) - (i23 << 1);
                        bVar.r(iArr[i30 - i8], iArr[i30 - i26]);
                    }
                    if (f2.j((i25 * 6) + i24 + i27 + i8)) {
                        int i31 = i23 << 1;
                        bVar.r(iArr[((i16 - 1) - i31) - i26], iArr[i31 + i8]);
                    }
                    i8++;
                    i17 = 2;
                }
                i26++;
                i8 = 0;
                i17 = 2;
            }
            i24 += i25 << 3;
            i23++;
            i8 = 0;
            i17 = 2;
        }
        c(bVar, z, i7, g2);
        if (z) {
            b(bVar, i7 / 2, 5);
        } else {
            int i32 = i7 / 2;
            b(bVar, i32, 7);
            int i33 = 0;
            int i34 = 0;
            while (i34 < (i16 / 2) - 1) {
                for (int i35 = i32 & 1; i35 < i7; i35 += 2) {
                    int i36 = i32 - i33;
                    bVar.r(i36, i35);
                    int i37 = i32 + i33;
                    bVar.r(i37, i35);
                    bVar.r(i35, i36);
                    bVar.r(i35, i37);
                }
                i34 += 15;
                i33 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.g(z);
        aVar3.j(i7);
        aVar3.h(i5);
        aVar3.f(n3);
        aVar3.i(bVar);
        return aVar3;
    }

    private static e.j.f.q.a f(e.j.f.q.a aVar, int i2, int i3) {
        e.j.f.q.m.d dVar = new e.j.f.q.m.d(h(i3));
        int i4 = i2 / i3;
        int[] a2 = a(aVar, i3, i4);
        dVar.b(a2, i4 - (aVar.n() / i3));
        e.j.f.q.a aVar2 = new e.j.f.q.a();
        aVar2.c(0, i2 % i3);
        for (int i5 : a2) {
            aVar2.c(i5, i3);
        }
        return aVar2;
    }

    public static e.j.f.q.a g(boolean z, int i2, int i3) {
        e.j.f.q.a aVar = new e.j.f.q.a();
        if (z) {
            aVar.c(i2 - 1, 2);
            aVar.c(i3 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.c(i2 - 1, 5);
        aVar.c(i3 - 1, 11);
        return f(aVar, 40, 4);
    }

    private static e.j.f.q.m.a h(int i2) {
        if (i2 != 4) {
            if (i2 != 6) {
                if (i2 != 8) {
                    if (i2 != 10) {
                        if (i2 == 12) {
                            return e.j.f.q.m.a.f11498h;
                        }
                        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
                    }
                    return e.j.f.q.m.a.f11499i;
                }
                return e.j.f.q.m.a.n;
            }
            return e.j.f.q.m.a.f11500j;
        }
        return e.j.f.q.m.a.f11501k;
    }

    public static e.j.f.q.a i(e.j.f.q.a aVar, int i2) {
        e.j.f.q.a aVar2 = new e.j.f.q.a();
        int n = aVar.n();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < n) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= n || aVar.j(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                aVar2.c(i8, i2);
            } else if (i8 == 0) {
                aVar2.c(i5 | 1, i2);
            } else {
                aVar2.c(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return aVar2;
    }

    private static int j(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }
}
