package e.b.a.p.k;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class u implements e.b.a.p.c {

    /* renamed from: k  reason: collision with root package name */
    private static final e.b.a.v.i<Class<?>, byte[]> f9590k = new e.b.a.v.i<>(50);

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.k.x.b f9591c;

    /* renamed from: d  reason: collision with root package name */
    private final e.b.a.p.c f9592d;

    /* renamed from: e  reason: collision with root package name */
    private final e.b.a.p.c f9593e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9594f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9595g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f9596h;

    /* renamed from: i  reason: collision with root package name */
    private final e.b.a.p.f f9597i;

    /* renamed from: j  reason: collision with root package name */
    private final e.b.a.p.i<?> f9598j;

    public u(e.b.a.p.k.x.b bVar, e.b.a.p.c cVar, e.b.a.p.c cVar2, int i2, int i3, e.b.a.p.i<?> iVar, Class<?> cls, e.b.a.p.f fVar) {
        this.f9591c = bVar;
        this.f9592d = cVar;
        this.f9593e = cVar2;
        this.f9594f = i2;
        this.f9595g = i3;
        this.f9598j = iVar;
        this.f9596h = cls;
        this.f9597i = fVar;
    }

    private byte[] a() {
        e.b.a.v.i<Class<?>, byte[]> iVar = f9590k;
        byte[] j2 = iVar.j(this.f9596h);
        if (j2 == null) {
            byte[] bytes = this.f9596h.getName().getBytes(e.b.a.p.c.b);
            iVar.n(this.f9596h, bytes);
            return bytes;
        }
        return j2;
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f9595g == uVar.f9595g && this.f9594f == uVar.f9594f && e.b.a.v.n.d(this.f9598j, uVar.f9598j) && this.f9596h.equals(uVar.f9596h) && this.f9592d.equals(uVar.f9592d) && this.f9593e.equals(uVar.f9593e) && this.f9597i.equals(uVar.f9597i);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        int hashCode = (((((this.f9592d.hashCode() * 31) + this.f9593e.hashCode()) * 31) + this.f9594f) * 31) + this.f9595g;
        e.b.a.p.i<?> iVar = this.f9598j;
        if (iVar != null) {
            hashCode = (hashCode * 31) + iVar.hashCode();
        }
        return (((hashCode * 31) + this.f9596h.hashCode()) * 31) + this.f9597i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f9592d + ", signature=" + this.f9593e + ", width=" + this.f9594f + ", height=" + this.f9595g + ", decodedResourceClass=" + this.f9596h + ", transformation='" + this.f9598j + "', options=" + this.f9597i + '}';
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f9591c.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f9594f).putInt(this.f9595g).array();
        this.f9593e.updateDiskCacheKey(messageDigest);
        this.f9592d.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        e.b.a.p.i<?> iVar = this.f9598j;
        if (iVar != null) {
            iVar.updateDiskCacheKey(messageDigest);
        }
        this.f9597i.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f9591c.e(bArr);
    }
}
