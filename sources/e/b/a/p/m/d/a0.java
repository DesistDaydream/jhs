package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class a0 extends h {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9736d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f9737e = f9736d.getBytes(e.b.a.p.c.b);

    /* renamed from: c  reason: collision with root package name */
    private final int f9738c;

    public a0(int i2) {
        this.f9738c = i2;
    }

    @Override // e.b.a.p.m.d.h
    public Bitmap a(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return d0.n(bitmap, this.f9738c);
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        return (obj instanceof a0) && this.f9738c == ((a0) obj).f9738c;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return e.b.a.v.n.p(-950519196, e.b.a.v.n.o(this.f9738c));
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f9737e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f9738c).array());
    }
}
