package g.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import e.b.a.p.m.d.d0;
import java.security.MessageDigest;

@Deprecated
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    private static final int f14766c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final String f14767d = "jp.wasabeef.glide.transformations.CropCircleTransformation.1";

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        return d0.d(pool, toTransform, outWidth, outHeight);
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof e;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 1288474723;
    }

    public String toString() {
        return "CropCircleTransformation()";
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f14767d.getBytes(e.b.a.p.c.b));
    }
}
