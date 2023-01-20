package e.b.a.v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class k {
    private Class<?> a;
    private Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f9951c;

    public k() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        b(cls, cls2, null);
    }

    public void b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.a = cls;
        this.b = cls2;
        this.f9951c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.a.equals(kVar.a) && this.b.equals(kVar.b) && n.d(this.f9951c, kVar.f9951c);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Class<?> cls = this.f9951c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }

    public k(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2);
    }

    public k(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        b(cls, cls2, cls3);
    }
}
