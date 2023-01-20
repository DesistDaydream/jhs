package e.b.a.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class d implements e.b.a.p.c {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f9938c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9939d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9940e;

    public d(@Nullable String str, long j2, int i2) {
        this.f9938c = str == null ? "" : str;
        this.f9939d = j2;
        this.f9940e = i2;
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f9939d == dVar.f9939d && this.f9940e == dVar.f9940e && this.f9938c.equals(dVar.f9938c);
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        long j2 = this.f9939d;
        return (((this.f9938c.hashCode() * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f9940e;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f9939d).putInt(this.f9940e).array());
        messageDigest.update(this.f9938c.getBytes(e.b.a.p.c.b));
    }
}
