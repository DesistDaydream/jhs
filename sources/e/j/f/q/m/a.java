package e.j.f.q.m;

import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: h  reason: collision with root package name */
    public static final a f11498h = new a(4201, 4096, 1);

    /* renamed from: i  reason: collision with root package name */
    public static final a f11499i = new a(1033, 1024, 1);

    /* renamed from: j  reason: collision with root package name */
    public static final a f11500j;

    /* renamed from: k  reason: collision with root package name */
    public static final a f11501k;

    /* renamed from: l  reason: collision with root package name */
    public static final a f11502l;

    /* renamed from: m  reason: collision with root package name */
    public static final a f11503m;
    public static final a n;
    public static final a o;
    private final int[] a;
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final b f11504c;

    /* renamed from: d  reason: collision with root package name */
    private final b f11505d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11506e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11507f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11508g;

    static {
        a aVar = new a(67, 64, 1);
        f11500j = aVar;
        f11501k = new a(19, 16, 1);
        f11502l = new a(MqttConfigImpl.DEFAULT_KEEP_ALIVE_INTERVAL, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f11503m = aVar2;
        n = aVar2;
        o = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.f11507f = i2;
        this.f11506e = i3;
        this.f11508g = i4;
        this.a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.a[i7]] = i7;
        }
        this.f11504c = new b(this, new int[]{0});
        this.f11505d = new b(this, new int[]{1});
    }

    public static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    public b b(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.f11504c;
            }
            int[] iArr = new int[i2 + 1];
            iArr[0] = i3;
            return new b(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    public int c(int i2) {
        return this.a[i2];
    }

    public int d() {
        return this.f11508g;
    }

    public b e() {
        return this.f11505d;
    }

    public int f() {
        return this.f11506e;
    }

    public b g() {
        return this.f11504c;
    }

    public int h(int i2) {
        if (i2 != 0) {
            return this.a[(this.f11506e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f11506e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f11507f) + ',' + this.f11506e + ')';
    }
}
