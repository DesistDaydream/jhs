package e.b.a.p.m.h;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import e.b.a.p.k.s;
import e.b.a.v.l;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class f implements e.b.a.p.i<c> {

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.i<Bitmap> f9819c;

    public f(e.b.a.p.i<Bitmap> iVar) {
        this.f9819c = (e.b.a.p.i) l.d(iVar);
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f9819c.equals(((f) obj).f9819c);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return this.f9819c.hashCode();
    }

    @Override // e.b.a.p.i
    @NonNull
    public s<c> transform(@NonNull Context context, @NonNull s<c> sVar, int i2, int i3) {
        c cVar = sVar.get();
        s<Bitmap> gVar = new e.b.a.p.m.d.g(cVar.e(), e.b.a.c.e(context).h());
        s<Bitmap> transform = this.f9819c.transform(context, gVar, i2, i3);
        if (!gVar.equals(transform)) {
            gVar.recycle();
        }
        cVar.o(this.f9819c, transform.get());
        return sVar;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f9819c.updateDiskCacheKey(messageDigest);
    }
}
