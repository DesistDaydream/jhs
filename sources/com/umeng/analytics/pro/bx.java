package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bo;

/* loaded from: classes3.dex */
public class bx {
    private static int a = Integer.MAX_VALUE;

    public static void a(int i2) {
        a = i2;
    }

    public static void a(bu buVar, byte b) throws bb {
        a(buVar, b, a);
    }

    public static void a(bu buVar, byte b, int i2) throws bb {
        if (i2 > 0) {
            int i3 = 0;
            switch (b) {
                case 2:
                    buVar.t();
                    return;
                case 3:
                    buVar.u();
                    return;
                case 4:
                    buVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    buVar.v();
                    return;
                case 8:
                    buVar.w();
                    return;
                case 10:
                    buVar.x();
                    return;
                case 11:
                    buVar.A();
                    return;
                case 12:
                    buVar.j();
                    while (true) {
                        byte b2 = buVar.l().b;
                        if (b2 == 0) {
                            buVar.k();
                            return;
                        } else {
                            a(buVar, b2, i2 - 1);
                            buVar.m();
                        }
                    }
                case 13:
                    br n = buVar.n();
                    while (i3 < n.f7103c) {
                        int i4 = i2 - 1;
                        a(buVar, n.a, i4);
                        a(buVar, n.b, i4);
                        i3++;
                    }
                    buVar.o();
                    return;
                case 14:
                    by r = buVar.r();
                    while (i3 < r.b) {
                        a(buVar, r.a, i2 - 1);
                        i3++;
                    }
                    buVar.s();
                    return;
                case 15:
                    bq p = buVar.p();
                    while (i3 < p.b) {
                        a(buVar, p.a, i2 - 1);
                        i3++;
                    }
                    buVar.q();
                    return;
            }
        } else {
            throw new bb("Maximum skip depth exceeded");
        }
    }

    public static bw a(byte[] bArr, bw bwVar) {
        if (bArr[0] > 16) {
            return new bo.a();
        }
        return (bArr.length <= 1 || (bArr[1] & h.k2.v.n.a) == 0) ? bwVar : new bo.a();
    }
}
