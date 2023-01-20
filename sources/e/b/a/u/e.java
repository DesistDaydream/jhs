package e.b.a.u;

import androidx.annotation.NonNull;
import e.b.a.v.l;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class e implements e.b.a.p.c {

    /* renamed from: c  reason: collision with root package name */
    private final Object f9941c;

    public e(@NonNull Object obj) {
        this.f9941c = l.d(obj);
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f9941c.equals(((e) obj).f9941c);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return this.f9941c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f9941c + '}';
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f9941c.toString().getBytes(e.b.a.p.c.b));
    }
}
