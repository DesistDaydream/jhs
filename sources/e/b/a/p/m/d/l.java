package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class l extends h {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9755c = "com.bumptech.glide.load.resource.bitmap.CenterCrop";

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f9756d = f9755c.getBytes(e.b.a.p.c.b);

    @Override // e.b.a.p.m.d.h
    public Bitmap a(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return d0.b(eVar, bitmap, i2, i3);
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        return obj instanceof l;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return -599754482;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f9756d);
    }
}
