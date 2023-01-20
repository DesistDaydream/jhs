package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class s extends h {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9775c = "com.bumptech.glide.load.resource.bitmap.FitCenter";

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f9776d = f9775c.getBytes(e.b.a.p.c.b);

    @Override // e.b.a.p.m.d.h
    public Bitmap a(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return d0.f(eVar, bitmap, i2, i3);
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        return obj instanceof s;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return 1572326941;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f9776d);
    }
}
