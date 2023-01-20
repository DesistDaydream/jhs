package e.b.a.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class f implements c {

    /* renamed from: c  reason: collision with root package name */
    private final ArrayMap<e<?>, Object> f9447c = new e.b.a.v.b();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void d(@NonNull e<T> eVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        eVar.update(obj, messageDigest);
    }

    @Nullable
    public <T> T a(@NonNull e<T> eVar) {
        return this.f9447c.containsKey(eVar) ? (T) this.f9447c.get(eVar) : eVar.d();
    }

    public void b(@NonNull f fVar) {
        this.f9447c.putAll((SimpleArrayMap<? extends e<?>, ? extends Object>) fVar.f9447c);
    }

    @NonNull
    public <T> f c(@NonNull e<T> eVar, @NonNull T t) {
        this.f9447c.put(eVar, t);
        return this;
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f9447c.equals(((f) obj).f9447c);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return this.f9447c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f9447c + '}';
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f9447c.size(); i2++) {
            d(this.f9447c.keyAt(i2), this.f9447c.valueAt(i2), messageDigest);
        }
    }
}
