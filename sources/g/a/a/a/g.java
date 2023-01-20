package g.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import e.b.a.p.m.d.d0;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: d  reason: collision with root package name */
    private static final int f14772d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final String f14773e = "jp.wasabeef.glide.transformations.CropSquareTransformation.1";

    /* renamed from: c  reason: collision with root package name */
    private int f14774c;

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int max = Math.max(outWidth, outHeight);
        this.f14774c = max;
        return d0.b(pool, toTransform, max, max);
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return (o instanceof g) && ((g) o).f14774c == this.f14774c;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return (-789843280) + (this.f14774c * 10);
    }

    public String toString() {
        return "CropSquareTransformation(size=" + this.f14774c + ")";
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14773e + this.f14774c).getBytes(e.b.a.p.c.b));
    }
}
