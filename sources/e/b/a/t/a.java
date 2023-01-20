package e.b.a.t;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import e.b.a.p.m.d.m;
import e.b.a.p.m.d.o;
import e.b.a.p.m.d.q;
import e.b.a.p.m.d.s;
import e.b.a.t.a;
import e.b.a.v.l;
import e.b.a.v.n;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private static final int A = -1;
    private static final int B = 2;
    private static final int C = 4;
    private static final int D = 8;
    private static final int E = 16;
    private static final int F = 32;
    private static final int G = 64;
    private static final int H = 128;
    private static final int I = 256;
    private static final int J = 512;
    private static final int K = 1024;
    private static final int L = 2048;
    private static final int M = 4096;
    private static final int N = 8192;
    private static final int O = 16384;
    private static final int P = 32768;
    private static final int Q = 65536;
    private static final int R = 131072;
    private static final int S = 262144;
    private static final int T = 524288;
    private static final int U = 1048576;
    private int a;
    @Nullable

    /* renamed from: e */
    private Drawable f9871e;

    /* renamed from: f */
    private int f9872f;
    @Nullable

    /* renamed from: g */
    private Drawable f9873g;

    /* renamed from: h */
    private int f9874h;

    /* renamed from: m */
    private boolean f9879m;
    @Nullable
    private Drawable o;
    private int p;
    private boolean t;
    @Nullable
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean z;
    private float b = 1.0f;
    @NonNull

    /* renamed from: c */
    private e.b.a.p.k.h f9869c = e.b.a.p.k.h.f9535e;
    @NonNull

    /* renamed from: d */
    private Priority f9870d = Priority.NORMAL;

    /* renamed from: i */
    private boolean f9875i = true;

    /* renamed from: j */
    private int f9876j = -1;

    /* renamed from: k */
    private int f9877k = -1;
    @NonNull

    /* renamed from: l */
    private e.b.a.p.c f9878l = e.b.a.u.c.a();
    private boolean n = true;
    @NonNull
    private e.b.a.p.f q = new e.b.a.p.f();
    @NonNull
    private Map<Class<?>, e.b.a.p.i<?>> r = new e.b.a.v.b();
    @NonNull
    private Class<?> s = Object.class;
    private boolean y = true;

    @NonNull
    private T B0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull e.b.a.p.i<Bitmap> iVar) {
        return C0(downsampleStrategy, iVar, true);
    }

    @NonNull
    private T C0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull e.b.a.p.i<Bitmap> iVar, boolean z) {
        T u0;
        if (z) {
            u0 = N0(downsampleStrategy, iVar);
        } else {
            u0 = u0(downsampleStrategy, iVar);
        }
        u0.y = true;
        return u0;
    }

    private T D0() {
        return this;
    }

    private boolean f0(int i2) {
        return g0(this.a, i2);
    }

    private static boolean g0(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    @NonNull
    private T s0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull e.b.a.p.i<Bitmap> iVar) {
        return C0(downsampleStrategy, iVar, false);
    }

    @NonNull
    @CheckResult
    public T A(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().A(drawable);
        }
        this.f9871e = drawable;
        int i2 = this.a | 16;
        this.a = i2;
        this.f9872f = 0;
        this.a = i2 & (-33);
        return E0();
    }

    @NonNull
    @CheckResult
    public T A0(@NonNull Priority priority) {
        if (this.v) {
            return (T) clone().A0(priority);
        }
        this.f9870d = (Priority) l.d(priority);
        this.a |= 8;
        return E0();
    }

    @NonNull
    @CheckResult
    public T B(@DrawableRes int i2) {
        if (this.v) {
            return (T) clone().B(i2);
        }
        this.p = i2;
        int i3 = this.a | 16384;
        this.a = i3;
        this.o = null;
        this.a = i3 & (-8193);
        return E0();
    }

    @NonNull
    @CheckResult
    public T C(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().C(drawable);
        }
        this.o = drawable;
        int i2 = this.a | 8192;
        this.a = i2;
        this.p = 0;
        this.a = i2 & (-16385);
        return E0();
    }

    @NonNull
    @CheckResult
    public T D() {
        return B0(DownsampleStrategy.f1713c, new s());
    }

    @NonNull
    @CheckResult
    public T E(@NonNull DecodeFormat decodeFormat) {
        l.d(decodeFormat);
        return (T) F0(o.f9763g, decodeFormat).F0(e.b.a.p.m.h.i.a, decodeFormat);
    }

    @NonNull
    public final T E0() {
        if (!this.t) {
            return D0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @NonNull
    @CheckResult
    public T F(@IntRange(from = 0) long j2) {
        return F0(VideoDecoder.f1727g, Long.valueOf(j2));
    }

    @NonNull
    @CheckResult
    public <Y> T F0(@NonNull e.b.a.p.e<Y> eVar, @NonNull Y y) {
        if (this.v) {
            return (T) clone().F0(eVar, y);
        }
        l.d(eVar);
        l.d(y);
        this.q.c(eVar, y);
        return E0();
    }

    @NonNull
    public final e.b.a.p.k.h G() {
        return this.f9869c;
    }

    @NonNull
    @CheckResult
    public T G0(@NonNull e.b.a.p.c cVar) {
        if (this.v) {
            return (T) clone().G0(cVar);
        }
        this.f9878l = (e.b.a.p.c) l.d(cVar);
        this.a |= 1024;
        return E0();
    }

    public final int H() {
        return this.f9872f;
    }

    @NonNull
    @CheckResult
    public T H0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.v) {
            return (T) clone().H0(f2);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.b = f2;
            this.a |= 2;
            return E0();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Nullable
    public final Drawable I() {
        return this.f9871e;
    }

    @NonNull
    @CheckResult
    public T I0(boolean z) {
        if (this.v) {
            return (T) clone().I0(true);
        }
        this.f9875i = !z;
        this.a |= 256;
        return E0();
    }

    @Nullable
    public final Drawable J() {
        return this.o;
    }

    @NonNull
    @CheckResult
    public T J0(@Nullable Resources.Theme theme) {
        if (this.v) {
            return (T) clone().J0(theme);
        }
        this.u = theme;
        this.a |= 32768;
        return E0();
    }

    public final int K() {
        return this.p;
    }

    @NonNull
    @CheckResult
    public T K0(@IntRange(from = 0) int i2) {
        return F0(e.b.a.p.l.y.b.b, Integer.valueOf(i2));
    }

    public final boolean L() {
        return this.x;
    }

    @NonNull
    @CheckResult
    public T L0(@NonNull e.b.a.p.i<Bitmap> iVar) {
        return M0(iVar, true);
    }

    @NonNull
    public final e.b.a.p.f M() {
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T M0(@NonNull e.b.a.p.i<Bitmap> iVar, boolean z) {
        if (this.v) {
            return (T) clone().M0(iVar, z);
        }
        q qVar = new q(iVar, z);
        P0(Bitmap.class, iVar, z);
        P0(Drawable.class, qVar, z);
        P0(BitmapDrawable.class, qVar.a(), z);
        P0(e.b.a.p.m.h.c.class, new e.b.a.p.m.h.f(iVar), z);
        return E0();
    }

    public final int N() {
        return this.f9876j;
    }

    @NonNull
    @CheckResult
    public final T N0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull e.b.a.p.i<Bitmap> iVar) {
        if (this.v) {
            return (T) clone().N0(downsampleStrategy, iVar);
        }
        w(downsampleStrategy);
        return L0(iVar);
    }

    public final int O() {
        return this.f9877k;
    }

    @NonNull
    @CheckResult
    public <Y> T O0(@NonNull Class<Y> cls, @NonNull e.b.a.p.i<Y> iVar) {
        return P0(cls, iVar, true);
    }

    @Nullable
    public final Drawable P() {
        return this.f9873g;
    }

    @NonNull
    public <Y> T P0(@NonNull Class<Y> cls, @NonNull e.b.a.p.i<Y> iVar, boolean z) {
        if (this.v) {
            return (T) clone().P0(cls, iVar, z);
        }
        l.d(cls);
        l.d(iVar);
        this.r.put(cls, iVar);
        int i2 = this.a | 2048;
        this.a = i2;
        this.n = true;
        int i3 = i2 | 65536;
        this.a = i3;
        this.y = false;
        if (z) {
            this.a = i3 | 131072;
            this.f9879m = true;
        }
        return E0();
    }

    public final int Q() {
        return this.f9874h;
    }

    @NonNull
    @CheckResult
    public T Q0(@NonNull e.b.a.p.i<Bitmap>... iVarArr) {
        if (iVarArr.length > 1) {
            return M0(new e.b.a.p.d(iVarArr), true);
        }
        if (iVarArr.length == 1) {
            return L0(iVarArr[0]);
        }
        return E0();
    }

    @NonNull
    public final Priority R() {
        return this.f9870d;
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T R0(@NonNull e.b.a.p.i<Bitmap>... iVarArr) {
        return M0(new e.b.a.p.d(iVarArr), true);
    }

    @NonNull
    public final Class<?> S() {
        return this.s;
    }

    @NonNull
    @CheckResult
    public T S0(boolean z) {
        if (this.v) {
            return (T) clone().S0(z);
        }
        this.z = z;
        this.a |= 1048576;
        return E0();
    }

    @NonNull
    public final e.b.a.p.c T() {
        return this.f9878l;
    }

    @NonNull
    @CheckResult
    public T T0(boolean z) {
        if (this.v) {
            return (T) clone().T0(z);
        }
        this.w = z;
        this.a |= 262144;
        return E0();
    }

    public final float U() {
        return this.b;
    }

    @Nullable
    public final Resources.Theme V() {
        return this.u;
    }

    @NonNull
    public final Map<Class<?>, e.b.a.p.i<?>> W() {
        return this.r;
    }

    public final boolean X() {
        return this.z;
    }

    public final boolean Y() {
        return this.w;
    }

    public final boolean Z() {
        return this.v;
    }

    public final boolean a0() {
        return f0(4);
    }

    public final boolean b0() {
        return this.t;
    }

    public final boolean c0() {
        return this.f9875i;
    }

    public final boolean d0() {
        return f0(8);
    }

    public boolean e0() {
        return this.y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return Float.compare(aVar.b, this.b) == 0 && this.f9872f == aVar.f9872f && n.d(this.f9871e, aVar.f9871e) && this.f9874h == aVar.f9874h && n.d(this.f9873g, aVar.f9873g) && this.p == aVar.p && n.d(this.o, aVar.o) && this.f9875i == aVar.f9875i && this.f9876j == aVar.f9876j && this.f9877k == aVar.f9877k && this.f9879m == aVar.f9879m && this.n == aVar.n && this.w == aVar.w && this.x == aVar.x && this.f9869c.equals(aVar.f9869c) && this.f9870d == aVar.f9870d && this.q.equals(aVar.q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && n.d(this.f9878l, aVar.f9878l) && n.d(this.u, aVar.u);
        }
        return false;
    }

    public final boolean h0() {
        return f0(256);
    }

    public int hashCode() {
        return n.q(this.u, n.q(this.f9878l, n.q(this.s, n.q(this.r, n.q(this.q, n.q(this.f9870d, n.q(this.f9869c, n.s(this.x, n.s(this.w, n.s(this.n, n.s(this.f9879m, n.p(this.f9877k, n.p(this.f9876j, n.s(this.f9875i, n.q(this.o, n.p(this.p, n.q(this.f9873g, n.p(this.f9874h, n.q(this.f9871e, n.p(this.f9872f, n.m(this.b)))))))))))))))))))));
    }

    public final boolean i0() {
        return this.n;
    }

    public final boolean j0() {
        return this.f9879m;
    }

    public final boolean k0() {
        return f0(2048);
    }

    @NonNull
    @CheckResult
    public T l(@NonNull a<?> aVar) {
        if (this.v) {
            return (T) clone().l(aVar);
        }
        if (g0(aVar.a, 2)) {
            this.b = aVar.b;
        }
        if (g0(aVar.a, 262144)) {
            this.w = aVar.w;
        }
        if (g0(aVar.a, 1048576)) {
            this.z = aVar.z;
        }
        if (g0(aVar.a, 4)) {
            this.f9869c = aVar.f9869c;
        }
        if (g0(aVar.a, 8)) {
            this.f9870d = aVar.f9870d;
        }
        if (g0(aVar.a, 16)) {
            this.f9871e = aVar.f9871e;
            this.f9872f = 0;
            this.a &= -33;
        }
        if (g0(aVar.a, 32)) {
            this.f9872f = aVar.f9872f;
            this.f9871e = null;
            this.a &= -17;
        }
        if (g0(aVar.a, 64)) {
            this.f9873g = aVar.f9873g;
            this.f9874h = 0;
            this.a &= -129;
        }
        if (g0(aVar.a, 128)) {
            this.f9874h = aVar.f9874h;
            this.f9873g = null;
            this.a &= -65;
        }
        if (g0(aVar.a, 256)) {
            this.f9875i = aVar.f9875i;
        }
        if (g0(aVar.a, 512)) {
            this.f9877k = aVar.f9877k;
            this.f9876j = aVar.f9876j;
        }
        if (g0(aVar.a, 1024)) {
            this.f9878l = aVar.f9878l;
        }
        if (g0(aVar.a, 4096)) {
            this.s = aVar.s;
        }
        if (g0(aVar.a, 8192)) {
            this.o = aVar.o;
            this.p = 0;
            this.a &= -16385;
        }
        if (g0(aVar.a, 16384)) {
            this.p = aVar.p;
            this.o = null;
            this.a &= -8193;
        }
        if (g0(aVar.a, 32768)) {
            this.u = aVar.u;
        }
        if (g0(aVar.a, 65536)) {
            this.n = aVar.n;
        }
        if (g0(aVar.a, 131072)) {
            this.f9879m = aVar.f9879m;
        }
        if (g0(aVar.a, 2048)) {
            this.r.putAll(aVar.r);
            this.y = aVar.y;
        }
        if (g0(aVar.a, 524288)) {
            this.x = aVar.x;
        }
        if (!this.n) {
            this.r.clear();
            int i2 = this.a & (-2049);
            this.a = i2;
            this.f9879m = false;
            this.a = i2 & (-131073);
            this.y = true;
        }
        this.a |= aVar.a;
        this.q.b(aVar.q);
        return E0();
    }

    public final boolean l0() {
        return n.w(this.f9877k, this.f9876j);
    }

    @NonNull
    public T m() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        return m0();
    }

    @NonNull
    public T m0() {
        this.t = true;
        return D0();
    }

    @NonNull
    @CheckResult
    public T n() {
        return N0(DownsampleStrategy.f1715e, new e.b.a.p.m.d.l());
    }

    @NonNull
    @CheckResult
    public T n0(boolean z) {
        if (this.v) {
            return (T) clone().n0(z);
        }
        this.x = z;
        this.a |= 524288;
        return E0();
    }

    @NonNull
    @CheckResult
    public T o() {
        return B0(DownsampleStrategy.f1714d, new m());
    }

    @NonNull
    @CheckResult
    public T o0() {
        return u0(DownsampleStrategy.f1715e, new e.b.a.p.m.d.l());
    }

    @NonNull
    @CheckResult
    public T p() {
        return N0(DownsampleStrategy.f1714d, new e.b.a.p.m.d.n());
    }

    @NonNull
    @CheckResult
    public T p0() {
        return s0(DownsampleStrategy.f1714d, new m());
    }

    @Override // 
    @CheckResult
    /* renamed from: q */
    public T clone() {
        try {
            T t = (T) super.clone();
            e.b.a.p.f fVar = new e.b.a.p.f();
            t.q = fVar;
            fVar.b(this.q);
            e.b.a.v.b bVar = new e.b.a.v.b();
            t.r = bVar;
            bVar.putAll(this.r);
            t.t = false;
            t.v = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    public T q0() {
        return u0(DownsampleStrategy.f1715e, new e.b.a.p.m.d.n());
    }

    @NonNull
    @CheckResult
    public T r(@NonNull Class<?> cls) {
        if (this.v) {
            return (T) clone().r(cls);
        }
        this.s = (Class) l.d(cls);
        this.a |= 4096;
        return E0();
    }

    @NonNull
    @CheckResult
    public T r0() {
        return s0(DownsampleStrategy.f1713c, new s());
    }

    @NonNull
    @CheckResult
    public T s() {
        return F0(o.f9767k, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public T t(@NonNull e.b.a.p.k.h hVar) {
        if (this.v) {
            return (T) clone().t(hVar);
        }
        this.f9869c = (e.b.a.p.k.h) l.d(hVar);
        this.a |= 4;
        return E0();
    }

    @NonNull
    @CheckResult
    public T t0(@NonNull e.b.a.p.i<Bitmap> iVar) {
        return M0(iVar, false);
    }

    @NonNull
    @CheckResult
    public T u() {
        return F0(e.b.a.p.m.h.i.b, Boolean.TRUE);
    }

    @NonNull
    public final T u0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull e.b.a.p.i<Bitmap> iVar) {
        if (this.v) {
            return (T) clone().u0(downsampleStrategy, iVar);
        }
        w(downsampleStrategy);
        return M0(iVar, false);
    }

    @NonNull
    @CheckResult
    public T v() {
        if (this.v) {
            return (T) clone().v();
        }
        this.r.clear();
        int i2 = this.a & (-2049);
        this.a = i2;
        this.f9879m = false;
        int i3 = i2 & (-131073);
        this.a = i3;
        this.n = false;
        this.a = i3 | 65536;
        this.y = true;
        return E0();
    }

    @NonNull
    @CheckResult
    public <Y> T v0(@NonNull Class<Y> cls, @NonNull e.b.a.p.i<Y> iVar) {
        return P0(cls, iVar, false);
    }

    @NonNull
    @CheckResult
    public T w(@NonNull DownsampleStrategy downsampleStrategy) {
        return F0(DownsampleStrategy.f1718h, l.d(downsampleStrategy));
    }

    @NonNull
    @CheckResult
    public T w0(int i2) {
        return x0(i2, i2);
    }

    @NonNull
    @CheckResult
    public T x(@NonNull Bitmap.CompressFormat compressFormat) {
        return F0(e.b.a.p.m.d.e.f9751c, l.d(compressFormat));
    }

    @NonNull
    @CheckResult
    public T x0(int i2, int i3) {
        if (this.v) {
            return (T) clone().x0(i2, i3);
        }
        this.f9877k = i2;
        this.f9876j = i3;
        this.a |= 512;
        return E0();
    }

    @NonNull
    @CheckResult
    public T y(@IntRange(from = 0, to = 100) int i2) {
        return F0(e.b.a.p.m.d.e.b, Integer.valueOf(i2));
    }

    @NonNull
    @CheckResult
    public T y0(@DrawableRes int i2) {
        if (this.v) {
            return (T) clone().y0(i2);
        }
        this.f9874h = i2;
        int i3 = this.a | 128;
        this.a = i3;
        this.f9873g = null;
        this.a = i3 & (-65);
        return E0();
    }

    @NonNull
    @CheckResult
    public T z(@DrawableRes int i2) {
        if (this.v) {
            return (T) clone().z(i2);
        }
        this.f9872f = i2;
        int i3 = this.a | 32;
        this.a = i3;
        this.f9871e = null;
        this.a = i3 & (-17);
        return E0();
    }

    @NonNull
    @CheckResult
    public T z0(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().z0(drawable);
        }
        this.f9873g = drawable;
        int i2 = this.a | 64;
        this.a = i2;
        this.f9874h = 0;
        this.a = i2 & (-129);
        return E0();
    }
}
