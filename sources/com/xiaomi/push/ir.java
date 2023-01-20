package com.xiaomi.push;

/* loaded from: classes3.dex */
public class ir {
    private static int a = Integer.MAX_VALUE;

    public static void a(io ioVar, byte b) {
        a(ioVar, b, a);
    }

    public static void a(io ioVar, byte b, int i2) {
        if (i2 <= 0) {
            throw new ih("Maximum skip depth exceeded");
        }
        int i3 = 0;
        switch (b) {
            case 2:
                ioVar.p();
                return;
            case 3:
                ioVar.q();
                return;
            case 4:
                ioVar.u();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                ioVar.r();
                return;
            case 8:
                ioVar.s();
                return;
            case 10:
                ioVar.t();
                return;
            case 11:
                ioVar.w();
                return;
            case 12:
                ioVar.f();
                while (true) {
                    byte b2 = ioVar.h().b;
                    if (b2 == 0) {
                        ioVar.g();
                        return;
                    } else {
                        a(ioVar, b2, i2 - 1);
                        ioVar.i();
                    }
                }
            case 13:
                in j2 = ioVar.j();
                while (i3 < j2.f9005c) {
                    int i4 = i2 - 1;
                    a(ioVar, j2.a, i4);
                    a(ioVar, j2.b, i4);
                    i3++;
                }
                ioVar.k();
                return;
            case 14:
                is n = ioVar.n();
                while (i3 < n.b) {
                    a(ioVar, n.a, i2 - 1);
                    i3++;
                }
                ioVar.o();
                return;
            case 15:
                im l2 = ioVar.l();
                while (i3 < l2.b) {
                    a(ioVar, l2.a, i2 - 1);
                    i3++;
                }
                ioVar.m();
                return;
        }
    }
}
