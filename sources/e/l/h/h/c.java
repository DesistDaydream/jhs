package e.l.h.h;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* loaded from: classes2.dex */
public class c {
    private SparseBooleanArray a = new SparseBooleanArray();
    private SparseArray<Float> b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private int f12110c;

    /* renamed from: d  reason: collision with root package name */
    private int f12111d;

    /* renamed from: e  reason: collision with root package name */
    private int f12112e;

    /* renamed from: f  reason: collision with root package name */
    private float f12113f;

    /* renamed from: g  reason: collision with root package name */
    private int f12114g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12115h;

    /* renamed from: i  reason: collision with root package name */
    private a f12116i;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i2, int i3);

        void b(int i2, int i3, float f2, boolean z);

        void c(int i2, int i3);

        void d(int i2, int i3, float f2, boolean z);
    }

    private void a(int i2) {
        a aVar = this.f12116i;
        if (aVar != null) {
            aVar.a(i2, this.f12110c);
        }
        this.a.put(i2, true);
    }

    private void b(int i2, float f2, boolean z, boolean z2) {
        if (this.f12115h || i2 == this.f12111d || this.f12114g == 1 || z2) {
            a aVar = this.f12116i;
            if (aVar != null) {
                aVar.b(i2, this.f12110c, f2, z);
            }
            this.b.put(i2, Float.valueOf(1.0f - f2));
        }
    }

    private void c(int i2, float f2, boolean z, boolean z2) {
        if (!this.f12115h && i2 != this.f12112e && this.f12114g != 1) {
            int i3 = this.f12111d;
            if (((i2 != i3 - 1 && i2 != i3 + 1) || this.b.get(i2, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        a aVar = this.f12116i;
        if (aVar != null) {
            aVar.d(i2, this.f12110c, f2, z);
        }
        this.b.put(i2, Float.valueOf(f2));
    }

    private void d(int i2) {
        a aVar = this.f12116i;
        if (aVar != null) {
            aVar.c(i2, this.f12110c);
        }
        this.a.put(i2, false);
    }

    public int e() {
        return this.f12111d;
    }

    public int f() {
        return this.f12114g;
    }

    public int g() {
        return this.f12110c;
    }

    public void h(int i2) {
        this.f12114g = i2;
    }

    public void i(int i2, float f2, int i3) {
        boolean z;
        float f3 = i2 + f2;
        float f4 = this.f12113f;
        boolean z2 = f4 <= f3;
        if (this.f12114g == 0) {
            for (int i4 = 0; i4 < this.f12110c; i4++) {
                if (i4 != this.f12111d) {
                    if (!this.a.get(i4)) {
                        a(i4);
                    }
                    if (this.b.get(i4, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i4, 1.0f, false, true);
                    }
                }
            }
            b(this.f12111d, 1.0f, false, true);
            d(this.f12111d);
        } else if (f3 == f4) {
            return;
        } else {
            int i5 = i2 + 1;
            if (f2 == 0.0f && z2) {
                i5 = i2 - 1;
                z = false;
            } else {
                z = true;
            }
            for (int i6 = 0; i6 < this.f12110c; i6++) {
                if (i6 != i2 && i6 != i5 && this.b.get(i6, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                    c(i6, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f5 = 1.0f - f2;
                c(i5, f5, true, false);
                b(i2, f5, true, false);
            } else if (z2) {
                c(i2, f2, true, false);
                b(i5, f2, true, false);
            } else {
                float f6 = 1.0f - f2;
                c(i5, f6, false, false);
                b(i2, f6, false, false);
            }
        }
        this.f12113f = f3;
    }

    public void j(int i2) {
        this.f12112e = this.f12111d;
        this.f12111d = i2;
        d(i2);
        for (int i3 = 0; i3 < this.f12110c; i3++) {
            if (i3 != this.f12111d && !this.a.get(i3)) {
                a(i3);
            }
        }
    }

    public void k(a aVar) {
        this.f12116i = aVar;
    }

    public void l(boolean z) {
        this.f12115h = z;
    }

    public void m(int i2) {
        this.f12110c = i2;
        this.a.clear();
        this.b.clear();
    }
}
