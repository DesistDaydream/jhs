package e.j.f.r.c;

import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.FormatException;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: h  reason: collision with root package name */
    private static final d[] f11510h = a();
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11511c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11512d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11513e;

    /* renamed from: f  reason: collision with root package name */
    private final c f11514f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11515g;

    /* loaded from: classes2.dex */
    public static final class b {
        private final int a;
        private final int b;

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        private b(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }
    }

    private d(int i2, int i3, int i4, int i5, int i6, c cVar) {
        b[] a2;
        this.a = i2;
        this.b = i3;
        this.f11511c = i4;
        this.f11512d = i5;
        this.f11513e = i6;
        this.f11514f = cVar;
        int b2 = cVar.b();
        int i7 = 0;
        for (b bVar : cVar.a()) {
            i7 += bVar.a() * (bVar.b() + b2);
        }
        this.f11515g = i7;
    }

    private static d[] a() {
        return new d[]{new d(1, 10, 10, 8, 8, new c(5, new b(1, 3))), new d(2, 12, 12, 10, 10, new c(7, new b(1, 5))), new d(3, 14, 14, 12, 12, new c(10, new b(1, 8))), new d(4, 16, 16, 14, 14, new c(12, new b(1, 12))), new d(5, 18, 18, 16, 16, new c(14, new b(1, 18))), new d(6, 20, 20, 18, 18, new c(18, new b(1, 22))), new d(7, 22, 22, 20, 20, new c(20, new b(1, 30))), new d(8, 24, 24, 22, 22, new c(24, new b(1, 36))), new d(9, 26, 26, 24, 24, new c(28, new b(1, 44))), new d(10, 32, 32, 14, 14, new c(36, new b(1, 62))), new d(11, 36, 36, 16, 16, new c(42, new b(1, 86))), new d(12, 40, 40, 18, 18, new c(48, new b(1, 114))), new d(13, 44, 44, 20, 20, new c(56, new b(1, CameraInterface.TYPE_RECORDER))), new d(14, 48, 48, 22, 22, new c(68, new b(1, 174))), new d(15, 52, 52, 24, 24, new c(42, new b(2, 102))), new d(16, 64, 64, 14, 14, new c(56, new b(2, 140))), new d(17, 72, 72, 16, 16, new c(36, new b(4, 92))), new d(18, 80, 80, 18, 18, new c(48, new b(4, 114))), new d(19, 88, 88, 20, 20, new c(56, new b(4, CameraInterface.TYPE_RECORDER))), new d(20, 96, 96, 22, 22, new c(68, new b(4, 174))), new d(21, 104, 104, 24, 24, new c(56, new b(6, 136))), new d(22, 120, 120, 18, 18, new c(68, new b(6, HideBottomViewOnScrollBehavior.f2749f))), new d(23, 132, 132, 20, 20, new c(62, new b(8, 163))), new d(24, CameraInterface.TYPE_RECORDER, CameraInterface.TYPE_RECORDER, 22, 22, new c(62, new b(8, 156), new b(2, 155))), new d(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new d(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new d(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new d(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new d(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static d h(int i2, int i3) throws FormatException {
        d[] dVarArr;
        if ((i2 & 1) == 0 && (i3 & 1) == 0) {
            for (d dVar : f11510h) {
                if (dVar.b == i2 && dVar.f11511c == i3) {
                    return dVar;
                }
            }
            throw FormatException.getFormatInstance();
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.f11513e;
    }

    public int c() {
        return this.f11512d;
    }

    public c d() {
        return this.f11514f;
    }

    public int e() {
        return this.f11511c;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.f11515g;
    }

    public int i() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    /* loaded from: classes2.dex */
    public static final class c {
        private final int a;
        private final b[] b;

        public b[] a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }

        private c(int i2, b bVar) {
            this.a = i2;
            this.b = new b[]{bVar};
        }

        private c(int i2, b bVar, b bVar2) {
            this.a = i2;
            this.b = new b[]{bVar, bVar2};
        }
    }
}
