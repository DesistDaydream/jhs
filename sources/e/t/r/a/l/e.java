package e.t.r.a.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import e.b.a.j;
import e.b.a.q.l;
import e.b.a.q.q;
import e.b.a.t.g;
import e.b.a.t.h;
import java.io.File;
import java.net.URL;

/* loaded from: classes3.dex */
public class e extends j {
    public e(@NonNull e.b.a.c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
        super(cVar, lVar, qVar, context);
    }

    @Override // e.b.a.j
    public void P(@NonNull h hVar) {
        if (hVar instanceof c) {
            super.P(hVar);
        } else {
            super.P(new c().l(hVar));
        }
    }

    @Override // e.b.a.j
    @NonNull
    /* renamed from: U */
    public e d(g<Object> gVar) {
        return (e) super.d(gVar);
    }

    @Override // e.b.a.j
    @NonNull
    /* renamed from: V */
    public synchronized e i(@NonNull h hVar) {
        return (e) super.i(hVar);
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: W */
    public <ResourceType> d<ResourceType> l(@NonNull Class<ResourceType> cls) {
        return new d<>(this.a, this, cls, this.b);
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: X */
    public d<Bitmap> m() {
        return (d) super.m();
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: Y */
    public d<Drawable> n() {
        return (d) super.n();
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: Z */
    public d<File> o() {
        return (d) super.o();
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: a0 */
    public d<e.b.a.p.m.h.c> p() {
        return (d) super.p();
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: b0 */
    public d<File> s(@Nullable Object obj) {
        return (d) super.s(obj);
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: c0 */
    public d<File> t() {
        return (d) super.t();
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: d0 */
    public d<Drawable> y(@Nullable Bitmap bitmap) {
        return (d) super.g(bitmap);
    }

    @Override // e.b.a.j
    @NonNull
    @CheckResult
    /* renamed from: e0 */
    public d<Drawable> z(@Nullable Drawable drawable) {
        return (d) super.f(drawable);
    }

    @Override // e.b.a.j, e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: f0 */
    public d<Drawable> b(@Nullable Uri uri) {
        return (d) super.b(uri);
    }

    @Override // e.b.a.j, e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: g0 */
    public d<Drawable> e(@Nullable File file) {
        return (d) super.e(file);
    }

    @Override // e.b.a.j, e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: h0 */
    public d<Drawable> j(@Nullable @DrawableRes @RawRes Integer num) {
        return (d) super.j(num);
    }

    @Override // e.b.a.j, e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: i0 */
    public d<Drawable> h(@Nullable Object obj) {
        return (d) super.h(obj);
    }

    @Override // e.b.a.j, e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: j0 */
    public d<Drawable> k(@Nullable String str) {
        return (d) super.k(str);
    }

    @Override // e.b.a.j, e.b.a.h
    @CheckResult
    @Deprecated
    /* renamed from: k0 */
    public d<Drawable> a(@Nullable URL url) {
        return (d) super.a(url);
    }

    @Override // e.b.a.j, e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: l0 */
    public d<Drawable> c(@Nullable byte[] bArr) {
        return (d) super.c(bArr);
    }

    @Override // e.b.a.j
    @NonNull
    /* renamed from: m0 */
    public synchronized e N(@NonNull h hVar) {
        return (e) super.N(hVar);
    }
}
