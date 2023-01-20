package e.j.f.r.d;

import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: i  reason: collision with root package name */
    public static final k[] f11539i;

    /* renamed from: j  reason: collision with root package name */
    private static k[] f11540j;
    private final boolean a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11541c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11542d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11543e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11544f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11545g;

    /* renamed from: h  reason: collision with root package name */
    private final int f11546h;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, CameraInterface.TYPE_RECORDER, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, AdEventType.VIDEO_PAUSE, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, CameraInterface.TYPE_RECORDER, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, CameraInterface.TYPE_RECORDER, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, HideBottomViewOnScrollBehavior.f2749f, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f11539i = kVarArr;
        f11540j = kVarArr;
    }

    public k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    private int f() {
        int i2 = this.f11544f;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 != 16) {
                    if (i2 == 36) {
                        return 6;
                    }
                    throw new IllegalStateException("Cannot handle this number of data regions");
                }
                return 4;
            }
        }
        return i3;
    }

    private int l() {
        int i2 = this.f11544f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 != 4) {
            if (i2 != 16) {
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
            return 4;
        }
        return 2;
    }

    public static k m(int i2) {
        return p(i2, SymbolShapeHint.FORCE_NONE, true);
    }

    public static k n(int i2, SymbolShapeHint symbolShapeHint) {
        return p(i2, symbolShapeHint, true);
    }

    public static k o(int i2, SymbolShapeHint symbolShapeHint, e.j.f.c cVar, e.j.f.c cVar2, boolean z) {
        k[] kVarArr;
        for (k kVar : f11540j) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && kVar.a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || kVar.a) && ((cVar == null || (kVar.k() >= cVar.b() && kVar.j() >= cVar.a())) && ((cVar2 == null || (kVar.k() <= cVar2.b() && kVar.j() <= cVar2.a())) && i2 <= kVar.b)))) {
                return kVar;
            }
        }
        if (z) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i2)));
        }
        return null;
    }

    private static k p(int i2, SymbolShapeHint symbolShapeHint, boolean z) {
        return o(i2, symbolShapeHint, null, null, z);
    }

    public static k q(int i2, boolean z, boolean z2) {
        return p(i2, z ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z2);
    }

    public static void r(k[] kVarArr) {
        f11540j = kVarArr;
    }

    public int a() {
        return this.b + this.f11541c;
    }

    public final int b() {
        return this.b;
    }

    public int c(int i2) {
        return this.f11545g;
    }

    public final int d() {
        return this.f11541c;
    }

    public final int e(int i2) {
        return this.f11546h;
    }

    public int g() {
        return this.b / this.f11545g;
    }

    public final int h() {
        return l() * this.f11543e;
    }

    public final int i() {
        return f() * this.f11542d;
    }

    public final int j() {
        return h() + (l() << 1);
    }

    public final int k() {
        return i() + (f() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f11542d);
        sb.append('x');
        sb.append(this.f11543e);
        sb.append(", symbol size ");
        sb.append(k());
        sb.append('x');
        sb.append(j());
        sb.append(", symbol data size ");
        sb.append(i());
        sb.append('x');
        sb.append(h());
        sb.append(", codewords ");
        sb.append(this.b);
        sb.append('+');
        sb.append(this.f11541c);
        return sb.toString();
    }

    public k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a = z;
        this.b = i2;
        this.f11541c = i3;
        this.f11542d = i4;
        this.f11543e = i5;
        this.f11544f = i6;
        this.f11545g = i7;
        this.f11546h = i8;
    }
}
