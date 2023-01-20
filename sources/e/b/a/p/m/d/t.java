package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class t extends h {

    /* renamed from: g  reason: collision with root package name */
    private static final String f9777g = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f9778h = f9777g.getBytes(e.b.a.p.c.b);

    /* renamed from: c  reason: collision with root package name */
    private final float f9779c;

    /* renamed from: d  reason: collision with root package name */
    private final float f9780d;

    /* renamed from: e  reason: collision with root package name */
    private final float f9781e;

    /* renamed from: f  reason: collision with root package name */
    private final float f9782f;

    public t(float f2, float f3, float f4, float f5) {
        this.f9779c = f2;
        this.f9780d = f3;
        this.f9781e = f4;
        this.f9782f = f5;
    }

    @Override // e.b.a.p.m.d.h
    public Bitmap a(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return d0.p(eVar, bitmap, this.f9779c, this.f9780d, this.f9781e, this.f9782f);
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            return this.f9779c == tVar.f9779c && this.f9780d == tVar.f9780d && this.f9781e == tVar.f9781e && this.f9782f == tVar.f9782f;
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return e.b.a.v.n.n(this.f9782f, e.b.a.v.n.n(this.f9781e, e.b.a.v.n.n(this.f9780d, e.b.a.v.n.p(-2013597734, e.b.a.v.n.m(this.f9779c)))));
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f9778h);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f9779c).putFloat(this.f9780d).putFloat(this.f9781e).putFloat(this.f9782f).array());
    }
}
