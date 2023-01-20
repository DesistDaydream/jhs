package com.umeng.analytics.pro;

/* loaded from: classes3.dex */
public class au extends bb {
    public static final int a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7050c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f7051d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f7052e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f7053f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f7054g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f7055h = 7;

    /* renamed from: j  reason: collision with root package name */
    private static final bz f7056j = new bz("TApplicationException");

    /* renamed from: k  reason: collision with root package name */
    private static final bp f7057k = new bp("message", (byte) 11, 1);

    /* renamed from: l  reason: collision with root package name */
    private static final bp f7058l = new bp("type", (byte) 8, 2);

    /* renamed from: m  reason: collision with root package name */
    private static final long f7059m = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f7060i;

    public au() {
        this.f7060i = 0;
    }

    public int a() {
        return this.f7060i;
    }

    public void b(bu buVar) throws bb {
        buVar.a(f7056j);
        if (getMessage() != null) {
            buVar.a(f7057k);
            buVar.a(getMessage());
            buVar.c();
        }
        buVar.a(f7058l);
        buVar.a(this.f7060i);
        buVar.c();
        buVar.d();
        buVar.b();
    }

    public static au a(bu buVar) throws bb {
        buVar.j();
        String str = null;
        int i2 = 0;
        while (true) {
            bp l2 = buVar.l();
            byte b2 = l2.b;
            if (b2 == 0) {
                buVar.k();
                return new au(i2, str);
            }
            short s = l2.f7102c;
            if (s != 1) {
                if (s != 2) {
                    bx.a(buVar, b2);
                } else if (b2 == 8) {
                    i2 = buVar.w();
                } else {
                    bx.a(buVar, b2);
                }
            } else if (b2 == 11) {
                str = buVar.z();
            } else {
                bx.a(buVar, b2);
            }
            buVar.m();
        }
    }

    public au(int i2) {
        this.f7060i = 0;
        this.f7060i = i2;
    }

    public au(int i2, String str) {
        super(str);
        this.f7060i = 0;
        this.f7060i = i2;
    }

    public au(String str) {
        super(str);
        this.f7060i = 0;
    }
}
