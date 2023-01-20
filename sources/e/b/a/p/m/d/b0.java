package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class b0 extends h {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9739d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f9740e = f9739d.getBytes(e.b.a.p.c.b);

    /* renamed from: c  reason: collision with root package name */
    private final int f9741c;

    public b0(int i2) {
        e.b.a.v.l.a(i2 > 0, "roundingRadius must be greater than 0.");
        this.f9741c = i2;
    }

    @Override // e.b.a.p.m.d.h
    public Bitmap a(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return d0.q(eVar, bitmap, this.f9741c);
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        return (obj instanceof b0) && this.f9741c == ((b0) obj).f9741c;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return e.b.a.v.n.p(-569625254, e.b.a.v.n.o(this.f9741c));
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f9740e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f9741c).array());
    }
}
