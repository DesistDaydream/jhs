package e.t.r.a.l;

import android.content.res.Resources;
import android.graphics.Bitmap;
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
import e.b.a.p.i;
import e.b.a.t.h;

/* loaded from: classes3.dex */
public final class c extends h implements Cloneable {
    private static c d0;
    private static c e0;
    private static c f0;
    private static c g0;
    private static c h0;
    private static c i0;

    @NonNull
    @CheckResult
    public static c A1() {
        if (e0 == null) {
            e0 = new c().o().m();
        }
        return e0;
    }

    @NonNull
    @CheckResult
    public static c A2(@NonNull e.b.a.p.c cVar) {
        return new c().G0(cVar);
    }

    @NonNull
    @CheckResult
    public static c C1() {
        if (g0 == null) {
            g0 = new c().p().m();
        }
        return g0;
    }

    @NonNull
    @CheckResult
    public static c C2(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return new c().H0(f2);
    }

    @NonNull
    @CheckResult
    public static c E2(boolean z) {
        return new c().I0(z);
    }

    @NonNull
    @CheckResult
    public static c F1(@NonNull Class<?> cls) {
        return new c().r(cls);
    }

    @NonNull
    @CheckResult
    public static c H2(@IntRange(from = 0) int i2) {
        return new c().K0(i2);
    }

    @NonNull
    @CheckResult
    public static c I1(@NonNull e.b.a.p.k.h hVar) {
        return new c().t(hVar);
    }

