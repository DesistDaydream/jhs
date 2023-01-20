package e.b.a.p.m.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class q implements e.b.a.p.i<Drawable> {

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.i<Bitmap> f9773c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9774d;

    public q(e.b.a.p.i<Bitmap> iVar, boolean z) {
        this.f9773c = iVar;
        this.f9774d = z;
    }

    private e.b.a.p.k.s<Drawable> b(Context context, e.b.a.p.k.s<Bitmap> sVar) {
        return x.d(context.getResources(), sVar);
    }

    public e.b.a.p.i<BitmapDrawable> a() {
        return this;
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof q) {
            return this.f9773c.equals(((q) obj).f9773c);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return this.f9773c.hashCode();
    }

    @Override // e.b.a.p.i
    @NonNull
    public e.b.a.p.k.s<Drawable> transform(@NonNull Context context, @NonNull e.b.a.p.k.s<Drawable> sVar, int i2, int i3) {
        e.b.a.p.k.x.e h2 = e.b.a.c.e(context).h();
        Drawable drawable = sVar.get();
        e.b.a.p.k.s<Bitmap> a = p.a(h2, drawable, i2, i3);
        if (a == null) {
            if (this.f9774d) {
                throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            }
            return sVar;
        }
        e.b.a.p.k.s<Bitmap> transform = this.f9773c.transform(context, a, i2, i3);
        if (transform.equals(a)) {
            transform.recycle();
            return sVar;
        }
        return b(context, transform);
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f9773c.updateDiskCacheKey(messageDigest);
    }
}
