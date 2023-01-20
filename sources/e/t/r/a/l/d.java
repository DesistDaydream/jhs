package e.t.r.a.l;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import e.b.a.i;
import e.b.a.j;
import e.b.a.k;
import e.b.a.p.k.h;
import e.b.a.t.g;
import java.io.File;
import java.net.URL;
import java.util.List;

/* loaded from: classes3.dex */
public class d<TranscodeType> extends i<TranscodeType> implements Cloneable {
    public d(@NonNull Class<TranscodeType> cls, @NonNull i<?> iVar) {
        super(cls, iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: A2 */
    public d<TranscodeType> w0(int i2) {
        return (d) super.w0(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: B2 */
    public d<TranscodeType> x0(int i2, int i3) {
        return (d) super.x0(i2, i3);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: C2 */
    public d<TranscodeType> y0(@DrawableRes int i2) {
        return (d) super.y0(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: D2 */
    public d<TranscodeType> z0(@Nullable Drawable drawable) {
        return (d) super.z0(drawable);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: E2 */
    public d<TranscodeType> A0(@NonNull Priority priority) {
        return (d) super.A0(priority);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: F2 */
    public <Y> d<TranscodeType> F0(@NonNull e.b.a.p.e<Y> eVar, @NonNull Y y) {
        return (d) super.F0(eVar, y);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: G2 */
    public d<TranscodeType> G0(@NonNull e.b.a.p.c cVar) {
        return (d) super.G0(cVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: H2 */
    public d<TranscodeType> H0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (d) super.H0(f2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: I2 */
    public d<TranscodeType> I0(boolean z) {
        return (d) super.I0(z);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: J1 */
    public d<TranscodeType> U0(@Nullable g<TranscodeType> gVar) {
        return (d) super.U0(gVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: J2 */
    public d<TranscodeType> J0(@Nullable Resources.Theme theme) {
        return (d) super.J0(theme);
    }

    @Override // e.b.a.i, e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: K1 */
    public d<TranscodeType> l(@NonNull e.b.a.t.a<?> aVar) {
        return (d) super.l(aVar);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: K2 */
    public d<TranscodeType> E1(float f2) {
        return (d) super.E1(f2);
    }

    @Override // e.b.a.t.a
    @NonNull
    /* renamed from: L1 */
    public d<TranscodeType> m() {
        return (d) super.m();
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: L2 */
    public d<TranscodeType> F1(@Nullable i<TranscodeType> iVar) {
        return (d) super.F1(iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: M1 */
    public d<TranscodeType> n() {
        return (d) super.n();
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: M2 */
    public d<TranscodeType> G1(@Nullable List<i<TranscodeType>> list) {
        return (d) super.G1(list);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: N1 */
    public d<TranscodeType> o() {
        return (d) super.o();
    }

    @Override // e.b.a.i
    @NonNull
    @SafeVarargs
    @CheckResult
    /* renamed from: N2 */
    public final d<TranscodeType> H1(@Nullable i<TranscodeType>... iVarArr) {
        return (d) super.H1(iVarArr);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: O1 */
    public d<TranscodeType> p() {
        return (d) super.p();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: O2 */
    public d<TranscodeType> K0(@IntRange(from = 0) int i2) {
        return (d) super.K0(i2);
    }

    @Override // e.b.a.i, e.b.a.t.a
    @CheckResult
    /* renamed from: P1 */
    public d<TranscodeType> q() {
        return (d) super.q();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: P2 */
    public d<TranscodeType> L0(@NonNull e.b.a.p.i<Bitmap> iVar) {
        return (d) super.L0(iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: Q1 */
    public d<TranscodeType> r(@NonNull Class<?> cls) {
        return (d) super.r(cls);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: Q2 */
    public <Y> d<TranscodeType> O0(@NonNull Class<Y> cls, @NonNull e.b.a.p.i<Y> iVar) {
        return (d) super.O0(cls, iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: R1 */
    public d<TranscodeType> s() {
        return (d) super.s();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: R2 */
    public d<TranscodeType> Q0(@NonNull e.b.a.p.i<Bitmap>... iVarArr) {
        return (d) super.Q0(iVarArr);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: S1 */
    public d<TranscodeType> t(@NonNull h hVar) {
        return (d) super.t(hVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    @Deprecated
    /* renamed from: S2 */
    public d<TranscodeType> R0(@NonNull e.b.a.p.i<Bitmap>... iVarArr) {
        return (d) super.R0(iVarArr);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: T1 */
    public d<TranscodeType> u() {
        return (d) super.u();
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: T2 */
    public d<TranscodeType> I1(@NonNull k<?, ? super TranscodeType> kVar) {
        return (d) super.I1(kVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: U1 */
    public d<TranscodeType> v() {
        return (d) super.v();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: U2 */
    public d<TranscodeType> S0(boolean z) {
        return (d) super.S0(z);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: V1 */
    public d<TranscodeType> w(@NonNull DownsampleStrategy downsampleStrategy) {
        return (d) super.w(downsampleStrategy);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: V2 */
    public d<TranscodeType> T0(boolean z) {
        return (d) super.T0(z);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: W1 */
    public d<TranscodeType> x(@NonNull Bitmap.CompressFormat compressFormat) {
        return (d) super.x(compressFormat);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: X1 */
    public d<TranscodeType> y(@IntRange(from = 0, to = 100) int i2) {
        return (d) super.y(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: Y1 */
    public d<TranscodeType> z(@DrawableRes int i2) {
        return (d) super.z(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: Z1 */
    public d<TranscodeType> A(@Nullable Drawable drawable) {
        return (d) super.A(drawable);
    }

    @Override // e.b.a.i
    @NonNull
    /* renamed from: a2 */
    public d<TranscodeType> d1(@Nullable i<TranscodeType> iVar) {
        return (d) super.d1(iVar);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: b2 */
    public d<TranscodeType> e1(Object obj) {
        return (d) super.e1(obj);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: c2 */
    public d<TranscodeType> B(@DrawableRes int i2) {
        return (d) super.B(i2);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: d2 */
    public d<TranscodeType> C(@Nullable Drawable drawable) {
        return (d) super.C(drawable);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: e2 */
    public d<TranscodeType> D() {
        return (d) super.D();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: f2 */
    public d<TranscodeType> E(@NonNull DecodeFormat decodeFormat) {
        return (d) super.E(decodeFormat);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: g2 */
    public d<TranscodeType> F(@IntRange(from = 0) long j2) {
        return (d) super.F(j2);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: h2 */
    public d<File> f1() {
        return new d(File.class, this).l(i.j0);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: i2 */
    public d<TranscodeType> o1(@Nullable g<TranscodeType> gVar) {
        return (d) super.o1(gVar);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: j2 */
    public d<TranscodeType> p1(@Nullable Bitmap bitmap) {
        return (d) super.g(bitmap);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: k2 */
    public d<TranscodeType> q1(@Nullable Drawable drawable) {
        return (d) super.f(drawable);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: l2 */
    public d<TranscodeType> r1(@Nullable Uri uri) {
        return (d) super.b(uri);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: m2 */
    public d<TranscodeType> s1(@Nullable File file) {
        return (d) super.e(file);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: n2 */
    public d<TranscodeType> t1(@Nullable @DrawableRes @RawRes Integer num) {
        return (d) super.j(num);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: o2 */
    public d<TranscodeType> u1(@Nullable Object obj) {
        return (d) super.h(obj);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: p2 */
    public d<TranscodeType> v1(@Nullable String str) {
        return (d) super.k(str);
    }

    @Override // e.b.a.i
    @CheckResult
    @Deprecated
    /* renamed from: q2 */
    public d<TranscodeType> w1(@Nullable URL url) {
        return (d) super.a(url);
    }

    @Override // e.b.a.i
    @NonNull
    @CheckResult
    /* renamed from: r2 */
    public d<TranscodeType> x1(@Nullable byte[] bArr) {
        return (d) super.c(bArr);
    }

    @Override // e.b.a.t.a
    @NonNull
    /* renamed from: s2 */
    public d<TranscodeType> m0() {
        return (d) super.m0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: t2 */
    public d<TranscodeType> n0(boolean z) {
        return (d) super.n0(z);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: u2 */
    public d<TranscodeType> o0() {
        return (d) super.o0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: v2 */
    public d<TranscodeType> p0() {
        return (d) super.p0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: w2 */
    public d<TranscodeType> q0() {
        return (d) super.q0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: x2 */
    public d<TranscodeType> r0() {
        return (d) super.r0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: y2 */
    public d<TranscodeType> t0(@NonNull e.b.a.p.i<Bitmap> iVar) {
        return (d) super.t0(iVar);
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: z2 */
    public <Y> d<TranscodeType> v0(@NonNull Class<Y> cls, @NonNull e.b.a.p.i<Y> iVar) {
        return (d) super.v0(cls, iVar);
    }

    public d(@NonNull e.b.a.c cVar, @NonNull j jVar, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(cVar, jVar, cls, context);
    }
}
