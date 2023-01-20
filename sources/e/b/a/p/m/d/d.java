package e.b.a.p.m.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

@Deprecated
/* loaded from: classes.dex */
public class d implements e.b.a.p.i<BitmapDrawable> {

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.i<Drawable> f9742c;

    public d(e.b.a.p.i<Bitmap> iVar) {
        this.f9742c = (e.b.a.p.i) e.b.a.v.l.d(new q(iVar, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static e.b.a.p.k.s<BitmapDrawable> a(e.b.a.p.k.s<Drawable> sVar) {
        if (sVar.get() instanceof BitmapDrawable) {
            return sVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + sVar.get());
    }

    private static e.b.a.p.k.s<Drawable> b(e.b.a.p.k.s<BitmapDrawable> sVar) {
        return sVar;
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f9742c.equals(((d) obj).f9742c);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return this.f9742c.hashCode();
    }

    @Override // e.b.a.p.i
    @NonNull
    public e.b.a.p.k.s<BitmapDrawable> transform(@NonNull Context context, @NonNull e.b.a.p.k.s<BitmapDrawable> sVar, int i2, int i3) {
        return a(this.f9742c.transform(context, b(sVar), i2, i3));
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f9742c.updateDiskCacheKey(messageDigest);
    }
}
