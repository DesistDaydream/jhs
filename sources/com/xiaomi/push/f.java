package com.xiaomi.push;

/* loaded from: classes3.dex */
public class f {
    public static final String a;
    public static final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8564c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8565d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8566e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f8567f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f8568g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f8569h;

    /* renamed from: i  reason: collision with root package name */
    private static int f8570i;

    static {
        int i2;
        String str = i.a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        a = str;
        boolean contains = str.contains("2A2FE0D7");
        b = contains;
        boolean z = false;
        f8564c = contains || "DEBUG".equalsIgnoreCase(str);
        f8565d = "LOGABLE".equalsIgnoreCase(str);
        f8566e = str.contains("YY");
        f8567f = str.equalsIgnoreCase("TEST");
        f8568g = "BETA".equalsIgnoreCase(str);
        if (str != null && str.startsWith("RC")) {
            z = true;
        }
        f8569h = z;
        f8570i = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (!str.equalsIgnoreCase("ONEBOX")) {
            f8570i = 1;
            return;
        } else {
            i2 = 3;
        }
        f8570i = i2;
    }

    public static void a(int i2) {
        f8570i = i2;
    }

    public static boolean a() {
        return f8570i == 2;
    }

    public static boolean b() {
        return f8570i == 3;
    }

    public static int c() {
        return f8570i;
    }
}
