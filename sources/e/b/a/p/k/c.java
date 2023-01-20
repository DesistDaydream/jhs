package e.b.a.p.k;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class c implements e.b.a.p.c {

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.c f9515c;

    /* renamed from: d  reason: collision with root package name */
    private final e.b.a.p.c f9516d;

    public c(e.b.a.p.c cVar, e.b.a.p.c cVar2) {
        this.f9515c = cVar;
        this.f9516d = cVar2;
    }

    public e.b.a.p.c a() {
        return this.f9515c;
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f9515c.equals(cVar.f9515c) && this.f9516d.equals(cVar.f9516d);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return (this.f9515c.hashCode() * 31) + this.f9516d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f9515c + ", signature=" + this.f9516d + '}';
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f9515c.updateDiskCacheKey(messageDigest);
        this.f9516d.updateDiskCacheKey(messageDigest);
    }
}
