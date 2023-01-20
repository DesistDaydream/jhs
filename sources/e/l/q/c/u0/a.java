package e.l.q.c.u0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.jihuanshe.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class a {
    private static final int w = 4;
    public final float[] a = new float[4];
    public final int[] b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    public final RectF f14248c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    public int f14249d = 0;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f14250e = -1;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f14251f = 1291845631;

    /* renamed from: g  reason: collision with root package name */
    public int f14252g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f14253h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f14254i = 0;

    /* renamed from: j  reason: collision with root package name */
    public float f14255j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f14256k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f14257l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f14258m = 0.5f;
    public float n = 20.0f;
    public boolean o = true;
    public boolean p = false;
    public boolean q = true;
    public int r = -1;
    public int s = 1;
    public long t = 1000;
    public long u;
    public long v;

    /* renamed from: e.l.q.c.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0400a extends b<C0400a> {
        public C0400a() {
            this.a.q = true;
        }

        @Override // e.l.q.c.u0.a.b
        /* renamed from: y */
        public C0400a f() {
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b<T extends b<T>> {
        public final a a = new a();

        private static float b(float f2, float f3, float f4) {
            return Math.min(f3, Math.max(f2, f4));
        }

        public a a() {
            this.a.c();
            this.a.d();
            return this.a;
        }

        public T c(Context context, AttributeSet attributeSet) {
            return d(context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0));
        }

        public T d(TypedArray typedArray) {
            if (typedArray.hasValue(3)) {
                i(typedArray.getBoolean(3, this.a.o));
            }
            if (typedArray.hasValue(0)) {
                g(typedArray.getBoolean(0, this.a.p));
            }
            if (typedArray.hasValue(1)) {
                h(typedArray.getFloat(1, 0.3f));
            }
            if (typedArray.hasValue(11)) {
                p(typedArray.getFloat(11, 1.0f));
            }
            if (typedArray.hasValue(7)) {
                l(typedArray.getInt(7, (int) this.a.t));
            }
            if (typedArray.hasValue(14)) {
                r(typedArray.getInt(14, this.a.r));
            }
            if (typedArray.hasValue(15)) {
                s(typedArray.getInt(15, (int) this.a.u));
            }
            if (typedArray.hasValue(16)) {
                t(typedArray.getInt(16, this.a.s));
            }
            if (typedArray.hasValue(18)) {
                v(typedArray.getInt(18, (int) this.a.v));
            }
            if (typedArray.hasValue(5)) {
                int i2 = typedArray.getInt(5, this.a.f14249d);
                if (i2 == 1) {
                    j(1);
                } else if (i2 == 2) {
                    j(2);
                } else if (i2 != 3) {
                    j(0);
                } else {
                    j(3);
                }
            }
            if (typedArray.hasValue(17)) {
                if (typedArray.getInt(17, this.a.f14252g) != 1) {
                    u(0);
                } else {
                    u(1);
                }
            }
            if (typedArray.hasValue(6)) {
                k(typedArray.getFloat(6, this.a.f14258m));
            }
            if (typedArray.hasValue(9)) {
                n(typedArray.getDimensionPixelSize(9, this.a.f14253h));
            }
            if (typedArray.hasValue(8)) {
                m(typedArray.getDimensionPixelSize(8, this.a.f14254i));
            }
            if (typedArray.hasValue(13)) {
                q(typedArray.getFloat(13, this.a.f14257l));
            }
            if (typedArray.hasValue(20)) {
                x(typedArray.getFloat(20, this.a.f14255j));
            }
            if (typedArray.hasValue(10)) {
                o(typedArray.getFloat(10, this.a.f14256k));
            }
            if (typedArray.hasValue(19)) {
                w(typedArray.getFloat(19, this.a.n));
            }
            return f();
        }

        public T e(a aVar) {
            j(aVar.f14249d);
            u(aVar.f14252g);
            n(aVar.f14253h);
            m(aVar.f14254i);
            x(aVar.f14255j);
            o(aVar.f14256k);
            q(aVar.f14257l);
            k(aVar.f14258m);
            w(aVar.n);
            i(aVar.o);
            g(aVar.p);
            r(aVar.r);
            t(aVar.s);
            s(aVar.u);
            v(aVar.v);
            l(aVar.t);
            a aVar2 = this.a;
            aVar2.f14251f = aVar.f14251f;
            aVar2.f14250e = aVar.f14250e;
            return f();
        }

        public abstract T f();

        public T g(boolean z) {
            this.a.p = z;
            return f();
        }

        public T h(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            a aVar = this.a;
            aVar.f14251f = (((int) (b(0.0f, 1.0f, f2) * 255.0f)) << 24) | (aVar.f14251f & 16777215);
            return f();
        }

        public T i(boolean z) {
            this.a.o = z;
            return f();
        }

        public T j(int i2) {
            this.a.f14249d = i2;
            return f();
        }

        public T k(float f2) {
            if (f2 >= 0.0f) {
                this.a.f14258m = f2;
                return f();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f2);
        }

        public T l(long j2) {
            if (j2 >= 0) {
                this.a.t = j2;
                return f();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j2);
        }

        public T m(@Px int i2) {
            if (i2 >= 0) {
                this.a.f14254i = i2;
                return f();
            }
            throw new IllegalArgumentException("Given invalid height: " + i2);
        }

        public T n(@Px int i2) {
            if (i2 >= 0) {
                this.a.f14253h = i2;
                return f();
            }
            throw new IllegalArgumentException("Given invalid width: " + i2);
        }

        public T o(float f2) {
            if (f2 >= 0.0f) {
                this.a.f14256k = f2;
                return f();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f2);
        }

        public T p(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            a aVar = this.a;
            aVar.f14250e = (((int) (b(0.0f, 1.0f, f2) * 255.0f)) << 24) | (aVar.f14250e & 16777215);
            return f();
        }

        public T q(float f2) {
            if (f2 >= 0.0f) {
                this.a.f14257l = f2;
                return f();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f2);
        }

        public T r(int i2) {
            this.a.r = i2;
            return f();
        }

        public T s(long j2) {
            if (j2 >= 0) {
                this.a.u = j2;
                return f();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j2);
        }

        public T t(int i2) {
            this.a.s = i2;
            return f();
        }

        public T u(int i2) {
            this.a.f14252g = i2;
            return f();
        }

        public T v(long j2) {
            if (j2 >= 0) {
                this.a.v = j2;
                return f();
            }
            throw new IllegalArgumentException("Given a negative start delay: " + j2);
        }

        public T w(float f2) {
            this.a.n = f2;
            return f();
        }

        public T x(float f2) {
            if (f2 >= 0.0f) {
                this.a.f14255j = f2;
                return f();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f2);
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends b<c> {
        public c() {
            this.a.q = false;
        }

        public c A(@ColorInt int i2) {
            a aVar = this.a;
            aVar.f14251f = (i2 & 16777215) | (aVar.f14251f & ViewCompat.MEASURED_STATE_MASK);
            return f();
        }

        public c B(@ColorInt int i2) {
            this.a.f14250e = i2;
            return f();
        }

        @Override // e.l.q.c.u0.a.b
        /* renamed from: y */
        public c d(TypedArray typedArray) {
            super.d(typedArray);
            if (typedArray.hasValue(2)) {
                A(typedArray.getColor(2, this.a.f14251f));
            }
            if (typedArray.hasValue(12)) {
                B(typedArray.getColor(12, this.a.f14250e));
            }
            return f();
        }

        @Override // e.l.q.c.u0.a.b
        /* renamed from: z */
        public c f() {
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface d {
        public static final int b0 = 0;
        public static final int c0 = 1;
        public static final int d0 = 2;
        public static final int e0 = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface e {
        public static final int f0 = 0;
        public static final int g0 = 1;
    }

    public int a(int i2) {
        int i3 = this.f14254i;
        return i3 > 0 ? i3 : Math.round(this.f14256k * i2);
    }

    public void b(int i2, int i3) {
        int round;
        double max = Math.max(i2, i3);
        float f2 = -(Math.round(((float) ((max / Math.sin(1.5707963267948966d - Math.toRadians(this.n % 90.0f))) - max)) / 2.0f) * 3);
        this.f14248c.set(f2, f2, e(i2) + round, a(i3) + round);
    }

    public void c() {
        if (this.f14252g != 1) {
            int[] iArr = this.b;
            int i2 = this.f14251f;
            iArr[0] = i2;
            int i3 = this.f14250e;
            iArr[1] = i3;
            iArr[2] = i3;
            iArr[3] = i2;
            return;
        }
        int[] iArr2 = this.b;
        int i4 = this.f14250e;
        iArr2[0] = i4;
        iArr2[1] = i4;
        int i5 = this.f14251f;
        iArr2[2] = i5;
        iArr2[3] = i5;
    }

    public void d() {
        if (this.f14252g != 1) {
            this.a[0] = Math.max(((1.0f - this.f14257l) - this.f14258m) / 2.0f, 0.0f);
            this.a[1] = Math.max(((1.0f - this.f14257l) - 0.001f) / 2.0f, 0.0f);
            this.a[2] = Math.min(((this.f14257l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.a[3] = Math.min(((this.f14257l + 1.0f) + this.f14258m) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f14257l, 1.0f);
        this.a[2] = Math.min(this.f14257l + this.f14258m, 1.0f);
        this.a[3] = 1.0f;
    }

    public int e(int i2) {
        int i3 = this.f14253h;
        return i3 > 0 ? i3 : Math.round(this.f14255j * i2);
    }
}