    @NonNull
    @CheckResult
    public static c M1(@NonNull DownsampleStrategy downsampleStrategy) {
        return new c().w(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static c O1(@NonNull Bitmap.CompressFormat compressFormat) {
        return new c().x(compressFormat);
    }

    @NonNull
    @CheckResult
    public static c Q1(@IntRange(from = 0, to = 100) int i2) {
        return new c().y(i2);
    }

    @NonNull
    @CheckResult
    public static c T1(@DrawableRes int i2) {
        return new c().z(i2);
    }

    @NonNull
    @CheckResult
    public static c U1(@Nullable Drawable drawable) {
        return new c().A(drawable);
    }

    @NonNull
    @CheckResult
    public static c Y1() {
        if (d0 == null) {
            d0 = new c().D().m();
        }
        return d0;
    }

    @NonNull
    @CheckResult
    public static c a2(@NonNull DecodeFormat decodeFormat) {
        return new c().E(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static c c2(@IntRange(from = 0) long j2) {
        return new c().F(j2);
    }

    @NonNull
    @CheckResult
    public static c e2() {
        if (i0 == null) {
            i0 = new c().u().m();
        }
        return i0;
    }

    @NonNull
    @CheckResult
    public static c f2() {
        if (h0 == null) {
            h0 = new c().v().m();
        }
        return h0;
    }

    @NonNull
    @CheckResult
    public static <T> c h2(@NonNull e.b.a.p.e<T> eVar, @NonNull T t) {
        return new c().F0(eVar, t);
    }

    @NonNull
    @CheckResult
    public static c q2(int i2) {
        return new c().w0(i2);
    }

    @NonNull
    @CheckResult
    public static c r2(int i2, int i3) {
        return new c().x0(i2, i3);
    }

    @NonNull
    @CheckResult
    public static c u2(@DrawableRes int i2) {
        return new c().y0(i2);
    }

    @NonNull
    @CheckResult
    public static c v2(@Nullable Drawable drawable) {
        return new c().z0(drawable);
    }

    @NonNull
    @CheckResult
    public static c w1(@NonNull i<Bitmap> iVar) {
        return new c().L0(iVar);
    }

    @NonNull
    @CheckResult
    public static c x2(@NonNull Priority priority) {
        return new c().A0(priority);
    }

    @NonNull
    @CheckResult
    public static c y1() {
        if (f0 == null) {
            f0 = new c().n().m();
        }
        return f0;
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: B1 */
    public c p() {
        return (c) super.p();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: B2 */
    public c H0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (c) super.H0(f2);
    }

    @Override // e.b.a.t.a
    @CheckResult
    /* renamed from: D1 */
    public c q() {
        return (c) super.clone();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: D2 */
    public c I0(boolean z) {
        return (c) super.I0(z);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: E1 */
    public c r(@NonNull Class<?> cls) {
        return (c) super.r(cls);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: F2 */
    public c J0(@Nullable Resources.Theme theme) {
        return (c) super.J0(theme);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: G1 */
    public c s() {
        return (c) super.s();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: G2 */
    public c K0(@IntRange(from = 0) int i2) {
        return (c) super.K0(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: H1 */
    public c t(@NonNull e.b.a.p.k.h hVar) {
        return (c) super.t(hVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: I2 */
    public c L0(@NonNull i<Bitmap> iVar) {
        return (c) super.L0(iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: J1 */
    public c u() {
        return (c) super.u();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: J2 */
    public <Y> c O0(@NonNull Class<Y> cls, @NonNull i<Y> iVar) {
        return (c) super.O0(cls, iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: K1 */
    public c v() {
        return (c) super.v();
    }

    @Override // e.b.a.t.a
    @NonNull
    @SafeVarargs
    @CheckResult
    /* renamed from: K2 */
    public final c Q0(@NonNull i<Bitmap>... iVarArr) {
        return (c) super.Q0(iVarArr);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: L1 */
    public c w(@NonNull DownsampleStrategy downsampleStrategy) {
        return (c) super.w(downsampleStrategy);
    }

    @Override // e.b.a.t.a
    @NonNull
    @Deprecated
    @SafeVarargs
    @CheckResult
    /* renamed from: L2 */
    public final c R0(@NonNull i<Bitmap>... iVarArr) {
        return (c) super.R0(iVarArr);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: M2 */
    public c S0(boolean z) {
        return (c) super.S0(z);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: N1 */
    public c x(@NonNull Bitmap.CompressFormat compressFormat) {
        return (c) super.x(compressFormat);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: N2 */
    public c T0(boolean z) {
        return (c) super.T0(z);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: P1 */
    public c y(@IntRange(from = 0, to = 100) int i2) {
        return (c) super.y(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: R1 */
    public c z(@DrawableRes int i2) {
        return (c) super.z(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: S1 */
    public c A(@Nullable Drawable drawable) {
        return (c) super.A(drawable);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: V1 */
    public c B(@DrawableRes int i2) {
        return (c) super.B(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: W1 */
    public c C(@Nullable Drawable drawable) {
        return (c) super.C(drawable);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: X1 */
    public c D() {
        return (c) super.D();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: Z1 */
    public c E(@NonNull DecodeFormat decodeFormat) {
        return (c) super.E(decodeFormat);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: b2 */
    public c F(@IntRange(from = 0) long j2) {
        return (c) super.F(j2);
    }

    @Override // e.b.a.t.a
    @NonNull
    /* renamed from: d2 */
    public c m0() {
        return (c) super.m0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: g2 */
    public c n0(boolean z) {
        return (c) super.n0(z);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: i2 */
    public c o0() {
        return (c) super.o0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: j2 */
    public c p0() {
        return (c) super.p0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: k2 */
    public c q0() {
        return (c) super.q0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: l2 */
    public c r0() {
        return (c) super.r0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: m2 */
    public c t0(@NonNull i<Bitmap> iVar) {
        return (c) super.t0(iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: n2 */
    public <Y> c v0(@NonNull Class<Y> cls, @NonNull i<Y> iVar) {
        return (c) super.v0(cls, iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: o2 */
    public c w0(int i2) {
        return (c) super.w0(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: p2 */
    public c x0(int i2, int i3) {
        return (c) super.x0(i2, i3);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: s2 */
    public c y0(@DrawableRes int i2) {
        return (c) super.y0(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: t2 */
    public c z0(@Nullable Drawable drawable) {
        return (c) super.z0(drawable);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: u1 */
    public c l(@NonNull e.b.a.t.a<?> aVar) {
        return (c) super.l(aVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    /* renamed from: v1 */
    public c m() {
        return (c) super.m();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: w2 */
    public c A0(@NonNull Priority priority) {
        return (c) super.A0(priority);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: x1 */
    public c n() {
        return (c) super.n();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: y2 */
    public <Y> c F0(@NonNull e.b.a.p.e<Y> eVar, @NonNull Y y) {
        return (c) super.F0(eVar, y);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: z1 */
    public c o() {
        return (c) super.o();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: z2 */
    public c G0(@NonNull e.b.a.p.c cVar) {
        return (c) super.G0(cVar);
    }
}
