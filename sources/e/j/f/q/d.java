package e.j.f.q;

import java.util.List;

/* loaded from: classes2.dex */
public final class d {
    private final byte[] a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11460c;

    /* renamed from: d  reason: collision with root package name */
    private final List<byte[]> f11461d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11462e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f11463f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f11464g;

    /* renamed from: h  reason: collision with root package name */
    private Object f11465h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11466i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11467j;

    public d(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f11461d;
    }

    public String b() {
        return this.f11462e;
    }

    public Integer c() {
        return this.f11464g;
    }

    public Integer d() {
        return this.f11463f;
    }

    public int e() {
        return this.b;
    }

    public Object f() {
        return this.f11465h;
    }

    public byte[] g() {
        return this.a;
    }

    public int h() {
        return this.f11466i;
    }

    public int i() {
        return this.f11467j;
    }

    public String j() {
        return this.f11460c;
    }

    public boolean k() {
        return this.f11466i >= 0 && this.f11467j >= 0;
    }

    public void l(Integer num) {
        this.f11464g = num;
    }

    public void m(Integer num) {
        this.f11463f = num;
    }

    public void n(int i2) {
        this.b = i2;
    }

    public void o(Object obj) {
        this.f11465h = obj;
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.a = bArr;
        this.b = bArr == null ? 0 : bArr.length * 8;
        this.f11460c = str;
        this.f11461d = list;
        this.f11462e = str2;
        this.f11466i = i3;
        this.f11467j = i2;
    }
}
